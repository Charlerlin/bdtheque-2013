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
         
         JTextField Title = new JTextField("Titre");
         JTextField Auteur = new JTextField("Auteur");

	}
	public static void main(String[] args){
		JFrame f = new JFrame();
		Album m = new Album();
		f.setContentPane(m);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);
	}
}

