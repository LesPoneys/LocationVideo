package metier;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Categorie implements Serializable
{
	private int cat_id;
	private String cat_nom;
	private Categorie CatMere;

	public Categorie()
	{
		super();
	}
	
	@Id @GeneratedValue
	public int getId() 
	{ 
		return cat_id;
	}
	
	public void setId(int id) 
	{
		this.cat_id= id; 
	}
	
	public String getNom() 
	{ 
		return cat_nom;
	}
	
	public void setNom(String nom) 
	{
		this.cat_nom = nom; 
	}

	@ManyToOne
	public Categorie getCatMere()
	{
		return CatMere;
	}

	public void setCatMere(Categorie catMere)
	{
		CatMere = catMere;
	}
}
