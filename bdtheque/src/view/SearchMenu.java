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
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.JTextField;
import object.RoundedBorder;
import object.SearchField;

/**
 *
 * @author Florian Vanhecke
 */
public class SearchMenu extends JPanel{
    private JTextField search;

    public SearchMenu(){
        this.setLayout(new GridBagLayout());
        this.search = new SearchField(new JTextField(), "loupe", "Rechercher ...");
        this.search.setMargin(new Insets(0, 20, 0, 0));
        this.search.setPreferredSize(new Dimension(320, 30));
        this.search.putClientProperty(
               "Quaqua.TextField.style","search"
            );
        this.add(search);

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
