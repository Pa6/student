package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.DBUtility;
import com.model.Marks;
import com.model.Student;

public class StudentMarksDao {

private Connection dbConnection;
private PreparedStatement pStmt;

public StudentMarksDao() {
	dbConnection = DBUtility.getConnection();
}


public void addStudentMarks(Marks marks) {
	String insertQuery = "INSERT INTO marks(STUDENTID, PHYSICS, " +
			"CHEMISTRY, MATH,FRENCH,ENGLISH) VALUES (?,?,?,?,?,?)";
	try {
		pStmt = dbConnection.prepareStatement(insertQuery);
		pStmt.setInt(1, marks.getStudentId());
		pStmt.setInt(2, marks.getPhysics());
		pStmt.setInt(3, marks.getChemistry());
		pStmt.setInt(4, marks.getMath());
		pStmt.setInt(5, marks.getFrench());
		pStmt.setInt(6, marks.getEnglish());
		pStmt.executeUpdate();
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}
}

public void deleteStudentMarks(int userId) {
	String deleteQuery = "DELETE FROM MARKS WHERE STUDENTID = ?";
	try {
		pStmt = dbConnection.prepareStatement(deleteQuery);
		pStmt.setInt(1, userId);
		pStmt.executeUpdate();
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}
}

public void updateStudentMarks(Marks marks)  {
	String updateQuery = "UPDATE MARKS SET PHYSICS = ?, " +
			"CHEMISTRY = ?, MATH = ?, ENGLISH = ?, FRENCH=? WHERE STUDENTID = ?";
	try {
		pStmt = dbConnection.prepareStatement(updateQuery);		
		pStmt.setInt(1, marks.getPhysics());
		pStmt.setInt(2, marks.getChemistry());
		pStmt.setInt(3, marks.getMath());
		pStmt.setInt(4, marks.getFrench());
		pStmt.setInt(5, marks.getEnglish());
		pStmt.executeUpdate();

	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}
}

public List<Marks> getAllStudentsMarks() {
	List<Marks> marks = new ArrayList<Marks>();

	String query = "SELECT * FROM marks ORDER BY STUDENTID";
	try {
		Statement stmt = dbConnection.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			Marks mark = new Marks();

			mark.setStudentId(rs.getInt("STUDENTID"));
			mark.setChemistry(rs.getInt("CHEMISTRY"));
			mark.setEnglish(rs.getInt("ENGLISH"));
			mark.setFrench(rs.getInt("FRENCH"));
			mark.setPhysics(rs.getInt("PHYSICS"));
			mark.setMath(rs.getInt("MATH"));
			
			
			marks.add(mark);
		}
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}
	return marks;
}
}