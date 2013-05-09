package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestAlbum {

	@Test(expected=IllegalArgumentException.class)
	public void constr_titreVide(){
		new Album("","blabla");
	}
	@Test(expected=IllegalArgumentException.class)
	public void constr_auteurVide(){
		new Album("blabla","");
	}
	@Test(expected=IllegalArgumentException.class)
	public void constr_serie0() throws IllegalAccessException{
		new Album("bla","ble","bli",0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void constr_titreNull(){
		new Album(null, "bla");
	}
	@Test(expected=IllegalArgumentException.class)
	public void constr_auteurNull(){
		new Album("bla", null);
	}
	@Test
	public void constr_serie() throws IllegalAccessException{
		Album a = new Album("bla", "ble", "bli", 1);
		assertEquals("bli", a.getSerie());
	}
	
	
}
