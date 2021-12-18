package Reservation;

import javax.swing.*;
import java.awt.*;

public class Main{
		public static void main(String[] args){
			JFrame fenetre= new JFrame("Réservation");
			fenetre.setSize(700, 500);
			fenetre.setLocationRelativeTo(null);
			fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			CardLayout monCardlayout = new CardLayout(); 
			JPanel panneauPrincipal= new JPanel();
			panneauPrincipal.setLayout(monCardlayout);

			JPanel pAccueil= new InterfaceAccueil(monCardlayout, panneauPrincipal);

			panneauPrincipal.add(pAccueil, "Accueil");

			fenetre.add(panneauPrincipal);
			fenetre.setVisible(true);	
	}
}
