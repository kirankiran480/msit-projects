<?php

$mail=$_POST["mail"];
$con=  mysqli_connect("localhost","root","root","enb1");
 if(mysqli_connect_errno())
 {
     echo "connection failed". mysqli_connect_error();
 }
 $sql="select * from login where emailid='$mail'";
 $result=mysqli_query($con,$sql);
 while($row=mysqli_fetch_array($result))
 {
     $count=$row["password"];
     $user=$row["username"];
 }
 $body="hello $user \n\n you have forgotten your password
         \n\n your password is $count";
 mail($mail,"forgot password for Engineering Note Book",$body);
?>
