<html>
    <head>
        <title>Engineering Note Book</title>
        <link rel="stylesheet" type="text/css" href="css/style1.css">
    </head>
    <script type="text/javascript">
        var e="0";
        function verify()
        {
            if(e=="0")
                {
                    alert(" no user registered with this email-id");
                return false;
                }
                else
                    return true;
        }
        function verifyemail()
   {
       var email=document.getElementById("email").value;
      if (window.XMLHttpRequest)
        {// code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp=new XMLHttpRequest();
        }
     else
       {// code for IE6, IE5
           xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
       }
	   xmlhttp.onreadystatechange=function()
       {
           if (xmlhttp.readyState==4 && xmlhttp.status==200)
          {
		   e = xmlhttp.responseText ;
		   if(e == "0")
           document.getElementById("msg2").innerHTML="enter a valid email id";
		   else if(e == "1")
		   document.getElementById("msg2").innerHTML="click submit to get password" ;
		   else
		   document.getElementById('msg2').innerHTML="Unable to retrive data from server" ;
          }
       }
	   xmlhttp.open("POST","emailAjax.php?q="+email,true);
	   xmlhttp.send();  
	}
    </script>

         <BODY style="background-image:url('images/bg2.jpg');">
        <div style="position:absolute;top:35%;left:40%;color:red">
		<table border="0"  align="center" height="180">
                <td><form action="forgotdb.php" onsubmit="return verify()"method="post">
<table border="0"  align="left" height="180">
<tr><td> <font size="5">&nbsp;  Enter your email id:</font> </td><td><input type="text" name="email" id="email" onblur="verifyemail()"></td><div style="position:absolute;top:45%;left:60%;" id="msg2"/></tr>
		<tr><td></td><td><input type="submit" name="submit" value="submit"></td></tr>
                        </table></form></td>
		</table>
	</div>
    </body>
</html>