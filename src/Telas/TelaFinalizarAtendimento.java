package Telas;

import javax.swing.*;
import Modelos.*;
import java.awt.*;

public class TelaFinalizarAtendimento extends JFrame {

    private UnidadeAtendimento unidade;
    private ArrayUnidades unidades;

    private JTextField campoDiagnostico;
    private JTextField campoMedicamentos;
    private JTextArea campoObservacoes;

    public TelaFinalizarAtendimento(UnidadeAtendimento unidade, ArrayUnidades unidades) {
        this.unidade = unidade;
        this.unidades = unidades;

        setTitle("Finalizar Atendimento - " + unidade.getNome());
        setSize(650, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel painelBase = EstiloTelas.criarPainelBase();
        add(painelBase);

        JPanel card = EstiloTelas.criarCard();
        painelBase.add(card);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titulo = EstiloTelas.criarTitulo("Finalizar Atendimento");
        String nomePaciente = unidade.getPacienteEmAtendimento() == null ? "Nenhum" : unidade.getPacienteEmAtendimento().getNome();
        JLabel subtitulo = EstiloTelas.criarSubtitulo("Paciente atual: " + nomePaciente);

        campoDiagnostico = EstiloTelas.criarCampo();
        campoMedicamentos = EstiloTelas.criarCampo();
        campoObservacoes = new JTextArea(5, 18);
        campoObservacoes.setLineWrap(true);
        campoObservacoes.setWrapStyleWord(true);
        campoObservacoes.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JButton finalizar = EstiloTelas.criarBotaoPrimario("Finalizar");
        JButton voltar = EstiloTelas.criarBotaoSecundario("Voltar");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        card.add(titulo, gbc);

        gbc.gridy = 1;
        card.add(subtitulo, gbc);

        gbc.gridwidth = 1;
        gbc.gridy = 2;
        gbc.gridx = 0;
        card.add(EstiloTelas.criarLabel("Diagnóstico:"), gbc);
        gbc.gridx = 1;
        card.add(campoDiagnostico, gbc);

        gbc.gridy = 3;
        gbc.gridx = 0;
        card.add(EstiloTelas.criarLabel("Medicamentos (separados por vírgula):"), gbc);
        gbc.gridx = 1;
        card.add(campoMedicamentos, gbc);

        gbc.gridy = 4;
        gbc.gridx = 0;
        card.add(EstiloTelas.criarLabel("Observações:"), gbc);
        gbc.gridx = 1;
        card.add(new JScrollPane(campoObservacoes), gbc);

        gbc.gridy = 5;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        card.add(finalizar, gbc);

        gbc.gridy = 6;
        card.add(voltar, gbc);

        finalizar.addActionListener(e -> finalizarAtendimento());
        voltar.addActionListener(e -> {
            new TelaPrincipal(unidade, unidades);
            dispose();
        });

        setVisible(true);
    }

    private void finalizarAtendimento() {
        String diagnostico = campoDiagnostico.getText().trim();
        String medicamentos = campoMedicamentos.getText().trim();
        String observacoes = campoObservacoes.getText().trim();

        if (diagnostico.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe o diagnóstico.");
            return;
        }

        Paciente finalizado = unidade.finalizarAtendimento(diagnostico, observacoes, medicamentos);

        if (finalizado == null) {
            JOptionPane.showMessageDialog(this, "Não há paciente em atendimento.");
            return;
        }

        JOptionPane.showMessageDialog(this, "Atendimento finalizado para " + finalizado.getNome() + ".");
        new TelaPrincipal(unidade, unidades);
        dispose();
    }
}