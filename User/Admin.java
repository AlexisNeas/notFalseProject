package User;

/**
 * Provides the logic for the Admin class 
 * author: Jess Hansen
 * date: 2/27/2018
 */
public class Admin
{
  private boolean loggedIn;
  private String firstName, lastName, username, password;
  private char accountType, status;
 
  /**
   * Basic constructor for creating an Admin object
   * @param loggedIn is a boolean to determine whether the admin is logged in or not
   * @param firstName is the first name of the admin
   * @param userName is the userName of the admin
   * @param password is the new password of the admin
   * @param accountType indicates whether the account is an admin or user
   * @param status indicates whether the admin has an active acount or not
   */
  public Admin(boolean loggedIn, String firstName, String lastName, String username, String password, char accountType, char status){
    this.loggedIn = loggedIn;
    this.firstName =firstName;
    this.lastName = lastName;
    this.username = username; 
    this.password = password;
    this.accountType = accountType;
    this.status = status;
  }
}