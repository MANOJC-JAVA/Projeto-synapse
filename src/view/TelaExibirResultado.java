package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import controlador.Sistema;
import modelo.Resultado;

public class TelaExibirResultado extends JFrame {

	public TelaExibirResultado() {

		setTitle("Resultados");

		setExtendedState(JFrame.MAXIMIZED_BOTH);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setLayout(null);

		// painel principal
		JPanel painel = new JPanel();

		painel.setLayout(null);

		painel.setBounds(0, 0, 1920, 1080);

		painel.setBackground(new Color(210, 220, 240));

		// título
		JLabel titulo = new JLabel("Resultados dos Testes");

		titulo.setBounds(650, 40, 700, 50);

		titulo.setFont(new Font("Arial", Font.BOLD, 34));

		// subtítulo
		JLabel subtitulo = new JLabel("Ranking dos melhores tempos");

		subtitulo.setBounds(700, 95, 400, 30);

		subtitulo.setFont(new Font("Arial", Font.PLAIN, 20));

		// área dos resultados
		JTextArea area = new JTextArea();

		area.setEditable(false);

		area.setFont(new Font("Arial", Font.PLAIN, 24));

		area.setBackground(Color.WHITE);

		area.setMargin(new Insets(20, 20, 20, 20));

		// ordena ranking
		ArrayList<Resultado> ranking = new ArrayList<>(Sistema.listaResultados);

		Collections.sort(ranking, Comparator.comparingLong(Resultado::getTempo));

		// exibe resultados
		if (ranking.isEmpty()) {

			area.append("Nenhum resultado registrado.");

		} else {

			int posicao = 1;

			for (Resultado r : ranking) {

				area.append(posicao + "º Lugar" + "\n\n" + "Participante: " + r.getNomeParticipante() + "\n" + "Tempo: "
						+ r.getTempo() + " ms" + "\n" + "-------------------------------------" + "\n\n");

				posicao++;
			}
		}

		JScrollPane scroll = new JScrollPane(area);

		scroll.setBounds(350, 170, 1200, 600);

		// painel de informações
		JPanel painelInfo = new JPanel();

		painelInfo.setLayout(null);

		painelInfo.setBounds(350, 800, 1200, 100);

		painelInfo.setBackground(new Color(190, 205, 230));

		painelInfo.setBorder(BorderFactory.createLineBorder(new Color(120, 150, 200), 2));

		JLabel info = new JLabel("Os resultados são organizados automaticamente pelo menor tempo.");

		info.setBounds(30, 30, 900, 30);

		info.setFont(new Font("Arial", Font.BOLD, 20));

		painelInfo.add(info);

		// botão voltar
		JButton btnVoltar = new JButton("Voltar");

		btnVoltar.setBounds(820, 940, 250, 50);

		btnVoltar.setFont(new Font("Arial", Font.BOLD, 18));

		btnVoltar.addActionListener(e -> {

			new TelaMenu();

			dispose();
		});

		// adiciona componentes
		painel.add(titulo);

		painel.add(subtitulo);

		painel.add(scroll);

		painel.add(painelInfo);

		painel.add(btnVoltar);

		add(painel);

		setVisible(true);
	}
}