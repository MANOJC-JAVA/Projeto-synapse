package view;

import javax.swing.*;
import java.awt.*;
import controlador.Sistema;

public class TelaMenu extends JFrame {

    public TelaMenu() {
        setTitle("Synapse - Menu");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null); 

        //  PAINEL LATERAL
        JPanel lateral = new JPanel();
        lateral.setBounds(0, 0, 200, 400);
        lateral.setBackground(new Color(120, 150, 200));
        lateral.setLayout(null);

        //  Usuário logado
        String nomeUsuario = (Sistema.usuarioLogado != null)
                ? Sistema.usuarioLogado.getNome()
                : "Usuário";

        JLabel lblUsuario = new JLabel("Olá, " + nomeUsuario);
        lblUsuario.setBounds(10, 20, 180, 30);

        //  BOTÕES
        JButton btnCadastro = new JButton("Cadastrar participante");
        btnCadastro.setBounds(10, 80, 180, 30);

        JButton btnTeste = new JButton("Realizar Avaliação");
        btnTeste.setBounds(10, 130, 180, 30);

        JButton btnResultado = new JButton("Exibir resultados");
        btnResultado.setBounds(10, 180, 180, 30);

        JButton btnGerenciar = new JButton("Gerenciar resultados");
        btnGerenciar.setBounds(10, 230, 180, 30);

        JButton btnSair = new JButton("Sair"); 
        btnSair.setBounds(10, 300, 180, 30);

        // AÇÕES

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

        // SAIR (volta pro login)
        btnSair.addActionListener(e -> {
            Sistema.usuarioLogado = null;
            new TelaLogin();
            dispose();
        });

        // ADICIONA NO LATERAL
        lateral.add(lblUsuario);
        lateral.add(btnCadastro);
        lateral.add(btnTeste);
        lateral.add(btnResultado);
        lateral.add(btnGerenciar);
        lateral.add(btnSair);

        // PAINEL PRINCIPAL
        JPanel conteudo = new JPanel();
        conteudo.setBounds(200, 0, 500, 400);
        conteudo.setBackground(new Color(210, 220, 240));

        //  ADD NA TELA
        add(lateral);
        add(conteudo);

        setVisible(true);
    }
}