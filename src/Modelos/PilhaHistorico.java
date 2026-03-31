package Modelos;

import Estruturas.Filas.*;
import Estruturas.Listas.*;
import Estruturas.Pilhas.*;

public class PilhaHistorico {

    private NoListaPacientes topo;

    public void push(Paciente paciente) {
        NoListaPacientes novo = new NoListaPacientes(paciente);
        novo.proximo = topo;
        topo = novo;
    }

    public Paciente pop() {
        if (topo == null) {
            return null;
        }

        Paciente paciente = topo.dados;
        topo = topo.proximo;
        return paciente;
    }

    public Paciente peek() {
        if (topo == null) {
            return null;
        }

        return topo.dados;
    }

    public boolean estaVazia() {
        return topo == null;
    }

    public String listar() {
        if (topo == null) {
            return "Nenhum atendimento finalizado.";
        }

        String texto = "";
        NoListaPacientes atual = topo;

        while (atual != null) {
            Paciente p = atual.dados;

            texto += "------------------------------\n";
            texto += "Nome: " + p.getNome() + "\n";
            texto += "ID: " + p.getId() + "\n";
            texto += "Idade: " + p.getIdade() + "\n";
            texto += "CPF: " + p.getCpf() + "\n";
            texto += "Prioridade: " + p.getPrioridade() + "\n";
            texto += "Sintomas: " + p.getSintomas() + "\n";
            texto += "Status: " + p.getStatusAtendimento() + "\n";

            atual = atual.proximo;
        }

        return texto;
    }
}