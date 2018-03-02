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
class projectView extends JPanel {

    public project vproj;
    public Statement stmt2,stmt3;
    public String gtitle,empname;
    
    public projectView() {
    
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 3;
           
        vproj = new project();
        
        JLabel pViewTitle = new JLabel("Project View");
        c.gridx = 0;
        c.gridy = 0;
        add(pViewTitle,c);
        
       
        Connection con = null;
        Statement stmt = null;
        stmt2 = null;
        stmt3 = null;
        
    try {
      Class.forName("org.sqlite.JDBC");
      con = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      
      
      stmt = con.createStatement();
      stmt2 = con.createStatement();
      stmt3 = con.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM project;" );
      while ( rs.next() ) {
          JLabel id = new JLabel("Project ID: " + rs.getString("Proj_ID") + " " +
                                     "Project Title: " + rs.getString("Proj_Title"));
          c.gridy += 1;
          add(id,c);
         
          JLabel det = new JLabel("Alloted Hours" + rs.getDouble("Proj_Req_Hours") 
                  + " Alloted Funds: " + rs.getDouble("Proj_Req_Funds"));
          c.gridy += 1;
          add(det,c);
          
         JLabel dates = new JLabel("Start Date: " + rs.getString("Proj_Start") + " " + 
                                   " End Date: " +  rs.getString("Proj_End"));
         c.gridy += 1;
         add(dates,c);
         
         int gid = rs.getInt("Proj_Grant_ID");
         
         ResultSet rs2 = stmt2.executeQuery( "SELECT * FROM grant where Grant_ID=" + gid + ";" );
         while ( rs2.next() ) {
             gtitle = rs2.getString("Grant_Name");
         }
         JLabel grant = new JLabel("Grant: " + gtitle);
         c.gridy += 1;
         add(grant,c);
         
         JLabel desc = new JLabel("Project Details: " + rs.getString("Proj_Desc"));
         c.gridy += 1;
         add(desc,c);
         
         int empid = rs.getInt("Proj_Emp_ID");
         
         ResultSet rs3 = stmt3.executeQuery( "SELECT * FROM employee where emp_id=" + empid + ";" );
         while (rs3.next()){
             empname = (rs3.getString("Emp_First") + " " + rs3.getString("Emp_Last"));
         }
         
         JLabel lead = new JLabel("Project Lead: " + empname);
         c.gridy += 1;
         add(lead,c);
         
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
      JLabel noProjects = new JLabel("No Projects Added Yet");
        c.weightx = 2;
        c.gridx = 0;
        c.gridy += 1;
        c.insets = new Insets(0,25,0,0);
        add(noProjects,c);
    }
     
    }
    
    
    public JPanel singleProjectView(int pid) {
        vproj = new project();
        vproj.Proj_Grant_ID = pid;
        JPanel spv = new JPanel();
        spv.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 3;
           
        
        JLabel pViewTitle = new JLabel("Project View");
        c.gridx = 0;
        c.gridy = 0;
        spv.add(pViewTitle,c);
        
       
        Connection con = null;
        Statement stmt = null;
        stmt2 = null;
        stmt3 = null;
        
    try {
      Class.forName("org.sqlite.JDBC");
      con = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      
      
      stmt = con.createStatement();
      stmt2 = con.createStatement();
      stmt3 = con.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM project where Proj_Grant_ID=" + vproj.Proj_Grant_ID + ";" );
      while ( rs.next() ) {
          JLabel id = new JLabel("Project ID: " + rs.getString("Proj_ID") + " " +
                                     "Project Title: " + rs.getString("Proj_Title"));
          c.gridy += 1;
          spv.add(id,c);
         
          JLabel det = new JLabel("Alloted Hours" + rs.getDouble("Proj_Req_Hours") 
                  + " Alloted Funds: " + rs.getDouble("Proj_Req_Funds"));
          c.gridy += 1;
          spv.add(det,c);
          
         JLabel dates = new JLabel("Start Date: " + rs.getString("Proj_Start") + " " + 
                                   " End Date: " +  rs.getString("Proj_End"));
         c.gridy += 1;
         spv.add(dates,c);
         
         int gid = rs.getInt("Proj_Grant_ID");
         
         ResultSet rs2 = stmt2.executeQuery( "SELECT * FROM grant where Grant_ID=" + gid + ";" );
         while ( rs2.next() ) {
             gtitle = rs2.getString("Grant_Name");
         }
         JLabel grant = new JLabel("Grant: " + gtitle);
         c.gridy += 1;
         spv.add(grant,c);
         
         JLabel desc = new JLabel("Project Details: " + rs.getString("Proj_Desc"));
         c.gridy += 1;
         spv.add(desc,c);
         
         int empid = rs.getInt("Proj_Emp_ID");
         
         ResultSet rs3 = stmt3.executeQuery( "SELECT * FROM employee where emp_id=" + empid + ";" );
         while (rs3.next()){
             empname = (rs3.getString("Emp_First") + " " + rs3.getString("Emp_Last"));
         }
         
         JLabel lead = new JLabel("Project Lead: " + empname);
         c.gridy += 1;
         spv.add(lead,c);
         
         JLabel spacer = new JLabel("----------------------------------------------------------");
         c.gridy += 1;
         spv.add(spacer,c);
         
      }
      rs.close();
      stmt.close();
      con.close();
      
    }
      catch ( ClassNotFoundException | SQLException e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      JLabel noProjects = new JLabel("No Projects Yet");
        c.weightx = 2;
        c.gridx = 0;
        c.gridy += 1;
        c.insets = new Insets(0,25,0,0);
        spv.add(noProjects,c);
    }
     return spv;
    }
    
}
