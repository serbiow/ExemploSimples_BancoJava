package br.com.fatec.testes;

import br.com.fatec.DAO.UsuarioDAO;
import br.com.fatec.model.Usuario;

import java.sql.SQLException;

public class TestaUpdate {
    public static void main(String[] args) throws SQLException {
        Usuario user= new Usuario(2, "Sapimpoba","sapim@gmail.com","senha789");

        UsuarioDAO.update(user);
    }
}
