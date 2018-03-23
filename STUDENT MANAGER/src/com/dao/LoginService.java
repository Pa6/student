package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.jdbc.DBUtility;
 
public class LoginService {
    public String doLogin(String username, String password){
        Connection con = null;
        String message = null;
        try {
            con= DBUtility.getConnection();

            PreparedStatement statement = con.prepareStatement("SELECT USERNAME, PASSWORD FROM STUDENTS WHERE USERNAME = ? AND PASSWORD = ?");
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
}
