package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CrudDao;

import gvjava.org.json.JSONObject;

 @WebServlet(name="AndroidLoginServlet")
public class AndroidLoginServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;

        protected void doPost(HttpServletRequest request,
                        HttpServletResponse response) throws ServletException, IOException {
                System.out.println("here");
                String email = request.getParameter("username");
                String password = request.getParameter("password");
                System.out.println("here username: "+email);

                String message = new CrudDao().doLogin(email, password);
                try
                {
                    JSONObject json= new JSONObject();
                    json.put("status", message);
                    response.getWriter().print(message);
                    System.out.print(json.toString());
                }catch(Exception e)
                {
                e.printStackTrace();	
                }

      
                

        }

        @Override
        protected void doGet(HttpServletRequest request,
                        HttpServletResponse response) throws ServletException, IOException {
        	doPost(request,response);
              
        }
}