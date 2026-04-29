package view;

import javax.swing.*;
import controlador.Sistema;
import modelo.Resultado;

public class TelaExibirResultado extends JFrame {

    public TelaExibirResultado() {
        setTitle("Resultados");
        setSize(400, 300);
        setLocationRelativeTo(null);

        JTextArea area = new JTextArea();

        if (Sistema.listaResultados.isEmpty()) {
            area.append("Nenhum resultado registrado.");
        } else {
            for (Resultado r : Sistema.listaResultados) {
                area.append(
                    r.getNomeParticipante() + " - " + r.getTempo() + " ms\n"
                );
            }
        }

        add(new JScrollPane(area));
        setVisible(true);
    }
}