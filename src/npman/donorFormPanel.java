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
class donorFormPanel extends JPanel {

    public static Donor toAdd;
    public String selectedValue,selectedMethod,accMark;
    
    public donorFormPanel() {
    
        setLayout(new GridBagLayout());
        //setPreferredSize(new Dimension(400,300));
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 3;
        //setLayout (new BoxLayout(this, BoxLayout.Y_AXIS));
        //setLayout(new BorderLayout());
           
        
        JLabel donorFormLabel = new JLabel("Add a new donor");
        c.weightx = 2;
        c.gridx = 0;
        c.gridy = 0;
        c.ipadx = 50;
        c.insets = new Insets(0,100,25,0);
        add(donorFormLabel,c);
        
        c.insets = new Insets(0,0,0,0);
        
        JLabel donorCompanyLabel = new JLabel("Company");
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 1;
        c.ipadx = 50;
        add(donorCompanyLabel,c);
        
        JTextField donorCompany = new JTextField(20);
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 2;
        c.ipadx = 50;
        c.insets = new Insets(0,0,0,50);
        add(donorCompany,c);
        
        JLabel donorFNameLabel = new JLabel("First Name");
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 3;
        c.ipadx = 50;
        add(donorFNameLabel,c);
        
        JTextField donorFName = new JTextField(20);
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 4;
        c.ipadx = 50;
        c.insets = new Insets(0,0,0,50);
        add(donorFName,c);
                
        c.insets = new Insets(0,0,0,0);   
        
        JLabel donorLNameLabel = new JLabel("Last Name");
        c.weightx = 2;
        c.gridx = 1;
        c.gridy = 3;
        c.ipadx = 50;
        add(donorLNameLabel,c);
        
        JTextField donorLName = new JTextField(20);
        c.weightx = 2;
        c.gridx = 1;
        c.gridy = 4;
        c.ipadx = 50;
        c.insets = new Insets(0,0,0,50);
        add(donorLName,c);
                
        c.insets = new Insets(0,0,0,0); 
                
        JLabel donorAdd1Label = new JLabel("Street Address");
        c.weightx = 2;
        c.gridx = 0;
        c.gridy = 5;
        
        add(donorAdd1Label,c);
        
        JTextField donorAdd1 = new JTextField(25);
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 6;
        c.insets = new Insets(0,0,0,50); 
        add(donorAdd1,c);
        
        
        JLabel donorAdd2Label = new JLabel("Address Line 2");
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 5;
        add(donorAdd2Label,c);
        
        JTextField donorAdd2 = new JTextField(5);
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 6;
        c.insets = new Insets(0,0,0,150); 
        add(donorAdd2,c);
        
        
        JLabel donorCityLabel = new JLabel("City");
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 7;
        add(donorCityLabel,c);
        
        JTextField donorCity = new JTextField(5);
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 8;
        c.insets = new Insets(0,0,0,50);
        add(donorCity,c);
        
        //c.insets = new Insets(0,0,0,0);
        
        JLabel donorStateLabel = new JLabel("State");
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 7;
        add(donorStateLabel,c);
        
        JComboBox empState = new JComboBox();
        stateMenu states = new stateMenu();
        empState = states.retStateMenu();
        c.gridx = 1;
        c.gridy = 8;
        c.insets = new Insets(0,0,0,50);
        add(empState,c);
        
          
        //c.insets = new Insets(0,0,0,0);
        
        JLabel donorZipLabel = new JLabel("Zip Code");
        c.weightx = 1;
        c.gridx = 2;
        c.gridy = 7;
        add(donorZipLabel,c);
        
        JTextField donorZip = new JTextField(5);
        c.weightx = 1;
        c.gridx = 2;
        c.gridy = 8;
        c.insets = new Insets(0,0,0,150);
        add(donorZip,c);
       
        c.insets = new Insets(0,0,0,0);
        
        JLabel donorPhoneLabel = new JLabel("Phone Number");
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 9;
        add(donorPhoneLabel,c);
        
        JTextField donorPhone = new JTextField(5);
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 10;
        c.insets = new Insets(0,0,0,125);
        add(donorPhone,c);
        
        c.insets = new Insets(0,0,0,0);
        
        JLabel donorEmailLabel = new JLabel("Email Address");
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 9;
        add(donorEmailLabel,c);
        
        JTextField donorEmail = new JTextField(5);
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 10;
        c.insets = new Insets(0,0,0,100);
        add(donorEmail,c);
        
        JLabel donorMarketLabel = new JLabel("Accepts Marketing?");
        c.gridx = 2;
        c.gridy = 9;
        add(donorMarketLabel,c);
        
        JCheckBox marketing = new JCheckBox();
        c.gridx = 2;
        c.gridy = 10;
        add(marketing,c);
        accMark = "no";
        marketing.addItemListener(new ItemListener()
    {
      public void itemStateChanged(ItemEvent e)
      {
      
        if(e.getStateChange()==1){
            accMark="yes";
                }
        else{
            accMark="no";
        }
        
              }
    });
        
        
        JLabel donorReferLabel = new JLabel("Referral Source");
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 11;
        add(donorReferLabel,c);
        
        JComboBox refer = new JComboBox();
        referMenu refs = new referMenu();
        refer = refs.referList();
        c.gridx = 0;
        c.gridy = 12;
        c.insets = new Insets(0,0,0,50);
        add(refer,c);
        
        c.insets = new Insets(0,0,0,0);
        
        
        JLabel donorDonationLabel = new JLabel("Add Donation");
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 11;
        add(donorDonationLabel,c);
        
        JTextField donorDonation = new JTextField("0.00");
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 12;
        c.insets = new Insets(0,0,0,150);
        add(donorDonation,c);
        
        JLabel donorMethodLabel = new JLabel("Payment Method");
        c.weightx = 1;
        c.gridx = 2;
        c.gridy = 11;
        add(donorMethodLabel,c);
        
        JComboBox donationMethod = new JComboBox();
        donationMethod.addItem("Cash");
        donationMethod.addItem("Check");
        donationMethod.addItem("Credit Card");
        donationMethod.addItem("Paypal");
        donationMethod.addItem("Pledge");
        c.gridx = 2;
        c.gridy = 12;
        add(donationMethod,c);
        
        selectedMethod = "Cash";
        
        donationMethod.addItemListener(new ItemListener() {
        public void itemStateChanged(ItemEvent arg0) {
            selectedMethod = donationMethod.getSelectedItem().toString();
        }
    });
        
        
        c.insets = new Insets(0,0,0,0);
        
        JLabel addDate = new JLabel("Add Date");
        c.gridx = 0;
        c.gridy = 13;
        add(addDate,c);
        
        JTextField aDay = new JTextField("2016-01-15");
        c.gridx = 1;
        c.gridy = 13;
        add(aDay,c);
                
        
        JButton submit = new JButton("Submit");
        c.weightx = .5;
        c.gridx = 1;
        c.gridy = 14;
        c.insets = new Insets(25,150,0,25);
        add(submit,c);
        
        c.insets = new Insets(0,0,0,0);
        
        //button listener
        submit.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
          refs.getRefer();
          states.getState();
        toAdd = new Donor();
        toAdd.donorCompany = donorCompany.getText();
        toAdd.donorFirstName = donorFName.getText();
        toAdd.donorLastName = donorLName.getText();
        toAdd.donorAdd1 = donorAdd1.getText();
        toAdd.donorAdd2 = donorAdd2.getText();
        toAdd.donorCity = donorCity.getText();
        toAdd.donorState = states.selectedState;
        toAdd.donorZip = donorZip.getText();
        toAdd.donorPhone = donorPhone.getText();
        toAdd.donorEmail = donorEmail.getText();
        toAdd.donorReferSrc = refs.selectedRefer;
        toAdd.donation = Double.parseDouble(donorDonation.getText()); 
        toAdd.donationMethod = selectedMethod;
        toAdd.donorMarket = accMark;
        toAdd.donorAddDate = aDay.getText();
                
        removeAll();
        JPanel donorView = toAdd.donorDetailView();
        
        add(donorView);
        
        JButton addVerDonor = new JButton("Yes, Add Donor");
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 10;
        c.insets = new Insets(0,0,0,0);
        add(addVerDonor,c);

        
        JButton dontAddDonor = new JButton("No,Return to Form");
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 10;
        c.insets = new Insets(0,0,0,0);
        add(dontAddDonor,c);
           
        
                
        //button listener
        addVerDonor.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
      
        toAdd.insertDonorData();
        removeAll();
        JLabel addedNewDonor = new JLabel("New Donor Added");
        add(addedNewDonor);
        validate();
        repaint();
        
        
              }
    });
    dontAddDonor.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        donorFormPanel donorForm1 = new donorFormPanel();
        
        removeAll();
        add(donorForm1);
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
