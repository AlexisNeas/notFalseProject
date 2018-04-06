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
  }
  
  @Test
  public void setSchoolNameTest()
  {
    university.setSchoolName("SJU");
    String expected = "SJU";
    String result = university.getSchoolName();
    Assert.assertTrue("The school name is not SJU", university.getSchoolName().equals("SJU"));    
  }
  
  @Test
  public void setLocationTest()
  {
    university.setLocation("Collegeville");
    String expected = "Collegeville";
    String result = university.getLocation();
    Assert.assertTrue("The location was set correctly", university.getLocation().equals("Collegeville"));
  }
  
  @Test
  public void setStateTest()
  {
    university.setState("MN");
    String expected = "MN";
    String result = university.getState();
    Assert.assertTrue("State set correctly", university.getState().equals("MN"));
    
  }
  
  @Test
  public void setControlTest()
  {
    university.setControl("STATE");
    String expected = "STATE";
    String result = university.getControl();
    Assert.assertTrue("Control set correctly", university.getControl().equals("STATE"));
    
  }
  
  @Test
  public void setStudyArea1Test()
  {
    university.setStudyArea1("A");
    String expected = "A";
    String result = university.getStudyArea1();
    Assert.assertTrue("Study area set correctly", university.getStudyArea1().equals("A"));
  }
  
  @Test
  public void setStudyArea2Test()
  {
    university.setStudyArea2("B");
    String expected = "B";
    String result = university.getStudyArea2();
    Assert.assertTrue("Study area set correctly", university.getStudyArea2().equals("B"));   
  }
  
  @Test
  public void setStudyArea3Test()  
  {
    university.setStudyArea3("C");
    String expected = "C";
    String result = university.getStudyArea3();
    Assert.assertTrue("Study area set correctly", university.getStudyArea3().equals("C"));
  }
  
  @Test
  public void setStudyArea4Test()
  {
    university.setStudyArea4("D");
    String expected = "D";
    String result = university.getStudyArea4();
    Assert.assertTrue("Study area set correctly", university.getStudyArea4().equals("D"));
  }
  
  
  @Test
  public void setStudyArea5Test()
  {
    university.setStudyArea5("E");
    String expected = "E";
    String result = university.getStudyArea5();
    Assert.assertTrue("Study area set correctly", university.getStudyArea5().equals("E"));
  }
  @Test
  public void setSocialTest()
  {
    university.setSocial(3);
    int expected = 3;
    int result = university.getSocial();
    Assert.assertTrue("The social scale was set correctly", university.getSocial()==3);       
  }
  
  @Test
  public void setNumApplicantsTest()
  {
    university.setNumApplicants(400);
    int expected = 400;
    int result = university.getNumApplicants();
    Assert.assertTrue("Number of applicants is set correctly", university.getNumApplicants()==400);      
  }
  
  @Test
  public void setNumStudentsTest()
  {
    university.setNumStudents(2000);
    int expected = 2000;
    int result = university.getNumStudents();
    Assert.assertTrue("Number of students is set correctly", university.getNumStudents()==2000);
  }
  
  @Test
  public void setQualOfLifeTest()
  {
    university.setQualOfLife(5);
    int expected = 5;
    int result = university.getQualOfLife();
    Assert.assertTrue("Correct quality of life amount", university.getQualOfLife()==5);
  }
  
  @Test
  public void setPercentEnrollTest()
  {
    university.setPercentEnroll(60);
    double expected = 60;
    double result = university.getPercentEnroll();
    Assert.assertTrue("Correct percent enroll", university.getPercentEnroll() == 60);
  }
  
  @Test
  public void setPercentAcceptedTest()
  {
    university.setPercentAccepted(50);
    double expected = 50;
    double result = university.getPercentAccepted();
    Assert.assertTrue("Correct percent accepted", university.getPercentAccepted()== 50);
  }
  
  @Test
  public void setPercentRecFinAidTest()
  {
    university.setPercentRecFinAid(50);
    double expected = 50;
    Assert.assertTrue("Correct percent rec. fin. aid", university.getPercentRecFinAid()== 50);
  }
  
  @Test
  public void setTuitionTest()
  {
    university.setTuition(50000);
    int expected = 50000;
    Assert.assertTrue("Correct tuition amount",  university.getTuition()== 50000);
  }
  
  @Test
  public void setSatMathTest()
  {
    university.setSatMath(50);
    int expected = 50;
    Assert.assertTrue("Correct satMath score", university.getSatMath()== 50);
  }
  
  @Test
  public void setSatVerbalTest()
  {
    university.setSatVerbal(50);
    int expected = 50;
    Assert.assertTrue("Correct satMath score", university.getSatVerbal()== 50);
  }
  
  @Test
  public void setAcademicScaleTest()
  {
    university.setAcademicScale(5);
    int expected = 5;
    int result = university.getAcademicScale();
    Assert.assertTrue("Academic scale set correctly", university.getAcademicScale()== 5);
  }
  
  @Test
  public void setPercentFemaleTest()
  {
    university.setPercentFemale(0);
    double expected = 0;
    Assert.assertTrue("Correct percent female", university.getPercentFemale()== 0);
  }
  
}