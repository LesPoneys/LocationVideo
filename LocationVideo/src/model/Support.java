package model;

import java.io.Serializable;

public class Support implements Serializable
{
	private int sup_id;
	private String sup_libelle;
	
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
