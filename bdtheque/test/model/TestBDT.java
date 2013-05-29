package model;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.Test;

public class TestBDT {
	
	@Test
	public void test_constr(){
		BDT b = new BDT();
		assertEquals(new HashMap<Integer, Album>(), b.getListeAlbums());
	}
	
	BDT b;
	TreeMap<String, TreeSet<Integer>> lA, lS, lT, lG;
	TreeSet<Integer> tsiJ, tsiJVH, tsiTB, tsiBM, tsiLSE, tsiLMP, tsiLMJ, tsiLEA, tsiLFB;
	
	public void setup_listeBase(){
		b = new BDT();
		
		tsiJ = new TreeSet<Integer>(); //Jacob
		tsiJVH = new TreeSet<Integer>(); //JVH
		tsiTB = new TreeSet<Integer>(); //TB
		tsiBM = new TreeSet<Integer>(); //Blake et Mortimer
		tsiLSE = new TreeSet<Integer>(); //le secret de l'espadon
		tsiLMP = new TreeSet<Integer>(); //le mystère de la grande pyramide
		tsiLMJ = new TreeSet<Integer>(); //la marque jaune
		tsiLEA = new TreeSet<Integer>(); //l'énigme de l'atlantide
		tsiLFB = new TreeSet<Integer>(); //l'affaire Francis Blake
		
		Album a = new Album("Le secret de l'espadon", "Jacob", "Jacob", "Blake et Mortimer", 1);
		b.ajouter(a);
		tsiJ.add(a.hashCode());
		tsiBM.add(a.hashCode());
		tsiLSE.add(a.hashCode());
		
		a = new Album("Le mystère de la grande Pyramide", "Jacob", "Jacob", "Blake et Mortimer", 2);
		b.ajouter(a);
		tsiJ.add(a.hashCode());
		tsiBM.add(a.hashCode());
		tsiLMP.add(a.hashCode());
		
		a = new Album("La Marque Jaune", "Jacob", "Jacob", "Blake et Mortimer", 3);
		b.ajouter(a);
		tsiJ.add(a.hashCode());
		tsiBM.add(a.hashCode());
		tsiLMJ.add(a.hashCode());
		
		a = new Album("L'énigme de l'Atlantide", "Jacob", "Jacob", "Blake et Mortimer", 4);
		b.ajouter(a);
		tsiJ.add(a.hashCode());
		tsiBM.add(a.hashCode());
		tsiLEA.add(a.hashCode());
		
		a = new Album("L'affaire Francis Blake", "Jean Van Hamme", "Ted Benoit", "Blake et Mortimer", 9);
		b.ajouter(a);
		tsiJVH.add(a.hashCode());
		tsiTB.add(a.hashCode());
		tsiBM.add(a.hashCode());
		tsiLFB.add(a.hashCode());
		
		lA = new TreeMap<String, TreeSet<Integer>>(); //listeAuteurs
		lA.put("Jacob", tsiJ);
		lA.put("Jean Van Hamme", tsiJVH);
		lA.put("Ted Benoit", tsiTB);
		
		lS = new TreeMap<String, TreeSet<Integer>>();
		lS.put("Blake et Mortimer", tsiBM);
		
		lT = new TreeMap<String, TreeSet<Integer>>();
		lT.put("Le secret de l'espadon", tsiLSE);
		lT.put("Le mystère de la grande Pyramide", tsiLMP);
		lT.put("La Marque Jaune", tsiLMJ);
		lT.put("L'énigme de l'Atlantide", tsiLEA);
		lT.put("L'affaire Francis Blake", tsiLFB);
		
		lG = new TreeMap<String, TreeSet<Integer>>();
		
		
	}
	@Test
	public void test_listeBase(){
		setup_listeBase();
		assertEquals(lA, b.getListeAuteurs());
		assertEquals(lS, b.getListeSeries());
		assertEquals(lT, b.getListeTitres());
		assertEquals(lG, b.getListeGenres());
	}
	
	TreeSet<Integer> tsi;
	
	public void setup_listeComp(){
		b = new BDT();
		Album a = new Album("Le Secret de l'Espadon", "Jacob", "Jacob", "Blake et Mortimer", 1, "Jacquart", "Le Belge", "aVentUre", "construire l'espadon", "trop  bien", 5, 50, 15);
		b.ajouter(a);
		
		tsi = new TreeSet<Integer>();
		tsi.add(a.hashCode());
		
		lA = new TreeMap<String, TreeSet<Integer>>(); //listeAuteurs
		lA.put("Jacob", tsi);
		lA.put("Jacquart", tsi);
		
		lS = new TreeMap<String, TreeSet<Integer>>();
		lS.put("Blake et Mortimer", tsi);
		
		lT = new TreeMap<String, TreeSet<Integer>>();
		lT.put("Le Secret de l'Espadon", tsi);
		
		lG = new TreeMap<String, TreeSet<Integer>>();
		lG.put("Aventure", tsi);
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
