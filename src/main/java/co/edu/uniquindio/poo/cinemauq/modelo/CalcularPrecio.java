package co.edu.uniquindio.poo.cinemauq.modelo;

public class CalcularPrecio {

    private static final double PRECIO_BASE = 18000;
    private static final double ADICIONAL_3D = 6000;
    private static final double ADICIONAL_4DX = 12000;

    public  double calcularPrecio(Formato formato, TipoCliente tipoCliente) {
        double precio = calcularPrecioFormato(formato);
        double factor = tipoCliente.getFactorDescuento();
        return precio * factor;
    }

    private double calcularPrecioFormato(Formato formato) {
        switch (formato) {
            case FORMATO_2D:
                return PRECIO_BASE;

            case FORMATO_3D:
                return PRECIO_BASE + ADICIONAL_3D;

            case FORMATO_4DX:
                return PRECIO_BASE + ADICIONAL_4DX;

            default:
                throw new IllegalArgumentException("Formato de entrada no valido");
        }
    }
}
