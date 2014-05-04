
<%-- 
    Document   : board
    Created on : Mar 11, 2013, 12:47:16 PM
    Author     : kiran
--%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <script
        src="jquery-1.9.1.min.js" >
        </script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <title>board</title>
<meta name="keywords" content="" />
<meta name="description" content="" />

<link href="default.css" rel="stylesheet" type="text/css" media="all" />

    <link  rel="stylesheet" href="boardcss.css" type="text/css" media="all" />
<!--[if IE 6]>
<link href="default_ie6.css" rel="stylesheet" type="text/css" />
<![endif]-->
</head>
<body onload ="dicemove();">
<div id="wrapper">
	<div id="header">
		<div id="logo">
			<h1><a href="#"><span style="font-family: 'Monotype Corsiva', Magneto, Magneto; font-weight: normal; font-style: italic; text-decoration: none; font-size: 40pt;"><font color="#FFFFFF">SNAKES AND LADDERS</span></font></a></h1>
			<br>
		</div>
	</div>
	<!-- end #header -->
	<div id="menu-wrapper">
		<div class="ribbon ribbon-content">
			<div id="menu" align : "right">
				<ul>
					<li class="current_page_item"><a href="index.html"><font size="3px">Home</a></li>
					<li><a href="about.html"><font size="3px">About game</font></a></li>
					<li><a href="registration.html"><font size="3px">Registration</a></li>
					<li><a href="rules.html"><font size="3px">Rules and Regulations</a></li>
					<li><a href="create.html"><font size="3px">create new game</a></li>
					<li><a href="join1.jsp"><font size="3px">join list</a></li>
					<li class="last"><a href="construct.html"><font size="3">Contact us </a></li>
				</ul>
			</div>
		</div>
	</div>
  
   <div id = "table" align = "center">
                  <table cellpadding="10px" cellspacing="10px">
           <tr>
               <td></td>
                   <table border="0" width="100%">
<tr>
<td>
<table border="1">
<tr>
<td>PlayerName</td>
<td>Die Color</td>
<td>Position</td>
</tr>
<%
    String gname=(String) session.getAttribute("gname");
    String pname= (String) session.getAttribute("uname");
%>
<% 
            Class.forName("com.mysql.jdbc.Driver"); 
            
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/snakes_ladders","root","root");
            
            Statement stm = conn.createStatement();
            Statement stm1 = conn.createStatement();
            Statement stm2 = conn.createStatement();
            ResultSet rs=stm.executeQuery("select player_name,player_color,current_position from player_details where game_name='"+gname+"'");
            ResultSet rs1 = stm1.executeQuery("select * from player_details where player_name="+"'"+gname+"'");
            ResultSet rs2 = stm2.executeQuery("select * from player_details where player_name='"+pname+"'");
            int idd1 = 0;
            int idd2 = 0;
            int idd3 = 0;
            int idd4 = 0;
            int d1 = 0;
            /*int turn=0;
            while(rs2.next())
            {
                turn=rs2.getInt("turn");
            }*/
            String color1 =null;
            String color2 = null;
            String color3 = null;
            String color4 = null;
            int i =1;
            while(rs.next()){%>

 <tr>
               <td> <%= rs.getString(1) %> </td>
               <td> <%= rs.getString(2) %> </td>  
               <td> <%= rs.getString(3) %> </td>
 </tr>

            
             <%}       
                      
                   
  while(rs1.next())
  {
     
          idd1=rs1.getInt("current_position");
          color1=rs1.getString("player_color");
        
                

      
  }
             %>

</table>

</td>
                                
                                <td>
 <table  style="table-layout:fixed; overflow-x:hidden;" border="1" background="SL.jpg " width="441px"; height="445px" >
<tr>
<td id="100"></td>
<td id="99">.</td>
<td id="98">.</td>
<td id="97">.</td>
<td id="96">.</td>
<td id="95">.</td>
<td id="94">.</td>
<td id="93">.</td>
<td id="92">.</td>
<td id="91">.</td>
</tr>
<tr>
<td id="81">.</td>
<td id="82">.</td>
<td id="83">.</td>
<td id="84">.</td>
<td id="85">.</td>
<td id="86">.</td>
<td id="87">.</td>
<td id="88">.</td>
<td id="89">.</td>
<td id="90">.</td>
</tr>

<tr>
<td id="80">.</td>
<td id="79">.</td>
<td id="78">.</td>
<td id="77">.</td>
<td id="76">.</td>
<td id="75">.</td>
<td id="74">.</td>
<td id="73">.</td>
<td id="72">.</td>
<td id="71">.</td>
</tr>
     
     
         
        <tr>
