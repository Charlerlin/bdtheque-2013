package model;

import java.util.HashMap;
import java.util.TreeMap;

public class BDT {
	private HashMap<Integer, Album> listeAlbums;
	private TreeMap<String, Integer> listeTitres, listeSeries, listeAuteurs, listeGenres;

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
			if(!a.getSerie().isEmpty())
				gestionIndexAjout(a, "serie");
			if(!a.getGenre().isEmpty())
				gestionIndexAjout(a, "genre");
			return true;
		}
	}

	private void gestionIndexAjout(Album a, String idx){
		if(idx.equals("titre")){
			if(listeTitres.containsKey(a.getTitre())){
				int nbTitres = listeTitres.remove(a.getTitre()); //nombre d'albums ayant ce titre
				listeTitres.put(a.getTitre(), ++nbTitres);
			}
			else{
				listeTitres.put(a.getTitre(), 1);
			}
		}
		if(idx.equals("serie")){
			if(listeSeries.containsKey(a.getSerie())){
				int nbSerie = listeSeries.remove(a.getSerie()); //nombre d'albums dans la série
				listeSeries.put(a.getSerie(), ++nbSerie);
			}
			else{
				listeSeries.put(a.getSerie(), 1);
			}
		}
		if(idx.equals("auteurs")){
			for(String aut : a.getAuteurs()){
				if(listeAuteurs.containsKey(aut)){
					int nbAuteurs = listeAuteurs.remove(aut); //nombre d'albums correspondants à cet auteur
					listeAuteurs.put(aut, ++nbAuteurs);
				}
				else{
					listeAuteurs.put(aut, 1);
				}
			}
		}
		if(idx.equals("genre")){
			if(listeGenres.containsKey(a.getTitre())){
				int nbGenres = listeGenres.remove(a.getGenre()); //nombre d'albums de ce genre
				listeGenres.put(a.getGenre(), ++nbGenres);
			}
			else{
				listeGenres.put(a.getGenre(), 1);
			}
		}
	}
	
	//-- GETTERS
	public HashMap<Integer, Album> getListeAlbums(){
		return listeAlbums;
	}

	public TreeMap<String, Integer> getListeTitres() {
		return listeTitres;
	}

	public TreeMap<String, Integer> getListeSeries() {
		return listeSeries;
	}

	public TreeMap<String, Integer> getListeAuteurs() {
		return listeAuteurs;
	}

	public TreeMap<String, Integer> getListeGenres() {
		return listeGenres;
	}
	
	//-- fin getters


}
