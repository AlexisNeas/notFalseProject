import java.util.*;
/**
 * Provides the logic for the User class 
 * author: Jess Hansen
 * date: 2/27/2018
 */


public class User extends Account {
  private boolean loggedIn;
  private String firstName, lastName, username, password;
  private char accountType, status;
 
  public User(boolean loggedIn, String firstName, String lastName, String username, String password, char accountType, char status){
    this.loggedIn = loggedIn;
    this.firstName =firstName;
    this.lastName = lastName;
    this.username = username; 
    this.password = password;
    this.accountType = accountType;
    this.status = status;
  }
 
  /**
   * returns a list of all the user's saved universities
   * @return array list of university name strings
   */
//  public ArrayList<String> getSavedUniversityNames(){
// 
//    //dbController.getUserSchools();
//    
//  }
//  
//  public User makeNewUser(String firstName, String lastName, String username, String password){
//    //dbController.addNewUser(firstName, lastName,username,password);
//    
//  }
  
  
  
}