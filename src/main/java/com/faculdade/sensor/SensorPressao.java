package com.faculdade.sensor;

/**
 * Abstract Product B da Abstract Factory: todo sensor de pressão,
 * de qualquer família (Interno ou Externo), sabe ler um valor e
 * devolver sua classificação.
 */
public interface SensorPressao {
    String ler(double valorMedido);
}
