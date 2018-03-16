package User;



import java.util.ArrayList;
import java.util.List;

import DatabaseController.DBController;
import University.University;

/**
 * Class that controls the user interactions, and interacts with the database
 * 
 * @author Alexis Neas
 * @version 3
 */

public class UserController {
 private DBController dbController;
 private User user;
 private University university;
 private AccountController accountController;
  /**
   * Takes a list of search criteria inputed by user, and returns a list of Universities
   * in an order of relevance
   * 
   * @param schoolName Name of the school to search for.
   * @param stateName Name of the state for schools.
   * @param location Location area of a school.
   * @param control Private State or City control.
   * @param lowNumberOfStudents Lower limit for student population.
   * @param upNumberOfStudents Upper limit for student population.
   * @param lowPercentFemale Lower limit for Percent Female.
   * @param upPercentFemale Upper limit for Percent Female.
   * @param lowSATVerbal Lower limit for SATVerbal.
   * @param upSATVerbal Upper limit for SATVerbal.
   * @param lowSATMath Lower limit for SATMath.
   * @param upSATMath Upper limit for SATMath.
   * @param lowExpenses Lower limit for Expenses.
   * @param upExpenses Upper limit for Expenses.
   * @param lowPercentEnrolled Lower limit for Percent Enrolled.
   * @param upPercentEnrolled Upper limit for Percent Enrolled.
   * @param lowAcademicsScale Lower limit for Academics Scale.
   * @param upAcademicsScale Upper limit for Academics Scale.
   * @param lowSocialScale Lower limit for Social Scale.
   * @param upSocialScale Upper limit for Social Scale.
   * @param lowQualityOfLifeScale Lower limit for Quality Of Life Scale.
   * @param upQualityOfLifeScale Upper limit for Quality Of Life Scale.
   * 
   * @return the university object closest to the search
   */
  public University searchSchool(String schoolName, String stateName, String location, String control,
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
   * @param user the name of user saving the school
   * @param school school to be added to user's list
   */
  public void addSchool(String user, String school)
  {
   dbController.userSaveSchool(user, school); 
  }
  
  /**
   * Find similar schools to the one selected
   * 
   * @param schoolName Name of the school to search for.
   * @param stateName Name of the state for schools.
   * @param location Location area of a school.
   * @param control Private State or City control.
   * @param lowNumberOfStudents Lower limit for student population.
   * @param upNumberOfStudents Upper limit for student population.
   * @param lowPercentFemale Lower limit for Percent Female.
   * @param upPercentFemale Upper limit for Percent Female.
   * @param lowSATVerbal Lower limit for SATVerbal.
   * @param upSATVerbal Upper limit for SATVerbal.
   * @param lowSATMath Lower limit for SATMath.
   * @param upSATMath Upper limit for SATMath.
   * @param lowExpenses Lower limit for Expenses.
   * @param upExpenses Upper limit for Expenses.
   * @param lowPercentEnrolled Lower limit for Percent Enrolled.
   * @param upPercentEnrolled Upper limit for Percent Enrolled.
   * @param lowAcademicsScale Lower limit for Academics Scale.
   * @param upAcademicsScale Upper limit for Academics Scale.
   * @param lowSocialScale Lower limit for Social Scale.
   * @param upSocialScale Upper limit for Social Scale.
   * @param lowQualityOfLifeScale Lower limit for Quality Of Life Scale.
   * @param upQualityOfLifeScale Upper limit for Quality Of Life Scale.
   */
  public University findSimilarSchools(University school)
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
   dbController.setUserInfo(  username,  password,  firstName,  lastName,  type,  status);
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

  
  