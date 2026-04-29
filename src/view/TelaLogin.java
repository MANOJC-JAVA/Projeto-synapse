package view;

import javax.swing.*;
import java.awt.*;


public class TelaLogin extends JFrame {

	
    public TelaLogin() {
        setTitle("Synapse - Login");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel painel = new JPanel();
        painel.setLayout(null);
        painel.setBackground(new Color(180, 200, 230));

        JLabel titulo = new JLabel("SYNAPSE - Plataforma de Avaliação Cognitiva");
        titulo.setBounds(50, 30, 400, 30);

        JTextField txtUsuario = new JTextField();
        txtUsuario.setBounds(150, 100, 200, 30);

        JPasswordField txtSenha = new JPasswordField();
        txtSenha.setBounds(150, 140, 200, 30);

        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.setBounds(180, 200, 120, 30);
        
        btnEntrar.addActionListener(e -> {
            new TelaMenu();
            dispose();
        });

        JButton btnCadastro = new JButton("Cadastrar-se");
        btnCadastro.setBounds(150, 250, 200, 25);
        
        btnCadastro.addActionListener(e -> {
            new TelaCadastro();
            dispose();
        });

        painel.add(titulo);
        painel.add(txtUsuario);
        painel.add(txtSenha);
        painel.add(btnEntrar);
        painel.add(btnCadastro);

        add(painel);
        setVisible(true);
    }
    public static void main(String[] args) {
        new TelaLogin();
    }
}