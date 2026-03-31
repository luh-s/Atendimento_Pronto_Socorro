package Modelos;

import Estruturas.Listas.ListaPacientes;

public class Paciente {
    private int id;
    private int idade;
    private String nome;
    private String cpf;
    private String prioridade;
    private String sintomas;
    private String statusAtendimento;

    public Paciente(int idade, String nome, String cpf, String prioridade, String sintomas, String statusAtendimento) {
        this.id = 0;
        this.idade = idade;
        this.nome = nome;
        this.cpf = cpf;
        this.prioridade = prioridade;
        this.sintomas = sintomas;
        this.statusAtendimento = statusAtendimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getStatusAtendimento() {
        return statusAtendimento;
    }

    public void setStatusAtendimento(String statusAtendimento) {
        this.statusAtendimento = statusAtendimento;
    }

    public void cadastrar(ListaPacientes lista) {
        lista.inserir(this);
    }

    public void atualizarDados(int idade, String nome, String cpf, String prioridade, String sintomas, String statusAtendimento) {
        this.idade = idade;
        this.nome = nome;
        this.cpf = cpf;
        this.prioridade = prioridade;
        this.sintomas = sintomas;
        this.statusAtendimento = statusAtendimento;
    }

    public String exibirDadosTexto() {
        return "-----------------------------\n"
                + "Id: " + getId() + "\n"
                + "Prioridade: " + getPrioridade() + "\n"
                + "Paciente: " + getNome() + "\n"
                + "Idade: " + getIdade() + "\n"
                + "Cpf: " + getCpf() + "\n"
                + "Sintomas: " + getSintomas() + "\n"
                + "Status de atendimento: " + getStatusAtendimento() + "\n"
                + "-----------------------------";
    }

    public void exibirDados() {
        System.out.println(exibirDadosTexto());
    }
}