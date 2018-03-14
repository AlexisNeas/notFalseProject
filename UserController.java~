import java.util.*;
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
   * @param criteria the search criteria 
   */
  public String[][] searchSchool(String schoolName, String stateName, String location, String control,
                           int lowNumberOfStudents, int upNumberOfStudents,  
                           double lowPercentFemale, double upPercentFemale, 
                           double lowSATVerbal, double upSATVerbal,
                           double lowSATMath, double upSATMath,
                           double lowExpenses, double upExpenses,
                           double lowPercentEnrolled, double upPercentEnrolled,
                           int lowAcademicsScale, int upAcademicsScale,
                           int lowSocialScale, int upSocialScale,
                           int lowQualityOfLifeScale, int upQualityOfLifeScale,
                           String emphases1,String emphases2,String emphases3,
                           String emphases4,String emphases5) {

     return dbController.search( schoolName,  stateName,  location,  control,
                            lowNumberOfStudents,  upNumberOfStudents,  
                            lowPercentFemale,  upPercentFemale, 
                            lowSATVerbal,  upSATVerbal,
                            lowSATMath,  upSATMath,
                            lowExpenses,  upExpenses,
                            lowPercentEnrolled,  upPercentEnrolled,
                            lowAcademicsScale,  upAcademicsScale,
                            lowSocialScale,  upSocialScale,
                            lowQualityOfLifeScale,  upQualityOfLifeScale,
                            emphases1, emphases2, emphases3,
                            emphases4, emphases5);
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
  public boolean addSchool(String school, String user)
  {
   return dbController.addSchoolToUserList(school, user); 
  }
  
  /**
   * Find similar schools to the one selected
   * 
   * @param school the school that should be compared to
   */
  public String[][] findSimilarSchools(String schoolName, String stateName, String location, String control,
                                       int numberOfStudents,  double percentFemale, 
                                       double SATVerbal, double SATMath, double expenses, double percentEnrolled, 
                                       int academicsScale, int socialScale, int qualityOfLifeScale, String emphases1,
                                       String emphases2, String emphases3, String emphases4, String emphases5)
  {
   return dbController.findSimilarSchools( schoolName,  stateName,  location,  control,
                                        numberOfStudents,   percentFemale, 
                                        SATVerbal,  SATMath,  expenses,  percentEnrolled, 
                                        academicsScale,  socialScale,  qualityOfLifeScale,  emphases1,
                                        emphases2,  emphases3,  emphases4,  emphases5); 
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

  
  