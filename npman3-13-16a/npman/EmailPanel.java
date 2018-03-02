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
public class EmailPanel extends JPanel{
    
    
    public EmailPanel(){
    
    
    setLayout(new BorderLayout(10,10));
    JLabel emailManTitle = new JLabel("Email Management Center");
    emailManTitle.setHorizontalAlignment(JLabel.CENTER);
    emailManTitle.setVerticalAlignment(JLabel.TOP);
    add(emailManTitle,BorderLayout.NORTH);
    
    getMenu(this);
    //updatePanel(this);
        
        
    }
    
    
    
    public void getMenu(JPanel a){
        JPanel main = a;
        JPanel menu = new JPanel();
        menu.setLayout(new GridBagLayout());
        
        menu.setPreferredSize(new Dimension(500,175));
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 10;
        c.ipadx = 20;
        c.insets = new Insets(0,0,0,0);

                
        JButton emailAdminButton = new JButton("Email Admin");
        c.gridx = 0;
        c.gridy = 0;
        menu.add(emailAdminButton,c);
        
        emailAdminButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        
        main.removeAll();
        JLabel emailAdminTitle = new JLabel("Email Administration Details");
        main.add(emailAdminTitle,BorderLayout.CENTER);
        main.add(menu,BorderLayout.NORTH);
        main.validate();
        main.repaint();
          
        
              }
    });
        
        JButton newEmailButton = new JButton("New Email");
        c.gridx = 1;
        c.gridy = 0;
        menu.add(newEmailButton,c);
        
        newEmailButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        main.removeAll();
        JLabel newEmailTitle = new JLabel("Compose a new email");
        main.add(menu,BorderLayout.NORTH);
        main.add(newEmailTitle,BorderLayout.CENTER);
        main.validate();
        main.repaint();
        
              }
    });
        
        JButton emailListButton = new JButton("Lists");
        c.gridx = 2;
        c.gridy = 0;
        menu.add(emailListButton,c);
        
        emailListButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        
        main.removeAll();
        JLabel emailListTitle = new JLabel("Manage Email Recipients");
//empFormPanel empform1 = new empFormPanel();
        main.add(emailListTitle,BorderLayout.CENTER);
        main.add(menu,BorderLayout.NORTH);
        main.validate();
        main.repaint();
          
        
              }
    });
        
        JButton emailScheduleButton = new JButton("Scheduling");
        c.gridx = 3;
        c.gridy = 0;
        menu.add(emailScheduleButton,c);
        
        emailScheduleButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        main.removeAll();
        JLabel emailScheduleTitle = new JLabel("Schedule Email Campaigns");
        main.add(emailScheduleTitle,BorderLayout.CENTER);
        main.add(menu,BorderLayout.NORTH);
        //main.add(locations,BorderLayout.CENTER);
        main.validate();
        main.repaint();
        
              }
    });
        
        JButton emailAnalyticsButton = new JButton("Email Analytics");
        c.gridx = 4;
        c.gridy = 0;
        menu.add(emailAnalyticsButton,c);
        
        emailAnalyticsButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        main.removeAll();
        JLabel emailAnalyticsTitle = new JLabel("Email Analytics");
        main.add(emailAnalyticsTitle,BorderLayout.CENTER);
        main.add(menu,BorderLayout.NORTH);
        
        //main.add(locations,BorderLayout.CENTER);
        main.validate();
        main.repaint();
        
              }
    });
        
        
        
    
        
        main.add(menu,BorderLayout.NORTH);
        
    }
    
}
