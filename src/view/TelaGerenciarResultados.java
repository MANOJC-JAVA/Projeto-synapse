package view;

import javax.swing.*;
import java.awt.*;

import controlador.Sistema;
import modelo.Resultado;

public class TelaGerenciarResultados extends JFrame {

    private DefaultListModel<String> modeloLista;
    private JList<String> listaResultados;

    public TelaGerenciarResultados() {

        setTitle("Gerenciar Resultados");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        //  TOPO
        JLabel titulo = new JLabel(
                "Gerenciamento de Resultados",
                SwingConstants.CENTER
        );

        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(titulo, BorderLayout.NORTH);

        //  LISTA
        modeloLista = new DefaultListModel<>();

        atualizarLista();

        listaResultados = new JList<>(modeloLista);
        listaResultados.setFont(new Font("Arial", Font.PLAIN, 16));

        JScrollPane scroll = new JScrollPane(listaResultados);

        add(scroll, BorderLayout.CENTER);

        //  BOTÕES
        JPanel painelBotoes = new JPanel();

        JButton btnEditar = new JButton("Editar");
        JButton btnExcluir = new JButton("Excluir");
        JButton btnVoltar = new JButton("Voltar");

        painelBotoes.add(btnEditar);
        painelBotoes.add(btnExcluir);
        painelBotoes.add(btnVoltar);

        add(painelBotoes, BorderLayout.SOUTH);

        //  EDITAR
        btnEditar.addActionListener(e -> {

            int index = listaResultados.getSelectedIndex();

            if (index == -1) {
                JOptionPane.showMessageDialog(
                        null,
                        "Selecione um resultado!"
                );
                return;
            }

            Resultado resultadoAtual =
                    Sistema.listaResultados.get(index);

            String novoNome = JOptionPane.showInputDialog(
                    "Novo nome:",
                    resultadoAtual.getNomeParticipante()
            );

            if (novoNome == null || novoNome.isEmpty()) {
                return;
            }

            String novoTempoTexto = JOptionPane.showInputDialog(
                    "Novo tempo:",
                    resultadoAtual.getTempo()
            );

            if (novoTempoTexto == null || novoTempoTexto.isEmpty()) {
                return;
            }

            try {

                long novoTempo = Long.parseLong(novoTempoTexto);

                Resultado novoResultado =
                        new Resultado(novoNome, novoTempo);

                Sistema.listaResultados.set(index, novoResultado);
                Sistema.salvarDados();

                atualizarLista();

                JOptionPane.showMessageDialog(
                        null,
                        "Resultado editado!"
                );

            } catch (Exception erro) {

                JOptionPane.showMessageDialog(
                        null,
                        "Digite um tempo válido!"
                );
            }
        });

        //  EXCLUIR
        btnExcluir.addActionListener(e -> {

            int index = listaResultados.getSelectedIndex();

            if (index == -1) {

                JOptionPane.showMessageDialog(
                        null,
                        "Selecione um resultado!"
                );

                return;
            }

            int resposta = JOptionPane.showConfirmDialog(
                    null,
                    "Deseja excluir esse resultado?",
                    "Confirmação",
                    JOptionPane.YES_NO_OPTION
            );

            if (resposta == JOptionPane.YES_OPTION) {

                Sistema.listaResultados.remove(index);
                Sistema.salvarDados();

                atualizarLista();

                JOptionPane.showMessageDialog(
                        null,
                        "Resultado removido!"
                );
            }
        });

        //  VOLTAR
        btnVoltar.addActionListener(e -> {

            new TelaMenu();

            dispose();
        });

        setVisible(true);
    }

    //  ATUALIZA LISTA
    private void atualizarLista() {

        modeloLista.clear();

        if (Sistema.listaResultados.isEmpty()) {

            modeloLista.addElement("Nenhum resultado encontrado.");

            return;
        }

        for (Resultado r : Sistema.listaResultados) {

            modeloLista.addElement(
                    r.getNomeParticipante()
                    + " - "
                    + r.getTempo()
                    + " ms"
            );
        }
    }
}