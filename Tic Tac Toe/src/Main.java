import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Main extends JFrame{

	final static int WIDTH=950;
	final static int HEIGHT=950;
	
	JFrame frame=null;
	
	public  Main () {
		
		super("Tic Tac Toe");
		
		frame=this;

		this.setLayout(null);
		
		this.setResizable(false);

		this.setSize(WIDTH,HEIGHT);
		
		displayBackGround();
		
		
		JButton start=new JButton("Start");
		
		start.setSize(new Dimension(290, 100));
		this.add(start);
		start.setIcon(new ImageIcon("res/start.jpg"));
		start.setLocation(this.getWidth()/6,this.getWidth()/3);
		
		

		JButton credits=new JButton("Credits");
		
		credits.setSize(new Dimension(290, 100));
		this.add(credits);
		credits.setIcon(new ImageIcon("res/credits.jpg"));
		credits.setLocation(this.getWidth()/6,this.getWidth()/2);
		

		JButton exit=new JButton("Exit");
		exit.setIcon(new ImageIcon("res/exit.jpg"));
		exit.setSize(new Dimension(290, 100));
		this.add(exit);
		
		exit.setLocation(this.getWidth()/6,this.getWidth()*2/3);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(700, 50);

		
		
		
		
		start.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
			
				new Board(3);
				frame.dispose();
				
			}
		});
		
		

		credits.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
			
				new Credits();
				frame.dispose();
				
			}
		});
		
		exit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
			
				frame.dispose();
			}
		});
		
	}
	
	
	void displayBackGround() {
		frame.createBufferStrategy(1);
		Graphics g=this.getBufferStrategy().getDrawGraphics();
		File file=new File("res/BackGroundTicTacToe2.jpg");
		Image img=null;
		try{
			img=ImageIO.read(file);
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "An ERROR Occured while loading the background please restart the game");
			
		}
		
		
		frame.setContentPane(new ImagePanel(img));
		
		
	}
}
