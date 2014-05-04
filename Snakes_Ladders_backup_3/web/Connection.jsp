
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java" session="true" %>
<%
Connection conn = null;
	String url = "jdbc:mysql://localhost:3306/";
	String dbName = "snakes_ladders";
	String driver = "com.mysql.jdbc.Driver";
	String usernam = "root"; 
	String userPassword = "admin";
       
	 


    try {
      Class.forName(driver).newInstance();
      conn = DriverManager.getConnection(url+dbName,usernam,userPassword);
	  
	
    } catch (Exception e) {
      e.printStackTrace();
    }
 %> 
