package view;

import javax.swing.*;
import java.awt.*;

import controlador.Sistema;
import modelo.Resultado;

public class TelaExibirResultado extends JFrame {

    public TelaExibirResultado() {

        setTitle("Resultados");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        //  TÍTULO
        JLabel titulo = new JLabel(
                "Resultados dos Testes",
                SwingConstants.CENTER
        );

        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        add(titulo, BorderLayout.NORTH);

        //  ÁREA DE TEXTO
        JTextArea area = new JTextArea();

        area.setEditable(false);
        area.setFont(new Font("Arial", Font.PLAIN, 16));

        //  MOSTRAR RESULTADOS
        if (Sistema.listaResultados.isEmpty()) {

            area.append("Nenhum resultado registrado.");

        } else {

            int posicao = 1;

            for (Resultado r : Sistema.listaResultados) {

                area.append(
                        posicao + "º Lugar - "
                        + r.getNomeParticipante()
                        + " | Tempo: "
                        + r.getTempo()
                        + " ms\n\n"
                );

                posicao++;
            }
        }

        JScrollPane scroll = new JScrollPane(area);

        add(scroll, BorderLayout.CENTER);

        //  BOTÃO VOLTAR
        JPanel painelBotao = new JPanel();

        JButton btnVoltar = new JButton("Voltar");

        painelBotao.add(btnVoltar);

        add(painelBotao, BorderLayout.SOUTH);

        //  VOLTAR
        btnVoltar.addActionListener(e -> {

            new TelaMenu();

            dispose();
        });

        setVisible(true);
    }
}