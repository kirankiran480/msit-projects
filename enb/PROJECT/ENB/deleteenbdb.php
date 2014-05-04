<html >
<head>
	<meta charset="UTF-8">
	<title>Engineering Note Book</title>
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
		<div id="body">
			<div class="header">
                            <?php
                            session_start();
                            $uname=$_SESSION["uname"];
                             $ename=$_POST["enb"];
    $con=  mysqli_connect("localhost","root","root","enb1");
 if(mysqli_connect_errno())
 {
     echo "connection failed". mysqli_connect_error();
 }
 $sql="delete from cenb3 where username='$uname' and enbname='$ename'";
 mysqli_query($con,$sql);
 $sql1="delete from cenb2 where username='$uname' and enbname='$ename'";
 mysqli_query($con,$sql1);
 $sql2="delete from cenb1 where username='$uname' and enbname='$ename'";
 mysqli_query($con,$sql2);
 $sql3="delete from createenb where username='$uname' and enbname='$ename'";
 mysqli_query($con,$sql3);
 $time=date("h:i:s A", strtotime("now"-12));
$date=date("Y/m/d");
$sql10="insert into viewlogs(username,date,time,action) values('$uname','$date','$time','DELETED AN ENB.$ename')";
        mysqli_query($con,$sql10);
 ?>
                            
                          <center>  <font color="white"> YOUR ENB IS SUCCESSFULLY DELETED </font>
                          
				
			</div>
		</div>
		<div id="footer">
			<div>	
			</div>
		</div>
	</div>
</body>
</html>
