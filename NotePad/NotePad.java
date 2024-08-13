import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
class demo extends JFrame implements ActionListener
{
	TextArea txt;
	JMenuBar menu;
	JMenu file,edit,help,view;
	JMenuItem loaditem,saveitem,saveas,exititem,new1,zi,zo,z,clear,color;
	public demo()
	{
		setTitle("NotePad");
		setLayout(new FlowLayout());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700,700);
		setResizable(false);
		setLocationRelativeTo(null);
		
		ImageIcon image = new ImageIcon("icon.jpg");
		setIconImage(image.getImage());
		//Border bt = BorderFactory.createLineBorder(Color.green,4);	
		//getContentPane().setBackground(new Color(185,213,150));
		menu = new JMenuBar();
		menu.setBackground(Color.gray);
	
		file = new JMenu("File");
		edit = new JMenu("Edit");
		view = new JMenu("View");
		help = new JMenu("Help");
		

		menu.add(file);
		menu.add(edit);
		menu.add(help);
		menu.add(view);
		
		loaditem = new JMenuItem("Open");
		loaditem.addActionListener(this);
		clear = new JMenuItem("Clear");
		clear.addActionListener(this);
		saveitem = new JMenuItem("Save");
		saveitem.addActionListener(this);
		saveas = new JMenuItem("Save As");
		saveas.addActionListener(this);
		exititem = new JMenuItem("Exit");
		exititem.addActionListener(this);
		new1 = new JMenuItem("New");
		new1.addActionListener(this);
		
		color = new JMenuItem("Color");
		color.addActionListener(this);
		edit.add(color);
		
		z = new JMenu("Zoom");
		zi = new JMenuItem("Zoom In");
		zo = new JMenuItem("Zoom Out");
		
		loaditem.setMnemonic(KeyEvent.VK_O);
		saveitem.setMnemonic(KeyEvent.VK_S);
		color.setMnemonic(KeyEvent.VK_C);
		exititem.setMnemonic(KeyEvent.VK_E);
		
		file.setMnemonic(KeyEvent.VK_F);
		new1.setMnemonic(KeyEvent.VK_N);
		clear.setMnemonic(KeyEvent.VK_C);
		edit.setMnemonic(KeyEvent.VK_E);
		help.setMnemonic(KeyEvent.VK_H);
		
		view.setMnemonic(KeyEvent.VK_V);
		z.setMnemonic(KeyEvent.VK_Z);
		saveas.setMnemonic(KeyEvent.VK_A);
		zi.setMnemonic(KeyEvent.VK_I);		
		zo.setMnemonic(KeyEvent.VK_O);
		
		file.add(new1);
		file.add(loaditem);
		file.add(clear);
		file.add(saveitem);
		file.add(saveas);
		file.add(exititem);
		view.add(z);
		z.add(zi);
		z.add(zo);
		
		txt = new TextArea(25,55);
		txt.setFont(new Font("serif",Font.PLAIN,25));
		setJMenuBar(menu);
		add(txt);
		
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==saveitem)
		{
			String temp=txt.getText();
			String str = JOptionPane.showInputDialog("File Name");
			try{
				
				if(str.isEmpty())
				{	
				}
				else
				{
					File file = new File("C:\\Users\\ELCOT\\Documents\\project\\New folder\\"+str+".txt");		
					if(file.createNewFile())
					{
						FileWriter filewriter = new FileWriter(file);
						filewriter.write(temp);
						JOptionPane.showMessageDialog(null,"Save Successfully","save",JOptionPane.INFORMATION_MESSAGE);
						filewriter.close();
					}
					else
					{
						JOptionPane.showMessageDialog(null,"File already exited","save",JOptionPane.WARNING_MESSAGE);
					}
				}
			}
			catch(Exception ex)
			{
				System.out.println("Exception in this program");
			}
		}
		if(e.getSource()==help)
		{
			System.out.println("Hello");
		}
		{
		}
		if(e.getSource()==exititem)
		{
			int check = JOptionPane.showConfirmDialog(null,"Are You Sure To Close","Confirmation",JOptionPane.YES_NO_OPTION);
			if(check==0)
			{
				System.exit(0);
			}
		}
		if(e.getSource()==clear||e.getSource()==new1)
		{
			txt.setText(null);
		}
		if(e.getSource()==color)
		{
			JColorChooser j = new JColorChooser();
			Color c = JColorChooser.showDialog(null,"BASIC COLOR",Color.black);
			txt.setForeground(c);
		}
		if(e.getSource()==loaditem)
		{
			JFileChooser fc = new JFileChooser();
			fc.showOpenDialog(null);
			try
			{
				File f = fc.getSelectedFile();
				String path = f.getAbsolutePath();
				FileReader fr = new FileReader(path);
				int c;
				StringBuffer sb = new StringBuffer();
				while((c=fr.read())!=-1)
				{
					char get =(char)c;
					sb.append(get);
				}
				String resultstr =sb.toString();
				txt.setText(resultstr);
				fr.close();
			}
			catch(Exception excep){}
		}
		if(e.getSource()==saveas)
		{
			JFileChooser fc = new JFileChooser();
			fc.showOpenDialog(null);
			File f = fc.getCurrentDirectory();
			String path = f.getAbsolutePath();
			System.out.println(path);
			
		}
	}
}
class NotePad
{
	public  static void main(String args[])
	{
		new demo();
	}
}