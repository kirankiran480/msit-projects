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
        <script type="text/javascript" language="javascript" src="js/Contact.js"></script>
    </head>
    <center>
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
        <div class="contdetails">
            <p>Kalyan Kaushik Khasibhatla</p>
            <p>9959853009</p>
            <p>kalyankaushik.khasibhatla@gmail.com</p>
            <p>Follow us on</p>
            <br><br>
            <div class ='fb'>
            <a href="https://www.facebook.com/kalyankaushik.khasibhatla"><img src='images/fb.jpg' alt='facebook' name='fbfollow' id='fbfollow'/></a>
        </div> 
            <div class ='gplus'>
            <a href="https://www.google.co.in/"><img src='images/g+.jpg' alt='google+' name='gplusfollow' id='gplusfollow'/></a>
        </div> 
            <div class ='twit'>
            <a href="https://twitter.com/"><img src='images/twit.png' alt='twitter' name='twitfollow' id='twitfollow'/></a>
        </div> 
            <br><br><br><br><br><p>Copyright © 2013 Kalyan Kaushik Khasibhatla. All Rights Reserved. All gaming content are copyright and trademarked by their owners, authors.</p>
        </div>
    </body>
    </center>
</html>
