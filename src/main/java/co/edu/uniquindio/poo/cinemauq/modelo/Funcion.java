package co.edu.uniquindio.poo.cinemauq.modelo;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Funcion implements PrototipoFuncion<Funcion>{

    private final String id = GeneradorId.siguiente("[FUNCION]");
    private final Pelicula pelicula;
    private final Sala sala;
    private final LocalDateTime inicio;
    private final Long precioBase;
    private EstadoFuncion estado = EstadoFuncion.PROGRAMADA;
    private final Set<String> asientosOcupados = new HashSet<>();

    public Funcion(Pelicula pelicula, Sala sala, LocalDateTime inicio, Long precioBase) {
        if(precioBase <= 0 ) throw new IllegalArgumentException("Precio de la funcion invalido");
        this.pelicula = pelicula;
        this.sala = sala;
        this.inicio = inicio;
        this.precioBase = precioBase;
    }

    //Constructor para las copias
    private Funcion(Funcion prototipoFuncion, LocalDateTime nuevoInicio) {
        this(prototipoFuncion.pelicula, prototipoFuncion.sala, prototipoFuncion.inicio, prototipoFuncion.precioBase);
    }

    @Override
    public Funcion clonar() {
        return new Funcion(this, inicio);
    }

    //metodo para saber si un asiento esta ocupado
    public synchronized boolean estaDisponible(String idAsiento){
        return estado == EstadoFuncion.PROGRAMADA && sala.getAsientos() != null && !asientosOcupados.contains(idAsiento);
    }

    //metodo para reservar un asiento
    public synchronized void reservar(Collection<String> ids, LocalDateTime ahora){
        if(estado != EstadoFuncion.PROGRAMADA)  throw new IllegalStateException("La funcion esta Cancelada");
        if(inicio.isAfter(ahora)) throw new IllegalArgumentException("La funcion ya comenzo");
        for(String a: ids){
            if(sala.getAsiento(a) == null) throw new IllegalStateException("El asiento " + a + " no existe en la sala");
            if(asientosOcupados.contains(a))throw new IllegalStateException("El asiento " + a + " ya fue vendido");
        }
        asientosOcupados.addAll(ids);
    }

    public synchronized void liberar(Collection<String> ids){
        asientosOcupados.removeAll(ids);
    }

    public synchronized void cancelar(){
        estado = EstadoFuncion.CANCELADA;
    }

    public synchronized double ocupacion(){
        return (double) asientosOcupados.size() / sala.capacidad();
    }

    public synchronized Set<String> getAsientosOcupados(){
        return Collections.unmodifiableSet(new HashSet<>(asientosOcupados));
    }


    public LocalDateTime getFin() { return inicio.plusMinutes(pelicula.getDuracionMin()); }
    public String getId() { return id; }
    public Pelicula getPelicula() { return pelicula; }
    public Sala getSala() { return sala; }
    public LocalDateTime getInicio() { return inicio; }
    public long getPrecio() { return precioBase; }
    public EstadoFuncion getEstado() { return estado; }

    @Override
    public String toString() {
        return id + " " + pelicula + " @ " + sala.getNombre() + " " + inicio;
    }
}
