package lab4p2_equipo4;

import java.util.Random;

public class Fisico extends Movimiento{
    int poder;
    int precision;

    public Fisico() {
    }

    public Fisico(int poder, int precision, String nombre, String descripcion) {
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
        return "Fisico{" + "poder=" + poder + ", precision=" + precision + '}';
    }

    @Override
    public void Ataque(Pokemon atacante, Pokemon defensor) {
        Random rand = new Random();
        int daño = rand.nextInt(50) + 1;
        
        if(atacante.getAtk() > defensor.getDef()){
            daño *= 2;
        }
        else if(atacante.getAtk() < defensor.getDef()){
            daño *= 0.5;
        }
        
        defensor.setHP(defensor.getHP() - daño);
    }
    
    
}
