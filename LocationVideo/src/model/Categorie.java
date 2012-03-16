package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Categorie implements Serializable
{
	private int cat_id;
	private String cat_nom;
	private int cat_idMere;

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
	
	public int getIdCatMere() 
	{ 
		return cat_idMere;
	}
	
	public void setIdCatMere(int idCat) 
	{
		this.cat_idMere = idCat; 
	}
}
