package model;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class BDT {
	private HashMap<Integer, Album> listeAlbums;
	private TreeMap<String, TreeSet<Integer>> listeTitres, listeSeries, listeAuteurs, listeGenres;

	public BDT(){
		listeAlbums = new HashMap<Integer, Album>();
		listeTitres = new TreeMap<String, TreeSet<Integer>>();
		listeAuteurs = new TreeMap<String, TreeSet<Integer>>();
		listeSeries = new TreeMap<String, TreeSet<Integer>>();
		listeGenres = new TreeMap<String, TreeSet<Integer>>();
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
				listeTitres.get(a.getTitre()).add(a.hashCode());
			}
			else{
				TreeSet<Integer> tsi = new TreeSet<Integer>();
				tsi.add(a.hashCode());
				listeTitres.put(a.getTitre(), tsi);
			}
		}
		if(idx.equals("serie")){
			if(listeSeries.containsKey(a.getSerie())){
				listeSeries.get(a.getSerie()).add(a.hashCode());
			}
			else{
				TreeSet<Integer> tsi = new TreeSet<Integer>();
				tsi.add(a.hashCode());
				listeSeries.put(a.getSerie(), tsi);
			}
		}
		if(idx.equals("auteurs")){
			for(String aut : a.getAuteurs()){
				if(listeAuteurs.containsKey(aut)){
					listeAuteurs.get(aut).add(a.hashCode());
				}
				else{
					TreeSet<Integer> tsi = new TreeSet<Integer>();
					tsi.add(a.hashCode());
					listeAuteurs.put(aut, tsi);
				}
			}
		}
		if(idx.equals("genre")){
			if(listeGenres.containsKey(a.getTitre())){
				listeGenres.get(a.getGenre()).add(a.hashCode());
			}
			else{
				TreeSet<Integer> tsi = new TreeSet<Integer>();
				tsi.add(a.hashCode());
				listeGenres.put(a.getGenre(), tsi);
			}
		}
	}
	
	//-- GETTERS
	public HashMap<Integer, Album> getListeAlbums(){
		return listeAlbums;
	}

	public TreeMap<String,TreeSet<Integer>> getListeTitres() {
		return listeTitres;
	}

	public TreeMap<String,TreeSet<Integer>> getListeSeries() {
		return listeSeries;
	}

	public TreeMap<String,TreeSet<Integer>> getListeAuteurs() {
		return listeAuteurs;
	}

	public TreeMap<String,TreeSet<Integer>> getListeGenres() {
		return listeGenres;
	}
	
	//-- fin getters


}
