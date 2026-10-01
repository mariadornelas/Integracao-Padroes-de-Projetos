package com.faculdade.sensor;

/** Concrete Product B1 — ambiente controlado, limiares mais apertados. */
public class SensorPressaoInterno implements SensorPressao {

    private static final double LIMITE_ALERTA = 6.0;
    private static final double LIMITE_CRITICO = 10.0;

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
