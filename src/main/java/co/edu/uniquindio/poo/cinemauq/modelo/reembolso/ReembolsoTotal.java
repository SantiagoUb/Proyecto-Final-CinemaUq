package co.edu.uniquindio.poo.cinemauq.modelo.reembolso;

public class ReembolsoTotal implements PoliticaReembolso {
    @Override public boolean permiteCancelar() { return true; }
    @Override public double porcentaje() { return 1.0; }
    @Override public String descripcion() { return "Reembolso total (100%)"; }
}
