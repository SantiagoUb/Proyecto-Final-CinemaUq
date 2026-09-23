package co.edu.uniquindio.poo.cinemauq.modelo;

public enum TipoCliente {
    GENERAL(1.00),
    ESTUDIANTE(0.80),
    TERCERA_EDAD(0.70),
    CONVENIO_UQ(0.50);

    private double factorDescuento;

    TipoCliente(double factorDescuento) {
        this.factorDescuento = factorDescuento;
    }

    public double getFactorDescuento() {
        return factorDescuento;
    }
}
