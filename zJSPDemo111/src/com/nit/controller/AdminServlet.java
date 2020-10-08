package com.nit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nit.bean.AdminDTO;
import com.nit.bean.Student;
import com.nit.dao.StudentDao;

public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    StudentDao dao = new StudentDao();
    AdminDTO dto = null;
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	
    	resp.setContentType("text/html");
    	PrintWriter out =resp.getWriter();
    	
    	String uname=req.getParameter("uname");
    	String pass=req.getParameter("pass");
    	
    	dto = new AdminDTO();
    	dto.setUsername(uname);
    	dto.setPassword(pass);
    	try{
    		boolean flag = dao.isValidUser(dto);
    		if(flag){
    			RequestDispatcher rd= req.getRequestDispatcher("/success.jsp");
    			rd.forward(req, resp);
    			
    		}else{
    			out.println("<font color=red> please enter correct username and password</font>");
    			RequestDispatcher rd=req.getRequestDispatcher("/index.jsp");
    			rd.include(req,resp);
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	
    	
    }

}
