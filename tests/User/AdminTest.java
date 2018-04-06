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
public class AdminTest {

	Admin admin;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.admin = new Admin("Noreen", "admin", "nadmin", "admin", 'a', 'Y');
	}

	@Test
	public void testAdminConstructor() {
		
		Admin result = this.admin;
		Admin expResult = new Admin("Noreen", "admin", "nadmin", "admin", 'a', 'Y');
		assertEquals("Admin account exists.",expResult, result);
	}

}
