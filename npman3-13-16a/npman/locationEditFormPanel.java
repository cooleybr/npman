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
import javax.imageio.ImageIO;
/**
 *
 * @author brc
 */
class locationEditFormPanel extends JPanel {

    public static LocDBMS locData;
    public String selectedLogo;
    public location toEdit;
    public int locID;
    public JLabel logoView;
    
    public locationEditFormPanel(int location) {
        toEdit = new location();
        locID = location;
        toEdit.retrSetLocData(locID);
        
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(500,400));
        GridBagConstraints c = new GridBagConstraints();
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;
        c.ipadx = 30;
     
          
               
        JLabel OrgLocLabel = new JLabel("Edit location: " + locID);
        c.gridx = 0;
        c.gridy = 0;
        //c.insets = new Insets(0,100,25,0);
        add(OrgLocLabel,c);
        
        c.insets = new Insets(0,0,0,0);
        
        JLabel OrgNameLabel = new JLabel("Organization Name");
        c.gridx = 0;
        c.gridy = 1;
        //c.insets = new Insets(0,10,0,0);
        add(OrgNameLabel,c);
        
        JTextField OrgName = new JTextField(toEdit.orgName);
        c.gridx = 0;
        c.gridy = 2;
        //c.insets = new Insets(0,0,0,50);
        add(OrgName,c);
                
             
                
        JLabel OrgAdd1Label = new JLabel("Street Address");
        c.gridx = 0;
        c.gridy = 3;
        //c.insets = new Insets(0,10,0,0);
        add(OrgAdd1Label,c);
        
        JTextField OrgAdd1 = new JTextField(toEdit.orgAdd1);
        c.gridx = 0;
        c.gridy = 4;
        //c.insets = new Insets(0,0,0,10);
        add(OrgAdd1,c);
        
        
        JLabel OrgAdd2Label = new JLabel("Address Line 2");
        c.gridx = 1;
        c.gridy = 3;
        //c.insets = new Insets(0,10,0,0);
        add(OrgAdd2Label,c);
        
        JTextField OrgAdd2 = new JTextField(toEdit.orgAdd2);
        c.gridx = 1;
        c.gridy = 4;
        //c.insets = new Insets(0,0,0,10);
        add(OrgAdd2,c);
        
        
        JLabel OrgCityLabel = new JLabel("City");
        c.gridx = 0;
        c.gridy = 5;
        //c.insets = new Insets(0,10,0,0);
        add(OrgCityLabel,c);
        
        JTextField OrgCity = new JTextField(toEdit.orgCity);
        c.gridx = 0;
        c.gridy = 6;
        //c.insets = new Insets(0,0,0,150);
        add(OrgCity,c);
        
        
        
        JLabel OrgStateLabel = new JLabel("State");
        c.gridx = 1;
        c.gridy = 5;
        //c.insets = new Insets(0,10,0,0);
        add(OrgStateLabel,c);
        
        JTextField OrgState = new JTextField(toEdit.orgState);
        c.gridx = 1;
        c.gridy = 6;
        //c.insets = new Insets(0,0,0,350);
        add(OrgState,c);
        
        
        
        JLabel OrgZipLabel = new JLabel("Zip Code");
        c.gridx = 2;
        c.gridy = 5;
        //c.insets = new Insets(0,10,0,0);
        add(OrgZipLabel,c);
        
        JTextField OrgZip = new JTextField(toEdit.orgZip);
        c.gridx = 2;
        c.gridy = 6;
        //c.insets = new Insets(0,0,0,200);
        add(OrgZip,c);
       
        JLabel OrgPhoneLabel = new JLabel("Phone Number");
        c.gridx = 0;
        c.gridy = 7;
        //c.insets = new Insets(0,10,0,0);
        add(OrgPhoneLabel,c);
        
        JTextField OrgPhone = new JTextField(toEdit.orgPhone);
        c.gridx = 0;
        c.gridy = 8;
        //c.insets = new Insets(0,0,0,300);
        add(OrgPhone,c);
        
        JLabel OrgFaxLabel = new JLabel("Fax Number");
        c.gridx = 1;
        c.gridy = 7;
        //c.insets = new Insets(0,10,0,0);
        add(OrgFaxLabel,c);
        
        JTextField OrgFax = new JTextField(toEdit.orgFax);
        c.gridx = 1;
        c.gridy = 8;
        //c.insets = new Insets(0,0,0,300);
        add(OrgFax,c);
        
        JLabel OrgWebLabel = new JLabel("Website Address");
        c.gridx = 0;
        c.gridy = 9;
        //c.insets = new Insets(0,10,0,0);
        add(OrgWebLabel,c);
        
        JTextField OrgWeb = new JTextField(toEdit.orgWeb);
        c.gridx = 0;
        c.gridy = 10;
        //c.insets = new Insets(0,0,0,175);
        add(OrgWeb,c);
        
        JLabel OrgTaxIdLabel = new JLabel("Tax Identification Number");
        c.gridx = 1;
        c.gridy = 9;
        //c.insets = new Insets(0,10,0,0);
        add(OrgTaxIdLabel,c);
        
        JTextField OrgTaxId = new JTextField(toEdit.orgTaxID);
        c.gridx = 1;
        c.gridy = 10;
        //c.insets = new Insets(0,0,0,300);
        add(OrgTaxId,c);
        
        
        JButton logoChooser = new JButton("Change Logo");
        logoChooser.setMaximumSize(new Dimension(20,150));
        c.gridx = 0;
        c.gridy = 11;
        //c.insets = new Insets(10,0,0,400);
        add(logoChooser,c);
        
        selectedLogo = toEdit.orgLogo;
        
