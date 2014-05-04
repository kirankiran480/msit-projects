<%-- 
    Document   : Logout
    Created on : Mar 12, 2013, 10:27:11 AM
    Author     : Kalyan
--%>

<%@page import="java.sql.*" session ="false" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout</title>
    </head>
    <body>
        <%HttpSession se=request.getSession(false);
        
        String JDBC_Driver = "com.mysql.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost:3306/snakes_ladders";;
        Connection conn = null;
        Class.forName(JDBC_Driver);
        
            conn = DriverManager.getConnection(DB_URL,"root","admin");
            Statement st=conn.createStatement();
            int check1= st.executeUpdate("delete from player_details");
            Statement st2=conn.createStatement();
            int check2= st2.executeUpdate("delete from game_details");
            se.invalidate();
            response.sendRedirect("index.jsp");
            
        %>
        <h1>Hello World!</h1>
    </body>
</html>
