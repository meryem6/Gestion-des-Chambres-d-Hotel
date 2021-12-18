package Reservation;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ControleurRadioBouton implements ActionListener{
	private JPanel panneau;
	private CardLayout moncardlayout;
	private ChambreModule chambremodule;
	private Client monclient;
	public int nomJR=0;

	public ControleurRadioBouton(CardLayout card, JPanel pann, Client client, ChambreModule chambremod){
		this.panneau= pann;
		this.moncardlayout= card;
		this.monclient=client;
		this.chambremodule=chambremod;
	}

	@Override
	 public void actionPerformed(ActionEvent event){
	 	String action = event.getActionCommand();// donne le texte du bouton cliqué

		if(action.equals("Valider") && this.nomJR!=0){
			System.out.println("Valider");
			this.chambremodule.changerEtat(this.nomJR);
			InterfaceReservation reservation= new InterfaceReservation(this.moncardlayout, this.panneau, this.monclient, this.nomJR);

		}else if(action.equals("Valider") && this.nomJR==0){
			System.out.println("Veuillez selectionner un numéro de chambre");

		}else{
		this.nomJR=Integer.parseInt(action);   // donne   ala variable le nom du radio bouton surlequel on a cliqué
		}

	}
}
