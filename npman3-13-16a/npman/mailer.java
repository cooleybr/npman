/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package npman;
import java.sql.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
/**
 *
 * @author brc
 */
public class mailer extends JPanel{
    
    public int Mail_ID, Mail_Loc_ID;
    public String Mail_Name, Mail_Message, Mail_Img, Mail_Ref_ID, Mail_Date, Mail_Method;
    
    public void mailer(){
        Mail_ID = 1;
        Mail_Name = "Test Mailer";
        Mail_Message = "This is a test mailer/email";
        Mail_Img = "placeholder.jpg";
        Mail_Loc_ID = 1;
        Mail_Ref_ID = "Location 1";
        Mail_Date = "2016-01-01";
        Mail_Method = "Print";
    }
    
    public void verifyMailerTable(){
    Connection c = null;
        Statement stmt = null;
    try {
        
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      stmt = c.createStatement();
      
      ResultSet rs = stmt.executeQuery( "SELECT * FROM mailer;" );
      while ( rs.next() ) {
         int id = rs.getInt("Mail_ID");
         System.out.println( "ID = " + id );
         System.out.println();
      }
      
      rs.close();
      stmt.close();
      c.close();
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      createMailerTable();
      
    }
    System.out.println("Mailer Check Complete");
    
    } 
    
