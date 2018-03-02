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
import java.awt.event.*;
/**
 *
 * @author Mountainside 19
 */
public class employee extends JPanel {
    
    int Emp_ID,Emp_Loc_ID;
        String Emp_First, Emp_Last, Emp_Add1, Emp_Add2, Emp_City, Emp_State, Emp_Zip;
        String Emp_Phone, Emp_Email, Emp_SS, Emp_Hire, Emp_Term,Emp_Vol;
    
    public void employee(){
        
       Emp_ID = 1;
       Emp_First = "John";
       Emp_Last = "Doe";
       Emp_Add1 = "";
       Emp_Add2 = "";
       Emp_City = "";
       Emp_State = "";
       Emp_Zip = "";
       Emp_Phone = "";
       Emp_Email = "";
       Emp_SS = "";
       Emp_Hire = "";
       Emp_Term = "";
       Emp_Vol = "";
       Emp_Loc_ID = 0;
        
}
    
    public void employee(String First,String Last,String Add1,String Add2,String City,
            String State,String Phone,String Email, String SS,String Vol, String Loc){
        
        Emp_First = First;
        Emp_Last = Last;
        Emp_Add1 = Add1;
        Emp_Add2 = Add2;
        Emp_City = City;
        Emp_State = State;
        Emp_Phone = Phone;
        Emp_Email = Email;
        Emp_SS = SS;
        Emp_Vol = Vol;
        //Emp_Loc_ID = Loc;
        
    }
    
    public JPanel employeeDetailView(){
        JPanel dV = new JPanel();
        dV.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.ipady = 3;
           
        JLabel empView =  new JLabel("Is the information correct?");
        c.gridx = 0;
        c.gridy = 0;
        dV.add(empView,c);
           
        JLabel empFNameVer = new JLabel("First Name: " + Emp_First);
        c.weightx = 2;
        c.gridx = 0;
        c.gridy = 1;
        dV.add(empFNameVer,c);
        
        JLabel empLNameVer = new JLabel("Last Name: " + Emp_Last);
        c.weightx = 2;
        c.gridx = 0;
        c.gridy = 2;
        dV.add(empLNameVer,c);
        
        JLabel empAdd1Ver = new JLabel("Address Line 1: " + Emp_Add1);
        c.weightx = 2;
        c.gridx = 0;
        c.gridy = 3;
        dV.add(empAdd1Ver,c);
        
        JLabel empAdd2Ver = new JLabel("Address Line 2: " + Emp_Add2);
        c.weightx = 2;
        c.gridx = 0;
        c.gridy = 4;
        dV.add(empAdd2Ver,c);
        
        JLabel empCityVer = new JLabel("City: " + Emp_City);
        c.weightx = 2;
        c.gridx = 0;
        c.gridy = 5;
        dV.add(empCityVer,c);
        
        JLabel empStateVer = new JLabel("State: " + Emp_State);
        c.weightx = 2;
        c.gridx = 0;
        c.gridy = 6;
        dV.add(empStateVer,c);
        
        JLabel empZipVer = new JLabel("Zip Code: " + Emp_Zip);
        c.weightx = 2;
        c.gridx = 0;
        c.gridy = 7;
        dV.add(empZipVer,c);
        
        JLabel empPhoneVer = new JLabel("Phone: " + Emp_Phone);
        c.weightx = 2;
        c.gridx = 0;
        c.gridy = 8;
        dV.add(empPhoneVer,c);
        
        JLabel empEmailVer = new JLabel("Email: " + Emp_Email);
        c.weightx = 2;
        c.gridx = 0;
        c.gridy = 9;
        dV.add(empEmailVer,c);
        
        JLabel empSSVer = new JLabel("Social Security: " + Emp_SS);
        c.weightx = 2;
        c.gridx = 0;
        c.gridy = 10;
        dV.add(empSSVer,c);
        
        JLabel empVolVer = new JLabel("Is Volunteer? " + Emp_Vol);
        c.weightx = 2;
        c.gridx = 0;
        c.gridy = 11;
        dV.add(empVolVer,c);
        
        
        
        JLabel empLocVer = new JLabel("Hired at location: " + Emp_Loc_ID);
        c.weightx = 2;
        c.gridx = 0;
        c.gridy = 12;
        dV.add(empLocVer,c);
        
        return dV;
        
    }
    
    public void verifyEmployeeTable(){
    
    try {
        Connection c = null;
        Statement stmt = null;
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM employee;" );
      while ( rs.next() ) {
         int id = rs.getInt("Emp_ID");
         System.out.println( "ID = " + id );
         System.out.println();
      }
      
      rs.close();
      stmt.close();
      c.close();
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      createEmployeeTable();
      
    }
    System.out.println("Employee Check Complete");
    
    } 
    
