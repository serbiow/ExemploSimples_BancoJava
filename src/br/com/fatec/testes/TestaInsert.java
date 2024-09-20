package br.com.fatec.testes;

import br.com.fatec.DAO.UsuarioDAO;
import br.com.fatec.model.Usuario;

import java.sql.SQLException;

public class TestaInsert {
    public static void main(String[] args) throws SQLException {
        Usuario user= new Usuario("Quero Quero","quero@gmail.com","senha123");
        UsuarioDAO.insere(user);
        UsuarioDAO.insere(new Usuario("Josimar","josimar@gmail.com","senha456"));
    }
}
