/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pdfreader;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import gui.gui;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import org.apache.commons.io.FileUtils;
import com.gnostice.pdfone.*;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfStamper;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/**
 *
 * @author Thomas
 */
public class Pdfreader  extends JPanel {
    
    protected static JTextArea textArea;
    private final static String newline = "\n";


    /**
     * @param args the command line arguments
     */
   //Specifying the file location.
   public static String read(String str2) throws IOException {
        String str3 = " ";
        String INPUTFILE = str2;    
        PdfReader reader = new PdfReader(INPUTFILE);
        int n = reader.getNumberOfPages();
       
        for(int i=1;i<=n;i++)
        {
        
        String str=PdfTextExtractor.getTextFromPage(reader, i);
        
        str3 = str+"\n\n\n\n\n"+str3;
        }
        //Extracting the content from a particular page.
        return str3;
       
    }
   public static void openlibrary(String path) throws InstantiationException, ClassNotFoundException, IllegalAccessException, SQLException, IOException
   {
       JFileChooser jfc1 = new JFileChooser();
        jfc1.showOpenDialog(null);
        File file1=jfc1.getSelectedFile();
        String st=file1.getPath();
        String stname = file1.getName();
        //String path="C:\\Users\\gowtham\\Documents\\LIBRARY";
        try {
            File destDir = new File(path);
            File srcFile = new File(st);
            FileUtils.copyFileToDirectory(srcFile, destDir);
            JOptionPane.showMessageDialog(null, "Book Added To Library");
        } catch(Exception e) {
        }
        System.out.println("MySQL Connect Example.");
  Connection conn = null;
  String url = "jdbc:mysql://localhost:3306/";
  //String dbName = "jdbctutorial";
  String driver = "com.mysql.jdbc.Driver";
  String userName = "root"; 
  String password = "root";
  Class.forName(driver).newInstance();
  conn = DriverManager.getConnection(url,userName,password);
  System.out.println("Connected to the database");
  Statement st1,st2 = null;
  st1 = conn.createStatement();
   st1.executeQuery("use reader9db");
   File file = new File("username.txt");
             BufferedReader in = null;
              try {
                  in = new BufferedReader(new FileReader(file));
                  
              } catch (FileNotFoundException ex) {
                  Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
              } 
              String  user3=in.readLine();
              PdfReader reader = new PdfReader(st);
              Map<String,String> mm = new HashMap<String,String>();
              mm=reader.getInfo();
              Iterator it = mm.entrySet().iterator();
              String author1 = null;
              while (it.hasNext())
              {
                  Map.Entry<String,String> xy = (Map.Entry)it.next();
                  if (xy.getKey().equalsIgnoreCase("title"))
                  {
                      String title = xy.getValue();
                  }
                   if (xy.getKey().equalsIgnoreCase("Author"))
                  {
                     author1 = xy.getValue();
                      System.out.println(xy.getKey()+"\t\t"+xy.getValue());
                  }
              }
              
              
           
st1.executeUpdate("insert into metadata(username,bookname,author) values('" + user3.toString() + "','"+ stname.toString() +"','"+ author1 + "' )");
       
   conn.close();
   }
   public void dellib(String path)
    {
        
            File root = new File(path);
            FileSystemView fsv = new openlibrary( root );
            JFileChooser fc = new JFileChooser(fsv);
            fc.showOpenDialog(null);
            File file1=fc.getSelectedFile();
            try{
 
    		//File file = new File("c:\\logfile20100131.log");
 
    		if(file1.delete()){
    			JOptionPane.showMessageDialog(null, "Book Succesfully Removed From Library");
    		}else{
    			JOptionPane.showMessageDialog(null, "Error Removing");
    		}
 
    	}catch(Exception e){
 
    		e.printStackTrace();
 
    	}
    }
   public void buybook()
    {
        JFrame frame = new JFrame("Reader9 Search");
        JButton button = new JButton("Search for a book");
        button.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
        String str = JOptionPane.showInputDialog(null, "Enter book name : ", "", 1);
        buy(str);
  }
  });
  JPanel panel = new JPanel();
  panel.add(button);
  frame.add(panel);
  frame.setSize(400, 400);
  frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  frame.setVisible(true);
  
   }
   public void print() throws PrinterException
    {
        PrinterJob pj = PrinterJob.getPrinterJob();
              pj.setJobName("name");

                PageFormat format = pj.getPageFormat(null);

                pj.setPrintable (new Printable() {

                @Override
                public int print(Graphics pg, PageFormat pf, int pageNum) throws PrinterException {
                    if (pageNum > 0){
                          return Printable.NO_SUCH_PAGE;
                          }

                          Graphics2D g2 = (Graphics2D) pg;

                          this.paint(g2);
                          return Printable.PAGE_EXISTS;
                }

            private void paint(Graphics2D g2) {
                throw new UnsupportedOperationException("Not yet implemented");
            }

           

              }, format);
              if (pj.printDialog() == false)
              return;


              pj.print();
              } 
   public void buy(String s)
    {
                       try {
  java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
  java.net.URI uri = new java.net.URI( "http", "www.flipkart.com/ebooks/pr?p%5B%5D=sort%3Dprice_asc&sid=ixq&layout=grid&q="+s,"");
  desktop.browse( uri );
} catch ( Exception e ) {
  System.err.println( e.getMessage() );
}
    

        
    }
  public static  void textdemo() throws IOException
  {
      textArea = new JTextArea(40,40);
      textArea.setEditable(false);
      JScrollPane scrollPane = new JScrollPane(textArea);
      String input = read("D:\\201285088_dd12_w4_m4.pdf");
       textArea.append(input + newline);
       textArea.setCaretPosition(textArea.getDocument().getLength());
      //Create and set up the window.
        JFrame frame = new JFrame("TextDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Add contents to the window.
        frame.add(textArea);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
  public void highs()
  {
      
  }
  public void bgcolor()
  {
    
  }
    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    textdemo();
                } catch (IOException ex) {
                    Logger.getLogger(Pdfreader.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}

