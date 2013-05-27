package model;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;

public class TestBDT {
	
	@Test
	public void test_constr(){
		BDT b = new BDT();
		assertEquals(new HashMap<Integer, Album>(), b.getListeAlbums());
	}
	
	BDT b;
	TreeMap<String, Integer> lA, lS, lT, lG;
	
	public void setup_listeBase(){
		b = new BDT();
		Album a = new Album("Le secret de l'espadon", "Jacob", "Jacob", "Blake et Mortimer", 1);
		b.ajouter(a);
		a = new Album("Le mystère de la grande Pyramide", "Jacob", "Jacob", "Blake et Mortimer", 2);
		b.ajouter(a);
		a = new Album("La Marque Jaune", "Jacob", "Jacob", "Blake et Mortimer", 3);
		b.ajouter(a);
		a = new Album("L'énigme de l'Atlantide", "Jacob", "Jacob", "Blake et Mortimer", 4);
		b.ajouter(a);
		a = new Album("L'affaire Francis Blake", "Jean Van Hamme", "Ted Benoit", "Blake et Mortimer", 9);
		b.ajouter(a);
		
		lA = new TreeMap<String, Integer>(); //listeAuteurs
		lA.put("Jacob", 4);
		lA.put("Jean Van Hamme", 1);
		lA.put("Ted Benoit", 1);
		
		lS = new TreeMap<String, Integer>();
		lS.put("Blake et Mortimer", 5);
		
		lT = new TreeMap<String, Integer>();
		lT.put("Le secret de l'espadon", 1);
		lT.put("Le mystère de la grande Pyramide", 1);
		lT.put("La Marque Jaune", 1);
		lT.put("L'énigme de l'Atlantide", 1);
		lT.put("L'affaire Francis Blake", 1);
		
		lG = new TreeMap<String, Integer>();
		
		
	}
	@Test
	public void test_listeBase(){
		setup_listeBase();
		assertEquals(lA, b.getListeAuteurs());
		assertEquals(lS, b.getListeSeries());
		assertEquals(lT, b.getListeTitres());
		assertEquals(lG, b.getListeGenres());
	}
	
	public void setup_listeComp(){
		b = new BDT();
		Album a = new Album("Le Secret de l'Espadon", "Jacob", "Jacob", "Blake et Mortimer", 1, "Jacquart", "Le Belge", "aVentUre", "construire l'espadon", "trop  bien", 5, 50, 15);
		b.ajouter(a);
		
		lA = new TreeMap<String, Integer>(); //listeAuteurs
		lA.put("Jacob", 1);
		lA.put("Jacquart", 1);
		
		lS = new TreeMap<String, Integer>();
		lS.put("Blake et Mortimer", 1);
		
		lT = new TreeMap<String, Integer>();
		lT.put("Le secret de l'espadon", 1);
		
		lG = new TreeMap<String, Integer>();
		lG.put("Aventure", 1);
	}
	@Test
	public void test_listeComp(){
		setup_listeComp();
		assertEquals(lA, b.getListeAuteurs());
		assertEquals(lS, b.getListeSeries());
		assertEquals(lT, b.getListeTitres());
		assertEquals(lG, b.getListeGenres());
	}

}
