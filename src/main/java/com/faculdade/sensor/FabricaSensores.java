package com.faculdade.sensor;

/**
 * Esta classe é o ponto onde dois padrões se encontram:
 *
 * <p><b>Abstract Factory</b>: {@code FabricaSensores} é a fábrica abstrata
 * que garante que os sensores de temperatura e pressão produzidos juntos
 * pertençam sempre à mesma família (Interno ou Externo) — nunca um
 * {@code SensorTemperaturaInterno} misturado com um
 * {@code SensorPressaoExterno}.</p>
 *
 * <p><b>Factory Method</b>: ela não implementa a criação dos produtos
 * diretamente. Cada método de criação ({@link #criarSensorTemperatura()} e
 * {@link #criarSensorPressao()}) é declarado abstrato aqui e só é
 * implementado nas subclasses concretas ({@link FabricaSensoresInterno},
 * {@link FabricaSensoresExterno}) — esse é o Factory Method clássico: a
 * classe-base decide QUE um produto será criado, a subclasse decide QUAL
 * produto exatamente.</p>
 *
 * <p>O método {@link #diagnosticar(double, double)} é concreto e já usa os
 * dois factory methods internamente, sem nunca saber se está falando com a
 * família Interno ou Externo — prova de que o código cliente (aqui, a
 * própria classe-base) depende apenas das abstrações.</p>
 */
public abstract class FabricaSensores {

    public abstract SensorTemperatura criarSensorTemperatura();

    public abstract SensorPressao criarSensorPressao();

    public final String diagnosticar(double valorTemperatura, double valorPressao) {
        String statusTemperatura = criarSensorTemperatura().ler(valorTemperatura);
        String statusPressao = criarSensorPressao().ler(valorPressao);
        return String.format(
                "Temperatura=%s (%.1f) | Pressao=%s (%.1f)",
                statusTemperatura, valorTemperatura, statusPressao, valorPressao);
    }
}
