package com.faculdade.sensor;

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
