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
public class locMenu {
    
    
    public String selectedLoc;
    public JComboBox menu;
    public int selectedID;
    
    public locMenu(){
        selectedLoc="--None--";
    }
    
    
    
    public JComboBox locList(){
        
        menu = new JComboBox();
        menu.addItem("--None--");
        Connection c = null;
        Statement stmt = null;
        
        
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM location;" );
      while ( rs.next() ) {
          if(rs.getString("loc_closed_date").isEmpty()){
          menu.addItem(rs.getInt("Loc_ID") + " " + rs.getString("LocOrgName"));
          }
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
            selectedLoc = menu.getSelectedItem().toString();
            
        }
    });
        
       return menu;
    }
    
    public void setSelectedLoc(int id){
        
        int loc = id;
        
        Connection c = null;
        Statement stmt = null;
        
        
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM location where Loc_ID=" + loc + ";" );
      while ( rs.next() ) {
          menu.setSelectedItem(rs.getInt("Loc_ID") + " " + rs.getString("LocOrgName"));        
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
    
    public void getLocation(){
        selectedLoc = menu.getSelectedItem().toString();
        String delims = "[ ]+";
        String[] tokens = selectedLoc.split(delims);
        if(tokens[0].equals("--None--")){
            selectedID = 0;
        }
        else{
        selectedID = Integer.parseInt(tokens[0]);
        }
        
    }
    
   
}
 