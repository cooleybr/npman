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
class addGrant extends JPanel {

    public grant toAdd;
    public empMenu menu;
    
    
    public addGrant() {
    
        setLayout(new GridBagLayout());
        
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 3;
        c.ipadx = 15;
       
        
        
        
        
        JLabel grantFormLabel = new JLabel("Add grant detail");
        c.gridx = 0;
        c.gridy = 0;
        add(grantFormLabel,c);
        
        JLabel grantOrgLabel = new JLabel("Grant Organization");
        c.gridx = 0;
        c.gridy = 1;
        add(grantOrgLabel,c);
        
        JTextField grantOrg = new JTextField(25);
        c.gridx = 0;
        c.gridy = 2;
        add(grantOrg,c);
        
       JLabel grantNameTitle = new JLabel("Grant Name");
        c.gridx = 1;
        c.gridy = 1;
        
        add(grantNameTitle,c);
        
        JTextField grantName = new JTextField(20);
        c.gridx = 1;
        c.gridy = 2;
        add(grantName,c);
        
        JLabel grantRefTitle = new JLabel("Grant Reference ID");
        c.gridx = 2;
        c.gridy = 1;
        add(grantRefTitle,c);
        
        JTextField grantRef = new JTextField(20);
        c.gridx = 2;
        c.gridy = 2;
        add(grantRef,c);
                    
        JLabel grantDescLabel = new JLabel("Grant Description");
        c.gridx = 0;
        c.gridy = 3;
        add(grantDescLabel,c);
        
        JTextArea grantDesc = new JTextArea();
        grantDesc.setEditable(true);
        grantDesc.setLineWrap(true);
        grantDesc.setVisible(true);
        JScrollPane pane = new JScrollPane(grantDesc);
        grantDesc.setMinimumSize(new Dimension(150,65));
        grantDesc.setPreferredSize(new Dimension(150,65));
        pane.setMinimumSize(new Dimension(150,65));
        pane.setPreferredSize(new Dimension(150,65));
        
        c.gridx = 0;
        c.gridy = 4;
        add(pane,c);
             
        JLabel grantDueLabel = new JLabel("Due Date");
        c.gridx = 0;
        c.gridy = 7;
        add(grantDueLabel,c);
        
        JTextField grantDue = new JTextField("2016-01-31");
        c.gridx = 0;
        c.gridy = 8;
        add(grantDue,c);
        
        JLabel grantPostLabel = new JLabel("Posted Date");
        c.gridx = 1;
        c.gridy = 7;
        add(grantPostLabel,c);
        
        JTextField grantPost = new JTextField("2016-01-31");
        c.gridx = 1;
        c.gridy = 8;
        add(grantPost,c);
        
        JLabel grantAmtLabel = new JLabel("Amount");
        c.gridx = 2;
        c.gridy = 7;
        add(grantAmtLabel,c);
        
        JTextField grantAmt = new JTextField("10000.00");
        c.gridx = 2;
        c.gridy = 8;
        add(grantAmt,c);
        
        JLabel grantEmpLabel = new JLabel("Added By:");
        c.gridx = 0;
        c.gridy = 9;
        add(grantEmpLabel,c);     
                
        JComboBox empMenu = new JComboBox();
        menu = new empMenu();
        empMenu = menu.empList();
        c.gridy = 10;
        c.gridx = 0;
        add(empMenu,c);
        
        
        JButton submit = new JButton("Submit");
        c.gridx = 2;
        c.gridy = 13;
        add(submit,c);
        
        c.insets = new Insets(0,0,0,0);
        
        //button listener
        submit.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        menu.getEmployee();
        toAdd = new grant();
        toAdd.Grant_Name = grantName.getText();
        toAdd.Grant_Ref_Num = grantRef.getText();
        toAdd.Grant_Desc = grantDesc.getText();
        toAdd.Grant_Org = grantOrg.getText();
        toAdd.Grant_Due_Date = grantDue.getText();
        toAdd.Grant_Posted_Date = grantPost.getText();
        toAdd.Grant_Amount = Double.parseDouble(grantAmt.getText());
        toAdd.Grant_Emp_ID = menu.selectedID;
        
        toAdd.insertGrantData();
                     
        removeAll();
        JLabel grantConf = new JLabel("Grant Info Added");
        add(grantConf);
        
        validate();
        repaint();
              }
    });
    
        
    }
    
}
