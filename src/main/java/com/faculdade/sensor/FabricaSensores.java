package com.faculdade.sensor;

public abstract class FabricaSensores {

    public abstract SensorTemperatura criarSensorTemperatura();

    public abstract SensorPressao criarSensorPressao();

    public final String diagnosticar(double valorTemperatura, double valorPressao) {
        String statusTemperatura = criarSensorTemperatura().ler(valorTemperatura);
        String statusPressao = criarSensorPressao().ler(valorPressao);
        return String.format(
                "Temperatura=%s (%.1f) | Pressao=%s (%.1f)",
                statusTemperatura, valorTemperatura, statusPressao, valorPressao);
    }
}
