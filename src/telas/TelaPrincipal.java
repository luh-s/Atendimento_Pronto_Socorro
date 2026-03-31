package Telas;

import javax.swing.*;
import Modelos.*;
import java.awt.*;

public class TelaPrincipal extends JFrame {

    private UnidadeAtendimento unidade;
    private ArrayUnidades unidades;
    private JTextArea areaSaida;

    public TelaPrincipal(UnidadeAtendimento unidade, ArrayUnidades unidades) {
        this.unidade = unidade;
        this.unidades = unidades;

        setTitle("Sistema - " + unidade.getNome());
        setSize(980, 580);
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
        titulo.setForeground(EstiloTelas.TEXTO);

        JLabel subtitulo = new JLabel("Fluxo completo do pronto-socorro");
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

        JPanel painelMenu = new JPanel(new GridLayout(7, 1, 8, 8));
        painelMenu.setBackground(EstiloTelas.PAINEL);
        painelMenu.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JButton btnCadastrar = EstiloTelas.criarBotaoPrimario("Cadastrar Paciente");
        JButton btnListar = EstiloTelas.criarBotaoSecundario("Listar Pacientes");
        JButton btnFila = EstiloTelas.criarBotaoSecundario("Exibir Fila");
        JButton btnChamar = EstiloTelas.criarBotaoSecundario("Chamar Próximo");
        JButton btnFinalizar = EstiloTelas.criarBotaoSecundario("Finalizar Atendimento");
        JButton btnHistorico = EstiloTelas.criarBotaoSecundario("Exibir Histórico");
        JButton btnProntuarios = EstiloTelas.criarBotaoSecundario("Navegar Prontuários");

        painelMenu.add(btnCadastrar);
        painelMenu.add(btnListar);
        painelMenu.add(btnFila);
        painelMenu.add(btnChamar);
        painelMenu.add(btnFinalizar);
        painelMenu.add(btnHistorico);
        painelMenu.add(btnProntuarios);

        painelPrincipal.add(painelMenu, BorderLayout.WEST);

        areaSaida = EstiloTelas.criarAreaTexto();
        areaSaida.setBackground(EstiloTelas.PAINEL);
        areaSaida.setForeground(EstiloTelas.TEXTO);
        areaSaida.setCaretColor(EstiloTelas.TEXTO);
        areaSaida.setText("Selecione uma ação no menu ao lado.");

        JScrollPane scroll = new JScrollPane(areaSaida);
        scroll.getViewport().setBackground(EstiloTelas.PAINEL);
        painelPrincipal.add(scroll, BorderLayout.CENTER);

        JPanel rodape = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        rodape.setBackground(EstiloTelas.FUNDO);

        JButton btnSair = EstiloTelas.criarBotaoSecundario("Sair");
        rodape.add(btnSair);

        painelPrincipal.add(rodape, BorderLayout.SOUTH);

        btnCadastrar.addActionListener(e -> {
            new TelaCadastroPaciente(unidade, unidades);
            dispose();
        });

        btnListar.addActionListener(e -> {
            areaSaida.setText(unidade.listarPacientesTexto());
            areaSaida.setCaretPosition(0);
        });

        btnFila.addActionListener(e -> {
            areaSaida.setText(unidade.exibirFilaTexto());
            areaSaida.setCaretPosition(0);
        });

        btnChamar.addActionListener(e -> chamarProximoPacienteComMedico());

        btnFinalizar.addActionListener(e -> {
            if (!unidade.temPacienteEmAtendimento()) {
                JOptionPane.showMessageDialog(this, "Nenhum paciente em atendimento.");
                return;
            }

            new TelaFinalizarAtendimento(unidade, unidades);
            dispose();
        });

        btnHistorico.addActionListener(e -> {
            areaSaida.setText(unidade.exibirHistoricoTexto());
            areaSaida.setCaretPosition(0);
        });

        btnProntuarios.addActionListener(e -> navegarProntuarios());

        btnSair.addActionListener(e -> {
            new TelaLogin(unidades);
            dispose();
        });

        setVisible(true);
    }

    private void chamarProximoPacienteComMedico() {
        if (unidade.temPacienteEmAtendimento()) {
            JOptionPane.showMessageDialog(this, "Já existe paciente em atendimento.");
            areaSaida.setText(unidade.exibirPacienteAtualTexto());
            areaSaida.setCaretPosition(0);
            return;
        }

        String medico = JOptionPane.showInputDialog(
                this,
                "Informe o nome do médico responsável pelo atendimento:",
                "Médico do atendimento",
                JOptionPane.PLAIN_MESSAGE
        );

        if (medico == null) {
            return;
        }

        medico = medico.trim();

        if (medico.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe o nome do médico antes de chamar o paciente.");
            return;
        }

        Paciente chamado = unidade.chamarProximoPaciente(medico);

        if (chamado == null) {
            JOptionPane.showMessageDialog(this, "Fila vazia ou médico não informado.");
            return;
        }

        JOptionPane.showMessageDialog(this,
                "Paciente chamado: " + chamado.getNome() + "\nMédico responsável: " + medico);

        areaSaida.setText(unidade.exibirPacienteAtualTexto());
        areaSaida.setCaretPosition(0);
    }

    private void navegarProntuarios() {
        if (!unidade.temProntuarios()) {
            JOptionPane.showMessageDialog(this, "Nenhum prontuário finalizado ainda.");
            return;
        }

        areaSaida.setText(unidade.abrirUltimoProntuarioTexto());
        areaSaida.setCaretPosition(0);

        String[] opcoes = {"Primeiro", "Anterior", "Próximo", "Último", "Fechar"};

        while (true) {
            int escolha = JOptionPane.showOptionDialog(
                    this,
                    "Escolha uma ação para navegar pelos prontuários.",
                    "Navegar Prontuários",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    opcoes,
                    opcoes[4]
            );

            if (escolha == 0) {
                areaSaida.setText(unidade.abrirPrimeiroProntuarioTexto());
            } else if (escolha == 1) {
                areaSaida.setText(unidade.voltarProntuarioTexto());
            } else if (escolha == 2) {
                areaSaida.setText(unidade.avancarProntuarioTexto());
            } else if (escolha == 3) {
                areaSaida.setText(unidade.abrirUltimoProntuarioTexto());
            } else {
                break;
            }

            areaSaida.setCaretPosition(0);
        }
    }
}