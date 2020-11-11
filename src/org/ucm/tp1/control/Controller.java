/*
 * Jacinto Javier Calvente Ochoa
 * Pablo Garcia Garcia-Tenorio
 */


package org.ucm.tp1.control;

import java.util.Scanner;
//import java.util.logging.Level;


import org.ucm.tp1.logic.Game;
//import org.ucm.tp1.logic.gameobjects.GameObjectBoard;
//import org.ucm.tp1.logic.gameobjects.Vampire;
//import org.ucm.tp1.view.GamePrinter;
import org.ucm.tp1.control.Player;

public class Controller {

	
	public final String prompt = "Command > ";
	public static final String helpMsg = String.format(
			"Available commands:%n" +
			"[a]dd <x> <y>: add a slayer in position x, y%n" +
			"[h]elp: show this help%n" + 
			"[r]eset: reset game%n" + 
			"[e]xit: exit game%n"+ 
			"[n]one | []: update%n");
	
	public static final String unknownCommandMsg = String.format("Unknown command");
	public static final String invalidCommandMsg = String.format("Invalid command");
	public static final String invalidPositionMsg = String.format("Invalid position");
	

    private Game game;
    private Scanner scanner;
    Player player;
   
    private boolean pasaTurno;
    private boolean finJuego;
    
    
    public Controller(Game game, Scanner scanner) {
	    this.game = game;
	    pasaTurno = false;
	    this.scanner = scanner;

    }

    
    public void run() {
    
    	Scanner scanner = new Scanner(System.in);	
    	 
    	finJuego = false;
    	while(!finJuego) {
    		
			if(!pasaTurno) {pinta();}
					
    	    	pedirInstruccion(scanner, player);
    	    		
    	    	if(!pasaTurno) {
    	    		finJuego = game.juego();
    	    		
    	    	}
    	    
    	
			}
    	
    	
    	scanner.close();
    }
	


	private void pinta() {
	System.out.println("[DEBUG] Executing:");
    	System.out.println(this.game);
    	
	} 

	private void pedirInstruccion(Scanner escaner, Player player) {
    	
		boolean instruccionValida = false;
		pasaTurno = true;
		finJuego = false;
		
		
		while(!instruccionValida) {
			System.out.print(prompt);
			String leido = scanner.nextLine();
			String[] instrucciones = leido.toLowerCase().split(" ");
			
			if(("h").equals(instrucciones[0])||("help").equals(instrucciones[0])) {
				instruccionValida = true;
				System.out.println(helpMsg);
				
				
			}
			else if(("r").equals(instrucciones[0])||("reset").equals(instrucciones[0])) {
				instruccionValida = true;
				System.out.println("RESET");
				game.reset();
				
				//run();
				
			}
			else if(("n").equals(instrucciones[0])||("none").equals(instrucciones[0]) || ("").equals(instrucciones[0])) {
				instruccionValida = true;
				
				pasaTurno = false;
				
				
			}
			else if(("e").equals(instrucciones[0])||("exit").equals(instrucciones[0])) {
				instruccionValida = true;
				finJuego = true;
				System.out.println("exit");
				
				
			}
			
			else if(("a").equals(instrucciones[0])||("add").equals(instrucciones[0])) {
				
				  
				if (instrucciones.length==3) {
					boolean posOcupada = false;
					
					pasaTurno = false;
					instruccionValida = true;
					int col = Integer.parseInt(instrucciones[2]);
					int fila = Integer.parseInt(instrucciones[1]);
					
					posOcupada = game.comprobarCasilla(col, fila);
					
					if(posOcupada!= true) {
					
						game.aniadirSlayer(col, fila);
					}
					else if (posOcupada== true) {
						System.out.println("Posicion ocupada");
					}
					
					
					
				}
				else {
					instruccionValida = false;
					System.out.println(invalidCommandMsg);
				}
			}
			else {
				System.out.println(unknownCommandMsg);
			}
		}
    	
	}


}

