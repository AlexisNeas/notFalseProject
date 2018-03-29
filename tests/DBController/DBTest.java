package tests.DBController;
import src.University.*;
import src.User.*;
import src.DatabaseController.*;
import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;



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
    ArrayList<String> list;
    DBController dbCont = new DBController("notfal", "csci230");  
    univ.setSchoolName("UOJ");
    dbCont.addNewSchool(univ); 
    list=dbCont.getListOfSchools();
    
    for (int i=0; i< list.size(); i++)
    {
      if(list.get(i).equals("UOJ")) 
      {
        String result = list.get(i);
        String expected = "UOJ";
        Assert.assertTrue("The university was added: " + expected, result == "UOJ");
      }
      break;
    }

  }
  
}