package User;
import java.util.*;
import DatabaseController.*;
import University.*;

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
 
 public UserController()
 {
   this.dbController = new DBController("notfal", "csci230");
   this.accountController = new AccountController();
 }
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
   * @return the university objects closest to the search
   */
  public ArrayList <University> searchSchool(String schoolName, String stateName, String location, String control,
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

     return dbController.search(schoolName, stateName, location, control, lowNumberOfStudents, upNumberOfStudents,
                                lowPercentFemale, upPercentFemale, lowSATVerbal, upSATVerbal, lowSATMath, upSATMath,
                                lowExpenses, upExpenses, lowPercentEnrolled, upPercentEnrolled, lowAcademicsScale, upAcademicsScale,
                                lowSocialScale,upSocialScale, lowQualityOfLifeScale, upQualityOfLifeScale, emphases1, emphases2,
                                emphases3, emphases4, emphases5);
                               
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
  public University getSchoolInfo(String school)
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
   * 
   * @return list of similar schools
   */
  public ArrayList<University> findSimilarSchools(University university)
  {
   return dbController.findSimilarSchools(university); 
  }
  
  /**
   * Displays the results of a search
   * 
   * @param schools list of schools that should be displayed
   */
  public void displayResults(ArrayList<University> universities)
  {
    if (universities == null)
      System.out.println("No universities to display");
    else
    for( University u:universities)
    {
      System.out.println("University: "+ u.getSchoolName()); 
    }
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
   * Edits the user's profile and saves changes
   * 
   * @param first the user's first name
   * @param last the user's last name
   * @param password the user's password
   * 
   * @return returns true if the profile has been successfully saved
   */
  public void editProfile(String firstName, String lastName, String username, String password, char type, char status)
  {
   dbController.setUserInfo(  firstName, lastName, username,  password,  type,  status);
  }
  /**
   * 
   * 
   * 
   * @param username
   * @return account an account object with the users information.
   */
  public Account viewProfile(String username)
  {
    Account acct = dbController.getUserInfo(username);
    return acct;
  }
  
}

  
  