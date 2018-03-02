/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package npman;


import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;

/**
 *
 * @author brc
 */
public class histPanel extends JPanel{
    
    final int ROW_HEIGHT = 25;
    final int VAL_WIDTH = 100;
    final int INCREMENT = 25;
    ArrayList<String> vals;
    ArrayList<Integer> values;
    ArrayList<String> labels;
    int width = 1;
    
    public histPanel(){
        
        setBackground(Color.white);
        
    }
    
    public void setVals(ArrayList<String> a){
        vals = a;
        values = new ArrayList();
        labels = new ArrayList();
        
        
        for (int i=0;i<vals.size();i++){
            String delims = "[-]+";
            String[] sp1 = vals.get(i).split(delims);
            //System.out.println(sp1[0]);
            
            if(sp1.length>1){
            labels.add(sp1[1]);
            //get values arraylist
            values.add(Integer.parseInt(sp1[0]));
            if (Integer.parseInt(sp1[0])>width){
                width = Integer.parseInt(sp1[0]);
            }     
            }
            
            System.out.println(width);
        }
    }
    
    public void paintComponent(Graphics page){
       
        
        super.paintComponent(page);
        setPreferredSize(new Dimension(width*INCREMENT+VAL_WIDTH,(vals.size()*ROW_HEIGHT)+50));
        page.drawString("How your donors find you",(width*INCREMENT+VAL_WIDTH),25);
        for (int j = 0; j<labels.size();j++){
            page.setColor(Color.black);
            page.drawString(labels.get(j) + " (" + values.get(j) + ")",10,j*ROW_HEIGHT+55);
            page.setColor(Color.WHITE);
            page.drawRect((VAL_WIDTH + 25),j*ROW_HEIGHT + 40,INCREMENT*values.get(j),ROW_HEIGHT);
            page.setColor(Color.BLUE);
            page.fillRect((VAL_WIDTH + 25),j*ROW_HEIGHT + 40,INCREMENT*values.get(j),ROW_HEIGHT-5);
        }
        
    }
    
}
