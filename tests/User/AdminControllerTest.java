package User;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import University.University;
import DatabaseController.DBController;

public class AdminControllerTest {
	
	private AdminController adminController;
	private DBController db;
	private User newUser;
	private University newSchool;
	
	@Before
	public void setUp() throws Exception {
		adminController = new AdminController();
		db = new DBController("notfal","csci230");
		newUser = new User("ZVets", "New", "TESTING", "password", 'a', 'Y');
		newSchool = new University("Vetters School", "NORTH DAKOTA", "BISMARCK",
				"STATE", 5, 1.0, 1.0, 1.0, 1.0, 1.0, 1, 1.0, 1.0, 1, 1, 1, "",
				"", "", "", "");
	}

	@Test
	public void testGetListOfUsers() {
		ArrayList<Account> expected = db.getListOfUsers();
		ArrayList<Account> result = adminController.getListOfUsers();
		assertTrue("Should be an ArrayList of Accounts", result.equals(expected));
	}

	@Test
	public void testViewUniversities() {
		ArrayList<String> expected = db.getListOfSchools();
		ArrayList<String> result = adminController.viewUniversities();
		assertTrue("Should be an ArrayList of Strings", result.equals(expected));
	}
//
//	@Test
//	public void testGetSchoolInformation() {
//		University expected = db.getSchoolInfo("UNIVERSITY OF MINNESOTA");
//		University result = adminController.getSchoolInformation("UNIVERSITY OF MINNESOTA");
//		assertTrue("University of Minnesota info does not match", result.equals)
//	}

	@Test
	public void testAddNewUser() {
		ArrayList<Account> currentUsers = adminController.getListOfUsers();
		assertTrue("The new account is already in the database", !currentUsers.contains(newUser));
		adminController.addNewUser(newUser);
		currentUsers = adminController.getListOfUsers();
		assertTrue("The account was not added", currentUsers.contains(newUser));
	}

	@Test
	public void testAddSchool() {
		ArrayList<String> currentSchools = adminController.viewUniversities();
		assertTrue("The new school is already in the database", !currentSchools.contains(newSchool.getSchoolName()));
		adminController.addSchool(newSchool);
		currentSchools = adminController.viewUniversities();
		assertTrue("The school was not added", currentSchools.contains(newSchool.getSchoolName()));
	}

	@Test
	public void testSetSchoolInfo() {
		db.addNewSchool(newSchool);
		University testSchool = adminController.getSchoolInformation(newSchool.getSchoolName());
		assertTrue("The school's state should currently be North Dakota", 
				testSchool.getState().equals("NORTH DAKOTA"));
		testSchool.setState("MINNESOTA");
		adminController.setSchoolInfo(testSchool);
		testSchool = adminController.getSchoolInformation(testSchool.getSchoolName());
		assertTrue("The school should now be in MINNESOTA",
				testSchool.getState().equals("MINNESOTA"));
	}

	@Test
	public void testEditUser() {
		db.addNewUser(newUser);
		Account testAccount = adminController.getUserInfo(newUser.getUsername());
		assertTrue("The Account's last name is New", testAccount.getLastName().equals("New"));
		testAccount.setLastName("Vetter");
		adminController.editUser(testAccount);
		testAccount = adminController.getUserInfo(testAccount.getUsername());
		assertTrue("New last name is Vetter", testAccount.getLastName().equals("Vetter"));
	}

	@Test
	public void testDeactivateUser() {
		db.addNewUser(newUser);
		Account testAccount = adminController.getUserInfo(newUser.getUsername());
		assertTrue("The account is already deactivated", testAccount.getStatus()=='Y');
		adminController.deactivateUser(testAccount.getUsername());
		testAccount = adminController.getUserInfo(testAccount.getUsername());
		assertTrue("The account was not deactivated", testAccount.getStatus()=='N');
	}

	@Test
	public void testGetUserInfo() {
		db.addNewUser(newUser);
		Account testAccount = adminController.getUserInfo(newUser.getUsername());
		assertTrue("The accouns are not the same", newUser.equals(testAccount));
	}

	@After
	public void takeDown() {
		db.deleteUser(newUser.getUsername());
		db.deleteSchool(newSchool.getSchoolName());
	}
}
