package Reservation;
import javax.swing.*;
import java.awt.*;

public class InterfaceListe extends JPanel{
	private JPanel panneau;
	private CardLayout moncardlayout;
	private ChambreModule chambremodule;
	private Client monclient;
	private int[] tabChambre;

	public InterfaceListe(CardLayout card, JPanel pann, Client client, int[] tab, ChambreModule chambremod){
		this.panneau= pann;
		this.moncardlayout= card;
		this.monclient=client;
		this.chambremodule=chambremod;
		this.tabChambre=tab;

		this.afficherVue();
	}

	public void afficherVue(){
		this.setLayout(new GridLayout(5, 1));  // met le layout en grid avec nos 3 éléments + les chambres dispo
		Color couleur= new Color(200, 200, 255);
		this.setBackground(couleur);  // modifie couleur panneau

		JLabel etiquette1= new JLabel("Liste des chambres");
		etiquette1.setFont(new Font("", Font.BOLD, 35));
		etiquette1.setHorizontalAlignment(JLabel.CENTER); //  la positionne

		JLabel etiquette2= new JLabel("Liste des chambres correspondant aux crit\u00e8res du client: "+monclient.getPrenom()+" "+monclient.getNom());
		etiquette2.setHorizontalAlignment(JLabel.CENTER); //  la positionne
		this.add(etiquette1);
		this.add(etiquette2);

		JLabel etiquette3= new JLabel("Les crit\u00e8res du client: début r\u00e9servation: "+this.monclient.getDate()+"  Nombre de nuit: "+this.monclient.getNuits());
		etiquette3.setHorizontalAlignment(JLabel.CENTER); //  la positionne
		this.add(etiquette3);

		ControleurRadioBouton controleurjr= new ControleurRadioBouton(this.moncardlayout, this.panneau, this.monclient, this.chambremodule);
		ButtonGroup groupe = new ButtonGroup();  // cree ensemble de bouton

		JPanel pann= new JPanel();
		pann.setLayout(new GridLayout((this.tabChambre.length)/4, 0));  // creer gridlayout pour placer nos bouton radios
		pann.setBackground(couleur);

		for(int i=0; i<this.tabChambre.length; i++){
			// creer bouton radios
			JRadioButton jr = new JRadioButton(""+tabChambre[i]+"");
			jr.setBackground(couleur);
			groupe.add(jr);
			pann.add(jr);


			jr.addActionListener(controleurjr);
		}
		this.add(pann);

		JPanel bouton= new JPanel();
		bouton.setBackground(couleur);
		JButton valider= new JButton("Valider");
		JButton accueil= new JButton("Accueil");
		bouton.add(valider);
		bouton.add(accueil);
		this.add(bouton);

		ControleurBouton controleur= new ControleurBouton(this.moncardlayout, this.panneau, this.monclient);
		accueil.addActionListener(controleur);

		valider.addActionListener(controleurjr);

		panneau.add(this, "Liste");
		moncardlayout.show(panneau, "Liste");
	}


}

