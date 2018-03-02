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
public class WebsitePanel extends JPanel{
    
    public website sites;
    
    public WebsitePanel(){
    
    
    setLayout(new BorderLayout());
    JLabel websiteManTitle = new JLabel("Website Management Center");
    websiteManTitle.setHorizontalAlignment(JLabel.CENTER);
    websiteManTitle.setVerticalAlignment(JLabel.TOP);
    add(websiteManTitle,BorderLayout.NORTH);
    
    webPage b = new webPage();
         b.verifyWebTable();
    
    sites = new website();
    JPanel websites = new JPanel();
    websites = sites.viewWebsites();
    JScrollPane scroll = new JScrollPane(websites);
    add(scroll,BorderLayout.CENTER);
    
    
    
    getMenu(this);
    //updatePanel(this);
        
        
    }
    
    
    
    public void getMenu(JPanel a){
        JPanel main = a;
        JPanel menu = new JPanel();
        menu.setLayout(new GridBagLayout());
        
        menu.setPreferredSize(new Dimension(400,50));
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0,0,0,0);
        
        

                
        JButton websiteAdminButton = new JButton("Website Admin");
        c.gridx = 0;
        c.gridy = 0;
        menu.add(websiteAdminButton,c);
        
        websiteAdminButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        
        main.removeAll();
        websiteForm newSite = new websiteForm();
        
        main.add(newSite,BorderLayout.CENTER);
        main.add(menu,BorderLayout.NORTH);
        main.validate();
        main.repaint();
          
        
              }
    });
        
        JButton webPagesButton = new JButton("Web Pages");
        c.gridx = 1;
        c.gridy = 0;
        menu.add(webPagesButton,c);
        
        webPagesButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        main.removeAll();
        webPageForm newPage = new webPageForm();
        JScrollPane scroll = new JScrollPane(newPage);
        main.add(menu,BorderLayout.NORTH);
        main.add(scroll,BorderLayout.CENTER);
        main.validate();
        main.repaint();
        
              }
    });
        
        
       
        /*******************************************************
        JButton webProductsButton = new JButton("Products");
        c.gridx = 3;
        c.gridy = 0;
        menu.add(webProductsButton,c);
        
        webProductsButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        main.removeAll();
        JLabel webProductsTitle = new JLabel("Manage Product Pages");
        main.add(webProductsTitle,BorderLayout.CENTER);
        main.add(menu,BorderLayout.NORTH);
        //main.add(locations,BorderLayout.CENTER);
        main.validate();
        main.repaint();
        
              }
    });
       *******************************************************/ 
        JButton webAnalyticsButton = new JButton("Analytics");
        c.gridx = 3;
        c.gridy = 0;
        menu.add(webAnalyticsButton,c);
        
        webAnalyticsButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        main.removeAll();
                
        //main.add(publish,BorderLayout.CENTER);
        main.add(menu,BorderLayout.NORTH);
        
        //main.add(locations,BorderLayout.CENTER);
        main.validate();
        main.repaint();
        
              }
    });
        
        
        
    
        
        main.add(menu,BorderLayout.NORTH);
        
    }
    
}
