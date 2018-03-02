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
import java.sql.*;
/**
 *
 * @author brc
 */
public class printMenu {
    
    
    public String selectedPrint;
    public JComboBox menu;
    public int selectedID;
    
    public printMenu(){
        selectedPrint="--None--";
    }
    
    
    
    public JComboBox printList(){
        
        menu = new JComboBox();
        menu.addItem("--None--");
        Connection c = null;
        Statement stmt = null;
        
        
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM mailer where Mail_Method='Print';" );
      while ( rs.next() ) {
          
          menu.addItem(rs.getInt("Mail_ID") + " " + rs.getString("Mail_Name"));
          
        }
      rs.close();
      stmt.close();
      c.close();
          
    }
      catch ( ClassNotFoundException | SQLException e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      //System.exit(0);
    }
        
        
        menu.addItemListener(new ItemListener() {
        public void itemStateChanged(ItemEvent arg0) {
            selectedPrint = menu.getSelectedItem().toString();
            
        }
    });
        
       return menu;
    }
    
        
    public void getPrint(){
        selectedPrint = menu.getSelectedItem().toString();
        String delims = "[ ]+";
        String[] tokens = selectedPrint.split(delims);
        if(tokens[0].equals("--None--")){
            selectedID = 0;
        }
        else{
        selectedID = Integer.parseInt(tokens[0]);
        }
        
    }
    
   
}
 