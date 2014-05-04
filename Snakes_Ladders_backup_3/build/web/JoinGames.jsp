<!--
To change this template, choose Tools | Templates
and open the template in the editor.
-->
<%@page import ="java.sql.*,java.util.ArrayList" session="false" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="SNcss.css"/>
        <script type="text/javascript" language="javascript" src="js/jquery-1.9.1.min.js">
            
        </script>
        <script src="js/jquery.transit.min.js" type="text/javascript"></script>
        <script type="text/javascript" language="javascript" src="js/index.js"></script>
        <script type="text/javascript" language="javascript" src="js/Links.js"></script>
        <script type="text/javascript" language="javascript" src="js/JoinGames.js"></script>
    </head>
  
    <body>
        
        
       <% 
    String JDBC_Driver = "com.mysql.jdbc.Driver";
    String DB_URL = "jdbc:mysql://localhost:3306/snakes_ladders";;
    Class.forName(JDBC_Driver);
    Connection con=null;
            con= DriverManager.getConnection(DB_URL,"root","admin");
            Statement st=con.createStatement();
        HttpSession se = request.getSession(false);
        
        if(se.getAttribute("Username")==null)
        {
            response.sendRedirect("Login.jsp");
        %>  
        <nav>
            <a href="Login.jsp" id='login'>Login</a>
         <a href="Register.jsp" id='register'>Sign Up</a>
        <a href="About.jsp" id='about'>About Game</a>
         <a href="Instructions.jsp" id='instruct'>Instructions</a>
        <a href="CreateGame.jsp" id='create'>Create Game</a>
        <a href="JoinGames.jsp" id='join'>Join Game</a>
        <a href="Contact.jsp" id='contact'>Contact Us</a>
        </nav>
        <%} else {%>
        <center>
          <p style="float:right;">welcome <%=se.getAttribute("Username")%></p>
    </center>
        <nav>
            <a href="Logout.jsp" id='logout'>Logout</a>
         
        <a href="About.jsp" id='about'>About Game</a>
         <a href="Instructions.jsp" id='instruct'>Instructions</a>
        <a href="CreateGame.jsp" id='create'>Create Game</a>
        <a href="JoinGames.jsp" id='join'>Join Game</a>
        <a href="Contact.jsp" id='contact'>Contact Us</a>
        </nav>
        <%}%>
        <div class="formcss">
        <center>
                <fieldset
                    name="Join Game">
                    <legend>Join Game</legend>
                    <form name="joinform" action="JoinExistGame">
                <link rel ="stylesheet" type="text/css" href="snlcss.css"/>
                <br/>
                <table border ="0" class="formtable" padding ="30px">
                    <tr>
                        <td>Username   :</td><td><input type="text" name="uname" id="u" class="input"><br/></td><td id="un"></td>
                    </tr>
                    <tr>
                
                        <td>Boardname    :</td><td><select name="bname"> 
<% ResultSet rs1= st.executeQuery("select game_name from game_details where count<=4");%>
 <%while(rs1.next())
{ %>
<option><%= rs1.getString(1)%></option>
<%}%>
</select></td><td id="bn"></td>
                </tr>
                    
                
                <tr><td>Password     :</td><td><input type="password"name="pass" id="p"class="input"><br/></td><td id="pas"></td></tr>
                
 
                <tr><td>Select Dice Color     :</td><td><select name="color">
                            <% ArrayList list = new ArrayList();
        list.add("red");
        list.add("green");
        list.add("yellow");
        list.add("blue");%>
        
                           <% ResultSet rs2= st.executeQuery("select player_color from player_details");%>
 <%while(rs2.next())
                    {String c=rs2.getString("player_color");
                    if(list.contains(c))
                    {
                        list.remove(c);
                    }
    }%>
    <%
                for(int i=0; i<list.size();i++)
                                       {
                    %>
                    <option><%=list.get(i) %></option>
                 <%
                }
                %>
    </select>
    <td id="c"></td></tr>
                </table>  
                <br>
               
                <input type="submit"name="submit" id="su" class="input" value="Join Game">
                    </form>
                   <br>
            <a href="Register.jsp" id='Reglink'>Did not register? Register now</a>&nbsp;&nbsp;&#124;&nbsp;&nbsp;
            <a href="ForgotPassword.jsp" id='Fplink'>Forgot your password? Enter here.</a>
                    
                    </fieldset>  

            </center>
        </div>
    </body>
</html>
