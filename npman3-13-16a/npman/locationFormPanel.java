/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package npman;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.io.File;
import javax.imageio.ImageIO;
/**
 *
 * @author brc
 */
class locationFormPanel extends JPanel {

    public static LocDBMS locData;
    public String selectedLogo;
    
    public locationFormPanel() {
    
        setLayout(new GridBagLayout());
        //setPreferredSize(new Dimension(400,300));
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 3;
        //setLayout (new BoxLayout(this, BoxLayout.Y_AXIS));
        //setLayout(new BorderLayout());
          
        locData = new LocDBMS();
        locData.OpenDB();
        
        JLabel OrgLocLabel = new JLabel("Add a new location");
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0,150,5,0);
        add(OrgLocLabel,c);
        
        c.insets = new Insets(0,0,0,0);
        
        JLabel OrgNameLabel = new JLabel("Organization Name");
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(0,0,0,200);
        add(OrgNameLabel,c);
        
        JTextField OrgName = new JTextField();
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(0,0,0,350);
        add(OrgName,c);
                
             
                
        JLabel OrgAdd1Label = new JLabel("Street Address");
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(0,0,0,400);
        add(OrgAdd1Label,c);
        
        JTextField OrgAdd1 = new JTextField();
        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(0,0,0,400);
        add(OrgAdd1,c);
        
        
        JLabel OrgAdd2Label = new JLabel("Address Line 2");
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(0,350,0,0);
        add(OrgAdd2Label,c);
        
        JTextField OrgAdd2 = new JTextField(5);
        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(0,350,0,100);
        add(OrgAdd2,c);
        
        
        JLabel OrgCityLabel = new JLabel("City");
        c.gridx = 0;
        c.gridy = 7;
        c.insets = new Insets(0,0,0,550);
        add(OrgCityLabel,c);
        
        JTextField OrgCity = new JTextField(5);
        c.gridx = 0;
        c.gridy = 8;
        c.insets = new Insets(0,0,0,550);
        add(OrgCity,c);
        
        
        
        JLabel OrgStateLabel = new JLabel("State");
        c.gridx = 0;
        c.gridy = 7;
        c.insets = new Insets(0,200,0,400);
        add(OrgStateLabel,c);
        
        JComboBox states = new JComboBox();
        stateMenu menu = new stateMenu();
        states = menu.retStateMenu();
        c.gridx = 0;
        c.gridy = 8;
        c.insets = new Insets(0,200,0,400);
        add(states,c);
               
        JLabel OrgZipLabel = new JLabel("Zip Code");
        c.gridx = 0;
        c.gridy = 7;
        c.insets = new Insets(0,350,0,250);
        add(OrgZipLabel,c);
        
        JTextField OrgZip = new JTextField(5);
        c.gridx = 0;
        c.gridy = 8;
        c.insets = new Insets(0,350,0,250);
        add(OrgZip,c);
       
        JLabel OrgPhoneLabel = new JLabel("Phone Number");
        c.gridx = 0;
        c.gridy = 9;
        c.insets = new Insets(0,0,0,0);
        add(OrgPhoneLabel,c);
        
        JTextField OrgPhone = new JTextField(5);
        c.gridx = 0;
        c.gridy = 10;
        c.insets = new Insets(0,0,0,550);
        add(OrgPhone,c);
        
        JLabel OrgFaxLabel = new JLabel("Fax Number");
        c.gridx = 0;
        c.gridy = 9;
        c.insets = new Insets(0,250,0,0);
        add(OrgFaxLabel,c);
        
        JTextField OrgFax = new JTextField(5);
        c.gridx = 0;
        c.gridy = 10;
        c.insets = new Insets(0,250,0,300);
        add(OrgFax,c);
        
        JLabel OrgWebLabel = new JLabel("Website Address");
        c.gridx = 0;
        c.gridy = 13;
        c.insets = new Insets(0,0,0,0);
        add(OrgWebLabel,c);
        
