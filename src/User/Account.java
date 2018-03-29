package src.User;
/**
 * Account entity super class to User and Admin. 
 * 
 * @author Zachary Vetter
 * @version 3/20/18
 */
public class Account {
  
  /**
   * Says if this account is logged in or not
   */
  private boolean loggedIn;
  
  /**
   * The account's first name
   */
  private String firstName;
  
  /**
   * The account's last name
   */
  private String lastName;
  
  /**
   * Account username
   */
  private String username;
  
  /**
   * Password for the account
   */
  private String password;
  
  /**
   * Account type designating user or admin
   */
  private char accountType;
  
  /**
   * Status of active or deactivated
   */
  private char status;
  
  
  
  /**
   * Account constructor
   * 
   * @param firstName
   * @param lastName
   * @param username
   * @param password
   * @param accountType
   * @param status
   */
  public Account(String firstName, String lastName, String username, String password, char accountType,
                 char status) {
    
    this.firstName = firstName;
    this.lastName = lastName;
    this.username = username;
    this.password = password;
    this.accountType = accountType;
    this.status = status;
  }

  /**
   * Gets the account's first name
   * 
   * @return first name
   */
  public String getFirstName(){
    return firstName;
  }
  
  /**
   * Gets the account's last name
   * 
   * @return last name
   */
  public String getLastName(){
    return lastName;
  }
  
  /**
   * Gets the account username
   * 
   * @return username
   */
  public String getUsername(){
    return username;
  }
  
  /**
   * Gets the account password
   * 
   * @return password
   */
  public String getPassword(){
    return password;
  }
  
  /**
   * Gets the account type of user or admin
   * 
   * @return account type
   */
  public char getAccountType(){
    return accountType;
  }
  
  /**
   * Returns whether or not the account is active or not
   * 
   * @return account status
   */
  public char getStatus(){
    return status;
  }
  
  /**
   * Sets the first name for the person's account
   * 
   * @param name the new first name
   */
  public void setFirstName(String name){
    this.firstName = name;
  }
  
  /**
   * Sets the new last name for the person's account
   * 
   * @param name the new last name
   */
  public void setLastName(String name){
    this.lastName = name;
  }
  
  /**
   * Sets the account username
   * 
   * @param uname the new username
   */
  public void setUsername(String uname){
    this.username = uname;
  }
  
  /**
   * Sets the account password
   * 
   * @param pass the new password
   */
  public void setPassword(String pass){
    this.password = pass;
  }
  
  /**
   * Sets the account type to user or admin
   * 
   * @param type the account type
   */
  public void setAccountType(char type){
    this.accountType = type;
  }
  
  /**
   * Sets the status of the account to acctive or inactive
   * 
   * @param stat the new status of the account
   */
  public void setStatus(char stat){
    this.status = stat;
  }
  
  /**
   * Logs the account on
   */
  public void logOn(){
    this.loggedIn = true;
  }
  
  /**
   * Logs the account off
   */
  public void logOff(){
    this.loggedIn = false;
  }
  
  /**
   * Checks to see if the account is currently logged on
   * 
   * @return a boolean with the value true if the account is logged on
   */
  public boolean isLoggedOn(){
    return this.loggedIn;
  }
}