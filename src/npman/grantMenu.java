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
public class grantMenu {
    
    
    public String selectedGrant;
    public JComboBox menu;
    public int selectedID;
    
    public grantMenu(){
        selectedGrant="--None--";
    }
    
    
    
    public JComboBox grantList(){
        
        menu = new JComboBox();
        menu.addItem("--None--");
        Connection c = null;
        Statement stmt = null;
        
        
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM grant;" );
      while ( rs.next() ) {
          menu.addItem(rs.getInt("Grant_ID") + " " + rs.getString("Grant_Name") + " " + rs.getString("Grant_Award_Date"));
                   
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
            selectedGrant = menu.getSelectedItem().toString();
            
        }
    });
        
       return menu;
    }
    
    public void setSelectedGrant(int id){
        
        int grant = id;
        
        Connection c = null;
        Statement stmt = null;
        
        
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM grant where Grant_ID=" + grant + ";" );
      while ( rs.next() ) {
          menu.setSelectedItem(rs.getInt("Grant_ID") + " " + rs.getString("Grant_Name")+ " " + rs.getString("Grant_Award_Date"));   
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
    
    public void getGrant(){
        selectedGrant = menu.getSelectedItem().toString();
        String delims = "[ ]+";
        String[] tokens = selectedGrant.split(delims);
        if(tokens[0].equals("--None--")){
            selectedID = 0;
        }
        else{
        selectedID = Integer.parseInt(tokens[0]);
        }
        
    }
    
   
}
 