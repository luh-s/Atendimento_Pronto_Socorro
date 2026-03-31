package Modelos;

import Estruturas.Listas.ListaPacientes;
import Estruturas.Listas.ListaProntuarios;
import Estruturas.Listas.NoProntuarioDuplo;

public class UnidadeAtendimento {
    private String nome;
    private String senha;
    private ListaPacientes pacientes;
    private Fila fila;
    private PilhaHistorico historico;
    private ListaProntuarios prontuarios;
    private NoProntuarioDuplo prontuarioAtual;
    private Atendimento atendimentoAtual;
    private int contadorAtendimentos;
    private int contadorProntuarios;
    private int proximoIdPaciente;

    public UnidadeAtendimento(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
        this.pacientes = new ListaPacientes();
        this.fila = new Fila();
        this.historico = new PilhaHistorico();
        this.prontuarios = new ListaProntuarios();
        this.prontuarioAtual = null;
        this.atendimentoAtual = null;
        this.contadorAtendimentos = 0;
        this.contadorProntuarios = 0;
        this.proximoIdPaciente = 1;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public ListaPacientes getPacientes() {
        return pacientes;
    }

    public Fila getFila() {
        return fila;
    }

    public PilhaHistorico getHistorico() {
        return historico;
    }

    public Atendimento getAtendimentoAtual() {
        return atendimentoAtual;
    }

    public Paciente getPacienteEmAtendimento() {
        return atendimentoAtual == null ? null : atendimentoAtual.getPaciente();
    }

    public boolean temPacienteEmAtendimento() {
        return atendimentoAtual != null;
    }

    public boolean cadastrarPaciente(Paciente paciente) {
        if (paciente == null || pacientes.contemCpf(paciente.getCpf())) {
            return false;
        }

        paciente.setId(proximoIdPaciente);
        proximoIdPaciente++;

        paciente.setStatusAtendimento("Cadastrado");
        paciente.cadastrar(pacientes);
        return true;
    }

    public boolean registrarChegadaPaciente(String cpf) {
        Paciente paciente = pacientes.buscarPorCpf(cpf);

        if (paciente == null) {
            return false;
        }

        if ("Aguardando na fila".equalsIgnoreCase(paciente.getStatusAtendimento())
                || "Em atendimento".equalsIgnoreCase(paciente.getStatusAtendimento())) {
            return false;
        }

        paciente.setStatusAtendimento("Aguardando na fila");
        fila.enfileirar(paciente);
        return true;
    }

    public boolean cadastrarPacienteERegistrarChegada(Paciente paciente) {
        if (!cadastrarPaciente(paciente)) {
            return false;
        }
        return registrarChegadaPaciente(paciente.getCpf());
    }

    public String listarPacientesTexto() {
        return pacientes.listarPacientesTexto();
    }

    public String exibirFilaTexto() {
        return fila.exibirFilaTexto();
    }

    public Paciente chamarProximoPaciente(String medico) {
        if (atendimentoAtual != null) {
            return null;
        }

        if (medico == null || medico.trim().isEmpty()) {
            return null;
        }

        Paciente paciente = fila.desenfileirar();
        if (paciente == null) {
            return null;
        }

        paciente.setStatusAtendimento("Em atendimento");
        contadorAtendimentos++;
        atendimentoAtual = Atendimento.criarNovo(contadorAtendimentos, paciente, medico.trim());
        atendimentoAtual.iniciarAtendimento();

        return paciente;
    }

    public Paciente finalizarAtendimento(String diagnostico, String observacoes, String medicamentos) {
        if (atendimentoAtual == null) {
            return null;
        }

        Paciente paciente = atendimentoAtual.getPaciente();
        paciente.setStatusAtendimento("Finalizado");

        contadorProntuarios++;
        Prontuario prontuario = new Prontuario(contadorProntuarios, paciente);
        prontuario.adicionarSintomas(paciente.getSintomas());
        prontuario.adicionarMedicamentos(medicamentos);
        prontuario.registrarDiagnostico(diagnostico);
        prontuario.setObservacoes(observacoes);

        atendimentoAtual.finalizarAtendimento(prontuario);
        historico.push(atendimentoAtual);
        prontuarios.adicionar(prontuario);
        prontuarioAtual = prontuarios.getFim();

        Paciente finalizado = paciente;
        atendimentoAtual = null;
        return finalizado;
    }

    public String exibirHistoricoTexto() {
        return historico.listar();
    }

    public String exibirPacienteAtualTexto() {
        if (atendimentoAtual == null) {
            return "Nenhum paciente em atendimento.";
        }

        Paciente paciente = atendimentoAtual.getPaciente();

        return "==============================\n"
                + "PACIENTE EM ATENDIMENTO\n"
                + "==============================\n\n"
                + atendimentoAtual.exibirResumo()
                + "\n\n=== DADOS DO PACIENTE ===\n"
                + "ID do paciente: " + paciente.getId() + "\n"
                + "Nome: " + paciente.getNome() + "\n"
                + "Idade: " + paciente.getIdade() + "\n"
                + "CPF: " + paciente.getCpf() + "\n"
                + "Prioridade: " + paciente.getPrioridade() + "\n"
                + "Sintomas informados: " + paciente.getSintomas() + "\n"
                + "Status: " + paciente.getStatusAtendimento() + "\n";
    }

    public boolean temProntuarios() {
        return !prontuarios.estaVazia();
    }

    public String abrirPrimeiroProntuarioTexto() {
        if (!temProntuarios()) {
            return "Nenhum prontuário finalizado ainda.";
        }

        prontuarioAtual = prontuarios.getInicio();
        return prontuarioAtual.dado.exibirProntuario();
    }

    public String abrirUltimoProntuarioTexto() {
        if (!temProntuarios()) {
            return "Nenhum prontuário finalizado ainda.";
        }

        prontuarioAtual = prontuarios.getFim();
        return prontuarioAtual.dado.exibirProntuario();
    }

    public String avancarProntuarioTexto() {
        if (!temProntuarios()) {
            return "Nenhum prontuário finalizado ainda.";
        }

        if (prontuarioAtual == null) {
            prontuarioAtual = prontuarios.getInicio();
            return prontuarioAtual.dado.exibirProntuario();
        }

        if (prontuarioAtual.proximo == null) {
            return "Você já está no último prontuário.\n\n" + prontuarioAtual.dado.exibirProntuario();
        }

        prontuarioAtual = prontuarioAtual.proximo;
        return prontuarioAtual.dado.exibirProntuario();
    }

    public String voltarProntuarioTexto() {
        if (!temProntuarios()) {
            return "Nenhum prontuário finalizado ainda.";
        }

        if (prontuarioAtual == null) {
            prontuarioAtual = prontuarios.getFim();
            return prontuarioAtual.dado.exibirProntuario();
        }

        if (prontuarioAtual.anterior == null) {
            return "Você já está no primeiro prontuário.\n\n" + prontuarioAtual.dado.exibirProntuario();
        }

        prontuarioAtual = prontuarioAtual.anterior;
        return prontuarioAtual.dado.exibirProntuario();
    }
}