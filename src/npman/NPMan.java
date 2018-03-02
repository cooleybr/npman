/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package npman;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.sql.*;

/**
 *
 * @author brc
 */
public class NPMan {

    /**
     * @param args the command line arguments
     */
     
     
    public static void main(String[] args) {
        // TODO code application logic here
        

                        
        JFrame frame = new JFrame("NPMWare - Non-Profit Management Suite");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        File dir = new File(System.getProperty("user.home") + "/NPMWare");
                dir.mkdirs();
        JTabbedPane tp = new JTabbedPane();
        frame.setPreferredSize(new Dimension(1000,600));
        frame.setLocationByPlatform(true);
        
        tp.addTab("Locations",new LocationPanel());
        tp.addTab("Employees/Volunteers", new EmployeePanel());
        tp.addTab("Donors", new DonorPanel());
        tp.addTab("Marketing", new MarketingPanel());
        tp.addTab("Grants", new GrantPanel());
        tp.addTab("Outreach", new OutreachPanel());
        tp.addTab("Reporting", new ReportPanel());
        //tp.addTab("Insights", new InsightPanel());
        //location a = new location();
        //a.updateLocColumns();
        frame.getContentPane().add(tp);
        frame.pack();
        frame.setVisible(true);
        
        
        //Open Database
        /*
        DBMS a = new DBMS();
        a.OpenDB();
        String statesTable = "CREATE TABLE States(State_ID numeric Primary Key," + "State varchar2(15))";
        a.createTableDB(statesTable);
        a.InsertStatesDB();
        a.verifyStates();
        */
    }
    
}
