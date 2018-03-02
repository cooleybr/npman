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
class donationForm extends JPanel {

    public String selectedDonor;
    public static Donor toAdd;
    public JComboBox selectDonor;
    
    public donationForm() {
    
        setLayout(new GridBagLayout());
        //setPreferredSize(new Dimension(400,300));
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 3;
        //setLayout (new BoxLayout(this, BoxLayout.Y_AXIS));
        //setLayout(new BorderLayout());
        
        toAdd = new Donor();
        
        JLabel formTitle = new JLabel("Accept Donation - Select Donor Below");
        c.gridy = 1;
        add(formTitle,c);
        
        
        selectDonor = new JComboBox();
        selectDonor = toAdd.donorBox();
        c.gridy = 2;
        add(selectDonor,c);
        
        selectedDonor = ("Add New Donor");
        
        selectDonor.addItemListener(new ItemListener() {
        public void itemStateChanged(ItemEvent arg0) {
            selectedDonor = selectDonor.getSelectedItem().toString();
 
        }
    });
        
        JButton confirm = new JButton("Continue");
        c.gridy = 3;
        c.insets = new Insets(10,0,0,0);
        add(confirm,c);
        
        
        
        confirm.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
      
        //System.out.println("Submitted");
        
        
        if(selectedDonor=="Add New Donor"){
            removeAll();
            donorFormPanel donorForm1 = new donorFormPanel();
            add(donorForm1);
            validate();
            repaint();
        }
        else{
            removeAll();
            
        
        String[] result = selectedDonor.split("\\s");
        
            toAdd.donID = Integer.parseInt(result[0]);
            toAdd.donorFirstName = result[1];
            toAdd.donorLastName = result[2];
            toAdd.getSetDonorData();
            JPanel form = new JPanel();
            form = toAdd.donationForm2();
            
            //toEdit.editDonor();
            
            add(form);
            validate();
            repaint();
        }
        
        
        
        
        
              }
    });
        
        
        
        
    }
    
}
