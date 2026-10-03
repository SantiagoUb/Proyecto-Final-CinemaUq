package co.edu.uniquindio.poo.cinemauq.modelo;

import java.time.LocalDateTime;
import java.util.List;

public class Compra {
    private final String id = GeneradorId.siguiente("CMP");
    private final Cliente cliente;
    private final Funcion funcion;                 // null si solo es confitería
    private final List<String> asientos;
    private final List<ItemCompra> items;
    private final Promocion promocion;
    private final double subtotal, descuento;
    private final MedioPago medioPago;
    private EstadoCompra estado = EstadoCompra.PENDIENTE;
    private LocalDateTime fecha;
    private TarjetaVirtual tarjetaUsada;
    private int puntosUsados;
    private boolean reembolsada;
    private double montoReembolsado;

    public Compra(Cliente cliente, Funcion funcion, List<String> asientos, List<ItemCompra> items,
                  Promocion promocion, double subtotal, double descuento, MedioPago medioPago) {
        this.cliente = cliente;
        this.funcion = funcion;
        this.asientos = List.copyOf(asientos);
        this.items = List.copyOf(items);
        this.promocion = promocion;
        this.subtotal = subtotal;
        this.descuento = descuento;
        this.medioPago = medioPago;
    }

    public void marcarPagadaConTarjeta(TarjetaVirtual t, LocalDateTime fecha) {
        this.tarjetaUsada = t; this.fecha = fecha; this.estado = EstadoCompra.PAGADA;
    }
    public void marcarPagadaConPuntos(int puntos, LocalDateTime fecha) {
        this.puntosUsados = puntos; this.fecha = fecha; this.estado = EstadoCompra.PAGADA;
    }
    //Idempotencia del reembolso: la segunda llamada falla
    public synchronized void registrarReembolso(double monto) {
        if (reembolsada || estado != EstadoCompra.PAGADA) throw new IllegalArgumentException("Esta compra ya fue reembolsada/cancelada");
        reembolsada = true; montoReembolsado = monto; estado = EstadoCompra.CANCELADA;
    }

    public double getTotal() { return subtotal - descuento; }
    public String getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public Funcion getFuncion() { return funcion; }
    public List<String> getAsientos() { return asientos; }
    public List<ItemCompra> getItems() { return items; }
    public Promocion getPromocion() { return promocion; }
    public double getSubtotal() { return subtotal; }
    public double getDescuento() { return descuento; }
    public MedioPago getMedioPago() { return medioPago; }
    public EstadoCompra getEstado() { return estado; }
    public LocalDateTime getFecha() { return fecha; }
    public TarjetaVirtual getTarjetaUsada() { return tarjetaUsada; }
    public int getPuntosUsados() { return puntosUsados; }
    public boolean isReembolsada() { return reembolsada; }
    public double getMontoReembolsado() { return montoReembolsado; }
    @Override public String toString() { return id + " " + estado + " $" + getTotal() + " (" + medioPago + ")"; }
}
