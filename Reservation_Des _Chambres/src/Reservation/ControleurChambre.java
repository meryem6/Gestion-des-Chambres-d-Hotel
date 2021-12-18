package Reservation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ControleurChambre implements ActionListener{

	private JPanel panneauP;
	private CardLayout card;
	private Client monclient;
	private ChambreModule chambremodule;

	public ControleurChambre(CardLayout cardL, JPanel pann, Client client, ChambreModule chambremod){
		this.panneauP= pann;  // récupère les arguments
		this.card= cardL;
		this.monclient=client;
		this.chambremodule=chambremod;
	}

	@Override
	 public void actionPerformed(ActionEvent event){
	 	String action = event.getActionCommand();// donne le texte du bouton cliqué

		if(action.equals("Valider")){
			System.out.println("VALIDER chambre");

			this.chambremodule.changerEtat(this.chambremodule.getNum());

			InterfaceReservation reservation= new InterfaceReservation(card, panneauP, monclient, this.chambremodule.getNum());
		}else{
			System.out.println("Consulter liste des chambres");
			InterfaceListe liste= new InterfaceListe(card, panneauP, monclient, this.chambremodule.getTab(), this.chambremodule);

	 	}
	}

}
