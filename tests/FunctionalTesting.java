import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import DBController.*;
import University.*;
import User.*;

public class FunctionalTesting {
	private UserInteraction userInteractions;
	private AdminInteractions adminInteractions;
	private AccountInteractions accountInteractions;
	
	@Before
	public void setUp() throws Exception {
		userInteractions = new UserInteraction();
		adminInteractions = new AdminInteractions();
		accountInteractions = new AccountInteractions();
	}

	@Test
	public void testLogOnU1U3() {
		Account account = accountInteractions.logOn("juser", "user");
		boolean loggedOn = account.isLoggedOn();
		boolean expected = true;
		assertTrue("The account should be logged on", loggedOn==expected);
	}
	
	@Test
	public void testLogOnU1U2() {
		Account account = accountInteractions.logOn("nadmin", "admin");
		boolean loggedOn = account.isLoggedOn();
		boolean expected = true;
		assertTrue("The account should be logged on", loggedOn==expected);
	}
	
	@Test
	public void testLogOnAlt1InvalidUser() {
		Account account = accountInteractions.logOn("THISISNOTAUSERNAME", "password");
		assertTrue("The account should not be logged on", account==null);
	}
	
	@Test
	public void testLogOnAlt2InvalidPassword() {
		Account account = accountInteractions.logOn("juser", "WRONGPASSWORD");
		boolean loggedOn = account.isLoggedOn();
		boolean expected = false;
		assertTrue("The account should not be logged on", loggedOn==expected);
	}
	
	@Test
	public void testLogOff() {
		Account account = accountInteractions.logOn("juser", "user");
		boolean loggedOn = account.isLoggedOn();
		account.logOff();
		boolean loggedOff = account.isLoggedOn();
		assertTrue("Account is not logged off", loggedOn != loggedOff);
	}
	
	@Test
	public void testViewUniversities() {
		
	}
	
	@Test
	public void testEditSchool() {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Test
	public void testEditUserU10() {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
