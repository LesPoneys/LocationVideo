import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.util.List;

public class Tableau extends JPanel 
{
    JTable table;
    DefaultTableModel tableau;
    
    public Tableau(List<String> colonnes, int width, int height) 
    {
		tableau = new  DefaultTableModel();
		
		for(int i = 0; i < colonnes.size(); i++)
		{
			tableau.addColumn(colonnes.get(i));
		}
	
		table = new JTable(tableau);
		table.setPreferredScrollableViewportSize(new Dimension(width, height));
		JScrollPane avecAsc = new JScrollPane(table);   
		add(new JScrollPane(table), BorderLayout.CENTER);
    }
    
    public void addLine(List<String> line)
    {
    	int nbRow = tableau.getRowCount();
    	tableau.setRowCount(nbRow + 1);
    	for (int i = 0; i < line.size(); i++)
    	{
    		if(i < tableau.getColumnCount())
    		tableau.setValueAt(line.get(i),nbRow,i);
    	}
    	
    }
    
    public void removeAllRow()
    {
    	tableau.getDataVector().removeAllElements();
    }
    
    public int getSelectedRow()
    {
    	return table.getSelectedRow();
    }
    
} 
