package com.tvnit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class ResultHandler extends TagSupport{
	
 private static final long serialVersionUID=1L;
 
 Connection con;
 public ResultHandler(){
	 try{
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
		 System.out.println(con);
		 
	 }catch(Exception e){
		 e.printStackTrace();
	 }	 
	 }
 public int doStartTag() throws JspException{
	 try{
		 JspWriter out=pageContext.getOut();
		 String htno=pageContext.getRequest().getParameter("htno");
		 int hno=Integer.parseInt(htno);
		 Statement stmt = con.createStatement();
		 ResultSet rs=stmt.executeQuery("select * from entrance where htno="+hno);
		 rs.next();
		 out.println("Halltickete number:"+hno);
		 out.println("candiate name:"+rs.getString(2));
		 out.println("marks:"+rs.getInt(3));
		 
		 rs.close();
		 stmt.close();
	 }catch(Exception e){
		 e.printStackTrace();
	 }
	return SKIP_BODY;
		
 }
 public void release(){
	 try{
		 if(con!=null){
			 con.close();
			 System.out.println("connnection closed");
		 }
	 }catch(Exception e){
		 e.printStackTrace();
	 }
 }

}
