/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package npman;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author brc
 */
public class website {
    
    public int Web_ID,Web_Loc_ID;
    public String Web_URL,Web_FTP_URL,Web_FTP_Log,Web_FTP_Pass;
    public String Web_Start_Date,Web_End_Date,Web_Track_Code,Web_Logo;
    public File target;
    
    public void website(){
        Web_ID = 0;
        Web_Loc_ID = 0;
        Web_URL = "";
        Web_FTP_URL = "";
        Web_FTP_Log = "";
        Web_FTP_Pass = "";
        Web_Start_Date = "";
        Web_End_Date = "";
        Web_Track_Code = "";
        Web_Logo = "";
    }
    
    public void verifyWebTable(){
        Connection c = null;
        Statement stmt = null;
        try {
        
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM website;" );
      while ( rs.next() ) {
         int id = rs.getInt("Web_ID");
         System.out.println( "ID = " + id );
         System.out.println();
      }
      System.out.println("Website Table Verified");
      rs.close();
      stmt.close();
      c.close();
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      createWebTable();
      System.out.println("Website Table Being Created");
      
    }
    
    } 
    
    public void createWebTable(){
        
       String sql = "CREATE TABLE website(Web_ID numeric Primary Key," 
            + "Web_URL varchar2(50),"
            + "Web_Loc_ID numeric,"
            + "Web_FTP_URL varchar2(50),"
            + "Web_FTP_Log varchar2(25),"
            + "Web_FTP_Pass varchar2(35),"
            + "Web_Start_Date Date default current_date,"
            + "Web_End_Date Date default NULL,"
            + "Web_Track_Code varchar2(150));";
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
    
    public void insertWebData() throws IOException{
        
        int webID = getNextWebID();
        Web_ID = webID;
        String sql = ("Insert into website values(" + Web_ID + ",'" + Web_URL + 
                        "'," + Web_Loc_ID + ",'" + Web_FTP_URL + "','" + Web_FTP_Log +
                    "','" + Web_FTP_Pass + "',current_date,NULL,'" + 
                    Web_Track_Code + "');");
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
      System.out.println("Website Record created successfully");
      
      publishWebpage addTemp = new publishWebpage();
      
      String delims = "[.]+";
                String[] tokens = Web_URL.split(delims);
                System.out.println(tokens[0]);
                if(tokens[0].equalsIgnoreCase("www")){
                target = new File(System.getProperty("user.home") + "/NPMWare/websites/" + tokens[1]);
                
                   }
                else{
                target = new File(System.getProperty("user.home") + "/NPMWare/websites/" + tokens[0]);
                 
                 
                }    
      File source = new File("./templates/04/");
      
      
      addTemp.copyTemplate(source, target);
      
      //File dir = new File()
      
    }
      catch ( ClassNotFoundException | SQLException e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.out.println("Website Record not created ");
      
      //System.exit(0);
    }
    
    }
    
    public int getNextWebID(){
    Connection c = null;
    Statement stmt = null;
    int retWebID;
    
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT MAX(Web_ID) FROM website;" );
      String EmpID = rs.getString("MAX(Web_ID)");
      try{
      retWebID = Integer.parseInt(EmpID);
      retWebID += 1;
      }
      catch(Exception f){
          retWebID = 1;
      }
      rs.close();
      stmt.close();
      c.close();
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.out.println("Did not get id");
      Random r = new Random();
          long t1 = System.currentTimeMillis() + r.nextInt();
          retWebID = (int)t1;
      System.out.println("Website ID Generated");
          
    }
    
