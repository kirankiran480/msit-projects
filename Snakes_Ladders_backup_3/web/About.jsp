<!--
To change this template, choose Tools | Templates
and open the template in the editor.
-->
<%@page session="false" contentType="text/html" pageEncoding="UTF-8"%>
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
       
    </head>
    </head>
    <body>
     
        <% HttpSession se = request.getSession(false);
        if(se.getAttribute("Username")==null)
        {
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
        <div class ="mainimgcss">
        
        <img src ="images/snakesws.gif" width="200" height="200"/>
    </div>
    <div class ="mainpar">
         
        <br/>
        <p><br/>Snakes and Ladders (or Chutes and Ladders) is an ancient Indian board game regarded today as a worldwide classic.[1] It is played between two or more players on a gameboard having numbered, gridded squares. A number of "ladders" and "snakes" (or "chutes") are pictured on the board, each connecting two specific board squares. The object of the game is to navigate one's game piece, according to die rolls, from the start (bottom square) to the finish (top square), helped or hindered by ladders and snakes, respectively. The historic version had root in morality lessons, where a player's progression up the board represented a life journey complicated by virtues (ladders) and vices (snakes).
The game is a simple race contest lacking a skill component, and is popular with young children.</p>
    <br/><br/><h2>Board Goemetry</h2>
    <hr/>
    <p>
        The size of the grid (most commonly 8×8, 10×10, or 12×12) varies from board to board, as does the exact arrangement of the snakes and ladders, with both factors affecting the duration of play. Random die rolls determine game piece movement in the traditional form of play.</p>
    </div>
    
    </body>
</html>
