<%-- 
    Document   : join2
    Created on : Mar 8, 2013, 10:57:05 AM
    Author     : kiran
--%>

<%@page import="javax.swing.JOptionPane"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.servlet.http.HttpSession"%>

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
 <form   onsubmit="return validateform()" name = "joingame" align = "center" action="join" method="post">
     <%
      Class.forName("com.mysql.jdbc.Driver").newInstance();  
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/snakes_ladders","root","root");  
      Statement stmt = con.createStatement(); 
      stmt.execute(" use snakes_ladders");
      ResultSet rs ;
     %>
     <table  id = "join" align="center" border="0">
	<tr>	<td>
                </select>
                <br />
                 <%
                ArrayList al= new ArrayList();
                al.add("red");
                al.add("blue");
                al.add("green");
                al.add("yellow");
                String sl=request.getParameter("gamename");
                HttpSession s = request.getSession(false);
                
               
                
                s.setAttribute("gname", new String(sl));
                
                String pass=request.getParameter("gamepassword");
                rs=stmt.executeQuery("Select * from game_details where game_name='"+sl+"'");
                String p=null;
                String curr_game=null;
                while(rs.next())
                                       {
                   p =rs.getString("passphrase");
                   
                }
                
                if(!pass.equals(p))
                  {                     
                    response.sendRedirect("join1.jsp");
                }
                rs=stmt.executeQuery("Select * from player_details where game_name='"+sl+"'");
                
                while(rs.next())
                {
                    if(s.getAttribute("uname").toString().equals(rs.getString("player_name")))
                    {
                        %>
                        <script>
                            alert("u already joined this game");
                            </script>
                        <%
                        JOptionPane.showMessageDialog(null,"u already played this game");
                        response.sendRedirect("join1.jsp");
                    }
                    String c=rs.getString("player_color");
                    if(al.contains(c))
                    {
                        al.remove(c);
                    }
                }
                %>
            </td>
        </tr>
            <tr>
                <td>
                    <label>DieColor</label><br />
                </td><td>
                     <%
                for(int i=0; i<al.size();i++)
                                       {
                    %>
                    <input type="radio" name="diecolor" value="<%=al.get(i) %>"><label><%=al.get(i) %></label><br />
                 <%
                }
                %>
                </td>
            </tr>
                <tr><td></td><td>
	<input type="submit" name="submit" value="submit"></td></tr></table>
	
	</form>
</div>

  </body>
</html>