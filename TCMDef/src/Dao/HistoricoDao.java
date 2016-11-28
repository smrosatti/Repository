/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import JDBC.ConnectionFactory;
import Model.Historico;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author SARA
 */
public class HistoricoDao {

    private Connection conexao;

    public HistoricoDao() {
        conexao = new ConnectionFactory().getConnection();
    }

    public void InsereHistorico(Historico h) {
        String sql = "INSERT INTO historico (datareg, id_user, dadosiniciais, dadosfinais, media, medialitros, id_media) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setDate(1, Date.valueOf(h.getDatareg()));
            stm.setInt(2, h.getId_usuario());
            stm.setInt(3, h.getDadosiniciais());
            stm.setInt(4, h.getDadosfinais());
            stm.setDouble(5, h.getMedia());
            stm.setDouble(6, h.getMedialitros());
            stm.setInt(7, h.getId_media());

            stm.execute();
            stm.close();
            conexao.close();

        } catch (SQLException ee) {
            ee.printStackTrace();
        }
    }

    public void deletar(Historico h) {
        String sql = "DELETE * FROM historico WHERE id = ?";
        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setInt(1, h.getId_historico());
            stm.execute();
            stm.close();
            conexao.close();

        } catch (SQLException ee) {
            ee.printStackTrace();
        }
    }

    public ObservableList<Historico> getLista() {
        ObservableList<Historico> historicos = FXCollections.observableArrayList();
        try {
            String sql = "SELECT * FROM historico WHERE id_user = ?";
            PreparedStatement stm = conexao.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Historico hist = new Historico();
                hist.setId_historico(rs.getInt("id_historico"));
                hist.setId_usuario(rs.getInt("id_user"));
                hist.setDadosiniciais(rs.getInt("dadosiniciais"));
                hist.setDadosfinais(rs.getInt("dadosfinais"));
                hist.setMedia(rs.getDouble("media"));
                hist.setMedialitros(rs.getDouble("medialitros"));
                hist.setId_media(rs.getInt("id_media"));
                Date data = rs.getDate("datareg");
                hist.setDatareg(data.toLocalDate());

                historicos.add(hist);
            }

            stm.close();
            rs.close();
            conexao.close();

            return historicos;

        } catch (SQLException ee) {
            throw new RuntimeException(ee);
        }
    }

}
