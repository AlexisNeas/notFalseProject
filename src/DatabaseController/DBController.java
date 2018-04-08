package DatabaseController;
import java.lang.reflect.Array;
import java.util.ArrayList;

import University.*;

import User.*;
import dblibrary.project.csci230.*;

/**
 * Manages the Database.
 * 
 * @author Trevor Wensman
 * @version 3/20/18
 */
public class DBController 
{
  // The Database library
  private UniversityDBLibrary univDBlib;
  // Constructs the database library for use in the DB Controller
  public DBController(String username, String password)
  {
    univDBlib = new UniversityDBLibrary(username,password);
  }
  
  // Gets the Database.
  //@return the database.
  public UniversityDBLibrary getUnivDBlib(){
    return univDBlib;
  }
  
  /**
   * Gets an ArrayList of all the emphases for a university.
   * 
   * @param schoolName Name of a school.
   * 
   * @return An array list of emphases for a university.
   * 
   */
  public ArrayList<String> universityEmphases(String schoolName)
  {
    String[][] arrayEmphases = univDBlib.university_getNamesWithEmphases();
    ArrayList<String> arrayList = new ArrayList<String>();
      for(int i = 0; i < arrayEmphases.length ;i++)
    {
      if(arrayEmphases[i][0].equals(schoolName))
      {
        arrayList.add(arrayEmphases[i][1]);
      }
    }
      return arrayList;
  }
  
  /**
   * Gets all emphases in the Database.
   * 
   */
  public ArrayList<String> getEmphases()
  {
	ArrayList<String> emphasesList= new ArrayList<String>();
	String[][] arrayEmphases = univDBlib.university_getEmphases();
	for(int i = 0; i < arrayEmphases.length; i++)
	{
		emphasesList.add(arrayEmphases[i][0]); 
	}
	
	
	return emphasesList;
	  
  }
  /**
   * Gets a specifed user from the database.
   * 
   * @param username the username of the desired user.
   * @throws NullPointerException
   * @return user An account object with a user's information.
   * 
   */
  public Account getUserInfo(String username) 
  {
    String[][] array = univDBlib.user_getUsers();
    Account user = null;
    for(int i = 0; i<array.length ;i++)
    {
      if(array[i][2].equals(username))
      {
        user = returnUser(array[i][0], array[i][1], array[i][2], array[i][3], array[i][4].charAt(0), array[i][5].charAt(0));
      }
    }
 
    
    return user;
  }
  
  /**
   * Gets a list of all the school names in the Database.
   * 
   * @return An ArrayList<String> of school names in the Database.
   * 
   */
  public ArrayList<String> getListOfSchools()
  {
    String[][] array = univDBlib.university_getUniversities();
    ArrayList<String> list = new ArrayList<String>();
    for(int i = 0; i<array.length;i++)
    {
      list.add(array[i][0]);
    }
    return list;
    
  }
  /**
   * Adds a new user to the database.
   * @param username the username.
   * @param password the users password.
   * @param firstName the users first name.
   * @param lastName the users last name.
   * @param type the type of user.
 * @throws Exception 
   * 
   * @throws IllegalArgumentException the username is already taken
   */
  public void addNewUser(Account user) throws IllegalArgumentException
  {
	  
 String username = user.getUsername();
 String firstName = user.getFirstName();
 String lastName = user.getLastName();
 String password = user.getPassword();
 char type = user.getAccountType();
    boolean bool = findUser(username);
    if(!bool)
    {
      univDBlib.user_addUser(firstName,lastName, username, 
                             password, type);
    }
    else {
    	throw new IllegalArgumentException();
    }
  }
  
  /**
   * Adds a new school to the database.
   * @param University a University object containing the information for the school.
   * 
   * @throws IllegalArgumentException if name is already used
   */
  public void addNewSchool(University univ) throws IllegalArgumentException
  {
    int add = univDBlib.university_addUniversity(univ.getSchoolName(), univ.getState(), univ.getLocation(), 
            	univ.getControl(),  univ.getNumStudents(),  univ.getPercentFemale(), 
            	univ.getSatVerbal(),  univ.getSatMath(),  univ.getTuition(),  univ.getPercentRecFinAid(),
            	univ.getNumApplicants(),  univ.getPercentAccepted(), 
            	univ.getPercentEnroll(),  univ.getAcademicScale(),  univ.getSocial(),  univ.getQualOfLife());
    if(add == -1) {
    	throw new IllegalArgumentException();
    }
  }
  
  /**
   * Adds an emphases for a school.
   */
  public void addNewEmphases(String schoolName, String emphases) throws Exception
  {
	  ArrayList<String> schools = this.getListOfSchools();
	  if(schools.contains(schoolName))
	  {
		  univDBlib.university_addUniversityEmphasis(schoolName, emphases);
	  }
	  else
	  {
		  throw new Exception("SCHOOL DOES NO EXIST.");
	  }
	  
  }

