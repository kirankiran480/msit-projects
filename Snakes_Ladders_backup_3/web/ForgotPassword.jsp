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
        <script type="text/javascript" language="javascript" src="js/ForgotPassword.js"></script>
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
            <link rel="stylesheet" type="text/css" href="snlcss.css"/>
            <center>
                <fieldset
                    name="ForgotPassword">
                    <legend>Forgot Password</legend>   
            <form action="CreateGame.jsp" method="get" id="regform">
          
                <br/>
                <table border ="0" class="formtable" padding ="30px">
                    <tr>
                        <td>Login name   :</td><td><input type="text" name="loginname" id="lname"value=""><br/></td><td id="ln"></td>
                </tr>
                <tr><td>Secret question  :</td><td><select id="secques"><option value="q">Select</option><option value="phone">What is your phone number?</option>

                               <option value="pet">What is your pet name?</option>
                            <option value="ID">What is the last number in your ID?</option>
                        </select><br/></td><td id="selq"></td></tr>
                <tr><td>Answer       :</td><td><input id="answer" type="text" name="Answer" value =""><br/></td><td id="ansent"></td></tr>
                <tr><td>Alternate Email  :</td><td><input id="altemail" type="text" name="email" value=""><br/></td><td id="altem"></td></tr>
                <tr><td>Your Password :</td><td><input type="text" name ="PrevPassword" value=""</td><td><input type="button" name="Recpass" align="center" value="Recover Password"></td></tr>
                </table>
                <center>
                    <br>  
                  <button name="enter" id="fpsubmit" type="submit">Go to Create Game</button></form>   
                </center>
                
                
           
             </fieldset>  

            </center>
        </div>
    </body>
</html>
