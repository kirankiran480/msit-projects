<html>
    <head>
        <title>Engineering Note Book</title>
        <link rel="stylesheet" type="text/css" href="css/style1.css">
    </head>
    <body>
        <div style="position:absolute;top:35%;left:40%;color:red">
<?php

$id=$_GET['id'];
$code=$_GET['code'];
if($id&&$code)
{
    $con=  mysqli_connect("localhost","root","root","enb1");
 if(mysqli_connect_errno())
 {
     echo "connection failed". mysqli_connect_error();
 }
 $sql="select status from register where Username='$id'&&code='$code'";
 $result1=mysqli_query($con, $sql);
 echo mysqli_error($con);
 if($row=  mysqli_fetch_array($result1))
 {
    
     if($row['status']==0)
     {
         $sql1="update register set status=1 where username='$id'&&code='$code'";
         mysqli_query($con,$sql1);
         echo "we have activated your account";
         mysqli_query($con,"update login set status=1 where username='$id'");
     }
     else
     {
         echo "your account is already activated";
     }
 }
}
 else {
die("data is missing!");    
}
?>
        </div>
    </body>