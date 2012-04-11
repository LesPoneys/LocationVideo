package helper;
import java.util.ArrayList;
import java.util.List;

import metier.Categorie;
import metier.Video;
import bean.LocVideoBean;


public class TriParCategorie {
	
	public List<Video> getVideosWithCategorie(String cat, List<Video> Liste)
	{
		
		if (cat.equals("Toutes les catégories"))
		{
			return Liste;
		}
				
		System.out.println("choix  "+cat);
		List<Video> MaListe=new ArrayList<Video>();
		for (int i = 0; i<Liste.size(); i++)
		{
			Video maVideo = Liste.get(i);
			if (maVideo.getCategorie().getNom().equals(cat))
			{
				System.out.println("La Video  "+maVideo.getNom());
				MaListe.add(maVideo);
			}
		}
	
		return MaListe;
	}
}
