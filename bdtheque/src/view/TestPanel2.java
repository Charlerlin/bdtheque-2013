/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author Florian Vanhecke
 */
public class TestPanel2 extends JPanel{

    public TestPanel2(){
        this.setSize(250,150);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
    }

    protected void paintComponent(Graphics g) {
        try {
            g.setColor(Color.blue);
            int w = getWidth();
            int h = getHeight();
            g.fillRect(0, 0, w, h);
            java.net.URL uri = getClass().getResource("icons/album.png");
            BufferedImage i = ImageIO.read(uri);
            g.drawImage(i, 0, 0, this);
        } catch (IOException ex) {
            Logger.getLogger(TestPanel2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
