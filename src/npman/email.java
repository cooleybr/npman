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
public class email extends JPanel{
    
    public int Email_ID,Web_ID;
    public String Email_Add, Email_User,Email_Pass;
    public String Email_Srvr;
    public String Email_AddDate,Email_EndDate;
    
    //Constructor for example donor
    public void email(){
        Email_ID = 0;
        Web_ID = 0;
        Email_Add = "";
        Email_User = "";
        Email_Pass = "";
        Email_Srvr = "";
        Email_AddDate = "";
        Email_EndDate = "";
    }
           
    public void verifyEmailTable(){
        Connection c = null;
        Statement stmt = null;
        
    try {
        
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM email;" );
      while ( rs.next() ) {
         int id = rs.getInt("Email_ID");
         }
      rs.close();
      stmt.close();
      c.close();
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      createEmailTable();
      
    }
    System.out.println("Email Check Complete");
    
    } 
    
    public void createEmailTable(){
    String sql = "CREATE TABLE email(Email_ID numeric Primary Key," 
            + "Web_ID numeric,"
            + "Email_Add varchar2(75),"
            + "Email_User varchar2(50),"
            + "Email_Pass varchar2(500),"
            + "Email_AddDate date default current_date,"
            + "Email_EndDate date default null);";
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
    
        
    public void insertEmailData(){
        
        Email_ID = getNextEmailId();
        String sql = ("Insert into email values(" + Email_ID + "," + Web_ID + 
                        ",'" + Email_Add + "','" + Email_Pass + "','" + Email_Srvr +
                    "',current_date,'" + Email_EndDate + "');");
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
      System.out.println("Records created successfully");
            
    }
      catch ( ClassNotFoundException | SQLException e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.out.println("Record not created ");
      
      //System.exit(0);
    }
    
    }
    
    public int getNextEmailId(){
    
    
    Connection c = null;
    Statement stmt = null;
    int retEmailID;
    
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT MAX(Email_ID) FROM email;" );
            try{
          retEmailID = rs.getInt("MAX(Email_ID)");
            retEmailID += 1;
      }
      catch(Exception f){
          retEmailID = 1;
      }
      rs.close();
      stmt.close();
      c.close();
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.out.println("Did not get email id");
      Random r = new Random();
          long t1 = System.currentTimeMillis() + r.nextInt();
          retEmailID = (int)t1;
      System.out.println("Email ID Generated");
          
    }
    
    return retEmailID;
            
    } 
    
   
    public void getSetEmailData(){
        Connection c = null;
        Statement stmt = null;
               
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM email where Email_ID=" + Email_ID + ";" );
      while ( rs.next() ) {
         Web_ID = rs.getInt("Web_ID");
         Email_Add = rs.getString("Email_Add");
         Email_Pass = rs.getString("Email_Pass");
         Email_Srvr = rs.getString("Email_Srvr");
         Email_AddDate = rs.getString("Email_AddDate");
         Email_EndDate = rs.getString("Email_EndDate");
             
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
    
    
}
