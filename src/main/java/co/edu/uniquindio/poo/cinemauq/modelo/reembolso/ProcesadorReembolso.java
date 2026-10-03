package co.edu.uniquindio.poo.cinemauq.modelo.reembolso;

import java.time.Duration;

public abstract  class ProcesadorReembolso {
    protected abstract PoliticaReembolso crearPolitica(Duration tiempoRestante, boolean canceladaPorCine);

    public final double calcularReembolso(double total, Duration tiempoRestante, boolean canceladaPorCine) {
        PoliticaReembolso politica = crearPolitica(tiempoRestante, canceladaPorCine);
        if (!politica.permiteCancelar())
            throw new IllegalArgumentException("No se permite cancelar: " + politica.descripcion());
        return Math.round(total * politica.porcentaje());
    }

}
