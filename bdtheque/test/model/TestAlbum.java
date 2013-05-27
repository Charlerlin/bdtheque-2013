package model;

import static org.junit.Assert.*;

import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

public class TestAlbum {

	//---Test constructeurs
	@Test(expected=IllegalArgumentException.class)
	public void constr_titreVide(){
		new Album("","blabla", "bleble");
	}
	@Test(expected=IllegalArgumentException.class)
	public void constr_scenaristeVide(){
		new Album("blabla","","bleble");
	}
	@Test(expected=IllegalArgumentException.class)
	public void constr_serie0() throws IllegalAccessException{
		new Album("bla","ble","bli","blo",0);
	}

	@Test(expected=IllegalArgumentException.class)
	public void constr_titreNull(){
		new Album(null, "bla", "ble");
	}
	@Test(expected=IllegalArgumentException.class)
	public void constr_scenaristeNull(){
		new Album("bla", null, "bli");
	}
	@Test(expected=IllegalArgumentException.class)
	public void contr_dessinateurNull(){
		new Album("bla", "ble", null);
	}
	@Test(expected=IllegalArgumentException.class)
	public void constr_serieNull() {
		new Album("titre", "scenariste", "dessinateur", null, 0);
	}
	@Test(expected=IllegalArgumentException.class)
	public void constr_serieVide() {
		new Album("titre", "scenariste", "dessinateur", "", 0);
	}
	@Test(expected=IllegalArgumentException.class)
	public void constr_serieNoZero() {
		new Album("bla", "ble", "bli", "blo", 0);
	}
	//-- fin test constructeurs

	private Album a, b, c, d, e, f, g, h, i, j, k, l, m, n; 
	private TreeSet<String> forA, forE, forG;

	@Before
	public void setup_test_equals(){
		a = new Album("titre", "scenariste", "dessinateur");
		b = new Album("titre  ", "scenariste  ", "  dessinateur");
		c = new Album("titre", "scenariste", "dessinateur", "serie", 1);
		d = new Album("titre", "scenariste", "dessinateur", "serie", 1);
		e = new Album("titre", "scenariste", "dessinateur", "serie", 1, "coloriste", "editeur",  "genre", "synopsis", "commentaire", 5, 30, 15);
		f = new Album("titre", "scenariste", "dessinateur", "serie", 1, "coloriste1", "editeur2", "genre2", "synopsis2", "commentaire2", 4, 29, 14);
		forA = new TreeSet<String>();
		forA.add("scenariste");
		forA.add("dessinateur");
		forE = new TreeSet<String>();
		forE.add("scenariste");
		forE.add("dessinateur");
		forE.add("coloriste");

		g = new Album("titre", "lememe", "lememe");
		forG = new TreeSet<String>();
		forG.add("lememe");

		h = new Album("TiTre", "SceNAriste", "DESSinateur");
		i = new Album("titre", "scenariste", "dessinateur");

		j = new Album("TITRE", "SCENARISTE", "DESSINATEUR", "SERIE", 1);
		k = new Album("titre", "scenariste", "dessinateur", "serie", 1);

		l = new Album("TITRE", "SCENARiste", "DESSinateur", "SERie", 1, "COLOriste", "EDIteur", "GENre", "SYNOPsis", "COMMentaire", 4, 29, 14);
		m = new Album("titre", "scenariste", "dessinateur", "serie", 1, "coloriste1", "editeur2", "genre2", "synopsis2", "commentaire2", 4, 29, 14);
		
		n = new Album("titreA", "scenaristeA", "dessinateurA", null, null, null, null, null, 66, 66, 66);

	}
	@Test
	public void test_equals(){
		assertTrue(a.equals(b));
		assertTrue(c.equals(d));
		assertTrue(e.equals(f));
		assertTrue(c.equals(e));
	}
	@Test
	public void test_hashcode(){
		assertEquals(0, a.hashCode()-b.hashCode());
		assertEquals(0, c.hashCode()-d.hashCode());
		assertEquals(0, e.hashCode()-f.hashCode());
		assertEquals(0, c.hashCode()-e.hashCode());
	}
	@Test
	public void test_getAuteurs(){
		assertEquals(forA, a.getAuteurs());
		assertEquals(forE, e.getAuteurs());
		assertEquals(forG, g.getAuteurs());
	}
	@Test
	public void test_lowercase(){
		assertTrue(h.equals(i));
		assertTrue(j.equals(k));
		assertTrue(l.equals(m));
	}


	@Test
	public void test_attributsNonNuls(){
		assertEquals("", n.getColoriste());
		assertEquals("", n.getEditeur());
		assertEquals("", n.getSerie());
		assertEquals("", n.getGenre());
		assertEquals("", n.getSynopsis());
		assertEquals("", n.getCommentaire());
	}
	
	@Test
	public void test_formatGenre(){
		assertEquals("Genre", l.getGenre());
	}

}
