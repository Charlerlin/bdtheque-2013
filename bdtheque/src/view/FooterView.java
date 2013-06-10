/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author Florian Vanhecke
 */
public class FooterView  extends JPanel {

    public FooterView(){
        this.setPreferredSize(new Dimension(800, 30));
       
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
