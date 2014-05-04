<?php
session_start();
//$ename=$_SESSION["ename"];
$uname=$_SESSION["uname"];
$con=  mysqli_connect("localhost","root","root","enb1");
 if(mysqli_connect_errno())
 {
     echo "connection failed". mysqli_connect_error();
 }
$sql="select enbname from createenb where username='$uname'";
    $result=mysqli_query($con,$sql);
     echo ("<option value='Select'>Select</option>");
    while($row=mysqli_fetch_array($result))
     {
        echo ("<option value='{$row['enbname']}'>{$row['enbname']}</option>");
        
     }
?>
