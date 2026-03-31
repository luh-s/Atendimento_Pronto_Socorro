package Telas;

import javax.swing.*;
import Modelos.*;
import java.awt.*;

public class TelaCadastroPaciente extends JFrame {

    private UnidadeAtendimento unidade;
    private ArrayUnidades unidades;

    private JTextField campoIdade;
    private JTextField campoNome;
    private JTextField campoCpf;
    private JComboBox<String> comboPrioridade;
    private JTextField campoSintomas;

    public TelaCadastroPaciente(UnidadeAtendimento unidade, ArrayUnidades unidades) {
        this.unidade = unidade;
        this.unidades = unidades;

        setTitle("Cadastro de Paciente - " + unidade.getNome());
        setSize(620, 460);
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
        JLabel subtitulo = EstiloTelas.criarSubtitulo("Ao salvar, o paciente já será registrado na fila");

        campoIdade = EstiloTelas.criarCampo();
        campoNome = EstiloTelas.criarCampo();
        campoCpf = EstiloTelas.criarCampo();
        campoSintomas = EstiloTelas.criarCampo();

        comboPrioridade = new JComboBox<>(new String[]{"baixa", "media", "alta"});
        comboPrioridade.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        comboPrioridade.setBackground(Color.WHITE);
        comboPrioridade.setFocusable(false);

        JButton salvar = EstiloTelas.criarBotaoPrimario("Cadastrar Paciente");
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
        card.add(EstiloTelas.criarLabel("Nome:"), gbc);
        gbc.gridx = 1;
        card.add(campoNome, gbc);

        gbc.gridy = 3;
        gbc.gridx = 0;
        card.add(EstiloTelas.criarLabel("Idade:"), gbc);
        gbc.gridx = 1;
        card.add(campoIdade, gbc);

        gbc.gridy = 4;
        gbc.gridx = 0;
        card.add(EstiloTelas.criarLabel("CPF:"), gbc);
        gbc.gridx = 1;
        card.add(campoCpf, gbc);

        gbc.gridy = 5;
        gbc.gridx = 0;
        card.add(EstiloTelas.criarLabel("Prioridade:"), gbc);
        gbc.gridx = 1;
        card.add(comboPrioridade, gbc);

        gbc.gridy = 6;
        gbc.gridx = 0;
        card.add(EstiloTelas.criarLabel("Sintomas (separe por vírgula):"), gbc);
        gbc.gridx = 1;
        card.add(campoSintomas, gbc);

        gbc.gridy = 7;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        card.add(salvar, gbc);

        gbc.gridy = 8;
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
            String prioridade = comboPrioridade.getSelectedItem().toString();
            String sintomas = campoSintomas.getText().trim();

            if (campoIdade.getText().trim().isEmpty()
                    || nome.isEmpty()
                    || cpf.isEmpty()
                    || sintomas.isEmpty()) {

                JOptionPane.showMessageDialog(this, "Preencha todos os campos.");
                return;
            }

            int idade = Integer.parseInt(campoIdade.getText().trim());

            Paciente paciente = new Paciente(
                    idade,
                    nome,
                    cpf,
                    prioridade,
                    sintomas,
                    "Cadastrado"
            );

            boolean sucesso = unidade.cadastrarPacienteERegistrarChegada(paciente);

            if (!sucesso) {
                JOptionPane.showMessageDialog(this, "Já existe paciente com esse CPF cadastrado nesta unidade.");
                return;
            }

            JOptionPane.showMessageDialog(this,
                    "Paciente cadastrado com sucesso!\nID gerado: " + paciente.getId()
                            + "\nPaciente já registrado na fila.");

            new TelaPrincipal(unidade, unidades);
            dispose();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "A idade deve ser um número inteiro.");
        }
    }
}