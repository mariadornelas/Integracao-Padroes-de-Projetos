package com.faculdade.sensor;

/**
 * Concrete Factory + Concrete Creator da família "Externo": implementa os
 * dois factory methods herdados de {@link FabricaSensores} devolvendo
 * sempre produtos da família Externo, mantendo a consistência que o
 * Abstract Factory exige.
 */
public class FabricaSensoresExterno extends FabricaSensores {

    @Override
    public SensorTemperatura criarSensorTemperatura() {
        return new SensorTemperaturaExterno();
    }

    @Override
    public SensorPressao criarSensorPressao() {
        return new SensorPressaoExterno();
    }
}
