package User;
import java.util.*;
/**
 * Abstract class that allows a user to interact with CMC
 * 
 * @author Alexis Neas
 * @version 1
 * 
 */
public class UserInteraction {
  private UserController userController;
  /**
   * Displays the list of similar schools
   * 
   * @param school the school that the schools should be similar to
   */
  public void displaySimilarSchools(University school)
  {
    String[][] schools = userController.findSimilarSchools(school);
    
    for ( int i = 0; i<schools[i].length; i++)
    {
      System.out.println(schools[i][0]);
    }
  }
  
/**
   * Removes a school from a user's list of saved schools
   * 
   * @param school the name of university to be removed
   * @param user the user that the university is being removed from
   *
   */
  public void remove(String school, String user)
  {
    boolean removed = userController.removeSchool(school, user);
   if( removed )
    System.out.println("School has been removed");
   else
     System.out.println("Error: School was not removed");
  }
  
  /**
   * Gets the information for the selected school
   * 
   * @param school the name of the school that is to be removed
   * 
   */
  public void viewSchoolInfo(String school)
  {
    ArrayList<String> arrayList = userController.getSchoolInfo(school);
    
  }
  
  /**
   * Adds a school to the user's list of saved schools
   * 
   * @param school school to be added to user's list
   */
  public void addSchool(String school, String username)
  {
   userController.addSchool(school, username); 
  }
  
  /**
   * Removes add button from the school
   * 
   * @param school the school that can no longer be added
   */
  public void removeAddButton(String school)
  {
    
  }
  
/**
   * Takes a list of search criteria inputed by user, and returns a list of Universities
   * in an order of relevance
   * 
   * @param university the university criteria being searched for
   */
  public String[][] searchSchool(University university) {
   return userController.searchSchool( university);
  }  
  
  /**
   * Displays the school list
   *
   */
  public void displaySchoolList()
  {
    
  }
  
  /**
   * Displays the results
   */
  public void displayResults()
  {}
  
  /**
   * Allows the user to manage and display the profile
   */
  public void manageProfile()
  {
   
  }
  
  /**
   * Will allow the user to view the saved Universities
   */
//  public void viewSavedUniversities()
//  {
//  userController.viewSavedUniversities();
//  }
  
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
    userController.editProfile( username,  password,  firstName,  lastName,  type,  status);
  }
}
