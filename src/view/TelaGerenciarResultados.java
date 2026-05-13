package view;

import javax.swing.*;
import controlador.Sistema;
import modelo.Resultado;

public class TelaGerenciarResultados extends JFrame {

    DefaultListModel<String> modeloLista = new DefaultListModel<>();
    JList<String> lista = new JList<>(modeloLista);

    public TelaGerenciarResultados() {
        setTitle("Gerenciar Resultados");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setLayout(null);

        JScrollPane scroll = new JScrollPane(lista);
        scroll.setBounds(20, 20, 340, 180);

        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(50, 220, 120, 30);

        JButton btnEditar = new JButton("Editar");
        btnEditar.setBounds(200, 220, 120, 30);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(120, 270, 120, 30);

        atualizarLista();

        //  EXCLUIR
        btnExcluir.addActionListener(e -> {
            int index = lista.getSelectedIndex();

            if (index != -1) {
                Sistema.listaResultados.remove(index);
                atualizarLista();
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um item!");
            }
        });

        // ✏ EDITAR
        btnEditar.addActionListener(e -> {
            int index = lista.getSelectedIndex();

            if (index != -1) {
                Resultado r = Sistema.listaResultados.get(index);

                String novoNome = JOptionPane.showInputDialog(
                        "Novo nome:", r.getNomeParticipante()
                );

                if (novoNome != null && !novoNome.isEmpty()) {
                    r.setNomeParticipante(novoNome);
                    atualizarLista();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um item!");
            }
        });

        //  VOLTAR
        btnVoltar.addActionListener(e -> {
            new TelaMenu();
            dispose();
        });

        add(scroll);
        add(btnExcluir);
        add(btnEditar);
        add(btnVoltar);

        setVisible(true);
    }

    private void atualizarLista() {
        modeloLista.clear();

        for (Resultado r : Sistema.listaResultados) {
            modeloLista.addElement(r.toString());
        }
    }
}