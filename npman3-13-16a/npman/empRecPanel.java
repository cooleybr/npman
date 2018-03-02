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
class empRecPanel extends JPanel {

int ct30;   
    
    public empRecPanel() {
    
        setLayout(new GridBagLayout());
        //setPreferredSize(new Dimension(400,300));
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.ipady = 3;
        c.gridy = 1;           
                
        Connection con = null;
        Statement stmt = null;
       
        try {
      Class.forName("org.sqlite.JDBC");
      con = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      stmt = con.createStatement();
      
      ResultSet rs = stmt.executeQuery( "SELECT * FROM employee where Emp_Term Is Null and julianday(current_date) - julianday(Emp_Hire) <= 7;" );
      
      JLabel weekNewHire = new JLabel("New Hires in the last 7 days");
      c.gridy += 1;
      add(weekNewHire,c);
      
      while ( rs.next() ) {
        
          JLabel name = new JLabel("Name: " + rs.getString("Emp_First") + " " + 
                                    rs.getString("Emp_Last") + " Hire Date: " + rs.getString("Emp_Hire"));
          c.gridy += 1;
          add(name,c);
          
          
          
        

      }
      
      JLabel spacer = new JLabel("---------------------------------------------------");
          c.gridy += 1;
          add(spacer,c);
          
      rs = stmt.executeQuery( "SELECT * FROM employee where Emp_Term Is Null and julianday(current_date) - julianday(Emp_Hire) < 30 and julianday(current_date) - julianday(Emp_Hire) > 7;" );
      
      weekNewHire = new JLabel("New Hires in the last 30 days");
      c.gridy += 1;
      add(weekNewHire,c);
      ct30=0;
      while ( rs.next() ) {
        ct30+=1;
          JLabel name = new JLabel("Name: " + rs.getString("Emp_First") + " " + 
                                    rs.getString("Emp_Last"));
          c.gridy += 1;
          add(name,c);
        }

  
      
      spacer = new JLabel("---------------------------------------------------");
          c.gridy += 1;
          add(spacer,c);
          
          
      rs = stmt.executeQuery( "SELECT * FROM employee where Emp_Term Is Not Null;" );
      
      weekNewHire = new JLabel("Recently Terminated Employees");
      c.gridy += 1;
      add(weekNewHire,c);
      
      while ( rs.next() ) {
        
          JLabel name = new JLabel("Name: " + rs.getString("Emp_First") + " " + 
                                    rs.getString("Emp_Last") + " Termination Date: " + rs.getString("Emp_Term"));
          c.gridy += 1;
          add(name,c);


      }
      
      spacer = new JLabel("---------------------------------------------------");
          c.gridy += 1;
          add(spacer,c);    
          
          
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
