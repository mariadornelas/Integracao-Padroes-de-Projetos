package com.faculdade.sensor;

public class App {

    public static void main(String[] args) {
        GerenciadorSensores gerenciador = GerenciadorSensores.getInstance();

        FabricaSensores fabricaInterno = gerenciador.obterFabrica("Interno");
        FabricaSensores fabricaExterno = gerenciador.obterFabrica("Externo");

        System.out.println("=== Ambiente Interno ===");
        System.out.println(fabricaInterno.diagnosticar(50.0, 5.0));
        System.out.println(fabricaInterno.diagnosticar(95.0, 11.0));

        System.out.println();
        System.out.println("=== Ambiente Externo ===");
        System.out.println(fabricaExterno.diagnosticar(70.0, 9.0));
        System.out.println(fabricaExterno.diagnosticar(105.0, 15.0));

        System.out.println();
        FabricaSensores fabricaInternoNovamente = gerenciador.obterFabrica("Interno");
        System.out.println("Mesma instância de fábrica reaproveitada do cache? "
                + (fabricaInterno == fabricaInternoNovamente));
        System.out.println("Fábricas distintas carregadas no gerenciador: "
                + gerenciador.quantidadeDeFabricasCarregadas());

        System.out.println();
        GerenciadorSensores outraReferencia = GerenciadorSensores.getInstance();
        System.out.println("GerenciadorSensores é mesmo um Singleton? "
                + (gerenciador == outraReferencia));
    }
}