        JTextField OrgWeb = new JTextField(5);
        c.gridx = 0;
        c.gridy = 14;
        c.insets = new Insets(0,0,0,450);
        add(OrgWeb,c);
        
        JLabel OrgTaxIdLabel = new JLabel("Tax Identification Number");
        c.gridx = 0;
        c.gridy = 15;
        c.insets = new Insets(0,0,0,0);
        add(OrgTaxIdLabel,c);
        
        JTextField OrgTaxId = new JTextField(5);
        c.gridx = 0;
        c.gridy = 16;
        c.insets = new Insets(0,0,0,550);
        add(OrgTaxId,c);
           
        JButton logoChooser = new JButton("Add Logo");
        c.gridx = 0;
        c.gridy = 16;
        c.insets = new Insets(0,250,0,275);
        add(logoChooser,c);
        
        logoChooser.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
          JFileChooser locLogo = new JFileChooser();
          locLogo.setSelectedFile(new File("placeholder.jpg"));
                 
          int returnVal = locLogo.showOpenDialog(null);
          if(returnVal == JFileChooser.APPROVE_OPTION) {
       System.out.println("You chose to open this file: " +
            locLogo.getSelectedFile().getName());
            selectedLogo = locLogo.getSelectedFile().getName();
            File selectedImg = locLogo.getSelectedFile();
              String filepath = selectedImg.getAbsolutePath();
              InputStream inStream = null;
              OutputStream outStream = null;
              
              File dir = new File(System.getProperty("user.home") + "/NPMWare/logos/");
                dir.mkdirs();
                
                try{
                    File source =new File(filepath);
                    File dest =new File(System.getProperty("user.home") + "/NPMWare/logos/" + selectedImg.getName());
                   
                    if(!dest.isFile()){
                    inStream = new FileInputStream(source);
                    outStream = new FileOutputStream(dest);

                    byte[] buffer = new byte[1024];

                    int length;
                    while ((length = inStream.read(buffer)) > 0){
                        outStream.write(buffer, 0, length);
                    }

                    if (inStream != null)inStream.close();
                    if (outStream != null)outStream.close();
                    
                    System.out.println("File Copied..");
                    }
                }catch(IOException e1){
                    e1.printStackTrace();
                }
            System.out.println(selectedLogo);
           }
          
        
              }
    });
        
        
        JButton submit = new JButton("Submit");
        c.gridx = 0;
        c.gridy = 18;
        c.insets = new Insets(10,350,0,250);
        add(submit,c);
        
        c.insets = new Insets(0,0,0,0);
        
        //button listener
        submit.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
          menu.getState();
        System.out.println("Submitted");
        String OrgName1 = OrgName.getText();
        String OrgAdd11 = OrgAdd1.getText();
        String OrgAdd21 = OrgAdd2.getText();
        String OrgCity1 = OrgCity.getText();
        String OrgState1 = menu.selectedState;
        String OrgZip1 = OrgZip.getText();
        String OrgPhone1 = OrgPhone.getText();
        String OrgFax1 = OrgFax.getText();
        String OrgWeb1 = OrgWeb.getText();
        String OrgTaxId1 = OrgTaxId.getText();
        String OrgLogo1 = (System.getProperty("user.home") + "/NPMWare/logos/" + selectedLogo);
      
        
        removeAll();
                JLabel orgVer =  new JLabel("Is the information correct?");
        c.gridx = 0;
        c.gridy = 0;
        add(orgVer,c);
           
        JLabel Logo  = new JLabel("Website Logo: " + OrgLogo1);
        c.gridx = 1;
        c.gridy = 0;
      add(Logo,c);
      
      
      
      try {
          BufferedImage myPicture = ImageIO.read(new File(OrgLogo1));
          
       
      JLabel logoView = new JLabel(new ImageIcon(myPicture));
      logoView.setMaximumSize(new Dimension(150,150));
      logoView.setPreferredSize(new Dimension(150,150));
      c.gridx = 1;
      c.gridy = 1;
      add(logoView,c);
      }
      catch(IOException i ) {
          
          JLabel logoView = new JLabel("Could not retrieve image");
            c.gridx = 1;
            c.gridy = 1;
            add(logoView,c);
      }
        JLabel orgNameVer = new JLabel(OrgName1);
        c.weightx = 2;
        c.gridx = 0;
        c.gridy = 1;
        add(orgNameVer,c);
        
        JLabel orgAdd1Ver = new JLabel(OrgAdd11);
        c.weightx = 2;
        c.gridx = 0;
        c.gridy = 2;
        add(orgAdd1Ver,c);
        
        JLabel orgAdd2Ver = new JLabel(OrgAdd21);
        c.weightx = 2;
        c.gridx = 0;
        c.gridy = 3;
        add(orgAdd2Ver,c);
        
        JLabel orgCityVer = new JLabel(OrgCity1);
        c.weightx = 2;
        c.gridx = 0;
        c.gridy = 4;
        add(orgCityVer,c);
        
        JLabel orgStateVer = new JLabel(OrgState1);
        c.weightx = 2;
        c.gridx = 0;
        c.gridy = 5;
        add(orgStateVer,c);
        
        JLabel orgZipVer = new JLabel(OrgZip1);
        c.weightx = 2;
        c.gridx = 0;
        c.gridy = 6;
        add(orgZipVer,c);
        
        JLabel orgPhoneVer = new JLabel(OrgPhone1);
        c.weightx = 2;
        c.gridx = 0;
        c.gridy = 7;
        add(orgPhoneVer,c);
        
        JLabel orgFaxVer = new JLabel(OrgFax1);
        c.weightx = 2;
        c.gridx = 0;
        c.gridy = 8;
        add(orgFaxVer,c);
        
        JLabel orgWebVer = new JLabel(OrgWeb1);
        c.weightx = 2;
        c.gridx = 0;
        c.gridy = 9;
        add(orgWebVer,c);
        //c.insets = new Insets(0,100,25,0);
        
        
        JButton addVerLocation = new JButton("Yes, Add Location");
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 10;
        c.insets = new Insets(0,50,0,200);
        add(addVerLocation,c);

        
        JButton dontAddLocation = new JButton("No, Return to Form");
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 10;
        c.insets = new Insets(0,50,0,150);
        add(dontAddLocation,c);
           
        
                
        //button listener
        addVerLocation.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
      
        //System.out.println("Submitted");
          
          int nextId = locData.getNextLocId();
          String locDatas = "Insert into location values(" + nextId + ",'"+OrgName1+"','"+OrgAdd11+"','"+OrgAdd21+"','"+OrgCity1
                              +"','"+OrgState1+"','"+OrgZip1+"','"+OrgPhone1+"','"+OrgFax1+"','"+OrgWeb1
                               +"','"+OrgTaxId1+"','"+OrgLogo1+"','','');";
          System.out.println(locDatas);
          locData.InsertLocData(locDatas);
        //locData.InsertLocData("Insert into location values("+OrgName1+","+OrgAdd11+","+OrgAdd21+","+OrgCity1
        //                      +","+OrgState1+","+OrgZip1+","+OrgPhone1+","+OrgFax1+","+OrgWeb1
        //                       +","+OrgTaxId1+","+OrgLogo1+");");
        removeAll();
        
        JLabel addedNewLoc = new JLabel("New Location Added");
        add(addedNewLoc);
        validate();
        repaint();
        
        
              }
    });
    dontAddLocation.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        locationFormPanel locForm1 = new locationFormPanel();
        removeAll();
        add(locForm1);
        validate();
        repaint();
        
        
              }
    });
        validate();
        repaint();
        
        System.out.println(OrgName1 + "\n" + OrgAdd11 + "\n" + OrgAdd21 +
                "\n" + OrgCity1 + ", " + OrgState1 + " " + OrgZip1 + "\n" +
                "Phone: " + OrgPhone1 + "\n Fax: " + OrgFax1 + "\n Website: " + 
                OrgWeb1);
              }
    });
    
    }
    
}
