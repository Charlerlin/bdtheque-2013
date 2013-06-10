package object;

import javax.swing.border.*;
import java.awt.*;
import java.awt.geom.*;

public class RoundedBorder extends AbstractBorder {

    private int left;

    public RoundedBorder(int left) {
        this.left = left;
    }

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int r = height - 1;
        RoundRectangle2D round = new RoundRectangle2D.Float(x, y, width - 1, height - 1, r, r);
        Container parent = c.getParent();
        if (parent != null) {
            g2.setColor(new Color(190, 190, 190));
            Area corner = new Area(new Rectangle2D.Float(x, y, width, height));
            corner.subtract(new Area(round));
            g2.fill(corner);
        }
        g2.setColor(new Color(178, 178, 178));
         
        g2.draw(round);
        g2.dispose();
    }

    public Insets getBorderInsets(Component c) {
        return new Insets(4, 8 + this.left, 4, 8);
    }

    public Insets getBorderInsets(Component c, Insets insets) {
        insets.left = 8 + this.left;
        insets.right = 8;
        insets.top = insets.bottom = 4;
        return insets;
    }


    public boolean isBorderOpaque() {
        return false;
    }
}
