package User;
import java.util.ArrayList;

import University.*;
import DatabaseController.*;

/**
 * Class that allows a user to interact with CMC and initializes the User Controller
 * 
 * @author Alexis Neas
 * @version 3/20/18
 * 
 */
public class UserInteraction {
  private UserController userController;
  
  /**
   * Constructor of User Interaction 
   */
  public UserInteraction()
  {
    this.userController = new UserController();
  }
  
  /**
   * Displays the list of similar schools
   * 
   * @param schoolName the school that the schools should be similar to
   */
  public void displaySimilarSchools(String schoolName)
  {
    University mainSchool = userController.getSchoolInfo(schoolName);
    
    ArrayList<University> universities = userController.findSimilarSchools(mainSchool);
    
     if(universities == null)
       System.out.println("Error: No Similar Schools");
     else 
     {
       for(University u : universities)
       {
        System.out.println(u.getSchoolName()); 
       }
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
    System.out.println("\tSchool has been removed");
   else
     System.out.println("\tError: School was not removed");
  }
  
  /**
   * Gets the information about the selected school
   * 
   * @param school the name of the school that's information is being retrieved
   * 
   */
  public void viewSchoolInfo(String school)
  {
    University u = userController.getSchoolInfo(school);
    System.out.println("Name: " + u.getSchoolName()+"\nState: " +
         u.getState()+"\nLocation: " + u.getLocation()+"\nControl: " + u.getControl()+"\nStudy Area 1: " + u.getStudyArea1()+
         "\nStudy Area 2: " + u.getStudyArea2()+"\nStudy Area 3: " + u.getStudyArea3()+"\nStudy Area 4: " 
         + u.getStudyArea4()+"\nStudy Area 5: " + u.getStudyArea5()+"\nNumber of Applications: " +
         u.getNumApplicants() + "\nNumber of Students: " + u.getNumStudents() + "\nAcademic Scale: " +
         u.getAcademicScale()+ "\nQuality of Life: " + u.getQualOfLife()+ "\nFemales %: " + 
         u.getPercentFemale() + "%\nSAT Verbal: " + u.getSatVerbal() + "\nSAT Math: " + u.getSatMath() + "\nTuition: " + u.getTuition() +
         "\nReceiving Financial Aid: " + u.getPercentRecFinAid()+ "%" + "\nAccepted: " + u.getPercentAccepted() + "\nEnrolled: " + u.getPercentEnroll() + "% " +"\nSocial Rating: "+
         u.getSocial() + "\n");

  } 
  
  /**
   * Adds a school to the user's list of saved schools
   * 
   * @param school school to be added to user's list
   * @param username the username that the school should be saved to
   */
  public void addSchool(String school, String username)
  {
   userController.addSchool(username, school); 
   System.out.println("School has been added.");
  }
  
  /**
   * Takes a list of search criteria inputed by user, and displays a list of Universities
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
   * @oaram emphases1 one of the emphases of the university
   * @oaram emphases2 one of the emphases of the university
   * @oaram emphases3 one of the emphases of the university
   * @oaram emphases4 one of the emphases of the university
   * @oaram emphases5 one of the emphases of the university
   * 
   */
  public void searchSchool(String schoolName, String stateName, String location, String control,
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
    ArrayList<University> universities = userController.searchSchool(schoolName, stateName, location, control, lowNumberOfStudents, upNumberOfStudents,
                                lowPercentFemale, upPercentFemale, lowSATVerbal, upSATVerbal, lowSATMath, upSATMath,
                                lowExpenses, upExpenses, lowPercentEnrolled, upPercentEnrolled, lowAcademicsScale, upAcademicsScale,
                                lowSocialScale,upSocialScale, lowQualityOfLifeScale, upQualityOfLifeScale, emphases1, emphases2,
                                emphases3, emphases4, emphases5);
    for (int i = 0; i<universities.size();i++)
    {
     System.out.println(universities.get(i).getSchoolName()); 
    }
  }  
  

  
  /**
   * Will allow the user to view their saved Universities
   * 
   * @param username the username of the account to view saved universities
   */
  public void getSavedUniversities(String username)
  {
    ArrayList<String> universities = userController.getSavedUniversities(username);
    
    for (String u: universities)
    {
     System.out.println("\t"+u); 
    }
  }
  
  /**
   * Edits the user's profile and saves changes
   * 
   * @param username the user's username
   * @param password the user's password
   * @param firstName the user's first name
   * @param lastName the user's last name
   * @param type the type of account
   * @param status the status of the account
   * 
   */
  public void editProfile(String username, String password, String firstName, String lastName, char type, char status)
  {
    userController.editProfile( username,  password,  firstName,  lastName,  type,  status);
    System.out.println("Changes have been saved");
    
  }
  /**
   * Allows the user to view their profile
   * 
   * @param username the user's username
   */
  public void viewProfile(String username)
  {
    Account info = userController.viewProfile(username);
    System.out.println("\tFirst name: "+info.getFirstName()+"\n\tLast name: "+info.getLastName()+"\n\tUsername: "
                         +info.getUsername()+"\n\tPassword: "+info.getPassword()+"\n\tAccount type: "+info.getAccountType());
  }
}
