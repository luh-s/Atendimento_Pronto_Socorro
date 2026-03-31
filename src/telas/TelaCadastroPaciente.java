package Telas;

import javax.swing.*;

import Modelos.*;

import java.awt.*;

public class TelaCadastroPaciente extends JFrame {

    private UnidadeAtendimento unidade;
    private ArrayUnidades unidades;

    private JTextField campoId;
    private JTextField campoIdade;
    private JTextField campoNome;
    private JTextField campoCpf;
    private JTextField campoPrioridade;
    private JTextField campoSintomas;
    private JTextField campoStatus;

    public TelaCadastroPaciente(UnidadeAtendimento unidade, ArrayUnidades unidades) {
        this.unidade = unidade;
        this.unidades = unidades;

        setTitle("Cadastro de Paciente - " + unidade.getNome());
        setSize(620, 520);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel painelBase = EstiloTelas.criarPainelBase();
        add(painelBase);

        JPanel card = EstiloTelas.criarCard();
        painelBase.add(card);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titulo = EstiloTelas.criarTitulo("Cadastrar Paciente");
        JLabel subtitulo = EstiloTelas.criarSubtitulo("Unidade atual: " + unidade.getNome());

        campoId = EstiloTelas.criarCampo();
        campoIdade = EstiloTelas.criarCampo();
        campoNome = EstiloTelas.criarCampo();
        campoCpf = EstiloTelas.criarCampo();
        campoPrioridade = EstiloTelas.criarCampo();
        campoSintomas = EstiloTelas.criarCampo();
        campoStatus = EstiloTelas.criarCampo();

        JButton salvar = EstiloTelas.criarBotaoPrimario("Salvar Paciente");
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
        card.add(EstiloTelas.criarLabel("ID:"), gbc);
        gbc.gridx = 1;
        card.add(campoId, gbc);

        gbc.gridy = 3;
        gbc.gridx = 0;
        card.add(EstiloTelas.criarLabel("Idade:"), gbc);
        gbc.gridx = 1;
        card.add(campoIdade, gbc);

        gbc.gridy = 4;
        gbc.gridx = 0;
        card.add(EstiloTelas.criarLabel("Nome:"), gbc);
        gbc.gridx = 1;
        card.add(campoNome, gbc);

        gbc.gridy = 5;
        gbc.gridx = 0;
        card.add(EstiloTelas.criarLabel("CPF:"), gbc);
        gbc.gridx = 1;
        card.add(campoCpf, gbc);

        gbc.gridy = 6;
        gbc.gridx = 0;
        card.add(EstiloTelas.criarLabel("Prioridade:"), gbc);
        gbc.gridx = 1;
        card.add(campoPrioridade, gbc);

        gbc.gridy = 7;
        gbc.gridx = 0;
        card.add(EstiloTelas.criarLabel("Sintomas:"), gbc);
        gbc.gridx = 1;
        card.add(campoSintomas, gbc);

        gbc.gridy = 8;
        gbc.gridx = 0;
        card.add(EstiloTelas.criarLabel("Status:"), gbc);
        gbc.gridx = 1;
        card.add(campoStatus, gbc);

        gbc.gridy = 9;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        card.add(salvar, gbc);

        gbc.gridy = 10;
        card.add(voltar, gbc);

        salvar.addActionListener(e -> salvarPaciente());

        voltar.addActionListener(e -> {
            new TelaPrincipal(unidade, unidades);
            dispose();
        });

        setVisible(true);
    }

    private void salvarPaciente() {
        try {
            String nome = campoNome.getText().trim();
            String cpf = campoCpf.getText().trim();
            String prioridade = campoPrioridade.getText().trim();
            String sintomas = campoSintomas.getText().trim();
            String status = campoStatus.getText().trim();

            if (campoId.getText().trim().isEmpty() ||
                campoIdade.getText().trim().isEmpty() ||
                nome.isEmpty() ||
                cpf.isEmpty() ||
                prioridade.isEmpty() ||
                sintomas.isEmpty() ||
                status.isEmpty()) {

                JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
                return;
            }

            int id = Integer.parseInt(campoId.getText().trim());
            int idade = Integer.parseInt(campoIdade.getText().trim());

            Paciente paciente = new Paciente(id, idade, nome, cpf, prioridade, sintomas, status);

            unidade.novoPaciente(paciente);

            JOptionPane.showMessageDialog(null, "Paciente cadastrado com sucesso!");
            new TelaPrincipal(unidade, unidades);
            dispose();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "ID e idade devem ser números inteiros.");
        }
    }
}