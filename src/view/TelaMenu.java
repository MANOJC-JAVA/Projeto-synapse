package view;

import javax.swing.*;
import java.awt.*;

import controlador.Sistema;

public class TelaMenu extends JFrame {

	public TelaMenu() {

		setTitle("Synapse - Menu");

		setExtendedState(JFrame.MAXIMIZED_BOTH);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setLayout(null);

		// painel lateral
		JPanel lateral = new JPanel();

		lateral.setLayout(null);

		lateral.setBounds(0, 0, 350, 1080);

		lateral.setBackground(new Color(120, 150, 200));

		// pega nome do usuário logado
		String nomeUsuario = "Usuário";

		if (Sistema.usuarioLogado != null) {
			nomeUsuario = Sistema.usuarioLogado.getNome();
		}

		// texto do usuário
		JLabel lblUsuario = new JLabel("Olá, " + nomeUsuario);

		lblUsuario.setBounds(30, 30, 250, 40);

		lblUsuario.setFont(new Font("Arial", Font.BOLD, 24));

		lblUsuario.setForeground(Color.WHITE);

		// botão cadastrar participante
		JButton btnCadastro = new JButton("Cadastrar participante");

		btnCadastro.setBounds(40, 140, 260, 55);

		btnCadastro.setFont(new Font("Arial", Font.BOLD, 18));

		// botão avaliação
		JButton btnTeste = new JButton("Realizar Avaliação");

		btnTeste.setBounds(40, 230, 260, 55);

		btnTeste.setFont(new Font("Arial", Font.BOLD, 18));

		// botão resultados
		JButton btnResultado = new JButton("Exibir resultados");

		btnResultado.setBounds(40, 320, 260, 55);

		btnResultado.setFont(new Font("Arial", Font.BOLD, 18));

		// botão gerenciar
		JButton btnGerenciar = new JButton("Gerenciar resultados");

		btnGerenciar.setBounds(40, 410, 260, 55);

		btnGerenciar.setFont(new Font("Arial", Font.BOLD, 18));

		// botão sair
		JButton btnSair = new JButton("Sair");

		btnSair.setBounds(40, 900, 260, 55);

		btnSair.setFont(new Font("Arial", Font.BOLD, 18));

		// ações dos botões

		btnCadastro.addActionListener(e -> {

			new TelaCadastroParticipante();

			dispose();
		});

		btnTeste.addActionListener(e -> {

			new TelaTeste();

			dispose();
		});

		btnResultado.addActionListener(e -> {

			new TelaExibirResultado();

			dispose();
		});

		btnGerenciar.addActionListener(e -> {

			new TelaGerenciarResultados();

			dispose();
		});

		btnSair.addActionListener(e -> {

			new TelaLogin();

			dispose();
		});

		// adiciona componentes na lateral
		lateral.add(lblUsuario);

		lateral.add(btnCadastro);

		lateral.add(btnTeste);

		lateral.add(btnResultado);

		lateral.add(btnGerenciar);

		lateral.add(btnSair);

		// painel principal
		JPanel conteudo = new JPanel();

		conteudo.setLayout(null);

		conteudo.setBounds(350, 0, 1600, 1080);

		conteudo.setBackground(new Color(210, 220, 240));

		// título principal
		JLabel titulo = new JLabel("Bem-vindo ao Sistema Synapse");

		titulo.setBounds(420, 250, 700, 50);

		titulo.setFont(new Font("Arial", Font.BOLD, 34));

		// subtítulo
		JLabel subtitulo = new JLabel("Sistema de Avaliação Cognitiva");

		subtitulo.setBounds(430, 330, 600, 40);

		subtitulo.setFont(new Font("Arial", Font.PLAIN, 24));

		// adiciona no conteúdo
		conteudo.add(titulo);

		conteudo.add(subtitulo);

		// adiciona painéis na tela
		add(lateral);

		add(conteudo);

		setVisible(true);
	}
}