/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package npman;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;


/**
 *
 * @author Martin Zarnock
 */
public class publishWebpage {
    
    public publishWebpage(){
    
        try{
            PrintWriter writer = new PrintWriter(System.getProperty("user.home") + "/NPMWare/test.html", "UTF-8");
            
            writer.println("<html>");
            writer.println("</html>");
            System.out.println("Constructor for Publish Webpage");
            writer.close();
            }
        catch(IOException e1){
                    //e1.printStackTrace();
            }
    
    
    
}
    
    public void publishWebpage(website a){
    website toPublish = a;
    String folder;
    String delims = "[.]+";
                String[] tokens = toPublish.Web_URL.split(delims);
                System.out.println(tokens[0]);
                if(tokens[0].equalsIgnoreCase("www")){
                folder = (System.getProperty("user.home") + "/NPMWare/websites/" + tokens[1] + "/");
                System.out.println(folder);
                                   }
                else{
                folder = (System.getProperty("user.home") + "/NPMWare/websites/" + tokens[0] + "/");
                 System.out.println(folder);
                 
                }    
    webPage toCreate = new webPage();
     Connection c = null;
     Statement stmt = null;
     Statement stmt2 = null;
     Statement stmt3 = null;
     Statement stmt4 = null;
      try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      stmt = c.createStatement();
      stmt2 = c.createStatement();
      stmt3 = c.createStatement();
      stmt4 = c.createStatement();
      String topnav = "";
      ///build topnav
      ResultSet rs2 = stmt2.executeQuery("SELECT * from webpage where Web_ID="+toPublish.Web_ID + ";");
      
      while (rs2.next()){
          if(rs2.getInt("Web_Pg_Parent")==0){
              topnav = (topnav + "<li>");
              delims = "[ ]+";
              tokens = rs2.getString("Web_Pg_Title").split(delims);
              String filename ="";
                for (int i=0;i<tokens.length;i++){
                filename = (tokens[i] + "_");
                }
                 filename = (filename + ".html");
              topnav = (topnav + "<a href=\""+ filename + "\">" + rs2.getString("Web_Pg_Title") + "</a>");
              System.out.println(topnav);
              ResultSet rs3 = stmt3.executeQuery("Select Web_Pg_ID,Web_Pg_Title from webpage where Web_Pg_Parent=" +
                                                        rs2.getInt("Web_Pg_ID") + ";");
              
                  
              topnav = (topnav + "<ul>");
              while(rs3.next()){
                  topnav = (topnav + "<li>");
                  delims = "[ ]+";
              tokens = rs3.getString("Web_Pg_Title").split(delims);
               filename ="";
                for (int j=0;j<tokens.length;j++){
                filename = (tokens[j] + "_");
                }
                 filename = (filename + ".html");
              topnav = (topnav + "<a href=\""+ filename + "\">" + rs3.getString("Web_Pg_Title") + "</a>");
              System.out.println(topnav);
              ResultSet rs4 = stmt4.executeQuery("Select Web_Pg_Title from webpage where Web_Pg_Parent=" 
                      + rs3.getInt("Web_Pg_ID")+ ";" );
              
             topnav = (topnav + "<ul>");
              while(rs4.next()){
                  topnav = (topnav + "<li>");
                  System.out.println("Result Set 4: " + rs4.getString("Web_Pg_Title"));
                  delims = "[ ]+";
              tokens = rs4.getString("Web_Pg_Title").split(delims);
               filename ="";
                for (int k=0;k<tokens.length;k++){
                filename = (tokens[k] + "_");
                }
                 filename = (filename + ".html");
              topnav = (topnav + "<a href=\""+ filename + "\">" + rs4.getString("Web_Pg_Title") + "</a>");
              System.out.println(topnav);
              topnav = (topnav + "</li>");
              }
              topnav = (topnav + "</ul>");
              topnav = (topnav + "</li>");
              }
              topnav = (topnav + "</ul>");
             
          }
          topnav = (topnav + "</li>");
      }
      
     topnav = topnav.replace("<ul></ul>","");
      
      ResultSet rs = stmt.executeQuery( "SELECT * from webpage where Web_ID="+toPublish.Web_ID + ";" );
      while(rs.next()){
          toCreate.Web_Pg_Title = rs.getString("Web_Pg_Title");
          toCreate.Web_Pg_Desc = rs.getString("Web_Pg_Desc");
          toCreate.Web_Pg_Body = rs.getString("Web_Pg_Body");
          toCreate.Web_Pg_Img = rs.getString("Web_Pg_Img");
          delims = "[ ]+";
          tokens = toCreate.Web_Pg_Title.split(delims);
          String filename ="";
          for (int i=0;i<tokens.length;i++){
              filename = (tokens[i] + "_");
          }
          filename = filename + ".html";
          try{
            PrintWriter writer = new PrintWriter(folder + filename, "UTF-8");
            writer.println("<!DOCTYPE HTML><html><head><title>" + toCreate.Web_Pg_Title + "</title><meta charset=\"utf-8\">");
            writer.println("<link href=\"http://fonts.googleapis.com/css?family=Open+Sans:400,300,700,800\" rel=\"stylesheet\" type=\"text/css\">");
            writer.println("<script src=\"js/jquery-1.8.3.min.js\"></script>");
            writer.println("<script src=\"css/5grid/init.js?use=mobile,desktop,1000px&amp;mobileUI=1&amp;mobileUI.theme=none\"></script>");
            writer.println("<script src=\"js/jquery.dropotron-1.2.js\"></script>");
            writer.println("<script src=\"js/init.js\"></script><noscript><link rel=\"stylesheet\" href=\"css/5grid/core.css\">");
            writer.println("<link rel=\"stylesheet\" href=\"css/5grid/core-desktop.css\"><link rel=\"stylesheet\" href=\"css/5grid/core-1200px.css\">");
            writer.println("<link rel=\"stylesheet\" href=\"css/5grid/core-noscript.css\"><link rel=\"stylesheet\" href=\"css/style.css\">");
            writer.println("<link rel=\"stylesheet\" href=\"css/style-desktop.css\"></noscript>");
            writer.println("<!--[if lte IE 9]><link rel=\"stylesheet\" href=\"css/ie9.css\"><![endif]--><!--[if lte IE 8]>");
            writer.println("<link rel=\"stylesheet\" href=\"css/ie8.css\"><![endif]--><!--[if lte IE 7]>");
            writer.println("<link rel=\"stylesheet\" href=\"css/ie7.css\"><![endif]-->");
            writer.println("</head><body class=\"no-sidebar\"><div id=\"header-wrapper\"><div class=\"5grid-layout\">");
            writer.println("<div class=\"row\"><div class=\"12u\"><header id=\"header\"><div class=\"inner\">");
            writer.println("<h1><a href=\"index.html\" class=\"mobileUI-site-name\">"+ toPublish.Web_URL + "</a></h1>");
            writer.println("<nav id=\"nav\" class=\"mobileUI-site-nav\"><ul>");
            writer.println(topnav);
            writer.println("</ul></nav></div></header></div></div></div></div><div id=\"main-wrapper\">");
            writer.println("<div class=\"main-wrapper-style2\"><div class=\"inner\"><div class=\"5grid-layout\">");
            writer.println("<div class=\"row\"><div class=\"12u mobileUI-main-content\"><div id=\"content\">");
            writer.println("<article><header class=\"major\"><h2>"+ toCreate.Web_Pg_Title+
                            " </h2><span class=\"byline\">" + toCreate.Web_Pg_Desc + " </span>");
            writer.println("</header><p>" + toCreate.Web_Pg_Body +"</p></article></div></div></div></div></div></div>");
            writer.println("<div class=\"main-wrapper-style3\"><div class=\"inner\"><div class=\"5grid-layout\">");
            writer.println("</div></div></div></div><div id=\"footer-wrapper\">");
            writer.println("<footer id=\"footer\" class=\"5grid-layout\"><div class=\"row\"><div class=\"3u\"><section>");
            writer.println("<h2>Filler Links</h2><ul class=\"style2\">");
            writer.println("<li><a href=\"#\">Quam turpis feugiat sit dolor</a></li>");
            writer.println("</ul></section></div><div class=\"3u\"></div><div class=\"6u\"><section>");
            writer.println("<h2>Get in touch</h2><div class=\"5grid\"><div class=\"row\"><div class=\"6u\">");
            writer.println("<dl class=\"contact\"><h2>Contact Us</h2><dt>Twitter</dt><dd><a href=\"#\">@n33co</a></dd>");
            writer.println("<dt>Facebook</dt><dd><a href=\"#\">dribbble.com/n33</a></dd><dt>Email</dt>");
            writer.println("<dd><a href=\"#\">aj -at- n33.co</a></dd></dl></div><div class=\"6u\">");
            writer.println("<dl class=\"contact\"><dt>Snail Mail</dt><dd> 1234 Fictional Road<br>");
            writer.println("Nashville, TN 00000-0000<br>USA </dd><dt>Phone</dt><dd>(000) 000-0000</dd>");
            writer.println("</dl></div></div></div></section></div></div><div class=\"row\"><div class=\"12u\">");
            writer.println("<div id=\"copyright\"> &copy; Untitled. All rights reserved </div>");
            writer.println("</div></div></footer></div></body></html>");
            
            
            writer.close();
            }
        catch(IOException e1){
                    //e1.printStackTrace();
            }
          
      }
      rs.close();
      stmt.close();
      stmt2.close();
      stmt3.close();
      stmt4.close();
      c.close();
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                     
    }
    
        
    
    
    
}
    
   public void copyTemplate(File sourceLocation , File targetLocation)
 throws IOException {
      
     if (sourceLocation.isDirectory()) {
         if (!targetLocation.exists()) {
             targetLocation.mkdir();
         }
          
         String[] children = sourceLocation.list();
         for (int i=0; i<children.length; i++) {
             copyTemplate(new File(sourceLocation, children[i]),
                     new File(targetLocation, children[i]));
         }
     } else {
          
         InputStream in = new FileInputStream(sourceLocation);
         OutputStream out = new FileOutputStream(targetLocation);
          
         // Copy the bits from instream to outstream
         byte[] buf = new byte[1024];
         int len;
         while ((len = in.read(buf)) > 0) {
             out.write(buf, 0, len);
         }
         in.close();
         out.close();
     }
 }
    
    
}
