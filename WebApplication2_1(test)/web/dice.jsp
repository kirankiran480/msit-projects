<%-- 
    Document   : dice
    Created on : Mar 14, 2013, 3:24:55 AM
    Author     : kiran
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% String uname = (String) session.getAttribute("uname");
    String gname = (String) session.getAttribute("gname");
    
    String JDBC_Driver = "com.mysql.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost:3306/snakes_ladders";;
        Connection conn = null;
        Class.forName(JDBC_Driver);
            conn = DriverManager.getConnection(DB_URL,"root","root");
            Statement st = conn.createStatement();
           ResultSet rs = st.executeQuery("select * from player_details where player_name="+"'"+uname+"' and game_name="+"'"+gname+"')");
           int curr=0;
           int prev=0;
           while(rs.next())
           {
              curr = rs.getInt("current_position");
              prev = rs.getInt("previous_position");
           }
           prev = curr;
           int die = Integer.parseInt(request.getParameter("dival"));
           curr = curr+die;
           
           Statement st1 = conn.createStatement();
           st1.executeUpdate("update player_details set previous_position='"+prev+"'where player_name='"+uname+"' and game_name="+"'"+gname+"'");
           
           Statement st2 = conn.createStatement();
           st2.executeUpdate("update player_details set current_position='"+curr+"'where player_name='"+uname+"'and game_name="+"'"+gname+"'");
           
           response.sendRedirect("board.jsp");
        %>
            
        
    </body>
</html>
