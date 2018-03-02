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
public class empMenu {
    
    
    public String selectedEmp;
    public JComboBox menu;
    public int selectedID;
    
    public empMenu(){
        selectedEmp="--None--";
    }
    
    
    
    public JComboBox empList(){
        
        menu = new JComboBox();
        menu.addItem("--None--");
        Connection c = null;
        Statement stmt = null;
        
        
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM employee;" );
      while ( rs.next() ) {
          menu.addItem(rs.getInt("Emp_ID") + " " + rs.getString("Emp_First") + " " + rs.getString("Emp_Last"));
                   
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
            selectedEmp = menu.getSelectedItem().toString();
            
        }
    });
        
       return menu;
    }
    
    public void setSelectedLoc(int id){
        
        int emp = id;
        
        Connection c = null;
        Statement stmt = null;
        
        
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM employee where Emp_ID=" + emp + ";" );
      while ( rs.next() ) {
          menu.setSelectedItem(rs.getInt("Emp_ID") + " " + rs.getString("Emp_First") + " " + rs.getString("Emp_Last"));        
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
    
    public void getEmployee(){
        selectedEmp = menu.getSelectedItem().toString();
        String delims = "[ ]+";
        String[] tokens = selectedEmp.split(delims);
        if(tokens[0].equals("--None--")){
            selectedID = 0;
        }
        else{
        selectedID = Integer.parseInt(tokens[0]);
        }
        
    }
    
   
}
 