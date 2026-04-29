package view;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class TelaTeste extends JFrame {

    JLabel lblPalavra;
    JButton btnVermelho, btnVerde, btnAzul;

    String[] palavras = {"VERMELHO", "VERDE", "AZUL"};
    Color[] cores = {Color.RED, Color.GREEN, Color.BLUE};

    int indiceCorCorreta;
    int rodadas = 0;
    int totalRodadas = 5;
    long tempoInicio;

    public TelaTeste() {
        setTitle("Teste Cognitivo");
        setSize(600, 400);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(null);
        painel.setBackground(new Color(210, 220, 240));

        lblPalavra = new JLabel("", SwingConstants.CENTER);
        lblPalavra.setBounds(200, 80, 200, 50);
        lblPalavra.setFont(new Font("Arial", Font.BOLD, 26));

        btnVermelho = new JButton("VERMELHO");
        btnVerde = new JButton("VERDE");
        btnAzul = new JButton("AZUL");

        btnVermelho.setBounds(120, 200, 120, 40);
        btnVerde.setBounds(250, 200, 120, 40);
        btnAzul.setBounds(380, 200, 120, 40);

        painel.add(lblPalavra);
        painel.add(btnVermelho);
        painel.add(btnVerde);
        painel.add(btnAzul);

        btnVermelho.addActionListener(e -> verificar(Color.RED));
        btnVerde.addActionListener(e -> verificar(Color.GREEN));
        btnAzul.addActionListener(e -> verificar(Color.BLUE));

        add(painel);
        setVisible(true);

        iniciar();
    }

    private void iniciar() {
        tempoInicio = System.currentTimeMillis();
        proximaRodada();
    }

    private void proximaRodada() {
        if (rodadas >= totalRodadas) {
            finalizar();
            return;
        }

        Random r = new Random();

        int palavraIndex = r.nextInt(3);
        int corIndex = r.nextInt(3);

        lblPalavra.setText(palavras[palavraIndex]);
        lblPalavra.setForeground(cores[corIndex]);

        indiceCorCorreta = corIndex;
        rodadas++;
    }

    private void verificar(Color cor) {
        proximaRodada();
    }

    private void finalizar() {
        long tempoTotal = System.currentTimeMillis() - tempoInicio;

        new TelaResultado(tempoTotal);

        dispose();
    }
}