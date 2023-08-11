package lab4p2_equipo4;

import java.util.ArrayList;

public class Entrenador {

    private String nombre;
    private int edad, dinero;

    private Pokemon[] pokemones = new Pokemon[6];
    private ArrayList<Pokemon> pc = new ArrayList<>();

    public Entrenador() {
    }

    public Entrenador(String nombre, int edad, int dinero) {
        this.nombre = nombre;
        this.edad = edad;
        this.dinero = dinero;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public Pokemon[] getPokemones() {
        return pokemones;
    }

    public void setPokemones(Pokemon[] pokemones) {
        this.pokemones = pokemones;
    }

    public ArrayList<Pokemon> getPc() {
        return pc;
    }

    public void setPc(ArrayList<Pokemon> pc) {
        this.pc = pc;
    }

    @Override
    public String toString() {
        return "Entrenador{" + "nombre=" + nombre + ", edad=" + edad + ", dinero=" + dinero + ", pokemones=" + print(pokemones) + ", pc=" + pc + '}';
    }

    public static String print(Pokemon[] arreglo) {
        String acum = "";
        for (Pokemon pk : arreglo) {

            acum += pk + " ";
        }

        return acum;
    }
    
    

}
