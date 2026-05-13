package view;

import javax.swing.*;
import java.awt.*;

public class TelaResultado extends JFrame {

    public TelaResultado(long tempo) {
        setTitle("Resultado");
        setSize(600, 400);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JLabel lbl = new JLabel("Tempo: " + tempo + " ms", SwingConstants.CENTER);
        lbl.setFont(new Font("Arial", Font.BOLD, 24));

        add(lbl, BorderLayout.CENTER);

        JButton btn = new JButton("Voltar");
        btn.addActionListener(e -> {
            new TelaMenu();
            dispose();
        });

        add(btn, BorderLayout.SOUTH);

        setVisible(true);
    }
}