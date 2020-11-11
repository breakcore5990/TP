/*
 * Jacinto Javier Calvente Ochoa
 * Pablo Garcia Garcia-Tenorio
 */



package org.ucm.tp1.control;

import java.util.Random;



public class Player {
	public int monedas ;
	private Random rand;
	public long seed;
	
	public Player(int monedas, Random rand){
		this.monedas = monedas;
		this.rand = rand;
		
	}


	public int getMonedas() {
		return monedas;
	}

	public void setMonedas(int monedas) {
		this.monedas = monedas;
	}
	
	
	public void update() {
		
		if (rand.nextFloat() >0.5) {
			monedas+=10;
		}
		
		
	}
	
}
