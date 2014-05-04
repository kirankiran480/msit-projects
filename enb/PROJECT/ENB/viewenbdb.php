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
		<div id="header">
                    <a href="index.php" id="logo"><img src="images/Picture3.png"  alt="Logo"></a> 
			<ul>
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
    
            </div>
  
    <br>
    <font color='white' > NOTES </font>
    <br>
    
    <?php
    session_start();
    $ename=$_POST["enb"];
    $uname=$_SESSION["uname"];
    $con=  mysqli_connect("localhost","root","root","enb1");
 if(mysqli_connect_errno())
 {
     echo "connection failed". mysqli_connect_error();
 }
 $sql="select * from cenb1 where enbname='$ename' and username='$uname'";
 $result=mysqli_query($con,$sql);
 while($row=mysqli_fetch_array($result))
 {
     ?>
     <textarea name="add" class="jqte-test"><?php echo stripslashes(trim($row["description"])) ?></textarea>
  <!--  <textarea rows="25" cols="80" name="content"><?php //echo stripslashes(trim($row["description"])) ?></textarea>-->
    <br>
    <?php
     
 }?>
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
    <?php
 $sql1="select * from cenb2 where enbname='$ename' and username='$uname'";
 $result1=mysqli_query($con,$sql1);
 ?>

           
                <font color='white' > DELIVERABLE STATUS </font>
<br>
            <br>
 <table border="1" width="400">
            <tr>
                <td>Deliverables</td>
                <td>Planned to Accompolish</td>
                <td>Actually Accompolished</td>
                <td>Size</td>
                <td>Effort</td>
            </tr>
            <?php
 while($row=mysqli_fetch_array($result1))
 {
    ?>
            <tr>
                 <td><?php echo $row["deliverables"] ?></td>
                  <td><?php echo $row["plan"] ?></td>
                   <td><?php echo $row["actual"] ?></td>
                    <td><?php echo $row["size"] ?></td>
                    <td><?php echo $row["effort"] ?></td>
            </tr>
            <?php
            }
            ?>
             </table>
        
            <br>
            <br>
                <font color='white' > LESSONS LEARNED </font>
<br>
            <br>
            <?php
            $sql2="select * from cenb3 where enbname='$ename' and username='$uname'";
 $result2=mysqli_query($con,$sql2);
            ?>

            <table border="1" width="400">
            <tr>
                <td>context</td>
                <td>lesson</td>
            </tr>
            <?php
            while($row=mysqli_fetch_array($result2))
 {
    ?>
            <tr>
                  <td><?php echo $row["context"] ?></td>
                   <td><?php echo $row["lesson"] ?></td>
            </tr>
            <?php
            }
            ?>
 </table>
            <br>
            <br>
                <font color='white' > PLAN FOR THE NEXT WEEK </font>
<br>
            <br>
            <?php
            $sql3="select * from cenb4 where enbname='$ename' and username='$uname'";
 $result3=mysqli_query($con,$sql3);
            ?>

            <table border="1" width="400">
            <tr>
                <td>DELIVERABLE</td>
                <td>WHAT DO YOU INTENDED TO ACCOMPLISH AND WHY</td>
            </tr>
            <?php
            while($row=mysqli_fetch_array($result3))
 {
    ?>
            <tr>
                  <td><?php echo $row["deliverable"] ?></td>
                   <td><?php echo $row["what"] ?></td>
            </tr>
            <?php
            }
            ?>
 </table>
</body>
</html>

