import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import metier.Categorie;
import metier.Video;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Home extends JFrame implements ActionListener
{
	private Tableau catTab;
	private Tableau filmTab;
	
	JButton addCatBtn;
	JButton delCatBtn;
	JButton addFilmBtn;
	JButton delFilmBtn;
	
	List<Video> videos;
	List<Categorie> categories;
	
	public Home(){
		super();
		build();
		
		//addCat();
		//addFilm();
		
		categories = LocVideoBean.getInstance().getCategories();
		videos = LocVideoBean.getInstance().getVideos();
		
		fillCatTab();
		fillFilmTab();
	}
	
	private void addFilm()
	{
		Video video = new Video();
		video.setNom("Avatar");
		video.setDescription("film de James Cameron");
		video.setDateCreation(new Date());
		
		LocVideoBean.getInstance().ajoutVideo(video);
	}
	
	private void addCat()
	{
		Categorie categorie = new Categorie();
		categorie.setNom("Aventure");
		
		LocVideoBean.getInstance().ajoutCategorie(categorie);
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
			video.add(vid.getDateCreation().toString());
			
			filmTab.addLine(video);
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
		
		List<String> colonnesCat = new ArrayList<String>();
		colonnesCat.add("Nom");
		List<String> colonnesFilm = new ArrayList<String>();
		colonnesFilm.add("Titre");
		colonnesFilm.add("Description");
		colonnesFilm.add("Date");
		
		catTab = new Tableau(colonnesCat, 150, 300);
		filmTab = new Tableau(colonnesFilm, 500, 300);
		
		addCatBtn = new JButton("+");
		delCatBtn = new JButton("-");
		addFilmBtn = new JButton("+");
		delFilmBtn = new JButton("-");
		
		addCatBtn.addActionListener(this);
		delCatBtn.addActionListener(this);
		addFilmBtn.addActionListener(this);
		delFilmBtn.addActionListener(this);
		
		addCatBtn.setPreferredSize(new Dimension(30,30));
		delCatBtn.setPreferredSize(new Dimension(30,30));
		addFilmBtn.setPreferredSize(new Dimension(30,30));
		delFilmBtn.setPreferredSize(new Dimension(30,30));
		
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
		c.gridheight = 3;
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
		panel.add(delCatBtn,c);
		
		c.gridx = 2;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 3;
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
		panel.add(delFilmBtn,c);

		return panel;
	}
}
