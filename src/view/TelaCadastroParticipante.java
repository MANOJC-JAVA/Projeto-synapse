package view;

import javax.swing.*;
import java.awt.*;

public class TelaCadastroParticipante extends JFrame {

    public TelaCadastroParticipante() {
        setTitle("Cadastrar Participante");
        setSize(600, 400);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(null);
        painel.setBackground(new Color(200, 210, 230));

        JLabel titulo = new JLabel("Cadastro de Participante");
        titulo.setBounds(200, 20, 200, 30);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(150, 80, 100, 20);

        JTextField txtNome = new JTextField();
        txtNome.setBounds(150, 100, 300, 25);

        JLabel lblIdade = new JLabel("Idade:");
        lblIdade.setBounds(150, 140, 100, 20);

        JTextField txtIdade = new JTextField();
        txtIdade.setBounds(150, 160, 300, 25);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(230, 220, 120, 30);

        painel.add(titulo);
        painel.add(lblNome);
        painel.add(txtNome);
        painel.add(lblIdade);
        painel.add(txtIdade);
        painel.add(btnSalvar);

        add(painel);
        setVisible(true);
    }
}