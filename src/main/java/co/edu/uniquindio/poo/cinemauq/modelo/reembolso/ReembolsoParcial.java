package co.edu.uniquindio.poo.cinemauq.modelo.reembolso;

public class ReembolsoParcial implements PoliticaReembolso {
    private final double porcentaje;
    public ReembolsoParcial(double porcentaje) { this.porcentaje = porcentaje; }
    @Override public boolean permiteCancelar() { return true; }
    @Override public double porcentaje() { return porcentaje; }
    @Override public String descripcion() { return "Reembolso parcial (" + (int) (porcentaje * 100) + "%)"; }
}
