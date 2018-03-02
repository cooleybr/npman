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
public class GrantPanel extends JPanel{
        
    public grant grantFunc;

    
    public GrantPanel(){
    
        grantFunc = new grant();
        grantFunc.verifyGrantTable();
    
    setLayout(new BorderLayout());
    JLabel startTitle = new JLabel("Grant Management Center");
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
        
        JButton findGrantsButton = new JButton("Find/Add Grants");
        c.gridx = 0;
        c.gridy = 1;
        menu.add(findGrantsButton,c);
        
        findGrantsButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        
        main.removeAll();
        //WebsitePanel manWebsite = new WebsitePanel();
        JPanel grantSearch = new JPanel();
        grantSearch = new grantSearch();
        main.add(grantSearch,BorderLayout.CENTER);
        main.add(menu,BorderLayout.WEST);
        main.validate();
        main.repaint();
          
        
              }
    });
        
        JButton openGrantsButton = new JButton("View Grants");
        c.gridx = 0;
        c.gridy = 2;
        menu.add(openGrantsButton,c);
        
        openGrantsButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        main.removeAll();
        JPanel allGrants = new JPanel();
        allGrants = new openGrants();
        JScrollPane scroll1 = new JScrollPane(allGrants);
        scroll1.setPreferredSize(new Dimension(400,300));
        main.add(menu,BorderLayout.WEST);
        main.add(scroll1,BorderLayout.CENTER);
        main.validate();
        main.repaint();
        
              }
    });
        
        JButton awardedGrantsButton = new JButton("Awarded");
        c.gridx = 0;
        c.gridy = 3;
        menu.add(awardedGrantsButton,c);
        
        awardedGrantsButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        
        main.removeAll();
        JPanel awards = new JPanel();
        awards = new awardedGrants();
        JScrollPane scroll = new JScrollPane(awards);
        scroll.setPreferredSize(new Dimension(400,300));
        main.add(scroll,BorderLayout.CENTER);
        main.add(menu,BorderLayout.WEST);
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
