/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author kiran
 */
public class search extends javax.swing.JFrame {

    /**
     * Creates new form search
     */
    public search() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchfield = new javax.swing.JTextField();
        searchb = new javax.swing.JButton();
        author = new javax.swing.JRadioButton();
        title = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        view = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        searchb.setText("search");
        searchb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbActionPerformed(evt);
            }
        });

        author.setText("author");
        author.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                authorActionPerformed(evt);
            }
        });

        title.setText("Title");
        title.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleActionPerformed(evt);
            }
        });

        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        view.setText("view");
        view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(author)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(title))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(searchfield, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(searchb, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(view)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchfield)
                    .addComponent(searchb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(author)
                    .addComponent(title))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(view)
                        .addGap(85, 85, 85))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void titleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_titleActionPerformed

    private void searchbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbActionPerformed
       
            // TODO add your handling code here:
              System.out.println("MySQL Connect Example.");
      Connection conn = null;
      String url = "jdbc:mysql://localhost:3306/";
      //String dbName = "jdbctutorial";
      String driver = "com.mysql.jdbc.Driver";
      String userName = "root"; 
      String password = "root";
           try {
                      Class.forName(driver).newInstance();
                  } catch (InstantiationException ex) {
                      Logger.getLogger(search.class.getName()).log(Level.SEVERE, null, ex);
                  } catch (IllegalAccessException ex) {
                      Logger.getLogger(search.class.getName()).log(Level.SEVERE, null, ex);
                  } catch (ClassNotFoundException ex) {
                      Logger.getLogger(search.class.getName()).log(Level.SEVERE, null, ex);
                  }
            try {
                conn = DriverManager.getConnection(url,userName,password);
            } catch (SQLException ex) {
                Logger.getLogger(search.class.getName()).log(Level.SEVERE, null, ex);
            }
      System.out.println("Connected to the database");
      Statement st = null,st2 = null;
        try {
            st = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(search.class.getName()).log(Level.SEVERE, null, ex);
        }
      ResultSet rs = null;
      if(author.isSelected())
      {
                  try {
                      rs = st.executeQuery("select * from reader9db.metadata where author like '%"+searchfield.getText().toString()+"%'");
                  } catch (SQLException ex) {
                      Logger.getLogger(search.class.getName()).log(Level.SEVERE, null, ex);
                  }
      }
      else if(title.isSelected())
              {
                  try {
                      rs = st.executeQuery("select * from reader9db.metadata where bookname like '%"+searchfield.getText().toString()+"%'");
                  } catch (SQLException ex) {
                      Logger.getLogger(search.class.getName()).log(Level.SEVERE, null, ex);
                  }
              }  
        try {
            jList1.setModel(new DefaultListModel());
            while(rs.next())
                       {
                           System.out.println("kiran");
                            
                            String  st4 = rs.getString("bookname");
                            ((DefaultListModel)jList1.getModel()).addElement(st4);
                       }
        } catch (SQLException ex) {
            Logger.getLogger(search.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchbActionPerformed

    private void authorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_authorActionPerformed
public String user3;
    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        // TODO add your handling code here:
         File file = new File("username.txt");
             BufferedReader in = null;
              try {
                  in = new BufferedReader(new FileReader(file));
                  
              } catch (FileNotFoundException ex) {
                  Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
              } 
        try {
            user3=in.readLine();
        } catch (IOException ex) {
            Logger.getLogger(search.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sr = jList1.getSelectedValue().toString();
        System.out.println(sr);
        String Sr2 = "C:\\Users\\kiran\\Documents\\library\\"+user3;
        gui g = new gui(Sr2);
        g.open(sr);
    }//GEN-LAST:event_jList1MouseClicked

    private void viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewActionPerformed
        // TODO add your handling code here:
         File file = new File("username.txt");
             BufferedReader in = null;
              try {
                  in = new BufferedReader(new FileReader(file));
                  
              } catch (FileNotFoundException ex) {
                  Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
              } 
        try {
            user3=in.readLine();
        } catch (IOException ex) {
            Logger.getLogger(search.class.getName()).log(Level.SEVERE, null, ex);
        }
         String sr = jList1.getSelectedValue().toString();
        System.out.println(sr);
        String Sr2 = "C:\\Users\\kiran\\Documents\\library\\"+user3;
        
        gui g = new gui(Sr2);
        g.open(sr);
        g.setVisible(true);
    }//GEN-LAST:event_viewActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new search().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton author;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton searchb;
    private javax.swing.JTextField searchfield;
    private javax.swing.JRadioButton title;
    private javax.swing.JButton view;
    // End of variables declaration//GEN-END:variables
}