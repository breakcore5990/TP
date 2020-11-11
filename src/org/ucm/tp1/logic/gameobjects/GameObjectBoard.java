/*
 * Jacinto Javier Calvente Ochoa
 * Pablo Garcia Garcia-Tenorio
 */



package org.ucm.tp1.logic.gameobjects;

import org.ucm.tp1.list.SlayerList;
import org.ucm.tp1.list.VampireList;




	public class GameObjectBoard {
	private SlayerList slayerList;
	private VampireList vampireList;
	
	
	public GameObjectBoard() {
		
		slayerList = new SlayerList();
		vampireList = new VampireList();
  
	    
	}
	
	public void addSlayer(Slayer s) {
		
		slayerList.addSlayer(s);
	}
	
	public void addVampire(Vampire v) {
		vampireList.addVampire(v);
	}

	public void mover() {
		vampireList.mover();
		
		
	}

	public String getStringAt(int i, int j) {
		Vampire v = vampireList.getVampAt(i,j);
		Slayer s = slayerList.getSlayAt(i,j);
		if(v!=null) {
			return v.toString();
		}
		
		if(s!=null) {
			return s.toString();
		}
		return " ";
		
	}

	public boolean vampiroPorIzquierdaOigual() {
		boolean vamp = vampireList.existeVampiroIzquierdaOigual();
		
		return vamp;
	}

	public void atacar() {
		
		vampireList.atacar(); //ataque del vampiro
		slayerList.atacar(); //ataque del slayer
		
	}

	public void atacaSlayer(int fila, int columna) {//ataque a Slayer
		Slayer s = slayerList.getSlayAt(fila, columna);
		if (s!= null) {
			s.recibeDanio(1);
			
		}
		
	}

	public void retiraMuertos() {
		slayerList.retirarMuertos();
		vampireList.retiraMuertos();
		
	}

	public boolean atacaVampiro(int fila, int i) {

			Vampire v = vampireList.getVampAt(fila, i);
			
			if(v!=null) {
				v.receiveDamage(1);
				return true;
				
			}
			return false;
			
		}
		
	

	public boolean comprobarCasilla(int col, int fila) {
		
		Vampire v = vampireList.getVampAt(col,fila);
		Slayer s = slayerList.getSlayAt(col,fila);
		if(v!=null || s!=null) {
			return true;
		}
		else {
			return false;
		}

	}

	public int getVamp() {
		
		return vampireList.getUsadosVampire();
	}

	public int vampRestantes() {
		return vampireList.getRemainingVampires();
		
	}

	

	
	
	
	
	
}
