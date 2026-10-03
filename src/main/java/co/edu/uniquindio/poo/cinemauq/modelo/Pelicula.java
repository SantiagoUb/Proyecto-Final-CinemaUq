package co.edu.uniquindio.poo.cinemauq.modelo;

public class Pelicula {
    private final String id = GeneradorId.siguiente("[PEL]");
    private final String titulo;
    private final int duracion;
    private final String clasificacion;
    private final String genero;
    private boolean enCartelera = true;

    public Pelicula(String titulo, int duracion, String clasificacion, String genero) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.clasificacion = clasificacion;
        this.genero = genero;
    }

    public String getId() { return id; }
    public String getTitulo() { return titulo; }
    public int getDuracionMin() { return duracion; }
    public String getClasificacion() { return clasificacion; }
    public String getGenero() { return genero; }
    public boolean isEnCartelera() { return enCartelera; }
    public void setEnCartelera(boolean v) { this.enCartelera = v; }
    @Override public String toString() { return titulo; }
}
