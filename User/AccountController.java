package User;
import DatabaseController.*;
import java.util.ArrayList;

import DatabaseController.DBController;
/**
 * Provides the logic for the Account Controller class 
 * author: Jess Hansen
 * date: 3/20/2018
 */
public class AccountController {
  /**
   * Instance of the DBController class
   */
  private DBController dbController;
  
  /**
   * Constructor for the AccountController class
   * Initializes the DBController
   */
  public AccountController(){
    this.dbController = new DBController("notfal", "csci230");
  }
  
  /**
   * Checks if the user's credentials are valid or not and logs them in
   * @param username is the username of the account trying to log on
   * @param password of the user trying to log on
   * @return Account of the account being logged in
   */
  public Account logOn(String username, String password){
    Account user = dbController.getUserInfo(username);
    if(user == null)
      return user;
    else if(user != null && password.equals(user.getPassword()))
    {
      if(user.getAccountType() == 'u')
      {
        user = new User(user.getFirstName(), user.getLastName(), user.getUsername(),
                               user.getPassword(), user.getAccountType(), user.getStatus());
        user.logOn();
        return user;
      }
      else
      {
        user =  new Admin(user.getFirstName(), user.getLastName(), user.getUsername(),
                               user.getPassword(), user.getAccountType(), user.getStatus());
        user.logOn();
        return user;
      }
    }
    else
    {
      return user;
    }
  }
  
 // public void displayOptions(){}
  
  /**
   * If the user is logged on, 
   * the user is able to log off using this method 
   * @param account of the user being logged off
   */
  public void logOff(Account account){
    account.logOff();
    
  }
  
  /**
   * This allows the user to recover their password if they forgot it.
   * They enter their username and are able to retrieve.
   * @return String of the user's password
   */
//  public Account getPassword(){
//  //  Scanner in = new Scanner(System.in);
//   // System.out.println("Enter your username: ");
//    //String user = in.nextLine();
//    Account userInfo = dbController.getUserInfo(user);
//    return userInfo;
//  }
  

  
  /**
   * Checks if a specific user has an active accountor not
   * displays an error message if their account is not active
//   */
//
//  public boolean getActive() {
//   char ch = account.getStatus();
//   if(ch == 'Y'){
//     return true;
//   }
//   //search through list of info for active/nonactive char
//   //if statement confirming whether the user has an active or inactive account
//   //displays an error if the account is inactive
//  else {
//    return false;
//   //Account doesn't exist
//     
//  }
//  }
  

  
  
}