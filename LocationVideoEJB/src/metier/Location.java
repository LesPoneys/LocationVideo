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
	private int id;
	private Date dateloc;
	private Date dateLimiteRetour;
	private Utilisateur utilisateur;
	private Video video;
	
	@Id @GeneratedValue
	public int getId() 
	{
		return id;
	}
	
	public void setId(int loc_id)
	{
		this.id = loc_id;
	}

	public Date getDateLocation() 
	{
		return dateloc;
	}

	public void setDateLocation(Date dateloc) 
	{
		this.dateloc = dateloc;
	}

	public Date getDateLimiteRetour() 
	{
		return dateLimiteRetour;
	}

	public void setDateLimiteRetour(Date dateLimiteRetour)
	{
		this.dateLimiteRetour = dateLimiteRetour;
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
