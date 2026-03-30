public class NoPacienteTemp {
    Paciente dados;
    NoPacienteTemp proximo = null;

    public NoPacienteTemp(Paciente paciente){
        this.dados = paciente;
        this.proximo = null;
    }
}