<td id="61">.</td>
<td id="62">.</td>
<td id="63">.</td>
<td id="64">.</td>
<td id="65">.</td>
<td id="66">.</td>
<td id="67">.</td>
<td id="68">.</td>
<td id="69">.</td>
<td id="70">.</td>
</tr>
<tr>
<td id="60">.</td>

<td id="59">.</td>

<td id="58">.</td>

<td id="57">.</td>

<td id="56">.</td>

<td id="55">.</td>

<td id="54">.</td>

<td id="53">.</td>
<td id="52">.</td>
<td id="51">.</td>

</tr>
     
     <tr>
<td id="41">.</td>
<td id="42">.</td>
<td id="43">.</td>
<td id="44">.</td>
<td id="45">.</td>
<td id="46">.</td>
<td id="47">.</td>
<td id="48">.</td>
<td id="49">.</td>
<td id="50">.</td>
</tr>
     <tr>

<td id="40">.</td>

<td id="39">.</td>

<td id="38">.</td>

<td id="37">.</td>

<td id="36">.</td>

<td id="35">.</td>

<td id="34">.</td>

<td id="33">.</td>

<td id="32">.</td>
<td id="31">.</td>
</tr>
     
     <tr>
<td id="21">.</td>
<td id="22">.</td>
<td id="23">.</td>
<td id="24">.</td>
<td id="25">.</td>
<td id="26">.</td>
<td id="27">.</td>
<td id="28">.</td>
<td id="29">.</td>
<td id="30">.</td>
</tr>
     <tr>


<td id="20">.</td>

<td id="19">.</td>

<td id="18">.</td>
<td id="17">.</td>
<td id="16">.</td>

<td id="15">.</td>

<td id="14">.</td>

<td id="13">.</td>

<td id="12">.</td>

<td id="11">.</td>
</tr>
<tr>
    <td id="1">.</td>
    <td id="2">.</td>
    <td id="3">.</td>
    <td id="4">.</td>
