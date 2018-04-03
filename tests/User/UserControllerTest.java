package User;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UserControllerTest {
	UserController uct;
	@Before
	public void setUp() throws Exception {
		uct = new UserController();
		// ****** should there be one school always added and one always removed
	}

	/*@Test
	public void testUserController() {
		fail("Not yet implemented");
	}*/

	@Test
	public void testSearchSchool() {
		fail("Not yet implemented");
	}

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
		assertTrue("The school is invalid and shouldn't have information", u.getName() == "UNIVERSITY OF MINNESOTA");
	}

	@Test
	public void testAddSchoolInvalidSchool() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindSimilarSchoolsInvalidSchool() {
		ArrayList<University> u = uct.findSimilarSchools("LINDA");
		assertTrue("There shouldn't be similar schools for an invalid school", u.length == 0);
	}
	
	@Test
	public void testFindSimilarSchoolsValid() {
		ArrayList<University> u = uct.findSimilarSchools("UNIVERSITY OF MINNESOTA");
		assertTrue("Returned no schools.", u.length == 5);
	}

	@Test
	public void testDisplayResults() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSavedUniversitiesInvalidUser() {
		ArrayList<University> u = uct.getSavedUniversities("Linda");
		assertTrue("No saved schools for invalid user", u==null);
	}
	
	@Test
	public void testGetSavedUniversitiesValid() {
		ArrayList<University> u = uct.getSavedUniversities("juser");
		assertTrue("No array list returned", u.length != null);
	}

	@Test
	public void testEditProfile() {
		fail("Not yet implemented");
	}

	@Test
	public void testViewProfileInvalidUser() {
		Account a = uct.viewProfile("Linda");
		assertTrue("No profile for invalid user", a== null);
	}
	
	@Test
	public void testViewProfileValid() {
		Account a = uct.viewProfile("juser");
		assertTrue("No profile for invalid user", a.getUsername()== "juser");
	}

}
