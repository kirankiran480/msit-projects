<%-- 
    Document   : join1
    Created on : Mar 8, 2013, 10:01:56 AM
    Author     : kiran
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>join</title>
<meta name="keywords" content="" />
<meta name="description" content="" />

<link href="default.css" rel="stylesheet" type="text/css" media="all" />
<!--[if IE 6]>
<link href="default_ie6.css" rel="stylesheet" type="text/css" />
<![endif]-->
</head>
<body>
<div id="wrapper">
	<div id="header">
		<div id="logo">
			<h1><a href="#"><span style="font-family: 'Monotype Corsiva', Magneto, Magneto; font-weight: normal; font-style: italic; text-decoration: none; font-size: 40pt;"><font color="#FFFFFF">SNAKES AND LADDERS</span></font></a></h1>
			 
                        <br>
		</div>
               
	</div>
	<!-- end #header -->
	<div id="menu-wrapper">
		<div class="ribbon ribbon-content">
			<div id="menu" align : "right">
				<ul>
					<li class="current_page_item"><a href="index.html">Home</a></li>
					<li><a href="about.html">About game</font></a></li>
                                        <li><a  align ="right" href="login.html" >Login</a></li>
					<li><a href="registration.html">Registration</a></li>
					<li><a href="rules.html">Rules</a></li>
					<li><a href="sesschech_create">Create New</a></li>
					<li><a href="sesschck_join">Join Game</a></li>
                                        <li><a href="signout">Sign Out</a></li>
					<li class="last"><a href="construct.html"><font size="3">Contact us </a></li>
				</ul>
			</div>
		</div>
	</div>
 <div class ="join_game">
<legend align ="center">join</legend>
 <form   onsubmit="return validateform()" name = "joingame" align = "center" action="join2.jsp" method="get">
    <table  id = "join" align="center" border="0">
        <tr><td>
        BoardName </td><td><select name='gamename'>  
      <option value="none">Select</option>
      <%
      Class.forName("com.mysql.jdbc.Driver").newInstance();  
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/snakes_ladders","root","root");  
      Statement stmt = con.createStatement(); 
      stmt.execute(" use snakes_ladders");
      ResultSet rs = stmt.executeQuery("Select * from game_details");
      while(rs.next()){
      %>
      <option  value="<%=rs.getString("game_name")%>"><%=rs.getString("game_name")%></option>
      <%
      }
     %>
        </select>
        <br />
        <% 
     %></td></tr>
     <tr>
         <td>GamePassword</td>
         <td><input type="password" name="gamepassword" value=""><br/></td>    </td>
     </tr><tr>
         <td></td>
         <td>
            <input type="submit" name="submit" value="submit"></td></tr></table> 
        
	</form>
</div>

  </body>
</html>