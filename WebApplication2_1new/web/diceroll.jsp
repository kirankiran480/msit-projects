<%-- 
    Document   : diceroll
    Created on : Mar 12, 2013, 10:40:35 PM
    Author     : kiran
--%>

<%@page import="java.util.Currency"%>
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
        <%
        String die=request.getParameter("dival");
        String gname=(String)session.getAttribute("gname");
        String pname=(String)session.getAttribute("uname");
        int prev=0;
        int cur=0;
      Class.forName("com.mysql.jdbc.Driver").newInstance();  
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/snakes_ladders","root","root");  
      Statement stmt = con.createStatement(); 
      Statement stmt1 = con.createStatement();
      stmt.execute("use snakes_ladders");
      stmt1.execute("use snakes_ladders");
      ResultSet rs = stmt.executeQuery("Select * from player_details where game_name='"+gname+"' and player_name='"+pname+"'");
      while(rs.next())
      {
          prev=rs.getInt("previous_position");
          cur=rs.getInt("current_position");
      }
      prev=cur;
      cur=cur+Integer.parseInt(die);
      if (cur ==6)
                   {
          cur=27;
      }
           else if( cur==23)
           {
               cur=62;
               
           }
           else if(cur==36)
           {
               cur=75;
               
           }
           else if(cur==50)
           {
               cur=89;
           }
           else if(cur==64)
                             {
               cur=98;
           }
       else if(cur==22)
                             {
               cur=4;
           }
       else if(cur==52)
                             {
               cur=35;
           }
       else if(cur==76)
                             {
               cur=16;
           }
       else if(cur==32)
                             {
               cur=9;
           }
       else if(cur==94)
           {
               cur=43;
           }
       else if(cur==99)
                             
       {
               cur=21;
       }
       else if(cur==100)
                             {
               cur=100;
           }
       else if(cur>100)
                             {
               cur=cur-Integer.parseInt(die);
           }
      stmt1.executeUpdate("update player_details set previous_position='"+prev+"',current_position='"+cur+"' where game_name='"+gname+"' and player_name='"+pname+"'");        
response.sendRedirect("board.jsp");
%>
        
        
      
    </body>
</html>