  /**
   * Sets a current Schools information.
   * @param University a University object containing the information for the school.
   * @throws IllegalArgumentException if the school doesn't exist
   */
  public void setSchoolInformation(University univ) throws IllegalArgumentException
  {
    int edited = univDBlib.university_editUniversity(univ.getSchoolName(), univ.getState(), univ.getLocation(), 
                                        univ.getControl(),  univ.getNumStudents(),  univ.getPercentFemale(), 
                                        univ.getSatVerbal(),  univ.getSatMath(),  univ.getTuition(),  univ.getPercentRecFinAid(),
                                        univ.getNumApplicants(),  univ.getPercentAccepted(), 
                                        univ.getPercentEnroll(),  univ.getAcademicScale(),  univ.getSocial(),  univ.getQualOfLife());
    if(edited <= 0) {
    	throw new IllegalArgumentException();
    }
  }
  
  /**
   * Sets a current users information
   * @param firstName the first name
   * @param lastName the last name
   * @param username the username.
   * @param password the user's password
   * @param type type of user
   * @param status status of the user
   * @return An account with the user's information.
   * @throws IllegalArgumentException if user does not exist in the database
   */
  public void setUserInfo(String firstName, String lastName, String username, String password, char type, char status) throws IllegalArgumentException
  {
      int edit = univDBlib.user_editUser(username , firstName, lastName, 
                              password, type, status);
      if(edit <= 0) {
    	  throw new IllegalArgumentException();
      }
  }
  /**
   * Gets an individual schools information.
   * @param schoolName the school name.
   * @return the school
   */
  public University getSchoolInfo(String schoolName)
  {
    String[][] array = univDBlib. university_getUniversities();
    University  university = null;
    String emp1,emp2,emp3,emp4,emp5;
    for(int i = 0; i<array.length;i++)
    {
      if(array[i][0].equals(schoolName))
      {
        for(int j = 0; j<array[i].length;j++)
        {
         ArrayList<String> emphasesArrayList = universityEmphases(array[i][0]);
            if(emphasesArrayList.size() == 5)
            {
             emp1 = emphasesArrayList.get(0);
             emp2 = emphasesArrayList.get(1);
             emp3 = emphasesArrayList.get(2);
             emp4 = emphasesArrayList.get(3);
             emp5 = emphasesArrayList.get(4);
             
            }
            else if(emphasesArrayList.size() == 4)
            {
             emp1 = emphasesArrayList.get(0);
             emp2 = emphasesArrayList.get(1);
             emp3 = emphasesArrayList.get(2);
             emp4 = emphasesArrayList.get(3);
             emp5 = "";
             
            }
            else if(emphasesArrayList.size() == 3)
            {
             emp1 = emphasesArrayList.get(0);
             emp2 = emphasesArrayList.get(1);
             emp3 = emphasesArrayList.get(2);
             emp4 = "";
             emp5 = "";
             
            }
            else if(emphasesArrayList.size() == 2)
            {
             emp1 = emphasesArrayList.get(0);
             emp2 = emphasesArrayList.get(1);
             emp3 = "";
             emp4 = "";
             emp5 = "";
             
            }
            else if(emphasesArrayList.size() == 1)
            {
             emp1 = emphasesArrayList.get(0);
             emp2 = "";
             emp3 = "";
             emp4 = "";
             emp5 = "";
             
            }
            else {
             
             emp1 = "";
             emp2 = "";
             emp3 = "";
             emp4 = "";
             emp5 = "";
            }
         
          
          university = returnUniversity(array[i][0], //schoolName
                  array[i][1], //State
                  array[i][2],//location
                  array[i][3],//control
                  Integer.parseInt(array[i][4]),// numStudents
                  Double.parseDouble(array[i][5]),//%Female
                  Double.parseDouble(array[i][6])//// SATVerbal
                 ,Double.parseDouble(array[i][7]),//SATMath
                  Double.parseDouble(array[i][8]),//Expenses
                  Double.parseDouble(array[i][9]),// percentFinancialAid
                  Integer.parseInt(array[i][10]),// numberofApps
                  Integer.parseInt(array[i][11])// percent admitted
                 ,Integer.parseInt(array[i][12]), //percentEnrolled
                  Integer.parseInt(array[i][13]), //academicsScale
                  Integer.parseInt(array[i][14]), // social scale
                  Integer.parseInt(array[i][15]), //qualoflife
                  emp1,emp2,emp3,emp4,emp5);
          
        }
      }
    }
    return university;
  }
  /**
   * Saves a school to a users profile.
   * @param username the username
   * @param the school name to save
   * 
   */
  public int userSaveSchool(String username,String schoolName)
  {
    return univDBlib.user_saveSchool(username, schoolName);
  }
  
  
  /**
   * Finds a user in the database
   * @param username the username
   * @return boolean true if found
   * 
   */
  public boolean findUser(String username)
  {
    String[][] array = univDBlib.user_getUsers();
    boolean bool = false;
    int len = array.length;
    for(int i = 0; i<len ;i++)
    {
      if(array[i][2].equals(username))
      {
        bool = true;
        break;
      }
    }
    return bool;
  }
  /**
   * Removes a school from the database
   * @param schoolName the name of the school to remove.
   */
  public void removeSchoolFromDatabase(String schoolName)
  {
    univDBlib.university_deleteUniversity(schoolName);
  }
  /**
   * Activates a user.
   * @param username the user to deactivate.
   * @return An account object with the user's information.
   */
  public void activateUser(String username)
  {
		Account acc = null;
	    String[][] array = univDBlib.user_getUsers();
	    int len = array.length;
	    for(int i = 0; i<len ;i++)
	    {
	      
	      if(array[i][2].equals(username))
	      {
	        String password= array[i][3];
	        String firstName= array[i][0];
	        String lastName = array[i][1];
	        char type = 'u';
	        char status = 'Y';
	        setUserInfo(firstName, lastName, username, password, type, status);
	        
	      }
	    }
  }
  /**
   * Deactivates a user.
   * @param username the user to deactivate.
   * @return An account object with the user's information.
   * @throws IllegalArgumentException if username is invalid
   */
  public void deactivateUser(String username) throws IllegalArgumentException
  {
	boolean found = false;
    String[][] array = univDBlib.user_getUsers();
    int len = array.length;
    for(int i = 0; i<len ;i++)
    {
      
      if(array[i][2].equals(username))
      {
    	found = true;
        String password= array[i][3];
        String firstName= array[i][0];
        String lastName = array[i][1];
        char type = 'u';
        char status = 'N';
        setUserInfo(firstName, lastName, username, password, type, status);
        
      }
    }
    if(!found) {
    	throw new IllegalArgumentException();
    }
  }
  /**
   * Gets the information for all users.
   * @return An ArrayList<Account> with the users information.
   */
  public ArrayList<Account> getListOfUsers()
  {
    String[][] array = univDBlib.user_getUsers();
    //System.out.println(array[0][0]);
    ArrayList<Account> userArray = new ArrayList<Account>();
    for(int i =0; i<array.length;i++)
    {
    Account user = returnUser(array[i][0],array[i][1],array[i][2],array[i][3],array[i][4].charAt(0),array[i][5].charAt(0));
    userArray.add(user);
    }
    return userArray;
  }
  
