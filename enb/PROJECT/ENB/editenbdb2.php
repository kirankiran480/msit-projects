<?php
session_start();
$uname=$_SESSION["uname"];
$ename=$_SESSION["ename"];
$deliverables=$_POST["deliverables"];
$pa=$_POST["pa"];
$aa=$_POST["aa"];
$size=$_POST["size"];
$effort=$_POST["effort"];
$con=  mysqli_connect("localhost","root","root","enb1");
 if(mysqli_connect_errno())
 {
     echo "connection failed". mysqli_connect_error();
 }
 $sql="delete from cenb2 where username='$uname' and enbname='$ename'";
 mysqli_query($con,$sql);
 mysqli_close($con);
 foreach($deliverables as $array=>$innerarray)
 {
     $con=  mysqli_connect("localhost","root","root","enb1");
 if(mysqli_connect_errno())
 {
     echo "connection failed". mysqli_connect_error();
 }
//    echo $deliverables[$array].$pa[$array].$aa[$array].$size[$array].$effort[$array];
//    echo "<br>";
  $sql="insert into  cenb2(username,enbname,deliverables,plan,actual,size,effort) values('nagapavan','enb11','$deliverables[$array]','$pa[$array]','$aa[$array]','$size[$array]','$effort[$array]')";
 mysqli_query($con,$sql);
 mysqli_error($con);
 mysqli_close($con);
 }
 header("location:cenb3.php");
?>