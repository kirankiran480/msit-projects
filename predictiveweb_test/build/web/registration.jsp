
<%@page import="java.io.File"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Connection"%>
<%@page session="false" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<% 
      Class.forName("com.mysql.jdbc.Driver").newInstance();  
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/predict_db","root","root");  
      Statement stmt = con.createStatement(); 
     String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String login = request.getParameter("login");
        String dob = request.getParameter("dob");
        String sex = request.getParameter("sex");
        String mail = request.getParameter("mail");
        String pwd = request.getParameter("pwd");
        String secret = request.getParameter("secret");
        String answer = request.getParameter("answer");
        String altmail = request.getParameter("altmail");
       String query1="use predict_db";
            PreparedStatement p = con.prepareStatement(query1);
              String sql = "insert into user_details values (?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, firstname);
                pst.setString(2, lastname);
                pst.setString(3, login);
                pst.setString(4, dob);
                pst.setString(5, sex);
                pst.setString(6, mail);
                pst.setString(7, pwd);
                pst.setString(8, secret);
                pst.setString(9, answer);
                pst.setString(10, altmail);
                try
        {
            int numRowsChanged=pst.executeUpdate();
            if(numRowsChanged!=0)
            {
              String dir =  config.getServletContext().getRealPath("/")+"uploadedFiles/"+login;
               System.out.println(dir);
                          
File resultFile = new File(dir);  
resultFile.mkdirs(); 
              con.close();
              session.invalidate();
               response.sendRedirect("login.html"); 
            }
            // 
        }
        catch(Exception e)
        {
       // JOptionPane.showMessageDialog(null,"you have entered invalid information");
       // response.sendRedirect("registration.html"); 
        }
               
     
      %>

