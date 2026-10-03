package co.edu.uniquindio.poo.cinemauq.modelo;

public class Cliente extends Usuario{
    private final TarjetaVirtual tarjeta = new TarjetaVirtual();
    private final CuentaPuntos puntos = new CuentaPuntos();


    public Cliente(String nombre, String correo, String clave) {
        super("CLI", nombre, correo, clave); }
    @Override
    public Rol getRol() { return Rol.CLIENTE; }
    public TarjetaVirtual getTarjeta() { return tarjeta; }
    public CuentaPuntos getPuntos() { return puntos; }
}
