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
/**
 *
 * @author brc
 */
public class webPageForm extends JPanel{
    public String selectedValue,filepath,dirpath;
    public File selectedImg;
    public JComboBox webChooser;
    public website webList;
    public int mainCheck;
    public webPage newPage;
    
        public webPageForm(){
        
        newPage = new webPage();
        newPage.verifyWebTable();
            
        setLayout(new GridBagLayout());
        
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 3;
        c.insets = new Insets(0,0,10,0);
        
        JLabel pageTitle = new JLabel("Page Title");
        c.gridx = 0;
        c.gridy = 2;
        add(pageTitle,c);
        
        JTextField titleIn = new JTextField();
        c.gridx = 1;
        c.gridy = 2;
        c.insets = new Insets(0,0,10,50);
        add(titleIn,c);
        
        JLabel pageDesc = new JLabel("Page Description");
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(0,0,0,0);
        add(pageDesc,c);
        
        JTextField pageDescIn = new JTextField();
        c.gridx = 1;
        c.gridy = 3;
        c.insets = new Insets(0,0,10,0);
        add(pageDescIn,c);
        
        JLabel pageContent = new JLabel("Page Body Content");
        c.gridx = 0;
        c.gridy = 6;
        add(pageContent,c);
        
        JTextArea pageContentIn = new JTextArea("Content Area");
        pageContentIn.setEditable(true);
        pageContentIn.setLineWrap(true);
        pageContentIn.setVisible(true);
        c.insets = new Insets(0,0,10,0);
        c.gridx = 1;
        c.gridy = 6;
        JScrollPane pane = new JScrollPane(pageContentIn);
        pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        pane.setMinimumSize(new Dimension(400,200));
        pane.setPreferredSize(new Dimension(400,200));
        add(pane,c);
        
        

        
        JButton logoChoose = new JButton("Add Image");
        c.gridx = 1;
        c.gridy = 9;
        c.insets = new Insets(0,200,10,0);
        add(logoChoose,c);
        
        selectedImg = new File(System.getProperty("user.home") + "/NPMWare/" + "placeholder.jpg");
        filepath = selectedImg.getAbsolutePath();
        
        logoChoose.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
          JFileChooser siteLogo = new JFileChooser();
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
        
        JLabel webChoose = new JLabel("Which Website");
        c.gridx = 0;
        c.gridy = 10;
        c.insets = new Insets(0,10,0,0);
        add(webChoose,c);
        
        webChooser = new JComboBox();
        websiteMenu sitemenu = new websiteMenu();
        webChooser = sitemenu.websiteList();
        c.gridx = 1;
        c.gridy = 10;
        c.insets = new Insets(0,0,10,0);
        add(webChooser,c);
        
        JLabel parentChoose = new JLabel("Main Link or Choose Parent Page");
        c.gridx = 0;
        c.gridy = 11;
        add(parentChoose,c);
        
        JComboBox isMain = new JComboBox();
        webpageMenu pmen = new webpageMenu();
        isMain = pmen.webpageList();
        c.gridx = 1;
        c.gridy = 11;
        c.insets = new Insets(0,10,10,0);
        add(isMain,c);
        
        
        
        JButton submit = new JButton("Submit");
        c.gridx = 1;
        c.gridy = 12;
        c.insets = new Insets(0,200,0,0);
        add(submit,c);
        
        submit.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
          sitemenu.getWebsite();
          InputStream inStream = null;
              OutputStream outStream = null;
              
              String delims = "[ ]+";
                String[] tokens = sitemenu.selectedSite.split(delims);
                delims = "[.]+";
                String[] tokens2 = tokens[1].split(delims);
                System.out.println(tokens2[1]);
                if(tokens2[0].equalsIgnoreCase("www")){
                File dir = new File(System.getProperty("user.home") + "/NPMWare/websites/" + tokens2[1]);
                dir.mkdirs();
                dirpath = (dir.getPath() + "/");
                }
                else{
                File dir = new File(System.getProperty("user.home") + "/NPMWare/websites/" + tokens2[0]);
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
      
            
        removeAll();
        JLabel webConfirmTitle = new JLabel("Confirm Saved");
        
        pmen.getWebpage();
        newPage.Web_ID = sitemenu.selectedID;
        newPage.Web_Pg_Title = titleIn.getText();
        newPage.Web_Pg_Desc = pageDescIn.getText();
        newPage.Web_Pg_Body = pageContentIn.getText();
        newPage.Web_Pg_Img = dirpath + selectedImg.getName();
        newPage.Web_Pg_Parent = pmen.selectedID;
        
        newPage.insertWebPageData();
        
        add(webConfirmTitle);
        validate();
        repaint();
        
              }
    });
        
        }
    
}
