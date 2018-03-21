package User;
import java.util.ArrayList;

import University.*;
import DatabaseController.*;

/**
 * Abstract class that allows a user to interact with CMC
 * 
 * @author Alexis Neas
 * @version 1
 * 
 */
public class UserInteraction {
  private UserController userController;
  public UserInteraction()
  {
    this.userController = new UserController();
  }
  
  /**
   * Displays the list of similar schools
   * 
   * @param school the school that the schools should be similar to
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
   * Gets the information for the selected school
   * 
   * @param school the name of the school that is to be removed
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
   */
  public void addSchool(String school, String username)
  {
   userController.addSchool(username, school); 
   System.out.println("School has been added.");
  }
  
/**
   * Takes a list of search criteria inputed by user, and returns a list of Universities
   * in an order of relevance
   * 
   * @param university the university criteria being searched for
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
   * Will allow the user to view the saved Universities
   * 
   * @param username the username of the account to view universities
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
   * @param first the user's first name
   * @param last the user's last name
   * @param password the user's password
   * 
   */
  public void editProfile(String username, String password, String firstName, String lastName, char type, char status)
  {
    userController.editProfile( username,  password,  firstName,  lastName,  type,  status);
    System.out.println("Changes have been saved");
    
  }
  
  public void viewProfile(String username)
  {
    Account info = userController.viewProfile(username);
    System.out.println("\tFirst name: "+info.getFirstName()+"\n\tLast name: "+info.getLastName()+"\n\tUsername: "
                         +info.getUsername()+"\n\tPassword: "+info.getPassword()+"\n\tAccount type: "+info.getAccountType());
  }
}
