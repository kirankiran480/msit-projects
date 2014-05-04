<html >
<head>
	<meta charset="UTF-8">
	<title>Engineering Note Book</title>
	<link rel="stylesheet" type="text/css" href="css/style1.css">
        <script>
        function addRow(tableID) {
var table = document.getElementById(tableID);
var rowCount = table.rows.length;
var row = table.insertRow(rowCount);
var colCount = table.rows[0].cells.length;
for(var i=0; i<colCount; i++) {
var newcell= row.insertCell(i);
newcell.innerHTML = table.rows[1].cells[i].innerHTML;
switch(newcell.childNodes[0].type) {
case "text":
newcell.childNodes[0].value = "";
break;
case "checkbox":
newcell.childNodes[0].checked = false;
break;
case "select-one":
newcell.childNodes[0].selectedIndex = 0;
break;
}
}
}
</SCRIPT>
</head>
<body>
   <?php
    session_start();
   $ename=$_SESSION["ename"];
    $uname=$_SESSION["uname"];
    $con=  mysqli_connect("localhost","root","root","enb1");
 if(mysqli_connect_errno())
 {
     echo "connection failed". mysqli_connect_error();
 }
 $sql="select * from cenb3 where username='$uname' and enbname='$ename'";
$result= mysqli_query($con,$sql);
 /*if (mysqli_num_rows($result)!=0)
  {
     //echo mysqli_num_rows($result);
  header("Location: eenb3.php");
  }*/
    ?>
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
        <a href="cenb3.php"><img src="images/4.png"></a><br><br>    
        <a href="cenb4.php"><img src="images/3.png"></a>
        
        
        </div></td>
        <td>
    <div id="content" style="height:200px;width:700px;float:left;">
        <INPUT type="button" value="Add Row" onclick="addRow('dataTable')" />
    <form method="post" action="editenbdb3.php">
        <table id="dataTable" border="1" width="400">
            <tr>
                <td>context</td>
                <td>lesson</td>
            </tr>
             <?php
 while($row=mysqli_fetch_array($result))
 {
    $context=$row["context"];
    $lesson=$row["lesson"];
    ?>
     <tr>
         <!--<td><input type="text" value=></td>-->
         <td><input type="text" name="context[]" value=<?php echo $context;?>></td>
         <td><input type="text" name="lesson[]" value=<?php echo $lesson;?>></td>
     </tr>
 <?php    
 }?>
        </table>
 <input type="submit" value="submit">
    </form>
    </div>
              </td>
</table>
         
            </div>
</body>
</html>