package co.edu.uniquindio.poo.cinemauq.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class CompraBuilder {
    private Cliente cliente; private Funcion funcion; private Promocion promocion; private LocalDate fechaPromo;
    private MedioPago medioPago = MedioPago.TARJETA;
    private final List<String> asientos = new ArrayList<>();
    private final List<ItemCompra> items = new ArrayList<>();

    public CompraBuilder conCliente(Cliente c) { this.cliente = c; return this; }
    public CompraBuilder conMedioPago(MedioPago m) { this.medioPago = m; return this; }

    public CompraBuilder conEntradas(Funcion f, Collection<String> codigos) {
        if (new HashSet<>(codigos).size() != codigos.size()) throw new IllegalArgumentException("Asientos repetidos en la selección");
        this.funcion = f;
        for (String c : codigos) {
            asientos.add(c);
            items.add(new ItemCompra(TipoItem.ENTRADA, "Entrada " + f.getPelicula().getTitulo() + " - " + c, 1, f.getPrecio()));
        }
        return this;
    }
    public CompraBuilder agregarProducto(Producto p, int cantidad) {
        if (!p.isActivo()) throw new IllegalArgumentException("Producto no disponible: " + p.getNombre());
        items.add(new ItemCompra(TipoItem.PRODUCTO, p.getNombre(), cantidad, p.getPrecio())); return this;
    }
    public CompraBuilder agregarCombo(Combo c, int cantidad) {
        if (!c.isActivo()) throw new IllegalArgumentException("Combo no disponible: " + c.getNombre());
        items.add(new ItemCompra(TipoItem.COMBO, c.getNombre(), cantidad, c.getPrecio())); return this;
    }
    public CompraBuilder conPromocion(Promocion p, LocalDate hoy) { this.promocion = p; this.fechaPromo = hoy; return this; }

    public Compra build() {
        if (cliente == null) throw new IllegalArgumentException("La compra requiere un cliente");
        if (items.isEmpty()) throw new IllegalArgumentException("La compra no tiene ítems");
        if (items.stream().anyMatch(i -> i.cantidad() <= 0)) throw new IllegalArgumentException("Cantidad inválida");
        double subtotal = items.stream().mapToDouble(ItemCompra::subtotal).sum();
        double descuento = 0; Promocion aplicada = null;
        if (promocion != null && medioPago == MedioPago.TARJETA && promocion.vigente(fechaPromo)) {
            descuento = Math.round(subtotal * promocion.getPorcentaje()); aplicada = promocion;
        }
        return new Compra(cliente, funcion, asientos, items, aplicada, subtotal, descuento, medioPago);
    }
}
