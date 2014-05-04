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
        <link rel="stylesheet" href="avgrund.css"/>
        <script type="text/javascript" language="javascript" src="js/jquery-1.9.1.min.js">
            
        </script>
        <script type="text/javascript" language="javascript" src="js/jquery.easing.1.3.js">
            
        </script>
        <script type="text/javascript" language="javascript" src="js/jquery.hoverwords.js">
            
        </script>
        
        <script type="text/javascript" language="javascript" src="js/jquery.lettering.js">
            
        </script>
        <script type="text/javascript" language="javascript" src="js/jquery.avgrund.js">
            
        </script>
        
        <script src="js/jquery.transit.min.js" type="text/javascript"></script>
        <script type="text/javascript" language="javascript" src="js/index.js"></script>
        <script type="text/javascript" language="javascript" src="js/Links.js"></script>
        <script type="text/javascript" language="javascript" src="js/Login.js"></script>
    </head>
    <body>
        
       <nav>
            <a href="Login.jsp" id='login'>Login</a>
            <a href="Register.jsp" id='register'>Sign Up</a>
            <a href="About.jsp" id='about'>About Game</a>
            <a href="Instructions.jsp" id='instruct'>Instructions</a>
            <a href="CreateGame.jsp" id='create'>Create Game</a>
            <a href="JoinGames.jsp" id='join'>Join Game</a>
            <a href="Contact.jsp" id='contact'>Contact Us</a>
        </nav>
        
        <div class="logincss">
        <center>
             <p>Enter the Following User Details to Log in.</p>
                <fieldset name="Login">
                <legend>Login</legend>
                <form action="loginhandler" method="post" name="loginform">
                <br/>
                <table border ="0" class="formtable" padding ="30px">
                <tr>
                <td>Username   :</td><td><input type="text" name="uname" id="luname" class="input"><br/></td><td id="un"></td>
                </tr>
                <tr><td>Password     :</td><td><input type="password"name="pass" id="lp"class="input"><br/></td><td id="pas"></td></tr>
                </table>
                <br>
                <br>
                <input type="submit"name="submit" id="lsub" class="input" value="Login">
                
                </form>
                
                </fieldset>  

        </center>
    </div>
    </body>
</html>
