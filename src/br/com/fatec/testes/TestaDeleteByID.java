package br.com.fatec.testes;

import br.com.fatec.DAO.UsuarioDAO;

import java.sql.SQLException;

public class TestaDeleteByID {
    public static void main(String[] args) throws SQLException {
        UsuarioDAO.deleteById(1);
    }
}
