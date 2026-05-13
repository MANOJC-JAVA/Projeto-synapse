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

        JPanel painel = new JPanel();
        painel.setLayout(null);
        painel.setBackground(new Color(180, 200, 230));

        //  TÍTULO
        JLabel titulo = new JLabel("SYNAPSE - Plataforma de Avaliação Cognitiva");
        titulo.setBounds(40, 30, 420, 30);
        titulo.setFont(new Font("Arial", Font.BOLD, 14));

        //  EMAIL
        JLabel lblUsuario = new JLabel("Email:");
        lblUsuario.setBounds(150, 80, 200, 20);

        JTextField txtUsuario = new JTextField();
        txtUsuario.setBounds(150, 100, 200, 30);

        //  SENHA
        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(150, 140, 200, 20);

        JPasswordField txtSenha = new JPasswordField();
        txtSenha.setBounds(150, 160, 200, 30);

        //  BOTÃO ENTRAR
        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.setBounds(180, 210, 120, 30);

        //  LOGIN FUNCIONANDO
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

        //  BOTÃO CADASTRO
        JButton btnCadastro = new JButton("Cadastrar-se");
        btnCadastro.setBounds(150, 260, 200, 25);

        btnCadastro.addActionListener(e -> {
            new TelaCadastro();
            dispose();
        });

        //  ADICIONAR COMPONENTES
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

    //  MAIN 
    public static void main(String[] args) {

        Sistema.carregarDados();

        new TelaLogin();
    }
    
}