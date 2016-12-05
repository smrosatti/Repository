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
public class Dicas {
    
    private int id_dica;
    private String texto;
    private int id_user;

    public int getId_dica() {
        return id_dica;
    }

    public void setId_dica(int id_dica) {
        this.id_dica = id_dica;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
    
}
