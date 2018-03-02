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
public class MailerPanel extends JPanel{
    
    public mailer a;
    
    public MailerPanel(){
    
    a = new mailer();
    a.verifyMailerTable();
    
    setLayout(new BorderLayout(10,10));
    JPanel view = new JPanel();
    view =  a.viewMailerTable();
    JScrollPane scroll = new JScrollPane(view);
    add(scroll,BorderLayout.CENTER);
    
    
    getMenu(this);
    //updatePanel(this);
        
        
    }
    
    
    
    public void getMenu(JPanel a){
        JPanel main = a;
        JPanel menu = new JPanel();
        menu.setLayout(new GridBagLayout());
        
        menu.setPreferredSize(new Dimension(500,50));
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 10;
        c.ipadx = 20;
        c.insets = new Insets(0,0,0,0);

                
        JButton mailerAdminButton = new JButton("Mailer Admin");
        c.gridx = 0;
        c.gridy = 0;
        menu.add(mailerAdminButton,c);
        
        mailerAdminButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        
        main.removeAll();
        emailAdmin admin = new emailAdmin();
        main.add(admin,BorderLayout.CENTER);
        main.add(menu,BorderLayout.NORTH);
        main.validate();
        main.repaint();
          
        
              }
    });
        
        JButton newMailerButton = new JButton("New Mailer");
        c.gridx = 1;
        c.gridy = 0;
        menu.add(newMailerButton,c);
        
        newMailerButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        main.removeAll();
        JPanel mailForm = new mailerForm();
        main.add(menu,BorderLayout.NORTH);
        main.add(mailForm,BorderLayout.CENTER);
        main.validate();
        main.repaint();
        
              }
    });
        
        JButton mailerListButton = new JButton("Recipients");
        c.gridx = 2;
        c.gridy = 0;
        menu.add(mailerListButton,c);
        
        mailerListButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        
        main.removeAll();
        JPanel recips = new JPanel();
        mailer b = new mailer();
        recips = b.mailRecipientPane();
        JScrollPane pane = new JScrollPane(recips);
        
        main.add(pane,BorderLayout.CENTER);
        main.add(menu,BorderLayout.NORTH);
        main.validate();
        main.repaint();
          
        
              }
    });
        
        
        
        
        
    
        
        main.add(menu,BorderLayout.NORTH);
        
    }
    
}
