package view;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.Comparator;
import controlador.Sistema;
import modelo.Resultado;

public class TelaExibirResultado extends JFrame {

    public TelaExibirResultado() {
        setTitle("Resultados");
        setSize(450, 350);
        setLocationRelativeTo(null);
        setLayout(null);

        JTextArea area = new JTextArea();
        area.setBounds(20, 20, 390, 220);
        area.setEditable(false);
        area.setFont(new Font("Arial", Font.PLAIN, 14));

        JScrollPane scroll = new JScrollPane(area);
        scroll.setBounds(20, 20, 390, 220);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(150, 260, 120, 30);

        //  voltar pro menu
        btnVoltar.addActionListener(e -> {
            new TelaMenu();
            dispose();
        });

        //  ordenar do menor tempo (melhor)
        Collections.sort(Sistema.listaResultados, Comparator.comparingLong(Resultado::getTempo));

        if (Sistema.listaResultados.isEmpty()) {
            area.append("Nenhum resultado registrado.");
        } else {
            int pos = 1;

            for (Resultado r : Sistema.listaResultados) {
                area.append(
                    pos + "º - " +
                    r.getNomeParticipante() + " - " +
                    r.getTempo() + " ms\n"
                );
                pos++;
            }
        }

        add(scroll);
        add(btnVoltar);

        setVisible(true);
    }
}