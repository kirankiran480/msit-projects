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
        <script type="text/javascript" language="javascript" src="js/CreateGame.js"></script>
    </head>
    
    <body>
        
       
        <% HttpSession se = request.getSession(false);
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
        <fieldset name="CreateGame">
            <legend>Create Game</legend>
        <form action="CreateNewGame" method="post" name="createform" id ="crg">
               
                <br/>
                <table border ="0" class="formtable" padding ="30px">
                    <tr>
                        <td>Username   :</td><td><input type="text" name="uname" id="uname" class="input"><br/></td><td id="us"></td>
                    </tr>
                    <tr>
                
                        <td>Boardname    :</td><td><input type="text" name="bname" id="bname"class="input"><br/></td><td id="bn"></td>
                </tr>
                <tr>
                    <td>Number of Players   :</td><td><select name="number" id="num"><option value="">select</option><option value="1">1</option>
                            <option value="2">2</option><option value="3">3</option><option value="4">4</option></select><br/></td><td value="np"></td>
                </tr>
                
                <tr><td>Password     :</td><td><input type="password" name="pass" id="pass"class="input"><br/></td><td id="pa"></td></tr>
                <tr><td>Select Dice Color     :</td><td><select  name="color" id="color" class="input"><option value="color">color</option><option value="red">red</option><option value="green">green</option><option value="blue">blue</option><option value="yellow">yellow</option></select><br></td><td id="se"></td></tr>
                </table>                                               
                <br>
                    <button name="enter" type="submit" id="crg">Create Game</button>
            </form>
            <br>
            <a href="Register.jsp" id='Reglink'>Did not register? Register now</a>&nbsp;&nbsp;&#124;&nbsp;&nbsp;
            <a href="ForgotPassword.jsp" id='Fplink'>Forgot your password? Enter here.</a>
            </center>
        </div>
    </body>
</html>
