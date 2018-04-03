package User;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import University.University;

public class AdminControllerTest {
	
	private AdminController adminController;
	
	@Before
	public void setUp() throws Exception {
		adminController = new AdminController();
	}

	@Test
	public void testGetListOfUsers() {
		ArrayList<Account> result = adminController.getListOfUsers();
		assertTrue("Should be an ArrayList of Accounts", result instanceof ArrayList);
	}

	@Test
	public void testViewUniversities() {
		fail("");
	}

	@Test
	public void testGetSchoolInformation() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddNewUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddSchool() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSchoolInfo() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeactivateUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUserInfo() {
		fail("Not yet implemented");
	}

}
