import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Demo_MessageDialog extends JFrame implements ActionListener
{
	JButton jb,del;
	JComboBox jbox;
	
	Demo_MessageDialog()
	{
		setSize(200,200);
		setVisible(true);	
		setTitle("DemoInputPane");
		jb=new JButton("ADD");
		del=new JButton("DEL");
		jbox=new JComboBox();
		setLayout(new FlowLayout());
		add(jb);	
		add(del);	
		add(jbox);
		del.addActionListener(this);
		jb.addActionListener(this);
		show();
	}
	public void actionPerformed(ActionEvent a)
	{
		if(jb==a.getSource())
		{
			///////////////////use of input dialog
			Icon df=new ImageIcon("default.gif");
			//String xx[]={"hello","welcome","bye"};
			//String tt=new String("hello");
			Object list[]=new Object[10];
			for(int i=0;i<list.length;i++)
			{
				list[i]=new Object();
				list[i]=""+(i+1);
			}
			Icon ic=new ImageIcon("./login.gif");
			Object sel=(Object)new String("1");

			//String ss=(String)JOptionPane.showInputDialog(this,"Enter Your Name:","Input",JOptionPane.QUESTION_MESSAGE,ic,list,sel);
			String ss=(String)JOptionPane.showInputDialog(this,"Enter Your Name:","Input",JOptionPane.PLAIN_MESSAGE);
			
			if(ss!=null&&ss.length()>0)
			jbox.addItem(ss);
			
		}
		else if(del==a.getSource())
		{
			if(jbox.getItemCount()>0)
			{
				String ss=(String)jbox.getItemAt(jbox.getSelectedIndex());
				///////////////////use of confirm dialog
				int but=JOptionPane.showConfirmDialog(this,"Item \""+ss+"\" is going to delete Do you realy want to Delete?","Confirm Delete",JOptionPane.YES_NO_OPTION);
				if(but==JOptionPane.YES_OPTION)
				{
					jbox.removeItemAt(jbox.getSelectedIndex());
					///////////////////use of message dialog
					JOptionPane.showMessageDialog(this,"Item Deleted:"+ss,"Delete",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else
			JOptionPane.showMessageDialog(this,"No ITem Found","Delete",JOptionPane.ERROR_MESSAGE);
			
		}	
		
	}
	public static void main(String a[])
	{
		new Demo_MessageDialog(); 
	}
}