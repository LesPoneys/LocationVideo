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
	private int his_id;
	private Date his_dateVisu;
	private Utilisateur utilisateur;
	private Video video;
	
	@Id @GeneratedValue
	public int getid() {
		return his_id;
	}
	
	public void setid(int his_id) 
	{
		this.his_id = his_id;
	}
	
	public Date getdateVisu() 
	{
		return his_dateVisu;
	}
	
	public void setdateVisu(Date his_dateVisu)
	{
		this.his_dateVisu = his_dateVisu;
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
