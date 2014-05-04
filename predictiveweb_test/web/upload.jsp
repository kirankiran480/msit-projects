
<%@page import="purepredict.PurePredictive"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="org.apache.commons.fileupload.*" %>
<%@ page import="org.apache.commons.fileupload.disk.*" %>
<%@ page import="org.apache.commons.fileupload.servlet.*" %>
<%@ page import="org.apache.commons.io.output.*" %>




<%
   File file ;
   int maxFileSize = 5000 * 1024;
   int maxMemSize = 5000 * 1024;
   ServletContext context = pageContext.getServletContext();
   HttpSession si=request.getSession(false);
   String uname= si.getAttribute("uname").toString();
  String option;
  String filePath = config.getServletContext().getRealPath("/")+"uploadedFiles\\"+uname+"\\";
   String fieldName=null;
   // Verify the content type
   String contentType = request.getContentType();
   
   if ((contentType.indexOf("multipart/form-data") >= 0)) {

      DiskFileItemFactory factory = new DiskFileItemFactory();
      // maximum size that will be stored in memory
      factory.setSizeThreshold(maxMemSize);
      // Location to save data that is larger than maxMemSize.
      factory.setRepository(new File("C:\\temp\\"));

      // Create a new file upload handler
      ServletFileUpload upload = new ServletFileUpload(factory);
      // maximum file size to be uploaded.
      upload.setSizeMax( maxFileSize );
      try{ 
         // Parse the request to get file items.
         List fileItems = upload.parseRequest(request);
        out.println("krian");
         // Process the uploaded file items
        
         
         Iterator i = fileItems.iterator();
        
         while ( i.hasNext () ) 
         {
            FileItem fi = (FileItem)i.next();
            if(!fi.isFormField())
            {
                  fieldName = fi.getFieldName();
            }
            if ( !fi.isFormField () )	
            {
            // Get the uploaded file parameters
               
           
            String fileName = fi.getName();
            boolean isInMemory = fi.isInMemory();
            long sizeInBytes = fi.getSize();
            // Write the file
            try
            {
            if( fileName.lastIndexOf("\\") >= 0 ){
            file = new File( filePath + 
            fileName.substring( fileName.lastIndexOf("\\"))) ;
            }else{
            file = new File( filePath + 
            fileName.substring(fileName.lastIndexOf("\\")+1)) ;
            }
            fi.write( file ) ;
            System.out.println("fieldname"+fieldName);
       //     out.println("Uploaded Filename: " +filePath + 
         //   fileName + "<br>");
            PurePredictive p=new PurePredictive(fileName,filePath);
            p.fileprocess();
            response.sendRedirect("selectalgo.html");
            }
            catch(Exception e){
                out.println("error in uploading files"+e);
            }
         }
            else{
               
            }
         }
         out.println("</body>");
         out.println("</html>");
         }
      catch(Exception ex) {
         System.out.println(ex);
      }
   }else{
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet upload</title>");  
      out.println("</head>");
      out.println("<body>");
      out.println("<p>No file uploaded</p>"); 
      out.println("</body>");
      out.println("</html>");
   }
%>