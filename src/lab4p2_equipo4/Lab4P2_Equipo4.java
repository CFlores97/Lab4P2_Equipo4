package lab4p2_equipo4;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

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
                    addEntrenador();
                    break;
                case 2:
                    //Battle factory
                    if (entrenadores.size() < 2) {
                        System.out.println("No hay suficientes entrenadores");
                        break;
                    }
                    System.out.println("Elija sus combatientes:");
                    int ent1 = Listar(entrenadores);
                    int ent2 = Listar(entrenadores);

                    if (ent1 == ent2) {
                        System.out.println("No puede pelear contra si mismo!");
                        break;
                    }
                    
                    if(hayEquipo(entrenadores.get(ent1).getPokemones()) == false || hayEquipo(entrenadores.get(ent2).getPokemones()) == false){
                        System.out.println("Uno de los entrenadores no tiene pokemones!");
                        break;
                    }
                    
                    //Elige el pokemon del primer entrenador.
                    int in1 = ListarPokemon(entrenadores.get(ent1).getPokemones());
                    Pokemon PK1 = entrenadores.get(ent1).getPokemones()[in1];
                    while (entrenadores.get(ent1).getPokemones()[in1] == null) {
                        System.out.println("Tiene que elegir un pokemon");
                        in1 = ListarPokemon(entrenadores.get(ent1).getPokemones());
                        PK1 = entrenadores.get(ent1).getPokemones()[in1];
                    }
                    
                    //Elige el pokemon del segundo entrenador.
                    int in2 = ListarPokemon(entrenadores.get(ent2).getPokemones());
                    Pokemon PK2 = entrenadores.get(ent2).getPokemones()[in2];
                    while (entrenadores.get(ent2).getPokemones()[in2] == null) {
                        System.out.println("Tiene que elegir un pokemon");
                        in2 = ListarPokemon(entrenadores.get(ent1).getPokemones());
                        PK2 = entrenadores.get(ent1).getPokemones()[in2];
                    }
                    
                    //Empiezan a pelear
                    while(PK1.getHP() > 0 || PK2.getHP() > 0){
                        System.out.println("Pokemon 1: " + PK1.getHP() + " HP");
                        int mov1 = ListarMovimientos(PK1.getMovimientos());
                        
                        System.out.println("Pokemon 2:" + PK2.getHP() + "HP");
                        int mov2 = ListarMovimientos(PK2.getMovimientos());
                        
                        if(PK1.getSpeed() >= PK2.getSpeed()){
                            PK2 = batalla(PK1, PK2, mov1);
                            if(PK2.getHP() <= 0){
                                break;
                            }
                            PK1 = batalla(PK2,PK1,mov2);
                        }
                        else{
                            PK1 = batalla(PK2, PK1, mov2);
                            if(PK1.getHP() <= 0){
                                break;
                            }
                            PK2 = batalla(PK1,PK2,mov1);
                        }
                    }
                    //Dice quien gano.
                    System.out.println("La batalla ha terminado");
                    if(PK1.getHP() <= 0){
                        System.out.println(PK2.getEspecie() + " del entrenador 2 gana!!!");
                    }
                    else{
                        System.out.println(PK1.getEspecie() + " del entrenador 1 gana!!!");
                    }
                    break;

                case 3:
                    // Capturar/Entrenar
                    if (entrenadores.isEmpty()) {
                        System.out.println("No hay entrenadores que elegir!");
                        break;
                    }

                    int indice = Listar(entrenadores);

                    System.out.println("Que accion desea realizar?\n1. Capturar\n2. Entrenar");
                    int acc = sc.nextInt();

                    switch (acc) {
                        //Capturar
                        case 1:
                            if (movimientos.size() < 4) {
                                System.out.println("No hay suficientes movimientos para enseñarle a un pokemon!");
                                break;
                            }

                            Pokemon pk = capturaPok();
                            Entrenador a = entrenadores.get(indice);
                            System.out.println("A donde quiere agregar su pokemon?\n1. Equipo principal\n2. Caja de pokemones");
                            int ans = sc.nextInt();
                            switch (ans) {
                                case 1:
                                    int posicion = ListarPokemon(a.getPokemones());
                                    a.getPokemones()[posicion] = pk;
                                    break;

                                case 2:
                                    a.getPc().add(pk);
                                    break;

                                default:
                                    throw new AssertionError();
                            }
                            break;
                        //Entrenar
                        case 2:
                            if (hayEquipo(entrenadores.get(indice).getPokemones()) == false) {
                                System.out.println("No hay ningun pokemon que entrenar");
                                break;
                            }

                            int index = ListarPokemon(entrenadores.get(indice).getPokemones());
                            Pokemon tempPok = entrenadores.get(indice).getPokemones()[index];
                            while (entrenadores.get(indice).getPokemones()[index] == null) {
                                System.out.println("Tiene que elegir un pokemon");
                                index = ListarPokemon(entrenadores.get(indice).getPokemones());
                                tempPok = entrenadores.get(indice).getPokemones()[index];
                            }

                            int newExp = Entrenar();
                            System.out.println(tempPok.getEspecie() + " gano " + newExp + " exp.");

                            tempPok.setExperiencia_actual(tempPok.getExperiencia_actual() + newExp);
                            tempPok.setExp_acumulada(tempPok.getExp_acumulada() + newExp);

                            while (tempPok.getExperiencia_actual() >= tempPok.getSubir_nivel()) {
                                tempPok.setExperiencia_actual(tempPok.getExperiencia_actual() - tempPok.getSubir_nivel());
                                tempPok.setNivel(tempPok.getNivel() + 1);
                            }
                            System.out.println(tempPok.getEspecie() + " subio a nivel " + tempPok.getNivel());
                            break;
                        default:

                    }
                    break;

                case 4:
                    añadirMovimiento();
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
    public static Pokemon capturaPok() {
        System.out.println("Ingrese la especie del pokemon: ");
        String esp = sc.next();

        System.out.println("Ingrese el nivel del pokemon: ");
        int nivel = sc.nextInt();

        System.out.println("Ingrese la experiencia total del pokemon: ");
        int exp = sc.nextInt();

        System.out.println("Ingrese la experiencia para subir al siguiente nivel: ");
        int subir_exp = sc.nextInt();

        System.out.println("Ingrese el HP del pokemon: ");
        int hp = sc.nextInt();
        System.out.println("Ingrese el ataque del pokemon: ");
        int atk = sc.nextInt();
        System.out.println("Ingrese la defensa del pokemon: ");
        int def = sc.nextInt();
        System.out.println("Ingrese el especial del pokemon: ");
        int sp = sc.nextInt();
        System.out.println("Ingrese la velocidad  del pokemon: ");
        int spe = sc.nextInt();
        String estado = "Neutral";

        Pokemon pokemon = new Pokemon(esp, estado, nivel, exp, subir_exp, hp, atk, def, sp, spe);

        // agregar movimientos
        for (int i = 0; i < 4; i++) {
            int indx = Listar(movimientos);
            pokemon.getMovimientos()[i] = movimientos.get(indx);
            movimientos.remove(indx);
        }

        return pokemon;
    }

    //Listar para ArrayList
    public static int Listar(ArrayList lista) {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println((i + 1) + ".) " + lista.get(i));
        }
        System.out.println("\nElija uno de la lista");
        int indice = sc.nextInt();
        while (indice <= 0 || indice > lista.size()) {
            System.out.println("Tiene que elegir un indice valido!");
            indice = sc.nextInt();
        }

        return indice - 1;
    }

    //Listar los pokemones.
    public static int ListarPokemon(Pokemon[] lista) {
        for (int i = 0; i < lista.length; i++) {
            System.out.println((i + 1) + ".) " + lista[i]);
        }
        System.out.println("\nElija un Pokemon de la lista");
        int indice = sc.nextInt();
        while (indice <= 0 || indice > lista.length) {
            System.out.println("Tiene que elegir un indice valido!");
            indice = sc.nextInt();
        }

        return indice - 1;
    }

    //Listar los movimientos.
    public static int ListarMovimientos(Movimiento[] lista) {
        for (int i = 0; i < lista.length; i++) {
            System.out.println((i + 1) + ".) " + lista[i]);
        }
        System.out.println("\nElija un movimiento de la lista");
        int indice = sc.nextInt();
        while (indice <= 0 || indice > lista.length) {
            System.out.println("Tiene que elegir un indice valido!");
            indice = sc.nextInt();
        }

        return indice - 1;
    }

    public static int Entrenar() {

        Random ran = new Random();

        int multExp = ran.nextInt(2);
        int expGanada = ran.nextInt(4999) + 100;

        return multExp * expGanada;

    }

    public static void añadirMovimiento() {
        System.out.println("Ingrese el nombre del ataque:");
        String nombre = sc.next();
        System.out.println("Ingrese la descripcion del ataque:");
        String descripcion = sc.next();
        System.out.println("""
                           Que tipo de ataque es?:
                           1.)Fisico
                           2.)Especial
                           3.)Estado
                           """);
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                System.out.println("Ingrese el poder de ataque:");
                int poder = sc.nextInt();
                System.out.println("Ingrese la precision de ataque");
                int precision = sc.nextInt();

                Movimiento move = new Fisico(poder, precision, nombre, descripcion);
                movimientos.add(move);
                break;

            case 2:
                System.out.println("Ingrese el poder de ataque:");
                int poderE = sc.nextInt();
                System.out.println("Ingrese la precision de ataque");
                int precisionE = sc.nextInt();

                Movimiento move2 = new Especial(poderE, precisionE, nombre, descripcion);
                movimientos.add(move2);
                break;

            case 3:
                System.out.println("""
                                   Elija que tipo de estado es:
                                   1.)Dormido
                                   2.)Envenenado
                                   3.)Paralizado
                                   4.)Quemado
                                   """);
                int option = sc.nextInt();
                String estado = "";
                switch (option) {
                    case 1:
                        estado = "Dormido";
                        break;

                    case 2:
                        estado = "Envenenado";
                        break;

                    case 3:
                        estado = "Paralizado";
                        break;

                    case 4:
                        estado = "Quemado";
                        break;

                    default:
                        break;

                }
                Movimiento move3 = new Estado(estado, nombre, descripcion);
                movimientos.add(move3);

                break;

            default:
                break;

        }

    }

    public static boolean hayEquipo(Pokemon[] equipo) {
        boolean existe = false;
        for (int i = 0; i < equipo.length; i++) {
            if (equipo[i] instanceof Pokemon) {
                existe = true;
            }
        }
        return existe;
    }
    
    public static Pokemon batalla(Pokemon atacante, Pokemon defensor, int move){
        Movimiento attack = atacante.getMovimientos()[move];
        int daño = attack.Ataque(atacante, defensor);
        if(attack instanceof Fisico){
            System.out.println(atacante.getEspecie() + "hizo " + daño + " de Daño");
            defensor.setHP(defensor.getHP() - daño);
        }
        else if(attack instanceof Especial){
            System.out.println(atacante.getEspecie() + "hizo " + daño + " de Daño");
            defensor.setHP(defensor.getHP() - daño);
        }
        else{
            if(daño < 76){
                System.out.println(defensor.getEspecie() + " ahora esta " + ((Estado) attack).getEstado());
                defensor.setEstado(((Estado) attack).getEstado());
            }
            else{
                System.out.println("El ataque de " + atacante.getEspecie() + " fallo!");
            }
        }
        return defensor;
    }
}
