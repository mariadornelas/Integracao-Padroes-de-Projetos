package com.faculdade.sensor;

/**
 * Abstract Product A da Abstract Factory: todo sensor de temperatura,
 * de qualquer família (Interno ou Externo), sabe ler um valor e
 * devolver sua classificação.
 */
public interface SensorTemperatura {
    String ler(double valorMedido);
}
