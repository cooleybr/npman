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
class overallSumPanel extends JPanel {

    public overallSumPanel() {
    
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(800,200));
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 10;
           
           
        JLabel overallSumTitle = new JLabel("Agency Summary");
        
        c.gridy = 0;
        c.insets = new Insets(0,100,25,0);
        add(overallSumTitle,c);
        
        
        
        

    
    }
    
}
