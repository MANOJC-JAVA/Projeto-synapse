package view;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import controlador.Sistema;
import modelo.Resultado;

public class TelaTeste extends JFrame {

	private JLabel lblTitulo;
	private JLabel lblPalavra;
	private JLabel lblRodada;

	private JButton btnVermelho;
	private JButton btnVerde;
	private JButton btnAzul;
	private JButton btnAmarelo;
	private JButton btnRoxo;
	private JButton btnLaranja;

	private String[] palavras = { "VERMELHO", "VERDE", "AZUL", "AMARELO", "ROXO", "LARANJA" };

	private Color[] cores = { Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, new Color(128, 0, 128), Color.ORANGE };

	private int indiceCorCorreta;

	private int rodadas = 0;

	private int totalRodadas = 15;

	private long tempoInicio;

	public TelaTeste() {

		setTitle("Teste Cognitivo");

		setExtendedState(JFrame.MAXIMIZED_BOTH);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setLayout(null);

		JPanel painel = new JPanel();

		painel.setLayout(null);

		painel.setBounds(0, 0, 1920, 1080);

		painel.setBackground(new Color(210, 220, 240));

		// título
		lblTitulo = new JLabel("Teste Cognitivo de Cores");

		lblTitulo.setBounds(650, 60, 700, 50);

		lblTitulo.setFont(new Font("Arial", Font.BOLD, 34));

		// rodada atual
		lblRodada = new JLabel();

		lblRodada.setBounds(840, 140, 300, 40);

		lblRodada.setFont(new Font("Arial", Font.BOLD, 22));

		// palavra principal
		lblPalavra = new JLabel("", SwingConstants.CENTER);

		lblPalavra.setBounds(500, 260, 900, 120);

		lblPalavra.setFont(new Font("Arial", Font.BOLD, 64));

		// botão vermelho
		btnVermelho = new JButton("VERMELHO");

		btnVermelho.setBounds(400, 520, 250, 70);

		btnVermelho.setFont(new Font("Arial", Font.BOLD, 18));

		// botão verde
		btnVerde = new JButton("VERDE");

		btnVerde.setBounds(830, 520, 250, 70);

		btnVerde.setFont(new Font("Arial", Font.BOLD, 18));

		// botão azul
		btnAzul = new JButton("AZUL");

		btnAzul.setBounds(1260, 520, 250, 70);

		btnAzul.setFont(new Font("Arial", Font.BOLD, 18));

		// botão amarelo
		btnAmarelo = new JButton("AMARELO");

		btnAmarelo.setBounds(400, 670, 250, 70);

		btnAmarelo.setFont(new Font("Arial", Font.BOLD, 18));

		// botão roxo
		btnRoxo = new JButton("ROXO");

		btnRoxo.setBounds(830, 670, 250, 70);

		btnRoxo.setFont(new Font("Arial", Font.BOLD, 18));

		// botão laranja
		btnLaranja = new JButton("LARANJA");

		btnLaranja.setBounds(1260, 670, 250, 70);

		btnLaranja.setFont(new Font("Arial", Font.BOLD, 18));

		// ações dos botões
		btnVermelho.addActionListener(e -> verificar(Color.RED));

		btnVerde.addActionListener(e -> verificar(Color.GREEN));

		btnAzul.addActionListener(e -> verificar(Color.BLUE));

		btnAmarelo.addActionListener(e -> verificar(Color.YELLOW));

		btnRoxo.addActionListener(e -> verificar(new Color(128, 0, 128)));

		btnLaranja.addActionListener(e -> verificar(Color.ORANGE));

		// adiciona componentes
		painel.add(lblTitulo);

		painel.add(lblRodada);

		painel.add(lblPalavra);

		painel.add(btnVermelho);

		painel.add(btnVerde);

		painel.add(btnAzul);

		painel.add(btnAmarelo);

		painel.add(btnRoxo);

		painel.add(btnLaranja);

		add(painel);

		setVisible(true);

		iniciar();
	}

	// inicia o teste
	private void iniciar() {

		tempoInicio = System.currentTimeMillis();

		proximaRodada();
	}

	// gera próxima rodada
	private void proximaRodada() {

		if (rodadas >= totalRodadas) {

			finalizar();

			return;
		}

		Random r = new Random();

		int palavraIndex = r.nextInt(palavras.length);

		int corIndex = r.nextInt(cores.length);

		lblPalavra.setText(palavras[palavraIndex]);

		lblPalavra.setForeground(cores[corIndex]);

		indiceCorCorreta = corIndex;

		rodadas++;

		lblRodada.setText("Rodada " + rodadas + " de " + totalRodadas);
	}

	// verifica resposta
	private void verificar(Color corSelecionada) {

		if (corSelecionada.equals(cores[indiceCorCorreta])) {

			proximaRodada();

		} else {

			JOptionPane.showMessageDialog(null, "Cor incorreta!");

			proximaRodada();
		}
	}

	// finaliza o teste
	private void finalizar() {

		long tempo = System.currentTimeMillis() - tempoInicio;

		if (Sistema.participanteAtual == null) {

			JOptionPane.showMessageDialog(null, "Nenhum participante encontrado!");

			return;
		}

		Resultado r = new Resultado(Sistema.participanteAtual.getNome(), tempo);

		Sistema.listaResultados.add(r);

		Sistema.salvarDados();

		new TelaResultado(tempo);

		dispose();
	}
}