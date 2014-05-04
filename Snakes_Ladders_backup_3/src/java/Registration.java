/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Kalyan
 */
public class Registration extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         String fn=request.getParameter("fname");
        String ln=request.getParameter("lname");
        String usr=request.getParameter("uname");
        String dob=request.getParameter("dob");
        String gend=request.getParameter("gender");
        String email=request.getParameter("email");
        String pwd=request.getParameter("password");
        String addr=request.getParameter("addr");
        String sq=request.getParameter("sq");
        String ans=request.getParameter("sqa");
        String aemail=request.getParameter("alte");
       try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		//System.out.println("Where is your MySQL JDBC Driver?");
		e.printStackTrace();
		return;
	}
    
    
    Connection connection = null;
    PreparedStatement pst=null;
    
    
    try
    {
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/snakes_ladders","root", "admin");
      Statement st=connection.createStatement();
      ResultSet rs=st.executeQuery("(select * from user_details where usr='"+usr+"');");
      if(rs.next())
      {
          response.sendRedirect("Register.jsp");
      }
      
      else
      {  
	try {
             
                String sql ="insert into user_details values('"+usr+"','"+fn+"','"+ln+"',  '"+pwd+"','"+email+"','"+gend+"', '"+dob+"','"+addr+"','"+sq+"','"+ans+"','"+aemail+"');";
                pst=connection.prepareStatement(sql);        
                pst.execute(sql);
                //ResultSet rs = stmt.executeQuery(query);
                
	} catch (SQLException e) {
		System.out.println("Connection Failed! Check output console");
		e.printStackTrace();
		return;
	}
 
	if (connection != null) {
		System.out.println("You made it, take control your database now!");
	} else {
		System.out.println("Failed to make connection!");
	}
        
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet registration</title>"); 
            out.println("<link rel="+"'stylesheet'" +"type="+"'text/css'"+"href="+"'SNcss.css'"+"/>");
            out.println("</head>");
            out.println("<body background='images/sn1.jpg'>");
            out.println("<center>");
            out.println("<h1 style="+"'font-family:'Fabrica''"+"> Data registerd successfully"  + "</h1>"+"<br>");
            out.println("</center>");
            out.println("<nav>");
            out.println("<a href=\"Login.jsp\" id='login'>Login</a>");
            out.println("<a href=\"Register.jsp\" id='register'>Sign Up</a>");
            out.println("<a href=\"About.jsp\" id='about'>About Game</a>");
            out.println("<a href=\"Instructions.jsp\" id='instruct'>Instructions</a>");
            out.println("<a href=\"CreateGame.jsp\" id='create'>Create Game</a>");
            out.println("<a href=\"JoinGames.jsp\" id='join'>Join Game</a>");
            out.println("<a href=\"Contact.jsp\" id='contact'>Contact Us</a>");
            out.println("</nav>");
            out.println("<center>");
            out.println("<br><br>");
            out.println("<p>The Data has been registered Succesfully.Either create a new game or join an existing game</p>");
            out.println("<form action='CreateGame.jsp' method='get'>");
            out.println("<button type=submit name=createsubmit> Start a New Game </button>"+"<br>");
            out.println("</form>");
            out.println("<form action='JoinGames.jsp' method='get'>");
            out.println("<button type=submit name=createsubmit> Join Existing Game </button>"+"<br>");
            out.println("</form>");
             out.println("</center>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
      }
    }
    
    catch(Exception e)
    {
        e.printStackTrace();
    }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
