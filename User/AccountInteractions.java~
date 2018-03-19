package User;
/**
 * Provides a class that directly interacts with user and
 * calls methods from the Account Controller
 * author: Jess Hansen
 * date: 2/27/2018
 */

public class AccountInteractions {
 
  private AccountController aController;
  
  
  public AccountInteractions() {
   this.aController = new AccountController();
  }
  /**
   * Checks if the user's credentials are valid and either
   * logs them in or supplies them with an error message to try again
   * @return boolean value regarding if the sign in was successful or not
   */
  public void logOn(String username, String password){
    
    Account user = aController.logOn(username,password);
    if(user == null)
    {
      System.out.println("Invalid username or password");
    }
    else if(!user.isLoggedOn())
    {
      System.out.println("Invalid username or password");
    }
    else if(user.getStatus() == 'N')
    {
      System.out.println("Account has been deactivated");
    }
    else
    {
      if(user instanceof User)
        System.out.println("The user account is now logged on");
      else
        System.out.println("The admin account is now logged on");
    }
  }
  
  /**
   * If the user is logged on, the user is able to log off using this method 
   * @return boolean value whether they successfully log off or not
   */
  public void logOff(){
    
    aController.logOff();
  }
   
  
  
  
 

}