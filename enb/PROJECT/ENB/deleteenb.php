<html >
<head>
	<meta charset="UTF-8">
	<title>Engineering Note Book</title>
        <script type="text/javascript">
         function enbAjax()
        {
            //alert("===========");
             if(window.XMLHttpRequest)
        {
          xmlHttp=new XMLHttpRequest();
        }
      else
       {
           xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
       }
              
      xmlHttp.onreadystatechange=function()
      {
           //window.alert("inside myfunction"+xmlHttp.responseText);
          if (xmlHttp.readyState==4 && xmlHttp.status==200)
         {
           //alert("inside "+xmlHttp.responseText);
             document.getElementById("enbname").innerHTML=xmlHttp.responseText;
         }
  
      };
      xmlHttp.open("GET","enbajax.php",true);
      xmlHttp.send();
        }
        
    </script> 
	<link rel="stylesheet" type="text/css" href="css/style1.css">
           
</head>
<body>
    <center>
	<div id="page">
		<div id="header">
                    <a href="index.php" id="logo"><img src="images/Picture3.png"  alt="Logo"></a> 
			<ul>
                            
				<!--<li class="current">-->
                                <li>
					<a href="index.php">Home</a>
				</li>
				<li>
					<a href="createenb.php">Create Enb</a>
				</li>
				<li>
					<a href="viewenb.php">view Enb</a>
				</li>
				<li>
					<a href="editenb.php">Edit Enb</a>
				</li>
				<li>
                                        <a href="deleteenb.php">Delete Enb</a>
					
					<!--<ul>
						<li>
							<a href="article.html">Article</a>
						</li>
					</ul> -->
				</li>
				<li>
					<a href="viewlogs.php">View logs</a>
				</li>
                                
                                <li>
					<a href="Downloadenb.php">Download ENB</a>
				</li>
                                
                                <li>
					<a href="logout.php">Logout</a>
				</li>
                                
                                
			</ul>
		</div>
    </center>
            
            </div>
    <form action="deleteenbdb.php" method="post" enctype="multipart/form-data">
        <center>
        <br><br>
        <br><br>
        <font color="white" >Choose an ENB:        <select id="enbname" name="enb" ondblclick="enbAjax();" >
            
            <option>Select   </option>
           </select>
        <br><br>
     <input type="submit" value="submit">
    </form>
</body>
</html>





