package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CrudDao;


public class LoginServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;

        protected void doPost(HttpServletRequest request,
                        HttpServletResponse response) throws ServletException, IOException {
        	System.out.println("here");
                String error;
                String email = request.getParameter("username");
                String password = request.getParameter("password");
                HttpSession session = request.getSession();


                String message = new CrudDao().doLogin(email, password);

                if (message.equalsIgnoreCase("success")) {
                    session.setAttribute("user", message);
                    response.sendRedirect("Students.jsp");

                } else {
                    error = "Invalid Email or password";
                    session.setAttribute("error", error);
                    response.sendRedirect("index.jsp");  
                }
        }

        @Override
        protected void doGet(HttpServletRequest request,
                        HttpServletResponse response) throws ServletException, IOException {
                if ("logout".equalsIgnoreCase(request.getParameter("param"))) {
                        HttpSession session = request.getSession();
                        session.removeAttribute("user");
                        session.invalidate();
                        response.sendRedirect("index.jsp");
                }
        }
}