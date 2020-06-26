import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EmptyStackException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;





  
//This Class contains all actions and the functionalities of the board of Tic Tac Toe 
  
 




public class Board extends JFrame implements MouseListener {

	 Button [] [] board;
	
	final int WIDTH  = 950,HEIGHT= 950;
	
	static boolean isUserTurn=true;
	
	static int Available;
	final static char AIPlayer='X';
	final static char Player='O';
	final static String X_Path="res/Letter_X.png";
	final static String O_Path="res/Letter_O.png";
	
	int loops=0;
	boolean hasShownMessage=false;
	
	int emptySpot=0;
	
	public  Board(int n) {
		super("Tic Tac Toe");
		
	
		
		Available=n*n;
		
		this.setResizable(false);
		this.setSize(WIDTH,HEIGHT);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(700, 50);

		
	     this.repaint();
		board=new Button[n][n];		
	    
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
			{
				board[i][j]=new Button();
				
				board[i][j].setSize(new Dimension(275,275));
				
				this.add(board[i][j]);
				
				board[i][j].setLocation(j*300+15, i*300+15);
				
				board[i][j].setPlayer(' ');
				board[i][j].addMouseListener(this);
			
				board[i][j].setOpaque(false);
				board[i][j].setContentAreaFilled(false);
				board[i][j].setBorderPainted(false);
			
			}
		
		
	
		      Drawer drawer=new Drawer();
		      drawer.setPreferredSize(new Dimension(950,950));
		      this.getContentPane().add(drawer);

		      this.setVisible(true);
			  this.repaint();
			  this.revalidate();
	}

	
	
	
//this function returns the score of the action the AI is going to perform	
  int minimax(boolean isMaximizing) {
	char c=checkWinner(false);
	
	 if( c!= ' ' || emptySpot==0)
	 return checkScore(c);
	
	if(isMaximizing) {
		
        int bestScore =-20;
		for(int i=0;i<board.length;i++)
			for(int j= 0;j<board[i].length;j++)
			{
				if(board[i][j].getPlayer()==' ')
				{
					board[i][j].setPlayer(AIPlayer);
					
		        	int score=minimax(false);
					board[i][j].setPlayer(' ');
					
					bestScore=Math.max(score, bestScore);
					
					
				}
			}
		

		
		return bestScore;
		
	}
	else
	{
		
        int bestScore = 20;
		
		for(int i=0;i<board.length;i++)
			for(int j= 0;j<board[i].length;j++)
			{
				if(board[i][j].getPlayer()==' ')
				{
					board[i][j].setPlayer(Player);
					int score=minimax(true);
					board[i][j].setPlayer(' ');
					
					bestScore=Math.min(score, bestScore);
					
				            
					
				}
			}
		
		return bestScore;
		
		
	}
	
	
	
	
	
	}
	
      int checkScore(char c) {
		
		int res=0;
		
		switch(c) {
		case AIPlayer:res= 10;break;
		case Player:res= -10;break;
		case ' ':res= 0;break;
		}
		
		return res;
		
		
	}
	
	// this method returns the best move after calculating its score
	 int [] bestMove() {
	
		int bestScore =-10;
		
		int [] move=new int [2];
		
		for(int i=0;i<board.length;i++)
			for(int j= 0;j<board[i].length;j++)
			{
				if(board[i][j].getPlayer()==' ')
				{
					board[i][j].setPlayer(AIPlayer);
		           
					int score=minimax(false);
					board[i][j].setPlayer(' ');
					
					if(bestScore<score)
					{
					  bestScore=score;
		              move[0]=i;
		              move[1]=j;
					}
					
					
		            
					
				}
			}
		return move;
		
	}
	 
	 // this method is for organization or a helper method
	 void AIPlay() {
		
		int [] index=bestMove();
		
		int i=index[0];
		int j=index[1];
	    
	
		
		board[i][j].setIcon(new ImageIcon(X_Path));
		board[i][j].setPlayer(AIPlayer);	
		this.repaint();
		this.revalidate();
	Available--;

	
	}

	
	
	public void mouseClicked(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		Button temp=((Button) e.getSource());
		temp.setIcon(new ImageIcon(O_Path));		
	    temp.setPlayer(Player);

	    checkWinner(true);
		Available--;
		
	    AIPlay();
	 
	    this.repaint();
	    temp.repaint();		
	     checkWinner(true);
	}
	public void mouseReleased(MouseEvent e) {
		
	}
	
// this method returns the winner in form of a char (X or O ) ,in case of Tie it returns ' ' 
	   char checkWinner(boolean areYouTheRealMove) {
			
		char Winner =' ';
	       emptySpot=0;
		
		for(int i=0;i<board.length;i++)
		if(board[i][0].getPlayer()!=' '&&board[i][0].getPlayer()==board[i][1].getPlayer()&&board[i][1].getPlayer()==board[i][2].getPlayer())
			{Winner=board[i][0].getPlayer();break;}
		
		
		for(int i=0;i<board.length && Winner==' ';i++)
			if(board[0][i].getPlayer()!=' '&&board[0][i].getPlayer()==board[1][i].getPlayer()&&board[1][i].getPlayer()==board[2][i].getPlayer())
				{Winner=board[0][i].getPlayer();break;}
			
		
			if(Winner==' '&&board[0][0].getPlayer()!=' '&& board[0][0].getPlayer()==board[1][1].getPlayer()&&board[1][1].getPlayer()==board[2][2].getPlayer())
				{Winner=board[0][0].getPlayer();}
		
			if(Winner==' '&&board[0][2].getPlayer()!=' '&& board[0][2].getPlayer()==board[1][1].getPlayer()&&board[2][0].getPlayer()==board[1][1].getPlayer())
			{Winner=board[0][2].getPlayer();}
	  

			
           
			if(!hasShownMessage&&areYouTheRealMove && (Available<=0||Winner!=' '))
			 showMessage(Winner);
			

			for(int i=0;i<board.length;i++)
				for(int j=0;j<board[i].length;j++)
					if(board[i][j].getPlayer()==' ')
						emptySpot++;
			 
			
			return Winner;
	   
	   
	   }
	   
	   // this method shows a message for the user when the game ends
	   void showMessage(char c) {
		   
		   hasShownMessage=true;
		   if(c==' ') 
			{JOptionPane.showMessageDialog(null, "Tie");}
		   else
		    JOptionPane.showMessageDialog(null, "The Winner is "+ c);
		   
		   this.dispose();
		   new Board(3);
		   
		   
	   }
	   
	   
	   
	   // for debugging purposes (it prints the board)
	   void print() {
		   for(int i=0;i<board.length;i++)
		   { for(int j=0;j<board[i].length;j++)
				   System.out.print(board[i][j].getPlayer()+" ");
	          
		   System.out.println();
		   }
		   System.out.println("Loop  Number    :"+ loops++);
		   System.out.println("---------------------------");
		   
	   }
}

