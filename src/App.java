import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("Atendimento Pronto Socorro");
        frame.setLayout(null);
        
        JTextField id = new JTextField();
        JTextField idade = new JTextField();
        JTextField nome = new JTextField();
        JTextField cpf = new JTextField();
        JTextField prioridade = new JTextField();
        JTextField status = new JTextField();
        id.setBounds(100, 100, 300, 40);
        idade.setBounds(100, 160, 300, 40);
        nome.setBounds(100, 220, 300, 40);
        cpf.setBounds(100, 280, 300, 40);
        prioridade.setBounds(100, 340, 300, 40);
        status.setBounds(100, 400, 300, 40);

        JButton salvar = new JButton("Salvar");
        salvar.setBounds(100, 470, 150, 40);

        frame.add(salvar);

        salvar.addActionListener(e -> {
        int idValor = Integer.parseInt(id.getText());
        int idadeValor = Integer.parseInt(idade.getText());
        String nomeValor = nome.getText();
        String cpfValor = cpf.getText();
        String prioridadeValor = prioridade.getText();
        String statusValor = status.getText();

        Paciente paciente = new Paciente(
            idValor,
            idadeValor,
            nomeValor,
            cpfValor,
            prioridadeValor,
            statusValor,
            null
        );
        paciente.exibirDados();
    });

        frame.add(id);
        frame.add(idade);
        frame.add(nome);
        frame.add(cpf);
        frame.add(prioridade);
        frame.add(status);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        frame.setVisible(true);
    } 
}
