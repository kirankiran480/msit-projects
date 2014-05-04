<?php
session_start();
$uname=$_POST["lname"];
$pwd=$_POST["pwd"];
$time=date("h:i:s A", strtotime("now"-12));
$date=date("Y/m/d");
$con=  mysqli_connect("localhost","root","root","enb1");
echo mysqli_error($con);
 if(mysqli_connect_errno())
 {
     echo "connection failed". mysqli_connect_error();
 }
 $sql="select password,status from register where username='$uname'";
 $result=  mysqli_query($con,$sql);
 while($row = mysqli_fetch_array($result))
  {
    $password=$row['password'];
    $status=$row['status'];
  }
 if(strcmp($pwd,$password)==0)
 {
     if($status==0)
     header("Location: activation.php");
     else
     {
          $sql1="insert into viewlogs(username,date,time,action) values('$uname','$date','$time','LOGIN INTO THE APPLICATION')";
        mysqli_query($con,$sql1);
     $_SESSION["uname"]=$uname;
     header("Location: index.php");
     }
 }
 else {
     header("Location: login.php");
 }
?>
