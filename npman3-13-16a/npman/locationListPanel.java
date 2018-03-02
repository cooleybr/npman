/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package npman;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

/**
 *
 * @author brc
 */
class locationListPanel extends JPanel {

    public static LocDBMS locData;
    
    public locationListPanel() {
    
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(400,300));
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 3;
           
        locData = new LocDBMS();
        
        JLabel listLocations = new JLabel("Current Locations List");
        c.weightx = 2;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0,25,0,0);
        add(listLocations,c);
        
       
        Connection con = null;
        Statement stmt = null;
        
        
    try {
      Class.forName("org.sqlite.JDBC");
      con = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      
      
      stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM location;" );
      while ( rs.next() ) {
          JLabel id = new JLabel("Location ID: " + rs.getString("Loc_ID") + " " +
                                     "Organization Name: " + rs.getString("LocOrgName"));
          c.gridy += 1;
          add(id,c);
         
          JLabel add = new JLabel("Address: " + rs.getString("loc_add1") + " " + rs.getString("loc_add2"));
          c.gridy += 1;
          add(add,c);
          
         JLabel citStaZi = new JLabel("City/State/Zip: " + rs.getString("loc_city") + ", " + 
                                   rs.getString("loc_state") + " " +  rs.getString("loc_zip"));
         c.gridy += 1;
         add(citStaZi,c);
         
         JLabel contact = new JLabel("Phone: " + rs.getString("loc_phone") + " Fax: " + rs.getString("loc_fax"));
         c.gridy += 1;
         add(contact,c);
         
         JLabel url = new JLabel("Website: " + rs.getString("loc_url"));
         c.gridy += 1;
         add(url,c);
         
         JLabel spacer = new JLabel("----------------------------------------------------------");
         c.gridy += 1;
         add(spacer,c);
         
      }
      rs.close();
      stmt.close();
      con.close();
      
    }
      catch ( ClassNotFoundException | SQLException e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      JLabel noLocations = new JLabel("No Locations Added Yet");
        c.weightx = 2;
        c.gridx = 0;
        c.gridy += 1;
        c.insets = new Insets(0,25,0,0);
        add(noLocations,c);
    }
     
    }
    
}
