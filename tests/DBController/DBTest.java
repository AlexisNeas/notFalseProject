package DBController;
import University.*;
import User.*;
import DatabaseController.*;
import static org.junit.Assert.*;
import org.junit.*;



public class DBTest
{
  
  @Before
  public void setUp()
  {
   
  }
  
  @Test
  public void setUserInfoTest()
  {
    Account acc = new Account("Jubie", "Alade", "jalade", "csci", 'u', 'Y');
    char expected = 'u';                               
    char result = acc.getAccountType();
    Assert.assertEquals("The char info was set correctly: " + expected, expected, result);  
  }
  
  @Test 
  public void setSchoolInformationTest()
  {
    University univ = new University();
    String expected = "SJU";
    univ.setSchoolName("SJU"); 
    String result = univ.getSchoolName();
    Assert.assertEquals("The info was set correctly " + expected, expected, result);
  }
  
  @Test
  public void addNewSchoolTest()
  {
    University univ = new University();
    
    
    @Test
	public void testGetSchoolInfo() {
		fail("Not yet implemented");
	}

	@Test
	public void testUserSaveSchool() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveSchoolFromDatabase() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeactivateUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetListOfUsers() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindSimilarSchools() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveSchool() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUserSchools() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearch() {
		fail("Not yet implemented");
	}
    
    
    
  }
  
}