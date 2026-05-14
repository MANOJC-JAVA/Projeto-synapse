package view;

import javax.swing.*;
import java.awt.*;

import controlador.Sistema;
import modelo.Participante;

public class TelaCadastroParticipante extends JFrame {

	public TelaCadastroParticipante() {

		setTitle("Cadastro de Participante");

		setExtendedState(JFrame.MAXIMIZED_BOTH);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setLayout(null);

		// painel principal
		JPanel painel = new JPanel();

		painel.setLayout(null);

		painel.setBounds(0, 0, 1920, 1080);

		painel.setBackground(new Color(200, 210, 230));

		// título
		JLabel titulo = new JLabel("Cadastro de Participante");

		titulo.setBounds(700, 100, 500, 50);

		titulo.setFont(new Font("Arial", Font.BOLD, 32));

		// label nome
		JLabel lblNome = new JLabel("Nome:");

		lblNome.setBounds(620, 240, 200, 30);

		lblNome.setFont(new Font("Arial", Font.BOLD, 20));

		// campo nome
		JTextField txtNome = new JTextField();

		txtNome.setBounds(620, 280, 600, 45);

		txtNome.setFont(new Font("Arial", Font.PLAIN, 18));

		// label idade
		JLabel lblIdade = new JLabel("Idade:");

		lblIdade.setBounds(620, 380, 200, 30);

		lblIdade.setFont(new Font("Arial", Font.BOLD, 20));

		// campo idade
		JTextField txtIdade = new JTextField();

		txtIdade.setBounds(620, 420, 600, 45);

		txtIdade.setFont(new Font("Arial", Font.PLAIN, 18));

		// botão cadastrar
		JButton btnCadastrar = new JButton("Cadastrar");

		btnCadastrar.setBounds(680, 560, 200, 50);

		btnCadastrar.setFont(new Font("Arial", Font.BOLD, 18));

		// botão voltar
		JButton btnVoltar = new JButton("Voltar");

		btnVoltar.setBounds(960, 560, 200, 50);

		btnVoltar.setFont(new Font("Arial", Font.BOLD, 18));

		// ação cadastrar
		btnCadastrar.addActionListener(e -> {

			String nome = txtNome.getText();

			String idade = txtIdade.getText();

			// verifica campos vazios
			if (nome.isEmpty() || idade.isEmpty()) {

				JOptionPane.showMessageDialog(null, "Preencha todos os campos!");

				return;
			}

			// cria participante
			Participante p = new Participante(nome);

			// salva participante
			Sistema.participantes.add(p);

			Sistema.participanteAtual = p;

			Sistema.salvarDados();

			JOptionPane.showMessageDialog(null, "Participante cadastrado!");

			// abre instruções
			new TelaInstrucoes();

			dispose();
		});

		// ação voltar
		btnVoltar.addActionListener(e -> {

			new TelaMenu();

			dispose();
		});

		// adiciona componentes
		painel.add(titulo);

		painel.add(lblNome);

		painel.add(txtNome);

		painel.add(lblIdade);

		painel.add(txtIdade);

		painel.add(btnCadastrar);

		painel.add(btnVoltar);

		add(painel);

		setVisible(true);
	}
}