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
public class webPage {
    
    public int Web_Pg_ID,Web_ID,Web_Pg_Parent;
    public String Web_Pg_Title,Web_Pg_Desc,Web_Pg_Body,Web_Pg_Img,Web_Pg_St_Date,Web_Pg_End_Date;
    
    public void webPage(){
        Web_Pg_ID = 0;
        Web_ID = 0;
        Web_Pg_Parent=0;
        Web_Pg_Title = "";
        Web_Pg_Desc = "";
        Web_Pg_Body = "";
        Web_Pg_Img = "";
        Web_Pg_St_Date = "";
        Web_Pg_End_Date = "";
    }
    
    public void verifyWebTable(){
        Connection c = null;
        Statement stmt = null;
        try {
        
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM webpage;" );
      while ( rs.next() ) {
         int id = rs.getInt("Web_Pg_ID");
         System.out.println( "ID = " + id );
         
      }
      System.out.println("Website Table Verified");
      rs.close();
      stmt.close();
      c.close();
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      createWebPageTable();
      System.out.println("Webpage Table Being Created");
      
    }
        
      
    
    } 
    
    public void createWebPageTable(){
        
       String sql = "CREATE TABLE webpage(Web_Pg_ID numeric Primary Key," 
            + "Web_ID numeric,"
            + "Web_Pg_Parent numeric,"
            + "Web_Pg_Title varchar2(75),"
            + "Web_Pg_Desc varchar2(200),"
            + "Web_Pg_Body varchar2(2000),"
            + "Web_Pg_Img varchar2(150),"
            + "Web_Pg_St_Date Date default current_date,"
            + "Web_Pg_End_Date Date default NULL);";
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
      System.out.println("Web Table created successfully");
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.out.println("Web Table not created");
    }  
        
    }
    
    public void insertWebPageData(){
        
        int webpageID = getNextWebPageID();
        Web_Pg_ID = webpageID;
        String sql = ("Insert into webpage values(" + Web_Pg_ID + "," + Web_ID + 
                        "," + Web_Pg_Parent + ",'" + Web_Pg_Title + "','" + Web_Pg_Desc + "','" + Web_Pg_Body +
                    "','" + Web_Pg_Img + "',current_date,NULL);");
        System.out.println("Parent Page: " + Web_Pg_Parent);
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
      System.out.println("Webpage Record created successfully");
    }
      catch ( ClassNotFoundException | SQLException e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.out.println("Webpage Record not created ");
      
      //System.exit(0);
    }
    
    }
    
    public int getNextWebPageID(){
    Connection c = null;
    Statement stmt = null;
    int retWebPageID;
    
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT MAX(Web_Pg_ID) FROM webpage;" );
      String EmpID = rs.getString("MAX(Web_Pg_ID)");
      try{
      retWebPageID = Integer.parseInt(EmpID);
      retWebPageID += 1;
      }
      catch(Exception f){
          retWebPageID = 1;
      }
      rs.close();
      stmt.close();
      c.close();
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.out.println("Did not get id");
      Random r = new Random();
          long t1 = System.currentTimeMillis() + r.nextInt();
          retWebPageID = (int)t1;
      System.out.println("Webpage ID Generated");
          
    }
    
    return retWebPageID;
            
    } 
    
    public JPanel webConfirmPanel(){
        
      JPanel webConfirm = new JPanel();
      webConfirm.setLayout(new GridBagLayout());
      GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 3;
        webConfirm.setMinimumSize(new Dimension(400,300));
      JLabel title = new JLabel("Is the following information correct?");
      c.gridy = 1;
      webConfirm.add(title,c);
      
      JLabel URL = new JLabel("Title: " + Web_Pg_Title);
      c.gridy = 2;
      webConfirm.add(URL,c);
      JLabel FTP_URL = new JLabel("Description: " + Web_Pg_Desc);
      c.gridy = 3;
      webConfirm.add(FTP_URL,c);
      JLabel FTP_Log = new JLabel("Body: " + Web_Pg_Body);
      c.gridy = 4;
      webConfirm.add(FTP_Log,c);
      JLabel FTP_Pass = new JLabel("Image: " + Web_Pg_Img);
      c.gridy = 5;
      webConfirm.add(FTP_Pass,c);
      
      return webConfirm;
    }
    
    public JPanel viewWebpages(){
        
        JPanel view = new JPanel();
        view.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 3;
        view.setMinimumSize(new Dimension(400,300));
        
        JLabel webView =  new JLabel("Webpage List");
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0,0,20,0);
        view.add(webView,c);
    
        c.insets = new Insets(0,0,0,0);
        try {
        Connection conn = null;
        Statement stmt = null;
      Class.forName("org.sqlite.JDBC");
      conn = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM webpage;" );
      while ( rs.next() ) {
         
         JLabel url = new JLabel("Title: " + rs.getString("Web_Pg_Title"));
         c.gridy += 1;
         view.add (url,c);
         JLabel ftpSite = new JLabel("Description: " + rs.getString("Web_Pg_Desc"));
         c.gridy += 1;
         view.add (ftpSite,c);
         JLabel webLaunch = new JLabel("Publish Date: " + rs.getString("Web_Pg_St_Date"));
         c.gridy +=1;
         view.add(webLaunch,c);
        
         JLabel spacer = new JLabel("--------------------------------");
         c.gridy += 1;
         view.add(spacer,c);
         
              }
      
      rs.close();
      stmt.close();
      conn.close();
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      
      
    }
        
        return view;
    }
    
    public JComboBox webpageSelector(){
        
        JComboBox webpages = new JComboBox();
        webpages.addItem("--Select Webpage--");
        try {
        Connection conn = null;
        Statement stmt = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
        System.out.println("Opened database successfully");
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery( "SELECT * FROM webpage;" );
         while ( rs.next() ) {
             
             webpages.addItem(rs.getString("Web_Pg_Title"));   
              }
      
      rs.close();
      stmt.close();
      conn.close();
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      
    }
        return webpages;
        
    }
    
}
