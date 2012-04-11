package metier;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Video implements Serializable
{
	private int id;
	private String nom;
	private String description;
	private Categorie categorie;
	private Set<Support> supports;
	private String image;

	public Video()
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
	
	public String getNom() 
	{ 
		return nom;
	}
	
	public void setNom(String nom) 
	{
		this.nom = nom; 
	}
	
	public String getDescription() 
	{ 
		return description;
	}
	
	public void setDescription(String desc) 
	{
		this.description = desc; 
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

	@ManyToMany(fetch=FetchType.EAGER)
	public Set<Support> getSupports() 
	{
		return supports;
	}

	public void setSupports(Set<Support> supports)
	{
		this.supports = supports;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
}
