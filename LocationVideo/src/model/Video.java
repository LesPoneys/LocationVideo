package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Video implements Serializable
{
	private int vid_id;
	private String vid_nom;
	private String vid_description;
	private float vid_notemoyen;
	private Date vid_datecre;
	private String vid_usercre;
	private int vid_idcategorie;

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
	
}
