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
    private JLabel t2;

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
	l = new JLabel("Temperature to be converted:", null, JLabel.CENTER);

	t2 = new JLabel("", null, JLabel.CENTER);
	m = new JLabel("Converted Temperature:", null, JLabel.CENTER);
	
	pane.add(l);
	pane.add(t);
	pane.add(m);
	pane.add(t2);
	pane.add(b);
	pane.add(c);


    }

    public void actionPerformed(ActionEvent e){
	String action = e.getActionCommand();
	double s = Double.parseDouble(t.getText());
	if(action.equals("Fahrenheit")){
	    s = 1.8*(s + 32);
	}else if(action.equals("Celsius")){
	    s = 0.55555555555*(s - 32);
	}
	t2.setText("" + s);
    }

    public static void main(String[] args){
	temperature temp = new temperature();
	temp.setVisible(true);
    }
    
}
