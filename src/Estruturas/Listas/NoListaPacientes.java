package Estruturas.Listas;
import Modelos.*;

public class NoListaPacientes {
    public Paciente dados;
    public NoListaPacientes proximo = null;

    public NoListaPacientes(Paciente paciente){
        this.dados = paciente;
        this.proximo = null;
    }

}
