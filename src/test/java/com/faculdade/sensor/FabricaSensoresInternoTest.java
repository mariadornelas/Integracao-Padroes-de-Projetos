package com.faculdade.sensor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FabricaSensoresInternoTest {

    private final FabricaSensores fabrica = new FabricaSensoresInterno();

    @Test
    void deveCriarSensorDeTemperaturaDaFamiliaInterno() {
        assertInstanceOf(SensorTemperaturaInterno.class, fabrica.criarSensorTemperatura());
    }

    @Test
    void deveCriarSensorDePressaoDaFamiliaInterno() {
        assertInstanceOf(SensorPressaoInterno.class, fabrica.criarSensorPressao());
    }

    @Test
    void diagnosticoDeveUsarOsDoisFactoryMethodsInternamente() {
        String diagnostico = fabrica.diagnosticar(50.0, 5.0);

        assertTrue(diagnostico.contains("NORMAL"));
    }
}