  /**
   * Finds similar schools.
   * 
   * @param mainUniversity the result clicked on to find similar schools to
   * 
   * @return an ArrayList containing the 5 nearest universities
   */
  public ArrayList<University> findSimilarSchools(University mainUniversity)
  {
    String[][] schoolArray = univDBlib.university_getUniversities();
    String[][] emphasisArray = univDBlib.university_getUniversities();
    ArrayList<String> mainEmphasis = new ArrayList<>();
    for(int i = 0; i < emphasisArray.length; i++)
    {
      if(emphasisArray[i][0].equals(mainUniversity.getSchoolName()))
        mainEmphasis.add(emphasisArray[i][1]);
    }
    double[][] distanceArray = new double[5][2];
    int sizeOfDistanceArray = 0;
    
    double maxStudent = Double.NEGATIVE_INFINITY;
    double minStudent = Double.POSITIVE_INFINITY;
    double minSatVerbal = Double.POSITIVE_INFINITY;
    double minSatMath = Double.POSITIVE_INFINITY;
    double maxExpenses = Double.NEGATIVE_INFINITY;
    double minExpenses = Double.POSITIVE_INFINITY;
    int maxApplicants = Integer.MIN_VALUE;
    int minApplicants = Integer.MAX_VALUE;
    
    for(int a = 0; a<schoolArray.length; a++)
    {
      if(maxStudent < Integer.parseInt(schoolArray[a][4]))
      {
        maxStudent = Integer.parseInt(schoolArray[a][4]);
      }
      else if(minStudent > Integer.parseInt(schoolArray[a][4]))
      {
        minStudent = Integer.parseInt(schoolArray[a][4]);
      }
      if(minSatVerbal > Double.parseDouble(schoolArray[a][6]))
      {
        minSatVerbal = Double.parseDouble(schoolArray[a][6]);
      }
      if(minSatMath > Double.parseDouble(schoolArray[a][7]))
      {
        minSatMath = Double.parseDouble(schoolArray[a][7]);
      }
      if(maxExpenses < Double.parseDouble(schoolArray[a][8]))
      {
        maxExpenses =  Double.parseDouble(schoolArray[a][8]);
      }
      else if(minExpenses > Double.parseDouble(schoolArray[a][8]))
      {
        minExpenses =  Double.parseDouble(schoolArray[a][8]);
      }
      if(maxApplicants < Integer.parseInt(schoolArray[a][10]))
      {
        maxApplicants =  Integer.parseInt(schoolArray[a][10]);
      }
      else if(minApplicants > Integer.parseInt(schoolArray[a][10]))
      {
        minApplicants =  Integer.parseInt(schoolArray[a][10]);
      }
    }
    
    for(int i = 0; i < schoolArray.length; i++)
    {
      if(!schoolArray[i][0].equals(mainUniversity.getSchoolName()))
      {
        double distance = 1; // We know the name will not match and its a string so minimum starting is 1
        
        if(!schoolArray[i][1].equals(mainUniversity.getState()))
        {
          distance++;
        }
        if(!schoolArray[i][2].equals(mainUniversity.getLocation()))
        {
          distance++;
        }
        if(!schoolArray[i][3].equals(mainUniversity.getControl()))
        {
          distance++;
        }
        if(Integer.parseInt(schoolArray[i][4]) != mainUniversity.getNumStudents())
        {
          distance = distance + Math.abs(Integer.parseInt(schoolArray[i][4]) - mainUniversity.getNumStudents()) 
            / (maxStudent-minStudent);
        }
        if(Double.parseDouble(schoolArray[i][5]) != mainUniversity.getPercentFemale())
        {
          distance = distance + Math.abs(Double.parseDouble(schoolArray[i][5]) - mainUniversity.getPercentFemale())
            / 100; // between 0 and 100
        }
        if(Double.parseDouble(schoolArray[i][6]) != mainUniversity.getSatVerbal())
        {
          distance = distance + Math.abs(Double.parseDouble(schoolArray[i][6]) - mainUniversity.getSatVerbal())
            / (800 - minSatVerbal); // up to 800
        }
        if(Double.parseDouble(schoolArray[i][7]) != mainUniversity.getSatMath())
        {
          distance = distance + Math.abs(Double.parseDouble(schoolArray[i][7]) - mainUniversity.getSatMath())
            / (800 - minSatMath); // up to 800
        }
        if(Double.parseDouble(schoolArray[i][8]) != mainUniversity.getTuition())
        {
          distance = distance + Math.abs(Double.parseDouble(schoolArray[i][8]) - mainUniversity.getTuition())
            / (maxExpenses - minExpenses);
        }
        if(Double.parseDouble(schoolArray[i][9]) != mainUniversity.getPercentRecFinAid())
        {
          distance = distance + Math.abs(Double.parseDouble(schoolArray[i][9]) - mainUniversity.getPercentRecFinAid())
            / 100; //between 0 and 100
        }
        if(Integer.parseInt(schoolArray[i][10]) != mainUniversity.getNumApplicants())
        {
          distance = distance + Math.abs(Integer.parseInt(schoolArray[i][10]) - mainUniversity.getNumApplicants())
            / (maxApplicants - minApplicants);
        }
        if(Double.parseDouble(schoolArray[i][11]) != mainUniversity.getPercentAccepted())
        {
          distance = distance + Math.abs(Double.parseDouble(schoolArray[i][11]) - mainUniversity.getPercentAccepted())
            / 100; //between 0 and 100
        }
        if(Double.parseDouble(schoolArray[i][12]) != mainUniversity.getPercentEnroll())
        {
          distance = distance + Math.abs(Double.parseDouble(schoolArray[i][12]) - mainUniversity.getPercentEnroll())
            / 100; //between 0 and 100
        }
        if(Integer.parseInt(schoolArray[i][13]) != mainUniversity.getAcademicScale())
        {
          distance = distance + Math.abs(Integer.parseInt(schoolArray[i][13]) - mainUniversity.getAcademicScale())
            / 4; //between 1 and 5
        }
        if(Integer.parseInt(schoolArray[i][14]) != mainUniversity.getSocial())
        {
          distance = distance + Math.abs(Integer.parseInt(schoolArray[i][14]) - mainUniversity.getSocial())
            / 4; //between 1 and 5
        }
        if(Integer.parseInt(schoolArray[i][15]) != mainUniversity.getQualOfLife())
        {
          distance = distance + Math.abs(Integer.parseInt(schoolArray[i][15]) - mainUniversity.getQualOfLife())
            / 4; //between 1 and 5
        }
        
        ArrayList<String> tempEmphasis = new ArrayList<>();
        for(int z = 0; z < emphasisArray.length; z++)
        {
          if(emphasisArray[z][0].equals(schoolArray[i][0]))
            tempEmphasis.add(emphasisArray[z][1]);
        }
        for(int z = 0; z < mainEmphasis.size(); z++)
        {
          if(!tempEmphasis.contains(mainEmphasis.get(z)))
            distance += 1;
        }
        if(tempEmphasis.size() - mainEmphasis.size() != 0)
          distance = distance + Math.abs(tempEmphasis.size() - mainEmphasis.size());
        
        
        if(sizeOfDistanceArray < 5)
        {
          distanceArray[sizeOfDistanceArray][0] = distance;
          distanceArray[sizeOfDistanceArray][1] = i;
          for(int j = 0; j<sizeOfDistanceArray-1; j++)
          {
           for(int k = 0; k<sizeOfDistanceArray-j-1;k++)
           {
            
           
            if(distanceArray[k][0] > distanceArray[k+1][0])
            {
              double tempDistance = distanceArray[k][0];
              double spot = distanceArray[k][1];
              distanceArray[k][0] = distanceArray[k+1][0];
              distanceArray[k][1] = distanceArray[k+1][1];
              distanceArray[k+1][0] = tempDistance;
              distanceArray[k+1][1] = spot;
            }
           }
          }
          sizeOfDistanceArray++;
        }
        else
        {
          if(distanceArray[4][0] > distance)
          {
            distanceArray[4][0] = distance;
            distanceArray[4][1] = i;
            for(int j = 0; j<4; j++)
            {

             for(int k = 0; k<4-j;k++)
             {
              
             
               if(distanceArray[k][0] > distanceArray[k+1][0])
               {
                 double tempDistance = distanceArray[k][0];
                 double spot = distanceArray[k][1];
                 distanceArray[k][0] = distanceArray[k+1][0];
                 distanceArray[k][1] = distanceArray[k+1][1];
                 distanceArray[k+1][0] = tempDistance;
                 distanceArray[k+1][1] = spot;
               }
             }

            }
          }
        }
      }
    }
    ArrayList<University> nearSchools = new ArrayList<>();
    for(int i = 0; i<5; i++)
    {
      int loc = (int)distanceArray[i][1];
      nearSchools.add(new University(schoolArray[loc][0],schoolArray[loc][1],schoolArray[loc][2],schoolArray[loc][3],
                                     Integer.parseInt(schoolArray[loc][4]),Double.parseDouble(schoolArray[loc][5]),
                                     Double.parseDouble(schoolArray[loc][6]),Double.parseDouble(schoolArray[loc][7]),
                                     Double.parseDouble(schoolArray[loc][8]),Double.parseDouble(schoolArray[loc][9]),
                                     Integer.parseInt(schoolArray[loc][10]),Double.parseDouble(schoolArray[loc][11]),
                                     Double.parseDouble(schoolArray[loc][12]),Integer.parseInt(schoolArray[loc][13]),
                                     Integer.parseInt(schoolArray[loc][14]),Integer.parseInt(schoolArray[loc][15]),
                                     "","","","",""));
    }
    return nearSchools;
  }
  
