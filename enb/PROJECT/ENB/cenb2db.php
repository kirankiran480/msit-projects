<?php
session_start();
$ename=$_SESSION["ename"];
$uname=$_SESSION["uname"];
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
 foreach($deliverables as $array=>$innerarray)
 {
     $con=  mysqli_connect("localhost","root","root","enb1");
 if(mysqli_connect_errno())
 {
     echo "connection failed". mysqli_connect_error();
 }
// echo $uname,$ename;
    //echo $deliverables[$array].$pa[$array].$aa[$array].$size[$array].$effort[$array];
//$sql="insert into  cenb2(username,enbname,deliverables,plan,actual,size,effort) values('$uname',$ename','$deliverables[$array]','$pa[$array]','$aa[$array]','$size[$array]','$effort[$array]')";
  $sql="insert into  cenb2(username,enbname,deliverables,plan,actual,size,effort) values('$uname','$ename','$deliverables[$array]','$pa[$array]','$aa[$array]','$size[$array]','$effort[$array]')";
 mysqli_query($con,$sql);
 mysqli_error($con);
 mysqli_close($con);
 }
header("Location: cenb3.php");
// if (mysqli_query($con,$sql))
//  {
//  echo "Row inserted successfully";
//   header("Location: cenb2.php");
//  }
//else
//  {
//  echo "Error in inserting into  table: " . mysqli_error($con);
//  }
?>
