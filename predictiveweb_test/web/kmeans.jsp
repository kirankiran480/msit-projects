<%-- 
    Document   : kmeans
    Created on : Jun 1, 2013, 10:54:18 PM
    Author     : Kavitha
--%>
<%@page import="java.io.IOException"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Scanner"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>Online Prediction Analysis Tool</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<meta name="description" content="" />
<meta name="keywords" content="" />
<link rel="stylesheet" type="text/css" media="screen" href="style.css" />
<!--<link href="http://fonts.googleapis.com/css?family=Droid+Sans" rel="stylesheet" type="text/css"/>
<link href="http://fonts.googleapis.com/css?family=Francois+One&amp;v1" rel="stylesheet" type="text/css" /> -->
<script type="text/javascript" src="http://code.jquery.com/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="superfish.js"></script>
<script type="text/javascript" src="scripts.js"></script>
<script type="text/javascript" language="javascript" src="register.js"></script>

        <script type="text/javascript">
  var s;
    function demoajax() {
        alert("call done");
     if (window.XMLHttpRequest) {

        httpRequest = new XMLHttpRequest();

     }

     else {

        if (window.ActiveXObject) {

           try {

              httpRequest = new ActiveXObject ("Microsoft.XMLHTTP");

           }

           catch (e) { 
           System.out.println("Exception"+e);
                }

        }
     }
getData21();
}
function getData21() 
{
     //alert(url);  
     //alert("hai");  
     var url = "kmeans";
     //alert(url);
     //alert(document.getElementById("txt").value)
     s=document.getElementById("txt").value;
     //alert(s)
     url=url+"?clusters=";
     url=url+s;
     //alert(url);
     httpRequest.onreadystatechange = showData21;
     httpRequest.open("GET", url, true);
     httpRequest.send(null);
     //setTimeout("getData2()", 10000);

}



function showData21() 
{
//alert("temp");
     if (httpRequest.readyState == 4) 
     {
        if (httpRequest.status == 200) 
        {
               var temp=httpRequest.responseText;
                //alert(temp);
               document.getElementById("destination1").innerHTML=httpRequest.responseText;
               var ratings=httpRequest.responseText;
               //alert(temp);
        }
        else 
        {
           alert("Error with loading data\n"+ httpRequest.status +":"+ httpRequest.statusText);
        }
     }
}



        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   </head>
    <body>
        <div id="container" class="clearfix">
   
	<div id="headercont" class="clearfix" align="">
            <h1 align="center"><a title="" href="">Online Prediction Analysis Tool</a></h1>
               
	</div>
	
	<div id="menucont" class="clearfix">
		<ul class="sf-menu dropdown">
			<li><a title="" href="index.html">Home</a></li>
			<li><a class="has_submenu" title="" href="about.html">About Predictive Analytics</a>
				<ul>
					<li><a title="" href="#">Feature Reduction</a></li>
					<li><a title="" href="#">Decision Trees</a></li>
					
				</ul>
			</li>
			<li><a title="" href="sesschck_join">Register</a></li>
                        <li><a title="" href="sessioncheck_login">Login</a></li>
                          <li><a title="" href="sessioncheck_predict">Predict</a></li>
                           
			<li><a title="" href="logout">logout</a></li>
		</ul>
	</div>
     <div id="maincont" class="clearfix" align="center">
         <p  style="font-size: 18px;"align ="center">Enter number of clusters</p><br>
        <input type="text" id="txt">
        <input type="button" onclick="demoajax()" value="Click">
        <div id="destination1" style="position: absolute; left: 300px ; top: 250px; ">
           
        </div>
            </div>
       
       
    </body>
</html>
