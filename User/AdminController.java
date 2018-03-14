import java.util.*;

/**
 * Provides the the logic for admin functionalities.
 * 
 * @author Zachary Vetter
 * @version 2/24/18
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
   * Gets all the users in the system
   * 
   * @return a list containing all the users
   */
  public String[][] getListOfUsers(){
    return dbController.getListOfUsers();
  }
  
  /**
   * Gets all the universities and lists them off
   * 
   * @return a list of the universities
   */
  public List viewUniversities(){
    return dbController.getListOfSchools();
  }
  
  /**
   * Gets a schools info
   * 
   * @param name the name of the school to get info for
   */
  public ArrayList<String> getSchoolInformation(String name){
    return dbController.getSchoolInfo(name);
  }
  
  /**
   * Adds a new user or admin to the system
   * 
   * @param firstName
   * @param lastName
   * @param username
   * @param password
   * @param type
   */
  public void addNewUser(String firstName, String lastName, String username, String password, char type){
    dbController.addNewUser(firstName, lastName, username, password, type);
  }
  
  /**
   * Adds a new school
   * 
   * @param name the name of the school
   * @param state
   * @param loc the city location
   * @param control who owns the school
   * @param numStudents number of students
   * @param perFem percent of female students
   * @param satVerbal the average verbal SAT score
   * @param satMath the average math SAT score
   * @param tuition cost of tuition
   * @param perFinancialAid the percent of students receiving financial aid
   * @param numApplicants number of people who apply to the school
   * @param perAccepted the percent of applicants who get accepted
   * @param perEnroll precent of people who actually enroll
   * @param academicScale the academic scale of the school
   * @param social the scale of social life
   * @param qualOfLife scale of the quality of life of students
   * @param studyArea1 area the school specializes in
   * @param studyArea2
   * @param studyArea3
   * @param studyArea4
   * @param studyArea5
   */
  public void addSchool(String name, String state, String loc, String control, int numStudents, double perFem,
                         int satVerbal, int satMath, double tuition, double perFinancialAid, int numApplicants,
                         double perAccepted, double perEnroll, int academicScale, int social, int qualOfLife,
                         String studyArea1, String studyArea2, String studyArea3, String studyArea4, String studyArea5) {
    
    
    dbController.addNewSchool(name, state, loc, control, numStudents, perFem,
                           satVerbal, satMath, tuition, perFinancialAid, numApplicants,
                           perAccepted, perEnroll, academicScale, social, qualOfLife);
  }
  
   /**
   * Edits a schools informations
   * 
   * @param name the name of the school
   * @param state
   * @param loc the city location
   * @param control who owns the school
   * @param numStudents number of students
   * @param perFem percent of female students
   * @param satVerbal the average verbal SAT score
   * @param satMath the average math SAT score
   * @param tuition cost of tuition
   * @param perFinancialAid the percent of students receiving financial aid
   * @param numApplicants number of people who apply to the school
   * @param perAccepted the percent of applicants who get accepted
   * @param perEnroll precent of people who actually enroll
   * @param academicScale the academic scale of the school
   * @param social the scale of social life
   * @param qualOfLife scale of the quality of life of students
   * @param studyArea1 area the school specializes in
   * @param studyArea2
   * @param studyArea3
   * @param studyArea4
   * @param studyArea5
   */
  public void setSchoolInfo(String name, String state, String loc, String control, int numStudents, double perFem,
                         int satVerbal, int satMath, double tuition, double perFinancialAid, int numApplicants,
                         double perAccepted, double perEnroll, int academicScale, int social, int qualOfLife,
                         String studyArea1, String studyArea2, String studyArea3, String studyArea4, String studyArea5) {
    
    
    dbController.setSchoolInformation(name, state, loc, control, numStudents, perFem,
                               satVerbal, satMath, tuition, perFinancialAid, numApplicants,
                               perAccepted, perEnroll, academicScale, social, qualOfLife);
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
  public ArrayList<String> getUserInfo(String username)
  {
    return dbController.getUserInfo(username);
  }
}