package co.edu.uniquindio.poo.cinemauq.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Funcion {

    private int id;
    private Pelicula pelicula;
    private Sala sala;
    private LocalDateTime fechaHora;

    private List<Asiento> asientosOcupados;

    public Funcion(int id, Pelicula pelicula, Sala sala, LocalDateTime fechaHora) {
        this.id = id;
        this.pelicula = pelicula;
        this.sala = sala;
        this.fechaHora = fechaHora;
        this.asientosOcupados = new ArrayList<>();
    }

    /*
     * Verifica si un asiento está disponible para esta función.
     */
    public boolean estaDisponible(Asiento asiento) {
        return !asientosOcupados.contains(asiento);
    }

    public boolean ocuparAsiento(Asiento asiento) {
        //Verificamos que el asiento pertenece a la sala
        if(!sala.getAsientos().contains(asiento)) {
            return false;
        }
        //Verificamos que el asiento no se compre dos veces
        if(asientosOcupados.contains(asiento)) {
            return false;
        }
        asientosOcupados.add(asiento);
        return true;
    }

    //Liberar un asiento ocupado
    public boolean liberarAsiento(Asiento asiento) {
        return asientosOcupados.remove(asiento);
    }

    // Getters
    public int getId() {
        return id;
    }    public Pelicula getPelicula() {
        return pelicula;
    }

    public Sala getSala() {
        return sala;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public List<Asiento> getAsientosOcupados() {
        return asientosOcupados;
    }

}
