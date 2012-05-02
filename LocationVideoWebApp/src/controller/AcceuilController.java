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

public class AcceuilController extends Controller {

	public AcceuilController(HttpServletRequest request,HttpServletResponse response) 
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
		
		String maCat = request.getParameter("catégorie");
		
		if ( maCat==null || maCat.isEmpty() )
		{
			maCat = "Toutes les catégories";
		}
		
		request.setAttribute("catégorie", maCat);
		
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
		String monTri = request.getParameter("trie");
		if(monTri == null)
			monTri = "az";
		
		if ( monTri.equals("az"))
		{
			Collections.sort(mesVideo, new Comparator<Video>()
				{
					public int compare(Video first, Video second)
					{
						return first.getNom().compareToIgnoreCase(second.getNom());
					}
				});
		}
		else if ( monTri.equals("za"))
		{
			Collections.sort(mesVideo, new Comparator<Video>()
				{
					public int compare(Video first, Video second)
					{
						return second.getNom().compareToIgnoreCase(first.getNom());
					}
				});
		}
		else if (monTri.equals("pcroissant"))
		{
			Collections.sort(mesVideo, new Comparator<Video>()
					{
						public int compare(Video first, Video second)
						{
							return Float.compare(first.getPrix(),second.getPrix());
						}
					});
		} 
		else if (monTri.equals("pdecroissant"))
		{
			Collections.sort(mesVideo, new Comparator<Video>()
					{
						public int compare(Video first, Video second)
						{
							return Float.compare(second.getPrix(),first.getPrix());
						}
					});
		}
		request.setAttribute("trie", monTri);
		request.setAttribute("videos", mesVideo);
		
		dispatch("acceuil.jsp");
	}

}
