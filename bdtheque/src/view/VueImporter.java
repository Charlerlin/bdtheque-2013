package view;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.*;

import model.Album;

public class VueImporter extends JFrame {

	public VueImporter() {
		class importer_rens extends JPanel{
			class importer_parcours extends JPanel{
				public importer_parcours(){
					
					setLayout(new GridLayout(1,2));
					
					JButton ok = new JButton("OK");
					JButton parcourir = new JButton("Parcourir...");
					
					add(parcourir);
					add(ok);
					
				}
			}
			class importer_liste extends JPanel{
				public importer_liste(){
					
				}

		}
       
       }

	}

}
