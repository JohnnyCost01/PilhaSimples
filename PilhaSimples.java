/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class PilhaSimples {

    public static void main(String[] args) {
        simularPilha();
    }

    public static void simularPilha() {
        int capacidade = 3;
        int[] pilha = new int[capacidade];
        AtomicInteger topo = new AtomicInteger(-1); // Wrapper mutável

        // Método auxiliar para empilhar
        Consumer<Integer> empilhar = (valor) -> {
            if (topo.get() >= capacidade - 1) {
                System.out.println("Pilha cheia!");
            } else {
                pilha[topo.incrementAndGet()] = valor;
            }
        };

        // Método auxiliar para desempilhar
        Runnable desempilhar = () -> {
            if (topo.get() < 0) {
                System.out.println("Pilha vazia!");
            } else {
                topo.decrementAndGet();
            }
        };

        // Método auxiliar para consultar o topo
        Runnable consultarTopo = () -> {
            if (topo.get() < 0) {
                System.out.println("Pilha vazia!");
            } else {
                System.out.println("Topo: " + pilha[topo.get()]);
            }
        };

        // Empilhar: 5, 8, 4, 7
        empilhar.accept(5);
        empilhar.accept(8);
        empilhar.accept(4);
        empilhar.accept(7); // deve exibir "Pilha cheia!"

        // Desempilhar duas vezes
        desempilhar.run();
        desempilhar.run();

        // Consultar o topo
        consultarTopo.run();

        // Desempilhar mais duas vezes
        desempilhar.run();
        desempilhar.run(); // deve exibir "Pilha vazia!"
    }
}

