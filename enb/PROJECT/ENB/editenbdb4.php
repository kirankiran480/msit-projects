<?php
session_start();
$ename=$_SESSION["ename"];
$uname=$_SESSION["uname"];
//$b=$_SESSION["ename"];
$context=$_POST["deliverable"];
$lesson=$_POST["what"];
$con=  mysqli_connect("localhost","root","root","enb1");
if(mysqli_connect_errno())
 {
     echo "connection failed". mysqli_connect_error();
 }
$sql="delete from cenb4 where username='$uname' and enbname='$ename'";
 mysqli_query($con,$sql);
 mysqli_close($con);
  foreach($context as $array=>$innerarray)
 {
  $con=  mysqli_connect("localhost","root","root","enb1");
 if(mysqli_connect_errno())
 {
     echo "connection failed". mysqli_connect_error();
 }
 $sql="insert into  cenb4(username,enbname,deliverable,what) values('$uname','$ename','$context[$array]','$lesson[$array]')";
 mysqli_query($con,$sql);
 mysqli_close($con);
 }
 header("Location: index.php");
?>
