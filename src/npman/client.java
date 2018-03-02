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
public class client extends JPanel{
    
    public static String Client_First,Client_Last;
    public static String Client_Add1,Client_Add2,Client_City,Client_State,Client_Zip;
    public static String Client_Phone,Client_Email, Client_AddDate,Client_LastDate;
    public int Client_ID,Client_Loc_ID;
    
    //Constructor for example donor
    public void client(){
     Client_First = "";
     Client_Last = "";
     Client_Add1 = "";
     Client_Add2 = "";
     Client_City = "";
     Client_State = "";
     Client_Zip = "";
     Client_Phone = "";
     Client_Email = "";
     Client_ID = 0;
     Client_Loc_ID = 0;
     Client_AddDate = "";
     Client_LastDate = "";
    }

    public JPanel clientDetailView(){
        JPanel dV = new JPanel();
        dV.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.ipady = 3;
           
        JLabel profTitle =  new JLabel("Client Profile");
        c.gridx = 0;
        c.gridy = 0;
        dV.add(profTitle,c);
           
        JLabel name = new JLabel(Client_First + " " + Client_Last);
        c.gridx = 0;
        c.gridy = 1;
        dV.add(name,c);
        
        JLabel add1 = new JLabel(Client_Add1 + " " + Client_Add2);
        c.gridx = 0;
        c.gridy = 2;
        dV.add(add1,c);
        
        JLabel add2 = new JLabel(Client_City + ", " + Client_State + " " + Client_Zip);
        c.gridx = 0;
        c.gridy = 3;
        dV.add(add2,c);
        
        JLabel contact = new JLabel("Phone: " + Client_Phone + " Email: " + Client_Email);
        c.gridx = 0;
        c.gridy = 4;
        dV.add(contact,c);
        
        JLabel dates = new JLabel("Added: " + Client_AddDate + " End: " + Client_AddDate);
        c.gridx = 0;
        c.gridy = 5;
        dV.add(dates,c);

        return dV;
    }
       
    public void verifyClientTable(){
    Connection c = null;
        Statement stmt = null;
    try {
        
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      
      stmt = c.createStatement();
      
      ResultSet rs = stmt.executeQuery( "SELECT * FROM client;" );
      while ( rs.next() ) {
         int id = rs.getInt("Client_ID");
        
      }
      
      rs.close();
      stmt.close();
      c.close();
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      createClientTable();
      
    }
    System.out.println("Client Check Complete");
    
    } 
    
    public void createClientTable(){
    String sql = "CREATE TABLE client(Client_ID numeric Primary Key," 
            + "Client_Loc_ID numeric,"
            + "Client_First varchar2(50),"
            + "Client_Last varchar2(50),"
            + "Client_Add1 varchar2(50),"
            + "Client_Add2 varchar2(25),"
            + "Client_City varchar2(35),"
            + "Client_State varchar2(20),"
            + "Client_Zip varchar2(10),"
            + "Client_Phone varchar2(15),"
            + "Client_Email varchar2(40),"
            + "Client_AddDate Date default current_date,"
            + "Client_LastDate Date default NULL) ;";

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
    
        
    public void insertClientData(){
        
        Client_ID = getNextClientId();
        String sql = ("Insert into client values(" + Client_ID + "," + Client_Loc_ID + 
                        ",'" + Client_First + "','" + Client_Last + "','" + Client_Add1 +
                    "','" + Client_Add2 + "','" + Client_City + "','" + Client_State + "','" + 
                    Client_Zip + "','" + Client_Phone + "','" + Client_Email + "','" 
                + Client_AddDate + "',NULL);");
        
        Connection c = null;
        Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");

      stmt = c.createStatement(); 
      stmt.executeUpdate(sql);
      stmt.close();
      //c.commit();
      c.close();
           
      
    }
      catch ( ClassNotFoundException | SQLException e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.out.println("Record not created ");
      
      //System.exit(0);
    }
    
    }
    
