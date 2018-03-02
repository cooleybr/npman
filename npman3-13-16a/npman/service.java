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
public class service extends JPanel{
    
    public int Serv_ID,Serv_Emp_ID,Serv_Event_ID,Serv_Grant_ID,Serv_Proj_ID;
    public String Serv_Date,Serv_Type,Serv_Desc;
    public double Serv_Mon_Val,Serv_Hours;
    
    //Constructor for example donor
    public void service(){
        Serv_ID = 0;
        Serv_Emp_ID = 0;
        Serv_Event_ID = 0;
        Serv_Grant_ID = 0;
        Serv_Proj_ID = 0;//add project creation
        Serv_Date = "currrent_date";
        Serv_Type = "";
        Serv_Desc = "";
        Serv_Mon_Val = 0.00;
        Serv_Hours = 0;
    }
           
    public void verifyServiceTable(){
        Connection c = null;
        Statement stmt = null;
        
    try {
        
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      stmt = c.createStatement();
      
      ResultSet rs = stmt.executeQuery( "SELECT * FROM service;" );
      while ( rs.next() ) {
         int id = rs.getInt("Serv_ID");
         System.out.println( "ID = " + id );
         }
      rs.close();
      stmt.close();
      c.close();
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      createServiceTable();
      
    }
    System.out.println("Service Check Complete");
    
    } 
    
    public void createServiceTable(){
    String sql = "CREATE TABLE service(Serv_ID numeric Primary Key," 
            + "Serv_Emp_ID numeric,"
            + "Serv_Event_ID numeric,"
            + "Serv_Grant_ID numeric,"
            + "Serv_Proj_ID numeric,"
            + "Serv_Date date default current_date,"
            + "Serv_Type varchar2(30),"
            + "Serv_Desc varchar2(400),"
            + "Serv_Mon_Val numeric(11,2),"
            + "Serv_Hours numeric);";
            
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
    
        
    public void insertServiceData(){
        
        int servID = getNextServId();
        String sql = ("Insert into service values(" + servID + "," + Serv_Emp_ID + 
                        "," + Serv_Event_ID + "," + Serv_Grant_ID +
                    "," + Serv_Proj_ID + ",'" + Serv_Date + "','" + Serv_Type + 
                "','" + Serv_Desc + "'," + Serv_Mon_Val + "," + Serv_Hours + ");");
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
    
    public int getNextServId(){
    
    
    Connection c = null;
    Statement stmt = null;
    int retServID;
    
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT MAX(Serv_ID) FROM service;" );
      String donID = rs.getString("MAX(Serv_ID)");
      try{
      retServID = Integer.parseInt(donID);
      retServID += 1;
      }
      catch(Exception f){
          retServID = 1;
      }
      rs.close();
      stmt.close();
      c.close();
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.out.println("Did not get service id");
      Random r = new Random();
          long t1 = System.currentTimeMillis() + r.nextInt();
          retServID = (int)t1;
      System.out.println("Service ID Generated");
          
    }
    
    return retServID;
            
    } 
    
   
    public void getSetServData(){
        Connection c = null;
        Statement stmt = null;
               
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM service where Serv_ID=" + Serv_ID + ";" );
      while ( rs.next() ) {
         Serv_Emp_ID = rs.getInt("Serv_Emp_ID");
         Serv_Event_ID = rs.getInt("Serv_Event_ID");
         Serv_Grant_ID = rs.getInt("Serv_Grant_ID");
         Serv_Proj_ID = rs.getInt("Serv_Proj_ID");
         Serv_Date = rs.getString("Serv_Date");
         Serv_Type = rs.getString("Serv_Type");
         Serv_Desc = rs.getString("Serv_Desc");
         Serv_Mon_Val = rs.getDouble("Serv_Mon_Val");    
         Serv_Hours = rs.getDouble("Serv_Hours"); 
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
