package com.faculdade.sensor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SensorTemperaturaExternoTest {

    private final SensorTemperatura sensor = new SensorTemperaturaExterno();

    @Test
    void deveClassificarComoNormalAbaixoDoLimiteDeAlerta() {
        assertEquals("NORMAL", sensor.ler(70.0));
    }

    @Test
    void deveClassificarComoAlertaEntreOsLimites() {
        assertEquals("ALERTA", sensor.ler(85.0));
    }

    @Test
    void deveClassificarComoCriticoAcimaDoLimiteCritico() {
        assertEquals("CRITICO", sensor.ler(105.0));
    }

    @Test
    void limiaresDevemSerMaisTolerantesQueOsDaFamiliaInterno() {
        SensorTemperatura interno = new SensorTemperaturaInterno();
        double valorIntermediario = 75.0;

        assertTrue(sensor.ler(valorIntermediario).equals("NORMAL"));
        assertTrue(!interno.ler(valorIntermediario).equals("NORMAL"));
    }
}
