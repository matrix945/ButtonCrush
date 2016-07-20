package a6;

import javax.swing.*;

import java.awt.event.*;

public class ShinyButtonsApp extends JFrame implements ActionListener{

	ButtonPanel view;
	JTextField s;
	private Timer timer;
	
	public ShinyButtonsApp(String title){
		
		super(title);
		setLayout(null);
		
		view = new ButtonPanel();
		view.setLocation(13, 5);
		getContentPane().add(view);
		
		JLabel score = new JLabel("Score:");
		score.setLocation(13, 562);
		score.setSize(50,30);
		getContentPane().add(score);
		
		s = new JTextField();
		s.setHorizontalAlignment(JTextField.RIGHT);
		s.setLocation(73, 562);
		s.setSize(80, 30);
		getContentPane().add(s);

		JButton newButton = new JButton("New Game");
		newButton.setLocation(385, 562);
		newButton.setSize(100, 30);
		getContentPane().add(newButton);
		newButton.addActionListener(this);
		
		JButton qButton = new JButton("Quit");
		qButton.setLocation(505, 562);
		qButton.setSize(60, 30);
		getContentPane().add(qButton);
		qButton.addActionListener(this);
		
		timer = new Timer(500,new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			// Write code here to clean the table, process it, and then update
				view.bu.cleanTable();
				view.bu.processTable();
				view.update();
				s.setText(view.bu.getScore()+"");
			}});
			timer.start(); //
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(578, 634);
		setResizable(false);
	}
	
	public void actionPerformed(ActionEvent e){
			if (e.getActionCommand() == "New Game")
				view.bu.resetButtons();
			else
				System.exit(0);
		}

	public static void main(String[] args){
		JFrame f = new ShinyButtonsApp("Shiny Buttons");
		f.setVisible(true);
	}
}
