package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.util.Scanner;

public final class kmeans_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
      out.write("\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("  var s;\n");
      out.write("    function demoajax() {\n");
      out.write("        alert(\"call done\");\n");
      out.write("     if (window.XMLHttpRequest) {\n");
      out.write("\n");
      out.write("        httpRequest = new XMLHttpRequest();\n");
      out.write("\n");
      out.write("     }\n");
      out.write("\n");
      out.write("     else {\n");
      out.write("\n");
      out.write("        if (window.ActiveXObject) {\n");
      out.write("\n");
      out.write("           try {\n");
      out.write("\n");
      out.write("              httpRequest = new ActiveXObject (\"Microsoft.XMLHTTP\");\n");
      out.write("\n");
      out.write("           }\n");
      out.write("\n");
      out.write("           catch (e) { \n");
      out.write("           System.out.println(\"Exception\"+e);\n");
      out.write("                }\n");
      out.write("\n");
      out.write("        }\n");
      out.write("     }\n");
      out.write("getData21();\n");
      out.write("}\n");
      out.write("function getData21() \n");
      out.write("{\n");
      out.write("     //alert(url);  \n");
      out.write("     //alert(\"hai\");  \n");
      out.write("     var url = \"kmeans\";\n");
      out.write("     //alert(url);\n");
      out.write("     //alert(document.getElementById(\"txt\").value)\n");
      out.write("     s=document.getElementById(\"txt\").value;\n");
      out.write("     //alert(s)\n");
      out.write("     url=url+\"?clusters=\";\n");
      out.write("     url=url+s;\n");
      out.write("     //alert(url);\n");
      out.write("     httpRequest.onreadystatechange = showData21;\n");
      out.write("     httpRequest.open(\"GET\", url, true);\n");
      out.write("     httpRequest.send(null);\n");
      out.write("     //setTimeout(\"getData2()\", 10000);\n");
      out.write("\n");
      out.write("}\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("function showData21() \n");
      out.write("{\n");
      out.write("//alert(\"temp\");\n");
      out.write("     if (httpRequest.readyState == 4) \n");
      out.write("     {\n");
      out.write("        if (httpRequest.status == 200) \n");
      out.write("        {\n");
      out.write("               var temp=httpRequest.responseText;\n");
      out.write("                //alert(temp);\n");
      out.write("               document.getElementById(\"destination1\").innerHTML=httpRequest.responseText;\n");
      out.write("               var ratings=httpRequest.responseText;\n");
      out.write("               //alert(temp);\n");
      out.write("        }\n");
      out.write("        else \n");
      out.write("        {\n");
      out.write("           alert(\"Error with loading data\\n\"+ httpRequest.status +\":\"+ httpRequest.statusText);\n");
      out.write("        }\n");
      out.write("     }\n");
      out.write("}\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("   </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"container\" class=\"clearfix\">\n");
      out.write("   \n");
      out.write("\t<div id=\"headercont\" class=\"clearfix\" align=\"\">\n");
      out.write("            <h1 align=\"center\"><a title=\"\" href=\"\">Online Prediction Analysis Tool</a></h1>\n");
      out.write("               \n");
      out.write("\t</div>\n");
      out.write("\t\n");
      out.write("\t<div id=\"menucont\" class=\"clearfix\">\n");
      out.write("\t\t<ul class=\"sf-menu dropdown\">\n");
      out.write("\t\t\t<li><a title=\"\" href=\"index.html\">Home</a></li>\n");
      out.write("\t\t\t<li><a class=\"has_submenu\" title=\"\" href=\"about.html\">About Predictive Analytics</a>\n");
      out.write("\t\t\t\t<ul>\n");
      out.write("\t\t\t\t\t<li><a title=\"\" href=\"#\">Feature Reduction</a></li>\n");
      out.write("\t\t\t\t\t<li><a title=\"\" href=\"#\">Decision Trees</a></li>\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t</li>\n");
      out.write("\t\t\t<li><a title=\"\" href=\"sesschck_join\">Register</a></li>\n");
      out.write("                        <li><a title=\"\" href=\"sessioncheck_login\">Login</a></li>\n");
      out.write("                          <li><a title=\"\" href=\"sessioncheck_predict\">Predict</a></li>\n");
      out.write("                           \n");
      out.write("\t\t\t<li><a title=\"\" href=\"logout\">logout</a></li>\n");
      out.write("\t\t</ul>\n");
      out.write("\t</div>\n");
      out.write("     <div id=\"maincont\" class=\"clearfix\" align=\"center\">\n");
      out.write("        <h2 align =\"center\">Enter number of clusters</h2><br><br>\n");
      out.write("        <input type=\"text\" id=\"txt\">\n");
      out.write("        <input type=\"button\" onclick=\"demoajax()\" value=\"Click\">\n");
      out.write("        <div id=\"destination1\" style=\"position: absolute; left: 300px ; top: 250px; \">\n");
      out.write("            <h2>Data</h2>\n");
      out.write("        </div>\n");
      out.write("            </div>\n");
      out.write("       \n");
      out.write("       \n");
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
