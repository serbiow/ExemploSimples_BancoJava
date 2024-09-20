package br.com.fatec.DAO;

import br.com.fatec.factory.ConnectionFactory;
import br.com.fatec.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO {
    //CRUD

    // Insert
    public static void insere(Usuario user) throws SQLException {
        String sql = "INSERT INTO usuarios(nome,login,senha) VALUES (?,?,?) ";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //criar uma conexão com o BD
            conn = ConnectionFactory.createConnection();

            //Preparando a query
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            // indicar as substituições na query- noem, login e senha do usuário
            pstm.setString(1, user.getNome());
            pstm.setString(2, user.getLogin());
            pstm.setString(3, user.getSenha());

            //Executando a query
            pstm.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pstm != null) pstm.close();
            if (conn != null) conn.close();
        }
    }

    //Delete by ID
    public static void deleteById(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //Listar
    public static ArrayList<Usuario> listar() {
        String sql = "SELECT * FROM usuarios";

        ArrayList<Usuario> lista = new ArrayList<Usuario>();

        Connection conn = null;
        PreparedStatement pstm = null;
        //Classe que vai recuperar os dados do banco de dados
        ResultSet rset = null;

        try {
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            //Enquanto existir dados no banco de dados, faça
            while (rset.next()) {
                Usuario user = new Usuario();

                //Recupera o id do banco e atribui ele ao objeto
                user.setId(rset.getInt("id"));

                //Recupera o nome do banco e atribui ele ao objeto
                user.setNome(rset.getString("nome"));

                //Recupera a login do banco e atribui ele ao objeto
                user.setLogin(rset.getNString("login"));

                //Recupera a senha do banco e atribui ela ao objeto
                user.setSenha(rset.getNString("senha"));

                //Adiciono o contato recuperado, a lista de contatos
                lista.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }

                if (pstm != null) {
                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return lista;
    }

    //Update
    public static void update(Usuario user) {
        String sql = "UPDATE usuarios SET nome = ?, login = ?, senha = ?" +
                " WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //Cria uma conexão com o banco
            conn = ConnectionFactory.createConnection();

            //Cria um PreparedStatment, classe usada para executar a query
            pstm = conn.prepareStatement(sql);

            //Adiciona o valor do primeiro parâmetro da sql
            pstm.setString(1, user.getNome());

            //Adicionar o valor do segundo parâmetro da sql
            pstm.setString(2, user.getLogin());

            //Adiciona o valor do terceiro parâmetro da sql
            pstm.setString(3, user.getSenha());
            pstm.setInt(4, user.getId());

            //Executa a sql para inserção dos dados
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //Fecha as conexões
            try {
                if (pstm != null) {
                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