  /**
   * Removes a school from a users profile.
   * @param schoolName school to remove
   * @param username the user
   * @return boolean true if removed.
   */
  public boolean removeSchool(String schoolName, String username)
  {
    String[][] array = univDBlib.user_getUsernamesWithSavedSchools();
    boolean bool = false;
    if(array == null)
      return bool;
    else {
      for(int i = 0;i<array.length;i++)
      {
        if(array[i][0].equals(username))
        {
          int len2 = array[i].length;
          for(int j = 1; j<len2;j++)
          {
            if(array[i][j].equals(schoolName))
            {
              bool = true; 
            }
          }
        }
        if(bool)
        {
          univDBlib.user_removeSchool(username, schoolName);
        }
      }
      return bool;
    }
  }
  /**
   * Adds a school to a user's list.
   * @param school the school to add
   * @param username the user's name.
   */
//  public boolean addSchoolToUserList(String school, String username)
//  {  
//    ArrayList<String> list = getUserSchools(username);
//    boolean bool = false;
//    for(int i = 0 ; i<list.size();i++)
//    {
//      if(school.equals(list.get(i)))
//      {
//        bool = true;
//      }
//    }
//    if(bool == false)
//    {
//      univDBlib.user_saveSchool(username, school);
//    }
//    return bool;
//  }
  /**
   * Gets a list of a user's schools.
   * @param username the user's name.
   * @return list an ArrayList<String> of the school name's.
 * @throws Exception 
   */
  public ArrayList<String> getUserSchools(String username) throws Exception
  {
    String[][] array = univDBlib.user_getUsernamesWithSavedSchools();
    
    boolean found = false;
    ArrayList<String> list = new ArrayList<String>();
    if(array == null)
      return list;
    else
    {
      int len = array.length;
      for(int i = 0; i<len ;i++)
      {
        
        if(array[i][0].equals(username))
        {
          found = true;
          int len2 = array[i].length;
          for(int j = 1; j<len2;j++)
          {
            list.add(array[i][j]);
          }
          
        }
      }

      if(!found)
      {
    	  throw new Exception("THIS USER DOES NOT EXIST");
      }
      return list;
    }
  }
  
