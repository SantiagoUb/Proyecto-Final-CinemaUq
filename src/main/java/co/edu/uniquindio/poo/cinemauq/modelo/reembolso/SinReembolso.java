package co.edu.uniquindio.poo.cinemauq.modelo.reembolso;

public class SinReembolso implements PoliticaReembolso {
    @Override public boolean permiteCancelar() { return false; }
    @Override public double porcentaje() { return 0; }
    @Override public String descripcion() { return "Cancelación no permitida"; }
}
