

/**

 * File: UniversityController.java

 */


import java.util.*;

import dblibrary.project.csci230.*;

import java.io.*;


/**

 * A class that creates an array for university objects, contructs universities and 

 * adds them to the list 

 */

public class UniversityController 

{ 

  //Creating an array for university objects named universityArray

  ArrayList<University> universityList;


  /** 

   * Return the universityList 

   */

  public ArrayList <University> getListOfSchools()

  {

    return this.universityList;

  }

  

 

  

  

  

  /**

   * Constructs university object

   * 

   * @param schoolName a string containing the school name 

   * @param state a string containing the name of the state

   * @param location a string containing the name of the schools location

   * @param control a String specifying who controls the new university

   * @param numStudents an integer for the number of students at school 

   * @param percentFemale a double out of 100 representing the percentage of females in the student population

   * @param satVerbal a double out of 800 representing the average SAT Verbal exam score for all students currently enrolled in the new university

   * @param satMath a double out of 800 representing the average SAT Math exam score for all students currently enrolled in the new university

   * @param tuition a double representing the annual tuition for the new university

   * @param percentRecFinAid a double out of 100 representing the percentage of students receiving any form sort 

   * of financial assistance from the new university

   * @param numApplicants an integer representing the number of students who typically apply annually to the new university 

   * @param percentAccepted a double out of 100 representing the percentage of applicants who are admitted annually to the new university

   * @param percentEnroll a double out of 100 representing the percentage of admitted students who enroll in the new university

   * @param academicScale an int between 1 and 5 (with 5 being best) indicating the quality of the academics at the new university

   * @param social an int between 1 and 5 (with 5 being best) indicating the quality of the social life at the new university

   * @param qualOfLife an int between 1 and 5 (with 5 being best) indicating the overall quality of life at the new university

   * @param studyArea1 a string containing the name of the study area

   * @param studyArea2 a string containing the name of the study area

   * @param studyArea3 a string containing the name of the study area

   * @param studyArea4 a string containing the name of the study area

   * @param studyArea5 a string containing the name of the study area

   * 

   * @return university object created 

   */

  public University makeUniversity(String schoolName,String state,String location, String control, int numStudents,

                                          double percentFemale, double satVerbal,double satMath, double tuition, double percentRecFinAid,

                                          int numApplicants, double percentAccepted, double percentEnroll, int academicScale, int social,

                                          int qualOfLife, String studyArea1,String studyArea2,String studyArea3,String studyArea4, 

                                          String studyArea5)

  {    

    //contructs a university object 

    University university = new University(schoolName, state, location, control, numStudents,

                                           percentFemale,satVerbal,satMath, tuition, percentRecFinAid,

                                          numApplicants,percentAccepted, percentEnroll, academicScale, social,

                                           qualOfLife, studyArea1, studyArea2, studyArea3, studyArea4, 

                                           studyArea5);  

    

   //adds created object to universityList

    universityList.add(university); 

    

    //returns university object 

    return university; 

  }

  

  

  

}
