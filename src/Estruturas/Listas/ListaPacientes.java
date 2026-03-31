package Estruturas.Listas;

import Modelos.Paciente;

public class ListaPacientes {

    private NoListaPacientes head;

    public void inserir(Paciente paciente) {
        NoListaPacientes novo = new NoListaPacientes(paciente);
        novo.proximo = head;
        head = novo;
    }

    public Paciente buscarPorCpf(String cpf) {
        NoListaPacientes atual = head;

        while (atual != null) {
            if (atual.dados.getCpf().equals(cpf)) {
                return atual.dados;
            }
            atual = atual.proximo;
        }

        return null;
    }

    public boolean contemCpf(String cpf) {
        return buscarPorCpf(cpf) != null;
    }

    public boolean estaVazia() {
        return head == null;
    }

    public String listarPacientesTexto() {
        if (head == null) {
            return "Nenhum paciente cadastrado nesta unidade.";
        }

        StringBuilder texto = new StringBuilder();
        NoListaPacientes atual = head;

        while (atual != null) {
            Paciente p = atual.dados;
            texto.append("ID: ").append(p.getId())
                 .append(" | Nome: ").append(p.getNome())
                 .append(" | Idade: ").append(p.getIdade())
                 .append(" | CPF: ").append(p.getCpf())
                 .append(" | Prioridade: ").append(p.getPrioridade())
                 .append(" | Sintomas: ").append(p.getSintomas())
                 .append(" | Status: ").append(p.getStatusAtendimento())
                 .append("\n");

            atual = atual.proximo;
        }

        return texto.toString();
    }
}