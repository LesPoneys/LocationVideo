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
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bean.LocVideoBean;

import metier.Categorie;

public class AddCatDialog extends JDialog implements ActionListener
{
	JButton addBtn;
	JButton cancelBtn;
	JTextField catField;
	Home parent;
	
	public AddCatDialog (JFrame parent)
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
		
		setTitle("Ajout de catégorie");
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
		
		catField = new JTextField();
		catField.setColumns(15);
		
		addBtn = new JButton("ok");
		cancelBtn = new JButton("Annuler");
		
		addBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		
		c.anchor = GridBagConstraints.LINE_START;
		c.insets = new Insets(5,5,5,5);

		c.gridx = 0;
		c.gridy = 0;
		panel.add(nameLabel,c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 2;
		panel.add(catField,c);
		
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		panel.add(cancelBtn,c);
		
		c.gridx = 1;
		c.gridy = 2;
		c.anchor = GridBagConstraints.LAST_LINE_END;
		panel.add(addBtn,c);

		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if(arg0.getSource() == addBtn)
		{
			Categorie cat = new Categorie();
			cat.setNom(catField.getText());
			
			parent.addCat(cat);
		}
		close();
		
	}

	private void close()
	{
		dispose();
		setVisible(false);
	}
}
