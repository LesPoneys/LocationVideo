package bean;

import java.util.List;

import javax.ejb.Remote;

import metier.Categorie;
import metier.Historique;
import metier.Support;
import metier.Utilisateur;
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
	
	public Utilisateur ajoutUtilisateur(Utilisateur uti);
	public void deleteUtilisateur(int id);
	public List<Utilisateur> getUtilisateurs();
	public Utilisateur getUtilisateur(int id);
	public Utilisateur getUtilisateurbyLogin(String login);
	public Utilisateur IdentificationUtilisateur(String login, String mdp);
	
	public List<Historique> getHistorique(int id_uti);
	public List<Video> getVideosByCategorie(int idCat);
}
