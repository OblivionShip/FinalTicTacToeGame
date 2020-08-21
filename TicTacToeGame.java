package games.board;
import games.board.Board;
import games.board.Cell;
import games.board.Mark;
import games.board.Outcome;
import java.awt.*;
import java.applet.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Scanner; 
 
public class TicTacToeGame extends JFrame {

	private static Board gb;
	private static int turn;
	static boolean getOutcome;
		
		private void takeTurn(Cell c) {
			Mark curMark = (turn++ % 2 == 0)? Mark.NOUGHT: Mark.CROSS;
			gb.setCell(curMark,c.getRow(),c.getColumn());
		}
		
		private TicTacToeGame() {
				gb = new Board(3, 3, new ActionListener() {
						public void actionPerformed(ActionEvent ae) {
							Cell c = (Cell) ae.getSource();
								takeTurn(c);
		}
		});
				this.add(gb);
				this.setDefaultCloseOperation(EXIT_ON_CLOSE);
				this.setTitle("TIC-TAC-TOE");
				this.setSize(300, 300);
				this.setVisible(true);
		}
					
		public static void main(String[] args) {
			       SwingUtilities.invokeLater( new Runnable () {
			           public void run() { new TicTacToeGame();}
			    });
				}



		private static Enum<Outcome> getOutcome() {
			if(gb.getCell(0,0).getContent() == Mark.NOUGHT && gb.getCell(0,1).getContent() == Mark.NOUGHT 
					&& gb.getCell(0,2).getContent() == Mark.NOUGHT) {return Outcome.PLAYER1_WIN;}
			if(gb.getCell(1,0).getContent() == Mark.NOUGHT && gb.getCell(1,1).getContent() == Mark.NOUGHT 
					&& gb.getCell(1,2).getContent() == Mark.NOUGHT) {return Outcome.PLAYER1_WIN;}
			if(gb.getCell(2,0).getContent() == Mark.NOUGHT && gb.getCell(2,1).getContent() == Mark.NOUGHT 
					&& gb.getCell(2,2).getContent() == Mark.NOUGHT) {return Outcome.PLAYER1_WIN;}

			if(gb.getCell(0,0).getContent() == Mark.NOUGHT && gb.getCell(1,1).getContent() == Mark.NOUGHT 
					&& gb.getCell(2,0).getContent() == Mark.NOUGHT) {return Outcome.PLAYER1_WIN;}
			if(gb.getCell(0,1).getContent() == Mark.NOUGHT && gb.getCell(1,1).getContent() == Mark.NOUGHT 
					&& gb.getCell(2,1).getContent() == Mark.NOUGHT) {return Outcome.PLAYER1_WIN;}
			if(gb.getCell(0,2).getContent() == Mark.NOUGHT && gb.getCell(1,2).getContent() == Mark.NOUGHT 
					&& gb.getCell(2,2).getContent() == Mark.NOUGHT) {return Outcome.PLAYER1_WIN;}
							
			if(gb.getCell(0,0).getContent() == Mark.NOUGHT && gb.getCell(1,1).getContent() == Mark.NOUGHT 
					&& gb.getCell(2,2).getContent() == Mark.NOUGHT) {return Outcome.PLAYER1_WIN;}
			if(gb.getCell(0,2).getContent() == Mark.NOUGHT && gb.getCell(1,1).getContent() == Mark.NOUGHT 
					&& gb.getCell(2,0).getContent() == Mark.NOUGHT) {return Outcome.PLAYER1_WIN;}
			
			if((gb.getCell(0,0).getContent() == Mark.CROSS) && (gb.getCell(0,1).getContent() == Mark.CROSS)
					&& (gb.getCell(0,2).getContent() == Mark.CROSS)) {return Outcome.PLAYER2_WIN;}
			if((gb.getCell(1,0).getContent() == Mark.CROSS) && (gb.getCell(1,1).getContent() == Mark.CROSS)
					&& (gb.getCell(1,2).getContent() == Mark.CROSS)) {return Outcome.PLAYER2_WIN;}
			if((gb.getCell(2,0).getContent() == Mark.CROSS) && (gb.getCell(2,1).getContent() == Mark.CROSS)
					&& (gb.getCell(2,2).getContent() == Mark.CROSS)) {return Outcome.PLAYER2_WIN;}

			if ((gb.getCell(0,0).getContent() == Mark.CROSS) && (gb.getCell(1,1).getContent() == Mark.CROSS)
					&& (gb.getCell(2,0).getContent() == Mark.CROSS)) {return Outcome.PLAYER2_WIN;}
			if((gb.getCell(0,1).getContent() == Mark.CROSS) && (gb.getCell(1,1).getContent() == Mark.CROSS)
					&& (gb.getCell(2,1).getContent() == Mark.CROSS)) {return Outcome.PLAYER2_WIN;}
			if((gb.getCell(0,2).getContent() == Mark.CROSS) && (gb.getCell(1,2).getContent() == Mark.CROSS)
					&& (gb.getCell(2,2).getContent() == Mark.CROSS)) {return Outcome.PLAYER2_WIN;}
			if((gb.getCell(0,0).getContent() == Mark.CROSS) && (gb.getCell(1,1).getContent() == Mark.CROSS) 
					&& (gb.getCell(2,2).getContent() == Mark.CROSS)) {return Outcome.PLAYER2_WIN;}
			if((gb.getCell(0,2).getContent() == Mark.CROSS) && (gb.getCell(1,1).getContent() == Mark.CROSS)
					&& (gb.getCell(2,0).getContent() == Mark.CROSS)) {return Outcome.PLAYER2_WIN;}
		
			else {
				
			}
			return null;

    }
}