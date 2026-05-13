package view;

import javax.swing.*;
import java.awt.*;
import controlador.Sistema;

public class TelaMenu extends JFrame {

    public TelaMenu() {

        setTitle("Synapse - Menu");
        setSize(913, 687);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        getContentPane().setLayout(null);

        //  USUÁRIO LOGADO
        String nomeUsuario = (Sistema.usuarioLogado != null)
                ? Sistema.usuarioLogado.getNome()
                : "Usuário";

        //  CONTEÚDO PRINCIPAL
        JPanel conteudo = new JPanel();
        conteudo.setBounds(0, 1, 897, 647);
        conteudo.setBackground(new Color(210, 220, 240));
        getContentPane().add(conteudo);
        conteudo.setLayout(null);
        
                JLabel titulo = new JLabel("Bem-vindo ao Sistema Synapse", SwingConstants.CENTER);
                titulo.setBounds(198, 0, 699, 646);
                conteudo.add(titulo);
                titulo.setFont(new Font("Arial", Font.BOLD, 18));
                
                        //  LATERAL
                        JPanel lateral = new JPanel();
                        lateral.setBounds(0, -23, 200, 669);
                        conteudo.add(lateral);
                        lateral.setBackground(new Color(120, 150, 200));
                        lateral.setLayout(null);
                        
                                JLabel lblUsuario = new JLabel("Olá, " + nomeUsuario);
                                lblUsuario.setBounds(10, 20, 180, 30);
                                lblUsuario.setForeground(Color.WHITE);
                                lblUsuario.setFont(new Font("Arial", Font.BOLD, 14));
                                
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
                                                                        btnSair.setBounds(10, 628, 180, 30);
                                                                        
                                                                                // 🔗 AÇÕES
                                                                        
                                                                                // Cadastro participante
                                                                                btnCadastro.addActionListener(e -> {
                                                                                    new TelaCadastroParticipante();
                                                                                    dispose();
                                                                                });
                                                                                
                                                                                        // Teste
                                                                                        btnTeste.addActionListener(e -> {
                                                                                            new TelaTeste();
                                                                                            dispose();
                                                                                        });
                                                                                        
                                                                                                // Exibir resultados
                                                                                                btnResultado.addActionListener(e -> {
                                                                                                    new TelaExibirResultado();
                                                                                                    dispose();
                                                                                                });
                                                                                                
                                                                                                        // Gerenciar resultados (editar/excluir)
                                                                                                        btnGerenciar.addActionListener(e -> {
                                                                                                            new TelaGerenciarResultados();
                                                                                                            dispose();
                                                                                                        });
                                                                                                        
                                                                                                                // Sair
                                                                                                                btnSair.addActionListener(e -> {
                                                                                                                    new TelaLogin();
                                                                                                                    dispose();
                                                                                                                });
                                                                                                                
                                                                                                                        //  ADD LATERAL
                                                                                                                        lateral.add(lblUsuario);
                                                                                                                        lateral.add(btnCadastro);
                                                                                                                        lateral.add(btnTeste);
                                                                                                                        lateral.add(btnResultado);
                                                                                                                        lateral.add(btnGerenciar);
                                                                                                                        lateral.add(btnSair);

        setVisible(true);
    }
}