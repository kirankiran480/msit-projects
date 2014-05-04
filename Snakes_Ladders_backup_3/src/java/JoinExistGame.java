/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kalyan
 */
public class JoinExistGame extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String un=request.getParameter("uname");
        String bn=request.getParameter("bname");
        String pw=request.getParameter("pass");
        String dc=request.getParameter("color");
        
        
        Connection con=null;
        
        try {
            // TODO code application logic here
            Class.forName(JDBC_Driver);
            con= DriverManager.getConnection(DB_URL,"root","admin");
            Statement st=con.createStatement();
            
            ResultSet rs1=st.executeQuery("(select * from game_details where game_name='"+bn+"')");
            
            int trn=0;
        
            if(rs1.next())
            {
                
             ResultSet rs2=st.executeQuery("(select * from game_details where game_name='"+bn+"')");
             if(rs2.next())
             {
                 System.out.println(rs2.getString(2));
                 if(pw.equalsIgnoreCase(rs2.getString(2)))
                 {
                     HttpSession se = request.getSession(false);
                     se.setAttribute("Board", bn);
                     System.out.println(rs2.getString("passphrase"));
                     String inccount="update game_details set count=count+1";
                     st.executeUpdate(inccount);
                    ResultSet rs3= st.executeQuery("select count(*) as cnt from player_details where game_name='"+bn+"'" );
                    while(rs3.next())
                    {
            System.out.println("trn"+rs3.getInt("cnt"));
            trn=rs3.getInt("cnt")+1;
            
                    }
                     int check2 = st.executeUpdate("insert into player_details values ('"+un+"','"+bn+"','"+dc+"','"+1+"','"+1+"','"+trn+"')");
                     if(check2==1)
                     {
                     response.sendRedirect("GameBoard.jsp");
                 }
                 }
                 
                 else
                 {
                     response.sendRedirect("JoinGames.jsp");
                 }
             }
           
                
            }
            
            else
            {
             
             response.sendRedirect("JoinGames.jsp");
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
        processRequest(request, response);
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
        processRequest(request, response);
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
