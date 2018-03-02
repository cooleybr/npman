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
class locationMenuPanel extends JPanel {

    public locationMenuPanel() {
    
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(175,500));
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
        add(menuTitle,c);
        
        JButton locHomeButton = new JButton("Home");
        c.gridx = 0;
        c.gridy = 1;
        add(locHomeButton,c);
        
        JButton locLocationsButton = new JButton("Locations");
        c.gridx = 0;
        c.gridy = 2;
        add(locLocationsButton,c);
        
        JButton locAddButton = new JButton("Add New");
        c.gridx = 0;
        c.gridy = 3;
        add(locAddButton,c);
        
        JButton locRemoveButton = new JButton("Remove Location");
        c.gridx = 0;
        c.gridy = 4;
        add(locRemoveButton,c);
        
        JLabel locSearchLabel = new JLabel("Search");
        c.gridx = 0;
        c.gridy = 8;
        c.ipady = 10;
        c.insets = new Insets(50,0,0,0);
        locSearchLabel.setVerticalAlignment(JLabel.TOP);
        add(locSearchLabel,c);
        
        c.insets = new Insets(0,0,0,0);
                
        JTextField locSearchField = new JTextField(20);
        c.gridx = 0;
        c.gridy = 9;
        c.ipady = 5;
        add(locSearchField,c);
        
        JButton locSearchButton = new JButton("Find");
        c.gridx = 0;
        c.gridy = 10;
        c.insets = new Insets(10,50,50,0); 
        add(locSearchButton,c);
        
        //button listener
        locHomeButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        
        //locationListPanel locList2 = new locationListPanel();
        //add(locList2,BorderLayout.CENTER);
        //repaint();
          
        
              }
    });

        locSearchButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        System.out.println("Submitted");
        
              }
    });
    
    }
    
}
