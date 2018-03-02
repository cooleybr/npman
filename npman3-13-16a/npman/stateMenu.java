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
public class stateMenu {
    
    public String[] states;
    public String selectedState;
    public JComboBox menu;
    
    public stateMenu(){
        selectedState="Alabama";
    }
    
    
    
    public JComboBox retStateMenu(){
        String[] states = {"Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","Florida","Georgia","Hawaii","Idaho","Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota","Mississippi","Missouri","Montana","Nebraska","Nevada","New Hampshire","New Jersey","New Mexico","New York","North Carolina","North Dakota","Ohio","Oklahoma","Oregon","Pennsylvania","Rhode Island","South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Washington","West Virginia","Wisconsin","Wyoming"};
        
        menu = new JComboBox();
        int i;
        for(i=0;i < states.length; i++){
            menu.addItem(states[i]);
            
        }
        
        menu.addItemListener(new ItemListener() {
        public void itemStateChanged(ItemEvent arg0) {
            selectedState = menu.getSelectedItem().toString();
        }
    });
        
       return menu;
    }
    
    public void getState(){
        
        selectedState = menu.getSelectedItem().toString();
    }
    
   
}
 