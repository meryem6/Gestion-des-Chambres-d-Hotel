package Reservation;

import javax.swing.*;
import java.awt.*;


public class Client{
	private String nomClient;
	private String prenomClient;
	private String numClient;
	private String dateClient;
	private int nuitsClient;

	public Client(String nom, String prenom, String num, String date, int nuits){
	this.nomClient= nom;
	this.prenomClient=prenom;
	this.numClient=num;
	this.dateClient=date;
	this.nuitsClient=nuits;
	}

/************** Getteres *************************/
	public String getNom(){
		return this.nomClient;
	}
	public String getPrenom(){
		return this.prenomClient;
	}
	public String getNum(){
		return this.numClient;
	}
	public String getDate(){
		return this.dateClient;
	}
	public int getNuits(){
		return this.nuitsClient;
	}

	/************** Setteres *************************/

	public void setNom(String nom){
		this.nomClient=nom;
	}
	public void setPrenom(String prenom){
		this.prenomClient=prenom;
	}
	public void setNum(String num){
		this.numClient=num;
	}
	public void setDate(String date){
		this.dateClient=date;
	}
	public void setNuits(int nuits){
		this.nuitsClient=nuits;
	}

}
