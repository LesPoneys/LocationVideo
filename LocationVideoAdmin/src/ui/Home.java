package ui;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import bean.LocVideoBean;

import metier.Categorie;
import metier.Support;
import metier.Video;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Home extends JFrame implements ActionListener
{
	private Tableau catTab;
	private Tableau filmTab;
	private Tableau supTab;
	
	private JButton addCatBtn;
	private JButton delCatBtn;
	private JButton addFilmBtn;
	private JButton delFilmBtn;
	private JButton addSupBtn;
	private JButton delSupBtn;
	
	private List<Video> videos;
	private List<Categorie> categories;
	private List<Support> supports;
	
	public Home(){
		super();
		build();
		
		categories = LocVideoBean.getInstance().getCategories();
		videos = LocVideoBean.getInstance().getVideos();
		supports = LocVideoBean.getInstance().getSupports();
		
		fillCatTab();
		fillFilmTab();
		fillSupTab();
	}
	
	public List<Categorie> getCategories()
	{
		return categories;
	}
	
	public List<Support> getSupports()
	{
		return supports;
	}
	
	public void addFilm(Video vid)
	{
		Video video = LocVideoBean.getInstance().ajoutVideo(vid);
		videos.add(video);
		fillFilmTab();
	}
	
	public void addCat(Categorie cat)
	{
		Categorie categorie = LocVideoBean.getInstance().ajoutCategorie(cat);
		categories.add(categorie);
		fillCatTab();
	}
	
	public void addSup(Support sup)
	{
		Support support = LocVideoBean.getInstance().ajoutSupport(sup);
		supports.add(support);
		fillSupTab();
	}
	
	public void fillCatTab()
	{
		catTab.removeAllRow();
		for(int i = 0; i < categories.size(); i++)
		{
			Categorie cat = (Categorie)categories.get(i);
			List<String> categorie = new ArrayList<String>();
			
			categorie.add(cat.getNom());

			catTab.addLine(categorie);
		}
	}
	
	public void fillFilmTab()
	{
		filmTab.removeAllRow();
		for(int i = 0; i < videos.size(); i++)
		{
			Video vid = (Video)videos.get(i);
			List<String> video = new ArrayList<String>();
			
			video.add(vid.getNom());
			video.add(vid.getDescription());
			
			if(vid.getCategorie() != null)
				video.add(vid.getCategorie().getNom());
			else 
				video.add("");
			
			if(vid.getSupports() != null)
			{
				String sups = new String();
				Iterator<Support> it= vid.getSupports().iterator();
				while (it.hasNext()) 
				{
					Support sup = (Support) it.next();
					sups += (sup.getLibelle() + ", ");
				}
				video.add(sups);
			}
			else 
				video.add("");
			
			filmTab.addLine(video);
		}
	}
	
	public void fillSupTab()
	{
		supTab.removeAllRow();
		for(int i = 0; i < supports.size(); i++)
		{
			Support sup = (Support)supports.get(i);
			List<String> support = new ArrayList<String>();
			
			support.add(sup.getLibelle());

			supTab.addLine(support);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		if(arg0.getSource() == delCatBtn)
		{
			int row = catTab.getSelectedRow();
			if(row != -1)
			{
				LocVideoBean.getInstance().supprimerCategorie(categories.get(row).getId());
				categories.remove(row);
				fillCatTab();
			}
		}
		else if(arg0.getSource() == delFilmBtn)
		{
			int row = filmTab.getSelectedRow();
			if(row != -1)
			{
				LocVideoBean.getInstance().supprimerVideo(videos.get(row).getId());
				videos.remove(row);
				fillFilmTab();
			}
		}
		else if(arg0.getSource() == delSupBtn)
		{
			int row = supTab.getSelectedRow();
			if(row != -1)
			{
				LocVideoBean.getInstance().supprimerSupport(supports.get(row).getId());
				supports.remove(row);
				fillSupTab();
			}
		}
		else if(arg0.getSource() == addCatBtn)
		{
			new AddCatDialog(this);
		}
		else if(arg0.getSource() == addFilmBtn)
		{
			new AddFilmDialog(this);
		}
		else if(arg0.getSource() == addSupBtn)
		{
			new AddSupDialog(this);
		}
	}
	
	private void build(){
		setTitle("Poney Location");
		setSize(800,600); 
		setLocationRelativeTo(null); 
		setResizable(false); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setContentPane(buildContentPane());
	}
	
	private JPanel buildContentPane(){
		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		JLabel catLabel = new JLabel("Categories :");
		JLabel filmLabel = new JLabel("Films :");
		JLabel supLabel = new JLabel("Supports :");
		
		List<String> colonnesCat = new ArrayList<String>();
		colonnesCat.add("Nom");
		List<String> colonnesFilm = new ArrayList<String>();
		colonnesFilm.add("Titre");
		colonnesFilm.add("Description");
		colonnesFilm.add("Categorie");
		colonnesFilm.add("Support");
				
		catTab = new Tableau(colonnesCat, 140, 150);
		filmTab = new Tableau(colonnesFilm, 400, 380);
		supTab = new Tableau(colonnesCat, 140, 150);
		
		addCatBtn = new JButton("+");
		delCatBtn = new JButton("-");
		addFilmBtn = new JButton("+");
		delFilmBtn = new JButton("-");
		addSupBtn = new JButton("+");
		delSupBtn = new JButton("-");
		
		addCatBtn.addActionListener(this);
		delCatBtn.addActionListener(this);
		addFilmBtn.addActionListener(this);
		delFilmBtn.addActionListener(this);
		addSupBtn.addActionListener(this);
		delSupBtn.addActionListener(this);
		
		addCatBtn.setPreferredSize(new Dimension(45,30));
		delCatBtn.setPreferredSize(new Dimension(45,30));
		addFilmBtn.setPreferredSize(new Dimension(45,30));
		delFilmBtn.setPreferredSize(new Dimension(45,30));
		addSupBtn.setPreferredSize(new Dimension(45,30));
		delSupBtn.setPreferredSize(new Dimension(45,30));
		
		c.anchor = GridBagConstraints.LINE_START;
		c.insets = new Insets(5,5,5,5);

		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		c.gridheight = 1;
		panel.add(catLabel,c);
		
		c.gridx = 2;
		c.gridy = 0;
		c.gridwidth = 2;
		c.gridheight = 1;
		panel.add(filmLabel,c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 2;
		panel.add(catTab,c);
		
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		panel.add(addCatBtn,c);
		
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.anchor = GridBagConstraints.PAGE_START;
		panel.add(delCatBtn,c);
		
		c.gridx = 2;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 5;
		c.anchor = GridBagConstraints.LINE_START;
		panel.add(filmTab,c);
		
		c.gridx = 3;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		panel.add(addFilmBtn,c);
		
		c.gridx = 3;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.anchor = GridBagConstraints.PAGE_START;
		panel.add(delFilmBtn,c);
		
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.anchor = GridBagConstraints.LINE_START;
		panel.add(supLabel,c);
		
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 1;
		c.gridheight = 2;
		panel.add(supTab,c);
		
		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth = 1;
		c.gridheight = 1;
		panel.add(addSupBtn,c);
		
		c.gridx = 1;
		c.gridy = 5;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.anchor = GridBagConstraints.PAGE_START;
		panel.add(delSupBtn,c);

		return panel;
	}
}
