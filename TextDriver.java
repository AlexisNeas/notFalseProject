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
     * X Search Schools
     * X View Results
     * X View School Information
     * X Display similar recommendations
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
   
    System.out.println(" ~~ TEST: Log on with invalid username and password ~~");
    System.out.println("Logging in with invalid user credentials of U - ERROR, P - ERROR:");
    account = accountInteractions.logOn("ERROR", "ERROR");
    
    System.out.println("\n ~~ TEST: Deactivated Account log in ~~");
    adminInteractions.deactivateUser("juser");
    account = accountInteractions.logOn("juser", "user");
    
    adminInteractions.editUser("Juser", "User", "juser", "user", 'u', 'Y');
    adminInteractions.editUser("Trevor", "Wensman", "trevor", "password", 'u', 'Y');
    adminInteractions.editSchool("Temp School", university.getState(), university.getLocation(), university.getControl(),
                                 university.getNumStudents(), 25, university.getSatVerbal(), university.getSatMath(),
                                 university.getTuition(), university.getPercentRecFinAid(), university.getNumApplicants(), university.getPercentAccepted(),
                                 university.getPercentEnroll(), university.getAcademicScale(), university.getSocial(), university.getQualOfLife(),
                                 university.getStudyArea1(),  university.getStudyArea2(),  university.getStudyArea3(),  university.getStudyArea4(),
                                 university.getStudyArea5()); 
    
    
    System.out.println("\n\n*******************************************************\n\n");
    
    System.out.println("**********************************************");
    System.out.println("************ User Functionalities ************");
    System.out.println("**********************************************");
    System.out.println("\n\n");
    
    System.out.println("*** Logging in with valid user credentials: ***");
    System.out.println(" -- Username: juser   Password: user --");
    account = accountInteractions.logOn("juser", "user");
    System.out.println("User account log on status: "+account.isLoggedOn());
    
    System.out.println("\n\n*** View Profile ***");
    userInteractions.viewProfile(account.getUsername());
    
    System.out.println("\n\n*** Edit Profile: Change name to Alexis Neas ***");
    userInteractions.editProfile("Alexis", "Neas", account.getUsername(), account.getPassword(), account.getAccountType(), account.getStatus());
    System.out.println("\n -- Check to ensure the account name is changed --");
    userInteractions.viewProfile(account.getUsername());

    System.out.println("\n\n*** Search schools and View Search Results: Schools in California ***");
    userInteractions.searchSchool("!", "CALIFORNIA","!" ,"!",//SchoolName, State, location,Control
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

    System.out.println("\n\n*** View School Information: University of Minnesota ***");
    userInteractions.viewSchoolInfo("UNIVERSITY OF MINNESOTA");
    System.out.println("\n*** Display Top 5 Schools Similar to University of Minnesota ***");
    userInteractions.displaySimilarSchools("UNIVERSITY OF MINNESOTA");
    
    System.out.println("\n\n*** Add school to User's saved universities: ***");
    System.out.println("Original List of Saved Schools");
    userInteractions.getSavedUniversities(account.getUsername());
    System.out.println("\nAdding University of Minnesota to current user account");
    userInteractions.addSchool("University of Minnesota", account.getUsername());
    System.out.println("\n -- Updated List of Saved Universities: --");
    userInteractions.getSavedUniversities(account.getUsername());
    System.out.println("\n*** Removing school from User's List of Schools: *** ");
    userInteractions.remove("University of Minnesota",account.getUsername());
    System.out.println("\n -- Display Saved Universities: --");
    userInteractions.getSavedUniversities(account.getUsername());
    System.out.println("\n\n *** Log Off ***");
    accountInteractions.logOff(account);
    System.out.println("User account log on status: "+account.isLoggedOn());
    
   
    System.out.println("\n\n\n***********************************************");
    System.out.println("************ Admin Functionalities ************");
    System.out.println("***********************************************");
    System.out.println("\n\n");
    
    System.out.println("*** Logging in with valid admin credentials: ***");
    System.out.println("Username: nadmin   Password: admin");
    account = accountInteractions.logOn("nadmin", "admin");

    System.out.println("\n\n*** Get List of Accounts ***");
    adminInteractions.getListOfUsers();
    System.out.println("\n*** Add New Account ***");
    adminInteractions.addNewUser("Trevor", "Wensman","trevor", "password", 'u');
    System.out.println("Display updated list of users");
    adminInteractions.getListOfUsers();
    
    System.out.println("\n\n*** Get information for specific account ***");
    adminInteractions.getUserInfo("trevor");
    
    System.out.println("\n\n*** Deactivate user ***");
    System.out.println("Original Account information");
    adminInteractions.getUserInfo("trevor");
    adminInteractions.deactivateUser("trevor");
    System.out.println("\n -- Get updated user information --");
    adminInteractions.getUserInfo("trevor");
    
    System.out.println("\n\n*** Edit Account Information ***");
    System.out.println("Original account information");
    adminInteractions.getUserInfo("trevor");
    System.out.println("\nChanging first name to ROVERT");
    adminInteractions.editUser("ROVERT", "Wensman", "trevor", "password", 'u', 'N');
    System.out.println("\n -- Get updated user information --");
    adminInteractions.getUserInfo("trevor");
    
    System.out.println("\n\n*** Viewing list of schools currently in system ***");
    adminInteractions.viewUniversities();
    System.out.println("\n\n*** Adding a new school called Temp School: ***");
    System.out.println("NOTE: The school much be change each time you run Driver");
    adminInteractions.addSchool("Temp School", "Minnesota", "Urban", "State", 10, 50, 50, 50, 50000.00, 99,12, 100.0, 10, 3, 3, 3);
    System.out.println("\n -- Added School..... Verifying School is there --");
    adminInteractions.getSchoolInfo("Temp School");
    
    System.out.println("\n\n*** Edit school: Temp School ***");
    System.out.println(" -- Current school info --");
    adminInteractions.getSchoolInfo("Temp School"); 
    adminInteractions.editSchool("Temp School", university.getState(), university.getLocation(), university.getControl(),
                                 university.getNumStudents(), 100, university.getSatVerbal(), university.getSatMath(),
                                 university.getTuition(), university.getPercentRecFinAid(), university.getNumApplicants(), university.getPercentAccepted(),
                                 university.getPercentEnroll(), university.getAcademicScale(), university.getSocial(), university.getQualOfLife(),
                                 university.getStudyArea1(),  university.getStudyArea2(),  university.getStudyArea3(),  university.getStudyArea4(),
                                 university.getStudyArea5()); 
    System.out.println("\n -- Get updated school information --");
    adminInteractions.getSchoolInfo("Temp School"); 
    
    System.out.println("\n\n *** Log Off ***");
    accountInteractions.logOff(account);
    System.out.println("Admin account log on status: "+account.isLoggedOn());
     }

}















