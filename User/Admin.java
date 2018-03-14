package User;
import java.util.*;
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