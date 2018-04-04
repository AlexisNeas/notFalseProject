package University; 
import University.*;
import org.junit.*;
import static org.junit.Assert.*;



public class UniversityTest
{
  
  University university;
  
  @Before
  public void init()
  {
    university = new University();
    
    university.setSchoolName("SJU");
    university.setState("MN");
    university.setLocation("Collegeville");
    university.setControl("User");
    university.setStudyArea1("A");
    university.setStudyArea2("B");
    university.setStudyArea3("C");
    university.setStudyArea4("D");
    university.setStudyArea5("E");
    university.setSocial(3);
    university.setNumApplicants(400);
    university.setNumStudents(2000);
    university.setAcademicScale(5);
    university.setQualOfLife(5);
    university.setPercentFemale(0);
    university.setSatVerbal(50);
    university.setSatMath(50);
    university.setTuition(50000);
    university.setPercentRecFinAid(50);
    university.setPercentAccepted(50);
    university.setPercentEnroll(60);
  }
  
  @Test
  public void testSchoolInfoReturnFalse()
  {
    Assert.assertFalse("The school name is not SJU", university.getSchoolName().equals("UST"));
    Assert.assertFalse("The school state is not MN", university.getState().equals("WI"));
    Assert.assertFalse("The location is not Collegeville", university.getLocation().equals("Over there"));
    Assert.assertFalse("The control isnt user", university.getControl().equals("Not user"));
    Assert.assertFalse("Study area is not correct", university.getStudyArea1().equals("Z"));
    Assert.assertFalse("Study area is not correct", university.getStudyArea2().equals("Z"));
    Assert.assertFalse("Study area is not correct", university.getStudyArea3().equals("Z"));
    Assert.assertFalse("Study area is not correct", university.getStudyArea4().equals("Z"));
    Assert.assertFalse("Study area is not correct", university.getStudyArea5().equals("Z"));
    Assert.assertFalse("The social scale is wrong", university.getSocial()==4);
    Assert.assertFalse("Number of applicants is wrong", university.getNumApplicants()==50);
    Assert.assertFalse("Number of students is wrong", university.getNumStudents()==20);
  
                       
  }
  
}