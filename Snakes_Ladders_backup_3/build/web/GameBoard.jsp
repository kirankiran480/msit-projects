<!--
To change this template, choose Tools | Templates
and open the template in the editor.
-->
<%@page import="java.sql.*" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="SNcss.css"/>
        <script type="text/javascript" language="javascript" src="js/jquery-1.9.1.min.js">
            
        </script>
        <script src="js/jquery.transit.min.js" type="text/javascript"></script>
        <script type="text/javascript" language="javascript" src="js/index.js"></script>
        <script type="text/javascript" language="javascript" src="js/Links.js"></script>
        <script type="text/javascript" language="javascript" src="js/GameBoard.js"></script>
    </head>
    <body onload="diceimage()">
        
       <% HttpSession se = request.getSession(false);
       String game=se.getAttribute("Board").toString();
       response.setIntHeader("Refresh", 5);
       String JDBC_Driver = "com.mysql.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost:3306/snakes_ladders";;
        Connection conn = null;
        Class.forName(JDBC_Driver);
            conn = DriverManager.getConnection(DB_URL,"root","admin");
            Statement st=conn.createStatement();
        %>
        <center>
          <p style="float:right;">welcome <%=se.getAttribute("Username")%></p>
    </center>
        <nav>
            <a href="Logout.jsp" id='logout'>Logout</a>
        </nav>
        
        <div class ="tablecss">
            <table border="1" id="gameboard" background="images/board.gif">
                <tr>
                    <td id="100"></td>
                    <td id="99"></td>
                    <td id="98"></td>
                    <td id="97"></td>
                    <td id="96"></td>
                    <td id="95"></td>
                    <td id="94"></td>
                    <td id="93"></td>
                    <td id="92"></td>
                    <td id="91"></td>
                </tr>
                <tr>
                    <td id="81"></td>
                    <td id="82"></td>
                    <td id="83"></td>
                    <td id="84"></td>
                    <td id="85"></td>
                    <td id="86"></td>
                    <td id="87"></td>
                    <td id="88"></td>
                    <td id="89"></td>
                    <td id="90"></td>
                </tr>
                <tr>
                    <td id="80"></td>
                    <td id="79"></td>
                    <td id="78"></td>
                    <td id="77"></td>
                    <td id="76"></td>
                    <td id="75"></td>
                    <td id="74"></td>
                    <td id="73"></td>
                    <td id="72"></td>
                    <td id="71"></td>
                </tr>
                <tr>
                    <td id="61"></td>
                    <td id="62"></td>
                    <td id="63"></td>
                    <td id="64"></td>
                    <td id="65"></td>
                    <td id="66"></td>
                    <td id="67"></td>
                    <td id="68"></td>
                    <td id="69"></td>
                    <td id="70"></td>
                </tr>
                <tr>
                    <td id="60"></td>
                    <td id="59"></td>
                    <td id="58"></td>
                    <td id="57"></td>
                    <td id="56"></td>
                    <td id="55"></td>
                    <td id="54"></td>
                    <td id="53"></td>
                    <td id="52"></td>
                    <td id="51"></td>
                </tr>
                <tr>
                     <td id="41"></td>
                    <td id="42"></td>
                    <td id="43"></td>
                    <td id="44"></td>
                    <td id="45"></td>
                    <td id="46"></td>
                    <td id="47"></td>
                    <td id="48"></td>
                    <td id="49"></td>
                    <td id="50"></td>
                </tr>
                <tr>
                    <td id="40"></td>
                    <td id="39"></td>
                    <td id="38"></td>
                    <td id="37"></td>
                    <td id="36"></td>
                    <td id="35"></td>
                    <td id="34"></td>
                    <td id="33"></td>
                    <td id="32"></td>
                    <td id="31"></td>
                </tr>
                <tr>
                    <td id="21"></td>
                    <td id="22"></td>
                    <td id="23"></td>
                    <td id="24"></td>
                    <td id="25"></td>
                    <td id="26"></td>
                    <td id="27"></td>
                    <td id="28"></td>
                    <td id="29"></td>
                    <td id="30"></td>
                </tr>
                <tr>
                    <td id="20"></td>
                    <td id="19"></td>
                    <td id="18"></td>
                    <td id="17"></td>
                    <td id="16"></td>
                    <td id="15"></td>
                    <td id="14"></td>
                    <td id="13"></td>
                    <td id="12"></td>
                    <td id="11"></td>
                </tr>
                <tr>
                    <td id="1"></td>
                    <td id="2"></td>
                    <td id="3"></td>
                    <td id="4"></td>
                    <td id="5"></td>
                    <td id="6"></td>
                    <td id="7"></td>
                    <td id="8"></td>
                    <td id="9"></td>
                    <td id="10"></td>
                </tr>
            </table></div>
            <div class="playercss">
                <form name="diceform" action="gamedice.jsp" id="diceform">
                <br/>
                <br/>
                <center>
                    <input type="button" name="rolldice" type="rolldice" value="roll dice" id="rolldice" onclick="return frame()"/>
                    <% //String pose=request.getParameter("position");
                    //int pos = Integer.parseInt(pose);
                    %>
