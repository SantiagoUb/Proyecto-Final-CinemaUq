package co.edu.uniquindio.poo.cinemauq.modelo;

public class Asiento {

    private final int fila;
    private final int numero;

    public Asiento(int fila, int numero) {
        this.fila = fila;
        this.numero = numero;
    }

    /*
     *Permite comparar dos asientos por su contenido
     *
     *Dos asientos son iguales si tienen la misma fila y el mismo numero
     */

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null || this.getClass() != obj.getClass()){
            return false;
        }
        Asiento asiento = (Asiento) obj;
        return this.fila == asiento.fila && this.numero == asiento.numero;
    }

    /*
     *Genera un codigo basado en fila y numero
     *Es necesario impelementarlo junto con equals()
     * para que funcionen estructuras como HashSet y HashMap
     * funcionen correctamente
     */
    @Override
    public int hashCode() {
        return this.fila + this.numero;
    }

    public int getFila() {
        return fila;
    }

    public int getNumero() {
        return numero;
    }

    public String getIdentificador() {
        return "F" + fila + "-A" + numero;
    }
}
