package co.edu.uniquindio.poo.cinemauq.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CuentaPuntos {

    private final List<LotePuntos> lotes = new ArrayList<LotePuntos>();

    public synchronized void agregar(String compraId, int puntos, LocalDateTime ahora, int vigenciaAnios) {
        if(puntos > 0) lotes.add(new LotePuntos(compraId, puntos, ahora, vigenciaAnios));
    }

    public synchronized int disponibles(LocalDateTime ahora) {
        return lotes.stream()
                .filter(l -> !l.vencido(ahora)).mapToInt(LotePuntos::getRestantes).sum();
    }

    public synchronized void consumir(int puntos, LocalDateTime ahora) {
        if (disponibles(ahora) < puntos)
            throw new IllegalArgumentException("Puntos insuficientes (o vencidos): disponibles");
        int falta = puntos;
        List<LotePuntos> orden = new ArrayList<>(lotes);
        orden.sort(Comparator.comparing(LotePuntos::getFechaVencimiento));
        for (LotePuntos l : orden) {
            if (falta == 0) break;
            if (l.vencido(ahora) || l.getRestantes() == 0) continue;
            int t = Math.min(falta, l.getRestantes());
            l.consumir(t); falta -= t;
        }
    }


    // Elimina los puntos generados por una compra que fue reembolsada
    public synchronized void revocar(String compraId) {
        lotes.removeIf(l -> l.getCompraId().equals(compraId)); }

    public synchronized List<LotePuntos> getLotes() { return List.copyOf(lotes); }
}
