package Reservation;
import javax.swing.*;
import java.awt.*;

public class InterfaceAccueil extends JPanel{
	private JPanel panneau;
	private CardLayout moncardlayout;
	private Client monclient;

	public InterfaceAccueil(CardLayout card, JPanel pann){
		this.panneau= pann;
		this.moncardlayout= card;
		//this.monclient=client;

		this.afficherVue();
	}

	public void afficherVue(){
		this.setLayout(new GridLayout(11, 1));  // met le layout en grid 7 lignes, 1 colonne

		Color couleur= new Color(200, 200, 255);
		this.setBackground(couleur);  // modifie couleur panneau

		JLabel etiquette1= new JLabel("Accueil");  // creer etiquette
		etiquette1.setHorizontalAlignment(JLabel.CENTER); //  la positionne
		etiquette1.setFont(new Font("", Font.BOLD, 35));  // modifie la police de etiquette1
		JLabel etiquette2= new JLabel("Veuillez entrez les informations suivantes sur le client: ");
		etiquette2.setFont(new Font("",Font.PLAIN, 18));  // modifie la police de etiquette1
		etiquette2.setHorizontalAlignment(JLabel.CENTER); //  la positionne

		JLabel nom= new JLabel("Nom du client: ");
		nom.setHorizontalAlignment(JLabel.CENTER); //  la positionne	
		JLabel prenom= new JLabel("Pr\u00E9nom du client: ");
		prenom.setHorizontalAlignment(JLabel.CENTER); //  la positionne
		JLabel etiquette3= new JLabel("et/ou");
		etiquette3.setHorizontalAlignment(JLabel.CENTER); //  la positionne
		JLabel num= new JLabel("R\u00E9f\u00E9rence de la r\u00E9servation du client: ");
		num.setHorizontalAlignment(JLabel.CENTER); //  la positionne	



		JLabel rien= new JLabel();

		JTextField jtfNom = new JTextField();  // creer le jtextfield en lui donnant le mask creer
		JTextField jtfPrenom = new JTextField();
		JTextField jtfnum = new JTextField();

		JPanel panbouton= new JPanel();
		panbouton.setBackground(couleur);
		JButton bouton= new JButton("Rechercher Client");  // creer bouton
		JButton quitter= new JButton("Quitter");
		panbouton.add(bouton);   // met les 2 boutons dans le panneau
		panbouton.add(quitter);

		this.add(etiquette1);  // ajoutte les etiquettes et les jtextfield
		this.add(etiquette2);
		this.add(nom);
		this.add(jtfNom);  
		this.add(prenom);
		this.add(jtfPrenom);
		this.add(etiquette3);
		this.add(num);
		this.add(jtfnum);
		this.add(rien);
		this.add(panbouton);


		ControleurAccueil moncontroleur = new ControleurAccueil(moncardlayout, panneau, jtfNom, jtfPrenom, jtfnum); 
		bouton.addActionListener(moncontroleur); 
		quitter.addActionListener(moncontroleur); 


	}

}

