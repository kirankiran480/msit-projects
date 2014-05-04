
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
    <body onload="movedice();" >
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
			<div id="menu" align : "left">
				<ul align ="left">
					<li><a href="index.html">Home</a></li>
					<li><a href="about.html">About game</font></a></li>
                                        <li><a  href="login.html" >Log in</a></li>
					<li><a href="registration.html">Registration</a></li>
					<li><a href="rules.html">Rules </a></li>
					<li><a href="sesschech_create">Create New Game</a></li>
					<li><a href="sesschck_join">Join Game</a></li>
                                        <li><a href="signout">Sign Out</a></li>
					<li><a href="construct.html">Contact us </a></li>
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
    String uname = (String) session.getAttribute("uname");
    String gname = (String) session.getAttribute("gname");
    
    String JDBC_Driver = "com.mysql.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost:3306/snakes_ladders";;
        Connection conn = null;
        Class.forName(JDBC_Driver);
            conn = DriverManager.getConnection(DB_URL,"root","root");
            Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("select * from player_details where player_name="+"'"+uname+"' and game_name="+"'"+gname+"'");
             while(rs.next())
             {
                 %>
            
    <tr>
        <td>
            <%= rs.getString("player_name") %>
        </td>
        <td>
            <%=rs.getString("player_color")%>
        </td>
        <td>
            <%=rs.getString("current_position")%>
        </td>
                 
    </tr>
        <%}%>
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
                                
                                        <form name="randm" action="dice.jsp">
                                            <input id="btt" type="button" value="Roll dice!" onClick="return rolldice();" ></input>
                                      <input id="tb" type="text" name="dival" value=""></input>
                                    </form>
                               
                                
                                <script>
                                function rolldice(){
                                    var die;
                               
                                die = showdice();
                                
                                
    $("#tb").val(die);
    
    document.forms["randm"].submit();
    
        
                            }
                               function showdice(){
                                d1=Math.floor(Math.random()*6+1);
                                //document.images["mydice"].src="dice/"+d1+".JPG";
                                return d1;
                                }
                                <%
             Statement st1 = conn.createStatement();
             ResultSet rs1;
             rs1= st1.executeQuery("select * from player_details where player_name="+"'"+uname+"' and game_name="+"'"+gname+"'");
             while(rs.next())
             {
             %>
                         function movedice(){
                             document.getElementById(<%=rs1.getInt("current_position")%>).innerHTML ="<div style='background-color:<%=rs1.getString("player_color")%>;width:10px;height:10px;'></div>";
                         }   
                         
                         <%} %>
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