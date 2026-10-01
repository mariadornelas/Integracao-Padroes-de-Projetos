package com.faculdade.sensor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GerenciadorSensoresTest {

    @Test
    void getInstanceDeveSempreDevolverAMesmaReferencia() {
        GerenciadorSensores instancia1 = GerenciadorSensores.getInstance();
        GerenciadorSensores instancia2 = GerenciadorSensores.getInstance();

        assertSame(instancia1, instancia2);
    }

    @Test
    void deveResolverAFabricaInternoPorReflexao() {
        FabricaSensores fabrica = GerenciadorSensores.getInstance().obterFabrica("Interno");

        assertInstanceOf(FabricaSensoresInterno.class, fabrica);
    }

    @Test
    void deveResolverAFabricaExternoPorReflexao() {
        FabricaSensores fabrica = GerenciadorSensores.getInstance().obterFabrica("Externo");

        assertInstanceOf(FabricaSensoresExterno.class, fabrica);
    }

    @Test
    void devePropagarErroParaUmAmbienteInexistente() {
        GerenciadorSensores gerenciador = GerenciadorSensores.getInstance();

        assertThrows(IllegalArgumentException.class, () -> gerenciador.obterFabrica("Subterraneo"));
    }

    @Test
    void mesmaFamiliaPedidaDuasVezesDeveReaproveitarAFabricaDoCache() {
        GerenciadorSensores gerenciador = GerenciadorSensores.getInstance();

        FabricaSensores primeiraChamada = gerenciador.obterFabrica("Interno");
        FabricaSensores segundaChamada = gerenciador.obterFabrica("Interno");

        assertSame(primeiraChamada, segundaChamada);
    }

    @Test
    void familiasDiferentesDevemProduzirFabricasDiferentes() {
        GerenciadorSensores gerenciador = GerenciadorSensores.getInstance();

        FabricaSensores interno = gerenciador.obterFabrica("Interno");
        FabricaSensores externo = gerenciador.obterFabrica("Externo");

        assertNotSame(interno, externo);
    }

    @Test
    void codigoClienteDeveFuncionarConhecendoApenasAsAbstracoes() {

        GerenciadorSensores gerenciador = GerenciadorSensores.getInstance();

        for (String ambiente : new String[] { "Interno", "Externo" }) {
            FabricaSensores fabrica = gerenciador.obterFabrica(ambiente);
            String diagnostico = assertDoesNotThrow(() -> fabrica.diagnosticar(50.0, 5.0));
            assertNotNull(diagnostico);
        }
    }
}
