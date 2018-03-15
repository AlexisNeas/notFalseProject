package User;
import java.util.ArrayList;
import java.util.List;

import DatabaseController.DBController;
import University.University;
/**
 * Class that controls the user interactions, and interacts with the database
 * 
 * @author Alexis Neas
 * @version 1
 */

public class UserController {
 private DBController dbController;
 private User user;
 private AccountController accountController;
  /**
   * Takes a list of search criteria inputed by user, and returns a list of Universities
   * in an order of relevance
   * 
   * @param university the university criteria being searched for 
   */
  public String[][] searchSchool(University university) {

     return dbController.search(university);
  }
  
  /**
   * Removes a school from a user's list of saved schools
   * 
   * @param school the name of university to be removed
   * @param user the user that the university is being removed from
   * 
   * @return returns a boolean to indicate the university has been removed
   */
  
  public boolean removeSchool(String university, String user)
  {
    return dbController.removeSchool(university, user);
  }
  
  /**
   * Gets the information for the selected school
   * 
   * @param school the name of the school that is to be removed
   * 
   * @return returns a University containing all of the information
   */
  public ArrayList<String> getSchoolInfo(String school)
  {
     return dbController.getSchoolInfo(school); 
  }
  
  /**
   * Adds a school to the user's list of saved schools
   * 
   * @param school school to be added to user's list
   */
  public void addSchool(String school, String user)
  {
   dbController.userSaveSchool(school, user); 
  }
  
  /**
   * Find similar schools to the one selected
   * 
   * @param school the school that should be compared to
   */
  public String[][] findSimilarSchools(University school)
  {
   return dbController.findSimilarSchools(school); 
  }
  
  /**
   * Displays the results of a search
   * 
   * @param schools list of schools that should be displayed
   */
  public void displayResults(List schools)
  {
    
  }
  
  /**
   * Allows the user to manage and display the profile
   */
  public void manageProfile()
  {
   
  }
  
  /**
   * Gets a list of user's saved universities
   * 
   * @return the list of schools that have been saved by user
   */
  public ArrayList<String> getSavedUniversities(String username)
  {
   return dbController.getUserSchools(username); 
  }
  
  /**
   * Will allow the user to view the saved Universities
   */
//  public void viewSavedUniversities()
//  {
//    for (University u : getSavedUniversities())
//      System.out.println(u);
//  }
  
  /**
   * Displays an error message if there are no schools saved
   */
  public void noSchoolError()
  {
   System.out.println("Sorry, you haven't saved any schools"); 
  }
  
  /**
   * Edits the user's profile and saves changes
   * 
   * @param first the user's first name
   * @param last the user's last name
   * @param password the user's password
   * 
   * @return returns true if the profile has been successfully saved
   */
  public void editProfile(String username, String password, String firstName, String lastName, char type, char status)
  {
   accountController.editAccount(  username,  password,  firstName,  lastName,  type,  status);
  }
  
  /**
   * Displays an error message if there was no search criteria entered
   */
  public void noCriteriaMessage()
  {
    System.out.println("You must provide search criteria");
  }
  
  /**
   * Gets the options for the users to select
   */
  public void getUserOptions()
  {
    
  }
  
}

  
  