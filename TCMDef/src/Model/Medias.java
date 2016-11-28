/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author SARA
 */
public class Medias {

    private double agua;
    private double gasto;
    private double metrocubico;
    private int registro1;
    private int registro2;
    private int cont = 0;
    
    //variavel agua2 inutil?
    //gasto é a quantidade de agua

    public void consumoreais() {
        setMetrocubico(1000);

        setGasto(getRegistro2() - getRegistro1());
        setGasto(getGasto() * getMetrocubico());

        if (getGasto() <= 10000) {
            setAgua(33.74);
        } else {
            while (getMetrocubico() * 10 < getGasto()) {
                if (getCont() == 0) {
                    setAgua(33.74);
                }
                setAgua(getAgua() + 6.84);
                setMetrocubico(getMetrocubico() + 1000);
                setCont(getCont() + 1);
            }
        }
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
