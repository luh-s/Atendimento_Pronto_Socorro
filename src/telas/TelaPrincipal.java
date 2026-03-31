package Telas;

import javax.swing.*;

import Modelos.*;

import java.awt.*;

public class TelaPrincipal extends JFrame {

    private UnidadeAtendimento unidade;
    private ArrayUnidades unidades;
    private JTextArea areaPacientes;

    public TelaPrincipal(UnidadeAtendimento unidade, ArrayUnidades unidades) {
        this.unidade = unidade;
        this.unidades = unidades;

        setTitle("Sistema - " + unidade.getNome());
        setSize(760, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel painelPrincipal = new JPanel(new BorderLayout(15, 15));
        painelPrincipal.setBackground(EstiloTelas.FUNDO);
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(painelPrincipal);

        JPanel topo = new JPanel(new BorderLayout());
        topo.setBackground(EstiloTelas.PAINEL);
        topo.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titulo = new JLabel("Unidade: " + unidade.getNome());
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titulo.setForeground(new Color(120, 180, 255)); // azul mais claro destaque
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titulo.setForeground(EstiloTelas.TEXTO);

        JLabel subtitulo = new JLabel("Pacientes cadastrados nesta unidade");
        subtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        subtitulo.setForeground(EstiloTelas.TEXTO_CLARO);

        JPanel textosTopo = new JPanel();
        textosTopo.setBackground(EstiloTelas.PAINEL);
        textosTopo.setLayout(new BoxLayout(textosTopo, BoxLayout.Y_AXIS));
        textosTopo.add(titulo);
        textosTopo.add(Box.createVerticalStrut(6));
        textosTopo.add(subtitulo);

        topo.add(textosTopo, BorderLayout.WEST);

        painelPrincipal.add(topo, BorderLayout.NORTH);

        areaPacientes = EstiloTelas.criarAreaTexto();
        atualizarListaPacientes();

        JScrollPane scroll = new JScrollPane(areaPacientes);
        JLabel tituloLista = new JLabel("Lista de Pacientes");
        tituloLista.setFont(new Font("Segoe UI", Font.BOLD, 14));
        tituloLista.setForeground(EstiloTelas.TEXTO);

        JPanel painelLista = new JPanel(new BorderLayout(5, 5));
        painelLista.setBackground(EstiloTelas.PAINEL);
        painelLista.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        painelLista.add(tituloLista, BorderLayout.NORTH);

        painelPrincipal.add(painelLista, BorderLayout.CENTER);
        scroll.getViewport().setBackground(EstiloTelas.PAINEL);

        areaPacientes.setBackground(EstiloTelas.PAINEL);
        areaPacientes.setForeground(EstiloTelas.TEXTO);
        areaPacientes.setCaretColor(EstiloTelas.TEXTO);

        painelPrincipal.add(scroll, BorderLayout.CENTER);

        JPanel rodape = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        rodape.setBackground(EstiloTelas.FUNDO);

        JButton cadastrarPaciente = EstiloTelas.criarBotaoPrimario("Cadastrar Paciente");
        JButton atualizar = EstiloTelas.criarBotaoSecundario("Atualizar Lista");
        JButton sair = EstiloTelas.criarBotaoSecundario("Sair");

        rodape.add(cadastrarPaciente);
        rodape.add(atualizar);
        rodape.add(sair);

        painelPrincipal.add(rodape, BorderLayout.SOUTH);

        cadastrarPaciente.addActionListener(e -> {
            new TelaCadastroPaciente(unidade, unidades);
            dispose();
        });

        atualizar.addActionListener(e -> atualizarListaPacientes());

        sair.addActionListener(e -> {
            new TelaLogin(unidades);
            dispose();
        });

        setVisible(true);
    }

    private void atualizarListaPacientes() {
        areaPacientes.setText(unidade.getPacientes().listarPacientesTexto());
        areaPacientes.setCaretPosition(0);
    }
}