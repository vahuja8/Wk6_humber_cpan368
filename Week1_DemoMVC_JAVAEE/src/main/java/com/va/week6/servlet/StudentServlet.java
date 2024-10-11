package com.va.week6.servlet;

import java.io.IOException;


import com.va.week6.dao.StudentDao;
import com.va.week6.hashing.Wk6_Hashing;
import com.va.week6.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;




/**
 * Servlet implementation class StudentServlet
 */
//WebServlet("/StudentServlet")
@WebServlet(name = "StudentServlet", urlPatterns = {"/StudentServlet"})
public class StudentServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private com.va.week6.dao.StudentDao stDao;
	public void init() {
		stDao = new StudentDao();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
/*
 * this fetches the info from the client!!-browser.. 
 */
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String grade = request.getParameter("grade");

		Student st = new Student();
		/*
		 * call the hashing method here!! and then you can call the setters!. 
		 */
		Wk6_Hashing wk = new Wk6_Hashing();
	// call the object to set the values for hashing!. 	
		
		
		st.setFirstname(firstName);
		st.setLastname(lastName);
		st.setGrade(grade);
		

		try {
			stDao.registerStudent(st);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("StudentInfo.jsp");
	}

}
