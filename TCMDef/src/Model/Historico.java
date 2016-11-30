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

    public Historico() {

    }

    private double agua;
    private double gasto;
    private double metrocubico;
    private int registro1;
    private int registro2;
    private int cont = 0;
    private LocalDate data;
    private int id;
    private int id_media;
    private int id_usuario;
    private int id_historico;

    public void consumo_de_agua() {
        metrocubico = (1000);
        
        registro1 = registro1 * metrocubico;
        registro2 = registro2 * metrocubico;

        regisFinal = registro1 + registro2;

        if (registro1 <= 10000 && regisFinal <= 10000) {
            gasto = (33.74);
        } else {
            while (cont < (registro2 / metrocubico)) {
                if (cont == 0) {
                    gasto = (33.74);
                }
                gasto = (gasto + 5.06);
                cont++;
            }
        }
        System.out.println(regisFinal + " " + gasto);
        setGasto(gasto);
        setRegisFinal(regisFinal);
    }
    public int getId_historico() {
        return id_historico;
    }

    public void setId_historico(int id_historico) {
        this.id_historico = id_historico;
    }

    public double getAgua() {
        return agua;
    }

    public void setAgua(double agua) {
        this.agua = agua;
    }

    public double getGasto() {
        return gasto;
    }

    public void setGasto(double gasto) {
        this.gasto = gasto;
    }

    public double getMetrocubico() {
        return metrocubico;
    }

    public void setMetrocubico(double metrocubico) {
        this.metrocubico = metrocubico;
    }

    public int getRegistro1() {
        return registro1;
    }

    public void setRegistro1(int registro1) {
        this.registro1 = registro1;
    }

    public int getRegistro2() {
        return registro2;
    }

    public void setRegistro2(int registro2) {
        this.registro2 = registro2;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_media() {
        return id_media;
    }

    public void setId_media(int id_media) {
        this.id_media = id_media;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
}
