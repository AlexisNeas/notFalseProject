package User;

import static org.junit.Assert.*;

import org.junit.Test;

public class AccountControllerTest {
  
	AccountController aController;
	
	
    @Before
	public void setUp() throws Exception {
	    aController = new AccountController();
	  }
	  
	@Test
	public void testLogOnForValidUser() {
		String userName = "Juser";
		String password = "user";
		Account expResult = new User("Juser", "User", "juser", "user", 'u', 'Y'); 
	    Account result = aController.logOn(userName,password);
	    
	    assert.assertEquals("Account logged on for: " + userName,expResult, result);
	}
	
	@Test
	public void testLogOnForInvalidUsername() {
		String userName = "Jess";
		String password = "user";
		Account expResult = new User("Juser", "User", "juser", "user", 'u', 'Y'); 
	    Account result = aController.logOn(userName,password);
	    
	    assert.assertFalse("Username provided is invalid.",expResult, result);
	}
	
	@Test
	public void testLogOnForInvalidPassword() {
		String userName = "Juser";
		String password = "password";
		Account expResult = new User("Juser", "User", "juser", "user", 'u', 'Y'); 
		Account result = aController.logOn(userName,password);
	    
		assert.assertFalse("Password entered is invalid.",expResult, result);
	}
	
	@Test
	public void testLogOnForDeactivatedAccount() {
		String userName = "jdeactivated";
		String password = "deactivated";
		Account expResult = new User("Jdeactivated", "deactivated", "jdeactivated", "deactivated", 'u', 'N'); 
		Account result = aController.logOn(userName,password);
	    
		assert.assertFalse("Account is deactivated.",expResult, result);
	}
	
	@Test
	public void testLogOffForValidUser() {
		String userName = "juser";
		String password = "user";
		Account user = new User("Juser", "user", "juser", "user", 'u', 'Y'); 
		boolean expResult = false;
	    aController.logOff(userName,password);
	    boolean result = user.isLoggedOn();
	    
	    assert.assertEquals("Account is logged off.",expResult, result);
	}
	

	
	@Test
	public void testLogOffForValidAdmin() {
		String userName = "jadmin";
		String password = "admin";
		Account admin = new User("Jadmin", "admin", "jadmin", "admin", 'a', 'Y'); 
		boolean expResult = false;
	    aController.logOff(userName,password);
	    boolean result = admin.isLoggedOn();
	    
	    assert.assertEquals("Account logged on for: " + userName,expResult, result);
	}
	

	
	}

}
