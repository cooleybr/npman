/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package npman;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author brc
 */
public class donor30Table extends JPanel{
    
    public donor30Table(){
        
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 3;
        c.insets = new Insets(5,5,5,5);
        
        JLabel labTitle = new JLabel("New Donors");
        c.gridx = 0;
        c.gridy = 0;
        add(labTitle,c);
        
        Connection con = null;
        Statement stmt = null;
        
    try {
        
      Class.forName("org.sqlite.JDBC");
      con = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT DonorAddDate,COUNT(DonorAddDate) from donor where (julianday(current_date)-julianday(DonorAddDate)) <= 30 group by (DonorAddDate) order by DonorAddDate;" );
      JLabel dayHead = new JLabel("Date");
      c.gridx = 0;
      c.gridy = 2;
      add(dayHead,c);
      JLabel hrHead = new JLabel("Donor Count");
      c.gridx = 1;
      c.gridy = 2;
      add(hrHead,c);
      
      while ( rs.next() ) {

         JLabel date = new JLabel(rs.getString("DonorAddDate"));
         c.gridx = 0;
         c.gridy += 1;
         add(date,c);
         Double hr = rs.getDouble("COUNT(DonorAddDate)");
         JLabel hrs = new JLabel(hr.toString());
         c.gridx = 1;
         add(hrs,c);

         }
      rs.close();
      stmt.close();
      con.close();
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          
    }
        
    }
}
