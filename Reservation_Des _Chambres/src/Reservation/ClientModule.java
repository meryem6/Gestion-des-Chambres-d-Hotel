package Reservation;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class ClientModule{
	private Client monClient;


	public ClientModule(Client client){
		this.monClient=client;

	}
	public int verifierInformations(){
		if(this.monClient.getNom().length()!=0 && this.monClient.getPrenom().length()!=0){
			if(rechercherClient(this.monClient.getNom(), this.monClient.getPrenom())==1){
				return 1;
			}else if((rechercherClient(this.monClient.getNom(), this.monClient.getPrenom())==2)){
				return 2; // client mais pas réservation
			}else{
				return 0;
			}

		}else if(this.monClient.getNum().length()!=0){
			if(rechercherClient(this.monClient.getNum())==1){
				return 1;
			}else{
				return 0;
			}
		}else{
			return 0;
			// inteface erreur
		}

	}

	public int rechercherClient(String jtfNom, String jtfPrenom){
		System.out.println("Rechercher client par nom et prénom");
		try{
			Class.forName("oracle.jdbc.OracleDriver");

			try{
				Connection co= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "meryem");

				try{
					PreparedStatement requete = co.prepareStatement("SELECT prenom, nom FROM Client WHERE prenom='"+this.monClient.getPrenom()+"'" +"AND nom='"+this.monClient.getNom()+"'");
					ResultSet res = requete.executeQuery();  // execute requete

					if(res.first()){		
						requete.close();
						res.close();
						requete=co.prepareStatement("SELECT C.prenom, C.nom, R.reference, R.debut , R.nuits FROM Client C, Reservation R WHERE C.prenom='"+this.monClient.getPrenom()+"'" +"AND C.nom='"+this.monClient.getNom()+"'"+"AND C.id=R.client");
						res = requete.executeQuery();  

						if(res.first()){	
						System.out.println(""+res.getString(1)+" "+res.getString(2)+" "+res.getString(3)+" "+res.getString(4)+" "+res.getInt(5)+"");

						this.monClient.setNum(res.getString(3)); // rempli le client avec la référence (car on a recherché qu'avec prenom et nom)
						this.monClient.setDate(res.getString(4));
						this.monClient.setNuits(res.getInt(5));

						}else{
							System.out.println("Le Client n'a pas de réservation");
							return 2; // client mais pas reservation
						}

					}else{
						return 0;  // pas de client
					}
					res.close();  
					requete.close();  // ferme requete
					co.close();


				}catch(SQLException e){
					System.err.println("Probleme de requete"+e.getMessage());
					return 0;
				}

			}catch(SQLException e){
				System.err.println("Erreur connexion: "+e.getMessage());
				return 0;
			}
		}catch(ClassNotFoundException e){
			System.err.println("Pilote indisponible");
			return 0;
		}
		 // client + reservation
		return 1;
	}


	public int rechercherClient(String jtfNum){
		System.out.println("Rechercher client par référence");

		try{
			Class.forName("oracle.jdbc.OracleDriver");

			try{
				Connection co= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "meryem");

				try{
					PreparedStatement requete = co.prepareStatement("SELECT prenom, nom, reference, debut, nuits FROM Reservation natural join Client WHERE reference='"+this.monClient.getNum()+"'");  // récupère les serveurs dont l'état est on
					ResultSet res = requete.executeQuery();  // execute requete

					if(res.first()){		
						System.out.println(""+res.getString(1)+" "+res.getString(2)+" "+res.getString(3));

						this.monClient.setPrenom(res.getString(1)); // rempli le client avec le nom (car on a recherche qu'avec la ref)
						this.monClient.setNom(res.getString(2));
						this.monClient.setDate(res.getString(4));
						this.monClient.setNuits(res.getInt(5));

						//interface chambre
						//insert notre BD

					}else{
						return 0; // pas de client ni reservation
						//interface erreur
					}
					res.close();  
					requete.close();  // ferme requete
					co.close();


				}catch(SQLException e){
					System.err.println("Probleme de requete");
					return 0;
				}

			}catch(SQLException e){
				System.err.println("Erreur connexion: "+e.getMessage());
				return 0;
			}
		}catch(ClassNotFoundException e){
			System.err.println("Pilote indisponible");
			return 0;
		}
				return 1;


	}
}
