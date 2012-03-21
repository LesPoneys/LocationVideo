package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import metier.Categorie;
import metier.Support;
import metier.Video;

public class AddFilmDialog extends JDialog implements ActionListener
{
	JButton addBtn;
	JButton cancelBtn;
	JTextField nameField;
	JTextField descriptionField;
	JComboBox<String> catBox;
	List<JCheckBox> supBoxs = new ArrayList<JCheckBox>();
	Home parent;
	
	public AddFilmDialog (JFrame parent)
	{
		super();
		this.parent = (Home)parent;
		setModal(true);
		setSize(300, 200);
		
		if (parent != null) {
		      Dimension parentSize = parent.getSize(); 
		      Point p = parent.getLocation(); 
		      setLocation(p.x + ((parentSize.width - getWidth()) / 2), p.y + ((parentSize.height - getHeight() ) / 2));
		}
		
		setTitle("Ajout de film");
		setResizable(false);
		setLocationRelativeTo(null); 
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setContentPane(buildContentPane());
		pack(); 
	    setVisible(true);
	}
	
	private JPanel buildContentPane()
	{
		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		JLabel nameLabel = new JLabel("Nom :");
		
		nameField = new JTextField();
		nameField.setColumns(15);
		
		JLabel descriptionLabel = new JLabel("Description :");
		
		descriptionField = new JTextField();
		descriptionField.setColumns(15);
		
		JLabel catLabel = new JLabel("Categorie :");
		
		catBox = new JComboBox<String>();
		List<Categorie> cats = parent.getCategories();
		for(int i = 0 ; i < cats.size() ; i++)
		{
			catBox.addItem(cats.get(i).getNom());
		}
		
		JLabel supportLabel = new JLabel("Support :");
		
		addBtn = new JButton("ok");
		cancelBtn = new JButton("Annuler");
		
		addBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		
		c.anchor = GridBagConstraints.LINE_START;
		c.insets = new Insets(5,5,5,5);

		c.gridx = 0;
		c.gridy = 0;
		panel.add(nameLabel,c);
		
		c.gridx = 1;
		c.gridy = 0;
		panel.add(nameField,c);
		
		c.gridx = 0;
		c.gridy = 1;
		panel.add(descriptionLabel,c);
		
		c.gridx = 1;
		c.gridy = 1;
		panel.add(descriptionField,c);
		
		c.gridx = 0;
		c.gridy = 2;
		panel.add(catLabel,c);
		
		c.gridx = 1;
		c.gridy = 2;
		panel.add(catBox,c);
		
		c.gridx = 0;
		c.gridy = 3;
		panel.add(supportLabel,c);
		
		List<Support> supports = parent.getSupports();
		for( int i = 0 ; i < supports.size(); i++)
		{
			JCheckBox check = new JCheckBox(supports.get(i).getLibelle());
			supBoxs.add(check);
			c.gridx = 1;
			c.gridy = i + 3;
			panel.add(check,c);
		}
		
		c.gridx = 0;
		c.gridy = 3 + ((supports.size() == 0) ? 1 : supports.size());
		c.gridwidth = 1;
		panel.add(cancelBtn,c);
		
		c.gridx = 1;
		c.gridy = 3 + ((supports.size() == 0) ? 1 : supports.size());
		c.anchor = GridBagConstraints.LAST_LINE_END;
		panel.add(addBtn,c);

		return panel;
	}
	
	private boolean allFieldFilled()
	{
		if(nameField.getText().isEmpty() || catBox.getSelectedIndex() == -1)
			return false;
		for(int i = 0; i < supBoxs.size() ; i++)
		{
			if(supBoxs.get(i).isSelected())
				return true;
			else if (i == (supBoxs.size()-1))
				return false;
		}
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if(arg0.getSource() == addBtn)
		{
			if(allFieldFilled())
			{
				Video vid = new Video();
				vid.setNom(nameField.getText());
				vid.setDescription(descriptionField.getText());
				vid.setDateCreation(new Date());
				
				List<Categorie> cats = parent.getCategories();
				vid.setCategorie(cats.get(catBox.getSelectedIndex()));
				
				List<Support> supports = parent.getSupports();
				Set<Support> supVid = new HashSet<Support>();
				for(int i = 0; i < supBoxs.size(); i++)
				{
					if(supBoxs.get(i).isSelected())
					{
						supVid.add(supports.get(i));
					}
				}
				vid.setSupports(supVid);
				
				parent.addFilm(vid);
			}
		}
		close();
		
	}

	private void close()
	{
		dispose();
		setVisible(false);
	}

}
