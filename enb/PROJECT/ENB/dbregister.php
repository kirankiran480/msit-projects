
<?php

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
$con=  mysqli_connect("localhost","root","root","enb1");
 if(mysqli_connect_errno())
 {
     echo "connection failed". mysqli_connect_error();
 }
 $uname=$_POST["uname"];
 $fname=$_POST["fname"];
 $lname=$_POST["lname"];
 $dob=$_POST["dob"];
 $gender=$_POST["gender"];
 $eid=$_POST["email"];
 $pwd=$_POST["pass"];
 $rtpwd=$_POST["repass"];
 $add=$_POST["add"];
 $status=0;
 function random($length)
{
    $chars="abcdefghijklmnopqrstuvwxyz0123456789";
    $str="";
    $size=strlen($chars);
    for($i=0;$i<$length;$i++)
    {
        $str.=$chars[rand(0,$size-1)];
    }
    return $str;
}
$act=  random(rand(5,10));
 $sql="insert into  register values('$uname','$fname','$lname','$pwd','$eid','$dob','$gender','$add',$status,'$act')";
  $body="hello $uname,\n\n you have registered into our Engineering Note Book.\n
      \n click the link below to activate your account\n\nhttp://localhost/enb1/activate.php?id=$uname&code=$act";
 if (mysqli_query($con,$sql))
  {
      mysqli_query($con,"insert into login values('$uname','$pwd','$eid',0)");
    echo "Row inserted successfully";
     if(mail($eid,"registration into the Engineering Note Book",$body))
  {
      
  }
  echo "Row inserted successfully";
   header("Location: login.php");
  }
else
  {
  echo "Error in inserting into  table: " . mysqli_error($con);
 
  }
?>

