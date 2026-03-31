package Estruturas.Listas;

import Modelos.Prontuario;

public class NoProntuarioDuplo {
    public Prontuario dado;
    public NoProntuarioDuplo anterior;
    public NoProntuarioDuplo proximo;

    public NoProntuarioDuplo(Prontuario dado) {
        this.dado = dado;
        this.anterior = null;
        this.proximo = null;
    }
}