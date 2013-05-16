package model;

import java.util.TreeSet;

/**
 * 
 * @author charlerlin
 * @author Aegils
 * @author CyrilMaertens
 *
 */

public class Album {
	private String titre, scenariste, dessinateur, coloriste, editeur, serie, genre, synopsis, commentaire;
	private int noserie, note, nbplanches, prix;
	// TODO ajouter l'illustration
	/*il faut trouver une hiérarchie de fichiers pour stocker les illustrations, dans ce cas, 
	 * on n'utilisera plus que le chemin, sous forme de String
	 */

	//---Constructeurs
	public Album() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Construit un Album en donnant juste le titre et l'auteur, constructeur minimal
	 * Les paramètres ne peuvent-être null ou vides
	 * @param titre
	 * @param scenariste
	 * @param dessinateur
	 * @throws IllegalArgumentException
	 */
	public Album(String titre, String scenariste, String dessinateur) throws IllegalArgumentException{
		if(titre==null || titre.isEmpty())
			throw new IllegalArgumentException("Titre vide");
		else
			this.titre = titre; 
		if(scenariste==null || scenariste.isEmpty())
			throw new IllegalArgumentException("Scenariste vide");
		else
			this.scenariste = scenariste;
		if(dessinateur==null || dessinateur.isEmpty())
			throw new IllegalArgumentException("Dessinateur vide");
		else
			this.dessinateur = dessinateur;
		coloriste = new String();
	}

	/**
	 * Contruit un Album en donnant le titre, l'auteur, la série et le numéro
	 * si la série n'est pas vide, le numéro ne peut pas être zéro
	 * @param titre
	 * @param scenariste
	 * @param dessinateur
	 * @param serie
	 * @param noserie
	 * @throws IllegalArgumentException
	 */
	public Album(String titre, String scenariste, String dessinateur, String serie, int noserie) 
			throws IllegalArgumentException {
		this(titre, scenariste, dessinateur);
		if(serie!=null && !serie.isEmpty()){
			if(noserie==0)
				throw new IllegalArgumentException("Numero de série zéro");
			else{
				this.serie = serie;
				this.noserie = noserie;
			}
		}
		else
			throw new IllegalArgumentException("Série vide");
	}
	
	/**
	 * Construit un Album en fournissant tous les paramètres
	 * (cf autres constructeurs)
	 * Si les chaines sont nulls, elles seront remplacées par des chaines vides 
	 * @param titre
	 * @param scenariste
	 * @param dessinateur
	 * @param coloriste
	 * @param editeur
	 * @param serie
	 * @param genre
	 * @param synopsis
	 * @param commentaire
	 * @param noserie
	 * @param note
	 * @param nbplanches
	 * @param prix
	 * @throws IllegalArgumentException
	 */
	public Album(String titre, String scenariste, String dessinateur, String coloriste, 
			String editeur, String serie, String genre, String synopsis, String commentaire, 
			int noserie, int note, int nbplanches, int prix) {
		this(titre, scenariste, dessinateur, serie, noserie);
		this.coloriste = nonNull(coloriste);
		this.editeur = nonNull(editeur);
		this.genre = nonNull(genre);
		this.synopsis = nonNull(synopsis);
		this.commentaire = nonNull(commentaire);
		this.note = note;
		this.nbplanches = nbplanches;
		this.prix = prix;
	}
	//----Fin constructeurs
	
	//----Static
	/**
	 * Garantit de ne pas avoir de String null, renvoie une String vide
	 * @param s
	 * @return String vide
	 */
	public String nonNull(String s){
		if(s==null)
			return new String("");
		else
			return s;
	}
	//----Fin static
	

	//----Getters
	public String getTitre() {
		return titre;
	}

	public String getScenariste() {
		return scenariste;
	}
	
	public String getDessinateur(){
		return dessinateur;
	}
	
	public String getColoriste(){
		return coloriste;
	}
	
	public TreeSet<String> getAuteurs(){
		TreeSet<String> ret = new TreeSet<String>();
		ret.add(scenariste);
		ret.add(dessinateur);
		if(!coloriste.isEmpty())
			ret.add(coloriste);
		return ret;
	}

	public String getGenre() {
		return genre;
	}
	
	public String getSerie(){
		return serie;
	}

	public String getEditeur() {
		return editeur;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public int getNoserie() {
		return noserie;
	}

	public int getNote() {
		return note;
	}

	public int getNbplanches() {
		return nbplanches;
	}

	public int getPrix() {
		return prix;
	}
	//----Fin getters

	
	

	//-- HashCode & Equals

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dessinateur == null) ? 0 : dessinateur.hashCode());
		result = prime * result + noserie;
		result = prime * result
				+ ((scenariste == null) ? 0 : scenariste.hashCode());
		result = prime * result + ((serie == null) ? 0 : serie.hashCode());
		result = prime * result + ((titre == null) ? 0 : titre.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Album other = (Album) obj;
		if (dessinateur == null) {
			if (other.dessinateur != null)
				return false;
		} else if (!dessinateur.equals(other.dessinateur))
			return false;
		if (noserie != other.noserie)
			return false;
		if (scenariste == null) {
			if (other.scenariste != null)
				return false;
		} else if (!scenariste.equals(other.scenariste))
			return false;
		if (serie == null) {
			if (other.serie != null)
				return false;
		} else if (!serie.equals(other.serie))
			return false;
		if (titre == null) {
			if (other.titre != null)
				return false;
		} else if (!titre.equals(other.titre))
			return false;
		return true;
	}
	
	//-- fin hashcode & equals

}
