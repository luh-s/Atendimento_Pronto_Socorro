package codigos;

public class PilhaAtendimento {

    private NoAtendimento topo;

    public void push(Atendimento atendimento) {
        NoAtendimento novo = new NoAtendimento(atendimento);
        novo.proximo = topo;
        topo = novo;
    }

    public Atendimento pop() {
        if (topo == null) {
            System.out.println("Nenhum atendimento no histórico.");
            return null;
        }
        Atendimento atendimento = topo.atendimento;
        topo = topo.proximo;
        return atendimento;
    }

    public Atendimento peek() {
        if (topo == null) {
            System.out.println("Nenhum atendimento realizado.");
            return null;
        }
        return topo.atendimento;
    }

    public void mostrarHistorico() {
        NoAtendimento atual = topo;
        while (atual != null) {
            System.out.println(atual.atendimento.getIdAtendimento());
            atual = atual.proximo;
        }
    }

}
