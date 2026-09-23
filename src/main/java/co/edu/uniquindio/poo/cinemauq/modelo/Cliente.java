package co.edu.uniquindio.poo.cinemauq.modelo;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private final String id;
    private String nombre;
    private String correo;
    private String contrasena;

    private TipoCliente tipoCliente;

    private TarjetaVirtual targetaVirtual;
    private List<Compra> compras;
    private CuentaPuntos cuentaPuntos;

    public Cliente(String id, String nombre, String correo, String contrasena, TipoCliente tipoCliente) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.tipoCliente = tipoCliente;
        this.compras = new ArrayList<>();
        this.cuentaPuntos = new CuentaPuntos();
    }

    public void agregarCompra(Compra compra){
        compras.add(compra);
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public TarjetaVirtual getTargetaVirtual() {
        return targetaVirtual;
    }

    public void setTargetaVirtual(TarjetaVirtual targetaVirtual) {
        this.targetaVirtual = targetaVirtual;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public CuentaPuntos getCuentaPuntos() {
        return cuentaPuntos;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }
}
