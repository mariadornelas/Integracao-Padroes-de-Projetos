package com.faculdade.sensor;

/** Concrete Product A2 — ambiente exposto ao tempo, mais tolerante. */
public class SensorTemperaturaExterno implements SensorTemperatura {

    private static final double LIMITE_ALERTA = 80.0;
    private static final double LIMITE_CRITICO = 100.0;

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
