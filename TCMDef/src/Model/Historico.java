/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.time.LocalDate;

/**
 *
 * @author SARA
 */
public class Historico {
    
    private int id_historico;
    private LocalDate datareg;
    private int dadosiniciais;
    private int dadosfinais;
    private double media;
    private double medialitros;
    private int id_media;
    private int id_usuario;

    public LocalDate getDatareg() {
        return datareg;
    }

    public void setDatareg(LocalDate datareg) {
        this.datareg = datareg;
    }

    public int getDadosiniciais() {
        return dadosiniciais;
    }

    public void setDadosiniciais(int dadosiniciais) {
        this.dadosiniciais = dadosiniciais;
    }

    public int getDadosfinais() {
        return dadosfinais;
    }

    public void setDadosfinais(int dadosfinais) {
        this.dadosfinais = dadosfinais;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public int getId_historico() {
        return id_historico;
    }

    public void setId_historico(int id_historico) {
        this.id_historico = id_historico;
    }

    /**
     * @return the medialitros
     */
    public double getMedialitros() {
        return medialitros;
    }

    /**
     * @param medialitros the medialitros to set
     */
    public void setMedialitros(double medialitros) {
        this.medialitros = medialitros;
    }

    /**
     * @return the id_media
     */
    public int getId_media() {
        return id_media;
    }

    /**
     * @param id_media the id_media to set
     */
    public void setId_media(int id_media) {
        this.id_media = id_media;
    }

    /**
     * @return the id_usuario
     */
    public int getId_usuario() {
        return id_usuario;
    }

    /**
     * @param id_usuario the id_usuario to set
     */
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

}
