/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package object;

import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.Observable;
import java.util.Observer;
import view.ListingView;

/**
 *
 * @author Florian Vanhecke
 */
public class ObjectSize extends Observable implements ComponentListener{

    private Dimension size = new Dimension(0, 0);

    public ObjectSize(ListingView  p){

        this.addObserver(p);
    }

    public Dimension getSize(){
        return this.size ;
    }

     public void componentResized(ComponentEvent e) {
        this.size = e.getComponent().getSize();
        this.setChanged();
        this.notifyObservers("SIZE");
    }
   

    public void componentMoved(ComponentEvent e) {
         this.size = e.getComponent().getSize();
        this.setChanged();
        this.notifyObservers("SIZE");
    }

    public void componentShown(ComponentEvent e) {
       
    }

    public void componentHidden(ComponentEvent e) {
       
    }


}
