package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CrudDao;
import com.model.Student;

public class SignUpServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;

        protected void doPost(HttpServletRequest request,
                        HttpServletResponse response) throws ServletException, IOException {


                CrudDao userDAO = new CrudDao();
                Student student= new Student();
                student.setEmailId(request.getParameter("email"));
                student.setDepartment(request.getParameter("department"));
                student.setName(request.getParameter("name"));
                student.setPassword(request.getParameter("password"));
                student.setStudentId(Integer.parseInt(request.getParameter("studentid")));
                student.setUsername(request.getParameter("username"));
                student.setStatus(request.getParameter("status"));

                

                int result = userDAO.addSignUp(student);
                if (result == 1) {
                        response.sendRedirect("index.jsp");
                }
        }
}