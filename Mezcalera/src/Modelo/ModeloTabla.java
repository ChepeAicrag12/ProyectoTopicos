package Modelo;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Clase controladora, aquí se encuentra la parte lógica del proyecto.
 * @author García García José Ángel
 * @author Sánchez Chávez Kevin Edilberto
 * @version 1.0 14/06/2020
 */
public class ModeloTabla extends AbstractTableModel {

    // Variable de instancia - Lista contenedora de los datos.
    private List<Object[]> dato;

    // Variable de instancia - Encabezados de la tabla.
    private String encabezado[];

    // Variable de instancia - Arreglo de tipo de clase de encabezados.
    private Class tipos[];

    public ModeloTabla( String encabezado[], Class tipos[]){
        this.encabezado = encabezado;
        this.tipos = tipos;
    }

    /**
     * Establece los datos a mostrar en la tabla.
     *
     * @param d Datos a colocar
     */
    public void setDatos(List<Object[]> d) {
        dato = d;
    }

    /**
     * Retorna la clase de la columna de acuerdo a la posición dada.
     *
     * @param c Múmero de columna en un rango de 0 a n.
     * @return Clase de la columna en dicha posición.
     */
    @Override
    public Class getColumnClass(int c){
        return tipos[c];
    }

    /**
     * Retorna el valor de las filas que hay.
     *
     * @return Número de filas en la tabla.
     */
    @Override
    public int getRowCount() {
        try{
            return dato.size();
        }catch(Exception e){
            return 0;
        }
    }

    /**
     * Retorna el valor de las columnas que hay.
     *
     * @return Número de columnas en la tabla.
     */
    @Override
    public int getColumnCount() {
        return encabezado.length;
    }

    /**
     * Retorna el valor de la psoción dada.
     *
     * @param c Posición de la columna.
     * @param r Posición de la fila.
     * @return Objeto en la posición indicada.
     */
    @Override
    public Object getValueAt(int r, int c) {
        return dato.get(r)[c];
    }

    /**
     * Retorna el nombre de la columna dad.
     *
     * @param col Poisición de la columna.
     * @return Nombre de la columna.
     */
    @Override
    public String getColumnName(int col){
        return encabezado[col];
    }
}
