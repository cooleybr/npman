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
class editDonorPanel extends JPanel {

    
    public String toChange;
    public Donor toEdit;
    public int id;
    
    public editDonorPanel() {
    
        setLayout(new GridBagLayout());
        setMinimumSize(new Dimension(400,300));
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.ipady = 3;
     
        JLabel empView =  new JLabel("Select Donor To Change");
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0,0,20,0);
        add(empView,c);
    
        c.insets = new Insets(0,0,0,0);
        
        toChange = "None";
        JComboBox donors = new JComboBox();
        
        try {
        Connection conn = null;
        Statement stmt = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
        System.out.println("Opened database successfully");
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery( "SELECT * FROM donor;" );
        donors.addItem("None");
      while ( rs.next() ) {
         id = rs.getInt("Don_ID");
         String first = (rs.getInt("Don_ID") + " " + rs.getString("DonorFirstName") + " " + rs.getString("DonorLastName"));
         
         donors.addItem(first);
                
              }
      c.gridy +=1;
      add(donors,c);
      
      
        donors.addItemListener(new ItemListener() {
        public void itemStateChanged(ItemEvent arg0) {
            toChange = donors.getSelectedItem().toString();
 
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
        
        toEdit = new Donor();
        System.out.println(toChange);
        String[] result = toChange.split("\\s");
        System.out.println(result[0]);
        if(result[0]!="None"){
            toEdit.donID = Integer.parseInt(result[0]);
            toEdit.donorFirstName = result[1];
            toEdit.donorLastName = result[2];
            toEdit.getSetDonorData();
            JPanel editDonor = new JPanel();
            editDonor = toEdit.editDonor();
            removeAll();
            add(editDonor);
            validate();
            repaint();
        }
        else{
            removeAll();
            JLabel noSelection = new JLabel("No donors selected");
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
