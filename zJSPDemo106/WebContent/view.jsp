<%@page import="com.nit.customer"%>
<%
Object obj=session.getAttribute("customer);
com.nit.Customer cust=(com.nit.Customer)obj;
out.println("<br><h1>,"+cust.getName()+"ur registration is successfull");
%>