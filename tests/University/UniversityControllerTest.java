package University;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UniversityControllerTest {
	private University testSchool;
 
@Before
 public void setUp() throws Exception {
	  testSchool = new University("Vetters School", "NORTH DAKOTA", "BISMARCK",
				"STATE", 5, 1.0, 1.0, 1.0, 1.0, 1.0, 1, 1.0, 1.0, 1, 1, 1, "",
				"", "", "", "");
 }


 @Test
 public void testMakeUniversity() 
 {
	 University newSchool = new University("Vetters School", "NORTH DAKOTA", "BISMARCK",
				"STATE", 5, 1.0, 1.0, 1.0, 1.0, 1.0, 1, 1.0, 1.0, 1, 1, 1, "",
				"", "", "", "");
	 assertTrue("The schools do not match", newSchool.equals(testSchool));
 }

}
