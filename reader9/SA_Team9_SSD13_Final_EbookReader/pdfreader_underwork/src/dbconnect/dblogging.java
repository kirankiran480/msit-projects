/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnect;

import java.sql.*;
//import java.sql.DriverManager;

/**
 *
 * @author PRAVEEN
 */
public class dblogging {
    
    
    public Statement stmt ;
    public String url = "jdbc:mysql://localhost:3306/";
    public String dbName = "reader9db";
    public String driver = "com.mysql.jdbc.Driver";
    public String userName = "root"; 
    public String password = "root";
    
    
    public boolean logverification(String name,String pass){
        System.out.println("MySQL Connect Example.");
        
        boolean val = false ;
        try {
            Class.forName(driver).newInstance();
            Connection con = DriverManager.getConnection(url,userName,password);
            stmt = con.createStatement();
            //stmt.execute("use reader9db");
            ResultSet rs = stmt.executeQuery("select * from reader9db.userprofile");
            for(;rs.next();)
            {
                String uname = rs.getString("username");
                String pword = rs.getString("password");
                if (uname.equals(name) && pword.equals(pass))
                {
                    val = true ;
                }
            }
            con.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return val;
    }
}
