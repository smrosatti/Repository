/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.MediasDao;
import Main.MAtualizar;
import Main.MEditUser;
import Model.Medias;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author SARA
 */
public class TelaAtualizarController implements Initializable {
    
    @FXML
    private DatePicker dataleitura;

    @FXML
    private Button btvoltar;

    @FXML
    private Button btsalvar;

    @FXML
    private Button bteditarperfil;

    @FXML
    private TextField num1;

    @FXML
    private Button btcancel;

    @FXML
    private TextField num2;

    @FXML
    private Label nomeuser;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    public void cadastrar(){
        try{
            Medias m = new Medias();
            m.setRegistro1(Integer.parseInt(num1.getText()));
            m.setRegistro2(Integer.parseInt(num2.getText()));
            m.setGasto(m.getGasto());
            m.setAgua(m.getAgua());
            
            MediasDao dao = new MediasDao();
            
            
        }catch(Exception ee){
            ee.printStackTrace();
        }
    }
    
    public void cancel(){
        try{
            MAtualizar.getStage().close();
        }catch(Exception ee){
            ee.printStackTrace();
        }
    }
    
}
