<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
PreparedStatement ps=con.prepareStatement("select * from qualification");

ResultSet rs=ps.executeQuery();
%>
<form action="./reg.jsp">



<pre>
ID:   <input type="text" name="id"/>
Name: <input type="text" name="name"/>
email:<input type="text" name="email"/>
adress:<input type="text" name="address"/>
Qual : <select name="qual">
		<%while(rs.next()){
			%>
			<option value="<%=rs.getString(2)%>"><%=rs.getString(2)%></option>
			<%
			}
		     %>
       </select>
       <input type="submit" value="register"/>
</pre>
</form>
<%
rs.close();
con.close(); %>
</body>
</html>