/*
 * Jacinto Javier Calvente Ochoa
 * Pablo Garcia Garcia-Tenorio
 */


package org.ucm.tp1.logic.gameobjects;
import org.ucm.tp1.logic.Game;


public class Slayer {
	
	private int fila;
	
	static final int COSTE = 50;
	private Game game;
	private int columna;
	private int vida = 3;
	
	static final int MAX_VIDA = 5;
	
	public Slayer(Game game, int fila, int columna) {
		
		this.columna = columna;
		this.fila = fila;
		this.game = game;
		
		
	}
	
	public int getFila() {
		return this.fila;
	}



	public int getColumna() {
		return this.columna;
	}



	public int getVida() {
		return this.vida;
	}



	public void setVida(int vida) {
		this.vida = vida;
	}

		
		public String toString() {
			
			return "S ["+this.vida+"]";
		}

		public void recibeDanio(int danio) {
			this.vida = this.vida - danio;
			
		}

		public void ataca() {
			
			int cont = 0;
			for(int i = 0; i<Game.COLUMNAS;i++) {
				if(cont == 0) {
					if(game.atacaVampiro(fila, i) == true) {
						cont++;
					}
					
					
				}
				
			}
			
			
		}
		
}
