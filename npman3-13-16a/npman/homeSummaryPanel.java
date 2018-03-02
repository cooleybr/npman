/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package npman;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 *
 * @author brc
 */
class homeSummaryPanel extends JPanel {

    public homeSummaryPanel() {
    
        setLayout(new GridBagLayout());
        //setPreferredSize(new Dimension(750,700));
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 3;
           
                
        JLabel summaryTitle = new JLabel("Agency Summary");
        c.gridy = 1;
        add(summaryTitle,c);
        
        JLabel tSpace = new JLabel("                                                         ");
        c.gridy += 1;
        add(tSpace,c);
        
        location a = new location();
        int locCount = a.getCountLoc();
        
        
        JLabel locCountLabel = new JLabel("There are " + locCount + " locations");
        c.gridy += 1;
        add(locCountLabel,c);
        
        employee b = new employee();
        int empCount = b.getCountEmp();
        
        
        JLabel empCountLabel = new JLabel ("There are " + empCount + " employees");
        c.gridy += 1;
        add(empCountLabel,c);
        
        Donor d = new Donor();
        int donorCount = d.getCountDonor();
        
        JLabel donorCountLabel = new JLabel ("There are " + donorCount + " donors");
        c.gridy += 1;
        add(donorCountLabel,c);
        
        donation e = new donation();
        int donationCount = e.getCountDonation();
        
        JLabel donationCountLabel = new JLabel ("There are " + donationCount + " donations");
        c.gridy += 1;
        add(donationCountLabel,c);
        
        double donationSum = e.getSumDonation();
        
        JLabel donationSumLabel = new JLabel ("You have received " + donationSum + " in donations");
        c.gridy += 1;
        add(donationSumLabel,c);
        
        JLabel sumSpace = new JLabel("________________________________________________________________");
        c.gridy += 1;
        add(sumSpace,c);
        
        JLabel costRev = new JLabel("Staffing Vs. Revenue");
        c.gridy += 1;
        add(costRev,c);
        
        JLabel stRe = new JLabel("                                                                     ");
        c.gridy += 1;
        add(stRe,c);
        
        empRecPanel recEmp = new empRecPanel();
        int empCt = recEmp.ct30;
        double addLabor = empCt * 2500;
        grant gCt = new grant();
        double gTot = gCt.sum30Grant();
        
        if ((donationSum+gTot)< addLabor){
            JLabel costBen = new JLabel("You increased labor cost recently but not revenue. " +
                                        "Would you like to contact donors or find grants?");
          c.gridy += 1;
          add(costBen,c);
                    }
        else{
            JLabel costBen = new JLabel("You increased revenue recently, but not labor. " +
                                        "This may be an opportunity to increase staffing.");
          c.gridy += 1;
          add(costBen,c);
        }
        
        project pro = new project();
        int allHour = pro.totalProject();
        
        if ((donorCount/50)+ (allHour/120)>empCt){
            JLabel custServ = new JLabel("It may be difficult to provide excellent service with current staffing");
            c.gridy += 1;
            add(custServ,c);
        }
        else{
            JLabel custServ = new JLabel("Consider additional marketing or donor outreach " +
                                        "to maximize labor costs.");
            c.gridy += 1;
            add(custServ,c);
        }
        
        JLabel refSpace = new JLabel("__________________________________________________________");
        c.gridy += 1;
        add(refSpace,c);
        
              
        JLabel refSp = new JLabel("                                              ");
        c.gridy += 1;
        add(refSp,c);
        
       ArrayList refs = d.donRefSrc();
      try{
       histPanel hist = new histPanel();
       hist.setVals(refs);
       JScrollPane scroll1 = new JScrollPane(hist);
       scroll1.setPreferredSize(new Dimension(300,200));
       c.gridy +=1;
       add(scroll1,c);
      }
       
       catch(Exception g){
           JLabel referrers = new JLabel("Not enough referral data");
           c.gridy += 1;
           add(referrers,c);
       }
        
    }
    
}
