package metier;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Location implements Serializable
{
	private int loc_id;
	private Date loc_dateloc;
	private Date loc_dateLimiteRetour;
	private Utilisateur utilisateur;
	private Video video;
	
	@Id @GeneratedValue
	public int getId() 
	{
		return loc_id;
	}
	
	public void setId(int loc_id)
	{
		this.loc_id = loc_id;
	}

	public Date getDateLocation() 
	{
		return loc_dateloc;
	}

	public void setDateLocation(Date loc_dateloc) 
	{
		this.loc_dateloc = loc_dateloc;
	}

	public Date getDateLimiteRetour() 
	{
		return loc_dateLimiteRetour;
	}

	public void setDateLimiteRetour(Date loc_dateLimiteRetour)
	{
		this.loc_dateLimiteRetour = loc_dateLimiteRetour;
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
