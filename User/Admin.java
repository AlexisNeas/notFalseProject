package User;

/**
 * Provides the logic for the Admin class 
 * author: Jess Hansen
 * date: 3/20/2018
 */
public class Admin extends Account
{
  /**
   * First name of the admin
   */
  private String firstName; 
  /**
   * Last name of the admin
   */
  private String lastName;
  /**
   * username of the admin
   */
  private String username;
  /**
   * Admin's password
   */
  private String password;
  /**
   * Clarifies the account is an admin's
   */
  private char accountType;
  /**
   * Clarifies whether the account is active or not
   */
  private char status;
 
  /**
   * Basic constructor for creating an Admin object
   * @param loggedIn is a boolean to determine whether the admin is logged in or not
   * @param firstName is the first name of the admin
   * @param userName is the userName of the admin
   * @param password is the new password of the admin
   * @param accountType indicates whether the account is an admin or user
   * @param status indicates whether the admin has an active acount or not
   */
  public Admin(String firstName, String lastName, String username, String password, char accountType, char status){
    super(firstName,lastName,username,password,accountType,status);
  }
}