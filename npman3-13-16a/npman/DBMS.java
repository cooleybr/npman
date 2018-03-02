/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package npman;
import java.sql.*;
/**
 *
 * @author brc
 */
public class DBMS {
    
    
    public void OpenDB(){
    Connection c = null;
    Statement stmt = null;
    try {
        //open sqllite db connection
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
        c.setAutoCommit(false);
        
        c.close();
        }
        catch ( Exception e ) {
        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        //System.exit(0);
        }
    }
    
    public void createTableDB(String tableDef){
    String tab = tableDef;
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      

      stmt = c.createStatement();
      String sql = tab; 
      stmt.executeUpdate(sql);
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      //System.exit(0);
    }
    
    }
    
    public void InsertStatesDB(){
        Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      c.setAutoCommit(false);
      
      
      stmt = c.createStatement();
      String sql = "INSERT INTO States Values(1,'Alabama');";
      stmt.executeUpdate(sql);
      
      sql = "INSERT INTO States Values(2,'Alaska');";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO States Values(3,'Arizona');";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO States Values(4,'Arkansas');";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO States Values(5,'California');";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO States Values(6,'Colorado');";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO States Values(7,'Connecticut');";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO States Values(8,'Delaware');";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO States Values(9,'Florida');";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO States Values(10,'Georgia');";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO States Values(11,'Hawaii');";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO States Values(12,'Idaho');";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO States Values(13,'Illinois');";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO States Values(14,'Indiana');";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO States Values(15,'Iowa');";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO States Values(16,'Kansas');";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO States Values(17,'Kentucky');";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO States Values(18,'Louisiana');";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO States Values(19,'Maine');";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO States Values(20,'Maryland');";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO States Values(21,'Massachusetts');";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO States Values(22,'Michigan');";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO States Values(23,'Minnesota');";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO States Values(24,'Mississippi');";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO States Values(25,'Missouri');";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO States Values(26,'Montana');";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO States Values(27,'Nebraska');";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO States Values(28,'Nevada');";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO States Values(29,'New Hampshire');";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO States Values(30,'New Jersey');";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO States Values(31,'New Mexico');";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO States Values(32,'New York');";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO States Values(33,'North Carolina');";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO States Values(34,'North Dakota');";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO States Values(35,'Ohio');";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO States Values(36,'Oklahoma');";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO States Values(37,'Oregon');";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO States Values(38,'Pennsylvania');";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO States Values(39,'Rhode Island');";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO States Values(40,'South Carolina');";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO States Values(41,'South Dakota');";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO States Values(42,'Tennessee');";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO States Values(43,'Texas');";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO States Values(44,'Utah');";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO States Values(45,'Vermont');";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO States Values(46,'Virginia');";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO States Values(47,'Washington');";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO States Values(48,'West Virginia');";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO States Values(49,'Wisconsin');";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO States Values(50,'Wyoming');";
      stmt.executeUpdate(sql);
      
      stmt.close();
      c.commit();
      c.close();
    } catch ( ClassNotFoundException | SQLException e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      //System.exit(0);
    }
    System.out.println("Records created successfully");
    }
    
    public void InsertDB(){
        //create insert statements
    }
    public void UpdateDB(){
        //create update statements
    }
    public void DeleteDB(){
    }
    public void CloseDB(){
        
    }
    
    public void verifyStates(){
    
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM States;" );
      while ( rs.next() ) {
         int id = rs.getInt("State_ID");
         String  name = rs.getString("State");
         System.out.println( "ID = " + id );
         System.out.println( "NAME = " + name );
         System.out.println();
      }
      rs.close();;
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      //System.exit(0);
    }
    System.out.println("Rows of States Table Printed");
    } 
    
    
    
}
