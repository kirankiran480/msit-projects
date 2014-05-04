<?php
session_start();
$uname=$_SESSION['uname'];
$enbname=$_POST['enb'];
include("/MPDF/mpdf.php");
$con=  mysqli_connect("localhost","root","root","enb1");
$time=date("h:i:s A", strtotime("now"-12));
$date=date("Y/m/d");
$sql10="insert into viewlogs(username,date,time,action) values('$uname','$date','$time','DOWNLOADED AN ENB.$enbname')";
 mysqli_query($con,$sql10);
$mpdf=new mPDF();
$mpdf->WriteHTML('<h1>Engineering Note Book</h1>');
$html='<br>'.'user :-'.$uname.'<br>'.'enbname:-'.$enbname;
$html.="<br>";
$sql="select * from createenb where username='$uname' and enbname='$enbname'";
$res = mysqli_query($con,$sql);
while($row = mysqli_fetch_array($res)){
    $html.='start date is:'.$row['fromdate'].'<br>';
    $html.='end date is:'.$row['todate'].'<br>';
    $html.='its description is:'.$row['description'].'<br>';
    $html.='============================================================.<br>';
}
$sql1="select * from cenb1 where username='$uname' and enbname='$enbname'";
$html.='NOTES'.'<br>';
$html.='======'.'<br>';
$res1 = mysqli_query($con,$sql1);
while($row = mysqli_fetch_array($res1)){
    $html.=$row['description'].'<br>';
    $html.='============================================================.<br>';
}
$html.='DELIVERABLES STATUS'.'<br>';
$html.='==================='.'<br>';
$sql2="select * from cenb2 where username='$uname' and enbname='$enbname'";
$res2= mysqli_query($con,$sql2);
$html.='<table border=1>';
 $html.='<tr>';
    $html.='<td>'.'deliverables'.'</td>';
    $html.='<td>'.'plan'.'</td>';
    $html.='<td>'.'actual'.'</td>';
    $html.='<td>'.'size'.'</td>';
    $html.='<td>'.'effort'.'</td>';
    $html.='</tr>';
while($row = mysqli_fetch_array($res2)){
    $html.='<tr>';
    $html.='<td>'.$row['deliverables'].'</td>';
    $html.='<td>'.$row['plan'].'</td>';
    $html.='<td>'.$row['actual'].'</td>';
    $html.='<td>'.$row['size'].'</td>';
    $html.='<td>'.$row['effort'].'</td>';
    $html.='</tr>';
}
$html.='</table>';
$html.='============================================================.<br>';
$html.='LESSONS LEARNED'.'<br>';
$html.='==============='.'<br>';
$sql2="select * from cenb3 where username='$uname' and enbname='$enbname'";
$res2= mysqli_query($con,$sql2);
$html.='<table border=1>';
$html.='<tr>';
    $html.='<td>'.'context'.'</td>';
    $html.='<td>'.'lesson'.'</td>';
    $html.='</tr>';
while($row = mysqli_fetch_array($res2)){
    $html.='<tr>';
    $html.='<td>'.$row['context'].'</td>';
    $html.='<td>'.$row['lesson'].'</td>';
    $html.='</tr>';
}
$html.='</table>';
$html.='============================================================.<br>';
$html.='plan FOR THE NEXT WEEK'.'<br>';
$html.='======================'.'<br>';
$sql3="select * from cenb4 where username='$uname' and enbname='$enbname'";
$res2= mysqli_query($con,$sql3);
$html.='<table border=1>';
$html.='<tr>';
    $html.='<td>'.'Deliverable'.'</td>';
    $html.='<td>'.'What needs to be accomplished and why'.'</td>';
    $html.='</tr>';
while($row = mysqli_fetch_array($res2)){
    $html.='<tr>';
    $html.='<td>'.$row['deliverable'].'</td>';
    $html.='<td>'.$row['what'].'</td>';
    $html.='</tr>';
}
$html.='</table>';
$mpdf->WriteHTML($html);
$mpdf->Output();
?>
