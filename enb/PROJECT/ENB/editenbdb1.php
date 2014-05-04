<?php
$a=$_POST["add"];
session_start();
$uname=$_SESSION["uname"];
$ename=$_SESSION["ename"];
$date = date( "d/m/Y h:i:s", time() );
$c=$a."\n---last saved at".$date;
$con=  mysqli_connect("localhost","root","root","enb1");
 if(mysqli_connect_errno())
 {
     echo "connection failed". mysqli_connect_error();
 }
  $sql="update cenb1 set description='$c' where enbname='$ename' and username='$uname'";
 if (mysqli_query($con,$sql))
  {
  echo "Row inserted successfully";
   header("Location: cenb2.php");
  }
else
  {
  echo "Error in inserting into  table: " . mysqli_error($con);
  }
?>