    public void createEmployeeTable(){
    String sql = "CREATE TABLE Employee(Emp_ID numeric Primary Key," 
            + "Emp_First varchar2(50),"
            + "Emp_Last varchar2(50),"
            + "Emp_Add1 varchar2(50),"
            + "Emp_Add2 varchar2(25),"
            + "Emp_City varchar2(35),"
            + "Emp_State varchar2(20),"
            + "Emp_Zip varchar2(10),"
            + "Emp_Phone varchar2(15),"
            + "Emp_Fax varchar2(15),"
            + "Emp_Email varchar2(40),"
            + "Emp_SS varchar2(15),"
            + "Emp_Hire Date default current_date,"
            + "Emp_Term Date default NULL,"
            + "Emp_Vol varchar2(15),"
            + "Emp_Loc_ID numeric);";
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
    
    public JScrollPane viewEmployeeTable(){
    
        JPanel dV = new JPanel();
        dV.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 3;
        //dV.setMinimumSize(new Dimension(400,400));
        JLabel empView =  new JLabel("Employee List");
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0,0,20,0);
        dV.add(empView,c);
    
        c.insets = new Insets(0,0,0,0);
        try {
        Connection conn = null;
        Statement stmt = null;
      Class.forName("org.sqlite.JDBC");
      conn = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM employee where Emp_Term Is Null;" );
      
      while ( rs.next() ) {
          
         int id = rs.getInt("Emp_ID");
         JLabel first = new JLabel("Name: " + rs.getString("Emp_First") + " " + rs.getString("Emp_Last"));
         c.gridy += 1;
         dV.add (first,c);
         JLabel address = new JLabel("Address: " + rs.getString("Emp_Add1") + " " + rs.getString("Emp_Add2"));
         c.gridy += 1;
         dV.add (address,c);
         JLabel cityStateZip = new JLabel("City/State/Zip: " + rs.getString("Emp_City") + ", " + 
                 rs.getString("Emp_State") + " " + rs.getString("Emp_Zip"));
         c.gridy +=1;
         dV.add(cityStateZip,c);
         
         JLabel contact = new JLabel("Phone: " + rs.getString("Emp_Phone") + " Email: " + rs.getString("Emp_Email"));
         c.gridy +=1;
         dV.add(contact,c);
         
         JLabel hire = new JLabel("Hire Date: " + rs.getString("Emp_Hire"));
         c.gridy += 1;
         dV.add(hire,c);
         
         
         JLabel spacer = new JLabel("--------------------------------");
         c.gridy += 1;
         dV.add(spacer,c);
        
              }
      
      
      rs.close();
      stmt.close();
      conn.close();
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      
      
    }
        
    JButton viewTerm = new JButton("Prior Employees");    
    c.gridy += 1;
    dV.add(viewTerm);
    
    viewTerm.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        dV.removeAll();
        
        viewPriorEmp termView = new viewPriorEmp();
        dV.add(termView);
        dV.validate();
        dV.repaint();
        
              }
    });
    
    JScrollPane scroll = new JScrollPane(dV);
    return scroll;
    } 
    
    public void insertEmployeeData(){
        
        int empID = getNextEmpId();
        String sql = ("Insert into employee values(" + empID + ",'" + Emp_First + 
                        "','" + Emp_Last + "','" + Emp_Add1 + "','" + Emp_Add2 +
                    "','" + Emp_City + "','" + Emp_State + "','" + Emp_Zip + "','" + 
                    Emp_Phone + "','" + Emp_Phone + "','" + Emp_Email + "','" + Emp_SS + "',current_date,NULL,'" + 
                    Emp_Vol + "','" + Emp_Loc_ID + "');");
    
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
    
    public int getNextEmpId(){
    
    
    Connection c = null;
    Statement stmt = null;
    int retEmpID;
    
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT MAX(Emp_ID) FROM employee;" );
      String EmpID = rs.getString("MAX(Emp_ID)");
      try{
      retEmpID = Integer.parseInt(EmpID);
      retEmpID += 1;
      }
      catch(Exception f){
          retEmpID = 1;
      }
      rs.close();
      stmt.close();
      c.close();
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.out.println("Did not get id");
      Random r = new Random();
          long t1 = System.currentTimeMillis() + r.nextInt();
          retEmpID = (int)t1;
      System.out.println("Employee ID Generated");
          
    }
    
    return retEmpID;
            
    } 
    
    public void termEmployee(){
        Connection c = null;
        Statement stmt = null;
        
            try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
                System.out.println("Opened database successfully");
                stmt = c.createStatement();
                System.out.println(Emp_First);
                String sql = ( "update employee set Emp_Term=current_date where" +
                                                " emp_id=" + Emp_ID + ";");
               System.out.println(sql);
                stmt.executeUpdate(sql);
               System.out.println("Employee Terminated"); 
             //rs.close();
             stmt.close();
             c.close();
              } 
            
            catch ( Exception e ) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                 System.out.println("What?");
                 }
          } 
    
    public void getEmpDates(){
    
    try {
        Connection c = null;
        Statement stmt = null;
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
        System.out.println("Opened database successfully");
        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery( "SELECT Emp_Hire,Emp_Term FROM employee;" );
      while ( rs.next() ) {
         //int id = rs.getInt("Emp_ID");
         String start = rs.getString("Emp_Hire");
         System.out.println( start );
         String term = rs.getString("Emp_Term");
         System.out.println( term );
         System.out.println();
      }
      
      rs.close();
      stmt.close();
      c.close();
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      
      
    }
    System.out.println("Date Check Complete");
    
    } 
    
    public void updEmpLoc(){
    
    try {
        Connection c = null;
        Statement stmt = null;
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
        System.out.println("Opened database successfully");
        stmt = c.createStatement();
        stmt.executeUpdate( "Update employee set Emp_Loc_ID=" + Emp_Loc_ID 
                                            + " where Emp_ID=" + Emp_ID + ";" );
           
      stmt.close();
      c.close();
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      
    }
    
    } 
    
    public JPanel editEmployee(){
        JPanel eF = new JPanel();
        eF.setLayout(new GridBagLayout());
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
                String sql = ( "select * from employee where Emp_id=" + Emp_ID +";");
                ResultSet rs = stmt.executeQuery(sql);
               while ( rs.next() ) {
                   Emp_ID = rs.getInt("Emp_ID");
                   Emp_First = rs.getString("Emp_First");
                   Emp_Last = rs.getString("Emp_Last");
                   Emp_Add1 = rs.getString("Emp_Add1");
                   Emp_Add2 = rs.getString("Emp_Add2");
                   Emp_City = rs.getString("Emp_City");
                   Emp_State = rs.getString("Emp_State");
                   Emp_Zip = rs.getString("Emp_Zip");
                   Emp_Phone = rs.getString("Emp_Phone");
                   Emp_Email = rs.getString("Emp_Email");
                   Emp_Vol = rs.getString("Emp_Vol");
                   Emp_Loc_ID = rs.getInt("Emp_Loc_ID");
         
                    rs.close();
                    
                    } 
               JLabel title = new JLabel("Edit Employee: #" + Emp_ID + " Name: " + Emp_First + " " + Emp_Last);
               c.weightx = 2;
               c.gridy = 0;
               eF.add(title,c);
               JLabel first = new JLabel("First Name");
               
               c.gridx = 0;
               c.gridy = 1;
               eF.add(first,c);
               JTextField First = new JTextField(Emp_First);
               c.insets = new Insets(0,0,0,25);
               c.gridx = 0;
               c.gridy = 2;
               eF.add(First,c);
               JLabel last = new JLabel("Last Name");
               c.insets = new Insets(0,0,0,0);
               c.gridx = 1;
               c.gridy = 1;
               eF.add(last,c);
               JTextField Last = new JTextField(Emp_Last);
               c.insets = new Insets(0,0,0,0);
               c.gridx = 1;
               c.gridy = 2;
               eF.add(Last,c);
               
               JLabel add1 = new JLabel("Address Line 1");
               c.insets = new Insets(0,0,0,25);
               c.gridx = 0;
               c.gridy = 3;
               eF.add(add1,c);
               JTextField Add1 = new JTextField(Emp_Add1);
               c.gridx = 0;
               c.gridy = 4;
               eF.add(Add1,c);
               JLabel add2 = new JLabel("Address Line 2");
               c.gridx = 1;
               c.gridy = 3;
               eF.add(add2,c);
               JTextField Add2 = new JTextField(Emp_Add2);
               c.gridx = 1;
               c.gridy = 4;
               eF.add(Add2,c);
               JLabel city = new JLabel("City");
               c.insets = new Insets(0,0,0,50);
               c.gridx = 0;
               c.gridy = 5;
               eF.add(city,c);
               JTextField City = new JTextField(Emp_City);
               c.gridx = 0;
               c.gridy = 6;
               eF.add(City,c);
               JLabel state = new JLabel("State");
               c.insets = new Insets(0,0,0,20);
               c.gridx = 1;
               c.gridy = 5;
               eF.add(state,c);
               
               stateMenu states = new stateMenu();
               
               JComboBox stateMenu = states.retStateMenu();
               stateMenu.setSelectedItem(Emp_State);
               c.gridx = 1;
               c.gridy = 6;
               eF.add(stateMenu,c);
               
               //JTextField State = new JTextField(Emp_State);
               
               JLabel zip = new JLabel("Zip Code");
               c.gridx = 2;
               c.gridy = 5;
               eF.add(zip,c);
               JTextField Zip = new JTextField(Emp_Zip);
               c.gridx = 2;
               c.gridy = 6;
               eF.add(Zip,c);
               JLabel phone = new JLabel("Phone");
               c.gridx = 0;
               c.gridy = 7;
               eF.add(phone,c);
               JTextField Phone = new JTextField(Emp_Phone);
               c.insets = new Insets(0,0,0,50);
               c.gridx = 0;
               c.gridy = 8;
               eF.add(Phone,c);
               JLabel email = new JLabel("Email");
               c.gridx = 1;
               c.gridy = 7;
               eF.add(email,c);
               JTextField Email = new JTextField(Emp_Email);
               c.gridx = 1;
               c.gridy = 8;
               eF.add(Email,c);
               JLabel vol = new JLabel("Volunteer?");
               
               c.gridx = 0;
               c.gridy = 9;
               eF.add(vol,c);
               JTextField Vol = new JTextField(Emp_Vol);
               c.insets = new Insets(0,0,0,60);
               c.gridx = 0;
               c.gridy = 10;
               eF.add(Vol,c);
               JLabel loc = new JLabel("Location");
               c.gridx = 1;
               c.gridy =9;
               eF.add(loc,c);
               
               location l = new location();
               int id = Emp_Loc_ID;
               l.retrSetLocData(id);
               
               locMenu location = new locMenu();
               JComboBox locMenu = location.locList();
               location.setSelectedLoc(id);
               
               
               c.gridx = 1;
               c.gridy = 10;
               eF.add(locMenu,c);
               
               JButton submit = new JButton("Save");
               c.gridx = 2;
               c.gridy = 13;
               eF.add(submit,c);
               
               submit.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        states.getState();
        location.getLocation();
        Emp_First = First.getText();  
        Emp_Last = Last.getText();
        Emp_Add1 = Add1.getText();
        Emp_Add2 = Add2.getText();
        Emp_City = City.getText();
        Emp_State = states.selectedState;
        Emp_Zip = Zip.getText();
        Emp_Phone = Phone.getText();
        Emp_Email = Email.getText();
        Emp_Vol = Vol.getText();
        Emp_Loc_ID = location.selectedID;

        Connection con = null;
        Statement stmt = null;
        
            try {
                Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
                System.out.println("Opened database successfully");
                stmt = con.createStatement();
        String sql = ( "update employee set Emp_First='" + Emp_First + "',Emp_Last='" +
                  Emp_Last + "',Emp_Add1='" + Emp_Add1 + "',Emp_Add2='" + Emp_Add2 + 
                  "',Emp_City='" + Emp_City + "',Emp_State='" + Emp_State +
                  "',Emp_Zip='" + Emp_Zip + "',Emp_Phone='" + Emp_Phone + 
                  "',Emp_Email='" + Emp_Email + "',Emp_Vol='" + Emp_Vol +
                  "',Emp_Loc_ID=" + Emp_Loc_ID + " where emp_id=" + Emp_ID + ";");
                                                
                stmt.executeUpdate(sql);    
                stmt.close();
                con.close();
                
                eF.removeAll();
                JLabel saved = new JLabel("Employee information has been updated");
                eF.add(saved);
                eF.validate();
                eF.repaint();
                
                }
            catch ( Exception f ) {
                //System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                 System.out.println("Not Updated");
                 }
      }
      });
          
            }
            catch ( Exception e ) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                 System.out.println("What?");
                 }
            return eF;
          } 
    
    public int getCountEmp(){
        int empCount = 0;
        Connection c = null;
        Statement stmt = null;
        
        
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      
      
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT COUNT(Emp_ID)FROM employee where Emp_Term is Null;" );
      while ( rs.next() ) {
         empCount = rs.getInt("COUNT(Emp_ID)");
      }
      rs.close();
      stmt.close();
      c.close();
          
    }
      catch ( ClassNotFoundException | SQLException e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      //System.exit(0);
    }
    return empCount;
    }
}
