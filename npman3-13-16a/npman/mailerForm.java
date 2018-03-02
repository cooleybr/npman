/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package npman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
/**
 *
 * @author brc
 */
public class mailerForm extends JPanel{
    public String mainCheck, selectedImg;
    
        public mailerForm(){
            
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.ipady = 3;
        
        JLabel webformTitle = new JLabel("Add Mailer Data");
        c.gridy = 0;
        c.insets = new Insets(0,0,0,0);
        add(webformTitle,c);
        
        JLabel pageTitle = new JLabel("Mailer Title");
        c.gridy = 2;
        c.insets = new Insets(20,0,0,200);
        add(pageTitle,c);
        
        JTextField titleIn = new JTextField(250);
        c.insets = new Insets(10,0,0,200);
        c.gridy = 3;
        add(titleIn,c);
        
               
        JLabel pageContent = new JLabel("Message");
        c.gridy = 6;
        c.insets = new Insets(20,0,0,200);
        add(pageContent,c);
        
        JTextArea pageContentIn = new JTextArea("Content Area");
        pageContentIn.setEditable(true);
        pageContentIn.setLineWrap(true);
        pageContentIn.setVisible(true);
        c.insets = new Insets(0,0,0,0);
        c.gridy = 7;
        JScrollPane pane = new JScrollPane(pageContentIn);
        pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        pane.setMinimumSize(new Dimension(30,200));
        add(pane,c);
        
        

        
        JButton logoChoose = new JButton("Add Image");
        c.insets = new Insets(10,0,0,50);
        c.gridy = 8;
        add(logoChoose,c);
        
        logoChoose.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
          JFileChooser locLogo = new JFileChooser();
          locLogo.setSelectedFile(new File("placeholder.jpg"));
                 
          int returnVal = locLogo.showOpenDialog(null);
          if(returnVal == JFileChooser.APPROVE_OPTION) {
       System.out.println("You chose to open this file: " +
            locLogo.getSelectedFile().getName());
            selectedImg = locLogo.getSelectedFile().getName();
            File selectedImg = locLogo.getSelectedFile();
              String filepath = selectedImg.getAbsolutePath();
              InputStream inStream = null;
              OutputStream outStream = null;
              
              File dir = new File(System.getProperty("user.home") + "/NPMWare/mailImg/");
                dir.mkdirs();
                
                try{
                    File source =new File(filepath);
                    File dest =new File(System.getProperty("user.home") + "/NPMWare/mailImg/" + selectedImg.getName());
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
            
           }
          
        
              }
    });
        
        JComboBox loc = new JComboBox();
        locMenu locMen = new locMenu();
        loc = locMen.locList();
        c.gridy = 8;
        c.gridx = 1;
        add(loc,c);
        
        
        JCheckBox isMain = new JCheckBox("Email?");
        c.weightx = .5;
        c.gridx = 0;
        c.gridy = 9;
        c.insets = new Insets(20,0,0,0);
        add(isMain,c);
        mainCheck = "Print";
        isMain.addItemListener(new ItemListener()
    {
      public void itemStateChanged(ItemEvent e)
      {
      
        if(e.getStateChange()==1){
            mainCheck="Email";
                }
        else{
            mainCheck="Print";
        }
        
              }
    });
        
        JButton submit = new JButton("Submit");
        c.gridx = 3;
        c.gridy = 10;
        c.insets = new Insets(0,20,0,200);
        add(submit,c);
        
        submit.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
          locMen.getLocation();
          mailer addMail =  new mailer();
          //addMail.Mail_Date = "current_date";
          addMail.Mail_Name = titleIn.getText();
          addMail.Mail_Message = pageContentIn.getText();
          addMail.Mail_Method = mainCheck;
          addMail.Mail_Img = (System.getProperty("user.home") + "/NPMWare/mailImg/" + selectedImg);
          addMail.Mail_ID = addMail.getNextMailID();
          addMail.Mail_Loc_ID = locMen.selectedID;
          addMail.insertMailer();
        removeAll();
        JLabel webConfirmTitle = new JLabel("Confirm Saved");
        add(webConfirmTitle);
        validate();
        repaint();
        
              }
    });
        
        }
    
        
        //this form comes from donorListPanel from prompt for contact now
        public JPanel mailerForm(ArrayList<Integer> donorList){
         JPanel dF = new JPanel();
        ArrayList donors = donorList;
        dF.setLayout(new GridBagLayout());
       
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(0,0,0,0);
        c.ipady = 3;
        c.gridy = 0;
        c.gridx = 0;
        
        JLabel webformTitle = new JLabel("Add Mailer Data");
        c.gridy = 0;
        c.insets = new Insets(0,0,0,0);
        dF.add(webformTitle,c);
        
        JLabel pageTitle = new JLabel("Mailer Title");
        c.gridy = 2;
        c.insets = new Insets(20,0,0,0);
        dF.add(pageTitle,c);
        
        JTextField titleIn = new JTextField(15);
        c.insets = new Insets(10,0,0,200);
        c.gridy = 3;
        dF.add(titleIn,c);
        
               
        JLabel pageContent = new JLabel("Message");
        c.gridy = 6;
        c.insets = new Insets(20,0,0,0);
        dF.add(pageContent,c);
        
        JTextArea pageContentIn = new JTextArea("Content Area");
        pageContentIn.setEditable(true);
        pageContentIn.setLineWrap(true);
        pageContentIn.setVisible(true);
        c.insets = new Insets(0,0,0,0);
        c.gridy = 7;
        JScrollPane pane = new JScrollPane(pageContentIn);
        pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        pane.setMinimumSize(new Dimension(50,200));
        pane.setPreferredSize(new Dimension(50,200));
        dF.add(pane,c);
        
        

        
        JButton logoChoose = new JButton("Add Image");
        c.insets = new Insets(10,0,0,50);
        c.gridy = 10;
        dF.add(logoChoose,c);
        
        logoChoose.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
          JFileChooser locLogo = new JFileChooser();
          locLogo.setSelectedFile(new File("placeholder.jpg"));
                 
          int returnVal = locLogo.showOpenDialog(null);
          if(returnVal == JFileChooser.APPROVE_OPTION) {
       System.out.println("You chose to open this file: " +
            locLogo.getSelectedFile().getName());
            selectedImg = locLogo.getSelectedFile().getName();
            File selectedImg = locLogo.getSelectedFile();
              String filepath = selectedImg.getAbsolutePath();
              InputStream inStream = null;
              OutputStream outStream = null;
              
              File dir = new File(System.getProperty("user.home") + "/NPMWare/mailImg/");
                dir.mkdirs();
                
                try{
                    File source =new File(filepath);
                    File dest =new File(System.getProperty("user.home") + "/NPMWare/mailImg/" + selectedImg.getName());
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
            
           }
          
        
              }
    });
        
        JComboBox loc = new JComboBox();
        locMenu locMen = new locMenu();
        loc = locMen.locList();
        c.gridy = 10;
        c.gridx = 1;
        dF.add(loc,c);
        
        
        JCheckBox isMain = new JCheckBox("Email?");
        c.weightx = .5;
        c.gridx = 0;
        c.gridy = 11;
        c.insets = new Insets(20,0,0,0);
        dF.add(isMain,c);
        mainCheck = "Print";
        isMain.addItemListener(new ItemListener()
    {
      public void itemStateChanged(ItemEvent e)
      {
      
        if(e.getStateChange()==1){
            mainCheck="Email";
                }
        else{
            mainCheck="Print";
        }
        
              }
    });
        
        JButton submit = new JButton("Submit");
        c.gridx = 3;
        c.gridy = 12;
        c.insets = new Insets(0,20,0,0);
        dF.add(submit,c);
        
        submit.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
          locMen.getLocation();
          mailer addMail =  new mailer();
          //addMail.Mail_Date = "current_date";
          addMail.Mail_Name = titleIn.getText();
          addMail.Mail_Message = pageContentIn.getText();
          addMail.Mail_Method = mainCheck;
          addMail.Mail_Img = (System.getProperty("user.home") + "/NPMWare/logos/" + selectedImg);
          addMail.Mail_ID = addMail.getNextMailID();
          addMail.Mail_Loc_ID = locMen.selectedID;
          addMail.insertMailer();
        removeAll();
        JLabel webConfirmTitle = new JLabel("Confirm Saved");
        dF.add(webConfirmTitle);
        validate();
        repaint();
        
              }
    });
        
        return dF;
        
        }
}
