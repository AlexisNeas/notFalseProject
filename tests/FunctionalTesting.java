import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import DatabaseController.*;
import University.*;
import User.*;

public class FunctionalTesting {
	private UserInteraction userInteractions;
	private AdminInteractions adminInteractions;
	private AccountInteractions accountInteractions;
	private AdminController adminController;
	private DBController dbController;
	private UserController userController;
	
	
	
	@Before
	public void setUp() throws Exception {
		 userInteractions = new UserInteraction();
		 adminInteractions = new AdminInteractions();
		 accountInteractions = new AccountInteractions();
		 adminController = new AdminController();
		 dbController = new DBController("notfal", "csci230");
		 userController = new UserController();
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Test
	public void testEditUserAndSaveAccountU10U11() {
		adminInteractions.addNewUser("ZVets", "New", "TESTING", "password", 'a');
		User expected = new User("Zachary", "Vetter", "TESTING", "password", 'a', 'Y');
		adminInteractions.editUser("Zachary", "Vetter", "TESTING", "password", 'a', 'Y');
		Account result = adminController.getUserInfo("TESTING");
		assertTrue("The users are not equal", expected.equals(result));
		dbController.deleteUser("TESTING");
	}
	
	@Test
	public void testAddSchoolAndSaveSchoolU6U12() {
		ArrayList<String> schoolList = adminController.viewUniversities();
		assertTrue("The school was already in the database", !schoolList.contains("Vetters School"));
		adminInteractions.addSchool("Vetters School", "NORTH DAKOTA", "BISMARCK",
				"STATE", 5, 1.0, 1, 1, 1.0, 1.0, 1, 1.0, 1.0, 1, 1, 1, "",
				"", "", "", "");
		schoolList = adminController.viewUniversities();
		assertTrue("The school was not added", schoolList.contains("Vetters School"));
		dbController.deleteSchool("Vetters School");
	}
	
	@Test
	public void testSearchAndViewResultsU13U15() {
		University expected = new University("Vetters School", "NORTH DAKOTA", "BISMARCK",
				"STATE", 5, 1.0, 1, 1, 1.0, 1.0, 1, 1.0, 1.0, 1, 1, 1, "",
				"", "", "", "");
		dbController.addNewSchool(expected);
		ArrayList<University> results = userController.searchSchool("!", "NORTH DAKOTA", "!", "!",
				-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
				-1, -1, -1, -1, -1, -1, "!", "!", "!", "!", "!");
		assertTrue("The school did not show up in the result list", results.contains(expected));
		dbController.deleteSchool("Vetters School");
	}
	
	@Test
	public void testSearchNoCriteriaU13Alt1() {
		ArrayList<University> results = userController.searchSchool("!", "!", "!", "!",
				-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
				-1, -1, -1, -1, -1, -1, "!", "!", "!", "!", "!");
		assertTrue("The results should be 0", results.isEmpty());
	}
	
	@Test
	public void testDeactivateUserU14() {
		adminInteractions.addNewUser("ZVets", "New", "TESTING", "password", 'a');
		adminInteractions.deactivateUser("TESTING");
		char result = adminController.getUserInfo("TESTING").getStatus();
		assertTrue("The users are not equal", 'N' == result);
		dbController.deleteUser("TESTING");
	}
	
	@Test
	public void testAddSchoolViewSavedSchoolsAndRemoveSavedSchoolsU16U19U21() {
		adminInteractions.addNewUser("ZVets", "New", "TESTING", "password", 'a');
		userInteractions.addSchool("YALE", "TESTING");
		ArrayList<String> savedSchools = userController.getSavedUniversities("TESTING");
		assertTrue("Yale should be saved to the user", savedSchools.contains("YALE"));
		userInteractions.remove("YALE", "TESTING");
		savedSchools = userController.getSavedUniversities("TESTING");
		assertTrue("Yale should not be saved to the user", !savedSchools.contains("YALE"));
		dbController.deleteUser("TESTING");
	}
	
	@Test
	public void testViewSavedSchoolsNoSchoolU16Alt1() throws Exception {
		adminInteractions.addNewUser("ZVets", "New", "TESTING", "password", 'a');
		ArrayList<String> savedSchools = userController.getSavedUniversities("TESTING");
		assertTrue("The size of the list should be 0", savedSchools.size() == 0);
		dbController.deleteUser("TESTING");
	}
	
	@Test
	public void testViewProfileU17() {
		adminInteractions.addNewUser("ZVets", "New", "TESTING", "password", 'u');
		User expected = new User("ZVets", "New", "TESTING", "password", 'u', 'Y');
		Account profile = userController.viewProfile("TESTING");
		assertTrue("The account information is not the same", profile.equals(expected));
		dbController.deleteUser("TESTING");
	}
	
	@Test
	public void testEditProfileU18() {
		adminInteractions.addNewUser("ZVets", "New", "TESTING", "password", 'u');
		Account expected = userController.viewProfile("TESTING");
		userInteractions.editProfile("ZVets", "Vetter", "TESTING", "password", 'u', 'Y');
		Account result = userController.viewProfile("TESTING");
		assertTrue("The user profile was not updated", !expected.equals(result));
		dbController.deleteUser("TESTING");
	}
	
	@Test
	public void testViewSchoolInformationU20() {
		University school = dbController.getSchoolInfo("YALE");
		University testSchool = userController.getSchoolInfo("YALE");
		assertTrue("The school information does not match", school.equals(testSchool));
	}
	
	@Test
	public void testViewSimilarSchoolsU22() {
		ArrayList<University> yaleSimilar = userController.findSimilarSchools(userController.getSchoolInfo("YALE"));
		ArrayList<University> tempSchool = userController.findSimilarSchools(userController.getSchoolInfo("CASE WESTERN"));
		assertTrue("The lists should not be the same", !yaleSimilar.equals(tempSchool));
	}
}
