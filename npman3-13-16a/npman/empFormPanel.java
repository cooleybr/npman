/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package npman;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author brc
 */



class empFormPanel extends JPanel {

    public String selectedValue,selectedLocation;
    public String isVolunteer;
    public static LocDBMS locData;
    
    public empFormPanel() {
    
        setLayout(new GridBagLayout());
        this.setMaximumSize(new Dimension(400,300));
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.ipady = 3;
        //setLayout (new BoxLayout(this, BoxLayout.Y_AXIS));
        //setLayout(new BorderLayout());
           
        
        JLabel empFormLabel = new JLabel("Add a new employee/volunteer");
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0,50,25,0);
        add(empFormLabel,c);
        
        c.insets = new Insets(0,0,0,0);
        
        JLabel empFNameLabel = new JLabel("First Name");
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(0,0,0,750);
        add(empFNameLabel,c);
        
        JTextField empFName = new JTextField();
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(0,0,0,750);
        add(empFName,c);
                
        c.insets = new Insets(0,0,0,0);   
        
        JLabel empLNameLabel = new JLabel("Last Name");
        c.gridx = 0;
        c.insets = new Insets(0,300,0,500);
        c.gridy = 1;
        add(empLNameLabel,c);
        
        JTextField empLName = new JTextField();
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(0,300,0,500);
        add(empLName,c);
            
        c.ipadx = 0;
        c.insets = new Insets(0,0,0,0); 
                
        JLabel empAdd1Label = new JLabel("Street Address");
        c.gridx = 0;
        c.gridy = 3;
        add(empAdd1Label,c);
        
        JTextField empAdd1 = new JTextField();
        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(0,0,0,350);
        add(empAdd1,c);
        
        
        JLabel empAdd2Label = new JLabel("Address Line 2");
        c.gridx = 0;
        c.gridy = 5;
        add(empAdd2Label,c);
        
        JTextField empAdd2 = new JTextField();
        c.gridx = 0;
        c.gridy = 6;
        c.insets = new Insets(0,0,0,350);
        add(empAdd2,c);
        
        
        JLabel empCityLabel = new JLabel("City");
        c.gridx = 0;
        c.gridy = 7;
        add(empCityLabel,c);
        
        JTextField empCity = new JTextField();
        c.gridx = 0;
        c.gridy = 8;
        c.insets = new Insets(0,0,0,750);
        add(empCity,c);
        
        
        
        stateMenu states = new stateMenu();
        JComboBox stateMenu = states.retStateMenu();
        c.gridx = 0;
        c.gridy = 8;
        c.insets = new Insets(0,250,0,550);
        add(stateMenu,c);   
        
        
        JLabel empZipLabel = new JLabel("Zip Code");
        c.gridx = 0;
        c.gridy = 7;
        c.insets = new Insets(0,500,0,350);
        add(empZipLabel,c);
        
        JTextField empZip = new JTextField();
        c.gridx = 0;
        c.gridy = 8;
        c.insets = new Insets(0,500,0,350);
        add(empZip,c);
       
        c.insets = new Insets(0,0,0,0);
        c.ipadx = 0;
        
        JLabel empPhoneLabel = new JLabel("Phone Number");
        c.gridx = 0;
        c.gridy = 9;
        add(empPhoneLabel,c);
        
        JTextField empPhone = new JTextField();
        c.gridx = 0;
        c.gridy = 10;
        c.insets = new Insets(0,0,0,650);
        add(empPhone,c);
        
        c.insets = new Insets(0,0,0,0);
        
        JLabel empEmailLabel = new JLabel("Email Address");
        c.gridx = 0;
        c.gridy = 11;
        c.insets = new Insets(0,0,0,600);
        add(empEmailLabel,c);
        
        JTextField empEmail = new JTextField();
        c.gridx = 0;
        c.gridy = 12;
        c.insets = new Insets(0,0,0,600);
        add(empEmail,c);
        
        c.insets = new Insets(0,0,0,0);
        
        JLabel empSSNumLabel = new JLabel("Social Security Number");
        c.gridx = 0;
        c.gridy = 13;
        c.insets = new Insets(0,0,0,700);
        add(empSSNumLabel,c);
        
        JTextField empSSNum = new JTextField();
        c.gridx = 0;
        c.gridy = 14;
        c.insets = new Insets(0,0,0,700);
        add(empSSNum,c);
        
        c.insets = new Insets(0,0,0,0);        
        
        JCheckBox volunteer = new JCheckBox("Volunteer");
        c.gridx = 0;
        c.gridy = 15;
        c.insets = new Insets(20,0,0,0);
        add(volunteer,c);
        isVolunteer = "Paid";
        volunteer.addItemListener(new ItemListener()
    {
      public void itemStateChanged(ItemEvent e)
      {
      
        if(e.getStateChange()==1){
            isVolunteer="Volunteer";
                }
        else{
            isVolunteer="Paid";
        }
        
              }
    });
        
        
        JLabel webLocEventLabel = new JLabel("Employee Location");
        c.gridy = 16;
        c.gridx = 0;
        c.insets = new Insets(10,0,0,0);
        add(webLocEventLabel,c);
        
        
        JComboBox location = new JComboBox();
        locMenu menu = new locMenu();
        location = menu.locList();
        c.gridy = 17;
        c.insets = new Insets(0,0,20,550);
        add(location,c); 
        
        
        
        
        JButton submit = new JButton("Submit");
        c.gridx = 0;
        c.gridy = 18;
        c.insets = new Insets(0,10,0,750);
        add(submit,c);
        
        c.insets = new Insets(0,0,0,0);
        
        //button listener
        submit.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        states.getState();
        menu.getLocation();
        employee toAdd = new employee();
        toAdd.Emp_First = empFName.getText();  
        toAdd.Emp_Last = empLName.getText();
        toAdd.Emp_Add1 = empAdd1.getText();
        toAdd.Emp_Add2 = empAdd2.getText();
        toAdd.Emp_City = empCity.getText();
       
        toAdd.Emp_State = states.selectedState;
        toAdd.Emp_Zip = empZip.getText();
        toAdd.Emp_Phone = empPhone.getText();
        toAdd.Emp_Email = empEmail.getText();
        toAdd.Emp_SS = empSSNum.getText();
        toAdd.Emp_Vol = isVolunteer;
        toAdd.Emp_Loc_ID = menu.selectedID;
        
        removeAll();
        JPanel verify = new JPanel();
        verify = toAdd.employeeDetailView();
        add(verify);
        
        JButton addVerEmployee = new JButton("Yes, Add Employee");
        c.gridx = 0;
        c.gridy = 11;
        c.insets = new Insets(20,200,0,0);
        add(addVerEmployee,c);

        
        JButton dontAddEmployee = new JButton("No,Return to Form");
        c.gridx = 1;
        c.gridy = 11;
        c.insets = new Insets(20,20,0,50);
        add(dontAddEmployee,c);
           
        
                        
        //button listener
        addVerEmployee.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
      
        //System.out.println("Submitted");
        
        removeAll();
        toAdd.insertEmployeeData();
        JLabel addedNewEmployee = new JLabel("New Employee Added");
        add(addedNewEmployee);
        validate();
        repaint();
        
        
              }
    });
    dontAddEmployee.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        empFormPanel empForm1 = new empFormPanel();
        
        removeAll();
        add(empForm1);
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
