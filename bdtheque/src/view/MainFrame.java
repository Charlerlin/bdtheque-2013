/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeSelectionModel;
import model.BDT;
import model.LeftColumnModel;

/**
 *
 * @author Florian Vanhecke
 */
public class MainFrame extends JPanel implements Observer {

    private BDT model;
    private JTree leftFilters;

    public MainFrame(final BDT model) {
        super(new BorderLayout());
        this.model = model;
        this.model.addObserver(this);

        this.setLayout(new GridBagLayout());

        /** HEADER **/
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.weightx = 1.0;
        c.anchor = GridBagConstraints.FIRST_LINE_START;

        HeaderView v = new HeaderView();
        v.setPreferredSize(new Dimension(800, 100));
        v.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.DARK_GRAY));

        this.add(v, c);


        /** COLONNE DE GAUCHE **/
         GridBagConstraints c2 = new GridBagConstraints();
        c2.fill = GridBagConstraints.BOTH;
        c2.weightx = 0.1;
        c2.gridx = 0;
        c2.gridy = 1;
        
       
        leftFilters = new JTree(new LeftColumnModel(this.model));
        leftFilters.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        JScrollPane treeView = new JScrollPane(leftFilters, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        treeView.setBorder(new EmptyBorder(0, 0, 0, 0));

        TreeCellRenderer renderer = new ToolTipTreeCellRenderer();
        leftFilters.setCellRenderer(renderer);
        leftFilters.putClientProperty("Quaqua.Tree.style", "sourceList");
        this.add(treeView, c2);



        /** CORPS DE PAGE **/
        c2.fill = GridBagConstraints.BOTH;
        c2.weightx = 0.80;
        c2.anchor = GridBagConstraints.CENTER;
        c2.gridx = 1;
        c2.weighty = 1.0;
        c2.gridy = 1;
        ListingView content = new ListingView();
        JScrollPane contentView = new JScrollPane(content, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        contentView.setBorder(new EmptyBorder(0, 0, 0, 0));
        contentView.setBorder(BorderFactory.createMatteBorder( 0,1, 0, 0, Color.DARK_GRAY));
        this.add(contentView, c2);


        /** FOOTER **/
        GridBagConstraints c3 = new GridBagConstraints();

        c3.fill = GridBagConstraints.HORIZONTAL;
        c3.gridx = 0;
        c3.gridy = 2;
        c3.gridwidth = GridBagConstraints.REMAINDER;
        c3.weightx = 1.0;
        c3.ipady = 20;
        c3.anchor = GridBagConstraints.LAST_LINE_START;

        FooterView footer = new FooterView();
        footer.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.DARK_GRAY));

        this.add(footer, c3);
        
    }

    public void update(Observable o, Object arg) {
        if (arg != "JTree") {
            System.out.println("UPDATE");

        }
    }
}
