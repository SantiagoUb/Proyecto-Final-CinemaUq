package co.edu.uniquindio.poo.cinemauq.modelo.reembolso;

import co.edu.uniquindio.poo.cinemauq.modelo.ConfiguracionCine;

import java.time.Duration;

public class ProcesadorReembolsoCine extends ProcesadorReembolso{
    @Override
    protected PoliticaReembolso crearPolitica(Duration restante, boolean canceladaPorCine) {
        ConfiguracionCine cfg = ConfiguracionCine.obtener();
        if (canceladaPorCine) return new ReembolsoTotal();
        if (restante.compareTo(Duration.ofHours(cfg.getHorasReembolsoTotal())) > 0) return new ReembolsoTotal();
        if (restante.compareTo(Duration.ofHours(cfg.getHorasLimiteCancelacion())) >= 0)
            return new ReembolsoParcial(cfg.getPorcentajeReembolsoParcial());
        return new SinReembolso();
    }
}
