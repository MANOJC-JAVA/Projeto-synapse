package view;

import javax.swing.*;
import java.awt.*;

public class TelaCadastroParticipante extends JFrame {

    public TelaCadastroParticipante() {
        setTitle("Cadastro de Participante");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(null);

        getContentPane().setBackground(new Color(200, 210, 230));

        JLabel titulo = new JLabel("Cadastro de Participante");
        titulo.setBounds(200, 20, 200, 30);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(150, 80, 100, 20);

        JTextField txtNome = new JTextField();
        txtNome.setBounds(150, 100, 300, 25);

        JLabel lblIdade = new JLabel("Idade:");
        lblIdade.setBounds(150, 140, 100, 20);

        JTextField txtIdade = new JTextField();
        txtIdade.setBounds(150, 160, 300, 25);

        // BOTÃO CADASTRAR
        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(180, 230, 120, 30);

        // BOTÃO VOLTAR
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(320, 230, 120, 30);

        // AÇÃO DO CADASTRAR
        btnCadastrar.addActionListener(e -> {
            String nome = txtNome.getText();
            String idade = txtIdade.getText();

            if (nome.isEmpty() || idade.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
                return;
            }

            JOptionPane.showMessageDialog(null, "Participante cadastrado!");

            new TelaInstrucoes(); // vai pra instruções
            dispose();
        });

        //  VOLTAR
        btnVoltar.addActionListener(e -> {
            new TelaMenu();
            dispose();
        });

        add(titulo);
        add(lblNome);
        add(txtNome);
        add(lblIdade);
        add(txtIdade);
        add(btnCadastrar);
        add(btnVoltar);

        setVisible(true);
    }
}