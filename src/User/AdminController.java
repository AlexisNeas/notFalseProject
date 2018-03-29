package User;
import University.*;
import java.util.ArrayList;
import java.util.List;
import DatabaseController.DBController;

/**
 * Provides the the logic for admin functionalities.
 * 
 * @author Zachary Vetter
 * @version 3/20/18
 */
public class AdminController {
  
  /**
   * Provides access to admin objects
   */
  private Admin admin;
  
  /**
   * Interacts with the database controller to access the data
   */
  private DBController dbController;
  
  /**
   * Interacts with the account controller
   */
  private AccountController accountController;
  
  /**
   * Constructor to access the database and initialize the account controller
   */
  public AdminController() {
    this.dbController = new DBController("notfal", "csci230");
    this.accountController = new AccountController();
  }

/**
   * Gets all the users in the system
   * 
   * @return an array list containing all the users
   */
  public ArrayList<Account> getListOfUsers(){
    return dbController.getListOfUsers();
  }
  
  /**
   * Gets all the universities in the system
   * 
   * @return a list of the universities
   */
  public ArrayList<String> viewUniversities(){
    return dbController.getListOfSchools();
  }
  
  /**
   * Gets a schools info
   * 
   * @param name the name of the school to get info for
   * 
   * @return a University object that contains the schools info
   */
  public University getSchoolInformation(String name){
    University univ = dbController.getSchoolInfo(name);
    return univ;
    
  }
  
  /**
   * Adds a new user or admin to the system
   * 
   * @param user to be added
   */
  public void addNewUser(User user){
    dbController.addNewUser(user);
  }
  
  /**
   * Adds a new school to the system
   * 
   * @param school to be added
   */
  public void addSchool(University school) {
    
    dbController.addNewSchool(school);
  }
  
  /**
   * Edits a schools informations
   * 
   * @param school a University object with the updated school information
   */
  public void setSchoolInfo(University school) {
    
    dbController.setSchoolInformation(school);
    
  }
  
  /**
   * Edits a user
   * 
   * @param firstName
   * @param lastName
   * @param username
   * @param password
   * @param type
   * @param status
   */
  public void editUser(String firstName, String lastName, String username, String password, char type, char status){
    dbController.setUserInfo(firstName, lastName, username, password, type, status);
  }
  
  /**
   * Changes a user's status to deactivated
   * 
   * @param username the username of the account being deactivated
   */
  public void deactivateUser(String username){
    dbController.deactivateUser(username);
  }
  
  /**
   * Gets the info on a user
   * 
   * @param username the unique username of the user
   * @return the user
   */
  public Account getUserInfo(String username)
  {
    return dbController.getUserInfo(username);
  }
}