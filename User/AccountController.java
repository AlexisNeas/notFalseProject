package User;
import DatabaseController;
/**

 * Provides the logic for the Account Controller class 
 * author: Jess Hansen
 * date: 2/27/2018
 */
import java.util.*;

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
  public boolean logOn(String username, String password){

    Scanner keyboard = new Scanner(System.in);
    
    System.out.println("Enter username here: ");
    String inpUser = keyboard.nextLine();
    System.out.println("Enter password here: ");
    String inpPass = keyboard.nextLine(); 
   
    if (dbController.findUser(inpUser)) {
        //System.out.print("User found and logged in.");
        return true;
    } else {
       // System.out.print("User was not found.");
      displayError();
      return false;
      
    }
    
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
  public ArrayList<String> getPassword(){
    Scanner in = new Scanner(System.in);
    System.out.println("Enter your username: ");
    String user = in.nextLine();
    ArrayList<String> userInfo = dbController.getUserInfo(user);
    return userInfo;
  }
  
  /**
   * Allows the user to edit their account by being able 
   * to change their credentials
   * @param username of the account that wants to edit their account
   */
  public void editAccount(String username){
    
    if(dbController.findUser(username))
    {
      ArrayList<String> userInfo = dbController.getUserInfo(username);
      dbController.setUserInfo(username,password,firstName,  lastName,  type,  status);
    }
    else{
     displayError(); 
    }
    
    
  }
  
  /**
   * Shows an error message if the user gave incorrect credentials
   */
  public void displayError(){
    
    System.out.println("Error, try again.");
    
  }
  
  /**
   * Checks if a specific user has an active accountor not
   * displays an error message if their account is not active
   */
  public void getActive(String user) {
	  
  if(findUser(user))
  {
	  ArrayList<String> info = getUserInfo(user);
	  //search through list of info for active/nonactive char
	  //if statement confirming whether the user has an active or inactive account
	  //displays an error if the account is inactive
  }
  else {
	  //Account doesn't exist
	  displayError();
  }
  }
  
  /**
   * Displays an error message if the account that is trying to log on 
   * is active or not.
   */
  public void deactivatedAccountError() {
	  System.out.println("Sorry, your account is curently deactivated.");
  }
  
  
}