package co.edu.uniquindio.poo.cinemauq.modelo;

import java.util.ArrayList;
import java.util.List;

public class Sala {

    private int id;
    private String nombre;
    private List<Asiento> asientos;

    public Sala(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.asientos = new ArrayList<>();
    }

    public void agregarAsiento(Asiento asiento) {
        asientos.add(asiento);
    }

    public void eliminarAsiento(Asiento asiento) {
        asientos.remove(asiento);
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Asiento> getAsientos() {
        return asientos;
    }

    public int getCapacidad() {
        return asientos.size();
    }
}
