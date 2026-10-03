package co.edu.uniquindio.poo.cinemauq.modelo;

public record ItemCompra(TipoItem tipo, String descripcion, int cantidad, double precioUnitario) {

    public double subtotal() { return cantidad * precioUnitario; }
}
