package co.edu.uniquindio.poo.cinemauq.modelo;

public record Asiento(char fila, int numero, TipoAsiento tipo) {

    public String id(){
        return ""+ fila + numero;

    }

    @Override
    public String toString() {
        return id() +  "(" + tipo + ")";
    }
}
