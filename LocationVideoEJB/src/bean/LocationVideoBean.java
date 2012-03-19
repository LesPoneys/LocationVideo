package bean;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	
	public Video getVideo(int id)
	{
		return entityManager.find(Video.class, id);
	}

}
