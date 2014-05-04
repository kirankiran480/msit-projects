/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kalyan
 */
@WebServlet(name = "CreateNewGame", urlPatterns = {"/CreateNewGame"})
public class CreateNewGame extends HttpServlet {
    
  static final String JDBC_Driver = "com.mysql.jdbc.Driver";
  static final String DB_URL = "jdbc:mysql://localhost:3306/snakes_ladders";;

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
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String un=request.getParameter("uname");
        String bn=request.getParameter("bname");
        String pw=request.getParameter("pass");
        String np=request.getParameter("number");
        String dc=request.getParameter("color");
        int count=1;
      
        
        Connection con=null;
        
        
         try {
            // TODO code application logic here
            Class.forName(JDBC_Driver);
            con= DriverManager.getConnection(DB_URL,"root","admin");
            Statement st=con.createStatement();
            
            ResultSet rs1=st.executeQuery("(select * from game_details where game_name='"+bn+"')");
            
            if(rs1.next())
            {
                response.sendRedirect("CreateGame.jsp");
            }
            
            else
            {
             int count1 = 1;
             int check=st.executeUpdate("insert into game_details values('"+bn+"','"+pw+"','"+np+"','"+un+"','"+count+"')");
              int check2=st.executeUpdate("insert into player_details values('"+un+"','"+bn+"','"+dc+"','"+"1"+"','"+"1"+"','"+count1+"')");
              HttpSession se = request.getSession(false);
              se.setAttribute("Board", bn);
             if(check == 1 && check2==1)
             {
                  response.sendRedirect("GameBoard.jsp");
             }
                    else{
                        response.sendRedirect("CreateGame.jsp");
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
            Logger.getLogger(CreateNewGame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CreateNewGame.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CreateNewGame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CreateNewGame.class.getName()).log(Level.SEVERE, null, ex);
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
