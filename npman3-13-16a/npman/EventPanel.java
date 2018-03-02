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
public class EventPanel extends JPanel{
    
    
    public EventPanel(){
    
    
    setLayout(new BorderLayout(10,10));
    JLabel eventManTitle = new JLabel("Event Management Center");
    eventManTitle.setHorizontalAlignment(JLabel.CENTER);
    eventManTitle.setVerticalAlignment(JLabel.TOP);
    add(eventManTitle,BorderLayout.NORTH);
    
    getMenu(this);
    //updatePanel(this);
        
        
    }
    
    
    
    public void getMenu(JPanel a){
        JPanel main = a;
        JPanel menu = new JPanel();
        menu.setLayout(new GridBagLayout());
        
        menu.setPreferredSize(new Dimension(500,75));
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 10;
        c.ipadx = 20;
        c.insets = new Insets(0,0,0,0);

                
        JButton eventScheduleButton = new JButton("Scheduled");
        c.gridx = 0;
        c.gridy = 0;
        menu.add(eventScheduleButton,c);
        
        eventScheduleButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        
        main.removeAll();
        JLabel eventScheduleTitle = new JLabel("Currently Scheduled Events");
        main.add(eventScheduleTitle,BorderLayout.CENTER);
        main.add(menu,BorderLayout.NORTH);
        main.validate();
        main.repaint();
          
        
              }
    });
        
        JButton newEventButton = new JButton("New Event");
        c.gridx = 1;
        c.gridy = 0;
        menu.add(newEventButton,c);
        
        newEventButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        main.removeAll();
        JLabel newEventTitle = new JLabel("Schedule an event");
        main.add(menu,BorderLayout.NORTH);
        main.add(newEventTitle,BorderLayout.CENTER);
        main.validate();
        main.repaint();
        
              }
    });
        
        JButton eventEditButton = new JButton("Edit Event");
        c.gridx = 2;
        c.gridy = 0;
        menu.add(eventEditButton,c);
        
        eventEditButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        
        main.removeAll();
        JLabel editEventTitle = new JLabel("Edit/Cancel a scheduled event");
//empFormPanel empform1 = new empFormPanel();
        main.add(editEventTitle,BorderLayout.CENTER);
        main.add(menu,BorderLayout.NORTH);
        main.validate();
        main.repaint();
          
        
              }
    });
        
        JButton promoteEventButton = new JButton("Promote Event");
        c.gridx = 3;
        c.gridy = 0;
        menu.add(promoteEventButton,c);
        
        promoteEventButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        main.removeAll();
        JLabel promoteEventTitle = new JLabel("Promote Event");
        main.add(promoteEventTitle,BorderLayout.CENTER);
        main.add(menu,BorderLayout.NORTH);
        //main.add(locations,BorderLayout.CENTER);
        main.validate();
        main.repaint();
        
              }
    });
        
        
        
        
        
    
        
        main.add(menu,BorderLayout.NORTH);
        
    }
    
}
