package co.edu.uniquindio.poo.cinemauq.modelo.reembolso;

public interface PoliticaReembolso {
    boolean permiteCancelar();
    double porcentaje();            // 0..1
    String descripcion();
}
