<%-- 
    Document   : uploadpage
    Created on : 24 May, 2013, 5:00:43 PM
    Author     : kiran
--%>

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
</head>
<body>
<div id="container" class="clearfix">
   
	<div id="headercont" class="clearfix" align="center">
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
			<li><a title="" href="logout">Logout</a></li>
		</ul>
	</div>
    <div id="maincont" class="clearfix" align="center">
        <form action="upload.jsp" method="post"
              enctype="multipart/form-data" onsubmit="">
            <input type="file" name="file" size="50" accept=".csv"/>
        <br /><br />
        <table>
            <tr>
                <td>
                    <input name="alogrithms" type="radio" value="predictive"></td><td>Primitive Attributes</td></tr>
            <tr><td>        
                    <input name="alogrithms" type="radio" value="decisontree"></td><td>Decision Trees</td></tr>
<input name="alogrithms" type="radio" value="k-means ">K-means<br>
<input name="alogrithms" type="radio" value="neuralnetworks ">Neural Networks<br>
<input name="alogrithms" type="radio" checked value="naivebayesian">Naive Bayesian<br>
<input name="alogrithms" type="radio" value="logit">Logit<br>
        </table>
        <br /><br />
<input type="submit" value="Predict !!!" />
<br />
</form>
      </div>
    <br />
    <div id="footercont" class="clearfix">
        <p>Designed by <a title="Predictive Analytics Team" href="index.jsp" rel="external">Predictive Analytics Team</a></p>
    </div>

</div>
    </body>
</html>
