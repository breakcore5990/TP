/*
 * Jacinto Javier Calvente Ochoa
 * Pablo Garcia Garcia-Tenorio
 */


package org.ucm.tp1.view;



import org.ucm.tp1.logic.Game;
import org.ucm.tp1.utils.MyStringUtils;

public class GamePrinter {
	
	
	private Game game;
	private int numRows; 
	private int numCols ;
	public String[][]board;
	final String space = " ";
	
	public GamePrinter (Game game) {
		this.game = game;
		numRows = Game.FILAS;
		numCols = Game.COLUMNAS;
		board = new String[numRows][numCols];
		
	}

	private void encodeGame() {
		
			for(int i=0; i<numRows; i++) {
		        for (int j=0; j<numCols; j++) {
		            
		        	board[i][j] = game.getStringAt(i, j);
		            
		        } 
			}
		
	}
	
	 public String toString() {
		encodeGame();
		int cellSize = 7;
		int marginSize = 2;
		String vDelimiter = "|";
		String hDelimiter = "-";
		String intersect = space;
		String vIntersect = space;
		String hIntersect = "-";
		String corner = space;

		String cellDelimiter = MyStringUtils.repeat(hDelimiter, cellSize);

		String rowDelimiter = vIntersect + MyStringUtils.repeat(cellDelimiter + intersect, numCols-1) + cellDelimiter + vIntersect;
		String hEdge =  corner + MyStringUtils.repeat(cellDelimiter + hIntersect, numCols-1) + cellDelimiter + corner;

		String margin = MyStringUtils.repeat(space, marginSize);
		String lineEdge = String.format("%n%s%s%n", margin, hEdge);
		String lineDelimiter = String.format("%n%s%s%n", margin, rowDelimiter);

		StringBuilder str = new StringBuilder();

		str.append(lineEdge);
		for(int i=0; i<numRows; i++) {
		        str.append(margin).append(vDelimiter);
		        for (int j=0; j<numCols; j++)
		            str.append( MyStringUtils.centre(board[i][j], cellSize)).append(vDelimiter);
		        if (i != numRows - 1) str.append(lineDelimiter);
		        else str.append(lineEdge);   
		}

		return str.toString();
	    }
	 
}

