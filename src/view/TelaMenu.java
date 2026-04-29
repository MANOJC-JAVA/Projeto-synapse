package view;

import javax.swing.*;
import java.awt.*;

public class TelaMenu extends JFrame {

    public TelaMenu() {
        setTitle("Synapse - Menu");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel lateral = new JPanel();
        lateral.setBounds(0, 0, 200, 400);
        lateral.setBackground(new Color(120, 150, 200));
        lateral.setLayout(null);

        JButton btnCadastro = new JButton("Cadastrar participante");
        btnCadastro.setBounds(10, 80, 180, 30);

        JButton btnTeste = new JButton("Realizar Avaliação");
        btnTeste.setBounds(10, 130, 180, 30);
        
        btnTeste.addActionListener(e -> {
            new TelaTeste();
            dispose();
        });

        btnCadastro.addActionListener(e -> new TelaCadastroParticipante());
        btnTeste.addActionListener(e -> new TelaTeste());
        
        JButton btnResultado = new JButton("Exibir resultados");
        btnResultado.setBounds(10, 180, 180, 30);

        lateral.add(btnCadastro);
        lateral.add(btnTeste);
        lateral.add(btnResultado);

        JPanel conteudo = new JPanel();
        conteudo.setBounds(200, 0, 500, 400);
        conteudo.setBackground(new Color(210, 220, 240));

        setLayout(null);
        add(lateral);
        add(conteudo);

        setVisible(true);
    }
}