        try {
          BufferedImage myPicture = ImageIO.read(new File(selectedLogo));
       
      logoView = new JLabel(new ImageIcon(myPicture));
      logoView.setPreferredSize(new Dimension(150,150));
      c.gridx = 1;
      c.gridy = 11;
      add(logoView,c);
      }
      catch(IOException i ) {
          
          logoView = new JLabel("Could not retrieve image: " + selectedLogo);
            c.gridx = 1;
            c.gridy = 11;
            add(logoView,c);
      }
        
        logoChooser.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
          JFileChooser locLogo = new JFileChooser();
if(toEdit.orgLogo != null){
          locLogo.setSelectedFile(new File(toEdit.orgLogo));
          }
else{
          locLogo.setSelectedFile(new File("placeholder.jpg"));
       }          
          int returnVal = locLogo.showOpenDialog(null);
          if(returnVal == JFileChooser.APPROVE_OPTION) {
              remove(logoView);
              revalidate();
              repaint();
       System.out.println("You chose to open this file: " +
            locLogo.getSelectedFile().getName());
            
            File selectedImg = locLogo.getSelectedFile();
            selectedLogo = (System.getProperty("user.home") + "/NPMWare/logos/" + selectedImg.getName());
              
            
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
                
            try {
                    
          BufferedImage myPicture = ImageIO.read(new File(selectedLogo));
       
      logoView = new JLabel(new ImageIcon(myPicture));
      logoView.setPreferredSize(new Dimension(150,150));
      c.gridx = 1;
      c.gridy = 11;
      add(logoView,c);
      revalidate();
      repaint();
      }
      catch(IOException i ) {
          
          logoView = new JLabel("Could not retrieve image: " + selectedLogo);
            c.gridx = 1;
            c.gridy = 11;
            add(logoView,c);
            revalidate();
            repaint();
      }
           }
          
        
              }
    });
        
        
        
        
        
        JButton submit = new JButton("Submit");
        c.gridx = 1;
        c.gridy = 12;
        //c.insets = new Insets(25,450,0,50);
        add(submit,c);
        
        c.insets = new Insets(0,0,0,0);
        
        //button listener
        submit.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        System.out.println("Submitted");
        toEdit.orgName = OrgName.getText();
        toEdit.orgAdd1 = OrgAdd1.getText();
        toEdit.orgAdd2 = OrgAdd2.getText();
        toEdit.orgCity = OrgCity.getText();
        toEdit.orgState = OrgState.getText();
        toEdit.orgZip = OrgZip.getText();
        toEdit.orgPhone = OrgPhone.getText();
        toEdit.orgFax = OrgFax.getText();
        toEdit.orgWeb = OrgWeb.getText();
        toEdit.orgTaxID = OrgTaxId.getText();
        toEdit.orgLogo = selectedLogo;
      
        
        removeAll();
                JLabel orgVer =  new JLabel("Is the information correct?");
        c.gridx = 0;
        c.gridy = 0;
        add(orgVer,c);
           
        JLabel orgNameVer = new JLabel("Organization: " + toEdit.orgName);
        c.gridx = 0;
        c.gridy = 1;
        add(orgNameVer,c);
        
        JLabel orgAdd1Ver = new JLabel("Address: " + toEdit.orgAdd1);
        c.gridx = 0;
        c.gridy = 2;
        add(orgAdd1Ver,c);
        
        JLabel orgAdd2Ver = new JLabel("Apt/Suite: " + toEdit.orgAdd2);
        c.gridx = 1;
        c.gridy = 2;
        add(orgAdd2Ver,c);
        
        JLabel orgCityVer = new JLabel("City: " + toEdit.orgCity);
        c.gridx = 0;
        c.gridy = 3;
        add(orgCityVer,c);
        
        JLabel orgStateVer = new JLabel("State: " + toEdit.orgState);
        c.gridx = 1;
        c.gridy = 3;
        add(orgStateVer,c);
        
        JLabel orgZipVer = new JLabel("Zip: " + toEdit.orgZip);
        c.gridx = 2;
        c.gridy = 3;
        add(orgZipVer,c);
        
        JLabel orgPhoneVer = new JLabel("Phone: " + toEdit.orgPhone);
        c.gridx = 0;
        c.gridy = 4;
        add(orgPhoneVer,c);
        
        JLabel orgFaxVer = new JLabel("Fax: " + toEdit.orgFax);
        c.gridx = 1;
        c.gridy = 4;
        add(orgFaxVer,c);
        
        JLabel orgWebVer = new JLabel("Website: " + toEdit.orgWeb);
        c.gridx = 0;
        c.gridy = 5;
        add(orgWebVer,c);
        //c.insets = new Insets(0,100,25,0);
        
        
        JButton addVerLocation = new JButton("Yes, Update Location");
        c.gridx = 1;
        c.gridy = 6;
        c.insets = new Insets(0,0,0,0);
        add(addVerLocation,c);

        
        JButton dontAddLocation = new JButton("No,Return to Form");
        c.gridx = 2;
        c.gridy = 6;
        c.insets = new Insets(0,0,0,0);
        add(dontAddLocation,c);
           
        
                
        //button listener
        addVerLocation.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
      
        toEdit.updateLocData();
        removeAll();
        
        JLabel updateLoc = new JLabel("Location Updated");
        add(updateLoc);
        validate();
        repaint();
        
        
              }
    });
    dontAddLocation.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        locationEditFormPanel locForm1 = new locationEditFormPanel(locID);
        removeAll();
        add(locForm1);
        validate();
        repaint();
        
        
              }
    });
        validate();
        repaint();
        
        
              }
    });
    
    }
    
}
