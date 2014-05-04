/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package registration;

import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author kiran
 */
@WebServlet(name = "registerval", urlPatterns = {"/registerval"})
public class registerval extends HttpServlet 
{

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
     public Connection getConnection() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
 {
         Class.forName("com.mysql.jdbc.Driver").newInstance ();
         
         Connection con = null;
         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/snakes_ladders","root","root");
         
       return con;
    }
    public void closeConnection(Connection con) throws SQLException
    {
        con.close();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        response.setContentType("text/html;charset=UTF-8");
        Map<String, String> errors = new HashMap<String, String>();
        String err="";
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String login = request.getParameter("login");
        String dob = request.getParameter("dob");
        String sex = request.getParameter("sex");
        String mail = request.getParameter("mail");
        String pwd = request.getParameter("pwd");
        String address = request.getParameter("address");
        String secret = request.getParameter("secret");
        String answer = request.getParameter("answer");
        String altmail = request.getParameter("altmail");
        String pat1="\\w+";
        String pat2="\\w+";
        String pat3="(([A-Za-z0-9_\\-\\.])+\\@([A-Za-z0-9_\\-\\.])+\\.([A-Za-z]{2,4}))(((;|,|; | ;| ; | , | ,){1}"
		+"([A-Za-z0-9_\\-\\.])+\\@([A-Za-z0-9_\\-\\.])+\\.([A-Za-z]{2,4}))*)";
        String pat4="\\w+";
        
        if ("".equals(firstname) || (firstname.length()< 5 || firstname.length()> 20) ||  !firstname.toLowerCase().matches(pat1))
        {
            errors.put("firstname", ": length 5 to 20 characters : Should not contain spaces and special characters");
            
        }
        if (    "".equals(lastname) || (lastname.length()< 5 || lastname.length()> 20) ||  !lastname.toLowerCase().matches(pat1))
        {
            errors.put("lastname", ":length 5 to 20 characters : Should not contain spaces and special characters");
        }
        if (    "".equals(login) || (login.length()< 5 || login.length()> 10) ||  !login.matches(pat2))
        {
            errors.put("username", ": length 5 to 10 characters : Should not contain spaces");
        }
        if (    "".equals(dob) || Integer.parseInt(dob.substring(0,4))<1950 || Integer.parseInt(dob.substring(0,4))>2008)
        {
            errors.put("dob", ": you should be born between 1950 and 2008 to play");
        }
        if (sex==null)
        {
            errors.put("sex", ": Enter your gender");
        }
        if (    "".equals(mail) || !mail.matches(pat3))
        {
            errors.put("mail", ": Enter valid email");
        }
        if (    "".equals(pwd) || (pwd.length()<5 || pwd.length()>10) || !pwd.matches(pat4))
        {
            errors.put("password", "Enter valid password");
        }
       /* if ( !password.equals(repass))
        {
            errors.put("repass", "Password does not match");
        }*/
        if (    "".equals(address))
        {
             errors.put("address", "Enter valid address");
        }
        if (    "".equals(secret))
        {
             errors.put("secret", "Enter secret question");
        }
        if (    "".equals(answer))
        {
             errors.put("answer", "Answer the question");
        }
        System.out.println(err);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        if (!errors.isEmpty())
        {
            //JOptionPane op = new JOptionPane();
            JOptionPane.showMessageDialog(null,"you have entered invalid information");
            response.sendRedirect("registration.html"); 
            
        /*try {
            //TODO output your page here. You may use following sample code. 
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet registration</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("Sorry! there were errors.");
            Iterator iterator = errors.keySet().iterator();
            while (iterator.hasNext()) 
            {
            String key = iterator.next().toString();
            String value = errors.get(key).toString();
            out.println(key + " " + value);
            out.println("<br>");
            }
            out.println("</body>");
            out.println("</html>");
        } 
        catch(Exception e)
        {
            
        }*/
            
        }
        else
        {
        
            Connection con = getConnection();
            String query1="use snakes_ladders";
            PreparedStatement p = con.prepareStatement(query1);
              String sql = "insert into user_details values (?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, firstname);
                pst.setString(2, lastname);
                pst.setString(3, login);
                pst.setString(4, dob);
                pst.setString(5, sex);
                pst.setString(6, mail);
                pst.setString(7, pwd);
                pst.setString(8, address);
                pst.setString(9, secret);
                pst.setString(10, answer);
                pst.setString(11, altmail);
          //  int numRowsChanged = pst.executeUpdate();
         //   PrintWriter out = response.getWriter();
             try
        {
            int numRowsChanged=pst.executeUpdate();
            response.sendRedirect("create.html"); 
        }
        catch(Exception e){
        JOptionPane.showMessageDialog(null,"you have entered invalid information");
        response.sendRedirect("registration.html"); 
        }
 
        /*try {
             TODO output your page here. You may use following sample code.
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            
            out.println("<head>");
            
            out.println("<title>Servlet registrationservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + login+ "</h1>");
            out.println("<table border='0' bgcolor='#000000'>");
         out.println("<tr>");

            out.println("<th width='250' font='arial' size='5' color='#DEDDDD' ><a href='create.html'>NEW GAME</td>");
            out.println("<th width='250' font='arial' size='5' color='#DEDDDD' ><a href='join.html'>JOIN</td>");

            out.println("</tr>");
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
            closeConnection(con);


            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }*/
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
             Logger.getLogger(registerval.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(registerval.class.getName()).log(Level.SEVERE, null, ex);
         } catch (InstantiationException ex) {
             Logger.getLogger(registerval.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
             Logger.getLogger(registerval.class.getName()).log(Level.SEVERE, null, ex);
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
             Logger.getLogger(registerval.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(registerval.class.getName()).log(Level.SEVERE, null, ex);
         } catch (InstantiationException ex) {
             Logger.getLogger(registerval.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
             Logger.getLogger(registerval.class.getName()).log(Level.SEVERE, null, ex);
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
