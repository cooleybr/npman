/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package npman;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author brc
 */
class donorListPanel extends JPanel {

   ArrayList<String> names;
    
    public donorListPanel() {
    
        setLayout(new GridBagLayout());
        //setPreferredSize(new Dimension(400,300));
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 3;
                   
        JLabel listLocations = new JLabel("Current Donor List");
        
        c.gridx = 0;
        c.gridy = 0;
        
        add(listLocations,c);
        
        Connection con = null;
        Statement stmt = null;
        Statement stmt2 = null;
        try {
      Class.forName("org.sqlite.JDBC");
      con = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      stmt = con.createStatement();
      stmt2 = con.createStatement();
      ResultSet rs2 = stmt.executeQuery("Select * from donor where DonorLastDate IS NULL or julianday(current_date)-julianday(DonorLastDate)>=30;");
      int j = 0;
      ArrayList<Integer> toContact = new ArrayList();
      names = new ArrayList();
      while ( rs2.next() ) {
         //test works - provide opportunity to connect
          j += 1;
          toContact.add(rs2.getInt("Don_ID"));
          
          names.add(rs2.getString("DonorFirstName") + " " + rs2.getString("DonorLastName"));
      }
      JLabel contactNote = new JLabel("There are " + j + " donors in your list without recent donations");
      c.gridy +=1;
      add(contactNote,c);
      
      JButton contactNow = new JButton("Send Contact");
      c.gridy += 1;
      c.insets = new Insets(5,250,5,300);
      add(contactNow,c);
      
      contactNow.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
          c.insets = new Insets(0,0,0,0);
          c.gridx = 1;
          c.gridy = 0;
          mailerForm reqDon =  new mailerForm();
          JPanel createReq = reqDon.mailerForm(toContact);
          JScrollPane scroll = new JScrollPane(createReq);
        removeAll();
        
        add(scroll);
        JPanel list = new JPanel();
        list.setLayout(new GridBagLayout());
        JLabel listTitle = new JLabel("Recipients:");
        c.gridx = 0;
        c.gridy = 0;
        list.add(listTitle,c);
        for(int i=0;i<names.size();i++){
            JLabel name = new JLabel(names.get(i));
            c.gridx = 0;
            c.gridy += 1;
            list.add(name,c);
            
        }
        JScrollPane scroll2 = new JScrollPane(list);
        //scroll2.setPreferredSize(new Dimension (100,500));
        c.gridy = 0;
        c.gridx = 0;
        add(scroll2);
        validate();
        repaint();
        
              }
    });
      
      rs2.close();
      stmt2.close();
      c.insets = new Insets(5,50,5,0);
      ResultSet rs = stmt.executeQuery( "SELECT * FROM donor;" );
      while ( rs.next() ) {
        
          JLabel name = new JLabel("Name: " + rs.getString("DonorFirstName") + " " + 
                                    rs.getString("DonorLastName"));
          c.gridy += 1;
          add(name,c);
          
          JLabel address = new JLabel("Address: " + rs.getString("DonorAdd1") + " " + 
                                    rs.getString("DonorAdd2"));
          c.gridy += 1;
          add(address,c);
          
          JLabel citStaZip = new JLabel("City/State/Zip: " + rs.getString("DonorCity") + ", " +
                            rs.getString("DonorState") + " " + rs.getString("DonorZip"));
          c.gridy += 1;
          add(citStaZip,c);
          
          JLabel contact = new JLabel("Phone: " + rs.getString("DonorPhone") + " " + 
                                   rs.getString("DonorEmail"));
          c.gridy += 1;
          add(contact,c);
          
          JLabel info = new JLabel ("Referred By: " + rs.getString("DonorReferSrc") + " " + 
                            "Date Added: " + rs.getString("DonorAddDate") + " Last Donation: " + 
                            rs.getString("DonorLastDate"));
          c.gridy +=1;
          add(info,c);
          
          
          
          JLabel spacer = new JLabel("---------------------------------------------------");
          c.gridy += 1;
          add(spacer,c);

      }
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
