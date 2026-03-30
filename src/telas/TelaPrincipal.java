package telas;

import javax.swing.*;

public class TelaPrincipal extends JFrame {

    public TelaPrincipal() {
        setTitle("Sistema de Atendimento");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel label = new JLabel("Bem-vindo ao sistema!");
        label.setBounds(150, 100, 200, 30);
        add(label);

        setLayout(null);
        setVisible(true);
    }
}
