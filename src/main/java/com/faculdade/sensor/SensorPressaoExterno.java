package com.faculdade.sensor;

public class SensorPressaoExterno implements SensorPressao {

    private static final double LIMITE_ALERTA = 10.0;
    private static final double LIMITE_CRITICO = 14.0;

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
