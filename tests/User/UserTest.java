/**
 * 
 */
package User;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author jhansen001
 *
 */
public class UserTest {
    User user;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception { 
		this.user = new User("Alexis", "Neas", "juser", "user", 'u', 'Y');
	}

	@Test
	public void testUserConstructor() {
		User result = this.user;
		User expResult = new User("Alexis", "Neas", "juser", "user", 'u', 'Y');
		assertEquals("User account exists.",expResult, result);
	}
	
	@Test
	public void testInvalidUserConstructor() {
		User result = this.user;
		User expResult = new User("Jess", "Neas", "juser", "user", 'u', 'Y');
		assertFalse("User account exists.",expResult.equals(result));
	}
	

}
