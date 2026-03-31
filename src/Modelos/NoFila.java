package Modelos;

public class NoFila{
    Paciente paciente;
    NoFila proximo;
    
    public NoFila(Paciente paciente) {
        this.paciente = paciente;
        this.proximo = null;
    }
}