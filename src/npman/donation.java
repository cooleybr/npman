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
 * @author Mountainside 19
 */
public class donation {
    
    public int Dona_ID,Don_ID,Dona_Emp_ID;
    public double Dona_Amt;
    public String Dona_Ref_Src,Dona_Date,Dona_Method;
    
    public void donation(){
        
        Dona_ID = 1;
        Don_ID = 0;
        Dona_Emp_ID = 1;
        Dona_Amt = 0.00;
        Dona_Ref_Src = "";
        Dona_Date = "";
        Dona_Method = "";
    }
    
    public void verifyDonationTable(){
        
        try {
        Connection c = null;
        Statement stmt = null;
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
        System.out.println("Opened database successfully");
        stmt = c.createStatement();
        
        ResultSet rs = stmt.executeQuery( "SELECT * FROM donation;" );
        
        while ( rs.next() ) {
           int id = rs.getInt("dona_ID");
           System.out.println( "ID = " + id );
        }
        System.out.println("Donation Table Verified");
        rs.close();
        stmt.close();
        c.close();
      
      } catch ( Exception e ) {
        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        System.out.println("Donation Table Being Created");
        createDonationTable();
      
      }
      
   
    }
    
    
    public void createDonationTable(){
    String sql = "CREATE TABLE Donation(Dona_ID numeric Primary Key," 
            + "Don_ID numeric,"
            + "Dona_Emp_ID numeric,"
            + "Dona_Amt numeric(13,2),"
            + "Dona_Ref_Src varchar2(50),"
            + "Dona_Date Date default current_date,"
            + "Dona_Method varchar2(20));";

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
      System.out.println("Donation Table created successfully");
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.out.println("Table not created");
    }
    
    }
    
    public int getNextDonationId(){
    
    
    Connection c = null;
    Statement stmt = null;
    int retDonationID;
    
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT MAX(Dona_ID) FROM donation;" );
      String donID = rs.getString("MAX(Dona_ID)");
      try{
      retDonationID = Integer.parseInt(donID);
      retDonationID += 1;
      }
      catch(Exception f){
          retDonationID = 1;
      }
      rs.close();
      stmt.close();
      c.close();
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.out.println("Did not get donation id");
      Random r = new Random();
          long t1 = System.currentTimeMillis() + r.nextInt();
          retDonationID = (int)t1;
      System.out.println("Donation ID Generated");
          
    }
    
    return retDonationID;
            
    } 
    
    public void insertDonationData(){
        
        int donID = getNextDonationId();
        Dona_ID = donID;
        String sql = ("Insert into donation values(" + Dona_ID + "," + Dona_Emp_ID + "," + Don_ID +
                        "," + Dona_Amt + ",'" + Dona_Ref_Src + "',current_date,'" + Dona_Method + "');"); 
        
        System.out.println(sql);
        Connection c = null;
        Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");

      stmt = c.createStatement(); 
      stmt.executeUpdate(sql);
      stmt.executeUpdate("update donor set donorLastDate=current_date where don_id=" + Don_ID + ";");
      
      stmt.close();
      //c.commit();
      c.close();
      System.out.println("Donation added successfully");
    }
      catch ( ClassNotFoundException | SQLException e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.out.println("Record not created ");
      
      //System.exit(0);
    }
    
    }
    
    public int getCountDonation(){
        int donationCount = 0;
        Connection c = null;
        Statement stmt = null;
        
        
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      
      
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT COUNT(Dona_ID)FROM donation;" );
      while ( rs.next() ) {
         donationCount = rs.getInt("COUNT(Dona_ID)");
      }
      rs.close();
      stmt.close();
      c.close();
          
    }
      catch ( ClassNotFoundException | SQLException e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      //System.exit(0);
    }
    return donationCount;
    }
    
     public double getSumDonation(){
        double donationSum = 0;
        Connection c = null;
        Statement stmt = null;
        
        
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      
      
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT SUM(Dona_Amt)FROM donation;" );
      while ( rs.next() ) {
         donationSum = rs.getInt("SUM(Dona_Amt)");
      }
      rs.close();
      stmt.close();
      c.close();
          
    }
      catch ( ClassNotFoundException | SQLException e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      //System.exit(0);
    }
    return donationSum;
    }
    
}
