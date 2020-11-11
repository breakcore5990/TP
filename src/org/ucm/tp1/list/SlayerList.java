/*
 * Jacinto Javier Calvente Ochoa
 * Pablo Garcia Garcia-Tenorio
 */



package org.ucm.tp1.list;


import org.ucm.tp1.logic.gameobjects.Slayer;



public class SlayerList {
	private Slayer[] lista;
	private int usadosSlayer;
	
	public SlayerList() {
		lista = new Slayer[20];
		usadosSlayer = 0;
	}
	
	public void addSlayer(Slayer slayer) {
		if(usadosSlayer<lista.length) {
			lista[usadosSlayer]= slayer;
			usadosSlayer++;
		}
	}
	
	public Slayer[] getLista() {
		return lista;
	}
	

	public void removeSlayer(int pos) {
		if(usadosSlayer>pos) {
			for (int i = pos; pos<usadosSlayer-1; i++) {
				lista[i]= lista[i+1];
			}
		}
		usadosSlayer--;
	}

	public int getUsadosSlayer() {
		return usadosSlayer;
	}
	

	public Slayer getSlayAt(int fila, int columna) {
		Slayer s = null;
		for(int i = 0 ; i < usadosSlayer; i++) {
			if (lista[i].getFila() == fila &&  lista[i].getColumna() == columna) {
				s = lista[i]; 
				break;
			}
		}
		return s;
	}

	public void retirarMuertos() {
		for(int i = 0; i<usadosSlayer; i++) {
			if(lista[i].getVida()<=0) {
				removeSlayer(i);
				i--;
			}
		}
		
	}

	public void atacar() {
		
		for(int i = 0 ; i<usadosSlayer; i++) {

				lista[i].ataca();
				
			}
	}

}
