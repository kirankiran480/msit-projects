<?php
session_start();
$desc=$_POST["add"];
$date = date( "d/m/Y h:i:s", time() );
$ename=$_SESSION["ename"];
$uname=$_SESSION["uname"];
//echo $a;
$c=$desc."\n---last saved at".$date;
//echo $c;
$con=  mysqli_connect("localhost","root","root","enb1");
 if(mysqli_connect_errno())
 {
     echo "connection failed". mysqli_connect_error();
 }
  $sql="insert into  cenb1 values('$uname','$ename','$c')";
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
