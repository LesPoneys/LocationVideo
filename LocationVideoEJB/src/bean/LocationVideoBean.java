package bean;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.Categorie;
import metier.Support;
import metier.Video;

@Stateful
public class LocationVideoBean implements ILocationVideoBean
{
	@PersistenceContext(unitName = "LocationVideo")
	private EntityManager entityManager;
	
	public Video ajoutVideo(Video video)
	{
		entityManager.persist(video);
		return video;
	}
	
	public void deleteVideo(int id)
	{
		Video video = entityManager.find(Video.class, id);
		entityManager.remove(video);
	}
	
	public List<Video> getVideos()
	{
		Query query = entityManager.createQuery("from Video");
		return query.getResultList() ;
	}
	
	public Video getVideo(int id)
	{
		return entityManager.find(Video.class, id);
	}
	
	public Categorie ajoutCategorie(Categorie cat)
	{
		entityManager.persist(cat);
		return cat;
	}
	
	public void deleteCategorie(int id)
	{
		Categorie cat = entityManager.find(Categorie.class, id);
		entityManager.remove(cat);
	}
	
	public List<Categorie> getCategories()
	{
		Query query = entityManager.createQuery("from Categorie");
		return query.getResultList() ;
	}
	
	public Categorie getCategorie(int id)
	{
		return entityManager.find(Categorie.class, id);
	}
	
	public Support ajoutSupport(Support sup)
	{
		entityManager.persist(sup);
		return sup;
	}
	
	public void deleteSupport(int id)
	{
		Support sup = entityManager.find(Support.class,id);
		entityManager.remove(sup);
	}
	
	public List<Support> getSupports()
	{
		Query query = entityManager.createQuery("from Support");
		return query.getResultList() ;
	}
	
	public Support getSupport(int id)
	{
		return entityManager.find(Support.class, id);
	}

}
