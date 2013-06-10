/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.*;
import javax.swing.*;
import object.RoundedBorder;
import object.SearchField;

/**
 *
 * @author Florian Vanhecke
 */
public class HeaderView extends JPanel {

   

    public HeaderView() {
        this.setLayout(new BorderLayout());

        this.add(new LeftPanel(), BorderLayout.WEST);

        this.add(new SearchMenu(), BorderLayout.CENTER);

        this.add(new SortMenu(), BorderLayout.EAST);
    }

    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int w = getWidth();
        int h = getHeight();
        GradientPaint gp = new GradientPaint(
                0, 0, new Color(193, 193, 193),
                0, h, new Color(155, 155, 155));
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
    }
}

class LeftPanel extends JPanel {
    public LeftPanel(){
        this.setLayout(new GridLayout(1, 2));
          java.net.URL imgURL = getClass().getResource("icons/logo.png");
         ImageIcon imgThisImg = null;
        if (imgURL != null) {
           imgThisImg =  new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file:");

        }
        JLabel bs = new JLabel();
        bs.setIcon(imgThisImg);
        bs.setBorder(BorderFactory.createEmptyBorder(0, 20, 0,0));
        this.add( bs );
        this.add(new FeaturesMenu());
    }

    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int w = getWidth();
        int h = getHeight();
        GradientPaint gp = new GradientPaint(
                0, 0, new Color(193, 193, 193),
                0, h, new Color(155, 155, 155));
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
    }
}