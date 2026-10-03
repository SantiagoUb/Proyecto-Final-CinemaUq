package co.edu.uniquindio.poo.cinemauq.modelo;

import java.time.LocalDateTime;

public class LotePuntos {
    private final String compraId;
    private final int cantidad;
    private int restantes;
    private final LocalDateTime fechaObtencion;
    private final LocalDateTime fechaVencimiento;

    public LotePuntos(String compraId, int cantidad, LocalDateTime fechaObtencion, int fechaVencimiento) {
        this.compraId = compraId;
        this.cantidad = cantidad;
        this.fechaObtencion = fechaObtencion;
        this.fechaVencimiento = fechaObtencion.plusYears(1);
    }

    public boolean vencido(LocalDateTime ahora) {
        return !ahora.isBefore(fechaVencimiento);
    }

    public void consumir(int n){
        restantes -= n;
    }

    public String getCompraId() {
        return compraId;
    }
    public int getCantidad() {
        return cantidad;
    }
    public int getRestantes() {
        return restantes;
    }
    public LocalDateTime getFechaObtencion() {
        return fechaObtencion;
    }
    public LocalDateTime getFechaVencimiento() {
        return fechaVencimiento;
    }
}
