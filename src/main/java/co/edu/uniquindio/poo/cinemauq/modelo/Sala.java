package co.edu.uniquindio.poo.cinemauq.modelo;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Sala {
    private final String id = GeneradorId.siguiente("[SALA]");
    private final String nombre;
    private final TipoSala tipo;
    private final Map<String, Asiento> asientos = new LinkedHashMap<>();

    //Genera la distribucion de asientos: filas A, B ,C ... y columnas 1..n.
    public Sala(String nombre, TipoSala tipo, int filas, int columnas) {
        if(filas < 1 || filas > 26 || columnas < 1 || columnas > 26) throw new IllegalArgumentException("Distribucion no valida");
        this.nombre = nombre;
        this.tipo = tipo;
        for (int i = 0; i < filas; i++) {
            TipoAsiento ta = tipo == TipoSala.SALA_VIP ? TipoAsiento.VIP
                    : (i >= filas / 3 && i < 2 * filas / 3 + 1 ? TipoAsiento.PREFERENCIAL : TipoAsiento.GENERAL);
            for (int c = 1; c <= columnas; c++) {
                Asiento a = new Asiento((char) ('A' + i), c, ta);
                asientos.put(a.id(), a);
            }
        }
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public TipoSala getTipo() { return tipo; }
    public int capacidad() { return asientos.size(); }
    public Map<String, Asiento> getAsientos() { return Collections.unmodifiableMap(asientos); }

    public Asiento getAsiento(String idAsiento) { return asientos.get(idAsiento); }

    @Override
    public String toString() {
        return nombre + " [" + tipo + ", " + capacidad() + " asientos]";
    }
}
