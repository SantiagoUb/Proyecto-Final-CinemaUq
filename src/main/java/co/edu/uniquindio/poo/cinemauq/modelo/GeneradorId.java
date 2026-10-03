package co.edu.uniquindio.poo.cinemauq.modelo;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class GeneradorId {

    private static final AtomicLong CONTADOR = new AtomicLong();

    private GeneradorId() {}

    public static String siguiente(String prefijo) {
        return String.format("%d", CONTADOR.incrementAndGet());
    }
}
