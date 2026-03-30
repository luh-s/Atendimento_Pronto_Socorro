package codigos;

public class NoAtendimento {
    
    Atendimento atendimento;
    NoAtendimento proximo;
    NoAtendimento anterior;

    public NoAtendimento(Atendimento atendimento) {
        this.atendimento = atendimento;
        this.proximo = null;
        this.anterior = null;
    }

}

