package co.edu.uniquindio.poo.cinemauq.modelo;

import java.time.LocalDate;

public class Promocion {

    private final String id = GeneradorId.siguiente("[PROM]");
    private String nombre;
    private double porcentaje;
    private LocalDate desde;
    private LocalDate hasta;
    private boolean activa = true;

    public Promocion(String nombre, double porcentaje, LocalDate desde, LocalDate hasta) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.desde = desde;
        this.hasta = hasta;
    }

    public boolean vigente(LocalDate hoy) {
        return activa && (hoy.isBefore(desde) || hoy.isEqual(desde));
    }

    public String getNombre() {
        return nombre;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public LocalDate getDesde() {
        return desde;
    }

    public LocalDate getHasta() {
        return hasta;
    }
    public boolean isActiva() {
        return activa;
    }
    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    @Override
    public String toString() {
        return "Promocion{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", porcentaje=" + porcentaje +
                ", desde=" + desde +
                ", hasta=" + hasta +
                ", activa=" + activa +
                '}';
    }
}
