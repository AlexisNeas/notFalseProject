/**
 * Provides the admin with functionalities.
 * 
 * @author Zachary Vetter
 * @version 2/24/18
 */
public class AdminInteractions {
  
  /**
   * Admin Controller object that actually has the logic for the admin methods.
   */
  private AdminController adminController;
  
  
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
  public void editSchool(String name, String state, String loc, String control, int numStudents, double perFem,
                         int satVerbal, int satMath, double tuition, double perFinancialAid, int numApplicants,
                         double perAccepted, double perEnroll, int academicScale, int social, int qualOfLife,
                         String studyArea1, String studyArea2, String studyArea3, String studyArea4, String studyArea5) {
    
    
    adminController.setSchoolInfo(name, state, loc, control, numStudents, perFem,
                                  satVerbal, satMath, tuition, perFinancialAid, numApplicants,
                                  perAccepted, perEnroll, academicScale, social, qualOfLife,
                                  studyArea1, studyArea2, studyArea3, studyArea4, studyArea5);
  }
  
  /**
   * Shows a schools information
   * 
   * @param schoolName the name of school to get info for
   */
  public void schoolInfo(String schoolName) {
    adminController.getSchoolInformation(schoolName);
  }
  
  /**
   * Gets all the users in the system
   */
  public void getListOfUsers(){
    adminController.getListOfUsers();
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
    adminController.addNewUser(firstName, lastName, username, password, type);
  }
  
  /**
   * Gets a users info
   * 
   * @param username the username of the user to get info for
   */
  public void getUserInfo(String username){
    adminController.getUserInfo(username);
  }
  
  /**
   * Gets a schools info
   * 
   * @param name the name of the school to get info for
   */
  public void getSchoolInfo(String name){
    adminController.getSchoolInformation(name);
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
    
    
    adminController.addSchool(name, state, loc, control, numStudents, perFem,
                              satVerbal, satMath, tuition, perFinancialAid, numApplicants,
                              perAccepted, perEnroll, academicScale, social, qualOfLife,
                              studyArea1, studyArea2, studyArea3, studyArea4, studyArea5);
  }
  
  /**
   * Edits a user
   * 
   * @param firstName
   * @param lastName
   * @param username
   * @param password
   * @param type
   */
  public void editUser(String firstName, String lastName, String username, String password, char type, char status){
    adminController.editUser(firstName, lastName, username, password, type, status);
  }
  
  /**
   * Gets all the universities and lists them off
   */
  public void viewUniversities(){
    adminController.viewUniversities();
  }
  
  /**
   * Changes a user's status to deactivated
   */
  public void deactivateUser(String username){
    adminController.deactivateUser(username);
  }
}