    public void createMailerTable(){
    String sql = "CREATE TABLE mailer(Mail_ID numeric Primary Key," 
            + "Mail_Name varchar2(50),"
            + "Mail_Message varchar2(250),"
            + "Mail_Img varchar2(50),"
            + "Mail_Loc_ID numeric,"
            + "Mail_Ref_ID varchar2(25),"
            + "Mail_Date Date default current_date,"
            + "Mail_Method varchar2(15));";
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      stmt = c.createStatement();
      stmt.executeUpdate(sql);
      stmt.close();
      c.close();
      System.out.println("Table created successfully");
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.out.println("Table not created");
    }
    
    }
    
    public JPanel viewMailerTable(){
    
        JPanel dV = new JPanel();
        dV.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 3;
        dV.setMinimumSize(new Dimension(400,400));
        JLabel empView =  new JLabel("Mailer List");
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0,0,20,0);
        dV.add(empView,c);
    
        c.insets = new Insets(0,0,0,0);
        Connection conn = null;
        Statement stmt = null;
        try {
        
      Class.forName("org.sqlite.JDBC");
      conn = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM mailer;" );
      while ( rs.next() ) {
         JLabel id = new JLabel("Mailer ID: " + rs.getInt("Mail_ID") + " Name: " + rs.getString("Mail_Name"));
         c.gridy += 1;
         dV.add(id,c);
                  
         try {
                    
          BufferedImage myPicture = ImageIO.read(new File(rs.getString("Mail_Img")));
          JLabel logoView = new JLabel(new ImageIcon(myPicture));
          logoView.setPreferredSize(new Dimension(150,150));
          c.gridy +=1;
          dV.add(logoView,c);
            }
        catch(IOException i ) {
          
           JLabel logoView = new JLabel("Could not retrieve image: " + rs.getString("Mail_Img"));
            c.gridy += 1;
            dV.add(logoView,c);
            }
         
         JLabel message = new JLabel("Message: " + rs.getString("Mail_Message"));
         c.gridy += 1;
         dV.add (message,c);
         
         JLabel date = new JLabel("Date: " + rs.getString("Mail_Date") + " Method: " + rs.getString("Mail_Method"));
         c.gridy +=1;
         dV.add(date,c);
         
         JLabel spacer = new JLabel("_____________________________________________________________");
         c.gridy += 1;
         dV.add(spacer,c);
         
              }
      
      rs.close();
      stmt.close();
      conn.close();
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      createMailerTable();
      
    }
    return dV;
    } 
    
    public JPanel mailRecipientPane(){
        ArrayList recipients = new ArrayList();
        JPanel contents = new JPanel();
        contents.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.ipady = 3;
        
        JLabel recipList = new JLabel("Select Mailer to Send");
        c.gridy = 0;
        c.insets = new Insets(0,0,0,0);
        contents.add(recipList,c);
        
        JComboBox print = new JComboBox();
        printMenu pmen = new printMenu();
        print = pmen.printList();
        c.gridy = 1;
        c.gridx = 0;
        contents.add(print,c);
        
        JComboBox email = new JComboBox();
        emailMenu emen = new emailMenu();
        email = emen.emailList();
        c.gridy = 1;
        c.gridx = 1;
        contents.add(email,c);
        
        JLabel select = new JLabel("Select Recipients:");
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(0,10,0,10);
        contents.add(select,c);
        c.insets = new Insets(0,0,0,0);
        Connection con = null;
        Statement stmt = null;
    try {
        
      Class.forName("org.sqlite.JDBC");
      con = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      stmt = con.createStatement();
      JPanel donor = new JPanel();
      donor.setLayout(new GridBagLayout());
      c.gridx =0;
      c.gridy =0;
      ResultSet rs = stmt.executeQuery( "SELECT * FROM donor;" );
      while ( rs.next() ) {
         JCheckBox don = new JCheckBox(rs.getString("DonorFirstName") + " " + rs.getString("DonorLastName"));
         c.gridy +=1;
         donor.add(don,c);
         don.addItemListener(new ItemListener()
    {
      public void itemStateChanged(ItemEvent e)
      {
      
        if(e.getStateChange()==1){
            recipients.add(don.getText());
                }
        
        
              }
    });
      }
      JScrollPane donScroll = new JScrollPane(donor);
      c.gridy = 3;
      c.gridx = 0;
      donScroll.setPreferredSize(new Dimension(250,200));
      contents.add(donScroll,c);
      
      JPanel emp = new JPanel();
      emp.setLayout(new GridBagLayout());
      c.gridy =0;
      c.gridx = 0;
      rs = stmt.executeQuery( "SELECT * FROM employee;" );
      while ( rs.next() ) {
         JCheckBox emps = new JCheckBox(rs.getString("Emp_First") + " " + rs.getString("Emp_Last"));
         c.gridy += 1;
         emp.add(emps,c);
         emps.addItemListener(new ItemListener()
    {
      public void itemStateChanged(ItemEvent e)
      {
      
        if(e.getStateChange()==1){
            recipients.add(emps.getText());
                }
        
        
              }
    });
      }
      JScrollPane empScroll = new JScrollPane(emp);
      c.gridy = 3;
      c.gridx = 1;
      empScroll.setPreferredSize(new Dimension(250,200));
      contents.add(empScroll,c);
      
      JButton send = new JButton("Send");
      c.gridy = 4;
      c.gridx = 1;
      contents.add(send,c);
      send.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
          pmen.getPrint();
          emen.getEmail();
          if(!pmen.selectedPrint.equals("--None--")){
              int mailID = pmen.selectedID;
              contents.removeAll();
        JLabel sent = new JLabel("Mailer Printed");
        for(int i=0;i<recipients.size();i++){
            System.out.println(recipients.get(i));
        }
        contents.add(sent);
        contents.validate();
        contents.repaint();
          }
          else if(!emen.selectedEmail.equals("--None--")){
              int mailID = emen.selectedID;
              contents.removeAll();
        JLabel sent = new JLabel("Email Sent");
        for(int i=0;i<recipients.size();i++){
            System.out.println(recipients.get(i));
        }
        contents.add(sent);
        contents.validate();
        contents.repaint();
              
          }
          else{
              
        JLabel sent = new JLabel("Please Choose A Mailer");
               c.gridy = 5;
               c.gridx = 1;
               contents.add(sent,c);
               contents.revalidate();
               contents.repaint();
          }
                     
        
              }
    });
      
      
      rs.close();
      stmt.close();
      con.close();
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      
      
    }
               
          
        
        
        return contents;
    }
    
    
    public void insertMailer(){
    Connection c = null;
        Statement stmt = null;
    try {
        
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      stmt = c.createStatement();
      stmt.executeUpdate( "insert into mailer values("+Mail_ID+",'"+Mail_Name+"','"+Mail_Message+
              "','"+Mail_Img+"',"+Mail_Loc_ID+",'"+Mail_Ref_ID+"',current_date,'"+Mail_Method+"');" );
            
    
      stmt.close();
      c.close();
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      createMailerTable();
      
    }
    System.out.println("Mailer Check Complete");
    
    } 
    
    public int getNextMailID(){
    Connection c = null;
    Statement stmt = null;
    int retMailID;
    
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT MAX(Mail_ID) FROM mailer;" );
      String EmpID = rs.getString("MAX(Mail_ID)");
      try{
      retMailID = Integer.parseInt(EmpID);
      retMailID += 1;
      }
      catch(Exception f){
          retMailID = 1;
      }
      rs.close();
      stmt.close();
      c.close();
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.out.println("Did not get id");
      Random r = new Random();
          long t1 = System.currentTimeMillis() + r.nextInt();
          retMailID = (int)t1;
      System.out.println("Mailer ID Generated");
          
    }
    
    return retMailID;
            
    } 
    
}
