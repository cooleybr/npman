/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package npman;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;

/**
 *
 * @author Mountainside 19
 */
public class searchPanel extends JPanel{
    
    public String query;
    public GridBagConstraints c;
    
    public searchPanel(){
        query = "";
        setLayout(new GridBagLayout());
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.ipady = 3;
        
    }
    
    public void getResults(){
        System.out.println(query);
        JLabel resTitle = new JLabel("Your search for \"" + query + "\" revealed the following results:");
        c.gridx = 0;
        c.gridy = 0;
        add(resTitle,c);
        
        
        
    }
    
}
