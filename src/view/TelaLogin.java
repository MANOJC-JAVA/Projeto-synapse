package view;

import javax.swing.*;
import java.awt.*;
import controlador.Sistema;

public class TelaLogin extends JFrame {

    public TelaLogin() {
        setTitle("Synapse - Login");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JPanel painel = new JPanel();
        painel.setLayout(null);
        painel.setBackground(new Color(180, 200, 230));
        painel.setBounds(0, 0, 500, 400);

        JLabel titulo = new JLabel("SYNAPSE - Plataforma de Avaliação Cognitiva");
        titulo.setBounds(50, 30, 400, 30);

        JLabel lblUsuario = new JLabel("Email:");
        lblUsuario.setBounds(150, 80, 100, 20);

        JTextField txtUsuario = new JTextField();
        txtUsuario.setBounds(150, 100, 200, 30);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(150, 130, 100, 20);

        JPasswordField txtSenha = new JPasswordField();
        txtSenha.setBounds(150, 150, 200, 30);

        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.setBounds(180, 200, 120, 30);

        JButton btnCadastro = new JButton("Cadastrar-se (Pesquisador)");
        btnCadastro.setBounds(150, 250, 200, 25);

        //  LOGIN
        btnEntrar.addActionListener(e -> {

            String email = txtUsuario.getText();
            String senha = new String(txtSenha.getPassword());

            if (Sistema.autenticar(email, senha)) {
                new TelaMenu();
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Email ou senha inválidos!");
            }
        });

        //  IR PARA CADASTRO
        btnCadastro.addActionListener(e -> {
            new TelaCadastro();
            dispose();
        });

        painel.add(titulo);
        painel.add(lblUsuario);
        painel.add(txtUsuario);
        painel.add(lblSenha);
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