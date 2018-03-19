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

    
    adminInteractions.getListOfUsers();
    adminInteractions.addNewUser("Trevor", "Wensman","trevor", "password", 'u');
    adminInteractions.getListOfUsers();

    
  }

}















