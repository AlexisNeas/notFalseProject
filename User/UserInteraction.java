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
    System.out.println("\tName: " + u.getSchoolName()+"\n\tState: " +
                       u.getState()+"\n\tLocation: " + u.getLocation()+"\n\tControl: " + u.getControl()+ "\n\tNumber of Students: " +
                       u.getNumStudents()+ "\n\t% Female: "+ u.getPercentFemale() + "\n\tSAT Verbal: " + u.getSatVerbal() + 
                       "\n\tSAT Math: " + u.getSatMath()+ "\n\tTuition: " + u.getTuition()+ "\n\t% Receiving Financial Aid: " + 
                       u.getPercentRecFinAid()+"\n\tNumber of Applications: " + u.getNumApplicants()+ "\n\t% Accepted: " + 
                       u.getPercentAccepted()+ "\n\t% Enrolled: " + u.getPercentEnroll()  + "\n\tAcademic Scale: " +
                       u.getAcademicScale() +"\n\tSocial Rating: "+ u.getSocial()+ "\n\tQuality of Life: " + u.getQualOfLife() +
                       "\n\tStudy Area 1: " + u.getStudyArea1()+"\n\tStudy Area 2: " + u.getStudyArea2()+"\n\tStudy Area 3: " + 
                       u.getStudyArea3()+"\n\tStudy Area 4: "  + u.getStudyArea4()+"\n\tStudy Area 5: " + u.getStudyArea5());

  } 
  
  /**
   * Adds a school to the user's list of saved schools
   * 
   * @param school school to be added to user's list
   */
  public void addSchool(String school, String username)
  {
   userController.addSchool(username, school); 
   System.out.println("\tSchool has been added.");
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
    if(universities.size() == 0)
      System.out.println("\tNo saved universities");
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
  public void editProfile(String firstName, String lastName, String username, String password, char type, char status)
  {
    userController.editProfile(firstName,  lastName,   username,  password,  type,  status);
    System.out.println("Changes have been saved");
    
  }
  
  public void viewProfile(String username)
  {
    Account info = userController.viewProfile(username);
    System.out.println("\tFirst name: "+info.getFirstName()+"\n\tLast name: "+info.getLastName()+"\n\tUsername: "
                         +info.getUsername()+"\n\tPassword: "+info.getPassword()+"\n\tAccount type: "+info.getAccountType());
  }
}
