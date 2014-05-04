<html >
<head>
	<meta charset="UTF-8">
	<title>Engineering Note Book</title>
	<link rel="stylesheet" type="text/css" href="css/style1.css">
<link type="text/css" rel="stylesheet" href="css/jquery-te-1.4.0.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js" charset="utf-8"></script>
<script type="text/javascript" src="jquery-te-1.4.0.min.js" charset="utf-8"></script>
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
            
<table width="1280">
    <td float="right">
    <div style="height:200px;width:200px;float:left;list-style: none;text-decoration: none;">
       
        <a href="cenb1.php"><img src="images/1.png"></a>
        <br><br>
        <a href="cenb2.php"><img src="images/2.png"></a>
        <br><br>
        <a href="cenb4.php"><img src="images/4.png"></a><br><br>    
        <a href="cenb3.php"><img src="images/3.png"></a>
        
        
        </div></td>
        <td>
               <?php
session_start();
$uname=$_SESSION["uname"];
$ename=$_SESSION["ename"];
    $con=  mysqli_connect("localhost","root","root","enb1");
 if(mysqli_connect_errno())
 {
     echo "connection failed". mysqli_connect_error();
 }
 $sql="select * from cenb1 where enbname='$ename'and username='$uname'";
 $result=mysqli_query($con,$sql);
 ?>
 <form method="post" action="editenbdb1.php">
     <?php
 while($row=mysqli_fetch_array($result))
 {
     ?>
   <textarea name="add" class="jqte-test"><?php echo stripslashes(trim($row["description"])) ?></textarea>
    <br>
    <?php
     
 }
    ?>
   
    <script>
	$('.jqte-test').jqte();
	
	// settings of status
	var jqteStatus = true;
	$(".status").click(function()
	{
		jqteStatus = jqteStatus ? false : true;
		$('.jqte-test').jqte({"status" : jqteStatus})
	});
</script>
    <input type="submit" value="submit">
     </td></table>
 </form>
            </div>
            </div>
 
</body>
</html>

