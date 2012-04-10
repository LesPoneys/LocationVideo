package ui;
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
		tableau = new  DefaultTableModel(){
		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		
		for(int i = 0; i < colonnes.size(); i++)
		{
			tableau.addColumn(colonnes.get(i));
		}
		
		table = new JTable(tableau);
		table.getTableHeader().setReorderingAllowed(false);
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
    	int rowCount= tableau.getRowCount();
    	for(int i=0;i<rowCount;i++ )
    	{
    		tableau.removeRow(0);
        }
    }
    
    public int getSelectedRow()
    {
    	return table.getSelectedRow();
    }
    
} 
