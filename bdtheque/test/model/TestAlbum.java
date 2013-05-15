package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestAlbum {

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
	
	
}
