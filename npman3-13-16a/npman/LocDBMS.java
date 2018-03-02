/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package npman;
import java.sql.*;
import java.util.*;
/**
 *
 * @author brc
 */
public class LocDBMS {
    
    
    public void OpenDB(){
    Connection c = null;
    Statement stmt = null;
    try {
        //open sqllite db connection
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
        c.setAutoCommit(false);
        System.out.println("Opened database successfully");
        c.close();
        }
        catch ( Exception e ) {
        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        //System.exit(0);
        }
    }
    
    public boolean verifyLocationTable(){
    
    boolean locDataExists = false;
    Connection c = null;
    Statement stmt = null;
    
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM location;" );
      locDataExists = true;
      rs.close();
      stmt.close();
      c.close();
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.out.println("Need to build table");
      createLocTable();
      
    }
    System.out.println("Location Check Complete");
    return locDataExists;
    } 
    
    public void createLocTable(){
    String tab = "CREATE TABLE location(Loc_ID numeric Primary Key," 
            + "LocOrgName varchar2(50),"
            + "loc_add1 varchar2(50),"
            + "loc_add2 varchar2(25),"
            + "loc_city varchar2(35),"
            + "loc_state varchar2(20),"
            + "loc_zip varchar2(10),"
            + "loc_phone varchar2(15),"
            + "loc_fax varchar2(15),"
            + "loc_url varchar2(40),"
            + "loc_tax_id varchar2(15),"
            + "loc_logo varchar2(75)," 
            + "loc_active_date date default current_date,"
            + "loc_closed_date date default NULL);";
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      String sql = tab; 
      stmt.executeUpdate(sql);
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      //System.exit(0);
    }
    System.out.println("Table created successfully");
    }
    
    public void InsertLocData(String toAdd){
        String locInfo = toAdd;
        Connection c = null;
        Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      String sql = locInfo; 
      stmt.executeUpdate(sql);
      stmt.close();
      //c.commit();
      c.close();
    }
      catch ( ClassNotFoundException | SQLException e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      //System.exit(0);
    }
    System.out.println("Records created successfully");
    }
    
    public ArrayList viewLocData(){
        Connection c = null;
        Statement stmt = null;
        ArrayList locListing = new ArrayList();   
        
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      
      
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM location;" );
      while ( rs.next() ) {
         String ID = rs.getString("Loc_ID");
         String Name = rs.getString("LocOrgName");
         String Add1 = rs.getString("loc_add1");
         String Add2 = rs.getString("loc_add2");
         String City = rs.getString("loc_city");
         String State = rs.getString("loc_state");
         String Zip = rs.getString("loc_zip");
         String Phone = rs.getString("loc_phone");
         String Fax = rs.getString("loc_fax");
         String URL = rs.getString("loc_url");
         String TaxId = rs.getString("loc_tax_id");
         String Logo = rs.getString("loc_logo");
         
         String location = (ID + " " + Name + " " + Add1 + " " + Add2 + " " + City + " " +
                            State + " " + Zip + " " + Phone + " " + Fax + " " + URL + " " + 
                            TaxId + " " + Logo);
         System.out.println(location);
         locListing.add(location);
         //System.out.println( "NAME = " + name );
      }
      rs.close();
      stmt.close();
      c.close();
      
      
    }
      catch ( ClassNotFoundException | SQLException e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      //System.exit(0);
    }
    System.out.println("Records viewed successfully");
    return(locListing);
    
    }
    
        public void deleteLocData(String toDelete){
        String locInfo = toDelete;
        Connection c = null;
        Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      String sql = locInfo; 
      stmt.executeUpdate(sql);
      stmt.close();
      //c.commit();
      c.close();
    }
      catch ( ClassNotFoundException | SQLException e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      //System.exit(0);
    }
    System.out.println("Record Deleted successfully");
    }
    
        public int getNextLocId(){
    
    
    Connection c = null;
    Statement stmt = null;
    int retLocID;
    
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT MAX(loc_id) FROM location;" );
      System.out.println(rs);
      String locID = rs.getString("MAX(loc_id)");
      try{
      retLocID = Integer.parseInt(locID);
      retLocID = retLocID + 1;
      } 
      catch(Exception e){
          retLocID = 1;
      }
      rs.close();
      stmt.close();
      c.close();
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.out.println("Need to build table");
      Random r = new Random();
          long t1 = System.currentTimeMillis() + r.nextInt();
          retLocID = (int)t1;
    }
    System.out.println("Location ID Found");
    return retLocID;
    } 
        
        
        
        
}
