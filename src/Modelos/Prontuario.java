package Modelos;

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
        this.listaMedicamentos = new ListaSimples();
        this.diagnostico = "Não informado";
        this.observacoes = "Nenhuma";
    }

    public int getIdProntuario() {
        return idProntuario;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public ListaSimples getListaSintomas() {
        return listaSintomas;
    }

    public ListaSimples getListaMedicamentos() {
        return listaMedicamentos;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void adicionarSintoma(String sintoma) {
        if (sintoma != null && !sintoma.trim().isEmpty()) {
            listaSintomas.adicionar(sintoma.trim());
        }
    }

    public void adicionarSintomas(String sintomas) {
        if (sintomas == null || sintomas.trim().isEmpty()) {
            return;
        }

        String[] partes = sintomas.split(",");
        for (String parte : partes) {
            adicionarSintoma(parte);
        }
    }

    public void adicionarMedicamento(String medicamento) {
        if (medicamento != null && !medicamento.trim().isEmpty()) {
            listaMedicamentos.adicionar(medicamento.trim());
        }
    }

    public void adicionarMedicamentos(String medicamentos) {
        if (medicamentos == null || medicamentos.trim().isEmpty()) {
            return;
        }

        String[] partes = medicamentos.split(",");
        for (String parte : partes) {
            adicionarMedicamento(parte);
        }
    }

    public void registrarDiagnostico(String diagnostico) {
        if (diagnostico == null || diagnostico.trim().isEmpty()) {
            this.diagnostico = "Não informado";
        } else {
            this.diagnostico = diagnostico.trim();
        }
    }

    public void setObservacoes(String observacoes) {
        if (observacoes == null || observacoes.trim().isEmpty()) {
            this.observacoes = "Nenhuma";
        } else {
            this.observacoes = observacoes.trim();
        }
    }

    public String exibirProntuario() {
        return "=== PRONTUÁRIO Nº " + idProntuario + " ===\n"
                + "Paciente: " + paciente.getNome() + "\n"
                + "ID: " + paciente.getId() + "\n"
                + "Idade: " + paciente.getIdade() + "\n"
                + "CPF: " + paciente.getCpf() + "\n"
                + "Prioridade: " + paciente.getPrioridade() + "\n\n"
                + "Sintomas:\n" + listaSintomas.listarTexto() + "\n"
                + "Medicamentos:\n" + listaMedicamentos.listarTexto() + "\n"
                + "Diagnóstico: " + diagnostico + "\n"
                + "Observações: " + observacoes + "\n"
                + "===============================\n";
    }
}