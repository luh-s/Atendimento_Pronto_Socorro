package codigos;
public class Fila {
    private No_Fila inicio;
    private No_Fila fim;
    private int tamanho;

    public Fila() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

     private int getPrioridadeNum(String prioridade) {
        if (prioridade.equalsIgnoreCase("alta")) return 3;
        if (prioridade.equalsIgnoreCase("media")) return 2;
        if (prioridade.equalsIgnoreCase("baixa")) return 1;
        return 0; 
    }

    public void enfileirar(Paciente paciente) {
        No_Fila novoNo = new No_Fila(paciente);
        if (fim == null || getPrioridadeNum(paciente.getPrioridade()) > getPrioridadeNum(fim.paciente.getPrioridade())) {
            inicio = novoNo;
            fim = novoNo;
        } else {
            No_Fila atual = inicio;
            while (atual.proximo != null && getPrioridadeNum(atual.proximo.paciente.getPrioridade()) >= getPrioridadeNum(paciente.getPrioridade())) {
                atual = atual.proximo;
            }
            novoNo.proximo = atual.proximo;
            atual.proximo = novoNo;
            if (novoNo.proximo == null) {
                fim = novoNo; 
            }          
        }
        tamanho++;
    }

    public Paciente desenfileirar() {
        if (inicio == null) {
            return null;
        }
        Paciente pacienteDesenfileirado = inicio.paciente;
        inicio = inicio.proximo;
        if (inicio == null) {
            fim = null; 
        }
        tamanho--;
        return pacienteDesenfileirado;
    }

    public void exibirFila() {
        No_Fila atual = inicio;
        System.out.print("Fila: ");
        while (atual != null) {
            System.out.print(atual.paciente + " -> ");
            atual = atual.proximo;
        }
        System.out.println("null");
    }

}
