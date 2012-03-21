package bean;

import java.util.List;

import javax.ejb.Remote;
import javax.persistence.Query;

import metier.Categorie;
import metier.Support;
import metier.Video;

@Remote
public interface ILocationVideoBean 
{
	public Video ajoutVideo(Video video);
	public void deleteVideo(int id);
	public List<Video> getVideos();
	public Video getVideo(int id);
	
	public Categorie ajoutCategorie(Categorie cat);
	public void deleteCategorie(int id);
	public List<Categorie> getCategories();
	public Categorie getCategorie(int id);
	
	public Support ajoutSupport(Support sup);
	public void deleteSupport(int id);
	public List<Support> getSupports();
	public Support getSupport(int id);
}
