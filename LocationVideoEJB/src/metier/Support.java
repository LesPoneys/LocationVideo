package metier;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Support implements Serializable
{
	private int sup_id;
	private String sup_libelle;
	
	@Id @GeneratedValue
	public int getId() 
	{
		return sup_id;
	}
	
	public void setId(int sup_id)
	{
		this.sup_id = sup_id;
	}
	
	public String getLibelle() 
	{
		return sup_libelle;
	}
	
	public void setLibelle(String sup_libelle)
	{
		this.sup_libelle = sup_libelle;
	}
}
