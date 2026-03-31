package codigos;

public class No_Fila {
    Paciente paciente;
    No_Fila proximo;
    
    public No_Fila(Paciente paciente) {
        this.paciente = paciente;
        this.proximo = null;
    }
}