package co.edu.uniquindio.poo.cinemauq.modelo;

public class Entrada {

    private int id;
    private Funcion funcion;
    private Asiento asiento;
    private double precio;
    private Formato formato;

    public Entrada(int id, Funcion funcion, Asiento asiento, double precio, Formato formato) {
        this.id = id;
        this.funcion = funcion;
        this.asiento = asiento;
        this.precio = precio;
        this.formato = formato;
    }

    public int getId() {
        return id;
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    public double getPrecio() {
        return precio;
    }

    public Formato getFormato() {
        return formato;
    }
}
