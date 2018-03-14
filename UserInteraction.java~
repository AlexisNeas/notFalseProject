import java.util.*;
/**
 * Abstract class that allows a user to interact with CMC
 * 
 * @author Alexis Neas
 * @version 1
 * 
 */
public abstract class UserInteraction {
  private UserController userController;
  /**
   * Displays the list of similar schools
   * 
   * @param school the school that the schools should be similar to
   */
  public void displaySimilarSchools(String schoolName, String stateName, String location, String control,
                                       int numberOfStudents,  double percentFemale, 
                                       double SATVerbal, double SATMath, double expenses, double percentEnrolled, 
                                       int academicsScale, int socialScale, int qualityOfLifeScale, String emphases1,
                                       String emphases2, String emphases3, String emphases4, String emphases5)
  {
    String[][] schools = userController.findSimilarSchools( schoolName,  stateName,  location,  control,
                                        numberOfStudents,   percentFemale, 
                                        SATVerbal,  SATMath,  expenses,  percentEnrolled, 
                                        academicsScale,  socialScale,  qualityOfLifeScale,  emphases1,
                                        emphases2,  emphases3,  emphases4,  emphases5);
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
   return userController.searchSchool( schoolName,  stateName,  location,  control,
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
