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
public class grant extends JPanel{
    
    public int Grant_ID,Grant_Emp_ID;
    public String Grant_Name, Grant_Ref_Num,Grant_Desc,Grant_Org;
    public String Grant_Due_Date,Grant_Posted_Date,Grant_Award_Date,Grant_Submit_Date;
    public double Grant_Amount;
    
    //Constructor for example donor
    public void grant(){
        Grant_ID = 0;
        Grant_Emp_ID = 0;
        Grant_Name = "";
        Grant_Ref_Num = "";
        Grant_Desc = "";
        Grant_Org = "";
        Grant_Due_Date = "";
        Grant_Posted_Date = "";
        Grant_Award_Date = "";
        Grant_Submit_Date = "current_date";
        Grant_Amount = 0.00;
    }
           
    public void verifyGrantTable(){
        Connection c = null;
        Statement stmt = null;
        
    try {
        
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM grant;" );
      while ( rs.next() ) {
         int id = rs.getInt("Grant_ID");
         System.out.println( "ID = " + id );
         }
      rs.close();
      stmt.close();
      c.close();
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      createGrantTable();
      
    }
    System.out.println("Grant Check Complete");
    
    } 
    
    public void createGrantTable(){
    String sql = "CREATE TABLE grant(Grant_ID numeric Primary Key," 
            + "Grant_Emp_ID numeric,"
            + "Grant_Name varchar2(75),"
            + "Grant_Ref_Num varchar2(50),"
            + "Grant_Desc varchar2(500),"
            + "Grant_Org varchar2(75),"
            + "Grant_Posted_Date date default current_date,"
            + "Grant_Due_Date date default null,"
            + "Grant_Submit_Date date default current_date,"
            + "Grant_Award_Date date default null,"
            + "Grant_Amount numeric(15,2));";
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
    
        
    public void insertGrantData(){
        
        int grantID = getNextGrantId();
        String sql = ("Insert into grant values(" + grantID + "," + Grant_Emp_ID + 
                        ",'" + Grant_Name + "','" + Grant_Ref_Num + "','" + Grant_Desc +
                    "','" + Grant_Org + "','" + Grant_Posted_Date + "','" + Grant_Due_Date + "',current_date,'" + Grant_Award_Date + "'," + Grant_Amount + ");");
        System.out.println(sql);
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
    
    public int getNextGrantId(){
    
    
    Connection c = null;
    Statement stmt = null;
    int retGrantID;
    
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT MAX(Grant_ID) FROM grant;" );
      String donID = rs.getString("MAX(Grant_ID)");
      try{
      retGrantID = Integer.parseInt(donID);
      retGrantID += 1;
      }
      catch(Exception f){
          retGrantID = 1;
      }
      rs.close();
      stmt.close();
      c.close();
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.out.println("Did not get grant id");
      Random r = new Random();
          long t1 = System.currentTimeMillis() + r.nextInt();
          retGrantID = (int)t1;
      System.out.println("Grant ID Generated");
          
    }
    
    return retGrantID;
            
    } 
    
   
    public void getSetGrantData(){
        Connection c = null;
        Statement stmt = null;
               
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM grant where Grant_ID=" + Grant_ID + ";" );
      while ( rs.next() ) {
         Grant_Emp_ID = rs.getInt("Grant_Emp_ID");
         Grant_Name = rs.getString("Grant_Name");
         Grant_Ref_Num = rs.getString("Grant_Ref_Num");
         Grant_Desc = rs.getString("Grant_Desc");
         Grant_Org = rs.getString("Grant_Org");
         Grant_Due_Date = rs.getString("Grant_Due_Date");
         Grant_Posted_Date = rs.getString("Grant_Posted_Date");
         Grant_Award_Date = rs.getString("Grant_Award_Date");
         Grant_Submit_Date = rs.getString("Grant_Submit_Date");
         Grant_Amount = rs.getDouble("Grant_Amount");        
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
    
    public JComboBox grantBox(){
        
        JComboBox grantList = new JComboBox();
        grantList.addItem("Add New Grant");
        
        
        try {
        Connection c = null;
        Statement stmt = null;
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM grant;" );
      while ( rs.next() ) {
         grantList.addItem(rs.getInt("Grant_ID") + " " + rs.getString("Grant_Name") + " " 
                 + rs.getDouble("Grant_Amount"));
      }
      
      rs.close();
      stmt.close();
      c.close();
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      
      
    }
    
    return grantList;
    }
    
    public double sum30Grant(){
        Connection c = null;
        Statement stmt = null;
        double grantSum = 0.0;
    try {
        
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM grant where julianday(current_date)-julianday(Grant_Award_Date)<=30;" );
      
      while ( rs.next() ) {
         grantSum += rs.getDouble("Grant_Amount");
         
         }
      rs.close();
      stmt.close();
      c.close();
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          
    }
    return grantSum;    
    } 
    
}
