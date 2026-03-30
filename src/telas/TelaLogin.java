package telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import codigos.*;

public class TelaLogin extends JFrame {
    private ArrayUnidades unidades;
    private JTextField campoUsuario;
    private JPasswordField campoSenha;

    public TelaLogin(ArrayUnidades unidades) {
        this.unidades=unidades;
        setTitle("Sistema de Saúde");
        setSize(500, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel principal com cor moderna
        JPanel painel = new JPanel();
        painel.setBackground(new Color(30, 30, 60));
        painel.setLayout(null);
        add(painel);

        JLabel titulo = new JLabel("SISTEMA CSUS (cesupa sus)");
        titulo.setBounds(100, 20, 400, 30);
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        painel.add(titulo);

        JLabel labelUsuario = new JLabel("Unidade:");
        labelUsuario.setBounds(100, 80, 100, 25);
        labelUsuario.setForeground(Color.WHITE);
        painel.add(labelUsuario);

        campoUsuario = new JTextField();
        campoUsuario.setBounds(200, 80, 180, 30);
        painel.add(campoUsuario);

        JLabel labelSenha = new JLabel("Senha:");
        labelSenha.setBounds(100, 130, 100, 25);
        labelSenha.setForeground(Color.WHITE);
        painel.add(labelSenha);

        campoSenha = new JPasswordField();
        campoSenha.setBounds(200, 130, 180, 30);
        painel.add(campoSenha);

        JButton botaoLogin = new JButton("Entrar");
        botaoLogin.setBounds(200, 180, 180, 35);
        botaoLogin.setBackground(new Color(70, 130, 180));
        botaoLogin.setForeground(Color.WHITE);
        painel.add(botaoLogin);

        JButton botaoCadastro = new JButton("Cadastrar Unidade");
        botaoCadastro.setBounds(200, 230, 180, 30);
        painel.add(botaoCadastro);

        // LOGIN
        botaoLogin.addActionListener(e -> {
            String usuario = campoUsuario.getText();
            String senha = new String(campoSenha.getPassword());

            if (unidades.verificar(usuario, senha)) {
                JOptionPane.showMessageDialog(null, "Login realizado!");
                new TelaPrincipal();
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Dados inválidos!");
            }
        });

        // IR PARA CADASTRO
        botaoCadastro.addActionListener(e -> {
            new TelaCadastroUnidade(unidades);
            dispose();
        });

        setVisible(true);
    }
}