    return retWebID;
            
    } 
    
    public JPanel webConfirmPanel() throws IOException{
        
      JPanel webConfirm = new JPanel();
      webConfirm.setLayout(new GridBagLayout());
      GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 3;
        webConfirm.setMinimumSize(new Dimension(400,300));
      JLabel title = new JLabel("Is the following information correct?");
      c.gridy = 1;
      webConfirm.add(title,c);
      
      JLabel URL = new JLabel("URL: " + Web_URL);
      c.gridy = 2;
      webConfirm.add(URL,c);
      JLabel FTP_URL = new JLabel("FTP URL: " + Web_FTP_URL);
      c.gridy = 3;
      webConfirm.add(FTP_URL,c);
      JLabel FTP_Log = new JLabel("FTP User: " + Web_FTP_Log);
      c.gridy = 4;
      webConfirm.add(FTP_Log,c);
      JLabel FTP_Pass = new JLabel("FTP Pass: " + Web_FTP_Pass);
      c.gridy = 5;
      webConfirm.add(FTP_Pass,c);
      JLabel Track = new JLabel("Tracking Code: " + Web_Track_Code);
      c.gridy = 6;
      webConfirm.add(Track,c);
      JLabel Logo  = new JLabel("Website Logo: " + Web_Logo);
      c.gridy = 7;
      webConfirm.add(Logo,c);
      
      
      
      try {
          BufferedImage myPicture = ImageIO.read(new File(Web_Logo));
       
      JLabel logoView = new JLabel(new ImageIcon(myPicture));
      logoView.setPreferredSize(new Dimension(150,150));
      c.gridx = 2;
      c.gridy = 7;
      webConfirm.add(logoView,c);
      }
      catch(IOException i ) {
          
          JLabel logoView = new JLabel("Could not retrieve image");
            c.gridx = 2;
            c.gridy = 7;
            webConfirm.add(logoView,c);
      }
      return webConfirm;
    }
    
    public JPanel viewWebsites(){
        
        JPanel view = new JPanel();
        view.setLayout(new GridBagLayout());
      GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 3;
        view.setMinimumSize(new Dimension(400,300));
        
        JLabel webView =  new JLabel("Website List");
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0,0,20,0);
        view.add(webView,c);
        Connection conn = null;
        Statement stmt = null;
        c.insets = new Insets(0,0,0,0);
        try {
        
      Class.forName("org.sqlite.JDBC");
      conn = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      stmt = conn.createStatement();
      Statement stmt2 = conn.createStatement();
      Statement stmt3 = conn.createStatement();
      Statement stmt4 = conn.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT Web_ID,Web_URL from website;" );
      while ( rs.next() ) {
            int id = rs.getInt("Web_ID");
            JLabel url = new JLabel(rs.getString("Web_URL"));
            c.gridy += 1;
            view.add (url,c);
            
            
             
            ResultSet rs2 = stmt2.executeQuery("Select Web_Pg_ID,Web_Pg_Title,Web_Pg_Parent from webpage where Web_ID=" + id + ";");
             while ( rs2.next() ) {
                 
                 
                 if(rs2.getInt("Web_Pg_Parent")==0){
                     JLabel page = new JLabel(rs2.getString("Web_Pg_Title"));
                     c.gridy += 1;
                    view.add (page,c);
                    
                    ResultSet rs3 = stmt3.executeQuery("Select Web_Pg_ID,Web_Pg_Title from webpage where Web_Pg_Parent=" +
                                                        rs2.getInt("Web_Pg_ID") + ";");
                    while(rs3.next()){
                        JLabel subpage = new JLabel("  - " + rs3.getString("Web_Pg_Title"));
                     c.gridy += 1;
                    view.add (subpage,c);
                        
                    ResultSet rs4 = stmt4.executeQuery("Select Web_Pg_Title from webpage where Web_Pg_Parent=" +
                                                    rs3.getInt("Web_Pg_ID") + ";");
                    
                    while (rs4.next()){
                        
                        JLabel subpage2 = new JLabel("    - " + rs4.getString("Web_Pg_Title"));
                     c.gridy += 1;
                    view.add (subpage2,c);
                        System.out.println("    - " + rs3.getString("Web_Pg_Title"));
                    }
                    }
                 }
      
                 
                
             }
         
             JButton manage = new JButton("Manage " + rs.getString("Web_URL"));
             c.gridy +=1;
             c.gridx = 1;
             view.add(manage,c);
        manage.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        view.removeAll();
        String bT = manage.getText();
        String delims = "[ ]+";
        String[] tokens = bT.split(delims);
        website toMan = new website();
        toMan.Web_URL = tokens[1];
        System.out.println(toMan.Web_URL);
        JPanel management = new JPanel();
        management = toMan.manageWeb();
        view.add(management);
       
              
        view.validate();
        view.repaint();
        
              }
    });
         c.gridx = 0;
              }
      
      rs.close();
      stmt.close();
      conn.close();
      
      
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      
      
    }
        
        return view;
    }
    
    public JComboBox websiteSelector(){
        
        JComboBox websites = new JComboBox();
        websites.addItem("--Select Website--");
        try {
        Connection conn = null;
        Statement stmt = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
        System.out.println("Opened database successfully");
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery( "SELECT * FROM website;" );
         while ( rs.next() ) {
             
             websites.addItem(rs.getString("Web_URL"));   
              }
      
      rs.close();
      stmt.close();
      conn.close();
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      
    }
        return websites;
        
    }
    
    public void getSetWebsite(){
        
        Connection c = null;
        Statement stmt = null;
        try {
        
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      stmt = c.createStatement();
      
      ResultSet rs = stmt.executeQuery( "SELECT * FROM website where Web_ID=" + Web_ID +";" );
      while ( rs.next() ) {
          Web_URL = rs.getString("Web_URL");
         Web_Loc_ID = rs.getInt("Web_Loc_ID");
      }
      
      rs.close();
      stmt.close();
      c.close();
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      
      
    }
        
    }
    
    public JPanel manageWeb(){
        
        JPanel man = new JPanel();
        man.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 3;
        Connection con = null;
        Statement stmt = null;
        
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
            System.out.println("Opened database successfully");
            stmt = con.createStatement();
            website a = new website();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM website where Web_URL='" + Web_URL + "';" );
        while ( rs.next() ) {
            a.Web_ID = rs.getInt("Web_ID");
            
            JButton publish = new JButton("Publish");
            man.add(publish);
            publish.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                        
                
                    a.getSetWebsite();
                
                publishWebpage b = new publishWebpage();
                b.publishWebpage(a);
              
        
              }
    });
        }
      
        rs.close();
        stmt.close();
         con.close();
      
        } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          }
        return man;
    }
    
}
