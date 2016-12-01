/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.MediasDao;
import Main.MAtualizar;
import Model.Medias;
import Model.Usuario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author SARA
 */
public class TelaAtualizarController implements Initializable {

    public static Usuario getLogado() {
        return logado;
    }

    public static void setLogado(Usuario aLogado) {
        logado = aLogado;
    }
    
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
    
    @FXML
    private ImageView imguser;
    
    private static Usuario logado;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inicializar();
    }
    
    public void limpar() {
        num1.clear();
        num2.clear();
        dataleitura.setValue(null);
    }
    
    @FXML
    void salvar() {
        Medias med = new Medias();
        med.setRegistro1(Integer.valueOf(num1.getText()));
        med.setRegistro2(Integer.valueOf(num2.getText()));
        
        med.setData(dataleitura.getValue());
        med.consumo_de_agua();
        med.getAgua();
        
        MediasDao dao = new MediasDao();
        dao.insereMedia(med);
        
        limpar();
    }
    
    public void cancel(){
        try{
            MAtualizar.getStage().close();
        }catch(Exception ee){
            ee.printStackTrace();
        }
    }
    
    public void inicializar(){
        try{
            imguser.setImage(new Image(logado.getImagem()));
            nomeuser.setText(logado.getUser());
        }catch(Exception ee){
            ee.printStackTrace();
        }
    }
    
}
