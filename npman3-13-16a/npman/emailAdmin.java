/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package npman;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class emailAdmin extends JPanel{
    
    public emailAdmin(){
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 3;
        
        JLabel title = new JLabel("Select an email account or add a new one");
        c.gridy = 2;
        add(title,c);
        
        JComboBox curEmails = new JComboBox();
        emailAcctMenu emails = new emailAcctMenu();
        curEmails = emails.emailList();
        c.gridy = 3;
        add(curEmails,c);
        
        JButton edit = new JButton("Edit Email Account");
        c.gridy = 3;
        c.gridx = 1;
        add(edit,c);
        
        edit.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
          JLabel editThis = new JLabel("Fill in edit function");
          
                    
          removeAll();
          validate();
          repaint();
          
          add(editThis);
 
              }
    });
        
        
        JButton addNew = new JButton("Add Email Account");
        c.gridy = 4;
        add(addNew,c);
        
        addNew.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
          addEmail nAcct = new addEmail();         
                    
          removeAll();
          validate();
          repaint();
          
          add(nAcct);
 
              }
    });
        
        
        
    }
}
