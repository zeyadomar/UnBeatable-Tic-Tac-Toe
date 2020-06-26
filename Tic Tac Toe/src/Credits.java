import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Credits extends JFrame {

	
	
	
	public Credits() {

		super("Tic Tac Toe");
		
		JFrame test=this;

		this.setLayout(null);
		
		this.setResizable(false);

		this.setSize(950, 950);
		
		JButton back=new JButton("Back");
		
		back.setSize(new Dimension(300, 100));
		this.add(back);
		
		back.setLocation(this.getWidth()/3,this.getWidth()*3/4);
		
		
		JTextField name=new JTextField();
		
		name.setSize(950, test.getWidth()/4);
		name.setFont(new Font("Ariel", Font.BOLD, 24));
		name.setText("Made by :  "+"zeyad omar");
		name.setEditable(false);

		JTextField sources=new JTextField();
		
		sources.setSize(950, test.getWidth()/4);
		sources.setFont(new Font("Ariel", Font.BOLD, 18));
		sources.setText("the game is implemented using Minimax algorithm ");
		sources.setEditable(false);
		

		JTextField link=new JTextField();
		
		link.setSize(950, test.getWidth()/4);
		link.setFont(new Font("Ariel", Font.BOLD, 18));
		link.setText("for more information about minimax visit the coding train channel  On YOUTUBE");
		link.setEditable(false);
		
		
		
		this.add(name);
		this.add(sources);
		this.add(link);
		sources.setLocation(0, this.getWidth()/4);
		link.setLocation(0, this.getWidth()/2);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(700, 50);

		
		
		back.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
			
				test.dispose();
				new Main();
			}
		});
	}
}
