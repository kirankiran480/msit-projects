<?php
session_start();
$ename=$_SESSION["ename"];
$uname=$_SESSION["uname"];
//$b=$_SESSION["ename"];
$context=$_POST["context"];
$lesson=$_POST["lesson"];
$con=  mysqli_connect("localhost","root","root","enb1");
if(mysqli_connect_errno())
 {
     echo "connection failed". mysqli_connect_error();
 }

  foreach($context as $array=>$innerarray)
 {
  $con=  mysqli_connect("localhost","root","root","enb1");
 if(mysqli_connect_errno())
 {
     echo "connection failed". mysqli_connect_error();
 }
 $sql="insert into  cenb3(username,enbname,context,lesson) values('$uname','$ename','$context[$array]','$lesson[$array]')";
 mysqli_query($con,$sql);
 mysqli_close($con);
 }
 header("Location: cenb4.php");
?>
