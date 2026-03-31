package Modelos;

public class PilhaHistorico {

    private static class NoAtendimento {
        Atendimento dado;
        NoAtendimento proximo;

        NoAtendimento(Atendimento dado) {
            this.dado = dado;
            this.proximo = null;
        }
    }

    private NoAtendimento topo;

    public void push(Atendimento atendimento) {
        NoAtendimento novo = new NoAtendimento(atendimento);
        novo.proximo = topo;
        topo = novo;
    }

    public Atendimento pop() {
        if (topo == null) {
            return null;
        }

        Atendimento atendimento = topo.dado;
        topo = topo.proximo;
        return atendimento;
    }

    public Atendimento peek() {
        if (topo == null) {
            return null;
        }
        return topo.dado;
    }

    public boolean estaVazia() {
        return topo == null;
    }

    public String listar() {
        if (topo == null) {
            return "Nenhum atendimento finalizado.";
        }

        StringBuilder texto = new StringBuilder();
        NoAtendimento atual = topo;
        int posicao = 1;

        while (atual != null) {
            Atendimento atendimento = atual.dado;
            texto.append(posicao)
                 .append("º atendimento finalizado\n")
                 .append(atendimento.exibirResumo())
                 .append("\n-----------------------------\n");
            atual = atual.proximo;
            posicao++;
        }

        return texto.toString();
    }
}