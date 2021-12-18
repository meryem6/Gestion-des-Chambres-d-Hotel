package Reservation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ControleurAccueil implements ActionListener{
	private JPanel panneauP;
	private CardLayout card;
	private Client monclient;

	private JTextField nomC;
	private JTextField prenomC;
	private JTextField numC;

	public ControleurAccueil(CardLayout cardL, JPanel pann, JTextField nom, JTextField prenom, JTextField num){  // constructeur
		this.panneauP= pann;  // récupère les arguments
		this.card= cardL;

		this.nomC=nom;
		this.prenomC=prenom;
		this.numC=num;
	}

	@Override
	 public void actionPerformed(ActionEvent event){
	 	String action = event.getActionCommand();// donne le texte du bouton cliqué

		if(action.equals("Quitter")){  // si on a cliquer sur quitter
			System.out.println("QUITTER ");
	   	 	System.exit(0);

		}else{  // si on a cliqué sur recher client

		 	if(this.nomC.getText().length()==0 && this.prenomC.getText().length()==0 && this.numC.getText().length()==0){
		 		System.out.println("ACUNNE DONNÉE ENTREE");

			}else{  // si on rempli quelque chose

				Client monclient= new Client(this.nomC.getText(), this.prenomC.getText(), this.numC.getText(), "", 0); // creer client

				 ClientModule monmodel= new ClientModule(monclient);	// appel model client qui recherche le client et sa reservation
				 if(monmodel.verifierInformations()==1){  // si le client existe et qu'il a bien une réservation

				 	ChambreModule chambremodel=new ChambreModule(monclient); // appel model chambre qui recherehce une chambre au client
				 	if(chambremodel.chambreProposee()==1){  // s'il y a une chambre libre
				 		Chambre machambre= new Chambre(chambremodel.getNum(), chambremodel.getCat(), 0);  // creer chambre automatiquement à notre client
						InterfaceChambre pChambre= new InterfaceChambre(card, panneauP, monclient, machambre, chambremodel);  
					}else{
						InterfaceNoChambre chambre= new InterfaceNoChambre(card, panneauP, monclient,chambremodel);  
						System.out.println("Interface pas de chambre");
					}

				 }else if(monmodel.verifierInformations()==2){ // si le client existe mais qu'il n'a pas de réservation
				 	System.out.println("Entrez mauvaises données Erreur Réservation");
				 	ErreurReservation pErreurReservation= new ErreurReservation(card, panneauP, monclient);

				 }else{   // si le client n'existe pas		 	
				 	System.out.println("Entrez mauvaises données Erreur Client");
				 	ErreurClient pErreurClient= new ErreurClient(card, panneauP, monclient);


				}
	 		}
		 }
	}
}
