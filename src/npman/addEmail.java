/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package npman;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author brc
 */
class addEmail extends JPanel {

    public email nAcct;
    public websiteMenu sites;

    
    public addEmail() {
        
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 3;
        c.insets = new Insets(5,5,10,10);
        
        nAcct = new email();
        
        JLabel formTitle = new JLabel("Add Email Account Detail:");
        c.gridy = 1;
        c.gridx = 0;
        add(formTitle,c);
        
                
        JLabel addressT = new JLabel("Email Address:");
        c.gridy = 3;
        c.gridx = 0;
        add(addressT,c);
        
        JTextField address = new JTextField();
        c.gridy = 3;
        c.gridx = 1;
        add(address,c);
        
        JLabel webT = new JLabel("Website");
        c.gridy = 4;
        c.gridx = 0;
        add(webT,c);
        
        JComboBox website = new JComboBox();
        sites = new websiteMenu();
        website = sites.websiteList();
        c.gridy = 4;
        c.gridx = 1;
        add(website,c);
        
               
        JLabel userT = new JLabel("Username");
        c.gridy = 5;
        c.gridx = 0;
        add(userT,c);
        
        JTextField user = new JTextField();
        c.gridy = 5;
        c.gridx = 1;
        add(user,c);
        
        JLabel passT = new JLabel("Password");
        c.gridy = 6;
        c.gridx = 0;
        add(passT,c);
        
                
        JTextField pass = new JTextField();
        c.gridy = 6;
        c.gridx = 1;
        add(pass,c);
        
        JLabel srvrT = new JLabel("SMTP Server");
        c.gridy = 7;
        c.gridx = 0;
        add(srvrT,c);
        
                
        JTextField srvr = new JTextField();
        c.gridy = 7;
        c.gridx = 1;
        add(srvr,c);
               
       
        JButton submit = new JButton("Save");
        c.gridy = 10;
        c.gridx = 2;
        c.insets = new Insets(0,0,0,0);
        add(submit,c);
        
        
        
        submit.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
          sites.getWebsite();
          nAcct.Email_Add = address.getText();
          nAcct.Email_User = user.getText();
          nAcct.Email_Pass = pass.getText();
          nAcct.Web_ID = sites.selectedID;
          nAcct.Email_Srvr = srvr.getText();
          nAcct.insertEmailData();
          
                    
          removeAll();
          validate();
          repaint();
          
          JLabel confirmed = new JLabel("Email added successfully");
          add(confirmed);
        
        
        
              }
    });
        
        
        
        
    }
    
    
        
}
