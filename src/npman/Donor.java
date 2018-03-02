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
public class Donor extends JPanel{
    
    public static String donorCompany,donorFirstName,donorLastName;
    public static String donorAdd1,donorAdd2,donorCity,donorState,donorZip;
    public static String donorPhone,donorFax,donorEmail,donorReferSrc,donorMarket;
    public static String donorAddDate,donorLastDate,donationMethod;
    public double donation;
    public int donID;
    public String accMark;
    
    //Constructor for example donor
    public void Donor(){
        donID = 1;
        donorCompany = "";
        donorFirstName = "";
        donorLastName = "";
        donorAdd1 = "";
        donorAdd2 = "";
        donorCity = "";
        donorState = "";
        donorZip = "";
        donorPhone = "";
        donorFax = "";
        donorEmail = "";
        donorReferSrc = "";
        donorAddDate = "";
        donorLastDate = "";
        donationMethod = "";
        donation = 0.00;
        donorMarket = "yes";
    }
    //Form Constructor - builds donor from input fields
    public void Donor(String Company,String First, String Last, String Add1,String Add2, String City,
                        String State, String Zip, String Phone, String Fax, String Email, String Refer){
        donorCompany = Company;
        donorFirstName = First;
        donorLastName = Last;
        donorAdd1 = Add1;
        donorAdd2 = Add2;
        donorCity = City;
        donorState = State;
        donorZip = Zip;
        donorPhone = Phone;
        donorFax = Fax;
        donorEmail = Email;
        donorReferSrc = Refer;
        
    }
    
    //Provide Donor Form
    public JPanel donorDetailView(){
        JPanel dV = new JPanel();
        dV.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.ipady = 3;
           
        JLabel donorVer =  new JLabel("Is the information correct?");
        c.gridx = 0;
        c.gridy = 0;
        dV.add(donorVer,c);
           
        JLabel donorFNameVer = new JLabel(donorFirstName);
        c.weightx = 2;
        c.gridx = 0;
        c.gridy = 1;
        dV.add(donorFNameVer,c);
        
        JLabel donorLNameVer = new JLabel(donorLastName);
        c.weightx = 2;
        c.gridx = 0;
        c.gridy = 2;
        dV.add(donorLNameVer,c);
        
        JLabel donorAdd1Ver = new JLabel(donorAdd1);
        c.weightx = 2;
        c.gridx = 0;
        c.gridy = 3;
        dV.add(donorAdd1Ver,c);
        
        JLabel donorAdd2Ver = new JLabel(donorAdd2);
        c.weightx = 2;
        c.gridx = 0;
        c.gridy = 4;
        dV.add(donorAdd2Ver,c);
        
        JLabel donorCityVer = new JLabel(donorCity);
        c.weightx = 2;
        c.gridx = 0;
        c.gridy = 5;
        dV.add(donorCityVer,c);
        
        JLabel donorStateVer = new JLabel(donorState);
        c.weightx = 2;
        c.gridx = 0;
        c.gridy = 6;
        dV.add(donorStateVer,c);
        
        JLabel donorZipVer = new JLabel(donorZip);
        c.weightx = 2;
        c.gridx = 0;
        c.gridy = 7;
        dV.add(donorZipVer,c);
        
        JLabel donorPhoneVer = new JLabel(donorPhone);
        c.weightx = 2;
        c.gridx = 0;
        c.gridy = 8;
        dV.add(donorPhoneVer,c);
        
        JLabel donorEmailVer = new JLabel(donorEmail);
        c.weightx = 2;
        c.gridx = 0;
        c.gridy = 9;
        dV.add(donorEmailVer,c);
        
        JLabel donorMarketVer= new JLabel(donorMarket);
        c.gridx = 0;
        c.gridy = 10;
        dV.add(donorMarketVer,c);
        
        return dV;
    }
       
