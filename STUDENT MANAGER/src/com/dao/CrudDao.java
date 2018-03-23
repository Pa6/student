package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.DBUtility;
import com.model.Student;

public class CrudDao {

private Connection dbConnection;
private PreparedStatement pStmt;

public CrudDao() {
	dbConnection = DBUtility.getConnection();
}



public String doLogin(String username, String password){
    String message = null;
    try {

        PreparedStatement statement = dbConnection.prepareStatement("SELECT USERNAME, PASSWORD FROM STUDENTS WHERE USERNAME = ? AND PASSWORD = ?");
        //setting the parameters
        statement.setString(1, username);
        statement.setString(2, password);
        //executing the prepared statement, which returns a ResultSet
        ResultSet rs = statement.executeQuery();
        if(rs.next()){
            message = "SUCCESS";
        }else{
            message = "FAILURE";
        }
    } catch (Exception e) {
        message = "FAILURE";
        e.printStackTrace();
    }
    return message;
}

public Boolean isAdmin(String username){
    String message = null;
    Boolean isAdmin=false;
    try {

        PreparedStatement statement = dbConnection.prepareStatement("SELECT STATUS FROM STUDENTS WHERE USERNAME = ?");
        //setting the parameters
        statement.setString(1, username);
        //executing the prepared statement, which returns a ResultSet
        ResultSet rs = statement.executeQuery();
        if(rs.next()){
            message = rs.getString("status");
            if(message.equalsIgnoreCase("admin"))
            {
            isAdmin= true;	
            }
        }
    } catch (Exception e) {
        message = "FAILURE";
        e.printStackTrace();
    }
   return isAdmin;
}

public void addStudent(Student student) {
	String insertQuery = "INSERT INTO STUDENTS(STUDENTID, NAME, " +
			"DEPARTMENT, EMAIL,STATUS,USERNAME,PASSWORD) VALUES (?,?,?,?,?,?,?)";
	try {
		pStmt = dbConnection.prepareStatement(insertQuery);
		pStmt.setInt(1, student.getStudentId());
		pStmt.setString(2, student.getName());
		pStmt.setString(3, student.getDepartment());
		pStmt.setString(4, student.getEmailId());
		pStmt.setString(5, student.getStatus());
		pStmt.setString(6, student.getUsername());
		pStmt.setString(7, student.getPassword());
		pStmt.executeUpdate();
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}
}
public int addSignUp(Student student) {
	String insertQuery = "INSERT INTO STUDENTS(STUDENTID, NAME, " +
			"DEPARTMENT, EMAIL,STATUS,USERNAME,PASSWORD) VALUES (?,?,?,?,?,?,?)";
	try {
		pStmt = dbConnection.prepareStatement(insertQuery);
		pStmt.setInt(1, student.getStudentId());
		pStmt.setString(2, student.getName());
		pStmt.setString(3, student.getDepartment());
		pStmt.setString(4, student.getEmailId());
		pStmt.setString(5, student.getStatus());
		pStmt.setString(6, student.getUsername());
		pStmt.setString(7, student.getPassword());
		pStmt.executeUpdate();
		return 1;
	} catch (SQLException e) {
		
		System.err.println(e.getMessage());
		return 0;
	}
}

public void deleteStudent(int userId) {
	String deleteQuery = "DELETE FROM STUDENTS WHERE STUDENTID = ?";
	try {
		pStmt = dbConnection.prepareStatement(deleteQuery);
		pStmt.setInt(1, userId);
		pStmt.executeUpdate();
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}
}

public void updateStudent(Student student)  {
	String updateQuery = "UPDATE STUDENTS SET NAME = ?, " +
			"DEPARTMENT = ?, EMAIL = ?, STATUS = ?, USERNAME=?, PASSWORD=? WHERE STUDENTID = ?";
	try {
		pStmt = dbConnection.prepareStatement(updateQuery);		
		pStmt.setString(1, student.getName());
		pStmt.setString(2, student.getDepartment());
		pStmt.setString(3, student.getEmailId());
		pStmt.setInt(4, student.getStudentId());
		pStmt.setString(5, student.getStatus());
		pStmt.setString(6, student.getUsername());
		pStmt.setString(7, student.getPassword());
		pStmt.executeUpdate();

	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}
}

public List<Student> getAllStudents() {
	List<Student> students = new ArrayList<Student>();

	String query = "SELECT * FROM STUDENTS ORDER BY STUDENTID";
	try {
		Statement stmt = dbConnection.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			Student student = new Student();

			student.setStudentId(rs.getInt("STUDENTID"));
			student.setName(rs.getString("NAME"));
			student.setDepartment(rs.getString("DEPARTMENT"));
			student.setEmailId(rs.getString("EMAIL"));
			student.setStatus(rs.getString("STATUS"));
			student.setUsername(rs.getString("USERNAME"));
			students.add(student);
		}
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}
	return students;
}
}