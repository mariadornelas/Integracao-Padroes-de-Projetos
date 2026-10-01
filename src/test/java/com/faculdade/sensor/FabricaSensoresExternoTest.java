package com.faculdade.sensor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FabricaSensoresExternoTest {

    private final FabricaSensores fabrica = new FabricaSensoresExterno();

    @Test
    void deveCriarSensorDeTemperaturaDaFamiliaExterno() {
        assertInstanceOf(SensorTemperaturaExterno.class, fabrica.criarSensorTemperatura());
    }

    @Test
    void deveCriarSensorDePressaoDaFamiliaExterno() {
        assertInstanceOf(SensorPressaoExterno.class, fabrica.criarSensorPressao());
    }

    @Test
    void diagnosticoDeveUsarOsDoisFactoryMethodsInternamente() {
        String diagnostico = fabrica.diagnosticar(105.0, 15.0);

        assertTrue(diagnostico.contains("CRITICO"));
    }
}
