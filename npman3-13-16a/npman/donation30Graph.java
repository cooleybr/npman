/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package npman;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.*;
import java.sql.*;
/**
 *
 * @author brc
 */
public class donation30Graph extends JPanel{
    
    private int MAX_SCORE = 100;
    private static final int PREF_W = 400;
    private static final int PREF_H = 200;
    private static final int BORDER_GAP = 1;
    private static final Color GRAPH_COLOR = Color.green;
    private static final Color GRAPH_POINT_COLOR = Color.blue;
    private static final Stroke GRAPH_STROKE = new BasicStroke(3f);
    private static final int GRAPH_POINT_WIDTH = 7;
    private int Y_HATCH_CNT = 7;
    private List<Double> donations;
    
    public donation30Graph(){
        donations = new ArrayList<Double>();
        for(int j=0;j<30;j++){
            donations.add(0.0);
        }
        Connection c = null;
        Statement stmt = null;
    try {
        
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") + "/NPMWare/test.db");
      
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT Dona_Date,SUM(Dona_Amt) FROM donation where (julianday(current_date)-julianday(Dona_Date)) <= 30 group by Dona_Date;" );
      while ( rs.next() ) {

           String day = rs.getString("Dona_Date");
           String delims = "[-]+";
           String[] dP = day.split(delims);
           double dCount = rs.getInt("SUM(Dona_Amt)");
           donations.set((Integer.parseInt(dP[2])), dCount);
 
      }
      
      rs.close();
      stmt.close();
      c.close();
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
    }
        
        
        
        
        
        double max = donations.get(0);
        for(int i=1; i<donations.size(); i++){
        if(donations.get(i) > max){
            max = donations.get(i);
        }
        }
        MAX_SCORE = ((int)(max));
        donation30Graph mainPanel = new donation30Graph(donations);
        Y_HATCH_CNT = MAX_SCORE;
    }
    
     public donation30Graph(List<Double> donations){
        this.donations = donations;
        
    }
    
    
    
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D)g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

      double xScale = ((double) getWidth()-2 * BORDER_GAP) / (donations.size() - 1);
      double yScale = ((double) getHeight()-2 * BORDER_GAP) / (MAX_SCORE - 1);

      List<Point> graphPoints = new ArrayList<Point>();
      for (int i = 0; i < donations.size(); i++) {
         int x1 = (int) (i * xScale + BORDER_GAP);
         int y1 = (int) ((MAX_SCORE - donations.get(i)) * yScale + BORDER_GAP);
         graphPoints.add(new Point(x1, y1));
      }

      // create x and y axes 
      g2.drawLine(BORDER_GAP, getHeight() - BORDER_GAP, BORDER_GAP, BORDER_GAP);
      g2.drawLine(BORDER_GAP, getHeight() - BORDER_GAP, getWidth() - BORDER_GAP, getHeight() - BORDER_GAP);

      // create hatch marks for y axis. 
      for (int i = 0; i < Y_HATCH_CNT; i++) {
         int x0 = BORDER_GAP;
         int x1 = GRAPH_POINT_WIDTH + BORDER_GAP;
         int y0 = getHeight() - (((i + 1) * (getHeight() - BORDER_GAP * 2)) / Y_HATCH_CNT + BORDER_GAP);
         int y1 = y0;
         g2.drawLine(x0, y0, x1, y1);
      }

      // and for x axis
      for (int i = 0; i < donations.size() - 1; i++) {
         int x0 = (i + 1) * (getWidth() - BORDER_GAP * 2) / (donations.size() - 1) + BORDER_GAP;
         int x1 = x0;
         int y0 = getHeight() - BORDER_GAP;
         int y1 = y0 - GRAPH_POINT_WIDTH;
         g2.drawLine(x0, y0, x1, y1);
      }

      Stroke oldStroke = g2.getStroke();
      g2.setColor(GRAPH_COLOR);
      g2.setStroke(GRAPH_STROKE);
      for (int i = 0; i < graphPoints.size() - 1; i++) {
         int x1 = graphPoints.get(i).x;
         int y1 = graphPoints.get(i).y;
         int x2 = graphPoints.get(i + 1).x;
         int y2 = graphPoints.get(i + 1).y;
         g2.drawLine(x1, y1, x2, y2);         
      }

      g2.setStroke(oldStroke);      
      g2.setColor(GRAPH_POINT_COLOR);
      for (int i = 0; i < graphPoints.size(); i++) {
         int x = graphPoints.get(i).x - GRAPH_POINT_WIDTH / 2;
         int y = graphPoints.get(i).y - GRAPH_POINT_WIDTH / 2;;
         int ovalW = GRAPH_POINT_WIDTH;
         int ovalH = GRAPH_POINT_WIDTH;
         g2.fillOval(x, y, ovalW, ovalH);
      }
      
      
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }
    
}
