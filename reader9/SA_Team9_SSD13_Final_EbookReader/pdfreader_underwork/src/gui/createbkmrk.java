/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author kiran
 */
public class createbkmrk {
    
    public void createbk(String bookname,int pgno,String user) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        
    
    System.out.println("MySQL Connect Example.");
  Connection conn = null;
  String url = "jdbc:mysql://localhost:3306/";
  //String dbName = "jdbctutorial";
  String driver = "com.mysql.jdbc.Driver";
  String userName = "root"; 
  String password = "root";
 
  Class.forName(driver).newInstance();
  
  conn = DriverManager.getConnection(url,userName,password);
  System.out.println("Connected to the database");
  Statement st,st2 = null;
  st = conn.createStatement();
  st.executeQuery("use reader9db");
  st.executeUpdate("insert into bookmarks(username,bookname,bookmarks) values('" + user.toString() + "','"+ bookname.toString() +"','"+ pgno + "' )");
  
}
}
