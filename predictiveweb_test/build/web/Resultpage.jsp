<%@page import="java.util.StringTokenizer"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
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
   
	<div id="headercont" class="clearfix" align="">
            <h1 align="center"><a title="" href="">Online Prediction Analysis Tool</a></h1>
               
	</div>
	
	<div id="menucont" class="clearfix">
		<ul class="sf-menu dropdown">
			<li><a title="" href="index.html">Home</a></li>
			<li><a class="has_submenu" title="" href="about.jsp">About Predictive Analytics</a>
				<ul>
					<li><a title="" href="#">Feature Reduction</a></li>
					<li><a title="" href="#">Decision Trees</a></li>
					
				</ul>
			</li>
			<li><a title="" href="sesschck_join">Register</a></li>
                         <li><a title="" href="sessioncheck_login">Login</a></li>
                          <li><a title="" href="sessioncheck_predict">Predict</a></li>
			<li><a title="" href="#">Contact</a></li>
		</ul>
	</div>
    <div id="maincont" class="clearfix" align="center">
        <p> Primitive Attributes</p> <br></br>
        <%
           HttpSession si=request.getSession(false);
   String uname= si.getAttribute("uname").toString();
   String filePath = config.getServletContext().getRealPath("/")+"uploadedFiles\\"+uname+"\\"+"primitive_attributes.csv";
   BufferedReader  br=new BufferedReader(new FileReader(filePath));
        String line;
        StringTokenizer Splitter;
        while((line=br.readLine())!=null)
        {
            Splitter=new StringTokenizer(line,",");
            while(Splitter.hasMoreTokens())
            {
            out.println(Splitter.nextElement());
           }
        }

            %>
      </div>
    </body>
</html>
