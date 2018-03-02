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
public class ReportPanel extends JPanel{
    
    
    public ReportPanel(){
    
    
    setLayout(new BorderLayout());
    JLabel startTitle = new JLabel("Report Management Center");
    startTitle.setHorizontalAlignment(JLabel.CENTER);
    startTitle.setVerticalAlignment(JLabel.TOP);
    add(startTitle,BorderLayout.NORTH);
    
    getMenu(this);
    //updatePanel(this);
        
        
    }
    
    
    
    public void getMenu(JPanel a){
        JPanel main = a;
        JPanel menu = new JPanel();
        menu.setLayout(new GridBagLayout());
        
        menu.setPreferredSize(new Dimension(175,500));
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 10;
        c.ipadx = 20;
        c.insets = new Insets(0,0,0,0);

        JLabel menuTitle = new JLabel("Menu");
        menuTitle.setHorizontalAlignment(JLabel.LEFT);
        menuTitle.setVerticalAlignment(JLabel.TOP);
        c.gridx = 0;
        c.gridy = 0;
        menu.add(menuTitle,c);
        
        
        
        JButton laborRepButton = new JButton("Labor Summary");
        c.gridx = 0;
        c.gridy = 2;
        menu.add(laborRepButton,c);
        
        laborRepButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        main.removeAll();
        //EmailPanel manEmail = new EmailPanel();
        JPanel laborRep = new JPanel();
        laborRep = new labor30Sum();
        main.add(menu,BorderLayout.WEST);
        main.add(laborRep,BorderLayout.CENTER);
        main.validate();
        main.repaint();
        
              }
    });
        
        JButton donorRepButton = new JButton("Donor Summary");
        c.gridx = 0;
        c.gridy = 3;
        menu.add(donorRepButton,c);
        
        donorRepButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        
        main.removeAll();
        //MailerPanel manMailer = new MailerPanel();
        JPanel donSum = new JPanel();
        donor30Sum last30 = new donor30Sum();
        donSum = last30;
        JScrollPane scroll = new JScrollPane(donSum);
        main.add(scroll,BorderLayout.CENTER);
        main.add(menu,BorderLayout.WEST);
        main.validate();
        main.repaint();
          
        
              }
    });
        
        JButton marketingRepButton = new JButton("Marketing Summary");
        c.gridx = 0;
        c.gridy = 4;
        menu.add(marketingRepButton,c);
        
        marketingRepButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        main.removeAll();
        //EventPanel manEvents = new EventPanel();
        JLabel marketingRepTitle = new JLabel("Marketing Summary");
        main.add(marketingRepTitle,BorderLayout.CENTER);
        main.add(menu,BorderLayout.WEST);
        //main.add(locations,BorderLayout.CENTER);
        main.validate();
        main.repaint();
        
              }
    });
        
        JButton grantRepButton = new JButton("Grant Summary");
        c.gridx = 0;
        c.gridy = 5;
        menu.add(grantRepButton,c);
        
        grantRepButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        main.removeAll();
        //EventPanel manEvents = new EventPanel();
        JLabel grantRepTitle = new JLabel("Grant Summary");
        main.add(grantRepTitle,BorderLayout.CENTER);
        main.add(menu,BorderLayout.WEST);
        //main.add(locations,BorderLayout.CENTER);
        main.validate();
        main.repaint();
        
              }
    });
        
        JButton outreachRepButton = new JButton("Outreach Summary");
        c.gridx = 0;
        c.gridy = 6;
        menu.add(outreachRepButton,c);
        
        outreachRepButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        main.removeAll();
        //EventPanel manEvents = new EventPanel();
        JLabel outreachRepTitle = new JLabel("Outreach Summary");
        main.add(outreachRepTitle,BorderLayout.CENTER);
        main.add(menu,BorderLayout.WEST);
        //main.add(locations,BorderLayout.CENTER);
        main.validate();
        main.repaint();
        
              }
    });
        JLabel searchLabel = new JLabel("Search");
        c.gridx = 0;
        c.gridy = 8;
        c.ipady = 10;
        c.insets = new Insets(50,0,0,0);
        searchLabel.setVerticalAlignment(JLabel.TOP);
        menu.add(searchLabel,c);
        
        c.insets = new Insets(0,0,0,0);
                
        JTextField searchField = new JTextField(20);
        c.gridx = 0;
        c.gridy = 9;
        c.ipady = 5;
        menu.add(searchField,c);
        
        JButton search = new JButton("Find");
        c.gridx = 0;
        c.gridy = 10;
        c.insets = new Insets(10,50,50,0); 
        menu.add(search,c);
        
        //button listener
        
        
        

        search.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        
        JPanel searchResults = new JPanel();
        searchPanel q = new searchPanel();
        searchResults = q;
        q.query = searchField.getText();
        q.getResults();
        JScrollPane scroll = new JScrollPane(searchResults);
        main.removeAll();
        main.add(menu,BorderLayout.WEST);
        main.add(scroll,BorderLayout.CENTER);
        main.revalidate();
        main.repaint();
        
              }
    });
    
        
        main.add(menu,BorderLayout.WEST);
        
    }
    
}
