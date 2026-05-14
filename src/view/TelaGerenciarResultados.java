package view;

import javax.swing.*;
import java.awt.*;

import controlador.Sistema;
import modelo.Resultado;

public class TelaGerenciarResultados extends JFrame {

	private JList<String> lista;

	private DefaultListModel<String> modeloLista;

	public TelaGerenciarResultados() {

		setTitle("Gerenciar Resultados");

		setExtendedState(JFrame.MAXIMIZED_BOTH);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setLayout(null);

		// painel principal
		JPanel painel = new JPanel();

		painel.setLayout(null);

		painel.setBounds(0, 0, 1920, 1080);

		painel.setBackground(new Color(210, 220, 240));

		// título
		JLabel titulo = new JLabel("Gerenciamento de Resultados");

		titulo.setBounds(620, 40, 700, 50);

		titulo.setFont(new Font("Arial", Font.BOLD, 34));

		// subtítulo
		JLabel subtitulo = new JLabel("Editar ou remover avaliações realizadas");

		subtitulo.setBounds(630, 95, 500, 30);

		subtitulo.setFont(new Font("Arial", Font.PLAIN, 18));

		// lista
		modeloLista = new DefaultListModel<>();

		carregarResultados();

		lista = new JList<>(modeloLista);

		lista.setFont(new Font("Arial", Font.PLAIN, 22));

		lista.setBackground(Color.WHITE);

		lista.setSelectionBackground(new Color(120, 150, 200));

		lista.setSelectionForeground(Color.WHITE);

		JScrollPane scroll = new JScrollPane(lista);

		scroll.setBounds(350, 170, 1200, 550);

		// painel informações
		JPanel painelInfo = new JPanel();

		painelInfo.setLayout(null);

		painelInfo.setBounds(350, 760, 1200, 120);

		painelInfo.setBackground(new Color(190, 205, 230));

		painelInfo.setBorder(BorderFactory.createLineBorder(new Color(120, 150, 200), 2));

		JLabel info = new JLabel("Selecione um resultado para editar ou excluir.");

		info.setBounds(30, 35, 700, 40);

		info.setFont(new Font("Arial", Font.BOLD, 22));

		painelInfo.add(info);

		// botão editar
		JButton btnEditar = new JButton("Editar");

		btnEditar.setBounds(560, 920, 180, 50);

		btnEditar.setFont(new Font("Arial", Font.BOLD, 18));

		// botão excluir
		JButton btnExcluir = new JButton("Excluir");

		btnExcluir.setBounds(850, 920, 180, 50);

		btnExcluir.setFont(new Font("Arial", Font.BOLD, 18));

		// botão voltar
		JButton btnVoltar = new JButton("Voltar");

		btnVoltar.setBounds(1140, 920, 180, 50);

		btnVoltar.setFont(new Font("Arial", Font.BOLD, 18));

		// editar resultado
		btnEditar.addActionListener(e -> {

			int index = lista.getSelectedIndex();

			if (index == -1) {

				JOptionPane.showMessageDialog(null, "Selecione um resultado!");

				return;
			}

			Resultado r = Sistema.listaResultados.get(index);

			String novoTempo = JOptionPane.showInputDialog(null, "Novo tempo:", r.getTempo());

			try {

				long tempo = Long.parseLong(novoTempo);

				Resultado novo = new Resultado(r.getNomeParticipante(), tempo);

				Sistema.listaResultados.set(index, novo);

				Sistema.salvarDados();

				carregarResultados();

				JOptionPane.showMessageDialog(null, "Resultado atualizado!");

			} catch (Exception ex) {

				JOptionPane.showMessageDialog(null, "Valor inválido!");
			}
		});

		// excluir resultado
		btnExcluir.addActionListener(e -> {

			int index = lista.getSelectedIndex();

			if (index == -1) {

				JOptionPane.showMessageDialog(null, "Selecione um resultado!");

				return;
			}

			int confirmar = JOptionPane.showConfirmDialog(null, "Deseja excluir esse resultado?");

			if (confirmar == 0) {

				Sistema.listaResultados.remove(index);

				Sistema.salvarDados();

				carregarResultados();

				JOptionPane.showMessageDialog(null, "Resultado removido!");
			}
		});

		// voltar
		btnVoltar.addActionListener(e -> {

			new TelaMenu();

			dispose();
		});

		// adiciona componentes
		painel.add(titulo);

		painel.add(subtitulo);

		painel.add(scroll);

		painel.add(painelInfo);

		painel.add(btnEditar);

		painel.add(btnExcluir);

		painel.add(btnVoltar);

		add(painel);

		setVisible(true);
	}

	// carrega resultados na lista
	private void carregarResultados() {

		modeloLista.clear();

		for (Resultado r : Sistema.listaResultados) {

			modeloLista
					.addElement("Participante: " + r.getNomeParticipante() + "   |   Tempo: " + r.getTempo() + " ms");
		}
	}
}