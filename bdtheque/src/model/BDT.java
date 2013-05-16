package model;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class BDT {
	private HashMap<Integer, Album> listeAlbums;
	private TreeMap<String, Integer> listeTitres, listeGenres, listeAuteurs, listeSeries;

	public BDT(){
		listeAlbums = new HashMap<Integer, Album>();
		listeTitres = new TreeMap<String, Integer>();
		listeAuteurs = new TreeMap<String, Integer>();
		listeSeries = new TreeMap<String, Integer>();
		listeGenres = new TreeMap<String, Integer>();
	}

	public boolean contains(Album a){
		return listeAlbums.containsKey(a.hashCode());
	}

	public boolean ajouter(Album a){
		if(contains(a))
			return false;
		else{
			listeAlbums.put(a.hashCode(), a);
			gestionIndexAjout(a, "titre");
			gestionIndexAjout(a, "auteurs");
			gestionIndexAjout(a, "genre");
			return true;
		}
	}

	private void gestionIndexAjout(Album a, String idx){
		if(idx.equals("titre")){
			if(listeTitres.containsKey(a.getTitre())){
				int nbTitres = listeTitres.remove(a.getTitre());
				listeTitres.put(a.getTitre(), ++nbTitres);
			}
			else{
				listeTitres.put(a.getTitre(), 1);
			}
		}
		if(idx.equals("auteurs")){
			for(String aut : a.getAuteurs()){
				if(listeAuteurs.containsKey(aut)){
					int nbAuteurs = listeAuteurs.remove(aut);
					listeAuteurs.put(aut, ++nbAuteurs);
				}
				else{
					listeAuteurs.put(aut, 1);
				}
			}
		}
	}


}
