/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package npman;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author brc
 */
public class labor30Sum extends JPanel{
    
    public labor30Sum(){
        
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 3;
        c.insets = new Insets(20,20,20,20);
        
        JPanel labTable = new JPanel();
        labor30Table last30 = new labor30Table();
        labTable = last30;
        c.gridx = 0;
        c.gridy = 0;
        add(labTable,c);
        
        JPanel labChart = new JPanel();
        labChart.setPreferredSize(new Dimension(400,300));
        labor30Graph last30G = new labor30Graph();
        labChart = last30G;
        c.gridx = 1;
        c.gridy = 0;
        add(labChart,c);
        
        JLabel chartLab = new JLabel("Labor hours per day last 30 days");
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(0,150,0,0);
        add(chartLab,c);
        
        
    }
    
}
