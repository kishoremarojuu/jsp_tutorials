<%
com.nit.Customer c = new com.nit.Customer();
String name = request.getParameter("name");
c.setName(name);
String age=request.getParameter("age");
int iage=Integer.parseInt(age);
c.setAge(iage);
String ph= request.getParameter("phonenum");
long phonenum=Long.parseInt(ph);

//store data into database
session.setAttribute("customer",c);

%>

<%@ include file="view.jsp" %>>