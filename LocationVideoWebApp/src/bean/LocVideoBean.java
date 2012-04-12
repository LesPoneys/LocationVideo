package bean;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

import metier.Categorie;
import metier.Support;
import metier.Utilisateur;
import metier.Video;

import bean.ILocationVideoBean;


public class LocVideoBean 
{
	private static LocVideoBean instance;
	public static final String DEFAULT_JNDI_NAME ="LocationVideoBean/remote";
	ILocationVideoBean bean;
	
	public LocVideoBean()
	{
		getBean();
	}
	
	public static LocVideoBean getInstance() {
        if (null == instance) 
        { 
            instance = new LocVideoBean();
        }
        return instance;
    }
	
	private void getBean()
	{
		try
		{
			Context context = new InitialContext();
			Object obj = context.lookup(DEFAULT_JNDI_NAME);
			bean = (ILocationVideoBean)PortableRemoteObject.narrow(obj,ILocationVideoBean.class);
		}
		catch(ClassCastException cce)
		{
			cce.printStackTrace();
		}
		catch(NamingException ne)
		{
			ne.printStackTrace();
		}
	}
	
	public void supprimerVideo(int id)
	{
		bean.deleteVideo(id);
	}
	
	public Video ajoutVideo(Video vid)
	{
		return bean.ajoutVideo(vid);
	}
	
	public List<Video> getVideos()
	{
		List<Video> vid = bean.getVideos();

		return vid;
	}
	
	public void supprimerCategorie(int id)
	{
		bean.deleteCategorie(id);
	}
	
	public Categorie ajoutCategorie(Categorie cat)
	{
		return bean.ajoutCategorie(cat);
	}
	
	public List<Categorie> getCategories()
	{
		return bean.getCategories();
	}
	
	public void supprimerSupport(int id)
	{
		bean.deleteSupport(id);
	}
	
	public Support ajoutSupport(Support sup)
	{
		return bean.ajoutSupport(sup);
	}
	
	public List<Support> getSupports()
	{
		return bean.getSupports();
	}
	
	public List<Utilisateur> getUtilisateurs()
	{
		return bean.getUtilisateurs();
	}
	
	public Utilisateur getUtilisateurbyLogin(String login)
	{
		return bean.getUtilisateurbyLogin(login);
	}
	
	public void supprimerUtilisateur(int id)
	{
		bean.deleteUtilisateur(id);
	}
	
	public Utilisateur ajoutUtilisateur(Utilisateur Uti)
	{
		return bean.ajoutUtilisateur(Uti);
	}
	
		
	public Utilisateur IdentificationUtilisateur(String Login, String Mdp)
	{
		return bean.IdentificationUtilisateur(Login,  Mdp);
	}
	
	

}
