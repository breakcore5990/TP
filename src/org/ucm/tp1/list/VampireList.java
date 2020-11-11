/*
 * Jacinto Javier Calvente Ochoa
 * Pablo Garcia Garcia-Tenorio
 */



package org.ucm.tp1.list;

import org.ucm.tp1.logic.gameobjects.Vampire;


import org.ucm.tp1.logic.Game;

public class VampireList {
		private int remainingVampires;
		private Vampire[] lista;
		private int usadosVampire =0;
		
		
		
		public VampireList() {
			
			lista = new Vampire[Game.NUMVAMPTOT];
			
			this.remainingVampires=Game.NUMVAMPTOT;
			this.usadosVampire =0;
		}

		public int getRemainingVampires() {
			return remainingVampires;
		}

		public void setRemainingVampires(int remainingVampires) {
			this.remainingVampires = remainingVampires;
		}


		public int getUsadosVampire() {
			return usadosVampire;
		}

		public void setUsadosVampire(int usadosVampire) {
			this.usadosVampire = usadosVampire;
		}

		public void addVampire( Vampire vampire) {
			 
			if(usadosVampire<lista.length) {
				lista[usadosVampire]= vampire;
				this.usadosVampire++;
				this.remainingVampires--;
			}
		}




		public void removeVampire(int pos) {
			if(usadosVampire>pos) {
				for (int i = pos; i<usadosVampire-1; i++) {
					if(usadosVampire >0) {
						lista[i]= lista[i+1];
					}
					
				}
				
			}
			usadosVampire--;
			
		}

		public void mover() {
			for(int i = 0 ; i<usadosVampire; i++) {
				lista[i].mover();
			}
			
		}


		public Vampire getVampAt(int fila, int columna) {
			Vampire v = null;
			for(int i = 0 ; i<usadosVampire; i++) {
				if (lista[i].getFila() == fila &&  lista[i].getColumna() == columna) {
					v = lista[i]; 
					break;
				}
			}
			
			return v;
		}




		public boolean existeVampiroIzquierdaOigual() {
			
			for(int i = 0 ; i<usadosVampire; i++) {
				if (lista[i].getColumna() < 0) {
					return true;
				}
			}
			return false;
		}




		public void atacar() {
			for(int i = 0 ; i<usadosVampire; i++) {
				lista[i].ataca();
			}
			
		}


		public void retiraMuertos() {
			for(int i = 0; i<usadosVampire; i++) {
				if ( lista[i].getVida()<=0) {
					removeVampire(i);
					i--;
				}
			}
			
		}

	}