    public void verifyDonorTable(){
    Connection c = null;
        Statement stmt = null;
    try {
        
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      
      stmt = c.createStatement();
      
      ResultSet rs = stmt.executeQuery( "SELECT * FROM donor;" );
      while ( rs.next() ) {
         int id = rs.getInt("don_ID");
         System.out.println( "ID = " + id );
         System.out.println();
      }
      
      rs.close();
      stmt.close();
      c.close();
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      createDonorTable();
      
    }
    System.out.println("Donor Check Complete");
    
    } 
    
    public void createDonorTable(){
    String sql = "CREATE TABLE Donor(Don_ID numeric Primary Key," 
            + "DonorCompanyName varchar2(50),"
            + "DonorFirstName varchar2(50),"
            + "DonorLastName varchar2(50),"
            + "DonorAdd1 varchar2(50),"
            + "DonorAdd2 varchar2(25),"
            + "DonorCity varchar2(35),"
            + "DonorState varchar2(20),"
            + "DonorZip varchar2(10),"
            + "DonorPhone varchar2(15),"
            + "DonorFax varchar2(15),"
            + "DonorEmail varchar2(40),"
            + "DonorReferSrc varchar2(15),"
            + "DonorAddDate Date default current_date,"
            + "DonorLastDate Date default NULL," 
            + "DonorMarket varchar2(5) default 'yes');";
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
    
        
    public void insertDonorData(){
        
        int donID = getNextDonorId();
        String sql = ("Insert into donor values(" + donID + ",'" + donorCompany + 
                        "','" + donorFirstName + "','" + donorLastName + "','" + donorAdd1 +
                    "','" + donorAdd2 + "','" + donorCity + "','" + donorState + "','" + 
                    donorZip + "','" + donorPhone + "','" + donorFax + "','" + donorEmail + "','" +
                    donorReferSrc + "','" + donorAddDate + "',NULL,'" + donorMarket +"');");
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
      if (donation > 0.00){
          donation a = new donation();
          a.Dona_Amt = donation;
          a.Don_ID = donID;
          a.Dona_Ref_Src = donorReferSrc;
          a.Dona_Method = donationMethod;
          a.insertDonationData();
          
      }
      
      
    }
      catch ( ClassNotFoundException | SQLException e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.out.println("Record not created ");
      
      //System.exit(0);
    }
    
    }
    
    public int getNextDonorId(){
    
    
    Connection c = null;
    Statement stmt = null;
    int retDonorID;
    
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT MAX(Don_ID) FROM donor;" );
      String donID = rs.getString("MAX(Don_ID)");
      try{
      retDonorID = Integer.parseInt(donID);
      retDonorID += 1;
      }
      catch(Exception f){
          retDonorID = 1;
      }
      rs.close();
      stmt.close();
      c.close();
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.out.println("Did not get donor id");
      Random r = new Random();
          long t1 = System.currentTimeMillis() + r.nextInt();
          retDonorID = (int)t1;
      System.out.println("Donor ID Generated");
          
    }
    
