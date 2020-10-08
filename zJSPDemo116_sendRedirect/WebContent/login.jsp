<%
String uname=request.getParameter("uname");
String pwd=request.getParameter("pwd");
if(uname.equals("admin") && pwd.equals("admin")){
	session.setAttribute("msg","login sucess");
	response.sendRedirect("./success.jsp");
}else{
	session.setAttribute("msg", "login fail");
	response.sendRedirect("./fail.jsp");
}

%>
