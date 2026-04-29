package view;

import javax.swing.*;
import java.awt.*;

public class TelaCadastro extends JFrame {

    public TelaCadastro() {
        setTitle("Cadastro Pesquisador");
        setSize(500, 500);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(null);
        painel.setBackground(new Color(200, 210, 230));

        String[] labels = {
            "Nome", "E-mail", "Instituição",
            "Área de Atuação", "Registro Profissional",
            "Senha", "Confirmar Senha"
        };

        int y = 80;

        for (String texto : labels) {
            JLabel lbl = new JLabel(texto);
            lbl.setBounds(100, y, 200, 20);
            JTextField txt = new JTextField();
            txt.setBounds(100, y + 20, 300, 25);

            painel.add(lbl);
            painel.add(txt);
            y += 50;
        }

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(180, y, 120, 30);

        painel.add(btnSalvar);

        add(painel);
        setVisible(true);
    }
}