package co.edu.uniquindio.poo.cinemauq.modelo;

public class Administrador extends Usuario{
    public Administrador(String nombre, String correo, String claveHash) { super("ADM", nombre, correo, claveHash); }
    @Override
    public Rol getRol() { return Rol.ADMINISTRADOR; }
}
