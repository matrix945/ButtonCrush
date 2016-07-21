package a6;

import javax.swing.*;
import java.awt.event.*;

public class ButtonPanel extends JPanel implements ActionListener{
	JButton[][] buttons;
	ShinyButtons bu;
	JButton selectedButton;
	
	public static ImageIcon[] icons = {new ImageIcon("RedButton.png"),
		new ImageIcon("OrangeButton.png"),
		new ImageIcon("YellowButton.png"),
		new ImageIcon("GreenButton.png"),
		new ImageIcon("BlueButton.png"),
		new ImageIcon("LightGrayButton.png"),
		new ImageIcon("DarkGrayButton.png")};
	
	public static ImageIcon[] selectedIcons = {
		new ImageIcon("SelectedRedButton.png"),
		new ImageIcon("SelectedOrangeButton.png"),
		new ImageIcon("SelectedYellowButton.png"),
		new ImageIcon("SelectedGreenButton.png"),
		new ImageIcon("SelectedBlueButton.png"),
		new ImageIcon("SelectedLightGrayButton.png"),
		new ImageIcon("SelectedDarkGrayButton.png")
		};
	
	public ButtonPanel() {
		
		setLayout(null);
		
		buttons = new JButton[8][8];
		bu = new ShinyButtons();
		
		for(int row=0; row<8; row++) {
			for (int col=0; col<8; col++) {
				buttons[row][col] = new JButton(icons[bu.getButton(row, col)]);
//				 if (bu.getSelectionTable(row,col)){
//			          System.out.println(row);
//			          System.out.println(col);
//			          buttons[row][col].setSelected(true);
//			          buttons[row][col].setSelectedIcon(selectedIcons[bu.getButton(row,col)]); 
//			        }

				buttons[row][col].setLocation(col*69, row*69);
				buttons[row][col].setSize(69, 69);
				buttons[row][col].addActionListener(this);
				add(buttons[row][col]);
			}
		}
		setSize(552, 552);
		

	}
	
	public void actionPerformed(ActionEvent e){
		for(int row=0; row<8; row++) {
			for (int col=0; col<8; col++) {
				if (e.getSource() == buttons[row][col]){
					if (selectedButton != null){
//after changing
						if (row > 0)//Down
			              if (buttons[row-1][col] == selectedButton)
			                  bu.swap(row, col, row-1, col);
			            if (row < 7)// Up
			               if (buttons[row+1][col] == selectedButton)
			                	bu.swap(row, col, row+1, col);
			            if (col > 0)// Right
			               if (buttons[row][col-1] == selectedButton)
			                	bu.swap(row, col, row, col-1);
			            if (col < 7)// Left
			               if (buttons[row][col+1] == selectedButton)
			                	bu.swap(row, col, row, col+1);
			           
						selectedButton = null;
						buttons[row][col].setSelected(false);
						buttons[row][col].setIcon(icons[bu.getButton(row, col)]);
						update();
					}
					else{
						selectedButton = buttons[row][col];
				          System.out.println(row);
				          System.out.println(col);
						buttons[row][col].setSelected(true);
//						bu.setSelectionTable(row, col, true);
//						System.out.println("the 00 function!" + bu.getSelectionTable(0, 0));
//						System.out.println(buttons[row][col].isSelected());
						buttons[row][col].setSelectedIcon(selectedIcons[bu.getButton(row, col)]);

					}
				}
			}
		}
	}
	
	public void update() {
		System.out.println("this is update function");
		System.out.println("the 00 is " + buttons[0][0].isSelected());
		System.out.println("the 00 function" + bu.getSelectionTable(0, 0));
		for(int row=0; row<8; row++) {
			for (int col=0; col<8; col++) {
				if (bu.getSelectionTable(row, col)){
					System.out.println(row + "  " + col  + "  ");
			        System.out.println("set true");	         
					buttons[row][col].setSelected(true);
					buttons[row][col].setSelectedIcon(selectedIcons[bu.getButton(row, col)]);
				}
				else{
					buttons[row][col].setSelected(false);
				buttons[row][col].setIcon(icons[bu.getButton(row, col)]);
				}
			}
		}
	}
	
}
