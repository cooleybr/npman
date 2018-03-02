package npman;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
/**
 *
 * @author brc
 */
public class grantSearch extends JPanel{
    
    public final String[] grantSites;
    
    
    public grantSearch(){
        
        
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(400,300));
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 3;
        
        JLabel gsTitle = new JLabel("Find Available Grants");
        c.gridy = 0;
        add(gsTitle,c);
        
        int i;
        grantSites = new String[]{"http://www.foundationcenter.org","http://www.grants.gov"};
        for(i=0;i < grantSites.length; i++){
            
        
        String address = grantSites[i];
        
        JLabel link = new JLabel(grantSites[i]);
        link.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        link.addMouseListener(new MouseAdapter() {
             public void mouseClicked(MouseEvent e) {
        if (Desktop.isDesktopSupported()) {
                      Desktop desktop = Desktop.getDesktop();
                     try {
                    URI url = new URI(address);
                    desktop.browse(url);
                    } catch (IOException ex) {
                    ex.printStackTrace();
                    } catch (URISyntaxException ex) {
                    ex.printStackTrace();
                    }
        
        
    }
             
             }
    });
        
        c.gridy += 1;
        add(link,c);
        
        }
        
        
        JButton addGrant = new JButton("Add Grant Detail");
        addGrant.setPreferredSize(new Dimension(75,25));
        c.gridy +=1;
        c.insets = new Insets(25,25,0,0);
        add(addGrant,c);
        
        addGrant.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        
        removeAll();
        JPanel addGData = new addGrant();
        add(addGData);
        validate();
        repaint();
              }
    });
        
        
    }
    
}