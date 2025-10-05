/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
class BIntNo {
    int valor;
    BIntNo esq, dir;

    BIntNo(int valor) {
        this.valor = valor;
        this.esq = null;
        this.dir = null;
    }
}

class ArvoreBinaria {
    private BIntNo raiz;

    public void inserirNo(int valor) {
        raiz = inserir(raiz, valor);
    }

    private BIntNo inserir(BIntNo no, int valor) {
        if (no == null) return new BIntNo(valor);
        if (valor < no.valor) no.esq = inserir(no.esq, valor);
        else no.dir = inserir(no.dir, valor);
        return no;
    }

    public void exibirEmOrdem() {
        exibirEmOrdem(raiz);
    }

    private void exibirEmOrdem(BIntNo no) {
        if (no != null) {
            exibirEmOrdem(no.esq);
            System.out.println(no.valor);
            exibirEmOrdem(no.dir);
        }
    }

    public void excluirNo(int valor) {
        raiz = excluir(raiz, valor);
    }

    private BIntNo excluir(BIntNo no, int valor) {
        if (no == null) return no;

        if (valor < no.valor) {
            no.esq = excluir(no.esq, valor);
        } else if (valor > no.valor) {
            no.dir = excluir(no.dir, valor);
        } else {
            // nó com apenas um filho ou nenhum
            if (no.esq == null) return no.dir;
            else if (no.dir == null) return no.esq;

            // nó com dois filhos: pega o menor da subárvore direita
            no.valor = menorValor(no.dir);
            no.dir = excluir(no.dir, no.valor);
        }

        return no;
    }

    private int menorValor(BIntNo no) {
        int min = no.valor;
        while (no.esq != null) {
            min = no.esq.valor;
            no = no.esq;
        }
        return min;
    }
}

public class TesteArvore {
    public static void main(String[] args) {
        simularArvore();
    }

    public static void simularArvore() {
        ArvoreBinaria arvore = new ArvoreBinaria();

        // Inserção de nós
        arvore.inserirNo(15);
        arvore.inserirNo(6);
        arvore.inserirNo(23);
        arvore.inserirNo(4);
        arvore.inserirNo(7);
        arvore.inserirNo(71);
        arvore.inserirNo(5);

        // Exibição em ordem antes da exclusão
        System.out.println("Árvore em ordem (antes da exclusão):");
        arvore.exibirEmOrdem();

        // Exclusão do nó com valor 6
        arvore.excluirNo(6);

        // Exibição em ordem após a exclusão
        System.out.println("Árvore em ordem (após a exclusão do 6):");
        arvore.exibirEmOrdem();
    }
}
