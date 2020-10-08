<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%
int id=Integer.parseInt(request.getParameter("id"));
String name = request.getParameter("name");
String email=request.getParamater("email");
String address=request.getParamater("address");
String qual=request.getParamater("qual");

 Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
PreparedStatement ps=con.prepareStatement("insert into student4244 values(?,?,?,?,?)");
ps.setInt(1, id);
ps.setString(2, name);
ps.setString(3,email);
ps.setString(4,address);
ps.setString(5,qual);

int i = ps.executeUpdate();


ps.close();
con.close();

if(i!=0){
	out.println("reg success");
}else{
	out.println("reg failed");
}

%>