package codigos;

public class ListaDuplaAtendimento {

    private NoAtendimento inicio;
    private NoAtendimento fim;
    private NoAtendimento atual;

    public void adicionarAtendimento(Atendimento atendimento) {

        NoAtendimento novo = new NoAtendimento(atendimento);

        if (inicio == null) {
            inicio = novo;
            fim = novo;
            atual = novo;
        } else {
            fim.proximo = novo;
            novo.anterior = fim;
            fim = novo;
        }
    }

    public Atendimento proximo() {

        if (atual != null && atual.proximo != null) {
            atual = atual.proximo;
        }

        return atual.atendimento;
    }

    public Atendimento anterior() {

        if (atual != null && atual.anterior != null) {
            atual = atual.anterior;
        }

        return atual.atendimento;
    }

    public Atendimento getAtual() {

        if (atual == null) {
            return null;
        }

        return atual.atendimento;
    }

    public void mostrarTodos() {

        NoAtendimento aux = inicio;

        while (aux != null) {
            System.out.println(aux.atendimento.getIdAtendimento());
            aux = aux.proximo;
        }
    }
}
