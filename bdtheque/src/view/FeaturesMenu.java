/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Florian Vanhecke
 */
public class FeaturesMenu extends JPanel {

    public FeaturesMenu() {
        ((FlowLayout)this.getLayout()).setVgap(0);
        java.net.URL imgURL = getClass().getResource("icons/plus.png");
        ImageIcon imgThisImg = null;
        imgThisImg = new ImageIcon(imgURL);
        JButton b = new JButton(imgThisImg);
        b.setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 0));
        b.setToolTipText("Ajouter un album");
        b.setPreferredSize(new Dimension(45, 25));
        b.setContentAreaFilled(false);
        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b.setFocusPainted(false);
        this.add(b);

        java.net.URL imgURL2 = getClass().getResource("icons/other.png");
        ImageIcon imgThisImg2 = null;
        imgThisImg2 = new ImageIcon(imgURL2);
        JButton b2 = new JButton(imgThisImg2);
        b2.setToolTipText("Importer/Exporter/Fusionner");
        b2.setPreferredSize(new Dimension(45, 25));
        b2.setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 0));
        b2.setContentAreaFilled(false);
        b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b2.setFocusPainted(false);
        this.add(b2);
        /*this.add(new JButton("*"));*/
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

          try {
            java.net.URL imgURL = getClass().getResource("icons/function.png");
            BufferedImage img;
            img = ImageIO.read(imgURL);
            g.drawImage(img, 50, 0, this);
        } catch (IOException ex) {
            Logger.getLogger(FeaturesMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
