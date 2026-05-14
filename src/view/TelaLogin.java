package view;

import javax.swing.*;
import java.awt.*;

import controlador.Sistema;

public class TelaLogin extends JFrame {

	public TelaLogin() {

		setTitle("Synapse - Login");

		//  TELA CHEIA
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		//  LAYOUT MANUAL
		setLayout(null);

		//  PAINEL PRINCIPAL
		JPanel painel = new JPanel();

		painel.setLayout(null);

		painel.setBounds(0, 0, 1920, 1080);

		painel.setBackground(new Color(180, 200, 230));

		//  TÍTULO
		JLabel titulo = new JLabel("SYNAPSE - Plataforma de Avaliação Cognitiva");

		titulo.setBounds(620, 120, 700, 40);

		titulo.setFont(new Font("Arial", Font.BOLD, 28));

		//  EMAIL
		JLabel lblUsuario = new JLabel("Email:");

		lblUsuario.setBounds(650, 250, 200, 30);

		lblUsuario.setFont(new Font("Arial", Font.BOLD, 18));

		JTextField txtUsuario = new JTextField();

		txtUsuario.setBounds(650, 290, 500, 45);

		txtUsuario.setFont(new Font("Arial", Font.PLAIN, 18));

		//  SENHA
		JLabel lblSenha = new JLabel("Senha:");

		lblSenha.setBounds(650, 380, 200, 30);

		lblSenha.setFont(new Font("Arial", Font.BOLD, 18));

		JPasswordField txtSenha = new JPasswordField();

		txtSenha.setBounds(650, 420, 500, 45);

		txtSenha.setFont(new Font("Arial", Font.PLAIN, 18));

		//  BOTÃO ENTRAR
		JButton btnEntrar = new JButton("Entrar");

		btnEntrar.setBounds(760, 540, 250, 50);

		btnEntrar.setFont(new Font("Arial", Font.BOLD, 18));

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

		//  BOTÃO CADASTRO
		JButton btnCadastro = new JButton("Cadastrar-se");

		btnCadastro.setBounds(650, 640, 500, 45);

		btnCadastro.setFont(new Font("Arial", Font.BOLD, 16));

		btnCadastro.addActionListener(e -> {

			new TelaCadastro();

			dispose();
		});

		//  ADD COMPONENTES
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