    return retDonorID;
            
    } 
    
    public ArrayList viewDonorData(){
        Connection c = null;
        Statement stmt = null;
        ArrayList donorListing = new ArrayList();   
        
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM donor;" );
      while ( rs.next() ) {
         String Company = rs.getString("DonorCompanyName");
         String FName = rs.getString("DonorFirstName");
         String LName = rs.getString("DonorLastName");
         String Add1 = rs.getString("DonorAdd1");
         String Add2 = rs.getString("DonorAdd2");
         String City = rs.getString("DonorCity");
         String State = rs.getString("DonorState");
         String Zip = rs.getString("DonorZip");
         String Phone = rs.getString("DonorPhone");
         String Fax = rs.getString("DonorFax");
         String Email = rs.getString("DonorEmail");
         String Refer = rs.getString("DonorReferSrc");
         String Add = rs.getString("DonorAddDate");
         String Last = rs.getString("DonorLastDate");
         String Market = rs.getString("DonorMarket");
         
         String location = (Company + "\n" + FName + " " + LName + "\n" + Add1 + " " + Add2 + "\n" +
                            City + ", " + State + " " + Zip + "\nPhone: " + Phone + " Fax: " + Fax +
                            "\nEmail: " + Email + "\nReferred By: " + Refer + "\nDate Added: " + Add +
                            " Last Donation: " + Last + " Accepts Marketing: " + Market);
         System.out.println(location);
         donorListing.add(location);
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
    return(donorListing);
    
    }
    
   
    public void getSetDonorData(){
        Connection c = null;
        Statement stmt = null;
        
        
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM donor where Don_ID=" + donID + ";" );
      while ( rs.next() ) {
         donorCompany = rs.getString("DonorCompanyName");
         donorFirstName = rs.getString("DonorFirstName");
         donorLastName = rs.getString("DonorLastName");
         donorAdd1 = rs.getString("DonorAdd1");
         donorAdd2 = rs.getString("DonorAdd2");
         donorCity = rs.getString("DonorCity");
         donorState = rs.getString("DonorState");
         donorZip = rs.getString("DonorZip");
         donorPhone = rs.getString("DonorPhone");
         donorFax = rs.getString("DonorFax");
         donorEmail = rs.getString("DonorEmail");
         donorReferSrc = rs.getString("DonorReferSrc");
         donorAddDate = rs.getString("DonorAddDate");
         donorLastDate = rs.getString("DonorLastDate");
         donorMarket = rs.getString("DonorMarket");
         
         
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
    
    public JComboBox donorBox(){
        
        JComboBox donorList = new JComboBox();
        donorList.addItem("Add New Donor");
        
        
        try {
        Connection c = null;
        Statement stmt = null;
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM donor;" );
      while ( rs.next() ) {
         donorList.addItem(rs.getInt("don_ID") + " " + rs.getString("DonorFirstName") + " " 
                 + rs.getString("DonorLastName"));
      }
      
      rs.close();
      stmt.close();
      c.close();
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      
      
    }
    
    return donorList;
    }
    
    
    public JPanel donationForm2() {
        JPanel df2 = new JPanel();
        df2.setLayout(new GridBagLayout());
        //df2.setMinimumSize(new Dimension(800,400));
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.ipady = 3;
        //setLayout (new BoxLayout(this, BoxLayout.Y_AXIS));
        //setLayout(new BorderLayout());
           
        
        JLabel donorFormLabel = new JLabel("Add Donation");
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0,100,25,0);
        df2.add(donorFormLabel,c);
        
        c.insets = new Insets(0,0,0,0);
        
        JLabel donorFNameLabel = new JLabel("First Name");
        c.gridx = 0;
        c.gridy = 1;
        df2.add(donorFNameLabel,c);
        
        JTextField donorFName = new JTextField(donorFirstName);
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(0,0,0,50);
        df2.add(donorFName,c);
                
        c.insets = new Insets(0,0,0,0);   
        
        JLabel donorLNameLabel = new JLabel("Last Name");
        c.gridx = 1;
        c.gridy = 1;
        df2.add(donorLNameLabel,c);
        
        JTextField donorLName = new JTextField(donorLastName);
        c.gridx = 1;
        c.gridy = 2;
        c.insets = new Insets(0,0,0,50);
        df2.add(donorLName,c);
                
        c.insets = new Insets(0,0,0,0); 
                
        JLabel donorAdd1Label = new JLabel("Street Address");
        c.gridx = 0;
        c.gridy = 3;
        df2.add(donorAdd1Label,c);
        
        JTextField Add1 = new JTextField(donorAdd1);
        c.gridx = 0;
        c.gridy = 4;
        df2.add(Add1,c);
        
        
        JLabel donorAdd2Label = new JLabel("Address Line 2");
        c.gridx = 0;
        c.gridy = 5;
        df2.add(donorAdd2Label,c);
        
        JTextField Add2 = new JTextField(donorAdd2);
        c.gridx = 0;
        c.gridy = 6;
        df2.add(Add2,c);
        
        
        JLabel donorCityLabel = new JLabel("City");
        c.gridx = 0;
        c.gridy = 7;
        df2.add(donorCityLabel,c);
        
        JTextField City = new JTextField(donorCity);
        c.gridx = 0;
        c.gridy = 8;
        c.insets = new Insets(0,0,0,50);
        df2.add(City,c);
        
        //c.insets = new Insets(0,0,0,0);
        
        JLabel donorStateLabel = new JLabel("State");
        c.gridx = 1;
        c.gridy = 7;
        df2.add(donorStateLabel,c);
        
        JTextField State = new JTextField(donorState);
        c.gridx = 1;
        c.gridy = 8;
        //c.insets = new Insets(0,0,0,250);
        df2.add(State,c);
        
        //c.insets = new Insets(0,0,0,0);
        
        JLabel donorZipLabel = new JLabel("Zip Code");
        c.gridx = 2;
        c.gridy = 7;
        df2.add(donorZipLabel,c);
        
        JTextField Zip = new JTextField(donorZip);
        c.gridx = 2;
        c.gridy = 8;
        //c.insets = new Insets(0,0,0,200);
        df2.add(Zip,c);
       
        c.insets = new Insets(0,0,0,0);
        
        JLabel donorPhoneLabel = new JLabel("Phone Number");
        c.gridx = 0;
        c.gridy = 9;
        df2.add(donorPhoneLabel,c);
        
        JTextField Phone = new JTextField(donorPhone);
        c.gridx = 0;
        c.gridy = 10;
        c.insets = new Insets(0,0,0,175);
        df2.add(Phone,c);
        
        c.insets = new Insets(0,0,0,0);
        
        JLabel donorEmailLabel = new JLabel("Email Address");
        c.gridx = 0;
        c.gridy = 11;
        df2.add(donorEmailLabel,c);
        
        JTextField Email = new JTextField(donorEmail);
        c.gridx = 0;
        c.gridy = 12;
        c.insets = new Insets(0,0,0,50);
        df2.add(Email,c);
        
        JLabel donorMarketLabel = new JLabel("Accepts Marketing?");
        c.gridx = 1;
        c.gridy = 11;
        df2.add(donorMarketLabel,c);
        
        JCheckBox marketing = new JCheckBox();
        c.gridx = 1;
        c.gridy = 12;
        df2.add(marketing,c);
        accMark = "no";
        marketing.addItemListener(new ItemListener()
    {
      public void itemStateChanged(ItemEvent e)
      {
      
        if(e.getStateChange()==1){
            accMark="yes";
                }
        else{
            accMark="no";
        }
        
              }
    });
        c.insets = new Insets(0,0,0,0);
        
                
        JLabel amountLabel = new JLabel("Donation Amount");
        c.gridx = 0;
        c.gridy = 13;
        df2.add(amountLabel,c);
        
        JTextField amount = new JTextField("0.00");
        c.gridx = 0;
        c.gridy = 14;
        c.insets = new Insets(0,0,0,50);
        df2.add(amount,c);
        
        JLabel donorMethodLabel = new JLabel("Payment Method");
        c.gridx = 1;
        c.gridy = 13;
        
        df2.add(donorMethodLabel,c);
        
        JComboBox donMethod = new JComboBox();
        donMethod.addItem("Cash");
        donMethod.addItem("Check");
        donMethod.addItem("Credit Card");
        donMethod.addItem("Paypal");
        donMethod.addItem("Pledge");
        c.gridx = 1;
        c.gridy = 14;
        
        df2.add(donMethod,c);
        
        
        
        donMethod.addItemListener(new ItemListener() {
        public void itemStateChanged(ItemEvent arg0) {
            donationMethod = "Cash";
            donationMethod = donMethod.getSelectedItem().toString();
        }
    });
        
        JButton submit = new JButton("Submit");
        c.gridx = 0;
        c.gridy = 15;
        c.insets = new Insets(25,150,0,25);
        df2.add(submit,c);
        
        c.insets = new Insets(0,0,0,0);
        
        //button listener
        submit.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        
        df2.removeAll();
        
        donation = Double.parseDouble(amount.getText());
        donation donate = new donation();
        donate.Dona_Amt = donation;
        donate.Don_ID = donID;
        donate.Dona_Method = donationMethod;
        donate.Dona_Ref_Src = "in house";
        if (donation>0.0){
        donate.insertDonationData();
        JLabel confirm = new JLabel("Donation Added");
        df2.add(confirm);
       }
        else{
            JLabel nothingEntered = new JLabel("No Amount Added");
            df2.add(nothingEntered);
        }
        
        df2.validate();
        df2.repaint();
              }
    });
    
        return df2;
    }
        
    public int getCountDonor(){
        int donorCount = 0;
        Connection c = null;
        Statement stmt = null;
        
        
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      
      
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT COUNT(Don_ID)FROM donor;" );
      while ( rs.next() ) {
         donorCount = rs.getInt("COUNT(Don_ID)");
      }
      rs.close();
      stmt.close();
      c.close();
          
    }
      catch ( ClassNotFoundException | SQLException e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      //System.exit(0);
    }
    return donorCount;
    }
    
    public JPanel editDonor(){
        JPanel eP = new JPanel();
        eP.setLayout(new GridBagLayout());
        //eP.setMinimumSize(new Dimension(800,400));
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.ipady = 3;

        
        JLabel donorFormLabel = new JLabel("Edit Donor");
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0,100,25,0);
        eP.add(donorFormLabel,c);
        
        c.insets = new Insets(0,0,0,0);
        
        JLabel donorCompanyLabel = new JLabel("Company");
        c.gridx = 0;
        c.gridy = 1;
        eP.add(donorCompanyLabel,c);
        
        JTextField Company = new JTextField(donorCompany);
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(0,0,0,50);
        eP.add(Company,c);
        
        JLabel donorFNameLabel = new JLabel("First Name");
        c.gridx = 0;
        c.gridy = 3;
        eP.add(donorFNameLabel,c);
        
        JTextField donorFName = new JTextField(donorFirstName);
        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(0,0,0,50);
        eP.add(donorFName,c);
                
        c.insets = new Insets(0,0,0,0);   
        
        JLabel donorLNameLabel = new JLabel("Last Name");
        c.gridx = 1;
        c.gridy = 3;
        eP.add(donorLNameLabel,c);
        
        JTextField donorLName = new JTextField(donorLastName);
        c.gridx = 1;
        c.gridy = 4;
        c.insets = new Insets(0,0,0,50);
        eP.add(donorLName,c);
                
        c.insets = new Insets(0,0,0,0); 
                
        JLabel donorAdd1Label = new JLabel("Street Address");
        c.gridx = 0;
        c.gridy = 5;
        eP.add(donorAdd1Label,c);
        
        JTextField Add1 = new JTextField(donorAdd1);
        c.gridx = 0;
        c.gridy = 6;
        eP.add(Add1,c);
        
        
        JLabel donorAdd2Label = new JLabel("Address Line 2");
        c.gridx = 1;
        c.gridy = 5;
        eP.add(donorAdd2Label,c);
        
        JTextField Add2 = new JTextField(donorAdd2);
        c.gridx = 1;
        c.gridy = 6;
        eP.add(Add2,c);
        
        
        JLabel donorCityLabel = new JLabel("City");
        c.gridx = 0;
        c.gridy = 7;
        eP.add(donorCityLabel,c);
        
        JTextField City = new JTextField(donorCity);
        c.gridx = 0;
        c.gridy = 8;
        c.insets = new Insets(0,0,0,50);
        eP.add(City,c);
        
        //c.insets = new Insets(0,0,0,0);
        
        JLabel donorStateLabel = new JLabel("State");
        c.gridx = 1;
        c.gridy = 7;
        eP.add(donorStateLabel,c);
        
        JTextField State = new JTextField(donorState);
        c.gridx = 1;
        c.gridy = 8;
        //c.insets = new Insets(0,0,0,250);
        eP.add(State,c);
        
        //c.insets = new Insets(0,0,0,0);
        
        JLabel donorZipLabel = new JLabel("Zip Code");
        c.gridx = 2;
        c.gridy = 7;
        eP.add(donorZipLabel,c);
        
        JTextField Zip = new JTextField(donorZip);
        c.gridx = 2;
        c.gridy = 8;
        //c.insets = new Insets(0,0,0,200);
        eP.add(Zip,c);
       
        c.insets = new Insets(0,0,0,0);
        
        JLabel donorPhoneLabel = new JLabel("Phone Number");
        c.gridx = 0;
        c.gridy = 9;
        eP.add(donorPhoneLabel,c);
        
        JTextField Phone = new JTextField(donorPhone);
        c.gridx = 0;
        c.gridy = 10;
        c.insets = new Insets(0,0,0,175);
        eP.add(Phone,c);
        
        c.insets = new Insets(0,0,0,0);
        
        JLabel donorEmailLabel = new JLabel("Email Address");
        c.gridx = 1;
        c.gridy = 9;
        eP.add(donorEmailLabel,c);
        
        JTextField Email = new JTextField(donorEmail);
        c.gridx = 1;
        c.gridy = 10;
        c.insets = new Insets(0,0,0,50);
        eP.add(Email,c);
        
        JLabel donorMarketLabel = new JLabel("Accepts Marketing?");
        c.gridx = 2;
        c.gridy = 9;
        eP.add(donorMarketLabel,c);
        
        JCheckBox marketing = new JCheckBox();
        c.gridx = 2;
        c.gridy = 10;
        eP.add(marketing,c);
        accMark = "no";
        marketing.addItemListener(new ItemListener()
    {
      public void itemStateChanged(ItemEvent e)
      {
      
        if(e.getStateChange()==1){
            accMark="yes";
                }
        else{
            accMark="no";
        }
        
              }
    });
        c.insets = new Insets(0,0,0,0);
        
        JButton submit = new JButton("Save");
        c.gridx = 2;
        c.gridy = 11;
        eP.add(submit,c);
        
        submit.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        
        
        
        donorCompany = Company.getText();
        donorFirstName = donorFName.getText();
        donorLastName = donorLName.getText();
        donorAdd1 = Add1.getText();
        donorAdd2 = Add2.getText();
        donorCity = City.getText();
        donorState = State.getText();
        donorZip = Zip.getText();
        donorPhone = Phone.getText();
        donorEmail = Email.getText();
        donorMarket = accMark;
        
        eP.removeAll();
        
        Connection c = null;
        Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");

      stmt = c.createStatement(); 
      stmt.executeUpdate("update donor set DonorCompanyName='" + donorCompany + "',DonorFirstName='" + donorFirstName + 
                        "',DonorLastName='" + donorLastName + "',DonorAdd1='" + donorAdd1 + "',DonorAdd2='" + donorAdd2 +
                        "',DonorCity='" + donorCity +
                        "',DonorState='" + donorState + "',DonorZip='" + donorZip + "',DonorPhone='" + donorPhone + "',donorEmail='" +
                        donorEmail + "',DonorMarket='" + donorMarket + "' where Don_ID=" + donID +";");
      stmt.close();
      c.close();
      System.out.println("Records created successfully");
      
      
      
    }
      catch ( ClassNotFoundException | SQLException g ) {
      System.err.println( g.getClass().getName() + ": " + g.getMessage() );
      System.out.println("Record not created ");

    }
        JLabel donorUpdated = new JLabel("Donor Information Updated");
        eP.add(donorUpdated);
        
        eP.validate();
        eP.repaint();
              }
    });
        
        return eP;
    }
    
    public ArrayList donRefSrc(){
        ArrayList<String> refer = new ArrayList<String>();
        
        Connection c = null;
        Statement stmt = null;
       
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      System.out.println("Opened database successfully");
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT COUNT(Don_ID),DonorReferSrc FROM donor group by DonorReferSrc Order By COUNT(DON_ID) DESC;" );
      
      while(rs.next()){
          String toAdd = (rs.getInt("COUNT(DON_ID)") + "-" + rs.getString("DonorReferSrc"));
          refer.add(toAdd);
          System.out.println(toAdd);
      }
      
      rs.close();
      stmt.close();
      c.close();
    }
       catch(Exception f){
          System.err.println( f.getClass().getName() + ": " + f.getMessage() );
      }
               
        return refer;
        
    }
    
}
