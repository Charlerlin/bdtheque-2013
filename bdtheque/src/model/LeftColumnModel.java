/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.Observable;
import java.util.Observer;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

/**
 *
 * @author Florian Vanhecke
 */
public class LeftColumnModel extends DefaultTreeModel implements Observer{
    private BDT model;

    public LeftColumnModel(BDT model){
        super(new DefaultMutableTreeNode("BDtheque"));
        this.model = model;
        this.__build();
        model.addObserver(this);
    }

    private void __build(){
        DefaultMutableTreeNode authors = new DefaultMutableTreeNode("Auteurs",true);
        for(String s : this.model.getListeAuteurs().keySet()){
            authors.add(new DefaultMutableTreeNode(s,true));
        }
        

        DefaultMutableTreeNode series = new DefaultMutableTreeNode("Séries",true);
        for(String s : this.model.getListeSeries().keySet()){
            series.add(new DefaultMutableTreeNode(s,true));
        }

        DefaultMutableTreeNode genres = new DefaultMutableTreeNode("Genres",true);
        for(String s : this.model.getListeGenres().keySet()){
            genres.add(new DefaultMutableTreeNode(s,true));
        }

        for(String s : this.model.getListeTitres().keySet()){
            genres.add(new DefaultMutableTreeNode(s,true));
        }

        ((DefaultMutableTreeNode)this.getRoot()).add(authors);
        ((DefaultMutableTreeNode)this.getRoot()).add(series);
        ((DefaultMutableTreeNode)this.getRoot()).add(genres);

        //this.reload(root);
    }

    public void update(Observable o, Object arg) {
        if(arg == "JTree"){
            this.__build();
            ((DefaultMutableTreeNode)this.getRoot()).removeFromParent();
            this.reload(((DefaultMutableTreeNode)this.getRoot()));
        }
    }
}
