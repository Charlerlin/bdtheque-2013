package view;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.ToolTipManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Florian Vanhecke
 */
public class ToolTipTreeCellRenderer implements TreeCellRenderer {

    DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();

    public ToolTipTreeCellRenderer() {
    }

    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        renderer.getTreeCellRendererComponent(tree, value, selected, expanded,
                leaf, row, hasFocus);
        ToolTipManager.sharedInstance().registerComponent(tree);
        if (value != null) {
            if (leaf) {
                renderer.setToolTipText(value.toString());
                   
            } else {
                if(value.toString().equals("Auteurs")){
                    java.net.URL authorsUrl = getClass().getResource("icons/authors.gif");
                    ImageIcon authorsIcon = new ImageIcon(authorsUrl);
                    renderer.setIcon(authorsIcon);
                }

                if(value.toString().equals("Genres")){
                    java.net.URL genressUrl = getClass().getResource("icons/genres.gif");
                    ImageIcon authorsIcon = new ImageIcon(genressUrl);
                    renderer.setIcon(authorsIcon);
                }
                
                renderer.setToolTipText(null);
            }
        }
       
        return renderer;
    }
}
