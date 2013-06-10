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
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Florian Vanhecke
 */
public class TestPanel extends JPanel {

    public TestPanel() {
        this.setSize(150, 150);
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.gridx = 0;
        c.gridy = 0;

        c.weightx = 1;
        c.weighty =  1;
        
         TestPanel2 p = new TestPanel2();
         p.setSize(250, 150);
         p.setPreferredSize(new Dimension(250, 150));
        this.add(p,c);

    }

}
