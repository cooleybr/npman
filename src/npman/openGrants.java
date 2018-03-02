/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package npman;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
/**
 *
 * @author brc
 */
public class openGrants extends JPanel{
    public int gid;
    public grant open;
    public Statement stmt3;
    public Connection con;
    
    public openGrants(){
        
        setLayout(new GridBagLayout());
        
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 3;
        
        
        con = null;
        Statement stmt = null;
        Statement stmt2 = null;
        
        JLabel viewTitle = new JLabel("Grants Overview");
        c.gridy = 0;
        add(viewTitle,c);
        
    try {
        
      Class.forName("org.sqlite.JDBC");
      con = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      stmt = con.createStatement();
      stmt2 = con.createStatement();
      
      ResultSet rs = stmt.executeQuery( "SELECT * FROM grant;" );
      while ( rs.next() ) {
         open = new grant();
         open.Grant_ID = rs.getInt("Grant_ID");
         open.Grant_Emp_ID = rs.getInt("Grant_Emp_ID");
         open.Grant_Name = rs.getString("Grant_Name");
         open.Grant_Ref_Num = rs.getString("Grant_Ref_Num");
         open.Grant_Desc = rs.getString("Grant_Desc");
         open.Grant_Org = rs.getString("Grant_Org");
         open.Grant_Posted_Date = rs.getString("Grant_Posted_Date");
         open.Grant_Due_Date = rs.getString("Grant_Due_Date");
         open.Grant_Submit_Date = rs.getString("Grant_Submit_Date");
         open.Grant_Award_Date = rs.getString("Grant_Award_Date");
         open.Grant_Amount = rs.getDouble("Grant_Amount");
         
         JLabel general = new JLabel("Grant ID: " + open.Grant_ID + " Grant Name: " + open.Grant_Name + 
                                    " Grant Reference Number: " + open.Grant_Ref_Num);
         c.gridy +=1;
         add(general,c);
         
         JLabel desc = new JLabel("Grantor: " + open.Grant_Org + " Description: " + open.Grant_Desc + " Amount: " + open.Grant_Amount);
         c.gridy += 1;
         add(desc,c);
         
         JLabel dates = new JLabel("Posted: " + open.Grant_Posted_Date + " Due: " + open.Grant_Due_Date + 
                                    " Submitted: " + open.Grant_Submit_Date + " Awarded: " + open.Grant_Award_Date);
         c.gridy +=1;
         add(dates,c);
         
         if(open.Grant_Award_Date.equals("null")){
         JButton awarded = new JButton("Mark ID-" + open.Grant_ID + "-Awarded");
         c.gridx = 1;
         add(awarded,c);
         
         awarded.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        String awtext = awarded.getText();
        String delims = "[-]+";
        String[] tokens = awtext.split(delims);
        gid = Integer.parseInt(tokens[1]);
        
        try{
           Class.forName("org.sqlite.JDBC");
           con = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
            stmt3 = con.createStatement();
           stmt3.executeUpdate("update grant set Grant_Award_Date=current_date where Grant_ID=" + gid + ";");
            stmt3.close();
            con.close();
        
        }
        catch ( Exception s ) {
      System.err.println( s.getClass().getName() + ": " + s.getMessage() );      
        }
        remove(awarded);
        
        JLabel awardedl = new JLabel("Grant Awarded");
        add(awardedl,c);
        
        validate();
        repaint();
              }
    });
         }
         c.gridx = 0;
         
         ResultSet rs2 = stmt2.executeQuery("Select * from employee where emp_id=" + open.Grant_Emp_ID + ";");
         while ( rs2.next() ) {
             String first = rs2.getString("Emp_First");
             String last = rs2.getString("Emp_Last");
             JLabel poc = new JLabel("Internal Point of Contact: " + first + " " + last);
             c.gridy +=1;
            add(poc,c);
         }
        
         
         
         JLabel spacer = new JLabel("-------------------------------------------------------------");
         c.gridy +=1;
         
         add(spacer,c);
         
         }
      rs.close();
      stmt.close();
      con.close();
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );      
    }
    System.out.println("Grant View Complete");
        
    }
}
