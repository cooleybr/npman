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
class addClient extends JPanel {

    public static client toAdd;
    public String selectedValue,selectedMethod,accMark;
    
    public addClient() {
    
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 3;
        //setLayout (new BoxLayout(this, BoxLayout.Y_AXIS));
        //setLayout(new BorderLayout());
           
        
        JLabel title = new JLabel("Add a new Client");
        c.gridx = 0;
        c.gridy = 0;
        add(title,c);
        
        c.insets = new Insets(0,0,0,50);
        
            
        JLabel clientFirstLabel = new JLabel("First Name");
        c.gridx = 0;
        c.gridy = 3;
        add(clientFirstLabel,c);
        
        JTextField first = new JTextField(20);
        c.gridx = 0;
        c.gridy = 4;
        add(first,c);
                
        
        JLabel lastLabel = new JLabel("Last Name");
        c.gridx = 1;
        c.gridy = 3;
        add(lastLabel,c);
        
        JTextField last = new JTextField(20);
        c.gridx = 1;
        c.gridy = 4;
        add(last,c);
                
                
        JLabel add1Label = new JLabel("Street Address");
        c.gridx = 0;
        c.gridy = 5;
        add(add1Label,c);
        
        JTextField add1 = new JTextField(25);
        c.gridx = 0;
        c.gridy = 6;
        add(add1,c);
        
        
        JLabel add2Label = new JLabel("Address Line 2");
        c.gridx = 1;
        c.gridy = 5;
        add(add2Label,c);
        
        JTextField add2 = new JTextField(5);
        c.gridx = 1;
        c.gridy = 6;
        add(add2,c);
        
        
        JLabel cityLabel = new JLabel("City");
        c.gridx = 0;
        c.gridy = 7;
        add(cityLabel,c);
        
        JTextField city = new JTextField(5);
        c.gridx = 0;
        c.gridy = 8;
        add(city,c);
        
        //c.insets = new Insets(0,0,0,0);
        
        JLabel stateLabel = new JLabel("State");
        c.gridx = 1;
        c.gridy = 7;
        add(stateLabel,c);
        
        JComboBox state = new JComboBox();
        stateMenu states = new stateMenu();
        state = states.retStateMenu();
        c.gridx = 1;
        c.gridy = 8;
        add(state,c);
        
        
        JLabel zipLabel = new JLabel("Zip Code");
        c.gridx = 2;
        c.gridy = 7;
        add(zipLabel,c);
        
        JTextField zip = new JTextField(5);
        c.gridx = 2;
        c.gridy = 8;
        add(zip,c);
       
        JLabel phoneLabel = new JLabel("Phone Number");
        c.gridx = 0;
        c.gridy = 9;
        add(phoneLabel,c);
        
        JTextField phone = new JTextField(5);
        c.gridx = 0;
        c.gridy = 10;
        add(phone,c);
               
        JLabel emailLabel = new JLabel("Email Address");
        c.gridx = 1;
        c.gridy = 9;
        add(emailLabel,c);
        
        JTextField email = new JTextField(5);
        c.gridx = 1;
        c.gridy = 10;
        add(email,c);
        
        
        JLabel addDate = new JLabel("Add Date");
        c.gridx = 0;
        c.gridy = 13;
        add(addDate,c);
        
        JTextField aDay = new JTextField("2016-01-15");
        c.gridx = 0;
        c.gridy = 14;
        add(aDay,c);
                
        
        JButton submit = new JButton("Submit");
        c.gridx = 2;
        c.gridy = 14;
        add(submit,c);
        
        c.insets = new Insets(0,0,0,0);
        
        //button listener
        submit.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
          states.getState();
        toAdd = new client();
        toAdd.Client_First = first.getText();
        toAdd.Client_Last = last.getText();
        toAdd.Client_Add1 = add1.getText();
        toAdd.Client_Add2 = add2.getText();
        toAdd.Client_City = city.getText();
        toAdd.Client_State = states.selectedState;
        toAdd.Client_Zip = zip.getText();
        toAdd.Client_Phone = phone.getText();
        toAdd.Client_Email = email.getText();
        toAdd.Client_AddDate = aDay.getText();
                
        removeAll();
        JPanel clientView = toAdd.clientDetailView();
        
        add(clientView);
        
        JButton addVerClient = new JButton("Yes, Add Client");
        c.gridx = 0;
        c.gridy = 10;
        add(addVerClient,c);

        
        JButton dontAddClient = new JButton("No,Return to Form");
        c.gridx = 1;
        c.gridy = 10;
        c.insets = new Insets(0,0,0,0);
        add(dontAddClient,c);
           
        
                
        //button listener
        addVerClient.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
      
        toAdd.insertClientData();
        removeAll();
        JLabel addedNewDonor = new JLabel("New Client Added");
        add(addedNewDonor);
        validate();
        repaint();
        
        
              }
    });
    dontAddClient.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        addClient clientForm = new addClient();
        
        removeAll();
        add(clientForm);
        validate();
        repaint();
        
        
              }
    });
        validate();
        repaint();
              }
    });
    
        
    }
    
}
