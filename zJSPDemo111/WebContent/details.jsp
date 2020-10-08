<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@import ="java.util.ArrayList" %>
<%@import ="com.nit.bean.Student" %>
<%@import ="java.util.Iterator" %>
<%@taglib uri="http//java.sun.com/jsp/jstl/core" prefix="core" %>
<%Student s= null;
ArrayList al = (ArrayList)request.getAttributeNames("studdata"));
%>
<html>
<head>
<body>
<h1>Student Data</h1>
SNO
NAME
MARKS
<%
Iterator iterator =al.iterator();
while(iterator.hasNext()){
	s=(Student)iterator.next();
%>
<%=s.getSno() %>
<%=s.getName() %>
<%=s.getMarks() %>

<%} %>
</body>
</html>