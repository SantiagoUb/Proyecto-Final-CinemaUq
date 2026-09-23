package co.edu.uniquindio.poo.cinemauq.modelo;

import java.time.LocalDateTime;

public class Movimiento {

    private final int id;
    private final TipoMovimiento tipo;
    private final double monto;
    private final LocalDateTime fecha;
    private final String descripcion;

    public Movimiento(int id, TipoMovimiento tipo, double monto, String descripcion) {
        this.id = id;
        this.tipo = tipo;
        this.monto = monto;
        this.descripcion = descripcion;
        this.fecha = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public TipoMovimiento getTipo() {
        return tipo;
    }

    public double getMonto() {
        return monto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

}
