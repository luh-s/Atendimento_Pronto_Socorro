package Estruturas.Listas;

import Modelos.Prontuario;

public class ListaProntuarios {
    private NoProntuarioDuplo inicio;
    private NoProntuarioDuplo fim;

    public void adicionar(Prontuario prontuario) {
        NoProntuarioDuplo novo = new NoProntuarioDuplo(prontuario);

        if (inicio == null) {
            inicio = novo;
            fim = novo;
        } else {
            fim.proximo = novo;
            novo.anterior = fim;
            fim = novo;
        }
    }

    public NoProntuarioDuplo getInicio() {
        return inicio;
    }

    public NoProntuarioDuplo getFim() {
        return fim;
    }

    public boolean estaVazia() {
        return inicio == null;
    }
}