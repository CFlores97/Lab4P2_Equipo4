
package lab4p2_equipo4;

import java.util.ArrayList;
import java.util.Scanner;


public class Lab4P2_Equipo4 {

    static ArrayList<Movimiento> movimientos = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    
    
    public static void main(String[] args) {
        boolean running = true;
        
        while (running) {
            System.out.println("1. Registrar entrenador\n2. Battle Factory\n3. Capturar/Entrenar\n4. Añadir movimientos\n5. Salir");
            int op = sc.nextInt();
            
            switch (op) {
                case 1:
                    break;
                case 2:
                    break;
                
                case 3:
                    break;
                
                case 4:
                    break;
                
                case 5:
                    running = false;
                    break;
                
                default:
                    break;
            }
            
        }
    }
    
}
