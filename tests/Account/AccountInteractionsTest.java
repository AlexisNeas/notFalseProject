/**
 * 
 */
package Account;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author jhansen001
 *
 */
public class AccountInteractionsTest {
 
	AccountInteractions aInteractions;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		aInteractions = new AccountInteractions();
	}

	@Test
	public void testLogOnForInvalidAccount() {
		String userName = "";
		String password = "";
		Account expResult = new User("Juser", "User", "juser", "user", 'u', 'Y'); 
	    Account result = aController.logOn(userName,password);
	    
	    assert.assertFalse("Account does not exist.",expResult, result);
		
	}
	
	

}
