/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recherche;

import java.util.Map;
import java.util.TreeSet;
import model.Album;
import model.BDT;

/**
 *
 * @author Florian Vanhecke
 */
public class RechercheLevenshtein implements Recherche{

    private BDT bdtheque;

    public RechercheLevenshtein(BDT bdtheque) {
        this.bdtheque = bdtheque;
    }

    public TreeSet<Album> searchByKeyword(String keyword) {
        TreeSet<Album> searchResult = new TreeSet<Album>();
        int i = 0;
        for (Map.Entry<String, TreeSet<Integer>> entry : this.bdtheque.getListeTitres().entrySet()) {
            TreeSet<Integer> albumsIndexes = entry.getValue();
            String title = entry.getKey();
            if (this.getSearchMatching(title, keyword) >= 50) {
                for (Integer index : albumsIndexes) {
                    searchResult.add((Album)this.bdtheque.get(index));
                }
            }
        }

        for (Map.Entry<String, TreeSet<Integer>> entry : this.bdtheque.getListeSeries().entrySet()) {
            TreeSet<Integer> albumsIndexes = entry.getValue();
            String title = entry.getKey();
            if (this.getSearchMatching(title, keyword) >= 50) {
                for (Integer index : albumsIndexes) {
                    searchResult.add(this.bdtheque.get(index));
                }
            }
        }

        for (Map.Entry<String, TreeSet<Integer>> entry : this.bdtheque.getListeAuteurs().entrySet()) {
            TreeSet<Integer> albumsIndexes = entry.getValue();
            String title = entry.getKey();
            if (this.getSearchMatching(title, keyword) >= 50) {
                for (Integer index : albumsIndexes) {
                    searchResult.add(this.bdtheque.get(index));
                }
            }
        }

        for (Map.Entry<String, TreeSet<Integer>> entry : this.bdtheque.getListeGenres().entrySet()) {
            TreeSet<Integer> albumsIndexes = entry.getValue();
            String title = entry.getKey();
            if (this.getSearchMatching(title, keyword) >= 50) {
                for (Integer index : albumsIndexes) {
                    searchResult.add(this.bdtheque.get(index));
                }
            }
        }
        return searchResult;
    }

    private int minimum(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    public float getSearchMatching(CharSequence str1, CharSequence str2) {
        int distance = this.LevenshteinDistance(str1, str2);
        float longestString = (str1.length() > str2.length()) ? str1.length() : str2.length();
        return ((1 - (distance / longestString)) * 100);
    }

    public int LevenshteinDistance(CharSequence str1, CharSequence str2) {
        int[][] distance = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i <= str1.length(); i++) {
            distance[i][0] = i;
        }
        for (int j = 1; j <= str2.length(); j++) {
            distance[0][j] = j;
        }

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                distance[i][j] = this.minimum(
                        distance[i - 1][j] + 1,
                        distance[i][j - 1] + 1,
                        distance[i - 1][j - 1]
                        + ((str1.charAt(i - 1) == str2.charAt(j - 1)) ? 0
                        : 1));
            }
        }

        return distance[str1.length()][str2.length()];
    }
}
