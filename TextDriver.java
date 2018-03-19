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
     * Search Schools
     * View Results
     * View School Information
     * Display similar recommendations
     * X Add School to profile
     * X View Saved Schools
     * X Remove Schools
     * X Log out
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
    userInteractions.viewProfile(account.getUsername());
    
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
    
    System.out.println("View Profile");
    //userInteraction.
     }

}















