package co.edu.uniquindio.poo.cinemauq.modelo;

import java.util.ArrayList;
import java.util.List;

public class TarjetaVirtual {

    private final String  numero;
    private double saldo;
    private boolean activa;

    private List<Movimiento> movimientos;

    public TarjetaVirtual(String numero) {
        this.numero = numero;
        this.saldo = 0;
        this.activa = true;
        this.movimientos = new ArrayList<>();
    }

    // Metodos de la targeta virtual
    /*
     * Realiza una recarga en la tarjeta.
     * La recarga aumenta el saldo y registra el movimiento.
     */

    public boolean recargar(double monto, int idMovimiento) {
        //Una tarjeta inactiva no puede recibir operaciones
        if(!activa){
            return false;
        }

        //No se permiten recargas de cero o de valores negativos
        if(monto <= 0){
            return false;
        }
        //Aumenta saldo
        saldo += monto;
        //Registramos la operacion
        Movimiento movimiento = new Movimiento(idMovimiento,
                TipoMovimiento.RECARGA,
                monto,
                "Recarga de tarjeta");

        movimientos.add(movimiento);

        return true;

    }

    /*
     * Realiza un pago utilizando el saldo disponible.
     * Verifica que la tarjeta esté activa y tenga suficiente saldo.
     */
    public boolean realizarPago(double monto, int idMovimiento) {

        // La tarjeta debe estar activa.
        if (!activa) {
            return false;
        }

        // El monto debe ser positivo.
        if (monto <= 0) {
            return false;
        }

        // Verificamos que haya suficiente saldo.
        if (monto > saldo) {
            return false;
        }

        // Descontamos el valor del pago.
        saldo -= monto;

        // Registramos el movimiento.
        Movimiento movimiento = new Movimiento(
                idMovimiento,
                TipoMovimiento.PAGO,
                monto,
                "Pago de compra"
        );

        movimientos.add(movimiento);

        return true;
    }

    /*
     * Devuelve dinero a la tarjeta cuando corresponde un reembolso.
     */
    public boolean recibirReembolso(double monto, int idMovimiento) {

        // La tarjeta debe estar activa.
        if (!activa) {
            return false;
        }

        // El reembolso debe ser positivo.
        if (monto <= 0) {
            return false;
        }

        // Aumentamos el saldo.
        saldo += monto;

        // Registramos el movimiento.
        Movimiento movimiento = new Movimiento(
                idMovimiento,
                TipoMovimiento.REEMBOLSO,
                monto,
                "Reembolso de compra"
        );

        movimientos.add(movimiento);

        return true;
    }

    /*
     * Desactiva la tarjeta.
     */
    public void desactivar() {
        activa = false;
    }

    /*
     * Activa nuevamente la tarjeta.
     */
    public void activar() {
        activa = true;
    }

    // Getters
    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean isActiva() {
        return activa;
    }
    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

}
