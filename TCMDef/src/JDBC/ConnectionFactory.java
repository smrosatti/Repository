/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Aluno
 */
public class ConnectionFactory {
    
    public Connection getConnection(){
        try{
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/tcm","postgres","pudim");
        }catch(SQLException sqle){
            System.out.println("Deu ruim no BD");
            throw new RuntimeException(sqle);
        }
    }
    
}
