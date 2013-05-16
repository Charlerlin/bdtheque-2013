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

	private Album a, b, c, d, e, f; 
	private TreeSet<String> forA, forE;

	@Before
	public void setup_test_equals(){
		a = new Album("titre", "scenariste", "dessinateur");
		b = new Album("titre", "scenariste", "dessinateur");
		c = new Album("titre", "scenariste", "dessinateur", "serie", 1);
		d = new Album("titre", "scenariste", "dessinateur", "serie", 1);
		e = new Album("titre", "scenariste", "dessinateur", "coloriste", "editeur", "serie", "genre", "synopsis", "commentaire", 1, 5, 30, 15);
		f = new Album("titre", "scenariste", "dessinateur", "coloriste1", "editeur2", "serie", "genre2", "synopsis2", "commentaire2", 1, 4, 29, 14);
		forA = new TreeSet<String>();
		forA.add("scenariste");
		forA.add("dessinateur");
		forE = new TreeSet<String>();
		forE.add("scenariste");
		forE.add("dessinateur");
		forE.add("coloriste");

	}
	@Test
	public void test_equals(){
		assertTrue(a.equals(b));
		assertTrue(c.equals(d));
		assertTrue(e.equals(f));
		assertTrue(c.equals(e));
	}
	@Test
	public void test_getAuteurs(){
		assertEquals(forA, a.getAuteurs());
		assertEquals(forE, e.getAuteurs());
	}

}
