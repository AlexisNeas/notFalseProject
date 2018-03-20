package DatabaseController;
import java.util.ArrayList;

import University.University;
import University.UniversityController;
import User.*;
import dblibrary.project.csci230.*;

/**
 * Manages the Database.
 * 
 * @author Trevor Wensman
 * @version 2/25/18
 */
public class DBController 
{
  // The Database library
  private UniversityDBLibrary univDBlib;
  //private University university;
  private UniversityController universityController;
  
  // Contructs the database library for use in the DB Controller
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
   * Gets a specifed user from the database.
   * 
   * @param username the username of the desired user.
   * 
   * @return
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
   * @return the schools.
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
   * 
   */
  public void addNewUser(User user)
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
  }
  /**
   * Adds a new school to the database.
   * @param University a University object containing the information for the school.
   * 
   */
  public void addNewSchool(University univ)
  {
    univDBlib.university_addUniversity(univ.getSchoolName(), univ.getState(), univ.getLocation(), 
            univ.getControl(),  univ.getNumStudents(),  univ.getPercentFemale(), 
            univ.getSatVerbal(),  univ.getSatMath(),  univ.getTuition(),  univ.getPercentRecFinAid(),
            univ.getNumApplicants(),  univ.getPercentAccepted(), 
            univ.getPercentEnroll(),  univ.getAcademicScale(),  univ.getSocial(),  univ.getQualOfLife());
  }
  /**
   * Sets a current Schools information.
   * @param University a University object containing the information for the school.
   * 
   */
  public void setSchoolInformation(University univ)
  {
    univDBlib.university_editUniversity(univ.getSchoolName(), univ.getState(), univ.getLocation(), 
                                        univ.getControl(),  univ.getNumStudents(),  univ.getPercentFemale(), 
                                        univ.getSatVerbal(),  univ.getSatMath(),  univ.getTuition(),  univ.getPercentRecFinAid(),
                                        univ.getNumApplicants(),  univ.getPercentAccepted(), 
                                        univ.getPercentEnroll(),  univ.getAcademicScale(),  univ.getSocial(),  univ.getQualOfLife());
  }
  
  /**
   * Sets a current users information
   * @param firstName the first name
   * @param lastName the last name
   * @param username the username.
   * @param password the user's password
   * @param type type of user
   * @param status status of the user
   * 
   */
  public Account setUserInfo(String firstName, String lastName, String username, String password, char type, char status)
  {
 Account acc = null;

      univDBlib.user_editUser(username , firstName, lastName, 
                              password, type, status);
      acc = returnUser(firstName,lastName,username,password,type,status);
      
    
    return acc;
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
             
             emp1 = " ";
             emp2 = " ";
             emp3 = " ";
             emp4 = " ";
             emp5 = " ";
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
  public void userSaveSchool(String username,String schoolName)
  {
    univDBlib.user_saveSchool(username, schoolName);
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
      if(array[i][0].equals(username))
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
   * Deactivates a user.
   * @param username the user to deactivate.
   */
  public Account deactivateUser(String username)
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
        char status = 'N';
        acc = setUserInfo(firstName, lastName, username, password, type, status);
        
      }
    }
    return acc;
  }
  /**
   * Gets the information for all users.
   * @return the user's information.
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
   */
  public ArrayList<University> findSimilarSchools(String schoolName, String stateName, String location, String control,
                                       int numberOfStudents,  double percentFemale, 
                                       double SATVerbal, double SATMath, double expenses, double percentEnrolled, 
                                       int academicsScale, int socialScale, int qualityOfLifeScale, String emphases1,
                                       String emphases2, String emphases3, String emphases4, String emphases5)
  {
    double maxStudent = 0;
    double minStudent = 0;
    double maxFemale = 0;
    double minFemale = 0;
    double maxSATVerbal = 0;
    double minSATVerbal = 0;
    double maxSATMath = 0;
    double minSATMath = 0;
    double maxExpenses = 0;
    double minExpenses = 0;
    double maxPercentEnrolled  = 0;
    double minPercentEnrolled  = 0;
    int maxAcademicsScale = 0;
    int minAcademicsScale = 0;
    int maxSocialScale = 0;
    int minSocialScale = 0;
    int maxQualityOfLifeScale = 0;
    int minQualityOfLifeScale = 0;
    String[][] array = univDBlib.university_getUniversities();
    int len1 = array.length;
    int len2 = array[0].length;
    //University Emphasis'
    String[][] arrayEmphases = univDBlib.university_getNamesWithEmphases();
    String[][] schools = new String[5][len2];
    Double[][] temp = new Double[len1][2];
    
    
    

    
    //University Search
    for(int a = 0; a<array.length; a++)
    {
      if(maxStudent < Integer.parseInt(array[a][4]))
      {
        maxStudent = Integer.parseInt(array[a][4]);
      }
      else if(minStudent > Integer.parseInt(array[a][4]))
      {
        minStudent = Integer.parseInt(array[a][4]);
      }
      
      
      if(maxFemale < Double.parseDouble(array[a][5]))
      {
        maxFemale = Double.parseDouble(array[a][5]);
      }
      else if(minFemale > Double.parseDouble(array[a][5]))
      {
        minFemale = Double.parseDouble(array[a][5]);
      }
      
      
      
      if(maxSATVerbal< Double.parseDouble(array[a][6]))
      {
        maxSATVerbal =  Double.parseDouble(array[a][6]);
      }
      else if(minSATVerbal > Double.parseDouble(array[a][6]))
      {
        minSATVerbal =  Double.parseDouble(array[a][6]);
      }
      
      
      if(maxSATMath < Double.parseDouble(array[a][7]))
      {
        maxSATMath =  Double.parseDouble(array[a][7]);
      }
      else if(minSATMath > Double.parseDouble(array[a][7]))
      {
        minSATMath =  Double.parseDouble(array[a][7]);
      }
      
      
      if(maxExpenses < Double.parseDouble(array[a][8]))
      {
        maxExpenses =  Double.parseDouble(array[a][8]);
      }
      else if(minExpenses > Double.parseDouble(array[a][8]))
      {
        minExpenses =  Double.parseDouble(array[a][8]);
      }
      
      
      if(maxPercentEnrolled < Double.parseDouble(array[a][9]))
      {
        maxPercentEnrolled =  Double.parseDouble(array[a][9]);
      }
      else if(minPercentEnrolled > Double.parseDouble(array[a][9]))
      {
        minPercentEnrolled =  Double.parseDouble(array[a][9]);
      }
      
      
      if(maxAcademicsScale < Integer.parseInt(array[a][10]))
      {
        maxAcademicsScale =  Integer.parseInt(array[a][10]);
      }
      else if(minAcademicsScale > Integer.parseInt(array[a][10]))
      {
        minAcademicsScale =  Integer.parseInt(array[a][10]);
      }
      
      
      if(maxSocialScale < Integer.parseInt(array[a][11]))
      {
        maxSocialScale =  Integer.parseInt(array[a][11]);
      }
      else if(minSocialScale > Integer.parseInt(array[a][11]))
      {
        minSocialScale =  Integer.parseInt(array[a][11]);
      }
      
      
      if(maxQualityOfLifeScale < Integer.parseInt(array[a][12]))
      {
        maxQualityOfLifeScale =  Integer.parseInt(array[a][12]);
      }
      else if(minQualityOfLifeScale > Integer.parseInt(array[a][12]))
      {
        minQualityOfLifeScale =  Integer.parseInt(array[a][12]);
      }
      
    }
    

    
    
    
    
    
    
    
    double v = 0;
    for(int i = 0; i<array.length; i++)
    {
      if(schoolName.equals(array[i][0]))
      {
        
      }
      else
      {
        v+=1;
      }
      
      
      
      if(stateName.equals(array[i][1]))
      {
        
      }
      else
      {
        v +=1;
      }
      
      if(location.equals(array[i][2]))
      {
        
      }
      else
      {
        v+=1; 
      }
      
      
      if(control.equals(array[i][3]))
      {
        
      }
      else
      {
        v+=1; 
      }
      
      
      //Emphases Search
      for(int aa = 0; aa<array.length; aa++)
      {
       if(arrayEmphases[i][0].contentEquals(schoolName))
       {
        if(arrayEmphases[i][1].contentEquals(emphases1))
        {
         
        }
        else {
         v+=1;
        }
        if(arrayEmphases[i][2].contentEquals(emphases2))
        {
         
        }
        else {
         v+=1;
        }
        if(arrayEmphases[i][3].contentEquals(emphases3))
        {
         
        }
        else {
         v+=1;
        }
        if(arrayEmphases[i][4].contentEquals(emphases4))
        {
         
        }
        else {
         v+=1;
        }
        if(arrayEmphases[i][5].contentEquals(emphases5))
        {
         
        }
        else {
         v+=1;
        }
       }
      }
      double studentVector = Math.abs(numberOfStudents - Double.parseDouble(array[i][4])) / Math.abs(maxStudent - minStudent);
      double femaleVector = Math.abs(percentFemale - Double.parseDouble(array[i][5])) /  Math.abs(maxFemale - minFemale);
      double SATVerbalVector = Math.abs(SATVerbal - Double.parseDouble(array[i][6])) /  Math.abs(maxSATVerbal - minSATVerbal);
      double SATMathVector = Math.abs(SATMath - Double.parseDouble(array[i][7])) /  Math.abs(maxSATMath - minSATMath);     
      double ExpensesVector = Math.abs(expenses - Double.parseDouble(array[i][8])) /  Math.abs(maxExpenses - minExpenses);      
      double PercentEnrolledVector  = Math.abs(percentEnrolled - Double.parseDouble(array[i][9])) /  Math.abs(maxPercentEnrolled - minPercentEnrolled);    
      double AcademicsScaleVector = Math.abs(academicsScale - Double.parseDouble(array[i][10])) /  Math.abs(maxAcademicsScale - minAcademicsScale);      
      double SocialScaleVector = Math.abs(socialScale - Double.parseDouble(array[i][11])) /  Math.abs(maxSocialScale - minSocialScale);   
      double QualityOfLifeScaleVector = Math.abs(qualityOfLifeScale - Double.parseDouble(array[i][12])) /  Math.abs(maxQualityOfLifeScale - minQualityOfLifeScale);
      double total = v + studentVector + femaleVector + SATVerbalVector + SATMathVector + ExpensesVector + PercentEnrolledVector + AcademicsScaleVector + SocialScaleVector + QualityOfLifeScaleVector;
      temp[i][0] = i + 0.0;//Adds position of the school in the list.
      temp[i][1] = v + total;//The 'score' the received based on the algorithm.
      
      
      //Need to sort.
      //Then add to the schools array to return the top 5 schools.
      v = 0;
    }
    for(int q = 0; q < temp.length; q++)//FIX SORT?
    {
      if(temp[q][1] > temp[q+1][1])
      {
        double tempI = temp[q][0];
        double tempV = temp[q][1];
        temp[q][0] = temp[q+1][0];
        temp[q][1] = temp[q+1][1];
        temp[q+1][0] = tempI;
        temp[q+1][1] = tempV;
      }
    }
    String emp1,emp2,emp3,emp4,emp5;
    ArrayList<University> universityArray = new ArrayList<University>();
    for(int z = 0; z<schools.length;z++)
    {
     
     int spot = temp[z][0].intValue();
     ArrayList<String> emphasesArrayList = universityEmphases(array[spot][0]);
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
     
     

     
     
     
     
     University newUniversity = returnUniversity(array[spot][0], //schoolName
                                                 array[spot][1], //State
                                                 array[spot][2],//location
                                                 array[spot][3],//control
                                                 Integer.parseInt(array[spot][4]),// numStudents
                                                 Double.parseDouble(array[spot][5]),//%Female
                                                 Double.parseDouble(array[spot][6])//// SATVerbal
                                                ,Double.parseDouble(array[spot][7]),//SATMath
                                                 Double.parseDouble(array[spot][8]),//Expenses
                                                 Double.parseDouble(array[spot][9]),// percentFinancialAid
                                                 Integer.parseInt(array[spot][10]),// numberofApps
                                                 Integer.parseInt(array[spot][11])// percent admitted
                                                ,Integer.parseInt(array[spot][12]), //percentEnrolled
                                                 Integer.parseInt(array[spot][13]), //academicsScale
                                                 Integer.parseInt(array[spot][14]), // social scale
                                                 Integer.parseInt(array[spot][15]), //qualoflife
                                                 emp1,emp2,emp3,emp4,emp5);
     universityArray.add(newUniversity);
    }
    return universityArray;
  }
  /**
   * Removes a school from a users profile.
   * @param schoolName school to remove
   * @oaram username the user
   * 
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
   * @return list an ArrayList of the school name's.
   */
  public ArrayList<String> getUserSchools(String username)
  {
    String[][] array = univDBlib.user_getUsernamesWithSavedSchools();
    

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
          int len2 = array[i].length;
          for(int j = 1; j<len2;j++)
          {
            list.add(array[i][j]);
          }
          
        }
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
   * 
   */
  public ArrayList<University> search(String schoolName, String stateName, String location, String control,
                           int lowNumberOfStudents, int upNumberOfStudents,  
                           double lowPercentFemale, double upPercentFemale, 
                           double lowSATVerbal, double upSATVerbal,
                           double lowSATMath, double upSATMath,
                           double lowExpenses, double upExpenses,
                           double lowPercentEnrolled, double upPercentEnrolled,
                           int lowAcademicsScale, int upAcademicsScale,
                           int lowSocialScale, int upSocialScale,
                           int lowQualityOfLifeScale, int upQualityOfLifeScale,
                           String emphases1,String emphases2,String emphases3,
                           String emphases4,String emphases5)
  {
    //University Info
	ArrayList<University> univArray = new ArrayList<University>();
    String[][] array = univDBlib.university_getUniversities();
    int len1 = array.length;
    boolean ignore1 = false;
    boolean ignore2 = false;
    boolean ignore3 = false;
    boolean ignore4 = false;
    //University Emphasis'
    String[][] arrayEmphases = univDBlib.university_getNamesWithEmphases();
    if(schoolName.equals("!"))
    	ignore1 = true;
    if(stateName.equals("!"))
    	 ignore2 = true;
    if(stateName.equals("!"))
    	 ignore3 = true;
    if(stateName.equals("!"))
    	 ignore4 = true;
    
    boolean add = false;
    
    for(int i = 0; i<len1;i++)
    {
      //School Name
      if(!ignore1 && array[i][0].indexOf(schoolName)>=0)
      {
        add = true;
      }
      //State name
      else if(!ignore2 && array[i][1].indexOf(stateName)>=0)
      {
        add = true;
      }
      //Location Suburban urban etc
      else if(!ignore3 && array[i][2].indexOf(location)>=0)
      {
        add = true; 
      }
      //Control
      else if(!ignore4 && array[i][3].indexOf(control)>=0)
      {
        add = true;
      }
      //Student Body Population
      else if(lowNumberOfStudents < Integer.parseInt(array[i][4]) &&  Integer.parseInt(array[i][4]) < upNumberOfStudents)
      {
        add = true; 
      }
      //%Female
      else if(lowPercentFemale < Double.parseDouble(array[i][5]) && Double.parseDouble(array[i][5]) < upPercentFemale)
      {
        add = true; 
      }
      //SatVerbal
      else if(lowSATVerbal < Double.parseDouble(array[i][6]) && Double.parseDouble(array[i][6]) < upSATVerbal)
      {
        add = true;
      }
      //SatMath
      else if(lowSATMath < Double.parseDouble(array[i][7]) && Double.parseDouble(array[i][7]) < upSATMath)
      {
        add = true;
      }
      else if(lowExpenses < Double.parseDouble(array[i][8]) && Double.parseDouble(array[i][8]) < upExpenses)
      {
        add = true; 
      }
      else if(lowPercentEnrolled < Double.parseDouble(array[i][9]) && Double.parseDouble(array[i][9]) < upPercentEnrolled)
      {
        add = true; 
      }
      else if(lowAcademicsScale <  Integer.parseInt(array[i][10]) &&  Integer.parseInt(array[i][10]) < upAcademicsScale)
      {
        add = true; 
      }
      else if(lowSocialScale <  Integer.parseInt(array[i][11]) &&  Integer.parseInt(array[i][11]) < upSocialScale)
      {
        add = true; 
      }
      else if(lowQualityOfLifeScale <  Integer.parseInt(array[i][12]) &&  Integer.parseInt(array[i][12]) < upQualityOfLifeScale)
      {
        add = true; 
      }
      else if(!add && !emphases1.equals(""))
      {
        for(int k = 0; k <arrayEmphases.length;k++)
        {
          if(schoolName.equals(arrayEmphases[k][0]))
          {
            if(emphases1.equals(arrayEmphases[k][0]) || emphases2.equals(arrayEmphases[k][0])
                 || emphases3.equals(arrayEmphases[k][0])|| emphases4.equals(arrayEmphases[k][0])
                 || emphases5.equals(arrayEmphases[k][0]))
            {
              add = true;
            }
          }
          if(array[i][0].charAt(0) < arrayEmphases[k][0].charAt(0))
         	 break;
        }
      }
      
      
      //Add the school?
      if(add)
      {
         String emp1 = "";
         String emp2 = "";
         String emp3 = "";
         String emp4 = "";
         String emp5 = "";
        for(int j = 0; j<array.length;j++)
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
            if(array[i][0].charAt(0) < arrayEmphases[j][0].charAt(0))
            	 break;
         

        }
        University univ = returnUniversity(array[i][0], //schoolName
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
        univArray.add(univ);
        add =  false;
      }
    }
    return univArray;
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
   * Makes a user.
   * 
   * 
   * 
   * 
   * 
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
      String[][] array = databasecontroller.getUnivDBlib().university_getUniversities();

      databasecontroller.getUnivDBlib().user_deleteUser("trevor");

      //String[][] array = databasecontroller.getUnivDBlib().user_getUsers();

      for(int i = 0; i < array.length; i++)
      {
        for(int j = 0; j<array[i].length; j++)
        {
          System.out.println(array[i][j]);
        }
      }
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
}