package com.faculdade.sensor;

/**
 * Concrete Factory + Concrete Creator da família "Interno": implementa os
 * dois factory methods herdados de {@link FabricaSensores} devolvendo
 * sempre produtos da família Interno, mantendo a consistência que o
 * Abstract Factory exige.
 */
public class FabricaSensoresInterno extends FabricaSensores {

    @Override
    public SensorTemperatura criarSensorTemperatura() {
        return new SensorTemperaturaInterno();
    }

    @Override
    public SensorPressao criarSensorPressao() {
        return new SensorPressaoInterno();
    }
}
