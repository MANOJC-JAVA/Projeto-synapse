package view;

import javax.swing.*;
import java.awt.*;

import controlador.Sistema;
import modelo.Usuario;

public class TelaCadastro extends JFrame {

	public TelaCadastro() {

		setTitle("Cadastro de Pesquisador");

		// TELA CHEIA
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// LAYOUT MANUAL
		setLayout(null);

		// PAINEL PRINCIPAL
		JPanel painel = new JPanel();

		painel.setLayout(null);

		painel.setBounds(0, 0, 1920, 1080);

		painel.setBackground(new Color(200, 210, 230));

		// TÍTULO
		JLabel titulo = new JLabel("Cadastro de Pesquisador");

		titulo.setBounds(760, 80, 400, 40);

		titulo.setFont(new Font("Arial", Font.BOLD, 28));

		// CAMPOS

		JTextField txtNome = new JTextField();

		txtNome.setBounds(650, 180, 500, 40);

		JTextField txtEmail = new JTextField();

		txtEmail.setBounds(650, 270, 500, 40);

		JTextField txtInstituicao = new JTextField();

		txtInstituicao.setBounds(650, 360, 500, 40);

		JTextField txtArea = new JTextField();

		txtArea.setBounds(650, 450, 500, 40);

		JTextField txtRegistro = new JTextField();

		txtRegistro.setBounds(650, 540, 500, 40);

		JPasswordField txtSenha = new JPasswordField();

		txtSenha.setBounds(650, 630, 500, 40);

		JPasswordField txtConfirmar = new JPasswordField();

		txtConfirmar.setBounds(650, 720, 500, 40);

		// LABELS
		addLabel(painel, "Nome:", 650, 150);

		addLabel(painel, "Email:", 650, 240);

		addLabel(painel, "Instituição:", 650, 330);

		addLabel(painel, "Área de atuação:", 650, 420);

		addLabel(painel, "Registro profissional:", 650, 510);

		addLabel(painel, "Senha:", 650, 600);

		addLabel(painel, "Confirmar senha:", 650, 690);

		// BOTÕES

		JButton btnCadastrar = new JButton("Cadastrar");

		btnCadastrar.setBounds(700, 820, 170, 45);

		JButton btnVoltar = new JButton("Voltar");

		btnVoltar.setBounds(930, 820, 170, 45);

		// CADASTRAR
		btnCadastrar.addActionListener(e -> {

			String nome = txtNome.getText();

			String email = txtEmail.getText();

			String senha = new String(txtSenha.getPassword());

			String confirmar = new String(txtConfirmar.getPassword());

			// VALIDAÇÃO
			if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {

				JOptionPane.showMessageDialog(null, "Preencha todos os campos!");

				return;
			}

			// CONFIRMAR SENHA
			if (!senha.equals(confirmar)) {

				JOptionPane.showMessageDialog(null, "As senhas não conferem!");

				return;
			}

			// CADASTRAR
			Usuario u = new Usuario(nome, email, senha);

			boolean sucesso = Sistema.cadastrarUsuario(u);

			if (sucesso) {

				JOptionPane.showMessageDialog(null, "Pesquisador cadastrado!");

				new TelaLogin();

				dispose();

			} else {

				JOptionPane.showMessageDialog(null, "Email já cadastrado!");
			}
		});

		// VOLTAR
		btnVoltar.addActionListener(e -> {

			new TelaLogin();

			dispose();
		});

		// ADD COMPONENTES

		painel.add(titulo);

		painel.add(txtNome);

		painel.add(txtEmail);

		painel.add(txtInstituicao);

		painel.add(txtArea);

		painel.add(txtRegistro);

		painel.add(txtSenha);

		painel.add(txtConfirmar);

		painel.add(btnCadastrar);

		painel.add(btnVoltar);

		add(painel);

		setVisible(true);
	}

	// LABELS
	private void addLabel(JPanel painel, String texto, int x, int y) {

		JLabel lbl = new JLabel(texto);

		lbl.setBounds(x, y, 300, 30);

		lbl.setFont(new Font("Arial", Font.BOLD, 18));

		painel.add(lbl);
	}
}