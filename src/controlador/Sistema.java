package controlador;

import java.util.ArrayList;
import modelo.Usuario;
import modelo.Resultado;
import modelo.Participante;

public class Sistema {

    public static ArrayList<Usuario> usuarios = new ArrayList<>();
    public static ArrayList<Resultado> listaResultados = new ArrayList<>();
    public static ArrayList<Participante> participantes = new ArrayList<>();

    public static Participante participanteAtual;
    public static Usuario usuarioLogado; // 🔥 NOVO

    // 🔐 LOGIN
    public static boolean autenticar(String email, String senha) {
        for (Usuario u : usuarios) {
            if (u.getEmail().equals(email) && u.getSenha().equals(senha)) {
                usuarioLogado = u; // 🔥 guarda quem logou
                return true;
            }
        }
        return false;
    }

    // 👤 CADASTRAR USUÁRIO (COM VALIDAÇÃO)
    public static boolean cadastrarUsuario(Usuario novo) {

        for (Usuario u : usuarios) {
            if (u.getEmail().equals(novo.getEmail())) {
                return false; // email já existe
            }
        }

        usuarios.add(novo);
        return true;
    }
}