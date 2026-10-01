package com.faculdade.sensor;

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
