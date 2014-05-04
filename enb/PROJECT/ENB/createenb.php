  <TITLE>Engineering Note Book</TITLE>
  <META NAME="Generator" CONTENT="EditPlus">
  <META NAME="Author" CONTENT="">
  <META NAME="Keywords" CONTENT="">
  <META NAME="Description" CONTENT="">
   <link rel="stylesheet" type="text/css" href="css/style1.css">
    <?php
                            session_start();
                            ?>
  <script type="text/javascript">
      var e = "0";
      function validenbname()
      {
          var ename=document.getElementById("ename").value;
            //var name=/^[A-Za-z]/;
            if(ename.length==0)
                {
                    alert("enter a valid enbname");
                    return false;
                }
          if(e=="1")
              {
                  alert("enb name is not available");
                  return false;
              }
              else
                  return true;
      }
  function validateform()
{
	
        if(!validdesc()){return false;}
    if(!validdate()){return false;}
    if(!validenbname()){return false;}
    return true;
      
}
function enbname()
        {
            var ename=document.getElementById("ename").value;
            //var name=/^[A-Za-z]/;
            if(ename.length==0)
                {
                    alert("enter a valid enbname");
                    return false;
                }
                        if(window.XMLHttpRequest)
                            {
                                xmlHttp=new XMLHttpRequest();
                            }
                            else
                             {
                                xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
                              }         
      xmlHttp.onreadystatechange=function()
      {
           
          if (xmlHttp.readyState==4 && xmlHttp.status==200)
         {
            e=xmlHttp.responseText;
            if(e=='0')
                {
           document.getElementById("msg1").innerHTML="enbname is available";
           return true;
                }
       else if(e=='1')
           {
           document.getElementById("msg1").innerHTML="enbname is not available";
       return false;
         }
  
      }
      }
      xmlHttp.open("GET","enbnameajax.php?q="+ename,true);
      xmlHttp.send();        
        }
        function validdate()
        { 
            var ele=document.getElementById("f1").value;
            //alert(ele);
            var ele1=ele.split("-");
          //alert(ele1[0]);
          var currentTime = new Date();
var month = currentTime.getMonth()+1;
var day = currentTime.getDate();
var year = currentTime.getFullYear();
//alert("monthis:"+month+"day is:"+day+"year is:"+year);
if(ele1[0]>year)
    {
       // alert(ele1[0])
        return true;
    }
    else if(ele1[0]==year)
        {
            if(ele1[1]>month)
                {
                    //alert(ele1[1]);
                    return true;
                }
                else if(ele1[1]==month)
                    {
                        if(ele1[2]>day)
                            {
                                //alert(ele1[2]);
                                return true;
                            }
                            else
                                {
                                     alert("enter a valid date");
                                    return false;
                                }
                    }
                    else
                {
                    alert("enter a valid date");
                    return false;
                }
        }
            else
                {
                    alert("enter a valid date");
                    return false;
                }
        }
           function validdesc()
        {
            var desc=document.getElementById("desc").value;
            if(desc.length==0)
                {
                    alert("enter the description");
                    return false;
                }
                return true;
        }
        
  </script>
 </HEAD>
  <BODY>
 <h1 style="font-family:timesnewroman;text-align:center;color:darkorchid">CREATE ENB</h1>
 <table width="1300">
     <td>
 <div align="left">

<a href="index.php"><img src="images/home.png"></a> 
 </div>
     </td>
     
     <td>
 <div align="right">

<a href="logout.php"><img src="images/logout.png" width="80" height="80"></a> 
 </div>
     </td>
 </table>

 <form action="createenbdb.php" onSubmit="return validateform()" method="post">
                         
 <table align="center" cellpadding="8">  
     <tr>
        <td>ENB NAME:</td><td><input type="text" name="ename" id="ename" onblur="enbname()"></td><div style="position:absolute;top:26%;left:60%;color:red" id="msg1"/>
     </tr>   
     <tr>
	<td>To date</td>
	<td><INPUT type="date" name="f1" id="f1" onblur="validdate()"></td>
    </tr>
<tr>
<td>Description:</td><td><br><textarea rows="3" cols="30"  name="desc" id="desc" onblur="validdesc()"></textarea></td>
</tr>
<tr>
<td><br></td><td><input type="submit" width="30" value="Submit"></td>
</tr>
 </table> 
 </form>
     
 </BODY>
</HTML>

<?php

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
?>
