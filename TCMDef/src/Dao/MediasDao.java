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
package DAO;

import JDBC.ConnectFactory;
import Model.Medias;
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
public class MediasDAO {

    private Connection conexaobd;

    public MediasDAO() {
        this.conexaobd = new ConnectFactory().getConnection();
    }

    public void insereMedia(Medias m) {
        String sql = "INSERT INTO medias(datamed, valor) values (?, ?)";
        try {
            PreparedStatement pst = conexaobd.prepareStatement(sql);

            pst.setDate(1, Date.valueOf(m.getData()));
            pst.setDouble(2, m.getAgua());
            pst.execute();
            conexaobd.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Medias m) {
        String sql = "UPDATE medias SET datamed = ?, valor = ?";
        try {
            PreparedStatement pst = conexaobd.prepareStatement(sql);

            pst.setDate(1, Date.valueOf(m.getData()));
            pst.setDouble(2, m.getAgua());

            pst.execute();
            pst.close();
            conexaobd.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ObservableList<Medias> getLista() {
        Date ota;
        ObservableList<Medias> meds = FXCollections.observableArrayList();
        try {
            String sql = "SELECT * FROM medias";
            PreparedStatement pst = conexaobd.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Medias m = new Medias();

                m.setId(rs.getInt("id_media"));
                ota = rs.getDate("datamed");
                m.setData(ota.toLocalDate());
                m.setAgua(rs.getDouble("valor"));

                meds.add(m);
            }
            pst.execute();
            conexaobd.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return meds;
    }
}
