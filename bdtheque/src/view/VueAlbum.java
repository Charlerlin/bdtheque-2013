package view;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.*;

import model.Album;

public class VueAlbum extends JFrame{

	private JTabbedPane panelOnglet;
	private JPanel jp1 = new JPanel();
	private JPanel jp2 = new JPanel();
	private JLabel jl1 = new JLabel("Présentation");
	private JLabel jl2 = new JLabel("Editer");

	public VueAlbum(){

		panelOnglet = new JTabbedPane();
		jp1.add(jl1);
		jp2.add(jl2);
		panelOnglet.addTab("Présentation", null, jp1);
		panelOnglet.addTab("Editer", null, jp2);

		class presentation_tab extends JPanel{     
			class presentation_infos extends JPanel{

				public presentation_infos(){

					setLayout(new GridLayout(3,3));
					JLabel title = new JLabel("Titre");
					JLabel auteur = new JLabel("Auteur");
					JLabel série = new JLabel("Série");
					JLabel date = new JLabel("Date");
					JLabel genre = new JLabel("Genre");
					JLabel editeur = new JLabel("Editeur");

					add(title);
					add(auteur);
					add(série);
					add(date);
					add(genre);
					add(editeur);

				}

				class presentation_note extends JPanel{

					public presentation_note(){

						setLayout(new GridLayout(2,2));
						JLabel synopsis = new JLabel("Synopsis");
						JLabel comments = new JLabel("Commentaires");
						JLabel note = new JLabel("Notation");
						
						add(synopsis);
						add(comments);
						add(note);

					}
				}
				
				class presentation_image extends JPanel{
					public presentation_image(){
						
					}
				}


			}

			/*public static void main(String[] args){
		JFrame f = new JFrame();
		Album m = new Album();
		f.setContentPane(m);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);
	}*/
		}


	}
}