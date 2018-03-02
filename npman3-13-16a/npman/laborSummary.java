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
public class laborSummary extends JPanel{
    
    public laborSummary(){
        
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 3;
        c.insets = new Insets(5,5,5,5);
        
        JLabel labTitle = new JLabel("Applied Labor");
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
      ResultSet rs = stmt.executeQuery( "SELECT Serv_Date,SUM(Serv_Hours),SUM(Serv_Mon_Val) from service where (julianday(current_date)-julianday(Serv_Date)) <= 30 group by (Serv_Date) order by Serv_Date;" );
      JLabel dayHead = new JLabel("Date");
      c.gridx = 0;
      c.gridy = 2;
      add(dayHead,c);
      JLabel hrHead = new JLabel("Applied Hours");
      c.gridx = 1;
      c.gridy = 2;
      add(hrHead,c);
      JLabel valHead = new JLabel("Monetary Value");
      c.gridx = 2;
      c.gridy = 2;
      add(valHead,c);
      
      while ( rs.next() ) {
         String sumServ = (rs.getString("Serv_Date") + " " + rs.getDouble("SUM(Serv_Hours)") + " " 
                 + rs.getDouble("SUM(Serv_Mon_Val)"));
         JLabel date = new JLabel(rs.getString("Serv_Date"));
         c.gridx = 0;
         c.gridy += 1;
         add(date,c);
         Double hr = rs.getDouble("SUM(Serv_Hours)");
         JLabel hrs = new JLabel(hr.toString());
         c.gridx = 1;
         add(hrs,c);
         Double val = rs.getDouble("SUM(Serv_Mon_Val)");
         JLabel vals = new JLabel(val.toString());
         c.gridx =2;
         add(vals,c);
         }
      rs.close();
      stmt.close();
      con.close();
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          
    }
        
    }
}
