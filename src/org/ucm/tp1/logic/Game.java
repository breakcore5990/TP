/*
 * Jacinto Javier Calvente Ochoa
 * Pablo Garcia Garcia-Tenorio
 */


package org.ucm.tp1.logic;
import org.ucm.tp1.logic.Level;


import java.util.Random;


import org.ucm.tp1.control.Player;

import org.ucm.tp1.logic.gameobjects.GameObjectBoard;
import org.ucm.tp1.logic.gameobjects.Vampire;
import org.ucm.tp1.view.GamePrinter;
import org.ucm.tp1.logic.gameobjects.Slayer;


public class Game {
	private GameObjectBoard board;
	private Player player;
	public static int FILAS;
	public static int COLUMNAS;
	public static double FRECUENCIA;
	private GamePrinter printer;
	private int turno;
	public static int NUMVAMPTOT;
	public static double seed;
	private Random rand;
	
	
	public Game(long seed, Level level) {
		
		this.rand = new Random(seed);
		
		COLUMNAS = level.getDim_x();
		FILAS = level.getDim_y();
		FRECUENCIA = level.getVampireFrequency();
		NUMVAMPTOT = level.getNumberOfVampires();
		printer = new GamePrinter(this);
		player = new Player(50, rand);
		board = new GameObjectBoard();

		
		
	}
	
	public Random getRand() {
		return rand;
	}
	

	public void update() {
		player.update(); //actualiza el numero de monedas del jugador
		board.mover();
		
	}
	
	public String toString() {
		
		StringBuilder temp = new StringBuilder("");
		temp.append("Numero de ciclos: "+ turno +"\n");
		temp.append("Monedas: "+ player.monedas + "\n");
		temp.append("Vampiros restantes: "+ board.vampRestantes()+ "\n");
		temp.append("Vampiros en el tablero: "+ board.getVamp() + "\n");
		temp.append(printer.toString());
		
		
		return temp.toString();
	}
	
	public boolean juego() {
		
		update(); //mueve los objetos del tablero y actualiza monedas del player
		atacar();
		addVampire();
		retirarMuertos();
		
		boolean endGame = false;
		if(board.vampiroPorIzquierdaOigual()) {
			System.out.println("[GAME OVER] Vampires win!");
			endGame=true;
		}
		if(board.vampRestantes()==0 && board.getVamp() == 0) {
			endGame=true;
			System.out.println("[GAME OVER] Slayer win!");
		}
		turno++;
		return endGame;
	}
	

	private void retirarMuertos() {
		board.retiraMuertos();
		
	}

	private void atacar() {
		board.atacar();
		
	}

	
	public void aniadirSlayer(int col, int fila) {
		if(player.monedas>=50) {
			player.monedas =player.monedas-50;
			board.addSlayer(new Slayer(this, col, fila));
		}
		else {
			System.out.println("No tienes suficientes monedas");
		}
		
		
	}

	public void reset() {
		
		board = new GameObjectBoard();
		player = new Player(50, rand);
		printer = new GamePrinter(this);
		turno = 0;

		this.rand = new Random(getSeed());
		
		
	}

	public static long getSeed() {
		return (long) seed;
	}

	public static void setSeed(double seed) {
		Game.seed = seed;
	}

	public String getStringAt(int i, int j) {
		return board.getStringAt(i,j);
		 
	}

	public void addVampire() {
		
		if (rand.nextDouble()<FRECUENCIA && board.vampRestantes()>0) {
			int fila = rand.nextInt(Game.FILAS-1);
			int col = Game.COLUMNAS;
			if(comprobarCasilla( fila, col) == false)	{
			board.addVampire(new Vampire(this,col, fila));
			}
			else {
				System.out.println("[DEBUG] vampire blocked");
			}
			
		}
	}
	

	public void atacaSlayer(int fila, int columna) {
		board.atacaSlayer(fila, columna);
		
	}

	public boolean atacaVampiro(int fila, int i) {//ataque del slayer al vampiro
		
			return board.atacaVampiro(fila, i);

	}

	public boolean comprobarCasilla(int col, int fila) {
		return board.comprobarCasilla(col , fila);
		
	}
	
	
	
	
}
