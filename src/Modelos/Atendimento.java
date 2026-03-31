package Modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Atendimento {
    private String idAtendimento;
    private Paciente paciente;
    private String medico;
    private String horarioEntrada;
    private String horarioAtendimento;
    private String horarioFinalizacao;
    private String status;
    private Prontuario prontuario;

    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public Atendimento(String idAtendimento, Paciente paciente, String medico, String horarioEntrada,
            String horarioAtendimento, String status) {
        this.idAtendimento = idAtendimento;
        this.paciente = paciente;
        this.medico = medico;
        this.horarioEntrada = horarioEntrada;
        this.horarioAtendimento = horarioAtendimento;
        this.status = status;
        this.horarioFinalizacao = "";
        this.prontuario = null;
    }

    public static Atendimento criarNovo(int numero, Paciente paciente, String medico) {
        String agora = LocalDateTime.now().format(FORMATO);
        return new Atendimento("ATD-" + numero, paciente, medico, agora, agora, "Em atendimento");
    }

    public void iniciarAtendimento() {
        this.horarioAtendimento = LocalDateTime.now().format(FORMATO);
        this.status = "Em atendimento";
    }

    public void finalizarAtendimento(Prontuario prontuario) {
        this.prontuario = prontuario;
        this.horarioFinalizacao = LocalDateTime.now().format(FORMATO);
        this.status = "Finalizado";
    }

    public void cancelarAtendimento() {
        this.status = "Cancelado";
        this.horarioFinalizacao = LocalDateTime.now().format(FORMATO);
    }

    public String exibirResumo() {
        String nomePaciente = paciente == null ? "Sem paciente" : paciente.getNome();
        String cpfPaciente = paciente == null ? "-" : paciente.getCpf();

        return "=== ATENDIMENTO ===\n"
                + "ID do atendimento: " + idAtendimento + "\n"
                + "Paciente: " + nomePaciente + "\n"
                + "CPF: " + cpfPaciente + "\n"
                + "Médico: " + medico + "\n"
                + "Horário de entrada: " + horarioEntrada + "\n"
                + "Início do atendimento: " + horarioAtendimento + "\n"
                + "Finalização: " + (horarioFinalizacao == null || horarioFinalizacao.isEmpty() ? "Ainda não finalizado" : horarioFinalizacao) + "\n"
                + "Status: " + status;
    }

    public String getIdAtendimento() {
        return idAtendimento;
    }

    public void setIdAtendimento(String idAtendimento) {
        this.idAtendimento = idAtendimento;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getHorarioEntrada() {
        return horarioEntrada;
    }

    public void setHorarioEntrada(String horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    public String getHorarioAtendimento() {
        return horarioAtendimento;
    }

    public void setHorarioAtendimento(String horarioAtendimento) {
        this.horarioAtendimento = horarioAtendimento;
    }

    public String getHorarioFinalizacao() {
        return horarioFinalizacao;
    }

    public void setHorarioFinalizacao(String horarioFinalizacao) {
        this.horarioFinalizacao = horarioFinalizacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Prontuario getProntuario() {
        return prontuario;
    }

    public void setProntuario(Prontuario prontuario) {
        this.prontuario = prontuario;
    }
}