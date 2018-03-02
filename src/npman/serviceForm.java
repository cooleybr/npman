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
class serviceForm extends JPanel {

    public service nserv;
    
    
    public serviceForm() {
    
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 3;
        c.insets = new Insets(5,5,10,10);
        
        nserv = new service();
        
        JLabel formTitle = new JLabel("Add Service");
        c.gridy = 1;
        c.gridx = 0;
        add(formTitle,c);
        
        JLabel servType = new JLabel("Service Type");
        c.gridy = 2;
        c.gridx = 0;
        add(servType,c);
        
        JComboBox services = new JComboBox();
        servMenu menu = new servMenu();
        services = menu.servList();
        c.gridy = 2;
        c.gridx = 1;
        add(services,c);
        
        JLabel employee = new JLabel("Employee");
        c.gridy = 3;
        c.gridx = 0;
        add(employee,c);
        
        JComboBox employees = new JComboBox();
        empMenu emenu = new empMenu();
        employees = emenu.empList();
        c.gridy = 3;
        c.gridx = 1;
        add(employees,c);
        
        JLabel grant = new JLabel("Grant");
        c.gridy = 4;
        c.gridx = 0;
        add(grant,c);
        
        JComboBox gbox = new JComboBox();
        grantMenu grants = new grantMenu();
        gbox = grants.grantList();
        c.gridy = 5;
        c.gridx = 0;
        add(gbox,c);
        
        JLabel projLab = new JLabel("Project");
        c.gridy = 4;
        c.gridx = 1;
        add(projLab,c);
        
        JComboBox proj = new JComboBox();
        projectMenu projects = new projectMenu();
        proj = projects.projList();
        c.gridy = 5;
        c.gridx = 1;
        add(proj,c);
        
        JLabel descLab = new JLabel("Description");
        c.gridy = 6;
        c.gridx = 0;
        add(descLab,c);
        
        JTextArea description = new JTextArea();
        description.setPreferredSize(new Dimension(100,50));
        c.gridy = 6;
        c.gridx = 1;
        add(description,c);
        
        JLabel monLab = new JLabel("Monetary Value");
        c.gridy = 9;
        c.gridx = 0;
        add(monLab,c);
        
        JTextField monVal = new JTextField("0.00");
        c.gridy = 10;
        c.gridx = 0;
        add(monVal,c);
        
        JLabel hourLab = new JLabel("Applied Hours");
        c.gridy = 9;
        c.gridx = 1;
        add(hourLab,c);
        
        JTextField hours = new JTextField("1");
        c.gridy = 10;
        c.gridx = 1;
        add(hours,c);
        
        JLabel dateLab = new JLabel("Service Date");
        c.gridy = 11;
        c.gridx = 1;
        add(dateLab,c);
        
        JTextField date = new JTextField("2016-01-15");
        c.gridy = 12;
        c.gridx = 1;
        add(date,c);
        
       
        JButton submit = new JButton("Save");
        c.gridy = 13;
        c.gridx = 1;
        c.insets = new Insets(10,0,0,0);
        add(submit,c);
        
        
        
        submit.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
          emenu.getEmployee();
          grants.getGrant();
          menu.getService();
          projects.getProject();
          nserv.Serv_Type = menu.selectedServ;
          nserv.Serv_Desc = description.getText();
          nserv.Serv_Emp_ID = emenu.selectedID;
          nserv.Serv_Grant_ID = grants.selectedID;
          nserv.Serv_Hours = Double.parseDouble(hours.getText());
          nserv.Serv_Mon_Val = Double.parseDouble(monVal.getText());
          nserv.Serv_Proj_ID = projects.selectedID;
          nserv.Serv_Date = date.getText();
          nserv.insertServiceData();
          System.out.println(nserv.Serv_Date);
          removeAll();
          validate();
          repaint();
          
          JLabel confirmed = new JLabel("Service added successfully");
          add(confirmed);
        
        
        
              }
    });
        
        
        
        
    }
    
}
