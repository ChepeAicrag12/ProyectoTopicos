/*
 * El mezcal ya destilado (Liquido)
 */

package Procesos;

/**
 * 
 * @author García García José Ángel
 */
public class Mezcal {
    private char tipo, estatus = 'D';
    private static int _id = 0;
    private int id;

    public Mezcal(char tipo) {
        this.tipo = tipo;
        _id++;
        id = _id;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public char getEstatus() {
        return estatus;
    }

    public void setEstatus(char estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return "Mezcal{" + "id=" + id + ", tipo=" + tipo + ", estatus=" + estatus + '}';
    }
   
}
