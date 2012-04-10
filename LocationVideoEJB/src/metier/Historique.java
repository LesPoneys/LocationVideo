package metier;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Historique implements Serializable
{
	private int id;
	private Date dateVisu;
	private Utilisateur utilisateur;
	private Video video;
	
	@Id @GeneratedValue
	public int getid() {
		return id;
	}
	
	public void setid(int id) 
	{
		this.id = id;
	}
	
	public Date getdateVisu() 
	{
		return dateVisu;
	}
	
	public void setdateVisu(Date dateVisu)
	{
		this.dateVisu = dateVisu;
	}

	@OneToOne
	public Utilisateur getUtilisateur() 
	{
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) 
	{
		this.utilisateur = utilisateur;
	}
	
	@OneToOne
	public Video getVideo() 
	{
		return video;
	}

	public void setVideo(Video video)
	{
		this.video = video;
	}
	
}
