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
     * View Profile
     * Edit Profile
     * Search Schools
     * View Results
     * View School Information
     * Display similar recommendations
     * Add School to profile
     * View Saved Schools
     * Remove Schools
     * Log out
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
    
    System.out.println("Logging in with invalid user credentials:");
    account = accountInteractions.logOn("ERROR", "ERROR");
    
    System.out.println("Logging in with valid user credentials:");
    account = accountInteractions.logOn("juser", "user");
    userInteractions.viewProfile(account.getUsername());
    
    
    System.out.println("Logging in with valid admin credentials:");
    account = accountInteractions.logOn("nadmin", "admin");

    System.out.println("List of all users in the Database.");
    adminInteractions.getListOfUsers();
    System.out.println("Adding a new user to the system");
    adminInteractions.addNewUser("Trevor", "Wensman","trevor", "password", 'u');
    System.out.println("Printing updated list of users");
    adminInteractions.getListOfUsers();

    
    System.out.println("Deactivating user");
    adminInteractions.deactivateUser("trevor");
    adminInteractions.getUserInfo("trevor");
    
    System.out.println("Editting User.");
    adminInteractions.editUser("Trevor", "Wensman", "rovert", "password", 'u', 'N');
    adminInteractions.getUserInfo("rovert");
    
    
    System.out.println("Adding a new school.");
    adminInteractions.addSchool("Temp School", "Minnesota", "Urban", "State", 10, 50, 50, 50, 50000.00, 99,12, 100.0, 10, 3, 3, 3);
    System.out.println("Added School..... Verifying School is there.");
    adminInteractions.getSchoolInfo("Temp School");

    


    
    System.out.println("View Profile");
    //userInteraction.
     }

}















