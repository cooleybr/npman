/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package npman;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
/**
 *
 * @author brc
 */
public class LocationPanel extends JPanel{
    
    public static LocDBMS locData;
    
    public LocationPanel(){
    
    
    setLayout(new BorderLayout(10,10));
    
     try {
                    
      BufferedImage myPicture = ImageIO.read(new File("./art.png"));
      JLabel logoView = new JLabel(new ImageIcon(myPicture));
      add(logoView,BorderLayout.CENTER);
     
      }
      catch(IOException i ) {
          
       
      }
    
    
    //startTitle.setHorizontalAlignment(JLabel.CENTER);
    //startTitle.setVerticalAlignment(JLabel.TOP);
   
    
    getMenu(this);
    //updatePanel(this);
        
    locData = new LocDBMS();
    locData.OpenDB();
    if (!locData.verifyLocationTable()){
        locData.createLocTable();
    }
    
    }
    
    
    
    public void getMenu(JPanel a){
        JPanel main = a;
        JPanel menu = new JPanel();
        menu.setLayout(new GridBagLayout());
        
        menu.setPreferredSize(new Dimension(175,500));
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 10;
        c.ipadx = 5;
        c.insets = new Insets(0,0,0,0);

        JLabel menuTitle = new JLabel("Menu");
        menuTitle.setHorizontalAlignment(JLabel.LEFT);
        menuTitle.setVerticalAlignment(JLabel.TOP);
        c.gridx = 0;
        c.gridy = 0;
        menu.add(menuTitle,c);
        
        JButton locHomeButton = new JButton("Home");
        c.gridx = 0;
        c.gridy = 1;
        menu.add(locHomeButton,c);
        
        locHomeButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        
        main.removeAll();
        homeSummaryPanel form1 = new homeSummaryPanel();
        JScrollPane scroll = new JScrollPane(form1);
        main.add(scroll,BorderLayout.CENTER);
        main.add(menu,BorderLayout.WEST);
        main.validate();
        main.repaint();
          
        
              }
    });
        
        JButton locLocationsButton = new JButton("Locations");
        c.gridx = 0;
        c.gridy = 2;
        menu.add(locLocationsButton,c);
        
        locLocationsButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        main.removeAll();
        locationListPanel locations = new locationListPanel();
        main.add(menu,BorderLayout.WEST);
        JScrollPane scroll = new JScrollPane(locations);
        main.add(scroll,BorderLayout.CENTER);
        main.validate();
        main.repaint();
        
        
              }
    });
        
        JButton locAddButton = new JButton("Add New");
        c.gridx = 0;
        c.gridy = 3;
        menu.add(locAddButton,c);
        
        locAddButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        
        main.removeAll();
        locationFormPanel form1 = new locationFormPanel();
        //JScrollPane scroll = new JScrollPane(form1);
        main.add(form1,BorderLayout.CENTER);
        main.add(menu,BorderLayout.WEST);
        main.validate();
        main.repaint();
          
        
              }
    });
        
        JButton locRemoveButton = new JButton("Edit/Remove");
        c.gridx = 0;
        c.gridy = 4;
        menu.add(locRemoveButton,c);
        
        locRemoveButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        main.removeAll();
        locationRemPanel locations = new locationRemPanel();
        main.add(menu,BorderLayout.WEST);
        main.add(locations,BorderLayout.CENTER);
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
