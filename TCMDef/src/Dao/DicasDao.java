/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import JDBC.ConnectionFactory;
import Model.Dicas;
import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author SARA
 */
public class DicasDao {
    
    private Connection conexao;

    public DicasDao() {
        this.conexao = new ConnectionFactory().getConnection();
    }

    public void insereDica(Dicas d) {
        String sql = "INSERT INTO dicas(descricao, id_user) VALUES (?, ?)";
        try {
            PreparedStatement pst = conexao.prepareStatement(sql);

            pst.setString(1, d.getTexto());
            pst.setInt(2, d.getId_user());
            pst.execute();
            pst.close();
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Dicas d) {
        String sql = "UPDATE dicas SET descricao = ? WHERE id_dica = ? AND id_user = ?";
        try {
            PreparedStatement pst = conexao.prepareStatement(sql);

            pst.setString(1, d.getTexto());
            pst.setInt(2, d.getId_dica());
            pst.setInt(3, d.getId_user());
            pst.execute();
            pst.close();
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ObservableList<Dicas> getLista(Usuario u) {
        ObservableList<Dicas> dicaslist = FXCollections.observableArrayList();
        try {
            String sql = "SELECT * FROM dicas WHERE id_user = ?";
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, u.getId_user());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Dicas d = new Dicas();

                d.setId_dica(rs.getInt("id_dica"));
                d.setTexto(rs.getString("descricao"));
                d.setId_user(rs.getInt("id_user"));

                dicaslist.add(d);
            }
            pst.execute();
            pst.close();
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dicaslist;
    }

    public void delete(Dicas d) {
        String sql = "DELETE FROM dicas WHERE id_dica = ?";
        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setInt(1, d.getId_dica());
            stm.execute();
            stm.close();
            conexao.close();
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }
    
    
}
