public class ListaPacienteTemp {
    
    NoPacienteTemp head;

    public void inserir(Paciente paciente) {
        NoPacienteTemp novo = new NoPacienteTemp(paciente);
        novo.proximo = head;
        head = novo;
    }
    public void mostrar() {
        NoPacienteTemp atual = head;

        while (atual != null) {
            System.out.println(atual.dados.getNome());
            atual = atual.proximo;
        }
    }
}
