package co.edu.uniquindio.poo.cinemauq.modelo;

public class SolicitudRecarga {
    private final String id = GeneradorId.siguiente("SOL");
    private final Cliente cliente; private final double monto; private boolean atendida;

    public SolicitudRecarga(Cliente cliente, double monto) {
        this.cliente = cliente;
        this.monto = monto;
    }
    public String getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public double getMonto() { return monto; }
    public boolean isAtendida() { return atendida; }
    public void marcarAtendida() { atendida = true; }
    @Override public String toString() { return cliente.getNombre() + " solicita $" + monto; }
}
