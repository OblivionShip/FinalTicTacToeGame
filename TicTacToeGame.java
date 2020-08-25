package games.board;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TicTacToeGame extends JFrame {
	//**Main method**//
	public static void main(String[] args) {
		SwingUtilities.invokeLater( new Runnable () {
	           public void run() { new TicTacToeGame();}
	    });
		}
	//**Main method**//
	private static Board gb;
	private static int turn;
	
	static Outcome getOutcome() {
		//ROWS//
		if((gb.getCell(0,0).getContent() == Mark.NOUGHT) 
				&& (gb.getCell(0,1).getContent() == Mark.NOUGHT) 
				&& (gb.getCell(0,2).getContent() == Mark.NOUGHT)) 
					{return Outcome.PLAYER1_WIN;}
		if((gb.getCell(1,0).getContent() == Mark.NOUGHT) 
				&&  (gb.getCell(1,1).getContent() == Mark.NOUGHT) 
				&&  (gb.getCell(1,2).getContent() == Mark.NOUGHT))
					{return Outcome.PLAYER1_WIN;}
			if((gb.getCell(2,0).getContent() == Mark.NOUGHT) 
				&&  (gb.getCell(2,1).getContent() == Mark.NOUGHT) 
				&&  (gb.getCell(2,2).getContent() == Mark.NOUGHT)) 
					{return Outcome.PLAYER1_WIN;}

			if((gb.getCell(0,0).getContent() == Mark.CROSS) 
					&& (gb.getCell(0,1).getContent() == Mark.CROSS)
					&& (gb.getCell(0,2).getContent() == Mark.CROSS)) 
						{return Outcome.PLAYER2_WIN;}
				if((gb.getCell(1,0).getContent() == Mark.CROSS)
					&&  (gb.getCell(1,1).getContent() == Mark.CROSS) 
					&&  (gb.getCell(1,2).getContent() == Mark.CROSS))
						{return Outcome.PLAYER2_WIN;}
				if((gb.getCell(2,0).getContent() == Mark.CROSS) 
					&&  (gb.getCell(2,1).getContent() == Mark.CROSS) 
					&&  (gb.getCell(2,2).getContent() == Mark.CROSS)) 
						{return Outcome.PLAYER2_WIN;}
		
		//COLUMNS//
				if((gb.getCell(0,0).getContent() == Mark.NOUGHT) 
						&& (gb.getCell(1,0).getContent() == Mark.NOUGHT) 
						&& (gb.getCell(2,0).getContent() == Mark.NOUGHT)) 
							{return Outcome.PLAYER1_WIN;}
					if((gb.getCell(0,1).getContent() == Mark.NOUGHT) 
						&&  (gb.getCell(1,1).getContent() == Mark.NOUGHT) 
						&&  (gb.getCell(2,1).getContent() == Mark.NOUGHT))
							{return Outcome.PLAYER1_WIN;}
					if((gb.getCell(0,2).getContent() == Mark.NOUGHT) 
						&&  (gb.getCell(1,2).getContent() == Mark.NOUGHT) 
						&&  (gb.getCell(2,2).getContent() == Mark.NOUGHT)) 
							{return Outcome.PLAYER1_WIN;}

					if((gb.getCell(0,0).getContent() == Mark.CROSS) 
						&& (gb.getCell(1,0).getContent() == Mark.CROSS) 
						&& (gb.getCell(2,0).getContent() == Mark.CROSS)) 
							{return Outcome.PLAYER2_WIN;}
					if((gb.getCell(0,1).getContent() == Mark.CROSS) 
						&&  (gb.getCell(1,1).getContent() == Mark.CROSS) 
						&&  (gb.getCell(2,1).getContent() == Mark.CROSS))
							{return Outcome.PLAYER2_WIN;}
					if((gb.getCell(0,2).getContent() == Mark.CROSS) 
						&&  (gb.getCell(1,2).getContent() == Mark.CROSS) 
						&&  (gb.getCell(2,2).getContent() == Mark.CROSS)) 
							{return Outcome.PLAYER2_WIN;}

		//DIAGONALS//
					if((gb.getCell(0,0).getContent() == Mark.NOUGHT) 
							&& (gb.getCell(1,1).getContent() == Mark.NOUGHT) 
							&& (gb.getCell(2,2).getContent() == Mark.NOUGHT)) 
								{return Outcome.PLAYER1_WIN;}
						if((gb.getCell(0,2).getContent() == Mark.NOUGHT) 
							&& (gb.getCell(1,1).getContent() == Mark.NOUGHT) 
							&& (gb.getCell(2,0).getContent() == Mark.NOUGHT)) 
								{return Outcome.PLAYER1_WIN;}

						if((gb.getCell(0,0).getContent() == Mark.CROSS) 
							&& (gb.getCell(1,1).getContent() == Mark.CROSS) 
							&& (gb.getCell(2,2).getContent() == Mark.CROSS)) 
								{return Outcome.PLAYER2_WIN;}
						if((gb.getCell(0,2).getContent() == Mark.CROSS) 
							&& (gb.getCell(1,1).getContent() == Mark.CROSS) 
							&& (gb.getCell(2,0).getContent() == Mark.CROSS)) 
								{return Outcome.PLAYER2_WIN;}

						//TIES//
						if((gb.getCell(2,2).getContent() == Mark.NOUGHT) 
								&& (gb.getCell(1,2).getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,1).getContent() == Mark. NOUGHT)
								&& (gb.getCell(0,1).getContent() == Mark. NOUGHT)
								&& (gb.getCell(2,0).getContent() == Mark. NOUGHT)) 
									{return Outcome.TIE;}
						if ((gb.getCell(0,0).getContent() == Mark.NOUGHT )
								&& (gb.getCell(1,0).getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,1).getContent() == Mark.NOUGHT) 
								&& (gb.getCell(2,1).getContent() == Mark.NOUGHT)
								&& (gb.getCell(0,2).getContent() == Mark.NOUGHT))
									{return Outcome.TIE;}//**#2
						if ((gb.getCell(0,2).getContent() == Mark.NOUGHT) 
								&& (gb.getCell(1,2).getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,1).getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,1).getContent() == Mark.NOUGHT)
								&& (gb.getCell(0,0).getContent() == Mark.NOUGHT)) 
									{return Outcome.TIE;}//**#3
						if ((gb.getCell(2,0).getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,1).getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,1).getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,2) .getContent() == Mark.NOUGHT) 
								&& (gb.getCell(0,0) .getContent() == Mark.NOUGHT))
									{return Outcome.TIE;}//**#4
						if ((gb.getCell(0,0).getContent() == Mark.NOUGHT)
								&& (gb.getCell(0,1).getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,1).getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,2).getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,0).getContent() == Mark.NOUGHT))
									{return Outcome.TIE;}//**#5
						if ((gb.getCell(2,0) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,0) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,1) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(0,1).getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,2) .getContent() == Mark.NOUGHT))
									{return Outcome.TIE;}//**#6
						if ((gb.getCell(0,2) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(0,1) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,1) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,0).getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,2) .getContent() == Mark.NOUGHT))
									{return Outcome.TIE;} //**#7
						if ((gb.getCell(2,2) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,1) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,1) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,0).getContent() == Mark.NOUGHT)
								&& (gb.getCell(0,2) .getContent() == Mark.NOUGHT))
									{return Outcome.TIE;} //**#8
						if((gb.getCell(0,2) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(0,1) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,2) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,1).getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,0) .getContent() == Mark.NOUGHT))
									{return Outcome.TIE;}//**#9
						if((gb.getCell(0,0) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,0) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(0,1).getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,1).getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,2) .getContent() == Mark.NOUGHT))
									{return Outcome.TIE;}//**#10
						if((gb.getCell(2,0) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,0) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,1) .getContent() == Mark.NOUGHT) 
								&& (gb.getCell(0,1) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,2) .getContent() == Mark.NOUGHT))
									{return Outcome.TIE;}//**#11
						if((gb.getCell(2,2) .getContent() == Mark.NOUGHT) 
								&& (gb.getCell(1,2) .getContent() == Mark.NOUGHT) 
								&& (gb.getCell(2,1) .getContent() == Mark.NOUGHT) 
								&& (gb.getCell(0,1) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,0) .getContent() == Mark.NOUGHT))
									{return Outcome.TIE;}//**#12
						if ((gb.getCell(0,2) .getContent() == Mark.NOUGHT) 
								&& (gb.getCell(0,1) .getContent() == Mark.NOUGHT) 
								&& (gb.getCell(1,2) .getContent() == Mark.NOUGHT) 
								&& (gb.getCell(1,0).getContent() == Mark.NOUGHT) 
								&& (gb.getCell(2,0) .getContent() == Mark.NOUGHT))
									{return Outcome.TIE;}//**#13
						if ((gb.getCell(0,2) .getContent() == Mark.NOUGHT) 
								&& (gb.getCell(0,1) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,1) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,0).getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,1) .getContent() == Mark.NOUGHT))
									{return Outcome.TIE;}//**#14
						if ((gb.getCell(0,0) .getContent() == Mark.NOUGHT)
								 && (gb.getCell(0,1) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,0) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,1).getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,2) .getContent() == Mark.NOUGHT))
									{return Outcome.TIE;}//**#15
						if ((gb.getCell(0,0) .getContent() == Mark.NOUGHT) 
								&& (gb.getCell(0,1) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,0) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,2).getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,2) .getContent() == Mark.NOUGHT))
									{return Outcome.TIE;}//**#16
						if ((gb.getCell(2,2) .getContent() == Mark.NOUGHT) 
								&& (gb.getCell(2,1) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,2) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,0).getContent() == Mark.NOUGHT)
								&& (gb.getCell(0,0) .getContent() == Mark.NOUGHT))
									{return Outcome.TIE;}//**#17
						if ((gb.getCell(2,2) .getContent() == Mark.NOUGHT) 
								&& (gb.getCell(2,1) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,2) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(0,1).getContent() == Mark.NOUGHT)
								&& (gb.getCell(0,0) .getContent() == Mark.NOUGHT))
									{return Outcome.TIE;}//**#18
						if ((gb.getCell(2,0) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,1) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,0) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(0,1).getContent() == Mark.NOUGHT)
								&& (gb.getCell(0,2) .getContent() == Mark.NOUGHT))
									{return Outcome.TIE;}//**#19
						if ((gb.getCell(2,0) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,1) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,0) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,2).getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,2) .getContent() == Mark.NOUGHT))
									{return Outcome.TIE;}//**#20
						if ((gb.getCell(2,0) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,0) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,1) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(0,2).getContent() == Mark.NOUGHT)
								&& (gb.getCell(0,1) .getContent() == Mark.NOUGHT))
									{return Outcome.TIE;}//**#21
						if ((gb.getCell(2,0) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,0) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,1) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,2).getContent() == Mark.NOUGHT)
								&& (gb.getCell(0,2) .getContent() == Mark.NOUGHT))
									{return Outcome.TIE;}//**#22
						if ((gb.getCell(0,0) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(0,2) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,2) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,0).getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,1) .getContent() == Mark.NOUGHT))
									{return Outcome.TIE;}//**#23
						if ((gb.getCell(2,2) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(0,1).getContent() == Mark.NOUGHT)
								&& (gb.getCell(0,2).getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,0).getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,0) .getContent() == Mark.NOUGHT))
									{return Outcome.TIE;}//**#24
						if ((gb.getCell(0,2) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,0) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(0,0) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,2).getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,1) .getContent() == Mark.NOUGHT))
									{return Outcome.TIE;}//**#25
						if ((gb.getCell(2,0) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,2) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,2) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(0,0).getContent() == Mark.NOUGHT)
								&& (gb.getCell(0,1) .getContent() == Mark.NOUGHT))
									{return Outcome.TIE;}//**#26
						if ((gb.getCell(0,0) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(0,1) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,0) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,1).getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,2) .getContent() == Mark.NOUGHT))
									{return Outcome.TIE;}//**#27
						if ((gb.getCell(2,0) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,0) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,2) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,2).getContent() == Mark.NOUGHT)
								&& (gb.getCell(0,1) .getContent() == Mark.NOUGHT))
									{return Outcome.TIE;}//**#28
						if ((gb.getCell(0,1) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(0,2) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,1) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,2).getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,0) .getContent() == Mark.NOUGHT))
									{return Outcome.TIE;}//**#29
						if ((gb.getCell(0,0).getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,0) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(0,2) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,2).getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,1) .getContent() == Mark.NOUGHT))
									{return Outcome.TIE;}//**#30

		return Outcome.CONTINUE;
	}
	
		private void takeTurn(Cell c) {
			Mark curMark = (turn++ % 2 == 0)? Mark.NOUGHT: Mark.CROSS;
			gb.setCell(curMark,c.getRow(),c.getColumn());
			if (getOutcome() == Outcome.PLAYER1_WIN)
					JOptionPane.showMessageDialog(this, "Player 1, O, wins!");
			else if (getOutcome() == Outcome.PLAYER2_WIN)
					JOptionPane.showMessageDialog(this, "Player 2, X, wins!");
			else if (getOutcome() == Outcome.TIE)
					JOptionPane.showMessageDialog(this, "Tie.");
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
}
