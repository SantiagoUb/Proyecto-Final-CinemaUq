package co.edu.uniquindio.poo.cinemauq.modelo;

public abstract class Usuario {
    private final String id;
    private String nombre;
    private final String correo;
    private final String clave;

    protected Usuario(String id, String nombre, String correo, String clave) {
        this.id = GeneradorId.siguiente(id);
        this.nombre = nombre;
        this.correo = correo;
        this.clave = clave;
    }

    public abstract Rol getRol();

    public boolean claveCoincide(String hash) { return clave.equals(hash); }
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCorreo() { return correo; }

    @Override
    public String toString() {
        return "Usuario{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", clave='" + clave + '\'' +
                '}';
    }
}
