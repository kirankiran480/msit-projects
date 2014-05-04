/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 *
 * @author kiran
 */
public class login extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ClassNotFoundException, InstantiationException {
        try {
    response.setContentType("text/html;charset=UTF-8");
    registerval reg = new registerval();
    Connection con= reg.getConnection();
    String uname = request.getParameter("uname");
     System.out.println(uname);
    String pwd1= request.getParameter("password");
     System.out.println(pwd1);
    ResultSet rs;
    Statement st = null;
    st = con.createStatement();
    System.out.println("select pwd from user_details where login="+"'"+uname+"'");
    rs= st.executeQuery("select pwd from user_details where login="+"'"+uname+"'");
    String pwd = null;
    int flag=0;
  while(rs.next())
  {
        pwd = rs.getString("pwd");
      // flag =0;
        
         if (pwd.equals(pwd1))
    {
        
        HttpSession si=request.getSession(true);
         si.setAttribute("uname",new String(uname));
        response.sendRedirect("join1.jsp");
         flag =1;
    }
  }
  System.out.println("password retrieved"+pwd);
   
    if(flag!=1){
        JOptionPane.showMessageDialog(null,"invalid login,try again!!");
       
        response.sendRedirect("login.html");
    }
    
    /*PrintWriter out = response.getWriter();
    try {
        ////////////////////////   out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet login</title>");            
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet login at " + request.getContextPath() + "</h1>");
        out.println("</body>");
        out.println("</html>");
    } finally {            
        out.close();
    }*/
    reg.closeConnection(con);
}       catch (Exception ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
           // JOptionPane.showMessageDialog(null,"invalid login,try again!!");
        
            //response.sendRedirect("login.html");
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
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
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
