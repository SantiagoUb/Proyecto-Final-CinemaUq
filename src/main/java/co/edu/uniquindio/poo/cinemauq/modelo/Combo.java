package co.edu.uniquindio.poo.cinemauq.modelo;

import java.util.ArrayList;
import java.util.List;

public class Combo {
    private final String id = GeneradorId.siguiente("[COMBO]");
    private String nombre;
    private final List<Producto> productos;
    private double descuento;
    private boolean activo = true;


    public Combo(String nombre, List<Producto> productos, double descuento) {
        this.nombre = nombre;
        this.productos = new ArrayList<>(productos);
        this.descuento = descuento;
    }

    public double getPrecio(){
        return Math.round(productos.stream().mapToDouble(Producto::getPrecio).sum() * (descuento / 100));
    }
    public String getNombre() {
        return nombre;
    }
    public String getId() {
        return id;
    }
    public List<Producto> getProductos() {
        return productos;
    }
    public double getDescuento() {
        return descuento;
    }
    public boolean isActivo() {
        return activo;
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Combo{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", productos=" + productos +
                ", descuento=" + descuento +
                ", activo=" + activo +
                '}';
    }
}
