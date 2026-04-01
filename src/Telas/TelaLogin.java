package Telas;

import javax.swing.*;
import Modelos.*;
import java.awt.*;

public class TelaLogin extends JFrame {
    private ArrayUnidades unidades;
    private JTextField campoUsuario;
    private JPasswordField campoSenha;

    public TelaLogin(ArrayUnidades unidades) {
        this.unidades = unidades;

        setTitle("Sistema de Saúde - Login");
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

        JLabel titulo = EstiloTelas.criarTitulo("Sistema CSUS");
        JLabel subtitulo = EstiloTelas.criarSubtitulo("Acesse com o nome e a senha da unidade");

        campoUsuario = EstiloTelas.criarCampo();
        campoSenha = EstiloTelas.criarCampoSenha();

        JButton botaoLogin = EstiloTelas.criarBotaoPrimario("Entrar");
        JButton botaoCadastro = EstiloTelas.criarBotaoSecundario("Cadastrar Unidade");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        card.add(titulo, gbc);

        gbc.gridy = 1;
        card.add(subtitulo, gbc);

        gbc.gridwidth = 1;
        gbc.gridy = 2;
        gbc.gridx = 0;
        card.add(EstiloTelas.criarLabel("Unidade:"), gbc);

        gbc.gridx = 1;
        card.add(campoUsuario, gbc);

        gbc.gridy = 3;
        gbc.gridx = 0;
        card.add(EstiloTelas.criarLabel("Senha:"), gbc);

        gbc.gridx = 1;
        card.add(campoSenha, gbc);

        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        card.add(botaoLogin, gbc);

        gbc.gridy = 5;
        card.add(botaoCadastro, gbc);

        botaoLogin.addActionListener(e -> {
            String usuario = campoUsuario.getText().trim();
            String senha = new String(campoSenha.getPassword());

            UnidadeAtendimento unidade = unidades.retorno(usuario, senha);

            if (unidades.verificar(usuario, senha)) {
                JOptionPane.showMessageDialog(null, "Login realizado!");
                new TelaPrincipal(unidade, unidades);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Dados inválidos!");
            }
        });

        botaoCadastro.addActionListener(e -> {
            new TelaCadastroUnidade(unidades);
            dispose();
        });

        setVisible(true);
    }
}