package com.faculdade.sensor;

/** Concrete Product A1 — ambiente controlado, limiares mais apertados. */
public class SensorTemperaturaInterno implements SensorTemperatura {

    private static final double LIMITE_ALERTA = 60.0;
    private static final double LIMITE_CRITICO = 80.0;

    @Override
    public String ler(double valorMedido) {
        if (valorMedido >= LIMITE_CRITICO) {
            return "CRITICO";
        }
        if (valorMedido >= LIMITE_ALERTA) {
            return "ALERTA";
        }
        return "NORMAL";
    }
}
