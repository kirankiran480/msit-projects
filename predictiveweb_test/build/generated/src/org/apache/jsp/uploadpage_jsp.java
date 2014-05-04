package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class uploadpage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      out.write("<head>\n");
      out.write("\n");
      out.write("<title>Online Prediction Analysis Tool</title>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>\n");
      out.write("<meta name=\"description\" content=\"\" />\n");
      out.write("<meta name=\"keywords\" content=\"\" />\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"style.css\" />\n");
      out.write("<!--<link href=\"http://fonts.googleapis.com/css?family=Droid+Sans\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("<link href=\"http://fonts.googleapis.com/css?family=Francois+One&amp;v1\" rel=\"stylesheet\" type=\"text/css\" /> -->\n");
      out.write("<script type=\"text/javascript\" src=\"http://code.jquery.com/jquery-1.4.2.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"superfish.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"scripts.js\"></script>\n");
      out.write("<script type=\"text/javascript\" language=\"javascript\" src=\"register.js\"></script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div id=\"container\" class=\"clearfix\">\n");
      out.write("   \n");
      out.write("\t<div id=\"headercont\" class=\"clearfix\" align=\"center\">\n");
      out.write("            <h1 align=\"center\"><a title=\"\" href=\"\">Online Prediction Analysis Tool</a></h1>\n");
      out.write("               \n");
      out.write("\t</div>\n");
      out.write("\t\n");
      out.write("\t<div id=\"menucont\" class=\"clearfix\">\n");
      out.write("\t\t<ul class=\"sf-menu dropdown\">\n");
      out.write("\t\t\t<li><a title=\"\" href=\"index.html\">Home</a></li>\n");
      out.write("\t\t\t<li><a class=\"has_submenu\" title=\"\" href=\"about.html\">About Predictive Analytics</a>\n");
      out.write("                            <ul>\n");
      out.write("\t\t\t\t\t<li><a title=\"\" href=\"#\">Feature Reduction</a></li>\n");
      out.write("\t\t\t\t\t<li><a title=\"\" href=\"#\">Decision Trees</a></li>\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t</li>\n");
      out.write("\t\t\t<li><a title=\"\" href=\"sesschck_join\">Register</a></li>\n");
      out.write("                        <li><a title=\"\" href=\"sessioncheck_login\">Login</a></li>\n");
      out.write("                         <li><a title=\"\" href=\"sessioncheck_predict\">Predict</a></li>\n");
      out.write("\t\t\t<li><a title=\"\" href=\"logout\">Logout</a></li>\n");
      out.write("\t\t</ul>\n");
      out.write("\t</div>\n");
      out.write("    <div id=\"maincont\" class=\"clearfix\" align=\"center\">\n");
      out.write("        <form action=\"upload.jsp\" method=\"post\"\n");
      out.write("              enctype=\"multipart/form-data\" onsubmit=\"\">\n");
      out.write("            <input type=\"file\" name=\"file\" size=\"50\" accept=\".csv\"/>\n");
      out.write("        <br /><br />\n");
      out.write("        <table>\n");
      out.write("            <tr>\n");
      out.write("                <td>\n");
      out.write("                    <input name=\"alogrithms\" type=\"radio\" value=\"predcitive\"></td><td>Primitive Attributes</td></tr>\n");
      out.write("            <tr><td>        \n");
      out.write("                    <input name=\"alogrithms\" type=\"radio\" value=\"decisontree\"></td><td>Decision Trees</td></tr>\n");
      out.write("<input name=\"alogrithms\" type=\"radio\" value=\"k-means \">K-means<br>\n");
      out.write("<input name=\"alogrithms\" type=\"radio\" value=\"neuralnetworks \">Neural Networks<br>\n");
      out.write("<input name=\"alogrithms\" type=\"radio\" checked value=\"naivebayesian\">Naive Bayesian<br>\n");
      out.write("<input name=\"alogrithms\" type=\"radio\" value=\"logit\">Logit<br>\n");
      out.write("        </table>\n");
      out.write("        <br /><br />\n");
      out.write("<input type=\"submit\" value=\"Predict !!!\" />\n");
      out.write("<br />\n");
      out.write("</form>\n");
      out.write("      </div>\n");
      out.write("    <br />\n");
      out.write("    <div id=\"footercont\" class=\"clearfix\">\n");
      out.write("        <p>Designed by <a title=\"Predictive Analytics Team\" href=\"index.jsp\" rel=\"external\">Predictive Analytics Team</a></p>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