</center>
            <table width="350" height="60">
                <tr><td>Player name</td><td>Color</td><td>Position</td></tr>
                    <% String color1=null,color2=null,color3=null,color4= null,cp1=null,cp2=null,cp3=null,cp4=null; %>
                        <%try
                        {ResultSet rs=st.executeQuery("(select player_name,player_color,current_position,turn from player_details where game_name='"+game+"')");
                       int i=1; while(rs.next()){%>
                        <% if(i==1)
                            {%>
                        <tr>  <td> <%= rs.getString(1)
                        %></td>                
                            
                            
                            <%color1= rs.getString(2); %>
                    <td> <%= rs.getString(2)
%></td>
                    
                    <%cp1 = rs.getString(3);%>
                    
                    <td> <%= rs.getString(3)
%></td>
                    
                </tr>
               <%}%>
                <% if(i==2)
                            {%>
                        <tr>  <td> <%= rs.getString(1)
                        %></td>                
                            
                            
                            <%color2= rs.getString(2); %>
                    <td> <%= rs.getString(2)
%></td>
                    
                    <%cp2 = rs.getString(3);%>
                    
                    <td> <%= rs.getString(3)
%></td>
                    
                </tr>
               <%}%>
                <% if(i==3)
                            {%>
                        <tr>  <td> <%= rs.getString(1)
                        %></td>                
                            
                            
                            <%color3= rs.getString(2); %>
                    <td> <%= rs.getString(2)
%></td>
                    
                    <%cp3 = rs.getString(3);%>
                    
                    <td> <%= rs.getString(3)
%></td>
                    
                </tr>
               <%}%>
                <% if(i==4)
                            {%>
                        <tr>  <td> <%= rs.getString(1)
                        %></td>                
                            
                            
                            <%color4= rs.getString(2); %>
                    <td> <%= rs.getString(2)
%></td>
                    
                    <%cp4 = rs.getString(3);%>
                    
                    <td> <%= rs.getString(3)
%></td>
                    
                </tr>
               <%}%>
               <% i++; %> 
               <script>
            function diceimage()
{
    document.getElementById("<%=cp1%>").innerHTML="<div style='background-color:<%=color1%>;width:10px;height:10px;'></div>";
        document.getElementById("<%=cp2%>").innerHTML="<div style='background-color:<%=color2%>;width:10px;height:10px;'></div>";
    document.getElementById("<%=cp3%>").innerHTML="<div style='background-color:<%=color3%>;width:10px;height:10px;'></div>";
    document.getElementById("<%=cp4%>").innerHTML="<div style='background-color:<%=color4%>;width:10px;height:10px;'></div>";

}
            </script>
                  <%}
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                        }
                        %>
                        
                </tr>
            </table>
                <br/>
                
            <img src="images/dice1.PNG" id ="dice"name="dice" alt="p"/>
                        <input type="text" name="valuedice" style="width: 30px;margin-left: 100px;"id="valuedice"/>
              </form>  
            </div>
        
    </body>
</html>