<td id="5">.</td>
<td id="6">.</td>
<td id="7">.</td>
<td id="8">.</td>
<td id="9">.</td>
<td id="10">.</td>
</tr>

 </table>
                                <td/>
                                <td>
 <table border="0">
                        <tr>
                            <td>
                                <div id="container" align="center" style="border:0px solid black ">        
                                <script>
                                var ctr=0;
                                var d1;
                                var images=new Array();
                                for(i=0;i<=6;i++){
                                images[i]=new Image(); images[i].src="dice/"+i+".JPG";
                                }
                                </script>
                                
                                    <img  alt="HELLOOO"src="dice/6.JPG" name="mydice">
                                
                                        <form name="rand" action="diceroll.jsp">
                                <input id="btt" type="button" value="Roll dice!" onClick="rolldice();">
                                      <input id="tb" type="text" name="dival" value=""></input>
                                    </form>
                               
                                
                                <script>
                                function rolldice(){
                                    var die;
                                if(ctr<6){
                                    
                                 die= showdice();
                                ctr++;
                                setTimeout("rolldice()",150);
                                }
                                else{
                                ctr=0;
                                die =showdice();
                                }
                                
    $("#tb").val(die);
    if(<%=idd1%><"100")
    {
 document.forms["rand"].submit();
    }
    else
        {
            alert("Game Over");
        }
        
                            }
                               function showdice(){
                                d1=Math.floor(Math.random()*6+1);
                                document.images["mydice"].src="dice/"+d1+".JPG";
                                return d1;
                                }
                                function dicemove()
                                {
                                   
    
   if("<%=color1%>"==="green")
    {
    document.getElementById("<%=idd1%>").innerHTML = '<p style=" text-align:right; text-indent: 0px; padding: 0px 0px 0px 0px; margin: 0px 0px 0px 0px;"><img width="10" height="20" alt=""  src="green.jpg"></p></td>';
    }
    else if("<%=color1%>"==="red")
        {
    document.getElementById("<%=idd1%>").innerHTML = '<p style=" text-align:left; text-indent: 0px; padding: 0px 0px 0px 0px; margin: 0px 0px 0px 0px;"><img width="10" height="20" alt=""  src="red.jpg"></p></td>';
    }
    else if("<%=color1%>"==="yellow")
   {
    document.getElementById("<%=idd1%>").innerHTML = '<p style=" text-align:right; text-indent: 0px; padding: 0px 0px 0px 0px; margin: 0px 0px 0px 0px;"><img width=20" height="10" alt=""  src="yellow.jpg"></p></td>';
   }
   else if("<%=color1%>"==="blue")
        {
   document.getElementById("<%=idd1%>").innerHTML = '<p style=" text-align:left; text-indent: 0px; padding: 0px 0px 0px 0px; margin: 0px 0px 0px 0px;"><img width="20" height="10" alt=""  src="blue.jpg"></p></td>';
   }
   if("<%=color2%>"==="green")
    {
    document.getElementById("<%=idd2%>").innerHTML = '<p style=" text-align:right; text-indent: 0px; padding: 0px 0px 0px 0px; margin: 0px 0px 0px 0px;"><img width="10" height="20" alt=""  src="green.jpg"></p></td>';
    }
    else if("<%=color2%>"==="red")
        {
    document.getElementById("<%=idd2%>").innerHTML = '<p style=" text-align:left; text-indent: 0px; padding: 0px 0px 0px 0px; margin: 0px 0px 0px 0px;"><img width="10" height="20" alt=""  src="red.jpg"></p></td>';
    }
    else if("<%=color2%>"==="yellow")
        {
    document.getElementById("<%=idd2%>").innerHTML = '<p style=" text-align:right; text-indent: 0px; padding: 0px 0px 0px 0px; margin: 0px 0px 0px 0px;"><img width=20" height="10" alt=""  src="yellow.jpg"></p></td>';
   }
   else if("<%=color2%>"==="blue")
        {
   document.getElementById("<%=idd2%>").innerHTML = '<p style=" text-align:left; text-indent: 0px; padding: 0px 0px 0px 0px; margin: 0px 0px 0px 0px;"><img width="20" height="10" alt=""  src="blue.jpg"></p></td>';
   
   }
   if("<%=color3%>"==="green")
    {
    document.getElementById("<%=idd3%>").innerHTML = '<p style=" text-align:right; text-indent: 0px; padding: 0px 0px 0px 0px; margin: 0px 0px 0px 0px;"><img width="10" height="20" alt=""  src="green.jpg"></p></td>';
    }
    else if("<%=color3%>"==="red")
        {
    document.getElementById("<%=idd3%>").innerHTML = '<p style=" text-align:left; text-indent: 0px; padding: 0px 0px 0px 0px; margin: 0px 0px 0px 0px;"><img width="10" height="20" alt=""  src="red.jpg"></p></td>';
    }
    else if("<%=color3%>"==="yellow")
        {
    document.getElementById("<%=idd3%>").innerHTML = '<p style=" text-align:right; text-indent: 0px; padding: 0px 0px 0px 0px; margin: 0px 0px 0px 0px;"><img width=20" height="10" alt=""  src="yellow.jpg"></p></td>';
   }
   else if("<%=color3%>"==="blue")
        {
   document.getElementById("<%=idd3%>").innerHTML = '<p style=" text-align:left; text-indent: 0px; padding: 0px 0px 0px 0px; margin: 0px 0px 0px 0px;"><img width="20" height="10" alt=""  src="blue.jpg"></p></td>';
   
   }
   if("<%=color4%>"==="green")
    {
    document.getElementById("<%=idd4%>").innerHTML = '<p style=" text-align:right; text-indent: 0px; padding: 0px 0px 0px 0px; margin: 0px 0px 0px 0px;"><img width="10" height="20" alt=""  src="green.jpg"></p></td>';
    }
    else if("<%=color4%>"==="red")
        {
    document.getElementById("<%=idd4%>").innerHTML = '<p style=" text-align:left; text-indent: 0px; padding: 0px 0px 0px 0px; margin: 0px 0px 0px 0px;"><img width="10" height="20" alt=""  src="red.jpg"></p></td>';
    }
    else if("<%=color4%>"==="yellow")
        {
    document.getElementById("<%=idd4%>").innerHTML = '<p style=" text-align:right; text-indent: 0px; padding: 0px 0px 0px 0px; margin: 0px 0px 0px 0px;"><img width=20" height="10" alt=""  src="yellow.jpg"></p></td>';
   }
   else if("<%=color4%>"==="blue")
        {
   document.getElementById("<%=idd4%>").innerHTML = '<p style=" text-align:left; text-indent: 0px; padding: 0px 0px 0px 0px; margin: 0px 0px 0px 0px;"><img width="20" height="10" alt=""  src="blue.jpg"></p></td>';
   
   }

     if("<%=idd1%>"==="100")
        {
            alert("Winner:"+"<%=pname%>");
        }
   else if("<%=idd2%>"==="100")
        {
            alert("Winner:"+"<%=pname%>");
        }
   else if("<%=idd3%>"==="100")
        {
            alert("Winner:"+"<%=pname%>");
        }
   else if("<%=idd4%>"==="100")
        {
            alert("Winner:"+"<%=pname%>");
        }
        }
                                </script>
                                </div>

                            </td>
                        </tr>
                        
                    </table>
                                  
                                 </td>  
           </tr>
       </table>
           </tr>
                  </table>
</div>



  </body>
</html>