package ProyectoTateti;
import java.util.Scanner;
public class Tateti {

	void mostrarTablero() {
		char [][]tablero = new char[3][3];
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				System.out.printf("%C", tablero [i][j]);
			}
			System.out.println("");
			System.out.println();
		}
	}
	
	
	void crearYLlenarTablero() {
		 try (Scanner in = new Scanner(System.in)) {
			System.out.println("Bienvenidos al tateti");
	        int jugador = 0;
	        int fila = 0;
	        int columna =  0;
	        char [][]tablero = new char[3][3];
	        for(int i = 0; i < tablero.length; i++) {
	            for (int j = 0; j < tablero[i].length; j++) {
	                tablero[i][j] = '-';
	            }    
	        }
	        boolean ganador = false;
	        int jugada = 1;
	        while (jugada <= 9) {
	            char ficha = 'X';
	            jugador = 1;
	            if (jugada % 2 == 0) {
	                ficha = 'O';
	                jugador = 2;
	            }
	            if (jugador == 1) {
	            System.out.println("Jugador "  + jugador + ", ingresar fila de la jugada");
	            fila = Integer.parseInt(in.nextLine());
	            System.out.println("Jugador " + jugador +", ingresar columna de la jugada");
	            columna = Integer.parseInt(in.nextLine());
	            } 
	            if (jugador == 2) {
	            	int min = 1;
	        		int max = 3;
	        		for(int i = min; i <=max; i++) {
	            	fila = (int) (Math.random() * (2-0+1));
	            	columna = (int) (Math.random() * (2-0+1));
	        		}
	            }
	            if (tablero[fila][columna] == '-') {
	                tablero[fila][columna] = ficha;
	                if ((tablero[fila][0]) == tablero [fila][1] && tablero [fila][1] == tablero [fila][2] ||
	                    (tablero[0][columna] == tablero [1][columna] && tablero [1][columna] == tablero [2][columna])||
	                    (tablero[0][0] == ficha && tablero [1][1] == ficha && tablero [2][2] == ficha)||
	                    (tablero[0][2] == ficha && tablero [1][1] == ficha && tablero [2][0] == ficha)){
	                    ganador = true;
	                }
	                jugada ++;
	            } else {
	                    System.out.println("La posicion ya se encuentra ocupada!");
	            }
	            for (int i=0; i<tablero.length; i++) {
	                for (int j=0; j<tablero.length; j++) {
	                    System.out.print(tablero[i][j] + " ");
	                } 
	                System.out.println();
	            }
	            if (ganador == true) {
	                break;
	            }
	        }
	        if (ganador == true) {
	            System.out.println("Fin del juego, ganador jugador " + jugador);
	        } else {
	            System.out.println("Fin del juego, empate");
	        }
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}