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
public class Medias {

    public Medias() {

    }

    private double agua;
    private double gasto;
    private double metrocubico;
    private int registro1;
    private int registro2;
    private int cont = 0;
    private LocalDate data;
    private int id;

    public void consumo_de_agua() {
        metrocubico = (1000);

        gasto = (registro2 - registro1);
        gasto = (gasto * metrocubico);

        if (gasto <= 10000) {
            agua = (33.74);
        } else {
            while (metrocubico * 10 < gasto) {
                if (cont == 0) {
                    agua = (33.74);
                }
                agua = (agua + 6.84);
                metrocubico = (metrocubico + 1000);
                cont = (cont + 1);
            }
            System.out.println(agua);
            setAgua(agua);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
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

}
