/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package npman;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
/**
 *
 * @author brc
 */
public class DonorPanel extends JPanel{
    
        
    public DonorPanel(){
    
     Donor a = new Donor();
     a.verifyDonorTable();
     donation b = new donation();
     b.verifyDonationTable();
     
    setLayout(new BorderLayout(10,10));
    JLabel startTitle = new JLabel("Donor Management Center");
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
        
        JButton donorViewButton = new JButton("View Donors");
        c.gridx = 0;
        c.gridy = 1;
        menu.add(donorViewButton,c);
        
        donorViewButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        
        main.removeAll();
        donorListPanel donors = new donorListPanel();
        JScrollPane scroll = new JScrollPane(donors);
        main.add(menu,BorderLayout.WEST);
        main.add(scroll,BorderLayout.CENTER);
        main.validate();
        main.repaint();
          
        
              }
    });
        
        JButton addDonorButton = new JButton("Add Donors");
        c.gridx = 0;
        c.gridy = 2;
        menu.add(addDonorButton,c);
        
        addDonorButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        
        main.removeAll();
        donorFormPanel donorForm1 = new donorFormPanel();
        main.add(donorForm1,BorderLayout.CENTER);
        main.add(menu,BorderLayout.WEST);
        main.validate();
        main.repaint();
              }
    });
        
        JButton newDonation = new JButton("New Donation");
        c.gridx = 0;
        c.gridy = 3;
        menu.add(newDonation,c);
        
        newDonation.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        
        main.removeAll();
        donationForm getDonation = new donationForm();
        main.add(getDonation,BorderLayout.CENTER);
        main.add(menu,BorderLayout.WEST);
        main.validate();
        main.repaint();
              }
    });
        
        JButton removeDonorButton = new JButton("Edit/Remove Donor");
        c.gridx = 0;
        c.gridy = 4;
        menu.add(removeDonorButton,c);
        
        removeDonorButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        
        main.removeAll();
        editDonorPanel toEdit = new editDonorPanel();
        main.add(menu,BorderLayout.WEST);
        main.add(toEdit,BorderLayout.CENTER);
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
