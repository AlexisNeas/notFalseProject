package User;

import static org.junit.Assert.*;
import User.Account;
import org.junit.Before;
import org.junit.Test;

public class AccountControllerTest {
  
	AccountController aController;
	
	
    @Before
	public void setUp() throws Exception {
	    aController = new AccountController();
	  }
	  
	@Test
	public void testLogOnForValidUser() {
		String userName = "juser";
		String password = "user";
		Account expResult = new User("Alexis", "Neas", "juser", "user", 'u', 'Y');
	    Account result = aController.logOn(userName,password);
	    
	    assertTrue("Account is logged in.",expResult.equals(result));
	}
	
	@Test
	public void testLogOnForInvalidUsername() {
		String userName = "Jess";
		String password = "user";
		Account expResult = new User("juser", "User", "juser", "user", 'u', 'Y'); 
	    Account result = aController.logOn(userName,password);
	    assertFalse("Username provided is invalid.",expResult.equals(result));
	}
	
	@Test
	public void testLogOnForInvalidPassword() {
		String userName = "juser";
		String password = "password";
		Account expResult = new User("Alexis", "Neas", "juser", "user", 'u', 'Y'); 
		Account result = aController.logOn(userName,password);
	    
		assertTrue("Password provided is invalid.",expResult.equals(result));
	}
	
	@Test
	public void testLogOnForDeactivatedAccount() {
		String userName = "trevor";
		String password = "password";
		Account expResult = new User("Rovert", "Wensman", userName , password, 'u', 'N'); 
		Account result = aController.logOn(userName,password);
	    
		assertFalse("Account is deactivated.",expResult.equals(result));
	}
	
	@Test
	public void testLogOffForValidUser() {
		Account user = new User("Alexis", "Neas", "juser", "user", 'u', 'Y'); 
		boolean expResult = false;
	    aController.logOff(user);
	    boolean result = user.isLoggedOn();
	    
	    assertEquals("Account is logged off.",expResult, result);
	}
	

	
	@Test
	public void testLogOffForValidAdmin() {
		String userName = "nadmin";
		Account admin = new User("Noreen", "Admin", "nadmin", "admin", 'a', 'Y'); 
		boolean expResult = false;
	    aController.logOff(admin);
	    boolean result = admin.isLoggedOn();
	    
	    assertEquals("Account logged on for: " + userName,expResult, result);
	}
	
	@Test
	public void testLogOnForValidAdmin() {
		String userName = "nadmin";
		String password = "admin";
		Admin expResult = new Admin("Noreen", "Admin", "nadmin", "admin", 'a', 'Y'); 
	    Account result = aController.logOn(userName,password);
	    
	    assertTrue("Account is logged in.",expResult.equals(result));
	}
	
}
