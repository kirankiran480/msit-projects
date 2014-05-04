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
        <script type="text/javascript" language="javascript" src="js/Register.js"></script>
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
        <div class="formcss">
        <center>
        <fieldset name="Register">
        <legend>Sign Up</legend>
        <form action="Registration" method="post" name="regform">
        <br/>
        <table border ="0" class="formtable" padding ="30px">
        <tr>
        <td>First name   :</td><td><input type="text" name="fname" id="fname" value=""><br/></td><td id="fn"></td>
        </tr>
        <tr>
        <td>Last name    :</td><td><input type="text" name="lname" id ="lname" value=""><br/></td><td id="ln"></td>
        </tr>
        <tr>
        <td>Login name   :</td><td><input type="text" name="uname" id="uname" value=""><br/></td><td id="us"></td>
        </tr>
        <tr><td>Dob          :</td><td><input type="date" name="dob"><br/></td><td></td></tr>
        <tr><td>Gender       :</td><td><select name="gender" id="gender"><option value="">select</option><option value="Male">Male</option><option value="Female">Female</option><br/></td><td id="gd"></td></tr>
        <tr><td>Email        :</td><td><input type=email name="email" id="email" value=""><br/></td><td id="em"></td></tr>
        <tr><td>Password     :</td><td><input type="password" name="password" id="pass"value=""><br/></td><td id="ps"></td></tr>
        <tr><td>Retype Password  :</td><td><input type="password" name="password1" id="pass1"value=""><br/></td><td id="pss"></td></tr>             
        <tr><td>Address :</td><td><textarea rows="4" cols="20" id="addr" name="addr" class="input"></textarea><br/></td><td id="ad"></td></tr>
        <tr><td>Secret question  :</td><td><select name="sq" id="sq" class="input"><option value="">Select</option><option value="phone">What is your phone number?</option>
                            <option value="pet">What is your pet name?</option>
                            <option value="ID">What is the last number in your ID?</option>
                        </select><br/></td><td id="sel"></td></tr>
        <tr><td>Answer       :</td><td><input type="text" name="sqa" id="sqa" class="input" ><br/></td><td id="sa"></td></tr>
        <tr><td>Alternate Email  :</td><td><input type="text" name="alte" id="alte" class="input"><br/></td><td id="ae"></td></tr>
        </table>
                <center>
                   <input type="submit" name="sb" id="sb" value="Register" class="button" >
                </center>
                </table>
            </form>
                    </fieldset>  

            </center>
        </div>
    </body>
</html>
