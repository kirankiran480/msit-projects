<%@page language="java" import="java.io.*,java.sql.*,javax.servlet.*" %>
<html>
<head>
	
</head>
<body>
<%
String uname=request.getParameter("uname");
int flag=0;
try
{
			 Class.forName("com.mysql.jdbc.Driver").newInstance();  
      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/snakes_ladders","root","root");  
      
                        
			 Statement st=conn.createStatement();
			  ResultSet rs=st.executeQuery("select login from user_details where login like'"+uname+"%'");
			   while(rs.next())
				{
					//response.getWriter().write(rs.getString(1));
                                    String name = rs.getString(1)+"<br />";
                                        out.println("<option value=\"+name+\">"+name+"</option> ");
				 }
				/* if(flag==1)
				 {
					 response.getWriter().write("User Name already exists");
				 } 
				 else
				{
					response.getWriter().write("User Name Available to use");
				}*/
}
 catch (Exception e){

			out.println(e.getMessage());
			
		}
		%>
