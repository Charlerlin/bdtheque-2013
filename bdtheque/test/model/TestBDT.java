package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.Before;
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
		b.add(a);
		tsiJ.add(a.hashCode());
		tsiBM.add(a.hashCode());
		tsiLSE.add(a.hashCode());
		
		a = new Album("Le mystère de la grande Pyramide", "Jacob", "Jacob", "Blake et Mortimer", 2);
		b.add(a);
		tsiJ.add(a.hashCode());
		tsiBM.add(a.hashCode());
		tsiLMP.add(a.hashCode());
		
		a = new Album("La Marque Jaune", "Jacob", "Jacob", "Blake et Mortimer", 3);
		b.add(a);
		tsiJ.add(a.hashCode());
		tsiBM.add(a.hashCode());
		tsiLMJ.add(a.hashCode());
		
		a = new Album("L'énigme de l'Atlantide", "Jacob", "Jacob", "Blake et Mortimer", 4);
		b.add(a);
		tsiJ.add(a.hashCode());
		tsiBM.add(a.hashCode());
		tsiLEA.add(a.hashCode());
		
		a = new Album("L'affaire Francis Blake", "Jean Van Hamme", "Ted Benoit", "Blake et Mortimer", 9);
		b.add(a);
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
		b.add(a);
		
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
	
	@Test
	public void test_get_contains(){
		Album a = new Album("L'énigme de l'Atlantide", "Jacob", "Jacob", "Blake et Mortimer", 4);
		b = new BDT();
		b.add(a);
		assertEquals(a, b.get(a.hashCode()));
		assertTrue(b.contains(a));
		assertTrue(b.contains(a.hashCode()));
	}
	
	
	TreeSet<Integer> tshc;
	@Before
	public void setup_getBy(){
		b = new BDT();
		Album a1 = new Album("Le secret de l'espadon", "Jacob", "Jacob", "Blake et Mortimer", 1);
		b.add(a1);
	
		Album a2 = new Album("Le mystère de la grande Pyramide", "Jacob", "Jacob", "Blake et Mortimer", 2);
		b.add(a2);
	
		Album a3 = new Album("La Marque Jaune", "Jacob", "Jacob", "Blake et Mortimer", 3);
		b.add(a3);
		
		Album a4 = new Album("L'énigme de l'Atlantide", "Jacob", "Jacob", "Blake et Mortimer", 4);
		b.add(a4);

		Album a5 = new Album("L'affaire Francis Blake", "Jean Van Hamme", "Ted Benoit", "Blake et Mortimer", 9);
		b.add(a5);
		
		tshc = new TreeSet<Integer>();
		tshc.add(a3.hashCode());
		//tshc.add(a2.hashCode());
		//tshc.add(a1.hashCode());
		//tshc.add(a5.hashCode());
		//tshc.add(a4.hashCode());

	}
	@Test
	public void test_getBy(){
		assertEquals(tshc, b.getByTitre("La Marque Jaune"));
	}
	
	public void setup_remove(){
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
		b.add(a);
		tsiJ.add(a.hashCode());
		tsiBM.add(a.hashCode());
		tsiLSE.add(a.hashCode());
		
		a = new Album("Le mystère de la grande Pyramide", "Jacob", "Jacob", "Blake et Mortimer", 2);
		b.add(a);
		tsiJ.add(a.hashCode());
		tsiBM.add(a.hashCode());
		tsiLMP.add(a.hashCode());
		
		a = new Album("La Marque Jaune", "Jacob", "Jacob", "Blake et Mortimer", 3);
		b.add(a);
		tsiJ.add(a.hashCode());
		tsiBM.add(a.hashCode());
		tsiLMJ.add(a.hashCode());
		
		a = new Album("L'énigme de l'Atlantide", "Jacob", "Jacob", "Blake et Mortimer", 4);
		b.add(a);

		b.remove(a);
		
		a = new Album("L'affaire Francis Blake", "Jean Van Hamme", "Ted Benoit", "Blake et Mortimer", 9);
		b.add(a);
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
		lT.put("L'affaire Francis Blake", tsiLFB);
	}
	@Test
	public void test_remove(){
		setup_remove();
		assertEquals(lA, b.getListeAuteurs());
		assertEquals(lS, b.getListeSeries());
		assertEquals(lT, b.getListeTitres());
		//assertEquals(lG, b.getListeGenres());
	}

}
