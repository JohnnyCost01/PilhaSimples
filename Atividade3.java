/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

public class ListaLigada {

    static class No {
        int valor;
        No proximo;

        No(int valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }

    static No inicio = null;

    public static void main(String[] args) {
        simularLista();
    }

    public static void simularLista() {
        // Inserir 43 no início
        inserirNoInicio(43);

        // Inserir 89 no final
        inserirNoFinal(89);

        // Inserir 55 na posição 2
        inserirNaPosicao(55, 2);

        // Consultar início
        if (inicio != null) {
            System.out.println("Início: " + inicio.valor);
        } else {
            System.out.println("Lista vazia.");
        }

        // Consultar fim
        if (inicio == null) {
            System.out.println("Lista vazia.");
        } else {
            No atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            System.out.println("Fim: " + atual.valor);
        }

        // Mostrar a lista
        mostrarLista();

        // Remover os valores: 55, 43, 7, 89 (nesta ordem)
        remover(55);
        remover(43);
        remover(7);
        remover(89);
    }

    public static void inserirNoInicio(int valor) {
        No novo = new No(valor);
        novo.proximo = inicio;
        inicio = novo;
    }

    public static void inserirNoFinal(int valor) {
        No novo = new No(valor);
        if (inicio == null) {
            inicio = novo;
        } else {
            No atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novo;
        }
    }

    public static void inserirNaPosicao(int valor, int posicao) {
        if (posicao <= 1 || inicio == null) {
            inserirNoInicio(valor);
            return;
        }

        No novo = new No(valor);
        No atual = inicio;
        int indice = 1;

        while (atual != null && indice < posicao - 1) {
            atual = atual.proximo;
            indice++;
        }

        if (atual == null) {
            inserirNoFinal(valor);
        } else {
            novo.proximo = atual.proximo;
            atual.proximo = novo;
        }
    }

    public static void mostrarLista() {
        if (inicio == null) {
            System.out.println("Lista vazia.");
            return;
        }

        No atual = inicio;
        System.out.print("Lista: ");
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }

    public static void remover(int valor) {
        if (inicio == null) {
            System.out.println("Lista vazia.");
            return;
        }

        // Se o valor estiver no início
        if (inicio.valor == valor) {
            inicio = inicio.proximo;
            return;
        }

        No atual = inicio;
        while (atual.proximo != null && atual.proximo.valor != valor) {
            atual = atual.proximo;
        }

        if (atual.proximo == null) {
            System.out.println("Elemento não existe na lista ligada.");
        } else {
            atual.proximo = atual.proximo.proximo;
        }
    }
}

