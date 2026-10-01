package com.faculdade.sensor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SensorPressaoExternoTest {

    private final SensorPressao sensor = new SensorPressaoExterno();

    @Test
    void deveClassificarComoNormalAbaixoDoLimiteDeAlerta() {
        assertEquals("NORMAL", sensor.ler(9.0));
    }

    @Test
    void deveClassificarComoAlertaEntreOsLimites() {
        assertEquals("ALERTA", sensor.ler(11.0));
    }

    @Test
    void deveClassificarComoCriticoAcimaDoLimiteCritico() {
        assertEquals("CRITICO", sensor.ler(15.0));
    }
}
