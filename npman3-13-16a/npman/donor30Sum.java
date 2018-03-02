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
public class donor30Sum extends JPanel{
    
    public donor30Sum(){
        
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 3;
        c.insets = new Insets(20,20,20,20);
        
        JPanel donTable = new JPanel();
        donor30Table last30 = new donor30Table();
        donTable = last30;
        c.gridx = 0;
        c.gridy = 0;
        add(donTable,c);
        
        JPanel donChart = new JPanel();
        donChart.setPreferredSize(new Dimension(400,300));
        donor30Graph last30G = new donor30Graph();
        donChart = last30G;
        c.gridx = 1;
        c.gridy = 0;
        add(donChart,c);
        
        JLabel chartLab = new JLabel("Donors per day last 30 days");
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(0,150,0,0);
        add(chartLab,c);
        
        c.insets = new Insets(20,20,20,20);
        
        JPanel donationTable = new JPanel();
        donation30Table last30d = new donation30Table();
        donationTable = last30d;
        c.gridx = 0;
        c.gridy = 2;
        add(donationTable,c);
        
        JPanel donationChart = new JPanel();
        donationChart.setPreferredSize(new Dimension(400,300));
        donation30Graph last30Gd = new donation30Graph();
        donationChart = last30Gd;
        c.gridx = 1;
        c.gridy = 2;
        add(donationChart,c);
        
        JLabel chart2Lab = new JLabel("Donations per day last 30 days");
        c.gridx = 1;
        c.gridy = 3;
        c.insets = new Insets(0,150,0,0);
        add(chart2Lab,c);
        
        
    }
    
}
