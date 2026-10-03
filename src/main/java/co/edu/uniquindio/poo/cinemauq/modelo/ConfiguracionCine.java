package co.edu.uniquindio.poo.cinemauq.modelo;

public class ConfiguracionCine {

    private static final class Holder {
        static final ConfiguracionCine INSTANCIA = new ConfiguracionCine();
    }

    private ConfiguracionCine() { }
    public static ConfiguracionCine obtener() { return Holder.INSTANCIA; }

    // Valores por defecto = reglas de negocio del enunciado
    private volatile double pesosPorPuntoGanado = 1000;
    private volatile double valorPuntoRedimido = 50;
    private volatile int vigenciaPuntosAnios = 1;
    private volatile long horasReembolsoTotal = 24;
    private volatile long horasLimiteCancelacion = 2;
    private volatile double porcentajeReembolsoParcial = 0.8;

    public double getPesosPorPuntoGanado() { return pesosPorPuntoGanado; }
    public double getValorPuntoRedimido() { return valorPuntoRedimido; }
    public int getVigenciaPuntosAnios() { return vigenciaPuntosAnios; }
    public long getHorasReembolsoTotal() { return horasReembolsoTotal; }
    public long getHorasLimiteCancelacion() { return horasLimiteCancelacion; }
    public double getPorcentajeReembolsoParcial() { return porcentajeReembolsoParcial; }
    public void setPesosPorPuntoGanado(double v) { this.pesosPorPuntoGanado = v; }
    public void setValorPuntoRedimido(double v) { this.valorPuntoRedimido = v; }
}
