import User.*;
import University.*;
  
/**
 * @author zvetter001
 * @version 3/15/18
 */
public class TextDriver {
  
  Account activeAccount;
  Admin admin;
  User user;
  
  /**
   * @param args
   */
  public static void main(String [] args) {
    /*TODO
     * X Log in with User Account
     * X View Profile
     * X Edit Profile
     * X Search Schools******************
     * X View Results
     * X View School Information
     * Display similar recommendations
     * X Add School to profile
     * X View Saved Schools
     * X Remove Schools
     * X Log out
     * 
     * X Log in as Admin
     * X View Universities
     * X Add new school
     * X Save school
     * X Edit school
     * X View Users
     * X Add new user
     * X Deactivate user
     * X Edit user

     */
    AccountInteractions accountInteractions = new AccountInteractions();
    AdminInteractions adminInteractions = new AdminInteractions();
    UserInteraction userInteractions = new UserInteraction();
    University university = new University();
    AdminController adminController = new AdminController();
    Account account;
   
    
    System.out.println("Logging in with invalid user credentials of U - ERROR, P - ERROR:");
    account = accountInteractions.logOn("ERROR", "ERROR");
    System.out.println("\n\n*******************************************************\n\n");
    
    System.out.println("Logging in with valid user credentials:");
    account = accountInteractions.logOn("juser", "user");
    System.out.println("User account log on status: "+account.isLoggedOn());
    System.out.println("**View Profile**");
    userInteractions.viewProfile(account.getUsername());
    System.out.println("Edit Profile: Change name to Alexis Neas");
    userInteractions.editProfile(account.getUsername(), account.getPassword(), "Alexis", "Neas", account.getAccountType(), account.getStatus());
    userInteractions.viewProfile(account.getUsername());

    System.out.println("Search schools: University of Minnesota and View Results");
    userInteractions.searchSchool("!", "CALI","!" ,"!",//SchoolName, State, location,Control
                                  0, 10000,//NumStudents
                                  -2,-2,//%Female
                                  -2,-2,//SATVerbal
                                  -2,-2,//SATMath
                                  -2,-2,//Expenses
                                  -2,-2,//PercentEnrolled
                                  -2,-2,//AcademicsScale
                                  -2,-2,//Social
                                  -2,-2,//Academics
                                  "", "","", "","");  

    System.out.println("View School Information: University of Minnesota");
    userInteractions.viewSchoolInfo("UNIVERSITY OF MINNESOTA");
    System.out.println("Display Similar Schools:");
    userInteractions.displaySimilarSchools("UNIVERSITY OF MINNESOTA");
    

    
    userInteractions.addSchool("University of Minnesota", account.getUsername());
    System.out.println("Saved universities:");
    userInteractions.getSavedUniversities(account.getUsername());
    System.out.println("Removing school: ");
    userInteractions.remove("University of Minnesota",account.getUsername());
    accountInteractions.logOff(account);
    System.out.println("User account log on status: "+account.isLoggedOn());
    
    
    
    
    
    System.out.println("\n\n*******************************************************\n\n");
    System.out.println("Logging in with valid admin credentials:");
    account = accountInteractions.logOn("nadmin", "admin");

    
    adminInteractions.getListOfUsers();
    adminInteractions.addNewUser("Trevor", "Wensman","trevor", "password", 'u');

    adminInteractions.getListOfUsers();
    adminInteractions.getUserInfo("trevor");
    System.out.println("Deactivating user");
    adminInteractions.deactivateUser("trevor");
    adminInteractions.getUserInfo("trevor");
    
    System.out.println("Editting User.");
    adminInteractions.editUser("ROVERT", "Wensman", "trevor", "password", 'u', 'N');
    adminInteractions.getUserInfo("trevor");
    
    
    System.out.println("Adding a new school.");
    adminInteractions.addSchool("Temp School", "Minnesota", "Urban", "State", 10, 50, 50, 50, 50000.00, 99,12, 100.0, 10, 3, 3, 3);
    System.out.println("Added School..... Verifying School is there.");
    adminInteractions.getSchoolInfo("Temp School");
    
    System.out.println("Edit school: Temp School");
    adminInteractions.editSchool("Temp School", university.getState(), university.getLocation(), university.getControl(),
                                 university.getNumStudents(), 100, university.getSatVerbal(), university.getSatMath(),
                                 university.getTuition(), university.getPercentRecFinAid(), university.getNumApplicants(), university.getPercentAccepted(),
                                 university.getPercentEnroll(), university.getAcademicScale(), university.getSocial(), university.getQualOfLife(),
                                 university.getStudyArea1(),  university.getStudyArea2(),  university.getStudyArea3(),  university.getStudyArea4(),
                                 university.getStudyArea5()); 
    adminInteractions.getSchoolInfo("Temp School"); 
     }

}















