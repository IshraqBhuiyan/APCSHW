import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class temperature extends JFrame implements ActionListener{
    private Container pane;

    private JButton b;
    private JLabel l;
    private JButton c;
    private JLabel m;
    private JTextField t;

    public temperature(){
	this.setTitle("Temperature Converter");
	this.setSize(1280, 720);
	this.setLocation(100, 100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());

	b = new JButton("To Fahrenheit");
	b.addActionListener(this);
	b.setActionCommand("Fahrenheit");
	
	c = new JButton("To Celsius");
	c.addActionListener(this);
	c.setActionCommand("Celsius");

	t = new JTextField(10);
	pane.add(b);
	pane.add(l);
	pane.add(c);
	pane.add(m);
	pane.add(t);
    }

    public void actionPerformed(ActionEvent e){

    }
	

}
