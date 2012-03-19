package metier;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Video implements Serializable
{
	private int vid_id;
	private String vid_nom;
	private String vid_description;
	private float vid_notemoyen;
	private Date vid_datecre;
	private String vid_usercre;
	private Categorie categorie;
	private Set<Support> supports;

	public Video()
	{
		super();
	}
	
	@Id @GeneratedValue
	public int getId() 
	{ 
		return vid_id;
	}
	
	public void setId(int id) 
	{
		this.vid_id= id; 
	}
	
	public String getNom() 
	{ 
		return vid_nom;
	}
	
	public void setNom(String nom) 
	{
		this.vid_nom = nom; 
	}
	
	public String getDescription() 
	{ 
		return vid_description;
	}
	
	public void setDescription(String desc) 
	{
		this.vid_description = desc; 
	}
	
	public float getNoteMoyen() 
	{ 
		return vid_notemoyen;
	}
	
	public void setNoteMoyen(float note) 
	{
		this.vid_notemoyen = note; 
	}
	
	public Date getDateCreation() 
	{
		return this.vid_datecre; 
	}
	
	public void setDateCreation(Date dateCre) 
	{
		this.vid_datecre = dateCre; 
	}
	
	public String getUserCreation() 
	{
		return this.vid_usercre; 
	}
	
	public void setUserCreation(String userCre) 
	{
		this.vid_usercre = userCre; 
	}
	
	@ManyToOne
	public Categorie getCategorie()
	{
		return categorie;
	}

	public void setCategorie(Categorie categorie) 
	{
		this.categorie = categorie;
	}

	@ManyToMany
	public Set<Support> getSupports() 
	{
		return supports;
	}

	public void setSupports(Set<Support> supports)
	{
		this.supports = supports;
	}
	
}
