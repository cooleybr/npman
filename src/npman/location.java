/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package npman;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author brc
 */
public class location {
    public static int orgID;
    public static String orgName,orgAdd1,orgAdd2,orgCity,orgState,orgZip;
    public static String orgPhone,orgFax,orgWeb,orgLogo;
    public static String orgTaxID,orgActDate,orgCloseDate;
    
    public location(){
        orgID = 0;
        orgName = "";
        orgAdd1 = "";
        orgAdd2 = "";
        orgCity = "";
        orgState = "";
        orgZip = "";
        orgPhone = "";
        orgFax = "";
        orgWeb = "";
        orgLogo = "";
        orgTaxID = "";
        orgActDate = "";
        orgCloseDate = "";
    }
    
    public void retrSetLocData(int location){
        int locID = location;
        Connection c = null;
        Statement stmt = null;
        
        
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      
      
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM location where loc_id=" + locID + ";" );
      while ( rs.next() ) {
         orgID = Integer.parseInt(rs.getString("Loc_ID"));
         orgName = rs.getString("LocOrgName");
         orgAdd1 = rs.getString("loc_add1");
         orgAdd2 = rs.getString("loc_add2");
         orgCity = rs.getString("loc_city");
         orgState = rs.getString("loc_state");
         orgZip = rs.getString("loc_zip");
         orgPhone = rs.getString("loc_phone");
         orgFax = rs.getString("loc_fax");
         orgWeb = rs.getString("loc_url");
         orgTaxID = rs.getString("loc_tax_id");
         orgLogo = rs.getString("loc_logo");
         orgActDate = rs.getString("loc_active_date");
         orgCloseDate = rs.getString("loc_closed_date");
         
         System.out.println(location);
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
    
     public void updateLocData(){
        
        Connection c = null;
        Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      stmt = c.createStatement(); 
      stmt.executeUpdate("update location set Locorgname ='" + orgName + "',loc_add1='" + orgAdd1 +
                        "',loc_add2='" + orgAdd2 + "',loc_city='" + orgCity + "',loc_state='" + orgState +
                        "',loc_zip='" + orgZip + "',loc_phone='" + orgPhone + "',loc_fax='" + orgFax + 
                        "',loc_url='" + orgWeb + "',loc_tax_id='" + orgTaxID + "',loc_logo='"+  orgLogo + 
                        "' where loc_id=" + orgID + ";");
      stmt.close();
      //c.commit();
      c.close();
      System.out.println("Records Updated successfully");
    }
      catch ( ClassNotFoundException | SQLException e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.out.println("Records Not Updated successfully");
      //System.exit(0);
    }
    //System.out.println("Records Updated successfully");
    }
    
     public int getCountLoc(){
        int locCount = 0;
        Connection c = null;
        Statement stmt = null;
        
        
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      
      
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT COUNT(Loc_ID)FROM location;" );
      while ( rs.next() ) {
         locCount = rs.getInt("COUNT(Loc_ID)");
      }
      rs.close();
      stmt.close();
      c.close();
          
    }
      catch ( ClassNotFoundException | SQLException e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      //System.exit(0);
    }
    return locCount;
    }
    
     public void updateLocColumns(){
        
        Connection c = null;
        Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      stmt = c.createStatement(); 
      //stmt.executeUpdate("alter table location add loc_active_date date;");
      //stmt.executeUpdate("alter table location add loc_closed_date date;");
      //stmt.executeUpdate("update location set loc_active_date='2016-01-01';");
      stmt.close();
      //c.commit();
      c.close();
      System.out.println("Records Updated successfully");
    }
      catch ( ClassNotFoundException | SQLException e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.out.println("Records Not Updated successfully");
      //System.exit(0);
    }
    //System.out.println("Records Updated successfully");
    }
    
     
     
}
