<%@page import="java.sql.*"%>
<%@page import="oracle.jdbc.driver.*;" %>
<%@page import="oracle.sql.*;" %>
<%@page import="oracle.jdbc.driver.OracleDriver;"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
 
 <%!
 Connection con;
 ResultSet rs;
 
public void JspInit(){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
		}catch(Exception e){
			e.printStackTrace();
		}	
} 
 %>
 <%
 try{
 PreparedStatement ps=con.prepareStatement("select * from emp2 where empno=?");
 int eno=Integer.parseInt(request.getParameter("t1"));
 ps.setInt(1,sno);
 rs=ps.executeQuery();
 while(rs.next()){
 
  %>
  
  <%=rs.getInt(1) %>
  <%=rs.getString(2) %>
  <%=rs.getFloat(3) %>
  
  <%
 }
 }
  catch(Exception e){
	  e.printStackTrace();}
  %>