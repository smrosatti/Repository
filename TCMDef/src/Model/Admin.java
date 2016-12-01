/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Aluno
 */
public class Admin {
    private int id_admin;
    private int cpf;
    private String usuario;
    private String senhaadmin;
    private String nomeadmin;
    private String sobrenomeadmin;
    
    public Admin(){
        
    }

    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenhaadmin() {
        return senhaadmin;
    }

    public void setSenhaadmin(String senhaadmin) {
        this.senhaadmin = senhaadmin;
    }

    public String getNomeadmin() {
        return nomeadmin;
    }

    public void setNomeadmin(String nomeadmin) {
        this.nomeadmin = nomeadmin;
    }

    public String getSobrenomeadmin() {
        return sobrenomeadmin;
    }

    public void setSobrenomeadmin(String sobrenomeadmin) {
        this.sobrenomeadmin = sobrenomeadmin;
    }
    
}
