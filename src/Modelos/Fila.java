package Modelos;

public class Fila {
    private NoFila inicio;
    private NoFila fim;
    private int tamanho;

    public Fila() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    private int getPrioridadeNum(String prioridade) {
        if (prioridade == null) return 0;
        if (prioridade.equalsIgnoreCase("alta")) return 3;
        if (prioridade.equalsIgnoreCase("media")) return 2;
        if (prioridade.equalsIgnoreCase("baixa")) return 1;
        return 0;
    }

    public void enfileirar(Paciente paciente) {
        NoFila novoNo = new NoFila(paciente);

        if (inicio == null) {
            inicio = novoNo;
            fim = novoNo;
            tamanho++;
            return;
        }

        if (getPrioridadeNum(paciente.getPrioridade()) > getPrioridadeNum(inicio.paciente.getPrioridade())) {
            novoNo.proximo = inicio;
            inicio = novoNo;
            tamanho++;
            return;
        }

        NoFila atual = inicio;
        while (atual.proximo != null &&
               getPrioridadeNum(atual.proximo.paciente.getPrioridade()) >= getPrioridadeNum(paciente.getPrioridade())) {
            atual = atual.proximo;
        }

        novoNo.proximo = atual.proximo;
        atual.proximo = novoNo;

        if (novoNo.proximo == null) {
            fim = novoNo;
        }

        tamanho++;
    }

    public Paciente desenfileirar() {
        if (inicio == null) {
            return null;
        }

        Paciente removido = inicio.paciente;
        inicio = inicio.proximo;

        if (inicio == null) {
            fim = null;
        }

        tamanho--;
        return removido;
    }

    public boolean estaVazia() {
        return inicio == null;
    }

    public int getTamanho() {
        return tamanho;
    }

    public String exibirFilaTexto() {
        if (inicio == null) {
            return "Fila vazia.";
        }

        String texto = "";
        NoFila atual = inicio;
        int posicao = 1;

        while (atual != null) {
            Paciente p = atual.paciente;
            texto += posicao + "º - "
                    + p.getNome()
                    + " | Prioridade: " + p.getPrioridade()
                    + " | Status: " + p.getStatusAtendimento()
                    + "\n";
            atual = atual.proximo;
            posicao++;
        }

        return texto;
    }
}