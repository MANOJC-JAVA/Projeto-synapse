package view;

import javax.swing.*;
import java.awt.*;
import controlador.Sistema;
import modelo.Usuario;

public class TelaCadastro extends JFrame {

    public TelaCadastro() {
        setTitle("Cadastro de Pesquisador");
        setSize(500, 550);
        setLocationRelativeTo(null);
        setLayout(null);

        getContentPane().setBackground(new Color(200, 210, 230));

        JLabel titulo = new JLabel("Cadastro de Pesquisador");
        titulo.setBounds(140, 20, 250, 30);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));

        // CAMPOS
        JTextField txtNome = new JTextField();
        txtNome.setBounds(100, 80, 300, 25);

        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(100, 130, 300, 25);

        JTextField txtInstituicao = new JTextField();
        txtInstituicao.setBounds(100, 180, 300, 25);

        JTextField txtArea = new JTextField();
        txtArea.setBounds(100, 230, 300, 25);

        JTextField txtRegistro = new JTextField();
        txtRegistro.setBounds(100, 280, 300, 25);

        JPasswordField txtSenha = new JPasswordField();
        txtSenha.setBounds(100, 330, 300, 25);

        JPasswordField txtConfirmar = new JPasswordField();
        txtConfirmar.setBounds(100, 380, 300, 25);

        // LABELS
        addLabel("Nome:", 100, 60);
        addLabel("Email:", 100, 110);
        addLabel("Instituição:", 100, 160);
        addLabel("Área de atuação:", 100, 210);
        addLabel("Registro profissional:", 100, 260);
        addLabel("Senha:", 100, 310);
        addLabel("Confirmar senha:", 100, 360);

        // BOTÕES
        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(120, 440, 120, 30);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(260, 440, 120, 30);

        // AÇÃO CADASTRAR (CORRIGIDA)
        btnCadastrar.addActionListener(e -> {

            String nome = txtNome.getText();
            String email = txtEmail.getText();
            String senha = new String(txtSenha.getPassword());
            String confirmar = new String(txtConfirmar.getPassword());

            // validação
            if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
                return;
            }

            if (!senha.equals(confirmar)) {
                JOptionPane.showMessageDialog(null, "As senhas não conferem!");
                return;
            }

            //  cria usuário
            Usuario novo = new Usuario(nome, email, senha);

            //  salva no sistema
            if (Sistema.cadastrarUsuario(novo)) {
                JOptionPane.showMessageDialog(null, "Pesquisador cadastrado com sucesso!");

                new TelaLogin();
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Email já cadastrado!");
            }
        });

        //  VOLTAR
        btnVoltar.addActionListener(e -> {
            new TelaLogin();
            dispose();
        });

        // ADICIONA COMPONENTES
        add(titulo);
        add(txtNome);
        add(txtEmail);
        add(txtInstituicao);
        add(txtArea);
        add(txtRegistro);
        add(txtSenha);
        add(txtConfirmar);
        add(btnCadastrar);
        add(btnVoltar);

        setVisible(true);
    }

    // MÉTODO AUXILIAR
    private void addLabel(String texto, int x, int y) {
        JLabel lbl = new JLabel(texto);
        lbl.setBounds(x, y, 200, 20);
        add(lbl);
    }
}