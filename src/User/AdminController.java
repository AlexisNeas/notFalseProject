package User;
import University.*;
import java.util.ArrayList;
import DatabaseController.DBController;

/**
 * Provides the the logic for admin functionalities.
 * 
 * @author Zachary Vetter
 * @version 3/20/18
 */
public class AdminController {
  
  /**
   * Interacts with the database controller to access the data
   */
  private DBController dbController;
  
  /**
   * Constructor to access the database and initialize the account controller
   */
  public AdminController() {
    this.dbController = new DBController("notfal", "csci230");
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
  public void addNewUser(Account user){
    try {
	  dbController.addNewUser(user);
    }
    catch(IllegalArgumentException e){
    	System.out.println("Username is already taken");
    }
  }
  
  /**
   * Adds a new school to the system
   * 
   * @param school to be added
   */
  public void addSchool(University school) {
    try {
    	dbController.addNewSchool(school);
    }
    catch(IllegalArgumentException e) {
    	System.out.println("The school name is already taken");
    }
  }
  
  /**
   * Edits a schools informations
   * 
   * @param school a University object with the updated school information
   */
  public void setSchoolInfo(University school) {
    try {
    	dbController.setSchoolInformation(school);
    }
    catch(IllegalArgumentException e) {
    	System.out.println("The school does not exist");
    }
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
  public void editUser(Account account){
	  try {
		  dbController.setUserInfo(account.getFirstName(), account.getLastName(),
				  account.getUsername(), account.getPassword(), account.getAccountType(),
				  account.getStatus());
	  }
	  catch(IllegalArgumentException e) {
		  System.out.println("The account does not exist.");
	  }
  }
  
  /**
   * Changes a user's status to deactivated
   * 
   * @param username the username of the account being deactivated
   */
  public void deactivateUser(String username){
    try {
	  dbController.deactivateUser(username);
    }
    catch(IllegalArgumentException e) {
	  System.out.println("The account does not exist.");
    }
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