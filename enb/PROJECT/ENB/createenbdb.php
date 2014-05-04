<?php
session_start();
$ename=$_POST["ename"];
$todate=$_POST["f1"];
$desc=$_POST["desc"];
$fromdate= date("Y-m-d");
$uname=$_SESSION["uname"];
$time=date("h:i:s A", strtotime("now"-12));
$date=date("Y/m/d");
$con=  mysqli_connect("localhost","root","root","enb1");
 if(mysqli_connect_errno())
 {
     echo "connection failed". mysqli_connect_error();
 }
 $sql="insert into  createenb values('$uname','$ename','$fromdate','$todate','$desc')";
 if (mysqli_query($con,$sql))
  {
        $sql1="insert into viewlogs(username,date,time,action) values('$uname','$date','$time','CREATED AN ENB.$ename')";
        mysqli_query($con,$sql1);
     $_SESSION["ename"]=$ename;
  echo "Row inserted successfully";
   header("Location: cenb1.php");
  }
else
  {
  echo "Error in inserting into  table: " . mysqli_error($con);
  }
?>
