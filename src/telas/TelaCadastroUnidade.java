package Telas;

import javax.swing.*;

import Modelos.*;

import java.awt.*;

public class TelaCadastroUnidade extends JFrame {
    private ArrayUnidades unidades;
    private JTextField campoNome;
    private JPasswordField campoSenha;

    public TelaCadastroUnidade(ArrayUnidades unidades) {
        this.unidades = unidades;

        setTitle("Cadastro de Unidade");
        setSize(520, 360);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painelBase = EstiloTelas.criarPainelBase();
        add(painelBase);

        JPanel card = EstiloTelas.criarCard();
        painelBase.add(card);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titulo = EstiloTelas.criarTitulo("Cadastrar Unidade");
        JLabel subtitulo = EstiloTelas.criarSubtitulo("Crie uma nova unidade para login no sistema");

        campoNome = EstiloTelas.criarCampo();
        campoSenha = EstiloTelas.criarCampoSenha();

        JButton salvar = EstiloTelas.criarBotaoPrimario("Salvar");
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
        card.add(EstiloTelas.criarLabel("Senha:"), gbc);

        gbc.gridx = 1;
        card.add(campoSenha, gbc);

        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        card.add(salvar, gbc);

        gbc.gridy = 5;
        card.add(voltar, gbc);

        salvar.addActionListener(e -> {
            String nome = campoNome.getText().trim();
            String senha = new String(campoSenha.getPassword());

            if (nome.isEmpty() || senha.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha nome e senha.");
                return;
            }

            if (unidades.verificar(nome, senha)) {
                JOptionPane.showMessageDialog(null, "Nome de unidade já cadastrada!");
            } else {
                unidades.cadastro(new UnidadeAtendimento(nome, senha));
                JOptionPane.showMessageDialog(null, "Unidade cadastrada!");
                campoNome.setText("");
                campoSenha.setText("");
            }
        });

        voltar.addActionListener(e -> {
            new TelaLogin(unidades);
            dispose();
        });

        setVisible(true);
    }
}