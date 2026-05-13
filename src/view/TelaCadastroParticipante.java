package view;

import javax.swing.*;
import java.awt.*;
import controlador.Sistema;
import modelo.Participante;

public class TelaCadastroParticipante extends JFrame {

    public TelaCadastroParticipante() {
        setTitle("Cadastro de Participante");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(null);

        getContentPane().setBackground(new Color(200, 210, 230));

        JLabel titulo = new JLabel("Cadastro de Participante");
        titulo.setBounds(200, 20, 250, 30);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(150, 80, 100, 20);

        JTextField txtNome = new JTextField();
        txtNome.setBounds(150, 100, 300, 25);

        JLabel lblIdade = new JLabel("Idade:");
        lblIdade.setBounds(150, 140, 100, 20);

        JTextField txtIdade = new JTextField();
        txtIdade.setBounds(150, 160, 300, 25);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(180, 230, 120, 30);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(320, 230, 120, 30);

        //  CADASTRAR DE VERDADE
        btnCadastrar.addActionListener(e -> {
            String nome = txtNome.getText();
            String idade = txtIdade.getText();

            if (nome.isEmpty() || idade.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
                return;
            }

            //  cria participante
            Participante p = new Participante(nome);

            //  salva no sistema
            Sistema.participantes.add(p);
            Sistema.participanteAtual = p;

            JOptionPane.showMessageDialog(null, "Participante cadastrado!");

            //  vai para instruções
            new TelaInstrucoes();
            dispose();
        });

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