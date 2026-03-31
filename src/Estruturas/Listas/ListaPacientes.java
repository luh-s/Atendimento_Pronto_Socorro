package Estruturas.Listas;
import Modelos.*;

public class ListaPacientes {

    NoListaPacientes head;

    public void inserir(Paciente paciente) {
        NoListaPacientes novo = new NoListaPacientes(paciente);
        novo.proximo = head;
        head = novo;
    }

    public void mostrar() {
        NoListaPacientes atual = head;

        while (atual != null) {
            System.out.println(atual.dados.getNome());
            atual = atual.proximo;
        }
    }

    public boolean estaVazia() {
        return head == null;
    }

    public String listarPacientesTexto() {
        if (head == null) {
            return "Nenhum paciente cadastrado nesta unidade.";
        }

        String texto = "";
        NoListaPacientes atual = head;

        while (atual != null) {
            Paciente p = atual.dados;

            texto += "ID: " + p.getId()
                    + " | Nome: " + p.getNome()
                    + " | Idade: " + p.getIdade()
                    + " | CPF: " + p.getCpf()
                    + " | Prioridade: " + p.getPrioridade()
                    + " | Sintomas: " + p.getSintomas()
                    + " | Status: " + p.getStatusAtendimento()
                    + "\n";

            atual = atual.proximo;
        }

        return texto;
    }
}