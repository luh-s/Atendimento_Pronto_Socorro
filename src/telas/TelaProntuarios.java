package Telas;

import javax.swing.*;
import Modelos.*;
import java.awt.*;

public class TelaProntuarios extends JFrame {

    private UnidadeAtendimento unidade;
    private ArrayUnidades unidades;
    private JTextArea areaTexto;

    public TelaProntuarios(UnidadeAtendimento unidade, ArrayUnidades unidades) {
        this.unidade = unidade;
        this.unidades = unidades;

        setTitle("Prontuários - " + unidade.getNome());
        setSize(760, 520);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel painelPrincipal = new JPanel(new BorderLayout(15, 15));
        painelPrincipal.setBackground(EstiloTelas.FUNDO);
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(painelPrincipal);

        JPanel topo = EstiloTelas.criarCard();
        topo.setLayout(new BorderLayout());

        JLabel titulo = EstiloTelas.criarTitulo("Navegação de Prontuários");
        JLabel subtitulo = EstiloTelas.criarSubtitulo("Use os botões para ir e voltar entre os prontuários");

        JPanel textos = new JPanel();
        textos.setBackground(EstiloTelas.PAINEL);
        textos.setLayout(new BoxLayout(textos, BoxLayout.Y_AXIS));
        textos.add(titulo);
        textos.add(Box.createVerticalStrut(6));
        textos.add(subtitulo);

        topo.add(textos, BorderLayout.WEST);
        painelPrincipal.add(topo, BorderLayout.NORTH);

        areaTexto = EstiloTelas.criarAreaTexto();
        areaTexto.setBackground(EstiloTelas.PAINEL);
        areaTexto.setForeground(EstiloTelas.TEXTO);

        JScrollPane scroll = new JScrollPane(areaTexto);
        painelPrincipal.add(scroll, BorderLayout.CENTER);

        JPanel rodape = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        rodape.setBackground(EstiloTelas.FUNDO);

        JButton btnPrimeiro = EstiloTelas.criarBotaoSecundario("Primeiro");
        JButton btnAnterior = EstiloTelas.criarBotaoSecundario("Anterior");
        JButton btnProximo = EstiloTelas.criarBotaoPrimario("Próximo");
        JButton btnUltimo = EstiloTelas.criarBotaoSecundario("Último");
        JButton btnVoltar = EstiloTelas.criarBotaoSecundario("Voltar");

        rodape.add(btnPrimeiro);
        rodape.add(btnAnterior);
        rodape.add(btnProximo);
        rodape.add(btnUltimo);
        rodape.add(btnVoltar);

        painelPrincipal.add(rodape, BorderLayout.SOUTH);

        if (unidade.temProntuarios()) {
            areaTexto.setText(unidade.abrirUltimoProntuarioTexto());
        } else {
            areaTexto.setText("Nenhum prontuário finalizado ainda.");
        }

        btnPrimeiro.addActionListener(e -> {
            areaTexto.setText(unidade.abrirPrimeiroProntuarioTexto());
            areaTexto.setCaretPosition(0);
        });

        btnAnterior.addActionListener(e -> {
            areaTexto.setText(unidade.voltarProntuarioTexto());
            areaTexto.setCaretPosition(0);
        });

        btnProximo.addActionListener(e -> {
            areaTexto.setText(unidade.avancarProntuarioTexto());
            areaTexto.setCaretPosition(0);
        });

        btnUltimo.addActionListener(e -> {
            areaTexto.setText(unidade.abrirUltimoProntuarioTexto());
            areaTexto.setCaretPosition(0);
        });

        btnVoltar.addActionListener(e -> {
            new TelaPrincipal(unidade, unidades);
            dispose();
        });

        setVisible(true);
    }
}