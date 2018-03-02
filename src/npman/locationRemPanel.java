/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package npman;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

/**
 *
 * @author brc
 */
class locationRemPanel extends JPanel {

    public static LocDBMS locData;
    public static String toChange;
    
    public locationRemPanel() {
    
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 10;
           
        locData = new LocDBMS();
        
        
        
       
        ArrayList currentLocations = locData.viewLocData();
        
        if (currentLocations.size() > 0){
        
        JLabel listLocations = new JLabel("Select a location from the dropdown to edit/remove");
        //c.weighty = 2;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0,100,25,0);
        add(listLocations,c);    
            
        locMenu menu = new locMenu();
        JComboBox location = menu.locList();
        c.gridy = 2;
        c.insets = new Insets(0,100,20,100);
        add(location,c); 
       
                
        JButton edit = new JButton("Edit Selected");
        c.gridx = 1;
        c.gridy = 3;
        c.insets = new Insets(0,5,0,300);
        add(edit,c);
        
        
        edit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                
                menu.getLocation();
                int locID = menu.selectedID;
                
                removeAll();
                locationEditFormPanel toEdit = new locationEditFormPanel(locID);
                add(toEdit);
                validate();
                repaint();
            }
            
        });
        
        JButton delete = new JButton("Delete Selected");
        c.gridx = 1;
        c.gridy = 4;
        c.insets = new Insets(20,5,0,300);
        add(delete,c);
        
        
        delete.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                menu.getLocation();
                int locID = menu.selectedID;
                String delQuery = ("update location set loc_closed_date=current_date where loc_id ="+locID+";");
                locData.deleteLocData(delQuery);
                removeAll();
                JLabel deleted = new JLabel("Location Removed");
                 c.gridy +=1;
                add(deleted);
                JButton ok = new JButton("Necessary Updates");
                c.gridy +=1;
                add(ok);
                
                ok.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                removeAll();
                JPanel updates = new JPanel();
                c.insets = new Insets(0,0,0,0);
                empLocUpdatePanel tochange = new empLocUpdatePanel();
                updates = tochange.empLocUpdate(menu.selectedID);
                add(updates,c);                
                
                validate();
                repaint();
            }
            
        });
                
                validate();
                repaint();
            }
            
        });
        
        }
        
        else{
            JLabel noLocations = new JLabel("No Locations Added");
            c.gridy += 1;
            add(noLocations,c);
        }
    }
    
}
