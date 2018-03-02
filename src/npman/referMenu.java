/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package npman;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author brc
 */
public class referMenu {
    
    
    public String selectedRefer;
    public JComboBox menu;
    
    public referMenu(){
        selectedRefer="Event";
    }
    
    
    
    public JComboBox referList(){
        String[] refer = {"Event","Website","Walk In","Mailer"};
        
        menu = new JComboBox();
        int i;
        for(i=0;i < refer.length; i++){
            menu.addItem(refer[i]);
            
        }
        
        menu.addItemListener(new ItemListener() {
        public void itemStateChanged(ItemEvent arg0) {
            selectedRefer = menu.getSelectedItem().toString();
        }
    });
        
       return menu;
    }
    
    public void setRefer(int id){
        int don = id;
        
        Connection c = null;
        Statement stmt = null;
        
        
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM donor where Don_ID=" + don + ";" );
      while ( rs.next() ) {
          menu.setSelectedItem(rs.getString("DonorReferSrc"));        
        }
      rs.close();
      stmt.close();
      c.close();
          
    }
      catch ( ClassNotFoundException | SQLException e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      //System.exit(0);
    }
        
    }
    
    public void getRefer(){
        
        selectedRefer = menu.getSelectedItem().toString();
    }
    
   
}
 