import javax.swing.*;
import java.text.SimpleDateFormat;
import java.awt.Color;
import java.awt.*;
import java.util.*;
class project extends JFrame
{
	SimpleDateFormat timeformat;
	Calendar calender;
	JLabel label;
	String time;
	public project()
	{
		this.setTitle("Digital clock");
		this.setSize(350,200);
		this.setResizable(false);
	//	this.setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		timeformat = new SimpleDateFormat("hh:mm:ss a");
	
		
		label = new JLabel();
		label.setFont(new Font("serif",Font.PLAIN,50));
		
		//label.setBounds(100,1,500,300);
		label.setForeground(Color.green);
		
		label.setBackground(Color.black);	
		label.setOpaque(true);
		this.add(label);
		
		this.setVisible(true);
		setTime();
	}
	public void setTime()
	
	{
		while(true){
		
		time = timeformat.format(Calendar.getInstance().getTime());
		label.setText(time);
		try{
		Thread.sleep(1000);
		}
		catch(InterruptedException i)
		{
		}
		}
	}
}
class clock
{
	public static void main(String args[])
	{
		new project();
	}
}