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
import java.sql.*;
/**
 *
 * @author brc
 */
public class servMenu {
    
    
    public String selectedServ;
    public JComboBox menu;
    
    
    public servMenu(){
        selectedServ="--None--";
    }
    
    
    
    public JComboBox servList(){
        
        menu = new JComboBox();
        menu.addItem("--None--");
        Connection c = null;
        Statement stmt = null;
        
        String[] services = {"Contribution","Volunteering","Fundraising","Promotion"};
        int i;
        for(i=0;i < services.length; i++){
            menu.addItem(services[i]);
            
        }
          
        
        menu.addItemListener(new ItemListener() {
        public void itemStateChanged(ItemEvent arg0) {
            selectedServ = menu.getSelectedItem().toString();
            
        }
    });
        
       return menu;
    }
       
    public void getService(){
        selectedServ = menu.getSelectedItem().toString();
                
    }
    
   
}
 