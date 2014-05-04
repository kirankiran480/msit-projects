<?php

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
$eid=$_GET["q"];
 $count='';
 //echo $eid;
$con=  mysqli_connect("localhost","root","root","enb1");
 if(mysqli_connect_errno())
 {
     echo "connection failed". mysqli_connect_error();
 }
 $sql="select count(*) as c from register where emailid='$eid'";
 $result=mysqli_query($con,$sql);
 while($row=mysqli_fetch_array($result))
 {
     $count=$row["c"];
 }
 if($count!=0)
 {
    echo "1";
 }
 else 
 {
echo "0";     
}
?>
