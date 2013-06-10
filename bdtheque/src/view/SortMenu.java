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
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Florian Vanhecke
 */
public class SortMenu extends JPanel {

    private String[] sorter = {"Titre", "Auteur", "Note"};

    public SortMenu() {
        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(150,500));
        JLabel sort = new JLabel("Trier par : ",JLabel.CENTER);
        this.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
        JComboBox sorterList = new JComboBox(this.sorter);
        sorterList.setPreferredSize(new Dimension(150,20));
        sorterList.setSelectedIndex(0);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.CENTER;
        c.ipadx = 10;
        c.ipady = 10;
        this.add(sort,c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.ipadx = 0;
        c.weightx = 1.0;
        c.ipady = 0;
        this.add(sorterList,c);

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
