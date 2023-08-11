package lab4p2_equipo4;
import java.util.Random;

public class Estado extends Movimiento{
    private String estado;

    public Estado() {
    }

    public Estado(String estado, String nombre, String descripcion) {
        super(nombre, descripcion);
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Estado{" + "estado=" + estado + '}';
    }

    @Override
    public int Ataque(Pokemon atacante, Pokemon defensor) {
        Random rand = new Random();
        int rng = rand.nextInt(100) + 1;
        return rng;
    }
}