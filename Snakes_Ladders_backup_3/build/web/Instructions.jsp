<!--
To change this template, choose Tools | Templates
and open the template in the editor.
-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
         <div class="instcss"><p>1.
Begin with the game pieces off the board, next to the number "1" space.
<br/>
2.
Have the first player roll the die. That person then moves his game piece the number that he rolls on the die.
<br/>
3.
Have the second player roll the die. She moves her game piece the number that she rolls on the die.
<br/>
4.
Continue this pattern until the game is over.
<br/>
5.
Move around the board in number order. Move from Space 1 to 2 to 3 and so on until you reach Space 100.
<br/>
6.
Move your piece up the ladder to the space where the ladder ends, if it lands exactly on a spot with the beginning of a ladder.
<br/>
7.
Move your piece down, to the space where the snake ends, if it lands at the beginning of a snake.
<br/>
8.
Reach space 100 by exact roll and win the game. For example, if you're one space away from Space 100, you must roll a 1 to win.
</p>
        </div>
    <center>
    <img src ="images/sinst.png" width="700" height="300"/>
    </center>
    </body>
</html>
