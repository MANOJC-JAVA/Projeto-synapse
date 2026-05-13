package view;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import controlador.Sistema;
import modelo.Resultado;

public class TelaTeste extends JFrame {

    private JLabel lblPalavra;

    private JButton btnVermelho;
    private JButton btnVerde;
    private JButton btnAzul;

    private String[] palavras = {
            "VERMELHO",
            "VERDE",
            "AZUL"
    };

    private Color[] cores = {
            Color.RED,
            Color.GREEN,
            Color.BLUE
    };

    private int rodadas = 0;

    private int totalRodadas = 5;

    private long tempoInicio;

    public TelaTeste() {

        setTitle("Teste Cognitivo");

        setSize(600, 400);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel painel = new JPanel();

        painel.setLayout(null);

        painel.setBackground(
                new Color(210, 220, 240)
        );

        //  TEXTO
        lblPalavra = new JLabel(
                "",
                SwingConstants.CENTER
        );

        lblPalavra.setBounds(
                200,
                80,
                200,
                50
        );

        lblPalavra.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        26
                )
        );

        //  BOTÕES
        btnVermelho = new JButton("VERMELHO");

        btnVerde = new JButton("VERDE");

        btnAzul = new JButton("AZUL");

        btnVermelho.setBounds(
                120,
                200,
                120,
                40
        );

        btnVerde.setBounds(
                250,
                200,
                120,
                40
        );

        btnAzul.setBounds(
                380,
                200,
                120,
                40
        );

        painel.add(lblPalavra);

        painel.add(btnVermelho);

        painel.add(btnVerde);

        painel.add(btnAzul);

        //  AÇÕES
        btnVermelho.addActionListener(
                e -> verificar()
        );

        btnVerde.addActionListener(
                e -> verificar()
        );

        btnAzul.addActionListener(
                e -> verificar()
        );

        add(painel);

        setVisible(true);

        iniciar();
    }

    //  INICIAR
    private void iniciar() {

        tempoInicio =
                System.currentTimeMillis();

        proximaRodada();
    }

    //  RODADAS
    private void proximaRodada() {

        if (rodadas >= totalRodadas) {

            finalizar();

            return;
        }

        Random r = new Random();

        int palavraIndex =
                r.nextInt(3);

        int corIndex =
                r.nextInt(3);

        lblPalavra.setText(
                palavras[palavraIndex]
        );

        lblPalavra.setForeground(
                cores[corIndex]
        );

        rodadas++;
    }

    //  VERIFICAR
    private void verificar() {

        proximaRodada();
    }

    // FINALIZAR
    private void finalizar() {

        long tempo =
                System.currentTimeMillis()
                        - tempoInicio;

        if (Sistema.participanteAtual == null) {

            JOptionPane.showMessageDialog(
                    null,
                    "Nenhum participante encontrado!"
            );

            return;
        }

        //  CRIA RESULTADO
        Resultado r =
                new Resultado(
                        Sistema.participanteAtual.getNome(),
                        tempo
                );

        //  ADICIONA
        Sistema.listaResultados.add(r);

        //  DEBUG
        System.out.println(
                "RESULTADOS NA LISTA: "
                + Sistema.listaResultados.size()
        );

        //  SALVA
        Sistema.salvarDados();

        //  RESULTADO
        new TelaResultado(tempo);

        dispose();
    }
}