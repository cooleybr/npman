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
public class project extends JPanel{
    
    public int Proj_ID,Proj_Emp_ID,Proj_Grant_ID;
    public String Proj_Start,Proj_End,Proj_Title,Proj_Desc;
    public double Proj_Req_Hours,Proj_Req_Funds;
    
    //Constructor for example donor
    public void project(){
        Proj_ID = 0;
        Proj_Emp_ID = 0;
        Proj_Grant_ID = 0;
        Proj_Req_Hours = 0;
        Proj_Req_Funds = 0;//add project creation
        Proj_Start = "currrent_date";
        Proj_End = "currrent_date";
        Proj_Title = "";
        Proj_Desc = "";
        
    }
           
    public void verifyProjectTable(){
        Connection c = null;
        Statement stmt = null;
        
    try {
        
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM project;" );
      while ( rs.next() ) {
         int id = rs.getInt("Proj_ID");
         System.out.println( "ID = " + id );
         }
      rs.close();
      stmt.close();
      c.close();
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      createProjectTable();
      
    }
    System.out.println("Project Check Complete");
    
    } 
    
    public void createProjectTable(){
    String sql = "CREATE TABLE project(Proj_ID numeric Primary Key," 
            + "Proj_Emp_ID numeric,"
            + "Proj_Grant_ID numeric,"
            + "Proj_Start date default current_date,"
            + "Proj_End date default null,"
            + "Proj_Title varchar2(30),"
            + "Proj_Desc varchar2(400),"
            + "Proj_Req_Funds numeric(11,2),"
            + "Proj_Req_Hours numeric);";
            
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
    
        
    public void insertProjectData(){
        
        int projID = getNextProjId();
        String sql = ("Insert into project values(" + projID + "," + Proj_Emp_ID + 
                        "," + Proj_Grant_ID + ",'" + Proj_Start + "','" + Proj_End + "','" + Proj_Title + 
                "','" + Proj_Desc + "'," + Proj_Req_Funds + "," + Proj_Req_Hours + ");");
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
    
    public int getNextProjId(){
    
    
    Connection c = null;
    Statement stmt = null;
    int retProjID;
    
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT MAX(Proj_ID) FROM project;" );
      String donID = rs.getString("MAX(Proj_ID)");
      try{
      retProjID = Integer.parseInt(donID);
      retProjID += 1;
      }
      catch(Exception f){
          retProjID = 1;
      }
      rs.close();
      stmt.close();
      c.close();
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.out.println("Did not get project id");
      Random r = new Random();
          long t1 = System.currentTimeMillis() + r.nextInt();
          retProjID = (int)t1;
      System.out.println("Project ID Generated");
          
    }
    
    return retProjID;
            
    } 
    
   
    public void getSetProjData(){
        Connection c = null;
        Statement stmt = null;
               
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM project where Proj_ID=" + Proj_ID + ";" );
      while ( rs.next() ) {
         Proj_Emp_ID = rs.getInt("Proj_Emp_ID");
         Proj_Grant_ID = rs.getInt("Proj_Grant_ID");
         Proj_Start = rs.getString("Proj_Start");
         Proj_End = rs.getString("Proj_End");
         Proj_Title = rs.getString("Proj_Title");
         Proj_Desc = rs.getString("Proj_Desc");
         Proj_Req_Funds = rs.getDouble("Proj_Req_Funds");    
         Proj_Req_Hours = rs.getDouble("Proj_Req_Hours"); 
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
   
    
    public boolean checkGrantProject(int gid){
        
        Proj_Grant_ID = gid;
        boolean hasProject=false;
        Connection c = null;
        Statement stmt = null;
               
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM project where Proj_Grant_ID=" + Proj_Grant_ID + ";" );
      while( rs.next() ) {
         if(rs.getInt("Proj_Grant_ID")>0){
             hasProject=true;
         }
             
         }
      rs.close();
      stmt.close();
      c.close();
      
      
    }
      catch ( ClassNotFoundException | SQLException e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      //System.exit(0);
    }
        return hasProject;
    }
        public int totalProject(){

        
        int hours = 0;
        Connection c = null;
        Statement stmt = null;
               
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT SUM(Proj_Req_Hours) FROM project where Proj_End='null';" );
      while( rs.next() ) {
         hours = rs.getInt("SUM(Proj_Req_Hours)");
         System.out.println(hours);
         }
                     
      rs.close();
      stmt.close();
      c.close();
         
    }
      catch ( ClassNotFoundException | SQLException e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      //System.exit(0);
    }
        return hours;
    }
    
    
}
