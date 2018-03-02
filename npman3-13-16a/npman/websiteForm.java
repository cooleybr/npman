/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package npman;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File;
/**
 *
 * @author brc
 */
public class websiteForm extends JPanel{
    public JFileChooser siteLogo;
    public String selectedLogo,dirpath,filepath;
    public String selectedValue,selectedLocation;
    public website newWeb;
    public JLabel ftpVer;
    public File selectedImg;
    
        public websiteForm(){
            
            
        setLayout(new GridBagLayout());
        //this.setMaximumSize(new Dimension(400,200));
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.ipady = 3;
        newWeb = new website();
        newWeb.verifyWebTable();
        
        JLabel webURL = new JLabel("Website Base URL");
        c.gridy = 2;
        c.gridx = 0;
        add(webURL,c);
        
        JTextField webURLIn = new JTextField();
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(0,0,0,50);
        add(webURLIn,c);
                
        JLabel ftpURL = new JLabel("Website FTP URL");
        c.gridy = 2;
        c.gridx = 1;
        
        add(ftpURL,c);
        
        JTextField ftpURLIn = new JTextField();
        
        c.gridx = 1;
        c.gridy = 3;
        add(ftpURLIn,c);
        
        JLabel ftpUser = new JLabel("Website FTP Username");
        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(0,0,0,0);
        add(ftpUser,c);
        
        JTextField ftpUserIn = new JTextField();
        c.gridx = 0;
        c.gridy = 5;
        c.insets = new Insets(0,0,0,50);
        add(ftpUserIn,c);
        
        JLabel ftpPass = new JLabel("Website FTP Password");
        c.gridx = 1;
        c.gridy = 4;
        add(ftpPass,c);
        
        JTextField ftpPassIn = new JTextField();
        c.gridx = 1;
        c.gridy = 5;
        c.insets = new Insets(0,0,0,50);
        add(ftpPassIn,c);
        
        JLabel trackCode = new JLabel("Website Tracking Code");
        c.gridy = 6;
        c.gridx = 0;
        add(trackCode,c);
        
        JTextArea trackCodeIn = new JTextArea("Tracking Code");
        trackCodeIn.setEditable(true);
        trackCodeIn.setLineWrap(true);
        trackCodeIn.setVisible(true);
        c.gridx = 0;
        c.gridy = 7;
        JScrollPane pane = new JScrollPane(trackCodeIn);
        pane.setPreferredSize(new Dimension(100,150));
        add(pane,c);
        
        JLabel webLocEventLabel = new JLabel("Is the website for a particular location or event?");
        c.gridy = 8;
        c.gridx = 1;
        c.insets = new Insets(5,0,0,25);
        add(webLocEventLabel,c);
        
        JComboBox location = new JComboBox();
        locMenu menu = new locMenu();
        location = menu.locList();
        c.gridx = 1;
        c.gridy = 9;
        
        add(location,c); 
        
        
        JButton logoChoose = new JButton("Add Logo");
        
        c.gridx = 0;
        c.gridy = 9;
        c.insets = new Insets(5,0,0,35);
        add(logoChoose,c);
        selectedImg = new File(System.getProperty("user.home") + "/NPMWare/" + "placeholder.jpg");
        filepath = selectedImg.getAbsolutePath();
        
        logoChoose.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
          siteLogo = new JFileChooser();
          siteLogo.setSelectedFile(new File("placeholder.jpg"));
                    
          int returnVal = siteLogo.showOpenDialog(null);
          if(returnVal == JFileChooser.APPROVE_OPTION) {
       System.out.println("You chose to open this file: " +
            siteLogo.getSelectedFile().getName());
              selectedImg = siteLogo.getSelectedFile();
              filepath = selectedImg.getAbsolutePath();
              
           }
        
              }
    });
        
        JButton testFTP = new JButton("Test FTP");
        c.gridx = 1;
        c.gridy = 6;
        c.insets = new Insets(10,50,0,75);
        add(testFTP,c);
        c.insets = new Insets(0,0,0,0);
        ftpVer = new JLabel("FTP Status...");
            c.gridy = 7;
            c.gridx = 1;
            c.insets = new Insets(5,50,0,0);
            add(ftpVer,c);
        
        testFTP.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        
        //get location or event id
        newWeb.Web_URL = webURLIn.getText();
        newWeb.Web_FTP_URL = ftpURLIn.getText();
        newWeb.Web_FTP_Log = ftpUserIn.getText();
        newWeb.Web_FTP_Pass = ftpPassIn.getText();
        newWeb.Web_Track_Code = trackCodeIn.getText();
        newWeb.Web_Logo = (dirpath + selectedLogo);
        ftpTest t1 = new ftpTest();
        //System.out.println(newWeb.Web_URL + " " + newWeb.Web_FTP_Log + " " + newWeb.Web_FTP_Pass);
         boolean confirm = false;
         
            
        confirm = t1.ftpWorks(newWeb);
        if (confirm==true){
           remove(ftpVer);
            ftpVer = new JLabel("FTP Connected Successfully");
            c.gridy = 7;
            c.gridx = 1;
            c.insets = new Insets(5,50,0,0);
            add(ftpVer,c);
        }
        else{
            remove(ftpVer);
            ftpVer = new JLabel("FTP Failed To Connect");
            c.gridy = 7;
            c.gridx = 1;
            c.insets = new Insets(5,50,0,0);
            add(ftpVer,c);
        }
        
        revalidate();
        repaint();
        
      }
      
      });
        
      JButton submit = new JButton("Submit");
        c.gridx = 1;
        c.gridy = 10;
        c.insets = new Insets(10,5,0,50);
        add(submit,c);
        
        submit.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
          
          InputStream inStream = null;
              OutputStream outStream = null;
              
              String delims = "[.]+";
                String[] tokens = webURLIn.getText().split(delims);
                System.out.println(tokens[0]);
                if(tokens[0].equalsIgnoreCase("www")){
                File dir = new File(System.getProperty("user.home") + "/NPMWare/websites/" + tokens[1]);
                dir.mkdirs();
                dirpath = (dir.getPath() + "/");
                }
                else{
                File dir = new File(System.getProperty("user.home") + "/NPMWare/websites/" + tokens[0]);
                 dir.mkdirs();
                 dirpath = (dir.getPath() + "/");
                }    
                
                
              try{
                    File source =new File(filepath);
                    
                    File dest =new File(dirpath + selectedImg.getName());
                    
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
                    //e1.printStackTrace();
                }
      
            selectedLogo = selectedImg.getName();
            System.out.println(selectedLogo);
        removeAll();
        menu.getLocation();
        newWeb.Web_URL = webURLIn.getText();
        newWeb.Web_FTP_URL = ftpURLIn.getText();
        newWeb.Web_FTP_Log = ftpUserIn.getText();
        newWeb.Web_FTP_Pass = ftpPassIn.getText();
        newWeb.Web_Track_Code = trackCodeIn.getText();
        newWeb.Web_Logo = (dirpath + selectedLogo);
        newWeb.Web_Loc_ID = menu.selectedID;
        JPanel confirmation = new JPanel();
          try {
              confirmation = newWeb.webConfirmPanel();
          } catch (IOException ex) {
              Logger.getLogger(websiteForm.class.getName()).log(Level.SEVERE, null, ex);
          }
        
        
        add(confirmation);
      
        JButton submit = new JButton("Add Website");
      c.gridy = 8;
      add(submit,c);
      
      submit.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
          
          try {
              newWeb.insertWebData();
          } catch (IOException ex) {
              Logger.getLogger(websiteForm.class.getName()).log(Level.SEVERE, null, ex);
          }
        removeAll();
        JLabel confirmed = new JLabel("Website Information Saved");
        add(confirmed);
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