  /**
   * Search
   * @param schoolName Name of the school to search for.
   * @param stateName Name of the state for schools.
   * @param location Location area of a school.
   * @param control Private State or City control.
   * @param lowNumberOfStudents Lower limit for student population.
   * @param upNumberOfStudents Upper limit for student population.
   * @param lowPercentFemale Lower limit for Percent Female.
   * @param upPercentFemale Upper limit for Percent Female.
   * @param lowSATVerbal Lower limit for SATVerbal.
   * @param upSATVerbal Upper limit for SATVerbal.
   * @param lowSATMath Lower limit for SATMath.
   * @param upSATMath Upper limit for SATMath.
   * @param lowExpenses Lower limit for Expenses.
   * @param upExpenses Upper limit for Expenses.
   * @param lowPercentEnrolled Lower limit for Percent Enrolled.
   * @param upPercentEnrolled Upper limit for Percent Enrolled.
   * @param lowAcademicsScale Lower limit for Academics Scale.
   * @param upAcademicsScale Upper limit for Academics Scale.
   * @param lowSocialScale Lower limit for Social Scale.
   * @param upSocialScale Upper limit for Social Scale.
   * @param lowQualityOfLifeScale Lower limit for Quality Of Life Scale.
   * @param upQualityOfLifeScale Upper limit for Quality Of Life Scale.
   * @return ArrayList<University> with all the schools information in the database.
   * @throws Exception 
   */
  public ArrayList<University> searchTwo(String schoolName, String stateName, String location, String control,
                           int lowNumberOfStudents, int upNumberOfStudents,  
                           double lowPercentFemale, double upPercentFemale, 
                           double lowSATVerbal, double upSATVerbal,
                           double lowSATMath, double upSATMath,
                           double lowExpenses, double upExpenses,
                           double lowPercentRecFinAid, double upPercentRecFinAid,
                           int lowNumApplicants, int upNumApplicants,
                           double lowPercentAccepted, double upPercentAccepted,
                           double lowPercentEnrolled, double upPercentEnrolled,
                           
                           int lowAcademicsScale, int upAcademicsScale,
                           int lowSocialScale, int upSocialScale,
                           int lowQualityOfLifeScale, int upQualityOfLifeScale,
                           String emphases1,String emphases2,String emphases3,
                           String emphases4,String emphases5) throws Exception
  {
   String[][] array = univDBlib.university_getUniversities();
   String[][] arrayEmphases = univDBlib.university_getNamesWithEmphases();
   ArrayList<University> result = new ArrayList<University>();
   int total = 0;

    if(!schoolName.equals("!"))
     total++; 
    if(!stateName.equals("!"))
     total++;
    if(!location.equals("!"))
     total++;
    if(!control.equals("!"))
     total++;
    if(lowNumberOfStudents != -1)
     total++;
    if(lowPercentFemale != -1)
     total++;  
    if(lowSATVerbal != -1)
     total++;
    if(lowSATMath != -1)
     total++;
    if(lowExpenses != -1)
     total++;
    if(lowPercentRecFinAid != -1)
     total++;
    if(lowNumApplicants != -1)
     total++;
    if(lowPercentAccepted != -1)
     total++;
    if(lowPercentEnrolled != -1)
     total++;
    if(lowAcademicsScale != -1)
     total++;
    if(lowSocialScale != -1)
     total++;
    if(lowQualityOfLifeScale != -1)
     total++;
    if(!emphases1.equals("!"))
     total++;
    if(!emphases2.equals("!"))
     total++;
    if(!emphases3.equals("!"))
     total++;
    if(!emphases4.equals("!"))
     total++;
    if(!emphases5.equals("!"))
     total++;


	
		  
	  for(int i = 0; i <array.length; i++) 
	  {
		  int searchTotal = 0;
		  if(!schoolName.equals("!"))
			  if(array[i][0].indexOf(schoolName)>=0)
				  searchTotal++;
		  if(!stateName.equals("!"))
			  if(array[i][1].indexOf(stateName)>=0)
				  searchTotal++;
		  if(!location.equals("!"))
			  if(array[i][2].equals(location))
				  searchTotal++;
		  if(!control.equals("!"))
			  if(array[i][3].indexOf(control)>=0)
				  searchTotal++;
		  if(lowNumberOfStudents != -1)
			  if(lowNumberOfStudents < Integer.parseInt(array[i][4]) && upNumberOfStudents > Integer.parseInt(array[i][4]))
				  searchTotal++;
		  if(lowPercentFemale != -1)
			  if(lowPercentFemale < Double.parseDouble(array[i][5]) && upPercentFemale > Double.parseDouble(array[i][5]))
				  searchTotal++;  
		  if(lowSATVerbal != -1)
			  if(lowSATVerbal < Double.parseDouble(array[i][6]) && upSATVerbal > Double.parseDouble(array[i][6]))
				  searchTotal++;
		  if(lowSATMath != -1)
			  if(lowSATMath < Double.parseDouble(array[i][7]) && upSATMath > Double.parseDouble(array[i][7]))
				  searchTotal++;
		  if(lowExpenses != -1)
			  if(lowExpenses < Double.parseDouble(array[i][8]) && upExpenses > Double.parseDouble(array[i][8]))
				  searchTotal++;
		  if(lowPercentRecFinAid != -1)
			  if(lowPercentRecFinAid < Double.parseDouble(array[i][9]) && upPercentRecFinAid > Double.parseDouble(array[i][9]))
				  searchTotal++;
		  if(lowNumApplicants != -1)
			  if(lowNumApplicants < Double.parseDouble(array[i][10]) && upNumApplicants > Double.parseDouble(array[i][10]))
				  searchTotal++;
		  if(lowPercentAccepted != -1)
			  if(lowPercentAccepted < Double.parseDouble(array[i][11]) && upPercentAccepted > Double.parseDouble(array[i][11]))
				  searchTotal++;
		  if(lowPercentEnrolled != -1)
			  if(lowPercentEnrolled < Double.parseDouble(array[i][12]) && upPercentEnrolled > Double.parseDouble(array[i][12]))
				  searchTotal++;
		  if(lowAcademicsScale != -1)
			  if(lowAcademicsScale < Integer.parseInt(array[i][13]) && upAcademicsScale > Integer.parseInt(array[i][13]))
				  searchTotal++;
		  if(lowSocialScale != -1)
			  if(lowSocialScale < Integer.parseInt(array[i][14]) && upSocialScale > Integer.parseInt(array[i][14]))
				  searchTotal++;
		  if(lowQualityOfLifeScale != -1)
			  if(lowQualityOfLifeScale < Integer.parseInt(array[i][15]) && upQualityOfLifeScale > Integer.parseInt(array[i][15]))
				  searchTotal++;
		  ArrayList<String> temps = new ArrayList<String>();
		  
		  for(int j = 0; j <arrayEmphases.length; j++)
		  {

			  if(arrayEmphases[j][0].equals(array[i][0]))
			  {
				  
				  if(!emphases1.equals("!"))
				  {
					  if(emphases1.equals(arrayEmphases[j][1]))
					  {
						  temps.add(arrayEmphases[j][1]);
						  searchTotal++;
					  }
				  }
		  
				  if(!emphases2.equals("!"))
				  {
					  if(emphases2.equals(arrayEmphases[j][1]))
					  {
						  temps.add(arrayEmphases[j][1]);
						  searchTotal++;
					  }
				  }
				  if(!emphases3.equals("!"))
				  {
					  if(emphases3.equals(arrayEmphases[j][1]))
					  {
						  temps.add(arrayEmphases[j][1]);
						  searchTotal++;
					  }
				  }
				  if(!emphases4.equals("!"))
				  {
					  if(emphases4.equals(arrayEmphases[j][1]))
					  {
						  temps.add(arrayEmphases[j][1]);
						  searchTotal++;
					  }
				  }
				  if(!emphases5.equals("!"))
				  {
					  if(emphases5.equals(arrayEmphases[j][1]))
					  {
						  temps.add(arrayEmphases[j][1]);
						  searchTotal++;
					  }
				  }
			  }
		  }
		  if(searchTotal == total)
		  {
			  	String  emp1;
			  	String  emp2;
			  	String  emp3;
			  	String  emp4;
			  	String  emp5;
	            if(temps.size() == 5)
	            {
	             emp1 = temps.get(0);
	             emp2 = temps.get(1);
	             emp3 = temps.get(2);
	             emp4 = temps.get(3);
	             emp5 = temps.get(4);
	             
	            }
	            else if(temps.size() == 4)
	            {
	             emp1 = temps.get(0);
	             emp2 = temps.get(1);
	             emp3 = temps.get(2);
	             emp4 = temps.get(3);
	             emp5 = "";
	             
	            }
	            else if(temps.size() == 3)
	            {
	             emp1 = temps.get(0);
	             emp2 = temps.get(1);
	             emp3 = temps.get(2);
	             emp4 = "";
	             emp5 = "";
	             
	            }
	            else if(temps.size() == 2)
	            {
	             emp1 = temps.get(0);
	             emp2 = temps.get(1);
	             emp3 = "";
	             emp4 = "";
	             emp5 = "";
	             
	            }
	            else if(temps.size() == 1)
	            {
	             emp1 = temps.get(0);
	             emp2 = "";
	             emp3 = "";
	             emp4 = "";
	             emp5 = "";
	             
	            }
	            else {
	             
	             emp1 = "";
	             emp2 = "";
	             emp3 = "";
	             emp4 = "";
	             emp5 = "";
	            }
	            if(searchTotal != 0) {
		        University u = returnUniversity(array[i][0], //schoolName
		                array[i][1], //State
		                array[i][2],//location
		                array[i][3],//control
		                Integer.parseInt(array[i][4]),// numStudents
		                Double.parseDouble(array[i][5]),//%Female
		                Double.parseDouble(array[i][6])//// SATVerbal
		               ,Double.parseDouble(array[i][7]),//SATMath
		                Double.parseDouble(array[i][8]),//Expenses
		                Double.parseDouble(array[i][9]),// percentFinancialAid
		                Integer.parseInt(array[i][10]),// numberofApps
		                Integer.parseInt(array[i][11])// percent admitted
		               ,Integer.parseInt(array[i][12]), //percentEnrolled
		                Integer.parseInt(array[i][13]), //academicsScale
		                Integer.parseInt(array[i][14]), // social scale
		                Integer.parseInt(array[i][15]), //qualoflife
		                emp1,emp2,emp3,emp4,emp5);
		        result.add(u);
		        System.out.println("\tName: " + u.getSchoolName()+"\n\tState: " +
		                u.getState()+"\n\tLocation: " + u.getLocation()+"\n\tControl: " + u.getControl()+ "\n\tNumber of Students: " +
		                u.getNumStudents()+ "\n\t% Female: "+ u.getPercentFemale() + "\n\tSAT Verbal: " + u.getSatVerbal() + 
		                "\n\tSAT Math: " + u.getSatMath()+ "\n\tTuition: " + u.getTuition()+ "\n\t% Receiving Financial Aid: " + 
		                u.getPercentRecFinAid()+"\n\tNumber of Applications: " + u.getNumApplicants()+ "\n\t% Accepted: " + 
		                u.getPercentAccepted()+ "\n\t% Enrolled: " + u.getPercentEnroll()  + "\n\tAcademic Scale: " +
		                u.getAcademicScale() +"\n\tSocial Rating: "+ u.getSocial()+ "\n\tQuality of Life: " + u.getQualOfLife() +
		                "\n\tStudy Area 1: " + u.getStudyArea1()+"\n\tStudy Area 2: " + u.getStudyArea2()+"\n\tStudy Area 3: " + 
		                u.getStudyArea3()+"\n\tStudy Area 4: "  + u.getStudyArea4()+"\n\tStudy Area 5: " + u.getStudyArea5());
	            }
		  }
		  searchTotal = 0;
		 
	  }
	  
	  if(result.isEmpty()) {
		  throw new Exception("No Search results");
	  }
	  
	  
	  
	  return result;
  }
  

