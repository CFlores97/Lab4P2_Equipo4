package lab4p2_equipo4;

import java.util.Random;

public class Especial extends Movimiento{
    int poder;
    int precision;

    public Especial() {
    }

    public Especial(int poder, int precision, String nombre, String descripcion) {
        super(nombre, descripcion);
        this.poder = poder;
        this.precision = precision;
    }

    public int getPoder() {
        return poder;
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    @Override
    public String toString() {
        return "Especial{" + "poder=" + poder + ", precision=" + precision + '}';
    }

    @Override
    public int Ataque(Pokemon atacante, Pokemon defensor) {
        Random rand = new Random();
        int daño = rand.nextInt(50) + 1;
        int rng = rand.nextInt(500) + 100;
        int suma = atacante.getSp() + defensor.getSp();
        
        if(rng == suma){
            daño *= 2;
        }
        return daño;
    }
    
}
