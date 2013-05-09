package model;

/**
 * 
 * @author charlerlin
 * @author Aegils
 * @author CyrilMaertens
 *
 */

public class Album {
	private String titre, auteur, editeur, serie, genre, synopsis, commentaire;
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
	 * @param auteur
	 * @throws IllegalArgumentException
	 */
	public Album(String titre, String auteur) throws IllegalArgumentException{
		if(titre==null || titre.isEmpty())
			throw new IllegalArgumentException("Titre vide");
		else
			this.titre = titre; 
		if(auteur==null || auteur.isEmpty())
			throw new IllegalArgumentException("Auteur vide");
		else
			this.auteur = auteur;
	}

	/**
	 * Contruit un Album en donnant le titre, l'auteur, la série et le numéro
	 * si la série n'est pas vide, le numéro ne peut pas être zéro
	 * @param titre
	 * @param auteur
	 * @param serie
	 * @param noserie
	 * @throws IllegalAccessException
	 */
	public Album(String titre, String auteur, String serie, int noserie) throws IllegalAccessException {
		this(titre, auteur);
		if(serie!=null && !serie.isEmpty()){
			if(noserie==0)
				throw new IllegalArgumentException("Numero de série zéro");
			else{
				this.serie = serie;
				this.noserie = noserie;
			}
		}
		else
			throw new IllegalAccessException("Série vide");
	}
	
	/**
	 * Construit un Album en fournissant tous les paramètres
	 * (cf autres constructeurs)
	 * Si les chaines sont nulls, elles seront remplacées par des chaines vides 
	 * @param titre
	 * @param auteur
	 * @param editeur
	 * @param serie
	 * @param genre
	 * @param synopsis
	 * @param commentaire
	 * @param noserie
	 * @param note
	 * @param nbplanches
	 * @param prix
	 * @throws IllegalAccessException
	 */
	public Album(String titre, String auteur, String editeur, String serie, 
			String genre, String synopsis, String commentaire, int noserie, 
			int note, int nbplanches, int prix) throws IllegalAccessException {
		this(titre, auteur, serie, noserie);
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
	 * @return
	 */
	public String nonNull(String s){
		if(s==null)
			return new String();
		else
			return s;
	}
	//----Fin static
	

	//----Getters
	public String getTitre() {
		return titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public String getGenre() {
		return genre;
	}
	
	public String getSerie(){
		return serie;
	}
	//----Fin getters

	

}
