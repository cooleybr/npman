
package npman;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
import java.awt.event.*;

public class viewPriorEmp extends JPanel {



public viewPriorEmp(){
    
        
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 3;
        
        JLabel empView =  new JLabel("Prior Employees");
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0,0,20,0);
        add(empView,c);
    
        c.insets = new Insets(0,0,0,0);
        try {
        Connection conn = null;
        Statement stmt = null;
      Class.forName("org.sqlite.JDBC");
      conn = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM employee where Emp_Term<>'null';" );
      
      while ( rs.next() ) {
          
         int id = rs.getInt("Emp_ID");
         JLabel first = new JLabel("Name: " + rs.getString("Emp_First") + " " + rs.getString("Emp_Last"));
         c.gridy += 1;
         add (first,c);
         JLabel address = new JLabel("Address: " + rs.getString("Emp_Add1") + " " + rs.getString("Emp_Add2"));
         c.gridy += 1;
         add (address,c);
         JLabel cityStateZip = new JLabel("City/State/Zip: " + rs.getString("Emp_City") + ", " + 
                 rs.getString("Emp_State") + " " + rs.getString("Emp_Zip"));
         c.gridy +=1;
         add(cityStateZip,c);
         
         JLabel contact = new JLabel("Phone: " + rs.getString("Emp_Phone") + " Email: " + rs.getString("Emp_Email"));
         c.gridy +=1;
         add(contact,c);
         
         JLabel hire = new JLabel("Hire Date: " + rs.getString("Emp_Hire") + " Termination Date: " + rs.getString("Emp_Term"));
         c.gridy += 1;
         add(hire,c);
         
         
         JLabel spacer = new JLabel("--------------------------------");
         c.gridy += 1;
         add(spacer,c);
        
              }
      
      
      rs.close();
      stmt.close();
      conn.close();
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      
      
    }
         }


}


 