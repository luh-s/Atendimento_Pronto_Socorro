package telas;

import javax.swing.*;
import java.awt.*;
import codigos.*;

public class TelaCadastroUnidade extends JFrame {
    private ArrayUnidades unidades;
    private JTextField campoNome;
    private JPasswordField campoSenha;

    public TelaCadastroUnidade(ArrayUnidades unidades) {
        this.unidades=unidades;
        setTitle("Cadastro de Unidade");
        setSize(500, 350);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setBackground(new Color(40, 40, 80));
        painel.setLayout(null);
        add(painel);

        JLabel titulo = new JLabel("Cadastrar Unidade");
        titulo.setBounds(150, 20, 250, 30);
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        painel.add(titulo);

        JLabel labelNome = new JLabel("Nome:");
        labelNome.setBounds(100, 80, 100, 25);
        labelNome.setForeground(Color.WHITE);
        painel.add(labelNome);

        campoNome = new JTextField();
        campoNome.setBounds(200, 80, 180, 30);
        painel.add(campoNome);

        JLabel labelSenha = new JLabel("Senha:");
        labelSenha.setBounds(100, 130, 100, 25);
        labelSenha.setForeground(Color.WHITE);
        painel.add(labelSenha);

        campoSenha = new JPasswordField();
        campoSenha.setBounds(200, 130, 180, 30);
        painel.add(campoSenha);

        JButton salvar = new JButton("Salvar");
        salvar.setBounds(200, 180, 180, 35);
        painel.add(salvar);

        JButton voltar = new JButton("Voltar");
        voltar.setBounds(200, 230, 180, 30);
        painel.add(voltar);

        salvar.addActionListener(e -> {
            String nome = campoNome.getText();
            String senha = new String(campoSenha.getPassword());
            JOptionPane.showMessageDialog(null, "Unidade cadastrada!");
            unidades.cadastro(new UnidadeAtendimento(nome, senha));
        });

        voltar.addActionListener(e -> {
            new TelaLogin(unidades);
            dispose();
        });

        setVisible(true);
    }
}
