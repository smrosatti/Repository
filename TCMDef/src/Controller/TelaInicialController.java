/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Main.MCadastro;
import Main.MInicial;
import Main.MLogin;
import javafx.scene.input.KeyEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Aluno
 */
public class TelaInicialController implements Initializable {
    
    @FXML
    private Button cadastro;
    @FXML
    private Button login;
    
    public void cad(){
        try{
          MCadastro tela = new MCadastro();
          tela.start(new Stage());
          MInicial.getStage().close();
        }catch(Exception ee){
            ee.printStackTrace();
        }
    }
    
    public void log(){
        try{
            MLogin log = new MLogin();
            log.start(new Stage());
            MInicial.getStage().close();
        }catch (Exception ee){
            ee.printStackTrace();
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        cadastro.setOnMouseClicked((MouseEvent evt) ->{
            cad();
        });
        
        cadastro.setOnKeyPressed((KeyEvent evt)->{
            if(evt.getCode() == KeyCode.ENTER){
                cad();
            }
        });
        
        login.setOnMouseClicked((MouseEvent evt) ->{
            log();
        });
        
        login.setOnKeyPressed((KeyEvent evt)->{
            if(evt.getCode() == KeyCode.ENTER){
                
            }
        });

    }    
    
}
