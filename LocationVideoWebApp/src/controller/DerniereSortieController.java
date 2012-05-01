package controller;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.LocVideoBean;

import metier.Categorie;
import metier.Video;

public class DerniereSortieController extends Controller {

	public DerniereSortieController(HttpServletRequest request,HttpServletResponse response) 
	{
		super(request, response);
	}
	
	public void process() throws ServletException, IOException
	{
		List<Video> mesVideo = null ;
		
		List<Categorie> mesCat = LocVideoBean.getInstance().getCategories();
		
		Collections.sort(mesCat, new Comparator<Categorie>()
				{
					public int compare(Categorie first, Categorie second)
					{
						return first.getNom().compareToIgnoreCase(second.getNom());
					}
				});
		
		
	   
		request.setAttribute("cats", mesCat);
		
		String maCat = request.getParameter("trie");
		
		if ( maCat==null || maCat.isEmpty() )
		{
			maCat = "Toutes les catégories";
		}
		
		request.setAttribute("trie", maCat);
		
		if(maCat.equals("Toutes les catégories"))
		{
			mesVideo = LocVideoBean.getInstance().getVideos();
		}
		else
		{
			for(int i =0; i< mesCat.size(); i++)
			{
				Categorie cat = mesCat.get(i);
				if(cat.getNom().equals(maCat))
				{
					mesVideo = LocVideoBean.getInstance().getVideosByCategorie(cat.getId());
					break;
				}
			}
		}
		//System.out.print("video : " + mesVideo);
		
		
		
		Collections.sort(mesVideo, new Comparator<Video>()
				{
					public int compare(Video first, Video second)
					{
						return second.getDateAjout().compareTo(first.getDateAjout());
					}
				});
		
		List<Video> lastVideos = mesVideo.subList(0, (mesVideo.size() >= 10) ? 10 : mesVideo.size());
		
		request.setAttribute("videos", lastVideos);
		
		dispatch("derniereSortie.jsp");
	}

}
