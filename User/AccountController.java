package User;
import DatabaseController.*;



/**

 * Provides the logic for the Account Controller class 
 * author: Jess Hansen
 * date: 2/27/2018
 */
import java.util.ArrayList;
import java.util.Scanner;

import DatabaseController.DBController;

public class AccountController {
  
  
  private String password, user;
  private DBController dbController;
  private Account account;
  
  /**
   * Checks if the user's credentials are valid and either
   * logs them in or supplies them with an error message to try again
   * @param username is the username of the account trying to log on
   * @param password of the user trying to log on
   * @return boolean value regarding if the sign in was successful or not
   */
  public void logOn(String username, String password){
      User user = dbController.getUserInfo(username);
      if(user != null || password.equals(user.getPassword()))
           {
        account.logOn();
      }
     return user;
    
  }
  
 // public void displayOptions(){}
  
  /**
   * If the user is logged on, 
   * the user is able to log off using this method 
   */
  public void logOff(){
    account.logOff();
    
  }
  
  /**
   * This allows the user to recover their password if they forgot it.
   * They enter their username and are able to retrieve.
   * @return String of the user's password
   */
  public User getPassword(){
  //  Scanner in = new Scanner(System.in);
   // System.out.println("Enter your username: ");
    //String user = in.nextLine();
    User userInfo = dbController.getUserInfo(user);
    return userInfo;
  }
  

  
  /**
   * Checks if a specific user has an active accountor not
   * displays an error message if their account is not active
   */

  public boolean getActive() {
   char ch = account.getStatus();
   if(ch == 'Y'){
     return true;
   }
   //search through list of info for active/nonactive char
   //if statement confirming whether the user has an active or inactive account
   //displays an error if the account is inactive
  else {
    return false;
   //Account doesn't exist
     
  }
  }
  

  
  
}