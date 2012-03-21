package main;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import javax.swing.SwingUtilities;

import ui.Home;

import metier.Video;

import bean.ILocationVideoBean;


public class Main
{
	
	
	public static void main(String [] args) 
	{ 
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				Home fenetre = new Home();
				fenetre.setVisible(true);
				
			}
		});
	} 


}
