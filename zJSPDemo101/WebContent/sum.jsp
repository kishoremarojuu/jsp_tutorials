<% 

String a =request.getParameter("num1") ;
String b =request.getParameter("num2") ;

int x = Integer.parseInt(a);
int y = Integer.parseInt(b);

int z=x+y;
out.println("sum is:"+z);

%>