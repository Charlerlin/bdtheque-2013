/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import object.ObjectSize;

/**
 *
 * @author Florian Vanhecke
 */
public class ListingView extends JPanel implements Observer {

    private ObjectSize sizeListener;
    private JScrollPane content ;
    public static final int BLOC_WIDTH = 250 ;
    
    public ListingView() {
        this.sizeListener = new ObjectSize(this);
       // this.addComponentListener(sizeListener);
       this.setLayout(new GridLayout(3, 3));
       for(int i = 0; i < 9; i++){
           TestPanel p = new TestPanel();
          
           this.add(p);
       }
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

    public void update(Observable o, Object arg) {
        if((String) arg == "SIZE"){
           
        }
    }

   

}
