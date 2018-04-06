package User;

import static org.junit.Assert.*;

import java.util.ArrayList;

import University.*;
import org.junit.Before;
import org.junit.Test;

import DatabaseController.DBController;

public class UserControllerTest {
	private UserController uct;
	private DBController db;
	
	
	@Before
	public void setUp() throws Exception {
		uct = new UserController();
		db = new DBController("notfal","csci230");
		// ****** should there be one school always added and one always removed
	}

	/*@Test
	public void testUserController() {
		fail("Not yet implemented");
	}*/

//	@Test
//	public void testSearchSchool() {

//	}

	@Test
	public void testRemoveSchoolInvalidSchool() {
		boolean removed = uct.removeSchool("Alexis", "juser");
		boolean expected = false;
		assertTrue("The invlid school should not have been removed.",removed == expected);
	}	
	
	@Test
	public void testRemoveSchoolNotSavedSchool() {
		boolean removed = uct.removeSchool("HARVARD", "juser");
		assertTrue("Cannot remove school that isn't saved.",removed == false);
	}
	
	@Test
	public void testRemoveSchoolInvalidUser() {
		boolean removed = uct.removeSchool("UNIVERSITY OF MINNESOTA", "Linda");
		assertTrue("The school should not have been removed, user is invalid",removed == false);
	}

	@Test
	public void testRemoveSchoolValid() {
		boolean removed = uct.removeSchool("UNIVERSITY OF MINNESOTA", "juser");
		assertTrue("The school should not have been removed",removed == true);
	}
	
	@Test
	public void testGetSchoolInfoInvalidSchool() {
		University u = uct.getSchoolInfo("LINDA");
		assertTrue("The school is invalid and shouldn't have information", u==null);
	}
	
	@Test
	public void testGetSchoolInfoValid() {
		University u = uct.getSchoolInfo("UNIVERSITY OF MINNESOTA");
		String expected = "UNIVERSITY OF MINNESOTA";
		assertTrue("The school is invalid and shouldn't have information", u.getSchoolName().equals(expected));	
	}

/*	@Test
	public void testAddSchoolInvalidSchool() {
		fail("Not yet implemented");
	}*/
//
/*	@Test
	public void testFindSimilarSchoolsValid() {
		
		ArrayList<University> u = uct.findSimilarSchools("UNIVERSITY OF MINNESOTA");
		assertTrue("There shouldn't be similar schools for an invalid school", u.length == 5);
	}*/
	
	@Test
	public void testFindSimilarSchoolsValid() {
		University univ = uct.getSchoolInfo("UNIVERSITY OF MINNESOTA");
		ArrayList<University> u = uct.findSimilarSchools(univ);
		assertTrue("Returned no schools.", u.size() == 5);
	}

	
	@Test(expected = Exception.class)
	public void testGetSavedUniversitiesInvalidUser() {
		uct.getSavedUniversities("Linda");
	}
	
	@Test
	public void testGetSavedUniversitiesValid() {
		ArrayList<String> u = uct.getSavedUniversities("juser");
		ArrayList<String> expected = db.getUserSchools("juser");
		assertTrue("No array list returned", u.size() != 0);
		assertTrue("Not returning saved schools of user", u.equals(expected));		
	}

/*	@Test
	public void testEditProfile() {
		fail("Not yet implemented");
	}*/

	@Test
	public void testViewProfileInvalidUser() {
		Account a = uct.viewProfile("Linda");
		assertTrue("No profile for invalid user", a== null);
	}
	
	@Test
	public void testViewProfileValid() {
		Account a = uct.viewProfile("juser");
		String expected = "juser";
		assertTrue("No profile for invalid user", a.getUsername().equals(expected));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddSchoolInvalidUser() {
		
	}
	}

}
