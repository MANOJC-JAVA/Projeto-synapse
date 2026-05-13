package view;

import javax.swing.*;
import java.awt.*;
import controlador.Sistema;

public class TelaResultado extends JFrame {

    public TelaResultado(long tempo) {
        setTitle("Resultado");
        setSize(500, 300);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(null);
        painel.setBackground(new Color(200, 210, 230));

        JLabel titulo = new JLabel("Resultado do Teste", SwingConstants.CENTER);
        titulo.setBounds(150, 30, 200, 30);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));

        //  Nome do participante
        String nome = (Sistema.participanteAtual != null)
                ? Sistema.participanteAtual.getNome()
                : "Desconhecido";

        JLabel lblNome = new JLabel("Participante: " + nome, SwingConstants.CENTER);
        lblNome.setBounds(150, 70, 200, 30);

        JLabel lblTempo = new JLabel("Tempo total: " + tempo + " ms", SwingConstants.CENTER);
        lblTempo.setBounds(150, 110, 200, 30);

        JButton btnVoltar = new JButton("Voltar ao Menu");
        btnVoltar.setBounds(170, 170, 150, 30);

        btnVoltar.addActionListener(e -> {
            new TelaMenu();
            dispose();
        });

        painel.add(titulo);
        painel.add(lblNome);
        painel.add(lblTempo);
        painel.add(btnVoltar);

        add(painel);
        setVisible(true);
    }
}