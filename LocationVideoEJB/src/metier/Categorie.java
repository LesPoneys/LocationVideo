package metier;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Categorie implements Serializable
{
	private int id;
	private String nom;
	private Categorie CatMere;

	public Categorie()
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
