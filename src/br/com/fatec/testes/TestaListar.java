package br.com.fatec.testes;

import br.com.fatec.DAO.UsuarioDAO;

import java.sql.SQLException;

public class TestaListar {
    public static void main(String[] args) throws SQLException {
        System.out.println(UsuarioDAO.listar());
    }
}
