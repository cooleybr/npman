/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package npman;

import java.awt.*;
import javax.swing.*;
import java.sql.*;

/**
 *
 * @author brc
 */
class viewService extends JPanel {

   
    
    public viewService() {
    
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 3;
                   
        JLabel servTitle = new JLabel("Logged Services");
        c.gridx = 0;
        c.gridy = 0;
        
        add(servTitle,c);
        
        Connection con = null;
        Statement stmt = null;
       
        try {
      Class.forName("org.sqlite.JDBC");
      con = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      stmt = con.createStatement();
      
      ResultSet rs = stmt.executeQuery( "SELECT * FROM service;" );
      while ( rs.next() ) {
        
          JLabel type = new JLabel("Type: " + rs.getString("Serv_Type") + " Description: " + 
                                    rs.getString("Serv_Desc"));
          c.gridy += 1;
          add(type,c);
          
          JLabel details = new JLabel("Date: " + rs.getString("Serv_Date") + " Applied Hours: " + 
                                    rs.getDouble("Serv_Hours") + " Monetary Value: " + rs.getDouble("Serv_Mon_Val"));
          c.gridy += 1;
          add(details,c);
          
                    
          JLabel spacer = new JLabel("---------------------------------------------------");
          c.gridy += 1;
          add(spacer,c);

      }
      rs.close();
      stmt.close();
      con.close();
      
      
    }
      catch ( ClassNotFoundException | SQLException e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      //System.exit(0);
    }
        
        
     
    }
    
}
