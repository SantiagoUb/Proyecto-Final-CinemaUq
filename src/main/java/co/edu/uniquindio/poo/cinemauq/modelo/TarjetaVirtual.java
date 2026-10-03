package co.edu.uniquindio.poo.cinemauq.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TarjetaVirtual {
    private final String id = GeneradorId.siguiente("[TARJETA]");
    private double saldo;
    private EstadoTarjeta estado = EstadoTarjeta.ACTIVA;
    private final List<MovimientoTarjeta> movimientos = new ArrayList<>();

    public synchronized void verificarPago(double monto){
        if(estado != EstadoTarjeta.ACTIVA) throw new IllegalArgumentException("Verifique que la tarjeta este activa");
        if(saldo < monto) throw new IllegalArgumentException("saldo insuficiente");
    }

    public synchronized void pagar(double monto, String descripcion, LocalDateTime fecha){
        verificarPago(monto);
        saldo -= monto;
        registar(TipoMovimiento.COMPRA, monto, descripcion, fecha);
    }

    public synchronized void recargar(TipoMovimiento tipo,double monto, String descripcion, LocalDateTime fecha){
        if(monto <= 0) throw new IllegalArgumentException("el monto debe ser positivo");
        saldo += monto;
        registar(tipo, monto, descripcion, fecha);
    }

    public void registar(TipoMovimiento tipo, double monto, String descripcion, LocalDateTime fecha){
        movimientos.add(new MovimientoTarjeta(GeneradorId.siguiente("MOVM"), fecha, tipo, monto, saldo, descripcion));
    }

    public String getId() {
        return id;
    }
    public double getSaldo() {
        return saldo;
    }
    public EstadoTarjeta getEstado() {
        return estado;
    }
    public void setEstado(EstadoTarjeta estado) {
        this.estado = estado;
    }

    public synchronized List<MovimientoTarjeta> getMovimientos() {
        return List.copyOf(movimientos);
    }
}
