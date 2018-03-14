/**
 * Account entity
 * 
 * @author Zachary Vetter
 * @version 2/25/18
 */
public abstract class Account {
  
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
}