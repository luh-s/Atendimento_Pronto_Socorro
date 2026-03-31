package Modelos;

import Estruturas.Listas.ListaPacientes;

public class UnidadeAtendimento {
    private String nome, senha;
    private ListaPacientes pacientes;
    private Fila fila;
    private PilhaHistorico historico;

    public UnidadeAtendimento(String nome, String senha){
        this.nome = nome;
        this.senha = senha;
        this.pacientes = new ListaPacientes();
        this.fila = new Fila();
        this.historico = new PilhaHistorico();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    public void novoPaciente(Paciente paciente){
        pacientes.inserir(paciente);
    }
}