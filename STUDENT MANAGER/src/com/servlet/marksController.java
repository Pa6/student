package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CrudDao;
import com.dao.StudentMarksDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.model.Marks;
import com.model.Student;

public class marksController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Object> JSONROOT = new HashMap<String, Object>();

	private StudentMarksDao dao;

	public marksController() {
		dao = new StudentMarksDao();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("here :");
		String action = request.getParameter("action");
		List<Marks> marksList = new ArrayList<Marks>();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		response.setContentType("application/json");

		if (action != null) {
			try {
				if (action.equals("list")) {
					// Fetch Data from Student Table
					marksList = dao.getAllStudentsMarks();

					// Return in the format required by jTable plugin
					JSONROOT.put("Result", "OK");
					JSONROOT.put("Records", marksList);
					System.out.println("JSONROOT :"+JSONROOT.toString());

					// Convert Java Object to Json
					String jsonArray = gson.toJson(JSONROOT);

					response.getWriter().print(jsonArray);
				} else if (action.equals("create") || action.equals("update")) {
					Marks marks = new Marks();
					if (request.getParameter("studentId") != null) {
						int studentId = Integer.parseInt(request.getParameter("studentId"));
						marks.setStudentId(studentId);
					}

					if (request.getParameter("chemistry") != null) {
						String chemistry = request.getParameter("chemistry");
						marks.setChemistry(Integer.parseInt(chemistry));
					}

					if (request.getParameter("physics") != null) {
						String physics = request.getParameter("physics");
						marks.setPhysics(Integer.parseInt(physics));
					}

					if (request.getParameter("math") != null) {
						String math = request.getParameter("math");
						marks.setMath(Integer.parseInt(math));
					}
					if (request.getParameter("french") != null) {
						String french = request.getParameter("french");
						marks.setFrench(Integer.parseInt(french));
					}
					if (request.getParameter("english") != null) {
						String english = request.getParameter("english");
						marks.setEnglish(Integer.parseInt(english));
					}
					

					if (action.equals("create")) {
						// Create new record
						dao.addStudentMarks(marks);
					} else if (action.equals("update")) {
						// Update existing record
						dao.updateStudentMarks(marks);
					}

					// Return in the format required by jTable plugin
					JSONROOT.put("Result", "OK");
					JSONROOT.put("Record", marks);

					// Convert Java Object to Json
					String jsonArray = gson.toJson(JSONROOT);
					response.getWriter().print(jsonArray);
				} else if (action.equals("delete")) {
					// Delete record
					if (request.getParameter("studentId") != null) {
						int studentId = Integer.parseInt(request.getParameter("studentId"));
						dao.deleteStudentMarks(studentId);

						// Return in the format required by jTable plugin
						JSONROOT.put("Result", "OK");

						// Convert Java Object to Json
						String jsonArray = gson.toJson(JSONROOT);
						response.getWriter().print(jsonArray);
					}
				}
			} catch (Exception ex) {
				JSONROOT.put("Result", "ERROR");
				JSONROOT.put("Message", ex.getMessage());
				String error = gson.toJson(JSONROOT);
				System.out.println("error :"+error);
				response.getWriter().print(error);
			}
		}
	}
}