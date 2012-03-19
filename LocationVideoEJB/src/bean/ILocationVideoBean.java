package bean;

import javax.ejb.Remote;

import metier.Video;

@Remote
public interface ILocationVideoBean 
{
	public Video ajoutVideo(Video video);
	public Video getVideo(int id);
}
