/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package registration;

import java.io.IOException;
import java.io.PrintWriter;
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
public class create extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        response.setContentType("text/html;charset=UTF-8");
        registerval reg = new registerval();
        HttpSession s = request.getSession(false);
       // HttpSession s=request.getSession(true);
       try
       {
    Connection con= reg.getConnection();
     // s.setAttribute("uname",uname);
    String uname = (String) s.getAttribute("uname");
    String passp = request.getParameter("password");
    String bname = request.getParameter("boardname");
    String tplayers = request.getParameter("totalplayers");
    String dcolor =  request.getParameter("diecolor");
    Statement st,st1,st2 ;
    st= con.createStatement();
    st1 = con.createStatement();
    st2=con.createStatement();
    
    s.setAttribute("createdbname", bname);
   System.out.println("username is "+uname+"boardname is"+bname);
   int x= st.executeUpdate("insert into game_details values ("+"'"+bname+"',"+"'"+passp+"',"+"'"+Integer.parseInt(tplayers)+"',"+"'"+uname+"',"+"'"+1+"')");
   int y= st1.executeUpdate("insert into player_details values ("+"'"+uname+"',"+"'"+bname+"',"+"'"+dcolor+"',"+"'"+1+"',"+"'"+1+"',"+"'"+1+"')");
   if (x!=0 && y !=0)
   {
      response.sendRedirect("board.jsp");
   }
  /*  PrintWriter out = response.getWriter();
        try {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet create</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet create at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }*/
    }
       catch(Exception e)
       {
           e.printStackTrace();
           System.out.println("the exception is"+e);
           JOptionPane.showMessageDialog(null,e);
           response.sendRedirect("create.html");
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
            Logger.getLogger(create.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(create.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(create.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(create.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(create.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(create.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(create.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(create.class.getName()).log(Level.SEVERE, null, ex);
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
