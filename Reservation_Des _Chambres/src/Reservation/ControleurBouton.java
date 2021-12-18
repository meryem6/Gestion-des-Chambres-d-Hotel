package Reservation;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ControleurBouton implements ActionListener{
	private JPanel panneau;
	private CardLayout moncardlayout;
	private Client monclient;


	public ControleurBouton(CardLayout moncardlayout2, JPanel panneau2, Client monclient2) {
		// TODO Auto-generated constructor stub
		this.panneau =panneau2;
		this.moncardlayout = moncardlayout2;
		this.monclient = monclient2;
	}





	@Override
	 public void actionPerformed(ActionEvent event){
	 	String action = event.getActionCommand();// donne le texte du bouton cliqué

		if(action.equals("Quitter")){
			System.out.println("QUITTER ");
	   		System.exit(0);
		}else if(action.equals("Accueil")){
			System.out.println("Accueil");
			moncardlayout.show(panneau, "Accueil");  // affiche l'accueil

		}
	}

}
