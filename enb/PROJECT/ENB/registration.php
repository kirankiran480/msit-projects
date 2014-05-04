  <TITLE> Registration </TITLE>
  <META NAME="Generator" CONTENT="EditPlus">
  <META NAME="Author" CONTENT="">
  <META NAME="Keywords" CONTENT="">
  <META NAME="Description" CONTENT="">
   <link rel="stylesheet" type="text/css" href="css/style1.css">
   
  <script type="text/javascript">
 var u = "0";
var e = "0";
   function verifyform()
   {
	   if(u == "1")
           {
           alert("UserName already registered");
           return false;
           }
	   if(e=="1")
           {
           alert("Email id is already registered");
           return false;
           }
	   return true;
   }

   function validateform()
   {
   if(!verifyfirst()){return false;}
    if(!verifylast()){return false;}
    if(!verifydate()){return false;}
    if(!verifyrepassword()){return false;}
    if(!verifyaddress()){return false;}
    if(!verifyform()){return false;}
    if(!verifygender()){return false;}
    return true;
   }
        function verifyuserName()
   {
	   var uname = document.getElementById('uname').value ;
	   if(uname.length < 5)
	   {
		   document.getElementById('msg1').innerHTML="User name should contain atleast 5 charactors" ;
		   u == "1";
		   return;
	   }
	   var xmlhttp;
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
		   u = xmlhttp.responseText ;
                   //alert(u);
		   if(u == "0")
           document.getElementById("msg1").innerHTML="Available";
		   else if(u == "1")
		   document.getElementById("msg1").innerHTML="Already Registered" ;
		   else
		   document.getElementById('msg1').innerHTML="Unable to retrive data from server</span>" ;
          }
       }
	   xmlhttp.open("POST","UserAjax.php?q="+uname,true);
	   xmlhttp.send();  
	}
	 function verifyemail()
   {
       var email=document.getElementById("email").value;
	   var xmlhttp;
           var atpos=email.indexOf("@");
	   var dotpos=email.lastIndexOf(".");
           if (atpos<1 || dotpos<atpos+2)
		{
                    document.getElementById('msg2').innerHTML="enter a valid email id" ;
		   e == "1";
		   return;
                }
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
                   //alert(u);
		   if(e == "0")
           document.getElementById("msg2").innerHTML="Available";
		   else if(e == "1")
		   document.getElementById("msg2").innerHTML="Already Registered" ;
		   else
		   document.getElementById('msg2').innerHTML="Unable to retrive data from server" ;
          }
       }
	   xmlhttp.open("POST","emailAjax.php?q="+email,true);
	   xmlhttp.send();  
	}
        function verifylast()
    { 
	    var uname=document.getElementById("lname").value;
       if(uname.length==0||uname.length<5||uname.length>20)
	   {
		 alert("lastname should contain atleast 5 characters");
		 return false;
	   }
	  else
	  {
		 
		 // var name=/^[A-Za-z0-9 ][A-Za-z0-9 ]+$/;
		 var name=/^[A-Za-z]/;
		  if(!name.test(uname))
		   {
			  alert("enter a valid lastname(only A-Z)");  
			  return false;
		   }
		  return true;
	  }
   }
   function verifyfirst()
    { 
	    var uname=document.getElementById("fname").value;
       if(uname.length==0||uname.length<5||uname.length>20)
	   {
               alert("firstname should contain atleast 5 characters");
		 return false;
	   }
	  else
	  {
		 
		 // var name=/^[A-Za-z0-9 ][A-Za-z0-9 ]+$/;
		 var name=/^[A-Za-z]/;
		  if(!name.test(uname))
		   {
			alert("enter a valid firstname(only A-Z)");  
			  return false;
		   }
		  return true;
	  }
   }
   function verifydate()
	 {
        var da=document.getElementById("dob").value;
		  if(da==null || da=="")
		   {
                       alert("enter a valid date");
			return false
		   }
		   else
		   {
			   return true
		   }
	  }
          function verifygender()
	  {
		  gen1=document.reg.gender[0].checked;
           gen2=document.reg.gender[1].checked;

		   if(gen1==false && gen2==false)
		   {
                       alert("select a gender");
			return false;
		   }
		   else
		   {
			   return true;
		   }

	  }
          function verifyaddress()
	{
		var ad=document.getElementById("add").value;
		//var pat=null;
	    var pat=/^[a-zA-Z0-9/.,-][a-zA-Z0-9/.,-]+$/
		if(ad.length==0)
		{
                    alert("enter address");
			return false;
		}
		else
		{
			if(!pat.test(ad))
			{
                          alert("enter a valid address");
			  return false;
			}
		     return true
		}
    }
    function verifypassword()
    {
          var rp=document.getElementById("pass").value;
		  if(rp.length==0||rp.length<5||rp.length>10)
	     {
		alert("enter (5-10)characters password");
		    return false;
	     }
             else
                 {
                     return true;
                 }
    }
     function verifyrepassword()
	  {
		 
		  var rp=document.getElementById("repass").value;
		  if(rp.length==0||rp.length<5||rp.length>10)
	     {
		alert("enter (5-10) characters password");
		    return false;
	     }
	    else
	    {
			 var p=document.getElementById("pass").value;
			  if(rp!=p)
			  {
                              alert("password is not matching");
                 return false;
			  }
			  else
			  {
				  return true;
			  }
		}
	}
  </script>
 </HEAD>
 <BODY style="background-image:url('images/bg2.jpg');">
 <h1 style="font-family:timesnewroman;text-align:center;color:darkorchid">REGISTRATION</h1>
 <form action="dbregister.php" onSubmit="return validateform()" method="post">
 <table align="center" cellpadding="8"> 
     <tr>
        <td>Username:</td><td><input type="text" name="uname" id="uname" onblur="verifyuserName()"></td><div style="position:absolute;top:12%;left:60%;color:red" id="msg1"/>
     </tr>
     <tr>
	<td>FirstName:</td><td><input type="text" name="fname" id="fname" onblur="verifyfirst()"></td>
     </tr>
     <tr>
        <td>LastName:</td><td><input type="text" name="lname" id="lname" onblur="verifylast()"></td>
     </tr>
    
     <tr>
	<td>DateofBirth:</td>
	<td><input type="date" name="dob" id="dob" onblur="verifydate()"></td>
    </tr>
    <tr>
        <td>Gender:</td><td><input type="radio"  name="gender" value="male">Male<input type="radio"  name="gender" value="female">Female</td>
    </tr>
    <tr>
        <td>Email Id:</td><td><input type="text" name="email" id="email" onblur="verifyemail();"></td><div style="position:absolute;top:45%;left:60%;" id="msg2"/>
   </tr>
   <tr>
        <td>Password:</td><td><input type="password" name="pass" id="pass" onblur="verifypassword()"></td>
   </tr>
<tr>
<tr>
<td>RetypePassword:</td><td><input type="password" name="repass" id="repass" onblur="verifyrepassword()"></td>
</tr>
<tr>
<td>Address:</td><td><br><textarea rows="3" cols="30"  name="add" id="add" onblur="verifyaddress()"></textarea></td>
</tr>
     <tr>
<td><br></td><td><input type="submit" width="30" value="Submit"></td>
</tr>
 </table>
 </form>
 </BODY>
</HTML>
