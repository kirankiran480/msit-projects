<?php
session_start();
$uname=$_SESSION["uname"];
$con=  mysqli_connect("localhost","root","root","enb1");
$time=date("h:i:s A", strtotime("now"-12));
$date=date("Y/m/d");
$sql10="insert into viewlogs(username,date,time,action) values('$uname','$date','$time','LOGOUT FROM THE APPLICATION')";
 mysqli_query($con,$sql10);
session_destroy();
header("Location:login.php");
?>
