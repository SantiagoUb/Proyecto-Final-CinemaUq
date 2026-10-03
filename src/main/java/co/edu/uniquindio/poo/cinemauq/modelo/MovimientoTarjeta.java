package co.edu.uniquindio.poo.cinemauq.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record MovimientoTarjeta(String id, LocalDateTime fecha, TipoMovimiento tipo, double monto, double saldoRestante,
                                String descripcion) { }
