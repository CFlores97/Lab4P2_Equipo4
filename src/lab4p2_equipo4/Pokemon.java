
package lab4p2_equipo4;


public class Pokemon {
    private String especie, estado;
    private int nivel, experiencia, subir_nivel, HP, atk, def, sp, speed; 
    
    
    // array normal de movimientos
    private Movimiento[] movimientos = new Movimiento[4];

    public Pokemon() {
    }

    public Pokemon(String especie, String estado, int nivel, int experiencia, int subir_nivel, int HP, int atk, int def, int sp, int speed) {
        this.especie = especie;
        this.estado = estado;
        this.nivel = nivel;
        this.experiencia = experiencia;
        this.subir_nivel = subir_nivel;
        this.HP = HP;
        this.atk = atk;
        this.def = def;
        this.sp = sp;
        this.speed = speed;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public int getSubir_nivel() {
        return subir_nivel;
    }

    public void setSubir_nivel(int subir_nivel) {
        this.subir_nivel = subir_nivel;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getSp() {
        return sp;
    }

    public void setSp(int sp) {
        this.sp = sp;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Movimiento[] getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(Movimiento[] movimientos) {
        this.movimientos = movimientos;
    }

    @Override
    public String toString() {
        return "Pokemon{" + "especie=" + especie + ", estado=" + estado + ", nivel=" + nivel + ", experiencia=" + experiencia + ", subir_nivel=" + subir_nivel + ", HP=" + HP + ", atk=" + atk + ", def=" + def + ", sp=" + sp + ", speed=" + speed + ", movimientos=" + movimientos + '}';
    }
    
    
    
}
