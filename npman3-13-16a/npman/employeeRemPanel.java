/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package npman;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

/**
 *
 * @author brc
 */
class employeeRemPanel extends JPanel {

    
    public String toChange;
    public employee toEdit;
    public int id;
    
    public employeeRemPanel() {
    
        setLayout(new GridBagLayout());
        //setMinimumSize(new Dimension(400,300));
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.ipady = 3;
     
        JLabel empView =  new JLabel("Select Employee(s) To Change");
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0,0,20,0);
        add(empView,c);
    
        c.insets = new Insets(0,0,0,0);
        
        toChange = "None";
        JComboBox employees = new JComboBox();
        
        try {
        Connection conn = null;
        Statement stmt = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
        System.out.println("Opened database successfully");
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery( "SELECT * FROM employee where Emp_Term Is Null;" );
        employees.addItem("None");
      while ( rs.next() ) {
         id = rs.getInt("Emp_ID");
         String first = (rs.getInt("Emp_ID") + " " + rs.getString("Emp_First") + " " + rs.getString("Emp_Last"));
         
         employees.addItem(first);
                
              }
      c.gridy +=1;
      add(employees,c);
      
      
        employees.addItemListener(new ItemListener() {
        public void itemStateChanged(ItemEvent arg0) {
            toChange = employees.getSelectedItem().toString();
 
        }
    });
      
      
      JButton edit = new JButton("Edit");      
      c.gridy += 1;
      c.insets = new Insets(10,0,0,10);
      add(edit,c);
      
      edit.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
      
        //System.out.println("Submitted");
        
        toEdit = new employee();
        System.out.println(toChange);
        String[] result = toChange.split("\\s");
        System.out.println(result[0]);
        if(result[0]!="None"){
            toEdit.Emp_ID = Integer.parseInt(result[0]);
            toEdit.Emp_First = result[1];
            toEdit.Emp_Last = result[2];
            JPanel editForm = new JPanel();
            editForm = toEdit.editEmployee();
            removeAll();
            add(editForm);
            validate();
            repaint();
        }
        else{
            removeAll();
            JLabel noSelection = new JLabel("No employees selected");
            c.gridy += 1;
            add(noSelection,c);
            validate();
            repaint();
        }
        
        
        
        
        
              }
    });
      
      
      
      JButton terminate = new JButton("Terminate");
      c.gridx = 1;
      add(terminate,c);
        
        terminate.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
      
        //System.out.println("Submitted");
        
        toEdit = new employee();
        System.out.println(toChange);
        String[] result = toChange.split("\\s");
        System.out.println(result[0]);
        if(result[0]!="None"){
            toEdit.Emp_ID = Integer.parseInt(result[0]);
            toEdit.Emp_First = result[1];
            toEdit.Emp_Last = result[2];
            toEdit.termEmployee();
            
        }
        else{
            removeAll();
            JLabel noSelection = new JLabel("No employees selected");
            c.gridy += 1;
            add(noSelection,c);
            validate();
            repaint();
        }
        
              }
    });
      
      
      rs.close();
      stmt.close();
      conn.close();
      
      
      
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      
      
    }
    
        
       
        
    }
    
}
