import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
//using vector
class Demo_JTable extends JFrame
{
	JPanel panel;
	JScrollPane scrollPane;
	JTextField tx_row,tx_col;
	JLabel label1,label2;
	Vector data;
	Vector cols;
	JTable table;
	
	Demo_JTable()
	{
		setLayout(new BorderLayout());
		setSize(400,400);
		data=new Vector();
		cols=new Vector();
		panel=new JPanel();
		
		panel.setLayout(new BorderLayout());
		
		for(int i=0;i<20;i++)
		{
			cols.add(" "+(i+1));
			Vector row=new Vector();
			for(int j=0;j<10;j++)
			{
				row.add(" "+((j+1)*(i+1)));
			}
			data.add(row);
		}
		
	
		TableModel tb=new DefaultTableModel(data,cols);
		table=new JTable();
		table.setModel(tb);
		
		int v=JScrollPane.VERTICAL_SCROLLBAR_ALWAYS;
		int h=JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS;
		
		scrollPane=new JScrollPane(table,v,h);
		
		add(scrollPane,BorderLayout.CENTER);
		add(panel,BorderLayout.NORTH);
		show();
		
		table.setColumnSelectionAllowed(true);
		table.setColumnSelectionInterval(0,2);
	}
	public static void main(String args[])
	{
		new Demo_JTable();
	}
}

	
		