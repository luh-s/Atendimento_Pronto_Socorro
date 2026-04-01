package Telas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class EstiloTelas {

    public static final Color FUNDO = new Color(24, 26, 27);
    public static final Color PAINEL = new Color(38, 40, 42);
    public static final Color PRIMARIA = new Color(76, 145, 255);
    public static final Color PRIMARIA_ESCURO = new Color(50, 110, 200);

    public static final Color TEXTO = new Color(230, 230, 230);
    public static final Color TEXTO_CLARO = new Color(170, 170, 170);

    public static JPanel criarPainelBase() {
        JPanel painel = new JPanel();
        painel.setBackground(FUNDO);
        painel.setLayout(new GridBagLayout());
        return painel;
    }

    public static JPanel criarCard() {
        JPanel card = new JPanel();
        card.setBackground(PAINEL);
        card.setLayout(new GridBagLayout());
        card.setBorder(new EmptyBorder(25, 25, 25, 25));
        return card;
    }

    public static JLabel criarTitulo(String texto) {
        JLabel titulo = new JLabel(texto);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titulo.setForeground(TEXTO);
        return titulo;
    }

    public static JLabel criarSubtitulo(String texto) {
        JLabel subtitulo = new JLabel(texto);
        subtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        subtitulo.setForeground(TEXTO_CLARO);
        return subtitulo;
    }

    public static JLabel criarLabel(String texto) {
        JLabel label = new JLabel(texto);
        label.setFont(new Font("Segoe UI", Font.BOLD, 13));
        label.setForeground(TEXTO);
        return label;
    }

    public static JTextField criarCampo() {
        JTextField campo = new JTextField(18);
        campo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        return campo;
    }

    public static JPasswordField criarCampoSenha() {
        JPasswordField campo = new JPasswordField(18);
        campo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        return campo;
    }

    public static JButton criarBotaoPrimario(String texto) {
        JButton botao = new JButton(texto);
        botao.setFont(new Font("Segoe UI", Font.BOLD, 13));
        botao.setBackground(PRIMARIA);
        botao.setForeground(Color.WHITE);
        botao.setFocusPainted(false);
        return botao;
    }

    public static JButton criarBotaoSecundario(String texto) {
        JButton botao = new JButton(texto);
        botao.setFont(new Font("Segoe UI", Font.BOLD, 13));
        botao.setBackground(new Color(60, 63, 65));
        botao.setForeground(TEXTO);
        botao.setFocusPainted(false);
        return botao;
    }

    public static JTextArea criarAreaTexto() {
        JTextArea area = new JTextArea();
        area.setFont(new Font("Monospaced", Font.PLAIN, 13));
        area.setForeground(TEXTO);
        area.setEditable(false);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        return area;
    }
}