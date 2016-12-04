/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import JDBC.ConnectionFactory;
import Model.Medias;
import Model.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author SARA
 */
public class MediasDao {

    private Connection conexaobd;

    public MediasDao() {
        this.conexaobd = new ConnectionFactory().getConnection();
    }

    public void insereMedia(Medias m) {
        String sql = "INSERT INTO medias(numerosiniciais, numerosfinais, mediaagua, mediagastos, datam, id_user) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pst = conexaobd.prepareStatement(sql);

            pst.setInt(1, m.getRegistro1());
            pst.setInt(2, m.getRegistro2());
            pst.setDouble(3, m.getRegisFinal());
            pst.setDouble(4, m.getGasto());
            pst.setDate(5, Date.valueOf(m.getData()));
            pst.setInt(6, m.getId_usuario());
            pst.execute();
            pst.close();
            conexaobd.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Medias m) {
        String sql = "UPDATE medias SET numerosiniciais = ?, numerosfinais = ?, mediaagua = ?, mediagastos = ?, datam = ? WHERE id_media = ? AND id_user = ?";
        try {
            PreparedStatement pst = conexaobd.prepareStatement(sql);

            pst.setInt(1, m.getRegistro1());
            pst.setInt(2, m.getRegistro2());
            pst.setDouble(3, m.getRegisFinal());
            pst.setDouble(4, m.getGasto());
            pst.setDate(5, Date.valueOf(m.getData()));
            pst.setInt(6, m.getId_media());
            pst.setInt(7, m.getId_usuario());
            pst.execute();
            pst.close();
            conexaobd.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ObservableList<Medias> getLista(Usuario u) {
        Date ota;
        ObservableList<Medias> meds = FXCollections.observableArrayList();
        try {
            String sql = "SELECT * FROM medias WHERE id_user = ?";
            PreparedStatement pst = conexaobd.prepareStatement(sql);
            pst.setInt(1, u.getId_user());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Medias m = new Medias();

                m.setId_media(rs.getInt("id_media"));
                ota = rs.getDate("datam");
                m.setData(ota.toLocalDate());
                m.setRegisFinal(rs.getDouble("mediaagua"));
                m.setGasto(rs.getDouble("mediagastos"));
                m.setRegistro1(rs.getInt("numerosiniciais"));
                m.setRegistro2(rs.getInt("numerosfinais"));

                meds.add(m);
            }
            pst.execute();
            pst.close();
            conexaobd.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return meds;
    }

    public void delete(Medias u) {
        String sql = "DELETE FROM medias WHERE id_media = ?";
        try {
            PreparedStatement stm = conexaobd.prepareStatement(sql);
            stm.setInt(1, u.getId_media());
            stm.execute();
            stm.close();
            conexaobd.close();
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }
}
