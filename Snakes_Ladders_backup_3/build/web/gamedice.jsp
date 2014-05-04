<%-- 
    Document   : gamedice
    Created on : Mar 13, 2013, 10:31:51 AM
    Author     : Kalyan
--%>

<%@page import="java.sql.*" contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Connection.jsp" %>
<%HttpSession se= request.getSession(false);
  String un = se.getAttribute("Username").toString(); %>
<%String game=se.getAttribute("Board").toString();%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
        <h1><% Statement s = conn.createStatement();
               ResultSet rs=s.executeQuery("(select * from player_details where player_name='"+un+"' and game_name='"+game+"')");
               %></h1>
            <% if(rs.next())
            {
                %>
                
                <% int curpos=rs.getInt("current_position");%>
                <% int prevpos=rs.getInt("previous_position"); %>
               
            
            <% String dicenum = request.getParameter("valuedice"); %>
            <% int dn = Integer.parseInt(dicenum); %>
            
            <% int newpos = curpos+dn;%>
            
            <% if(newpos==4)
            {
                newpos=24;
            }
            
            if(newpos==8)
            {
                newpos=34;
            }
            
            if(newpos==15)
            {
                newpos=5;
            }
            
            if(newpos==22)
            {
                newpos=42;
            }
            
            if(newpos==25)
            {
                newpos=73;
            }
            
            if(newpos==30)
            {
                newpos=31;
            }
            
            if(newpos==32)
            {
                newpos=9;
            }
            
            if(newpos==35)
            {
                newpos=18;
            }
            
            if(newpos==38)
            {
                newpos=20;
            }
            
            if(newpos==44)
            {
                newpos=78;
            }
            
            if(newpos==49)
            {
                newpos=53;
            }
            
            if(newpos==58)
            {
                newpos=41;
            }
            
            if(newpos==60)
            {
                newpos=61;
            }
            
            if(newpos==65)
            {
                newpos=26;
            }
            
            if(newpos==72)
            {
                newpos=93;
            }
            
            if(newpos==81)
            {
                newpos=63;
            }
            
            if(newpos==85)
            {
                newpos=96;
            }
            
            if(newpos==90)
            {
                newpos=69;
            }
            if(newpos==94)
            {
                newpos = 33;
            }
            
            if(newpos==98)
            {
                newpos=64;
            }
            
            if(newpos>100)
            {
                newpos=curpos;
            }
            %>
            <% String updatepos1 = "update player_details set previous_position='"+curpos+"'where player_name='"+un+"'";
             s.executeUpdate(updatepos1);
             String updatepos = "update player_details set current_position='"+newpos+"'where player_name='"+un+"'";
             s.executeUpdate(updatepos);
              %>
              <% response.setIntHeader("Refresh", 5);
              response.sendRedirect("GameBoard.jsp");} %>
    </body>
</html>
