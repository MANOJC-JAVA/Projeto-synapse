package view;

import javax.swing.*;
import java.awt.*;

public class TelaInstrucoes extends JFrame {

    public TelaInstrucoes() {

        setTitle("Instruções");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        //  TÍTULO
        JLabel titulo = new JLabel(
                "Instruções do Teste Cognitivo",
                SwingConstants.CENTER
        );

        titulo.setFont(new Font("Arial", Font.BOLD, 20));

        add(titulo, BorderLayout.NORTH);

        //  TEXTO
        JTextArea texto = new JTextArea();

        texto.setEditable(false);

        texto.setFont(new Font("Arial", Font.PLAIN, 16));

        texto.setText(
                "Leia atentamente:\n\n"
                + "- Uma palavra aparecerá na tela.\n"
                + "- A palavra terá uma cor diferente.\n"
                + "- Clique na COR da palavra.\n"
                + "- Seja rápido.\n"
                + "- O sistema calculará seu tempo.\n\n"
                + "Clique em 'Iniciar Teste' para começar."
        );

        add(new JScrollPane(texto), BorderLayout.CENTER);

        //  BOTÃO
        JPanel painel = new JPanel();

        JButton btnIniciar = new JButton("Iniciar Teste");

        painel.add(btnIniciar);

        add(painel, BorderLayout.SOUTH);

        //  INICIAR
        btnIniciar.addActionListener(e -> {

            new TelaTeste();

            dispose();
        });

        setVisible(true);
    }
}