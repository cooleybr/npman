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
public class EmployeePanel extends JPanel{
    
    
    public EmployeePanel(){
    
     employee a = new employee();
     a.verifyEmployeeTable();
    
    setLayout(new BorderLayout(10,10));
    JLabel startTitle = new JLabel("Employee/Volunteer Management Center");
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
        
        JButton empViewButton = new JButton("Recent Activity");
        c.gridx = 0;
        c.gridy = 1;
        menu.add(empViewButton,c);
        
        empViewButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        
        main.removeAll();
        empRecPanel recent = new empRecPanel();
        
        main.add(recent,BorderLayout.CENTER);
        //employee b = new employee();
        //b.getEmpDates();
                
        main.add(menu,BorderLayout.WEST);
        main.validate();
        main.repaint();
          
        
              }
    });
        
        JButton volListButton = new JButton("View Personnel");
        c.gridx = 0;
        c.gridy = 2;
        menu.add(volListButton,c);
        
        volListButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        main.removeAll();
        JScrollPane scroll = new JScrollPane();
        employee v = new employee();
        scroll = v.viewEmployeeTable();
        main.add(menu,BorderLayout.WEST);
        main.add(scroll,BorderLayout.CENTER);
        main.validate();
        main.repaint();
        
              }
    });
        
        JButton empAddButton = new JButton("Add New");
        c.gridx = 0;
        c.gridy = 3;
        menu.add(empAddButton,c);
        
        empAddButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        
        main.removeAll();
        empFormPanel empform1 = new empFormPanel();
        main.add(empform1,BorderLayout.CENTER);
        main.add(menu,BorderLayout.WEST);
        main.validate();
        main.repaint();
          
        
              }
    });
        
        JButton empRemoveButton = new JButton("Edit/Remove");
        c.gridx = 0;
        c.gridy = 4;
        menu.add(empRemoveButton,c);
        
        empRemoveButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        main.removeAll();
        employeeRemPanel remove = new employeeRemPanel();
        
        main.add(remove,BorderLayout.CENTER);
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
