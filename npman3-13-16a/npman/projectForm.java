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
class projectForm extends JPanel {

    public project nproj;
    public grantMenu grants;

    
    public projectForm() {
        
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 3;
        c.insets = new Insets(5,5,10,10);
        
        nproj = new project();
        
        JLabel formTitle = new JLabel("Add Project Detail:");
        c.gridy = 1;
        c.gridx = 0;
        add(formTitle,c);
        
                
        JLabel employee = new JLabel("Project Lead:");
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
        c.gridy = 4;
        c.gridx = 1;
        add(gbox,c);
        
        
        JLabel titleLab = new JLabel("Title");
        c.gridy = 5;
        c.gridx = 0;
        add(titleLab,c);
        
        JTextField title = new JTextField();
        c.gridy = 5;
        c.gridx = 1;
        add(title,c);
        
        JLabel descLab = new JLabel("Description");
        c.gridy = 7;
        c.gridx = 0;
        add(descLab,c);
        
        JTextArea description = new JTextArea();
        description.setPreferredSize(new Dimension(100,50));
        c.gridy = 7;
        c.gridx = 1;
        add(description,c);
        
        JLabel monLab = new JLabel("Alotted Funds");
        c.gridy = 9;
        c.gridx = 0;
        add(monLab,c);
        
        JTextField monVal = new JTextField("0.00");
        c.gridy = 10;
        c.gridx = 0;
        add(monVal,c);
        
        JLabel hourLab = new JLabel("Allotted Hours");
        c.gridy = 9;
        c.gridx = 1;
        add(hourLab,c);
        
        JTextField hours = new JTextField("1");
        c.gridy = 10;
        c.gridx = 1;
        add(hours,c);
        
       
        JButton submit = new JButton("Save");
        c.gridy = 11;
        c.gridx = 1;
        c.insets = new Insets(10,0,0,0);
        add(submit,c);
        
        
        
        submit.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
          emenu.getEmployee();
          grants.getGrant();
          
          nproj.Proj_Emp_ID = emenu.selectedID;
          nproj.Proj_Grant_ID = grants.selectedID;
          nproj.Proj_Start = "current_date";
          nproj.Proj_End = "null";
          nproj.Proj_Title = title.getText();
          nproj.Proj_Desc = description.getText();
          nproj.Proj_Req_Hours = Double.parseDouble(hours.getText());
          nproj.Proj_Req_Funds = Double.parseDouble(monVal.getText());
       
          
          nproj.insertProjectData();
          
          removeAll();
          validate();
          repaint();
          
          JLabel confirmed = new JLabel("Project added successfully");
          add(confirmed);
        
        
        
              }
    });
        
        
        
        
    }
    
    public JPanel projectGForm(int gid) {
        
        JPanel pF = new JPanel();
        pF.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 3;
        
        
        nproj = new project();
        nproj.Proj_Grant_ID = gid;
        
        JLabel formTitle = new JLabel("Add Project Detail:");
        c.gridy = 1;
        c.gridx = 0;
        pF.add(formTitle,c);
        
                
        JLabel employee = new JLabel("Project Lead:");
        c.gridy = 3;
        c.gridx = 0;
        pF.add(employee,c);
        
        JComboBox employees = new JComboBox();
        empMenu emenu = new empMenu();
        employees = emenu.empList();
        c.gridy = 3;
        c.gridx = 1;
        pF.add(employees,c);
        
        JLabel grant = new JLabel("Grant");
        c.gridy = 4;
        c.gridx = 0;
        pF.add(grant,c);
        
        JComboBox gbox = new JComboBox();
        grantMenu grants = new grantMenu();
        gbox = grants.grantList();
        
        grants.setSelectedGrant(nproj.Proj_Grant_ID);
        
        c.gridy = 4;
        c.gridx = 1;
        pF.add(gbox,c);
        
        
        JLabel titleLab = new JLabel("Title");
        c.gridy = 5;
        c.gridx = 0;
        pF.add(titleLab,c);
        
        JTextField title = new JTextField();
        c.gridy = 5;
        c.gridx = 1;
        pF.add(title,c);
        
        JLabel descLab = new JLabel("Description");
        c.gridy = 7;
        c.gridx = 0;
        pF.add(descLab,c);
        
        JTextArea description = new JTextArea();
        description.setPreferredSize(new Dimension(100,20));
        c.gridy = 7;
        c.gridx = 1;
        pF.add(description,c);
        
        JLabel monLab = new JLabel("Alotted Funds");
        c.gridy = 9;
        c.gridx = 0;
        pF.add(monLab,c);
        
        JTextField monVal = new JTextField("0.00");
        c.gridy = 10;
        c.gridx = 0;
        pF.add(monVal,c);
        
        JLabel hourLab = new JLabel("Allotted Hours");
        c.gridy = 9;
        c.gridx = 1;
        pF.add(hourLab,c);
        
        JTextField hours = new JTextField("1");
        c.gridy = 10;
        c.gridx = 1;
        pF.add(hours,c);
        
       
        JButton submit = new JButton("Save");
        c.gridy = 11;
        c.gridx = 1;
        c.insets = new Insets(10,0,0,0);
        pF.add(submit,c);
        
        
        
        submit.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
          emenu.getEmployee();
          grants.getGrant();
          
          nproj.Proj_Emp_ID = emenu.selectedID;
          nproj.Proj_Grant_ID = grants.selectedID;
          nproj.Proj_Start = "current_date";
          nproj.Proj_End = "null";
          nproj.Proj_Title = title.getText();
          nproj.Proj_Desc = description.getText();
          nproj.Proj_Req_Hours = Double.parseDouble(hours.getText());
          nproj.Proj_Req_Funds = Double.parseDouble(monVal.getText());
       
          
          nproj.insertProjectData();
          
          pF.removeAll();
          pF.validate();
          pF.repaint();
          
          JLabel confirmed = new JLabel("Project added successfully");
          pF.add(confirmed);
        
        
        
              }
    });
        
        
        return pF;
        
    }
        
}
