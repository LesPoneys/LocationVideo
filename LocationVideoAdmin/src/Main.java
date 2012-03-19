import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

import metier.Video;

import bean.ILocationVideoBean;


public class Main
{
	public static final String DEFAULT_JNDI_NAME ="LocationVideoBean/remote";
	
	public static void main(String [] args) 
	{ 
		try
		{
			Context context = new InitialContext();
			Object obj = context.lookup(DEFAULT_JNDI_NAME);
			ILocationVideoBean bean = (ILocationVideoBean)PortableRemoteObject.narrow(obj,ILocationVideoBean.class);
			
			Video video = new Video();
			video.setNom("Avatar");
			video.setDescription("film de James Cameron");
			video.setDateCreation(new Date());
			
			video = bean.ajoutVideo(video);
			
			System.out.println(video.getNom() + " id : " + video.getId());
			
			Video video1 = bean.getVideo(video.getId());
			
			System.out.println(video1.getNom() + " id : " + video1.getId());
			
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


}
