package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;

public final class board_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n");
      out.write("\n");
      out.write("\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      out.write("<head>\n");
      out.write("    <script\n");
      out.write("        src=\"jquery-1.9.1.min.js\" >\n");
      out.write("        </script>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write(" <title>board</title>\n");
      out.write("<meta name=\"keywords\" content=\"\" />\n");
      out.write("<meta name=\"description\" content=\"\" />\n");
      out.write("\n");
      out.write("<link href=\"default.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />\n");
      out.write("\n");
      out.write("    <link  rel=\"stylesheet\" href=\"boardcss.css\" type=\"text/css\" media=\"all\" />\n");
      out.write("<!--[if IE 6]>\n");
      out.write("<link href=\"default_ie6.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("<![endif]-->\n");
      out.write("</head>\n");
      out.write("<body >\n");
      out.write("<div id=\"wrapper\">\n");
      out.write("\t<div id=\"header\">\n");
      out.write("\t\t<div id=\"logo\">\n");
      out.write("\t\t\t<h1><a href=\"#\"><span style=\"font-family: 'Monotype Corsiva', Magneto, Magneto; font-weight: normal; font-style: italic; text-decoration: none; font-size: 40pt;\"><font color=\"#FFFFFF\">SNAKES AND LADDERS</span></font></a></h1>\n");
      out.write("\t\t\t<br>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<!-- end #header -->\n");
      out.write("\t<div id=\"menu-wrapper\">\n");
      out.write("\t\t<div class=\"ribbon ribbon-content\">\n");
      out.write("\t\t\t<div id=\"menu\" align : \"left\">\n");
      out.write("\t\t\t\t<ul align =\"left\">\n");
      out.write("\t\t\t\t\t<li class=\"current_page_item\"><a href=\"index.html\">Home</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"about.html\">About game</font></a></li>\n");
      out.write("                                        <li><a  href=\"login.html\" >Log in</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"registration.html\">Registration</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"rules.html\">Rules </a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"sesschech_create\">Create New Game</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"sesschck_join\">Join Game</a></li>\n");
      out.write("                                        <li><a href=\"signout\">Sign Out</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"construct.html\">Contact us </a></li>\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("  \n");
      out.write("   <div id = \"table\" align = \"center\">\n");
      out.write("                  <table cellpadding=\"10px\" cellspacing=\"10px\">\n");
      out.write("           <tr>\n");
      out.write("               <td></td>\n");
      out.write("                   <table border=\"0\" width=\"100%\">\n");
      out.write("<tr>\n");
      out.write("<td>\n");
      out.write("<table border=\"1\">\n");
      out.write("<tr>\n");
      out.write("<td>PlayerName</td>\n");
      out.write("<td>Die Color</td>\n");
      out.write("<td>Position</td>\n");
      out.write("</tr>\n");
      out.write("          \n");
      out.write("\n");
      out.write("      \n");
      out.write("                      \n");
      out.write("                   \n");
      out.write("  \n");
      out.write("\n");
      out.write("</table>\n");
      out.write("\n");
      out.write("</td>\n");
      out.write("                                \n");
      out.write("                                <td>\n");
      out.write(" <table  style=\"table-layout:fixed; overflow-x:hidden;\" border=\"1\" background=\"SL.jpg \" width=\"441px\"; height=\"445px\" >\n");
      out.write("<tr>\n");
      out.write("<td id=\"100\"></td>\n");
      out.write("<td id=\"99\">.</td>\n");
      out.write("<td id=\"98\">.</td>\n");
      out.write("<td id=\"97\">.</td>\n");
      out.write("<td id=\"96\">.</td>\n");
      out.write("<td id=\"95\">.</td>\n");
      out.write("<td id=\"94\">.</td>\n");
      out.write("<td id=\"93\">.</td>\n");
      out.write("<td id=\"92\">.</td>\n");
      out.write("<td id=\"91\">.</td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("<td id=\"81\">.</td>\n");
      out.write("<td id=\"82\">.</td>\n");
      out.write("<td id=\"83\">.</td>\n");
      out.write("<td id=\"84\">.</td>\n");
      out.write("<td id=\"85\">.</td>\n");
      out.write("<td id=\"86\">.</td>\n");
      out.write("<td id=\"87\">.</td>\n");
      out.write("<td id=\"88\">.</td>\n");
      out.write("<td id=\"89\">.</td>\n");
      out.write("<td id=\"90\">.</td>\n");
      out.write("</tr>\n");
      out.write("\n");
      out.write("<tr>\n");
      out.write("<td id=\"80\">.</td>\n");
      out.write("<td id=\"79\">.</td>\n");
      out.write("<td id=\"78\">.</td>\n");
      out.write("<td id=\"77\">.</td>\n");
      out.write("<td id=\"76\">.</td>\n");
      out.write("<td id=\"75\">.</td>\n");
      out.write("<td id=\"74\">.</td>\n");
      out.write("<td id=\"73\">.</td>\n");
      out.write("<td id=\"72\">.</td>\n");
      out.write("<td id=\"71\">.</td>\n");
      out.write("</tr>\n");
      out.write("     \n");
      out.write("     \n");
      out.write("         \n");
      out.write("        <tr>\n");
      out.write("<td id=\"61\">.</td>\n");
      out.write("<td id=\"62\">.</td>\n");
      out.write("<td id=\"63\">.</td>\n");
      out.write("<td id=\"64\">.</td>\n");
      out.write("<td id=\"65\">.</td>\n");
      out.write("<td id=\"66\">.</td>\n");
      out.write("<td id=\"67\">.</td>\n");
      out.write("<td id=\"68\">.</td>\n");
      out.write("<td id=\"69\">.</td>\n");
      out.write("<td id=\"70\">.</td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("<td id=\"60\">.</td>\n");
      out.write("\n");
      out.write("<td id=\"59\">.</td>\n");
      out.write("\n");
      out.write("<td id=\"58\">.</td>\n");
      out.write("\n");
      out.write("<td id=\"57\">.</td>\n");
      out.write("\n");
      out.write("<td id=\"56\">.</td>\n");
      out.write("\n");
      out.write("<td id=\"55\">.</td>\n");
      out.write("\n");
      out.write("<td id=\"54\">.</td>\n");
      out.write("\n");
      out.write("<td id=\"53\">.</td>\n");
      out.write("<td id=\"52\">.</td>\n");
      out.write("<td id=\"51\">.</td>\n");
      out.write("\n");
      out.write("</tr>\n");
      out.write("     <tr>\n");
      out.write("<td id=\"41\">.</td>\n");
      out.write("<td id=\"42\">.</td>\n");
      out.write("<td id=\"43\">.</td>\n");
      out.write("<td id=\"44\">.</td>\n");
      out.write("<td id=\"45\">.</td>\n");
      out.write("<td id=\"46\">.</td>\n");
      out.write("<td id=\"47\">.</td>\n");
      out.write("<td id=\"48\">.</td>\n");
      out.write("<td id=\"49\">.</td>\n");
      out.write("<td id=\"50\">.</td>\n");
      out.write("</tr>\n");
      out.write("     <tr>\n");
      out.write("\n");
      out.write("<td id=\"40\">.</td>\n");
      out.write("\n");
      out.write("<td id=\"39\">.</td>\n");
      out.write("\n");
      out.write("<td id=\"38\">.</td>\n");
      out.write("\n");
      out.write("<td id=\"37\">.</td>\n");
      out.write("\n");
      out.write("<td id=\"36\">.</td>\n");
      out.write("\n");
      out.write("<td id=\"35\">.</td>\n");
      out.write("\n");
      out.write("<td id=\"34\">.</td>\n");
      out.write("\n");
      out.write("<td id=\"33\">.</td>\n");
      out.write("\n");
      out.write("<td id=\"32\">.</td>\n");
      out.write("<td id=\"31\">.</td>\n");
      out.write("</tr>\n");
      out.write("     \n");
      out.write("     <tr>\n");
      out.write("<td id=\"21\">.</td>\n");
      out.write("<td id=\"22\">.</td>\n");
      out.write("<td id=\"23\">.</td>\n");
      out.write("<td id=\"24\">.</td>\n");
      out.write("<td id=\"25\">.</td>\n");
      out.write("<td id=\"26\">.</td>\n");
      out.write("<td id=\"27\">.</td>\n");
      out.write("<td id=\"28\">.</td>\n");
      out.write("<td id=\"29\">.</td>\n");
      out.write("<td id=\"30\">.</td>\n");
      out.write("</tr>\n");
      out.write("     <tr>\n");
      out.write("\n");
      out.write("\n");
      out.write("<td id=\"20\">.</td>\n");
      out.write("\n");
      out.write("<td id=\"19\">.</td>\n");
      out.write("\n");
      out.write("<td id=\"18\">.</td>\n");
      out.write("<td id=\"17\">.</td>\n");
      out.write("<td id=\"16\">.</td>\n");
      out.write("\n");
      out.write("<td id=\"15\">.</td>\n");
      out.write("\n");
      out.write("<td id=\"14\">.</td>\n");
      out.write("\n");
      out.write("<td id=\"13\">.</td>\n");
      out.write("\n");
      out.write("<td id=\"12\">.</td>\n");
      out.write("\n");
      out.write("<td id=\"11\">.</td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("<td id=\"1\">.</td>\n");
      out.write("<td id=\"2\">.</td>\n");
      out.write("<td id=\"3\">.</td>\n");
      out.write("<td id=\"4\">.</td>\n");
      out.write("<td id=\"5\">.</td>\n");
      out.write("<td id=\"6\">.</td>\n");
      out.write("<td id=\"7\">.</td>\n");
      out.write("<td id=\"8\">.</td>\n");
      out.write("<td id=\"9\">.</td>\n");
      out.write("<td id=\"10\">.</td>\n");
      out.write("</tr>\n");
      out.write("\n");
      out.write(" </table>\n");
      out.write("                                <td/>\n");
      out.write("                                <td>\n");
      out.write(" <table border=\"0\">\n");
      out.write("                        <tr>\n");
      out.write("                            <td>\n");
      out.write("                                <div id=\"container\" align=\"center\" style=\"border:0px solid black \">        \n");
      out.write("                                <script>\n");
      out.write("                                var ctr=0;\n");
      out.write("                                var d1;\n");
      out.write("                                var images=new Array();\n");
      out.write("                                for(i=0;i<=6;i++){\n");
      out.write("                                images[i]=new Image(); images[i].src=\"dice/\"+i+\".JPG\";\n");
      out.write("                                }\n");
      out.write("                                </script>\n");
      out.write("                                \n");
      out.write("                                    <img  alt=\"HELLOOO\"src=\"dice/6.JPG\" name=\"mydice\">\n");
      out.write("                                \n");
      out.write("                                        <form name=\"rand\" action=\"rolldice\">\n");
      out.write("                                <input id=\"btt\" type=\"button\" value=\"Roll dice!\" onClick=\"rolldice();\">\n");
      out.write("                                      <input id=\"tb\" type=\"text\" name=\"dival\" value=\"\"></input>\n");
      out.write("                                    </form>\n");
      out.write("                               \n");
      out.write("                                \n");
      out.write("                                <script>\n");
      out.write("                                function rolldice(){\n");
      out.write("                                    var die;\n");
      out.write("                                if(ctr<6){\n");
      out.write("                                    \n");
      out.write("                                 die= showdice();\n");
      out.write("                                ctr++;\n");
      out.write("                                setTimeout(\"rolldice()\",150);\n");
      out.write("                                }\n");
      out.write("                                else{\n");
      out.write("                                ctr=0;\n");
      out.write("                                die =showdice();\n");
      out.write("                                }\n");
      out.write("                                \n");
      out.write("    $(\"#tb\").val(die);\n");
      out.write("\n");
      out.write("    \n");
      out.write("    \n");
      out.write("        \n");
      out.write("                            }\n");
      out.write("                               function showdice(){\n");
      out.write("                                d1=Math.floor(Math.random()*6+1);\n");
      out.write("                                document.images[\"mydice\"].src=\"dice/\"+d1+\".JPG\";\n");
      out.write("                                return d1;\n");
      out.write("                                }\n");
      out.write("                                \n");
      out.write("                                   \n");
      out.write("    \n");
      out.write("   \n");
      out.write("                              </script>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        \n");
      out.write("                    </table>\n");
      out.write("                                  \n");
      out.write("                                 </td>  \n");
      out.write("           </tr>\n");
      out.write("       </table>\n");
      out.write("           </tr>\n");
      out.write("                  </table>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("  </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}