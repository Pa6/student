package com.oops.studentmanager.Constants;

/**
 * Created by i24sm on 11/23/2016.
 */

public  class Constants {
   public static final String BASE_URL="http://10.0.2.2:8080/STUDENTMANAGER/";
    public static final String LOGIN_URL=BASE_URL+"AndroidLoginServlet";
    public static final String STUDENTS_URL=BASE_URL+"AndroidStudentOperationsServlet";
    public static final String MARKS_URL=BASE_URL+"AndroidMarksOperationsServlet";

    //For encryption
    public static final String FIVE = "9127486780122756"; // This has to be 16 characters
    public static final String SECRET_KEY = "yHHJfyj8";
}
