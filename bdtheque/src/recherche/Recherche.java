/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package recherche;

import java.io.Serializable;
import java.util.TreeSet;
import model.Album;

/**
 *
 * @author Flo
 */
public interface Recherche extends Serializable{
    public TreeSet<Album> searchByKeyword(String keyword);
}
