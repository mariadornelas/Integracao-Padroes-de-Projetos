package com.faculdade.sensor;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * Terceiro padrão da integração: <b>Singleton</b>.
 *
 * <p>É o único ponto de acesso do sistema às fábricas de sensores. Em vez
 * de o código cliente escrever {@code new FabricaSensoresInterno()} ou
 * {@code new FabricaSensoresExterno()} diretamente (o que o acoplaria às
 * classes concretas), ele pede ao gerenciador: {@code
 * GerenciadorSensores.getInstance().obterFabrica("Interno")}.</p>
 *
 * <p>Internamente, o gerenciador usa <b>Reflection</b> — a mesma técnica
 * já usada no projeto de Factory Method anterior — para localizar a classe
 * {@code FabricaSensores<ambiente>} a partir do nome do ambiente, sem um
 * {@code switch}/{@code if-else} para cada família existente. Cada fábrica
 * resolvida é guardada em cache: pedir a mesma família duas vezes devolve
 * sempre a MESMA instância de fábrica, evitando recriar objetos à toa.</p>
 */
public class GerenciadorSensores {

    private static final GerenciadorSensores INSTANCIA = new GerenciadorSensores();

    private final Map<String, FabricaSensores> fabricasEmCache = new HashMap<>();

    private GerenciadorSensores() {
        // construtor privado: ninguém fora desta classe pode instanciá-la.
    }

    public static GerenciadorSensores getInstance() {
        return INSTANCIA;
    }

    public FabricaSensores obterFabrica(String ambiente) {
        return fabricasEmCache.computeIfAbsent(ambiente, this::resolverFabricaPorReflexao);
    }

    public int quantidadeDeFabricasCarregadas() {
        return fabricasEmCache.size();
    }

    private FabricaSensores resolverFabricaPorReflexao(String ambiente) {
        try {
            Class<?> classe = Class.forName("com.faculdade.sensor.FabricaSensores" + ambiente);
            Constructor<?> construtor = classe.getDeclaredConstructor();
            Object objeto = construtor.newInstance();
            if (!(objeto instanceof FabricaSensores)) {
                throw new IllegalArgumentException("ambiente inválido: " + ambiente);
            }
            return (FabricaSensores) objeto;
        } catch (ReflectiveOperationException ex) {
            throw new IllegalArgumentException("ambiente inexistente: " + ambiente, ex);
        }
    }
}
