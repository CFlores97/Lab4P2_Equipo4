package lab4p2_equipo4;

import java.util.ArrayList;
import java.util.Scanner;

public class Lab4P2_Equipo4 {

    static ArrayList<Movimiento> movimientos = new ArrayList<>();
    static ArrayList<Entrenador> entrenadores = new ArrayList<>();

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

    // metodo para agregar entrenadores
    public static void addEntrenador() {
        System.out.println("Ingrese el nombre del entrenador: ");
        String name = sc.next();
        System.out.println("Ingrese la edad del entrenador: ");
        int edad = sc.nextInt();
        System.out.println("Ingrese el dinero del entrenador: ");
        int dinero = sc.nextInt();

        Entrenador ent = new Entrenador(name, edad, dinero);

        entrenadores.add(ent);

    }

    // agrega pokemones
    public static void capturaPok() {
        System.out.println("Ingrese la especie del pokemon: ");
        String esp = sc.next();

        System.out.println("Ingrese el nivel del pokemon: ");
        int nivel = sc.nextInt();

        System.out.println("Ingrese la experiencia del pokemon: ");
        int exp = sc.nextInt();

        System.out.println("Ingrese la experiencia que le falta para subir al siguiente nivel: ");
        int subir_exp = sc.nextInt();

    }
}
