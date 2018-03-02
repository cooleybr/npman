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
public class InsightPanel extends JPanel{
    
    
    public InsightPanel(){
    
    
    setLayout(new BorderLayout());
    JLabel startTitle = new JLabel("Insight Management Center");
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
        
        JButton industryInsButton = new JButton("Industry Stats");
        c.gridx = 0;
        c.gridy = 1;
        menu.add(industryInsButton,c);
        
        industryInsButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        
        main.removeAll();
        //WebsitePanel manWebsite = new WebsitePanel();
        JLabel industryInsTitle = new JLabel("Industry Trends and Statistics");
        main.add(industryInsTitle,BorderLayout.CENTER);
        main.add(menu,BorderLayout.WEST);
        main.validate();
        main.repaint();
          
        
              }
    });
        
        JButton nicheInsButton = new JButton("Niche Stats");
        c.gridx = 0;
        c.gridy = 2;
        menu.add(nicheInsButton,c);
        
        nicheInsButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        main.removeAll();
        //EmailPanel manEmail = new EmailPanel();
        JLabel nicheInsTitle = new JLabel("Trends and stats for organizations like yours");
        main.add(menu,BorderLayout.WEST);
        main.add(nicheInsTitle,BorderLayout.CENTER);
        main.validate();
        main.repaint();
        
              }
    });
        
        JButton geographicInsButton = new JButton("Geographic");
        c.gridx = 0;
        c.gridy = 3;
        menu.add(geographicInsButton,c);
        
        geographicInsButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        
        main.removeAll();
        //MailerPanel manMailer = new MailerPanel();
        JLabel geographicInsTitle = new JLabel("Trends and stats in your geographic region");
        main.add(geographicInsTitle,BorderLayout.CENTER);
        main.add(menu,BorderLayout.WEST);
        main.validate();
        main.repaint();
          
        
              }
    });
        
        JButton demographicInsButton = new JButton("Demographics");
        c.gridx = 0;
        c.gridy = 4;
        menu.add(demographicInsButton,c);
        
        demographicInsButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        main.removeAll();
        //EventPanel manEvents = new EventPanel();
        JLabel demographicInsTitle = new JLabel("Demographic trends and stats");
        main.add(demographicInsTitle,BorderLayout.CENTER);
        main.add(menu,BorderLayout.WEST);
        //main.add(locations,BorderLayout.CENTER);
        main.validate();
        main.repaint();
        
              }
    });
        
        JButton marketingInsButton = new JButton("Marketing Trends");
        c.gridx = 0;
        c.gridy = 5;
        menu.add(marketingInsButton,c);
        
        marketingInsButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        main.removeAll();
        //EventPanel manEvents = new EventPanel();
        JLabel marketingInsTitle = new JLabel("Marketing Trends and Stats");
        main.add(marketingInsTitle,BorderLayout.CENTER);
        main.add(menu,BorderLayout.WEST);
        //main.add(locations,BorderLayout.CENTER);
        main.validate();
        main.repaint();
        
              }
    });
        
        JButton suggestionInsButton = new JButton("Opportunities");
        c.gridx = 0;
        c.gridy = 6;
        menu.add(suggestionInsButton,c);
        
        suggestionInsButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        main.removeAll();
        //EventPanel manEvents = new EventPanel();
        JLabel suggestionInsTitle = new JLabel("Opportunities to drive growth and reduce costs");
        main.add(suggestionInsTitle,BorderLayout.CENTER);
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
