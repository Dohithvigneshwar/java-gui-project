import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
class demoSwing extends JFrame implements ActionListener
{
JLabel label;
String time;
JLabel l1,l2,l3,l4;
JTextField txt1,txt2;
JButton btn1,btn2,btn3,btn4;
	public demoSwing()
	{
		super("DOHITH");
		setVisible(true);
		setLayout(null);
		setSize(800,700);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Border bt = BorderFactory.createLineBorder(Color.green,4);	
		getContentPane().setBackground(new Color(185,213,150));
		getRootPane().setBorder(bt);

		//ImageIcon  image = new ImageIcon("image.jpg");
	

		l1 = new JLabel("MINI CALCULATOR");
		l1.setFont(new Font("serif",Font.BOLD,30));
		l1.setBounds(250,10,300,100);
		l1.setForeground(Color.blue);
		//l1.setIcon(image);

		l2 = new JLabel("Enter Number ");
		l2.setBounds(130,110,150,100);
		l2.setForeground(new Color(5,82,123));

		l3 = new JLabel("Enter Number ");
		l3.setBounds(130,150,150,100);
		l3.setForeground(new Color(5,82,123));

		txt1 = new JTextField();
		txt1.setBounds(250,135,200,30);
		txt1.setBorder(BorderFactory.createLineBorder(Color.YELLOW,4));

				
		txt2 = new JTextField();
		txt2.setBounds(250,190,200,35);
		txt2.setBorder(BorderFactory.createLineBorder(Color.YELLOW,4));

		btn1 = new JButton("ADDTION");
		btn1.setBounds(200,300,130,35);
		btn1.setBorder(BorderFactory.createLineBorder(Color.red,4));
		btn1.addActionListener(this);

		btn2 = new JButton("SUBTRACTION");
		btn2.setBounds(350,300,130,35);
		btn2.setBorder(BorderFactory.createLineBorder(Color.red,4));
		btn2.addActionListener(this);
			
		btn3 = new JButton("MULTIPLICATION");
		btn3.setBounds(350,370,130,35);
		btn3.setBorder(BorderFactory.createLineBorder(Color.red,4));
		btn3.addActionListener(this);

		
		btn4 = new JButton("DIVISION");
		btn4.setBounds(200,370,130,35);
		btn4.setBorder(BorderFactory.createLineBorder(Color.red,4));
		btn4.addActionListener(this);
		

		l4 = new JLabel();
		l4.setBounds(270,450,400,70);	
		l4.setFont(new Font("serif",Font.PLAIN,20));
		
		
		add(l2);
		add(l1);	
		add(txt1);
		add(txt2);
		add(l3);
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		add(l4);

	}

public void actionPerformed(ActionEvent e)
{
	String str1 = txt1.getText();
	String str2 = txt2.getText();
	try
	{
	if(str1.isEmpty()||str2.isEmpty())
	{
		JOptionPane.showMessageDialog(null,"Please Enter Data","WARNING",JOptionPane.INFORMATION_MESSAGE);
	}
	else
	{
		String value = e.getActionCommand();
		if(value.equals("ADDTION"))
		{
			int a = Integer.parseInt(str1);
			int b = Integer.parseInt(str2);
			int c = a+b;
			//String result = String.valueOf(c);
			//add(l4);
			l4.setText("Addtion of two number :"+c);
		}
		else if(value.equals("SUBTRACTION"))
		{
			int a = Integer.parseInt(str1);
			int b = Integer.parseInt(str2);
			int c = a-b;
			//String result = String.valueOf(c);
			l4.setText("Subtraction of two number :"+c); 
		}
		else if(value.equals("MULTIPLICATION"))
		{
			int a = Integer.parseInt(str1);
			int b = Integer.parseInt(str2);
			int c = a*b;
			//String result = String.valueOf(c);
			l4.setText("multiplication of two number :"+c);
		}
		else if(value.equals("DIVISION"))
		{
			int a = Integer.parseInt(str1);
			int b = Integer.parseInt(str2);
			int c = a/b;
			//String result = String.valueOf(c);
			l4.setText("Division of two number :"+c);
		}
	}
	}
	catch(NumberFormatException eb)
	{
		JOptionPane.showMessageDialog(null,"Numbers only accepted","WARNING",JOptionPane.WARNING_MESSAGE);
	}
	catch(ArithmeticException b)
	{
		JOptionPane.showMessageDialog(null,"Math Error","WARNING",JOptionPane.ERROR_MESSAGE);
	}
	}
	

}
class minicalculator
{
	public static void main(String args[])
	{
		new demoSwing();
	}
}
