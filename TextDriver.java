import User.*;
  
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
     * Edit Profile
     * Search Schools******************
     * View Results
     * View School Information
<<<<<<< HEAD
     * Display similar recommendations *************8
     * Add School to profile
     * View Saved Schools
     * Remove Schools
     * Log out
=======
     * Display similar recommendations
     * X Add School to profile
     * X View Saved Schools
     * X Remove Schools
     * X Log out
>>>>>>> 5e1f0e6fe7743f3e82e02a286e892d203c852696
     * 
     * X Log in as Admin
     * View Universities
     * Add new school
     * Save school
     * Edit school
     * View Users
     * Add new user
     * Deactivate user
     * Edit user
     */
    AccountInteractions accountInteractions = new AccountInteractions();
    AdminInteractions adminInteractions = new AdminInteractions();
    UserInteraction userInteractions = new UserInteraction();
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
//    System.out.println("Search schools: University of Minnesota and View Results");
//    userInteractions.searchSchool("", "MINNESOTA","" ,"",
//                                  null, 40000,
//                                  null,null,
//                                  null,null,
//                                  null,null,
//                                  null,null,
//                                  null,null,
//                                  null, null,
//                                  null,null,
//                                  "", "","", "","");  
    System.out.println("View School Information: University of Minnesota");
    userInteractions.viewSchoolInfo("UNIVERSITY OF MINNESOTA");
    System.out.println("Display Similar Schools:");
    
                                
    
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
     }

}