  /**
   * Reads a schools information into a University Object.
   * 
   * 
   * @param schoolName Name of the school to search for.
   * @param stateName Name of the state for schools.
   * @param location Location area of a school.
   * @param control Private State or City control.
   * @param numberOfStudents Lower limit for student population.
   * @param percentFemale Lower limit for Percent Female.
   * @param SATVerbal Lower limit for SATVerbal.
   * @param expenses Lower limit for Expenses.
   * @param percentEnrolled Lower limit for Percent Enrolled.
   * @param academicsScale Lower limit for Academics Scale.
   * @param socialScale Lower limit for Social Scale.
   * @param qualityOfLifeScale Lower limit for Quality Of Life Scale.
   * 
   * 
   * @return university A university.
   */
  public University returnUniversity(String schoolName,String state,String location, String control, int numStudents,

                                          double percentFemale, double satVerbal,double satMath, double expenses, double percentRecFinAid,

                                          int numApplicants, double percentAccepted, double percentEnroll, int academicScale, int social,

                                          int qualOfLife, String studyArea1,String studyArea2,String studyArea3,String studyArea4, 

                                          String studyArea5)
  {
   University university = new University( schoolName, state, location,  control,  numStudents,

                                           percentFemale,  satVerbal, satMath,  expenses,  percentRecFinAid,

                                           numApplicants,  percentAccepted,  percentEnroll,  academicScale,  social,

                                           qualOfLife,  studyArea1, studyArea2, studyArea3, studyArea4, 

                                           studyArea5);
  return university;
  }
  
  
  /**
   * 
   * @param firstName
   * @param lastName
   * @param username
   * @param password
   * @param accountType
   * @param status
   * @return An account object with the users information.
   */
  public Account returnUser(String firstName, String lastName, String username, String password, char accountType, char status)
  {
  Account user = new Account(firstName, lastName, username, password, accountType, status);  
  return user;
  }
  
  
  
