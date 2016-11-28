/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Controller.TelaLoginController;
import JDBC.ConnectionFactory;
import Model.Criptografia;
import Model.Usuario;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author SARA
 */
public class UsuarioDao {

    private Connection conexaobd;

    public UsuarioDao() {
        this.conexaobd = new ConnectionFactory().getConnection();
    }

    public void insereUsuario(Usuario u) {

        String sql = "INSERT INTO usuario(nome, sobrenome, usuario, email, senha, caminho_imagem) values (?,?,?,?,?,?)";
        try {
            PreparedStatement statement = conexaobd.prepareStatement(sql);
            statement.setString(1, u.getNome());
            statement.setString(2, u.getSobrenome());
            statement.setString(3, u.getUser());
            statement.setString(4, u.getEmail());
            statement.setString(5, Criptografia.criptografar(u.getSenha()));
            statement.setString(6, u.getImagem());
            statement.execute();
            conexaobd.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void Update(Usuario u) {
        String sql = "UPDATE usuario SET nome = ? sobrenome = ? email = ?, senha = ?, caminho_imagem = ? WHERE id_user = ?";
        try {
            PreparedStatement smt = conexaobd.prepareStatement(sql);
            smt.setString(1, u.getNome());
            smt.setString(2, u.getSobrenome());
            smt.setString(3, u.getEmail());
            smt.setString(4, u.getSenha());

            smt.setInt(5, u.getId_user());

        } catch (Exception ee) {
            ee.printStackTrace();
        }

    }

    public ObservableList<Usuario> getLista() {
        ObservableList<Usuario> usuarios = FXCollections.observableArrayList();
        try {
            String sql = "SELECT * FROM usuario";
            PreparedStatement stm = conexaobd.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId_user(rs.getInt("id_user"));
                u.setNome(rs.getString("nome"));
                u.setSobrenome(rs.getString("sobrenome"));
                u.setUser(rs.getString("usuario"));
                u.setEmail(rs.getString("email"));
                u.setSenha(rs.getString("senha"));
                u.setImagem(rs.getString("caminho_imagem"));

                usuarios.add(u);
            }
            stm.execute();
            conexaobd.close();
            return usuarios;
        } catch (SQLException ee) {
            throw new RuntimeException();
        }
    }

}
