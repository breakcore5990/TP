/*
 * Jacinto Javier Calvente Ochoa
 * Pablo Garcia Garcia-Tenorio
 */



package org.ucm.tp1.logic.gameobjects;


import org.ucm.tp1.logic.Game;


public class Vampire {
	private int fila;
	private int columna;
	private Game game;
	private int vida;
	public int contVamp=1;
	
	
		public Vampire(Game game,int col, int fila) {
			this.columna = Game.COLUMNAS-1;
			this.fila = fila;
			this.game = game;
			this.vida = 5;
			
			
		}
		
		public int getFila() {
			return this.fila;
		}


		public int getColumna() {
			return this.columna;
		}

		
		
		@Override
		
		public String toString() {
			return "V ["+this.vida+"]";
		}

		public void mover() {
			if( game.comprobarCasilla( this.fila, this.columna-1)== false && contVamp == 0) {
				this.columna--;
				contVamp++;
			}
			else if(contVamp == 1) {
				contVamp--;
			}
				
			
		}



		public void ataca() {
			game.atacaSlayer(fila, columna);
			game.atacaSlayer(fila, columna-1);
			
		}

		public void receiveDamage(int danio) {
			this.vida = this.vida - danio;
			
		}

		public int getVida() {
			return this.vida;
		}
}