  public static void main(String[] args)
  {
    try{
      DBController databasecontroller = new DBController("notfal", "csci230");
      University u = databasecontroller.getSchoolInfo("UNIVERSITY OF MINNESOTA");
      String[][] info = databasecontroller.univDBlib.university_getNamesWithEmphases();
      ArrayList<String> emphases = new ArrayList<String>();
      for(int i = 0; i < info.length; i ++)
      {
    	  if(!emphases.contains(info[i][1]))
    		  emphases.add(info[i][1]);
   
      }
      for(int j = 0; j < emphases.size();j++)
      {
    	  System.out.println(emphases.get(j));
    	  
      }
      
      //databasecontroller.getUnivDBlib().university_deleteUniversity("Temp School");
      //databasecontroller.getUnivDBlib().user_deleteUser("trevor");

      //String[][] array = databasecontroller.getUnivDBlib().user_getUsers();

//      for(int i = 0; i < array.length; i++)
//      {
//        for(int j = 0; j<array[i].length; j++)
//        {
//          System.out.println(array[i][j]);
//        }
//      }
      //String message = "";
      //String[][] arrayEmphases = databasecontroller.getUnivDBlib().university_getNamesWithEmphases();
//      for(int k = 0; k < arrayEmphases.length; k++)
//      {
//        for(int l = 0; l<arrayEmphases[k].length; l++)
//        {
//          message = message + " " +arrayEmphases[k][l];
//        }
//        System.out.println(message);
//        message = "";
//      }
    }
    catch(Exception e){
      e.printStackTrace();
    }
    
  }
  
  public void deleteUser(String username)
  {
	  univDBlib.user_deleteUser(username);
  }
  
  public void deleteSchool(String name)
  {
	  univDBlib.university_deleteUniversity(name);
  }
}