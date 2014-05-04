/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnect;

/**
 *
 * @author kiran
 */

    import java.sql.*;

public class dbconn{
  public static void main(String[] args) {
  System.out.println("MySQL Connect Example.");
  Connection conn = null;
  String url = "jdbc:mysql://localhost:3306/";
  //String dbName = "jdbctutorial";
  String driver = "com.mysql.jdbc.Driver";
  String userName = "root"; 
  String password = "root";
  try {
  Class.forName(driver).newInstance();
  
  conn = DriverManager.getConnection(url,userName,password);
  System.out.println("Connected to the database");
  Statement st,st2 = null;
  st = conn.createStatement();
  ResultSet rs ,rs2;
  rs = st.executeQuery("show databases");
  while(rs.next())
  {
      String database = rs.getString("Database");
      System.out.println(database);
  }
  
  //st.executeUpdate("create database "+"reader9db");
  st.executeQuery("use reader9db");
  st.executeUpdate("create table userprofile(username varchar(10),password varchar(10),email varchar(10),profession varchar(10),company varchar(10))");
  
          conn.close();
  System.out.println("Disconnected from database");
  } catch (Exception e) {
  e.printStackTrace();
  }
  }
}
