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

	public boolean isEmpty(){
		return listeAlbums.isEmpty();
	}
	public int size(){
		return listeAlbums.size();
	}
	public boolean contains(int hc){
		return listeAlbums.containsKey(hc);
	}
	public boolean contains(Album a){
		return listeAlbums.containsKey(a.hashCode());
	}

	public boolean add(Album a){
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

	public Album get(int hc){
		return listeAlbums.get(hc);
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
	
	public boolean remove(Album a){
		if(!contains(a))
			return false;
		else{
			listeAlbums.remove(a.hashCode());
			gestionIndexSupp(a, "titre");
			gestionIndexSupp(a, "auteurs");
			if(!a.getSerie().isEmpty())
				gestionIndexSupp(a, "serie");
			if(!a.getGenre().isEmpty())
				gestionIndexSupp(a, "genre");
			return true;
		}
	}
	
	private void gestionIndexSupp(Album a, String idx){
		if(idx.equals("titre")){
			listeTitres.get(a.getTitre()).remove(a.hashCode());
			if (listeTitres.get(a.getTitre()).isEmpty()) {
				listeTitres.remove(a.getTitre());
			}
		}
		if(idx.equals("serie")){
			listeSeries.get(a.getSerie()).remove(a.hashCode());
			if (listeSeries.get(a.getSerie()).isEmpty()) {
				listeSeries.remove(a.getSerie());
			}
		}
		if(idx.equals("auteurs")){
			for(String aut : a.getAuteurs()){
				listeAuteurs.get(aut).remove(a.hashCode());
				if (listeAuteurs.get(aut).isEmpty()) {
					listeAuteurs.remove(a.getSerie());
				}
			}
		}
		if(idx.equals("genre")){
			listeGenres.get(a.getGenre()).remove(a.hashCode());
			if (listeGenres.get(a.getGenre()).isEmpty()) {
				listeGenres.remove(a.getGenre());
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

	public TreeSet<Album> getByTitre(String s){
		s = s.trim();
		TreeSet<Album> ret = new TreeSet<Album>();
		if(!listeTitres.containsKey(s)){
			return ret;
		}
		else{
			TreeSet<Integer> tmp = listeTitres.get(s);
			for(int i : tmp){
				ret.add(listeAlbums.get(i));
			}
			return ret;
		}
	}

	//-- fin getters


}