    public int getNextClientId(){
    
    
    Connection c = null;
    Statement stmt = null;
    int retClientID;
    
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT MAX(Client_ID) FROM client;" );
      String donID = rs.getString("MAX(Client_ID)");
      try{
      retClientID = Integer.parseInt(donID);
      retClientID += 1;
      }
      catch(Exception f){
          retClientID = 1;
      }
      rs.close();
      stmt.close();
      c.close();
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.out.println("Did not get client id");
      Random r = new Random();
          long t1 = System.currentTimeMillis() + r.nextInt();
          retClientID = (int)t1;
      System.out.println("Client ID Generated");
          
    }
    
    return retClientID;
            
    } 
    
    public JPanel viewClientData(){
        Connection con = null;
        Statement stmt = null;
        JPanel cV = new JPanel();
        cV.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.ipady = 3;
        
        
    try {
      Class.forName("org.sqlite.JDBC");
      con = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM client;" );
      while ( rs.next() ) {
         JLabel name = new JLabel(rs.getString("Client_First") + " " + rs.getString("Client_Last"));
         c.gridx = 0;
         c.gridy += 1;
         cV.add(name,c);
         
         JLabel add = new JLabel(rs.getString("Client_Add1") + " " + rs.getString("Client_Add2"));
         c.gridx = 0;
         c.gridy += 1;
         cV.add(add,c);
         
         JLabel add1 = new JLabel(rs.getString("Client_City") + ", " + rs.getString("Client_State") +  
                            " " + rs.getString("Client_Zip"));
         c.gridx = 0;
         c.gridy += 1;
         cV.add(add1,c);
         
         JLabel contact = new JLabel("Phone: " + rs.getString("Client_Phone") + " Email: " + rs.getString("Client_Email"));
         c.gridx = 0;
         c.gridy += 1;
         cV.add(contact,c);
         
         JLabel dates = new JLabel("Added: " + rs.getString("Client_AddDate") + " End: " + rs.getString("Client_LastDate"));
         c.gridx = 0;
         c.gridy += 1;
         cV.add(dates,c);
         
         JLabel spacer = new JLabel("--------------------------------------------------------------");
         c.gridx = 0;
         c.gridy += 1;
         cV.add(spacer,c);
     
      }
      rs.close();
      stmt.close();
      con.close();
      
      
    }
      catch ( ClassNotFoundException | SQLException e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      //System.exit(0);
    }
    System.out.println("Records viewed successfully");
    return cV;
    
    }
    
   
    public void getSetClientData(){
        Connection c = null;
        Statement stmt = null;
        
        
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM client where Client_ID=" + Client_ID + ";" );
      while ( rs.next() ) {
         Client_First = rs.getString("Client_First");
         Client_Last = rs.getString("Client_Last");
         Client_Add1 = rs.getString("Client_Add1");
         Client_Add2 = rs.getString("Client_Add2");
         Client_City = rs.getString("Client_City");
         Client_State = rs.getString("Client_State");
         Client_Zip = rs.getString("Client_Zip");
         Client_Phone = rs.getString("Client_Phone");
         Client_Email = rs.getString("Client_Email");
         Client_AddDate = rs.getString("Client_AddDate");
         Client_LastDate = rs.getString("Client_LastDate");
        
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
    
    public JComboBox clientBox(){
        
        JComboBox clientList = new JComboBox();
        clientList.addItem("Add New Client");
        
        
        try {
        Connection c = null;
        Statement stmt = null;
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM client;" );
      while ( rs.next() ) {
         clientList.addItem(rs.getInt("Client_ID") + " " + rs.getString("Client_First") + " " 
                 + rs.getString("Client_Last"));
      }
      
      rs.close();
      stmt.close();
      c.close();
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      
      
    }
    
    return clientList;
    }
    
    
    
        
    public int getCountClient(){
        int clientCount = 0;
        Connection c = null;
        Statement stmt = null;
        
        
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      
      
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT COUNT(Client_ID)FROM client;" );
      while ( rs.next() ) {
         clientCount = rs.getInt("COUNT(Client_ID)");
      }
      rs.close();
      stmt.close();
      c.close();
          
    }
      catch ( ClassNotFoundException | SQLException e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      //System.exit(0);
    }
    return clientCount;
    }
    
    public void editDonor(){
        //build edit function
        
    }
    
}
