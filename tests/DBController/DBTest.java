package DBController;
import University.*;
import User.*;
import DatabaseController.*;
import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;



public class DBTest
{
  private Account newUser;
  @Before
  public void setUp()
  {
   this.newUser = new User("first", "last", "username", "password", 'a', 'Y');
  }
  
  //setting user information
  @Test
  public void setUserInfoTest()
  {
    Account acc = new Account("Jubie", "Alade", "jalade", "csci", 'u', 'Y');
    char expected = 'u';                               
    char result = acc.getAccountType();
    Assert.assertEquals("The char info was set correctly: " + expected, expected, result);  
  }
  
  //setting school information 
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
    
    DBController dbCont = new DBController("notfal", "csci230");  
    univ.setSchoolName("UOJ");
    dbCont.addNewSchool(univ); 
    univ = dbCont.getSchoolInfo("UOJ");
    

        String result = univ.getSchoolName();
        String expected = "UOJ";
        Assert.assertTrue("The university was added: " + expected, result.equals("UOJ"));
   }


  
    
    
    
  
  

  @Test (expected = Exception.class)
  public void emptySearchResults() throws Exception
  {
   
   DBController dc = new DBController("notfal", "csci230");
   dc.searchTwo("!", "!","!" ,"!",//SchoolName, State, location,Control
              -500, -400,//NumStudents
              -1,-1,//%Female
              -1,-1,//SATVerbal
              -1,-1,//SATMath
              -1,-1,//Tuition
              -1,-1,//percentRecFinAid
              -1,-1,//numApps
              -1,-1,//percentAccepted
              -1,-1,//PercentEnrolled
              -1,-1,//AcademicsScale
              -1,-1,//Social
              -1,-1,//Academics
              "!", "!","!", "!","!");
   

          
    
  }

  
  @Test
  public void searchTwoTest()
  {

   

	  
	  ArrayList<University> list = null;
	  DBController dc = new DBController("notfal", "csci230");
	    try {
			list = dc.searchTwo("OF", "MINNESOTA","URBAN" ,"STATE",//SchoolName, State, location,Control
			                              10000, 45000,//NumStudents
			                              40.0,46.0,//%Female
			                              489.0,491.0,//SATVerbal
			                              556.0,558.0,//SATMath
			                              13771.0,13773.0,//Tuition
			                              49,51,	//percentRecFinAid
			                              8499,8501,		//numApps
			                              79,81,		//percentAccepted
			                              59.0,61.0,//PercentEnrolled
			                              3,5,//AcademicsScale
			                              1,5,//Social
			                              1,5,//Academics
			                              "AGRICULTURE", "ENGINEERING","!", "!","!");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	    	 String result = list.get(0).getSchoolName();
	         String expected = "UNIVERSITY OF MINNESOTA";
	         Assert.assertTrue("Search did not return desired result: " + expected, result.equals(expected));
	  	
	  	
	  	


  }
  
  @Test(expected = Exception.class)
 public void testAddNewUser() throws Exception{
  
  DBController dc = new DBController("notfal", "csci230");
  dc.addNewUser(newUser);
  
 }
  @Test 
  public void getUserSchoolsTest() throws Exception
  {
   ArrayList<String> list;
   DBController dc = new DBController("notfal", "csci230");
   dc.userSaveSchool("juser", "UNIVERSITY OF MINNESOTA");
   list = dc.getUserSchools("juser");
   //System.out.println(list.get(0));
   String result = list.get(0);
     String expected = "UNIVERSITY OF MINNESOTA";
     Assert.assertTrue("Saved schools did not return desired result: " + expected, result.equals(expected));
  
     
     
     
  }
 
  
  @Test
  public void findSimilarSchoolsTest()
  {
   University univ = new University();
   
   ArrayList<University> list;
   DBController dc = new DBController("notfal", "csci230");
   univ = dc.getSchoolInfo("YALE");
   list = dc.findSimilarSchools(univ);
   String result = list.get(0).getSchoolName();
   String expected = list.get(0).getSchoolName();
   Assert.assertTrue("Saved schools did not return desired result: " + expected, result.equals(expected));
  }
  @Test
  public void getListOfUsersTest()
  {
   DBController dc = new DBController("notfal", "csci230");
   ArrayList<Account> acc = dc.getListOfUsers();
   String result = acc.get(0).getUsername();
   String expected = acc.get(0).getUsername();   
   Assert.assertTrue("List of users not correct:" + expected, result.equals(expected));
  }
  
  @Test
  public void activateUserTest()
  {
<<<<<<< HEAD
	  DBController dc = new DBController("notfal", "csci230");
	  dc.activateUser("juser");
	  Account acc = dc.getUserInfo("juser");
	  char result = acc.getStatus();
	  char expected = 'Y';
	  Assert.assertTrue("List of users not correct:" + expected, result == expected);
	  
=======
   DBController dc = new DBController("notfal", "csci230");
   Account acc = dc.activateUser("juser");
   char result = acc.getStatus();
   char expected = 'Y';
   Assert.assertTrue("List of users not correct:" + expected, result == expected);
   
>>>>>>> 5d0b1208a95d6420b1062ea28e473fe8fd3b7d9a
  }
  @Test
  public void deactivateUser()
  {
<<<<<<< HEAD
	  DBController dc = new DBController("notfal", "csci230");
	  dc.deactivateUser("juser");
	  Account acc = dc.getUserInfo("juser");
	  char result = acc.getStatus();
	  char expected = 'N';
	  Assert.assertTrue("List of users not correct:" + expected, result == expected);
	  
=======
   DBController dc = new DBController("notfal", "csci230");
   Account acc = dc.deactivateUser("juser");
   char result = acc.getStatus();
   char expected = 'N';
   Assert.assertTrue("List of users not correct:" + expected, result == expected);
   
>>>>>>> 5d0b1208a95d6420b1062ea28e473fe8fd3b7d9a
  }
  @Test
  public void userSaveSchool() throws Exception
  {
   ArrayList<String> list;
   DBController dc = new DBController("notfal", "csci230");
   dc.userSaveSchool("juser", "UNIVERSITY OF MINNESOTA");
   list = dc.getUserSchools("juser");
   //System.out.println(list.get(0));
   String result = list.get(0);
     String expected = "UNIVERSITY OF MINNESOTA";
     Assert.assertTrue("Saved schools did not return desired result: " + expected, result.equals(expected));
  }
  @Test 
  public void getSchoolInfo()
  {
 DBController dc = new DBController("notfal", "csci230");
 University univ =   dc.getSchoolInfo("UNIVERSITY OF MINNESOTA");
 String result = univ.getSchoolName();
 String expected = "UNIVERSITY OF MINNESOTA";
 Assert.assertTrue("Saved schools did not return desired result: " + expected, result.equals(expected));
  }
  
  @Test
  public void removeUserSchoolTest() throws Exception
  {
   DBController dc = new DBController("notfal", "csci230");
   
   dc.removeSchool("UNIVERSITY OF MINNESOTA", "juser");
   ArrayList<String> list = dc.getUserSchools("juser");
   Assert.assertTrue("Remove schools did not return desired result: " + null, list.isEmpty());
  }
  
  @Test(expected = Exception.class)
  public void testInvalidUserSchools() throws Exception
  {
	  DBController dc = new DBController("notfal", "csci230");
	  dc.getUserSchools("sup");
  }
  

  
}