package codigos;
public class Prontuario {
    private int idProntuario;
    private Paciente paciente;
    private ListaSimples listaSintomas;
    private ListaSimples listaMedicamentos;
    private String diagnostico;
    private String observacoes;
    
    public Prontuario(int idProntuario, Paciente paciente) {
        this.idProntuario = idProntuario;
        this.paciente = paciente;
        this.listaSintomas = new ListaSimples();
        listaMedicamentos = new ListaSimples();
        this.diagnostico = "Aguardando atendimento";
        this.observacoes = "";
    }

    public void adicionarSintomas(String sintoma){
        listaSintomas.adicionar(sintoma);
    }

    public void adicionarMedicamento(String medicamento){
        listaMedicamentos.adicionar(medicamento);
    }

    public void registrarDiagnostico(String diagnostico, String obs){
        this.diagnostico = diagnostico;
        this.observacoes = obs;
    }

    public void exibirProntuario() {
        System.out.println("=== PRONTUÁRIO Nº " + idProntuario + " ===");
        System.out.println("Paciente: " + paciente.getNome());
        System.out.print("Sintomas: ");
        listaSintomas.exibir();
        System.out.print("Medicamentos: ");
        listaMedicamentos.exibir();
        System.out.println("Diagnóstico: " + diagnostico);
        System.out.println("Observações: " + observacoes);
        System.out.println("===============================");
    }

    


}
