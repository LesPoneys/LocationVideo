package metier;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Support implements Serializable
{
	private int id;
	private String libelle;
	
	@Id @GeneratedValue
	public int getId() 
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getLibelle() 
	{
		return libelle;
	}
	
	public void setLibelle(String libelle)
	{
		this.libelle = libelle;
	}
}
