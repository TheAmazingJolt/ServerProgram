package main;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Display {

	static GraphicsConfiguration gc;
	private JButton start, setIP1, setIP2;
	private JLabel label;
	private JTextField ip1, ip2;
	
	public Display() {
		JFrame frame = new JFrame(gc);
		frame.setTitle("Server Program");
		frame.setSize(600,400);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
		setIP1 = new JButton("Set Ip");
		setIP2 = new JButton("Set Ip");
		start = new JButton("Start");
		label = new JLabel();
		ip1 = new JTextField();
		ip2 = new JTextField();

		frame.add(ip1);
		frame.add(setIP1);
		frame.add(ip2);
		frame.add(setIP2);
		frame.add(start);
		
		start.addActionListener(new CustomActionListener());
		setIP1.addActionListener(new CustomActionListener2());
		setIP2.addActionListener(new CustomActionListener3());
		
		frame.setLayout(new GridLayout(3,2));
		
		frame.setVisible(true);
	}
	
	class CustomActionListener implements ActionListener{
	      public void actionPerformed(ActionEvent e) {
	    	 	Main main = new Main();
	      }
	}
	
	class CustomActionListener2 implements ActionListener{
	      public void actionPerformed(ActionEvent e) {
	    	  	Main.setIp1(ip1.getText());
	      }
	}
	
	class CustomActionListener3 implements ActionListener{
	      public void actionPerformed(ActionEvent e) {
	    	  	Main.setIp2(ip2.getText());
	      }
	}
	
	public void setLabelText(String str) {
		label.setText(str);
	}
	
}
