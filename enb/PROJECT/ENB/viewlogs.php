<html >
<head>
	<meta charset="UTF-8">
	<title>Engineering Note Book</title>
        <link rel="stylesheet" type="text/css" href="css/style1.css">
           
</head>
<body>
    <center>
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
<?php
session_start();
$uname=$_SESSION['uname'];
?>
<br>
<br>
<br>
<br>
<br>
 <font color='white' > <center>VIEW LOGS</center> </font>
<br>
            <br>
 <table border="1" width="400" align="center">
            <tr>
                <td>Date</td>
                <td>Time</td>
                <td>Action</td>
            </tr>
            <?php
            $con=  mysqli_connect("localhost","root","root","enb1");
            $sql1="select * from viewlogs where username='$uname'";
 $result1=mysqli_query($con,$sql1);
 while($row=mysqli_fetch_array($result1))
 {
    ?>
            <tr>
                 <td width="200"><?php echo $row["date"] ?></td>
                  <td width="200"><?php echo $row["time"] ?></td>
                   <td width="200"><?php echo $row["action"] ?></td>
            </tr>
            <?php
            }
            ?>
             </table>
