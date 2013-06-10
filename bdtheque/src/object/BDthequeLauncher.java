/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Album;
import model.BDT;

/**
 *
 * @author Florian Vanhecke
 */
public class BDthequeLauncher extends WindowAdapter {

    private BDT model;

    public BDthequeLauncher() {
        File f = new File("bdtheque.db");
        if (f.exists()) {
            try {
                FileInputStream fichier = new FileInputStream("bdtheque.db");
                ObjectInputStream ois = new ObjectInputStream(fichier);
                BDT bdt = (BDT) ois.readObject();
                this.model = bdt;
            } catch (java.io.IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            this.model = new BDT();
            Album a1 = new Album("Tintin et le Trésor de Rackham le Rouge", "auteur1", "dessinateur1", "TinTin", 1, "", "", "Aventure", "", "", 0, 0, 0);
            Album a2 = new Album("tintin2", "auteur1", "dessinateur1", "TinTin", 2, "", "", "Aventure", "", "", 0, 0, 0);
            Album a3 = new Album("tintin3", "auteur1", "dessinateur1", "TinTin", 3, "", "", "Aventure", "", "", 0, 0, 0);
            Album a4 = new Album("tintin4", "auteur1", "dessinateur1", "TinTin", 4, "", "", "Aventure", "", "", 0, 0, 0);
            Album a5 = new Album("tintin5", "auteur1", "dessinateur1", "TinTin", 5, "", "", "Aventure", "", "", 0, 0, 0);
            Album a6 = new Album("asterix1", "auteurAsterix", "dessinateur2", "AsterixEtOBe", 1, "", "", "Voyage", "", "", 0, 0, 0);
            Album a7 = new Album("asterix2", "auteurAsterix", "dessinateur2", "AsterixEtOBe", 2, "", "", "Voyage", "", "", 0, 0, 0);
            Album a8 = new Album("asterix3", "auteurAsterix", "dessinateur2", "AsterixEtOBe", 3, "", "", "Voyage", "", "", 0, 0, 0);
            Album a9 = new Album("asterix4", "auteurAsterix", "dessinateur2", "AsterixEtOBe", 4, "", "", "Voyage", "", "", 0, 0, 0);
            Album a10 = new Album("asterix5", "auteurAsterix", "dessinateur2", "AsterixEtOBe", 5, "", "", "Voyage", "", "", 0, 0, 0);
            Album a11 = new Album("titreALaCon", "auteurCon", "dessinateurCon");
            Album a12 = new Album("PuniToutseul", "auteurPuniToutSeul", "dessinateurPuni");
            Album a13 = new Album("BeauTitre", "auteurBeau", "dessinateurBeau");
            Album a14 = new Album("DernierTitre", "auteurDernier", "dessinateurDernier");
            this.model.add(a1);
            this.model.add(a2);
            this.model.add(a3);
            this.model.add(a4);
            this.model.add(a5);
            this.model.add(a6);
            this.model.add(a7);
            this.model.add(a8);
            this.model.add(a9);
            this.model.add(a10);
            this.model.add(a11);
            this.model.add(a12);
            this.model.add(a13);
            this.model.add(a14);
        }

    }

    public BDT getModel() {
        return this.model;
    }

    public void windowClosing(WindowEvent e) {
        FileOutputStream fichier = null;
        try {
            ObjectOutputStream oos = null;
            fichier = new FileOutputStream("bdtheque.db");
            oos = new ObjectOutputStream(fichier);
            oos.writeObject(this.model);
            oos.flush();
            oos.close();
        } catch (IOException ex) {
            Logger.getLogger(BDthequeLauncher.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fichier.close();
            } catch (IOException ex) {
                Logger.getLogger(BDthequeLauncher.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.exit(1);

    }
}
