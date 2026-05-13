package view;

import javax.swing.*;
import java.awt.*;

public class TelaInstrucoes extends JFrame {

    public TelaInstrucoes() {
        setTitle("Instruções do Teste");
        setSize(574, 404);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        getContentPane().setBackground(new Color(210, 220, 240));

        JLabel titulo = new JLabel("Instruções", SwingConstants.CENTER);
        titulo.setBounds(150, 20, 200, 30);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));

        JTextArea texto = new JTextArea();
        texto.setText(
                "Você verá palavras com cores diferentes.\n\n" +
                "Sua tarefa é clicar na COR do texto,\n" +
                "não na palavra escrita.\n\n" +
                "Exemplo:\nSe estiver escrito 'AZUL' em vermelho,\n" +
                "clique no botão VERMELHO.\n\n" +
                "Responda o mais rápido possível!"
        );

        texto.setBounds(80, 70, 334, 223);
        texto.setEditable(false);
        texto.setBackground(new Color(210, 220, 240));

        JButton btnComecar = new JButton("Começar Teste");
        btnComecar.setBounds(150, 324, 200, 30);

        btnComecar.addActionListener(e -> {
            new TelaTeste();
            dispose();
        });

        getContentPane().add(titulo);
        getContentPane().add(texto);
        getContentPane().add(btnComecar);

        setVisible(true);
    }
}