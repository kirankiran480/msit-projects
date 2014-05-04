<?php
session_start();
$uname=$_SESSION["uname"];
$ename=$_GET["q"];
 $count='';
$con=  mysqli_connect("localhost","root","root","enb1");
echo mysqli_error($con);
 if(mysqli_connect_errno())
 {
     echo "connection failed". mysqli_connect_error();
 }
  $sql="select * from createenb where enbname='$ename' and username='$uname'";
  $result=mysqli_query($con,$sql);
 if(mysqli_num_rows($result)!=0)
    {
        echo "1";
    }
else
    {
        echo "0";
    }
?>
