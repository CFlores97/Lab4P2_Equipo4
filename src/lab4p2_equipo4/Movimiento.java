
package lab4p2_equipo4;


public abstract class Movimiento {
    private String nombre, descripcion;

    public Movimiento() {
    }

    public Movimiento(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Movimiento{" + "nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }
    
    public abstract void Ataque(Pokemon atacante, Pokemon defensor);
}
