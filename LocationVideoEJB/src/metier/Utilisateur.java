package metier;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Utilisateur implements Serializable
{
	private int uti_id;
	private String uti_login;
	private String uti_mdp;
	private String uti_nom;
	private String uti_prenom;
	private String uti_email;
	private boolean uti_isAdmin;

	public Utilisateur()
	{
		super();
	}
	
	@Id @GeneratedValue
	public int getId() 
	{ 
		return uti_id;
	}
	
	public void setId(int id) 
	{
		this.uti_id= id; 
	}
	
	public String getLogin() 
	{ 
		return uti_login;
	}
	
	public void setLogin(String login)
	{
		this.uti_login = login;
	}

	public String getMdp() {
		return uti_mdp;
	}

	public void setMdp(String uti_mdp) {
		this.uti_mdp = uti_mdp;
	}

	public String getNom() {
		return uti_nom;
	}

	public void setNom(String uti_nom) {
		this.uti_nom = uti_nom;
	}

	public String getPrenom() {
		return uti_prenom;
	}

	public void setPrenom(String uti_prenom) {
		this.uti_prenom = uti_prenom;
	}

	public String getEmail() {
		return uti_email;
	}

	public void setEmail(String uti_email) {
		this.uti_email = uti_email;
	}

	public boolean getIsAdmin() {
		return uti_isAdmin;
	}

	public void setIsAdmin(boolean uti_isAdmin) {
		this.uti_isAdmin = uti_isAdmin;
	}
	
}
