package games.board;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TicTacToeGame extends JFrame {
	static int[][] cells = new int[3][3];
	public static void main(String[] args) {
		SwingUtilities.invokeLater( new Runnable () {
	           public void run() { new TicTacToeGame();}
	    });
		}
	private static Board gb;
	private int turn;
	
	static Outcome getOutcome() {
		Boolean win = false;
		Boolean tie = false;
		//ROWS//
				if((gb.getCell(0, 0).getContent() == Mark.NOUGHT) 
						&& (gb.getCell(0,1).getContent() == Mark.NOUGHT) 
						&& (gb.getCell(0,2).getContent() == Mark.NOUGHT)) 
							{win = true;}
				if((gb.getCell(1,0).getContent() == Mark.NOUGHT) 
						&&  (gb.getCell(1,1).getContent() == Mark.NOUGHT) 
						&&  (gb.getCell(1,2).getContent() == Mark.NOUGHT))
				{win = true;}
					if((gb.getCell(2,0).getContent() == Mark.NOUGHT) 
						&&  (gb.getCell(2,1).getContent() == Mark.NOUGHT) 
						&&  (gb.getCell(2,2).getContent() == Mark.NOUGHT)) 
					{win = true;}
				
					if((gb.getCell(0,0).getContent() == Mark.CROSS) 
							&& (gb.getCell(0,1).getContent() == Mark.CROSS)
							&& (gb.getCell(0,2).getContent() == Mark.CROSS)) 
								{win = true;}
						if((gb.getCell(1,0).getContent() == Mark.CROSS)
							&&  (gb.getCell(1,1).getContent() == Mark.CROSS) 
							&&  (gb.getCell(1,2).getContent() == Mark.CROSS))
								{win = true;}
						if((gb.getCell(2,0).getContent() == Mark.CROSS) 
							&&  (gb.getCell(2,1).getContent() == Mark.CROSS) 
							&&  (gb.getCell(2,2).getContent() == Mark.CROSS)) 
								{win = true;}

						//COLUMNS//
						if((gb.getCell(0,0).getContent() == Mark.NOUGHT) 
						&& (gb.getCell(1,0).getContent() == Mark.NOUGHT) 
						&& (gb.getCell(2,0).getContent() == Mark.NOUGHT)) 
							{win = true;}
					if((gb.getCell(0,1).getContent() == Mark.NOUGHT) 
						&&  (gb.getCell(1,1).getContent() == Mark.NOUGHT) 
						&&  (gb.getCell(2,1).getContent() == Mark.NOUGHT))
							{win = true;}
					if((gb.getCell(0,2).getContent() == Mark.NOUGHT) 
						&&  (gb.getCell(1,2).getContent() == Mark.NOUGHT) 
						&&  (gb.getCell(2,2).getContent() == Mark.NOUGHT)) 
							{win = true;}

					if((gb.getCell(0,0).getContent() == Mark.CROSS) 
						&& (gb.getCell(1,0).getContent() == Mark.CROSS) 
						&& (gb.getCell(2,0).getContent() == Mark.CROSS)) 
							{win = true;}
					if((gb.getCell(0,1).getContent() == Mark.CROSS) 
						&&  (gb.getCell(1,1).getContent() == Mark.CROSS) 
						&&  (gb.getCell(2,1).getContent() == Mark.CROSS))
							{win = true;}
					if((gb.getCell(0,2).getContent() == Mark.CROSS) 
						&&  (gb.getCell(1,2).getContent() == Mark.CROSS) 
						&&  (gb.getCell(2,2).getContent() == Mark.CROSS)) 
							{win = true;}

		//DIAGONALS//
					if((gb.getCell(0,0).getContent() == Mark.NOUGHT) 
							&& (gb.getCell(1,1).getContent() == Mark.NOUGHT) 
							&& (gb.getCell(2,2).getContent() == Mark.NOUGHT)) 
								{win = true;}
						if((gb.getCell(0,2).getContent() == Mark.NOUGHT) 
							&& (gb.getCell(1,1).getContent() == Mark.NOUGHT) 
							&& (gb.getCell(2,0).getContent() == Mark.NOUGHT)) 
								{win = true;}

						if((gb.getCell(0,0).getContent() == Mark.CROSS) 
							&& (gb.getCell(1,1).getContent() == Mark.CROSS) 
							&& (gb.getCell(2,2).getContent() == Mark.CROSS)) 
								{win = true;}
						if((gb.getCell(0,2).getContent() == Mark.CROSS) 
							&& (gb.getCell(1,1).getContent() == Mark.CROSS) 
							&& (gb.getCell(2,0).getContent() == Mark.CROSS)) 
								{win = true;}

						//TIES//
						//TIES//
						if((gb.getCell(2,2).getContent() == Mark.NOUGHT) 
								&& (gb.getCell(1,2).getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,1).getContent() == Mark.NOUGHT)
								&& (gb.getCell(0,1).getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,0).getContent() == Mark.NOUGHT)) 
									{tie = true;}
						if ((gb.getCell(0,0).getContent() == Mark.NOUGHT )
								&& (gb.getCell(1,0).getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,1).getContent() == Mark.NOUGHT) 
								&& (gb.getCell(2,1).getContent() == Mark.NOUGHT)
								&& (gb.getCell(0,2).getContent() == Mark.NOUGHT))
									{tie = true;}//**#2
						if ((gb.getCell(0,2).getContent() == Mark.NOUGHT) 
								&& (gb.getCell(1,2).getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,1).getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,1).getContent() == Mark.NOUGHT)
								&& (gb.getCell(0,0).getContent() == Mark.NOUGHT)) 
									{tie = true;}//**#3
						if ((gb.getCell(2,0).getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,1).getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,1).getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,2) .getContent() == Mark.NOUGHT) 
								&& (gb.getCell(0,0) .getContent() == Mark.NOUGHT))
									{tie = true;}//**#4
						if ((gb.getCell(0,0).getContent() == Mark.NOUGHT)
								&& (gb.getCell(0,1).getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,1).getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,2).getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,0).getContent() == Mark.NOUGHT))
									{tie = true;}//**#5
						if ((gb.getCell(2,0) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,0) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,1) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(0,1).getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,2) .getContent() == Mark.NOUGHT))
									{tie = true;}//**#6
						if ((gb.getCell(0,2) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(0,1) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,1) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,0).getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,2) .getContent() == Mark.NOUGHT))
									{tie = true;} //**#7
						if ((gb.getCell(2,2) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,1) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,1) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,0).getContent() == Mark.NOUGHT)
								&& (gb.getCell(0,2) .getContent() == Mark.NOUGHT))
									{tie = true;} //**#8
						if((gb.getCell(0,2) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(0,1) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,2) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,1).getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,0) .getContent() == Mark.NOUGHT))
									{tie = true;}//**#9
						if((gb.getCell(0,0) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,0) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(0,1).getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,1).getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,2) .getContent() == Mark.NOUGHT))
									{tie = true;}//**#10
						if((gb.getCell(2,0) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,0) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,1) .getContent() == Mark.NOUGHT) 
								&& (gb.getCell(0,1) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,2) .getContent() == Mark.NOUGHT))
									{tie = true;}//**#11
						if((gb.getCell(2,2) .getContent() == Mark.NOUGHT) 
								&& (gb.getCell(1,2) .getContent() == Mark.NOUGHT) 
								&& (gb.getCell(2,1) .getContent() == Mark.NOUGHT) 
								&& (gb.getCell(0,1) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,0) .getContent() == Mark.NOUGHT))
									{tie = true;}//**#12
						if ((gb.getCell(0,2) .getContent() == Mark.NOUGHT) 
								&& (gb.getCell(0,1) .getContent() == Mark.NOUGHT) 
								&& (gb.getCell(1,2) .getContent() == Mark.NOUGHT) 
								&& (gb.getCell(1,0).getContent() == Mark.NOUGHT) 
								&& (gb.getCell(2,0) .getContent() == Mark.NOUGHT))
									{tie = true;}//**#13
						if ((gb.getCell(0,2) .getContent() == Mark.NOUGHT) 
								&& (gb.getCell(0,1) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,1) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,0).getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,1) .getContent() == Mark.NOUGHT))
									{tie = true;}//**#14
						if ((gb.getCell(0,0) .getContent() == Mark.NOUGHT)
								 && (gb.getCell(0,1) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,0) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,1).getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,2) .getContent() == Mark.NOUGHT))
									{tie = true;}//**#15
						if ((gb.getCell(0,0) .getContent() == Mark.NOUGHT) 
								&& (gb.getCell(0,1) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,0) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,2).getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,2) .getContent() == Mark.NOUGHT))
									{tie = true;}//**#16
						if ((gb.getCell(2,2) .getContent() == Mark.NOUGHT) 
								&& (gb.getCell(2,1) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,2) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,0).getContent() == Mark.NOUGHT)
								&& (gb.getCell(0,0) .getContent() == Mark.NOUGHT))
									{tie = true;}//**#17
						if ((gb.getCell(2,2) .getContent() == Mark.NOUGHT) 
								&& (gb.getCell(2,1) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,2) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(0,1).getContent() == Mark.NOUGHT)
								&& (gb.getCell(0,0) .getContent() == Mark.NOUGHT))
									{tie = true;}//**#18
						if ((gb.getCell(2,0) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,1) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,0) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(0,1).getContent() == Mark.NOUGHT)
								&& (gb.getCell(0,2) .getContent() == Mark.NOUGHT))
									{tie = true;}//**#19
						if ((gb.getCell(2,0) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,1) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,0) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,2).getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,2) .getContent() == Mark.NOUGHT))
									{tie = true;}//**#20
						if ((gb.getCell(2,0) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,0) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,1) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(0,2).getContent() == Mark.NOUGHT)
								&& (gb.getCell(0,1) .getContent() == Mark.NOUGHT))
									{tie = true;}//**#21
						if ((gb.getCell(2,0) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,0) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,1) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,2).getContent() == Mark.NOUGHT)
								&& (gb.getCell(0,2) .getContent() == Mark.NOUGHT))
									{tie = true;}//**#22
						if ((gb.getCell(0,0) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(0,2) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,2) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,0).getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,1) .getContent() == Mark.NOUGHT))
									{tie = true;}//**#23
						if ((gb.getCell(2,2) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(0,1).getContent() == Mark.NOUGHT)
								&& (gb.getCell(0,2).getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,0).getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,0) .getContent() == Mark.NOUGHT))
									{tie = true;}//**#24
						if ((gb.getCell(0,2) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,0) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(0,0) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,2).getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,1) .getContent() == Mark.NOUGHT))
									{tie = true;}//**#25
						if ((gb.getCell(2,0) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,2) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,2) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(0,0).getContent() == Mark.NOUGHT)
								&& (gb.getCell(0,1) .getContent() == Mark.NOUGHT))
									{tie = true;}//**#26
						if ((gb.getCell(0,0) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(0,1) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,0) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,1).getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,2) .getContent() == Mark.NOUGHT))
									{tie = true;}//**#27
						if ((gb.getCell(2,0) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,0) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,2) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,2).getContent() == Mark.NOUGHT)
								&& (gb.getCell(0,1) .getContent() == Mark.NOUGHT))
									{tie = true;}//**#28
						if ((gb.getCell(0,1) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(0,2) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,1) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,2).getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,0) .getContent() == Mark.NOUGHT))
									{tie = true;}//**#29
						if ((gb.getCell(0,0).getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,0) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(0,2) .getContent() == Mark.NOUGHT)
								&& (gb.getCell(1,2).getContent() == Mark.NOUGHT)
								&& (gb.getCell(2,1) .getContent() == Mark.NOUGHT))
									{tie = true;}//**#30

		return Outcome.CONTINUE;
	}
	
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
}
