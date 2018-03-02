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
public class webpageMenu {
    
    
    public String selectedPage;
    public JComboBox menu;
    public int selectedID;
    
    public webpageMenu(){
        selectedPage="--None--";
    }
    
    
    
    public JComboBox webpageList(){
        
        menu = new JComboBox();
        menu.addItem("--Main Link--");
        Connection c = null;
        Statement stmt = null;
        
        
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM website s join webpage p where s.Web_ID=p.Web_ID;" );
      while ( rs.next() ) {
          menu.addItem(rs.getString("Web_URL") + "/" + rs.getString("Web_Pg_Title"));
                   
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
            selectedPage = menu.getSelectedItem().toString();
            
        }
    });
        
       return menu;
    }
    
    
    
    public void getWebpage(){
        
        Connection c = null;
        Statement stmt = null;
        selectedPage = menu.getSelectedItem().toString();
        String delims = "[/]+";
        String[] tokens = selectedPage.split(delims);
        if(tokens[0].equals("--Main Link--")){
            selectedID = 0;
        }
        else{
        selectedPage = tokens[1];
        try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM webpage where Web_Pg_Title='"+selectedPage +"';" );
      while ( rs.next() ) {
          selectedID = rs.getInt("Web_Pg_ID");
          System.out.println(selectedID);
                   
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
        
    }
    
   
}
 