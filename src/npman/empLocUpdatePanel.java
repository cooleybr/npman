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
public class empLocUpdatePanel extends JPanel{
    
    public boolean terminate;
    
    public empLocUpdatePanel(){
        
        terminate=false;
        
        
        
    }
    
    public JPanel empLocUpdate(int locID){
        
        JPanel up = new JPanel();
        up.setLayout(new GridBagLayout());
        up.setPreferredSize(new Dimension(400,300));
        GridBagConstraints d = new GridBagConstraints();
        d.fill = GridBagConstraints.HORIZONTAL;
        d.ipady = 10;
        
        JLabel pTitle = new JLabel("These employees work for the closed location, reassign or terminate");
        d.gridy = 1;
        up.add(pTitle,d);
        try {
        int location = locID;
        Connection c = null;
        Statement stmt = null;
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
        System.out.println("Opened database successfully");
        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery( "SELECT * from employee where Emp_Loc_ID=" + location + ";" );
      while ( rs.next() ) {
          
          int Emp_ID = rs.getInt("Emp_ID");
          String Emp_First = rs.getString("Emp_First");
          String Emp_Last = rs.getString("Emp_Last");
          JLabel empName = new JLabel ("Edit Employee: #" + Emp_ID + " Name: " + Emp_First + " " + Emp_Last);
          d.gridy += 1;
          up.add(empName,d);
         JCheckBox term = new JCheckBox("Terminate " + Emp_ID);
         d.gridy += 1;
         up.add(term,d);
         
         
         term.addItemListener(new ItemListener()
    {
      public void itemStateChanged(ItemEvent e)
      {
      
        if(e.getStateChange()==1){
            terminate=true;
            
                }
        else{
            terminate=false;
        }
        
              }
    });
         
         JComboBox curLoc = new JComboBox();
         locMenu loc = new locMenu();
         curLoc = loc.locList();
         loc.setSelectedLoc(rs.getInt("Emp_Loc_ID"));
         d.gridy += 1;
         up.add(curLoc,d);
         
         JButton submit = new JButton("Update Location");
      d.gridy += 1;
      up.add(submit,d);
      
      submit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                if(terminate==true){
                    String empToTerm = term.getText();
                    String delims = "[ ]+";
                     String[] tokens = empToTerm.split(delims);
                    employee term = new employee();
                    term.Emp_ID = Integer.parseInt(tokens[1]);
                    term.termEmployee();
                }
                else{
                    loc.getLocation();
                    employee move = new employee();
                    String empToTerm = term.getText();
                    String delims = "[ ]+";
                     String[] tokens = empToTerm.split(delims);
                   
                    move.Emp_ID = Integer.parseInt(tokens[1]);
                    move.Emp_Loc_ID = loc.selectedID;
                    move.updEmpLoc();
                } 
            }
            
        });
         
         }
      
      rs.close();
      stmt.close();
      c.close();
      
      
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      
      
    }
        return up;
    }
    
}
