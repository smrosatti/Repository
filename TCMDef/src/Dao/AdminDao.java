/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import JDBC.ConnectionFactory;
import java.sql.Connection;

/**
 *
 * @author Aluno
 */
public class AdminDao {
    
    private Connection conexao;
    
    public AdminDao(){
        conexao = new ConnectionFactory().getConnection();
    }
    
}
