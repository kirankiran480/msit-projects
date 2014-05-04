<?php

$enam=$_POST["enb"];
session_start();
$con=  mysqli_connect("localhost","root","root","enb1");
$uname=$_SESSION["uname"];
if(isset($_SESSION['ename']))
    $_SESSION['ename']=$enam;
$time=date("h:i:s A", strtotime("now"-12));
$date=date("Y/m/d");
$sql1="insert into viewlogs(username,date,time,action) values('$uname','$date','$time','EDITED AN ENB.$enam')";
        mysqli_query($con,$sql1);
header("location:eenb1.php");
?>
