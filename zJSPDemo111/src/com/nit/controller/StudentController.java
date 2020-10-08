package com.nit.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nit.dao.StudentDao;


public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			StudentDao dao = new StudentDao();
			ArrayList al = (ArrayList)dao.getStudentData();
			req.setAttribute("studdata", al);
		
			RequestDispatcher rd = req.getRequestDispatcher("/details.jsp");
			rd.forward(req, resp);
	
	
		}

}
