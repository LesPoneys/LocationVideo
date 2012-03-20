package metier;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Utilisateur implements Serializable
{
	private int id;
	private String login;
	private String mdp;
	private String nom;
	private String prenom;
	private String email;
	private boolean isAdmin;

	public Utilisateur()
	{
		super();
	}
	
	@Id @GeneratedValue
	public int getId() 
	{ 
		return id;
	}
	
	public void setId(int id) 
	{
		this.id= id; 
	}
	
	public String getLogin() 
	{ 
		return login;
	}
	
	public void setLogin(String login)
	{
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
}
