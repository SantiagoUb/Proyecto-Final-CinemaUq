package co.edu.uniquindio.poo.cinemauq.modelo;

public class Pelicula {

    private int id;
    private String titulo;
    private String genero;
    private int duracion;
    private String clasificacion;
    private boolean disponible;

    public Pelicula(int id, String titulo, String genero,int duracion, String clasificacion, boolean disponible) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion;
        this.clasificacion = clasificacion;
        this.disponible = true;
    }

    public void activar(){
        disponible = true;
    }
    public void desactivar(){
        disponible = false;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getClasificacion() {
        return clasificacion;
    }
    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
}
