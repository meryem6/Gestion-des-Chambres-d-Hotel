package Reservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import javax.swing.*;

public class ChambreModule {
	private Client monclient;
	private int catClient;
	private int[] tabChambre;
	private int numChambre;

	public ChambreModule(Client client){
		this.monclient=client;
	}

	public int chambreProposee(){
		int[] tabPremier=new int[50];
		System.out.println("chambreProposee");
		try{
			Class.forName("oracle.jdbc.OracleDriver");

			try{
				Connection co= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "meryem");

				try{  // premiere requette recuperer preference client la catégorie qui'il veut
					PreparedStatement requete = co.prepareStatement("SELECT categorie FROM Reservation WHERE reference='"+this.monclient.getNum()+"'");
					ResultSet res = requete.executeQuery();  // execute requete

					if(res.first()){		
						this.catClient=res.getInt(1);
						System.out.println("Categorie: "+catClient);
					}		
					res.close();  
					requete.close();  // ferme requete
					co.close();

				}catch(SQLException e){
					System.err.println("Probleme de requete"+e.getMessage());

				}

		}catch(SQLException e){
				System.err.println("Erreur connexion: "+e.getMessage());	
			}


			/****************************************************************************************/

			try{// deuxième requette cherhcer chambre qui correspond aux preferences client (a ala catégorie souhaité)
				Connection co= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "meryem");

				try{  // premiere requette recuperer preference client
					PreparedStatement requete = co.prepareStatement("SELECT numero FROM Chambre WHERE categorie='"+this.catClient+"'"+"AND etat='0'");
					ResultSet res = requete.executeQuery();  // execute requete

					if(res.first()){  // s'il y a une chambre dispo
						this.numChambre=res.getInt(1);  // attribu la première chambre dispo qui est propposée
						tabPremier[0]=res.getInt(1);
						System.out.println("Chambre: "+res.getInt(1));

						int taille=1;
						for(int i=1; res.next(); i++){	// rempli tableau des chambres dispo
							tabPremier[i]=res.getInt(1);
							taille++;
						}
						this.tabChambre=Arrays.copyOf(tabPremier, taille);

					}else{
						System.out.println("Pas de chambre disponible");
						return 0;
					}	

					res.close();  
					requete.close();  // ferme requete
					co.close();

				}catch(SQLException e){
					System.err.println("Probleme de requete"+e.getMessage());

				}

			}catch(SQLException e){
				System.err.println("Erreur connexion: "+e.getMessage());	
			}

		}catch(ClassNotFoundException e){
			System.err.println("Pilote indisponible");

		}
		return 1;

	}

/****************************************************************************************/

	public void changerEtat(int num){  // lorsque l'on valide une chambre, rend la chambre occupé
		System.out.println("Changer Etat");
		try{
			Class.forName("oracle.jdbc.OracleDriver");

			try{
				Connection co= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "meryem");

				try{ 
					PreparedStatement requete = co.prepareStatement("UPDATE Chambre set Etat='1' WHERE numero='"+num+"'");
					ResultSet res = requete.executeQuery();  // execute requete

					res.close();  
					requete.close();  // ferme requete
					co.close();

				}catch(SQLException e){
					System.err.println("Probleme de requete"+e.getMessage());

				}

			}catch(SQLException e){
				System.err.println("Erreur connexion: "+e.getMessage());	
			}

		}catch(ClassNotFoundException e){
			System.err.println("Pilote indisponible");

		}

		this.insererClient(num);  // appelle methode pour insereer client et lui passe le numéro de la chambre

	}


	public void insererClient(int num){  // inserer le client dans notre BD
		System.out.println("Insérer Client dans notre table Client");
		try{
			Class.forName("oracle.jdbc.OracleDriver");

			try{
				Connection co= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "meryem");

				try{ 
					PreparedStatement requete = co.prepareStatement("INSERT INTO Client values('"+this.monclient.getNom()+"', '"+this.monclient.getPrenom()+"', '"+this.monclient.getNum()+"', '"+num+"')");
					ResultSet res = requete.executeQuery();  // execute requete

					res.close();  
					requete.close();  // ferme requete
					co.close();

				}catch(SQLException e){
					System.err.println("Probleme de requete"+e.getMessage());

				}

			}catch(SQLException e){
				System.err.println("Erreur connexion: "+e.getMessage());	
			}

		}catch(ClassNotFoundException e){
			System.err.println("Pilote indisponible");

		}

	}

/************************************ Getteres **********************************************/

	public int getNum(){
		return this.numChambre;
	}
	public int[] getTab(){
		return this.tabChambre;
	}

	public int getCat(){
		return this.catClient;
	}

}


