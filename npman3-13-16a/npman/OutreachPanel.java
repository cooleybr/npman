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
public class OutreachPanel extends JPanel{
    
    public service nserv;
    public project nproj;
    
    public OutreachPanel(){
    
    nserv = new service();
    nserv.verifyServiceTable();
    
    nproj = new project();
    nproj.verifyProjectTable();
    setLayout(new BorderLayout());
    JLabel startTitle = new JLabel("Outreach Management Center");
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
        
        menu.setPreferredSize(new Dimension(125,500));
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 3;
        
        c.insets = new Insets(0,0,0,0);

        JLabel menuTitle = new JLabel("Menu");
        menuTitle.setHorizontalAlignment(JLabel.LEFT);
        menuTitle.setVerticalAlignment(JLabel.TOP);
        c.gridx = 0;
        c.gridy = 0;
        menu.add(menuTitle,c);
        
        JButton viewServButton = new JButton("View Services");
        c.gridx = 0;
        c.gridy = 1;
        menu.add(viewServButton,c);
        
        viewServButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        
        main.removeAll();
        JPanel service = new JPanel();
        service = new viewService();
        JScrollPane scroll = new JScrollPane(service);
        main.add(scroll,BorderLayout.CENTER);
        main.add(menu,BorderLayout.WEST);
        main.validate();
        main.repaint();
          
        
              }
    });
        
        JButton serviceButton = new JButton("Add Service");
        c.gridx = 0;
        c.gridy = 2;
        menu.add(serviceButton,c);
        
        serviceButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        
        main.removeAll();
        JPanel service = new JPanel();
        service = new serviceForm();
        main.add(service,BorderLayout.CENTER);
        main.add(menu,BorderLayout.WEST);
        main.validate();
        main.repaint();
          
        
              }
    });
        
        
        
        JButton viewProjects = new JButton("View Projects");
        c.gridx = 0;
        c.gridy = 3;
        menu.add(viewProjects,c);
        
        viewProjects.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        
        main.removeAll();
        //MailerPanel manMailer = new MailerPanel();
        JPanel projView = new JPanel();
        projView = new projectView();
        JScrollPane scroll = new JScrollPane(projView);
        main.add(scroll,BorderLayout.CENTER);
        main.add(menu,BorderLayout.WEST);
        main.validate();
        main.repaint();
          
        
              }
    });
        
        JButton projectButton = new JButton("Add Project");
        c.gridx = 0;
        c.gridy = 4;
        menu.add(projectButton,c);
        
        projectButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        main.removeAll();
        JPanel projects = new JPanel();
        projects = new projectForm();
        main.add(menu,BorderLayout.WEST);
        main.add(projects,BorderLayout.CENTER);
        main.validate();
        main.repaint();
        
              }
    });
        
        JButton clientsButton = new JButton("View Clients");
        c.gridx = 0;
        c.gridy = 5;
        menu.add(clientsButton,c);
        
        clientsButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        main.removeAll();
        client nC = new client();
        nC.verifyClientTable();
        JPanel vC = nC.viewClientData();
        main.add(vC,BorderLayout.CENTER);
        main.add(menu,BorderLayout.WEST);
        //main.add(locations,BorderLayout.CENTER);
        main.validate();
        main.repaint();
        
              }
    });
        
         JButton addClientButton = new JButton("Add Clients");
        c.gridx = 0;
        c.gridy = 6;
        menu.add(addClientButton,c);
        
        addClientButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        main.removeAll();
        client nC = new client();
        nC.verifyClientTable();
        JPanel vC = new addClient();
        main.add(vC,BorderLayout.CENTER);
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
