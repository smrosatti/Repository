/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.DicasDao;
import Main.MCadastrarDicas;
import Model.Dicas;
import Model.Usuario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author SARA
 */
public class CadastrarDicasController implements Initializable {

    public static Usuario getLogado() {
        return logado;
    }

    public static void setLogado(Usuario aLogado) {
        logado = aLogado;
    }


     @FXML
    private Button btvoltar;

    @FXML
    private Button btsalvar;

    @FXML
    private TextArea textodica;

    @FXML
    private ImageView imguser;

    @FXML
    private Label nomeuser;

    @FXML
    private Button btlimpar;
    
    private static Usuario logado;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        iniciar();
        
        btlimpar.setOnMouseClicked((MouseEvent evt)->{
            limpar();
        });
        
        btsalvar.setOnMouseClicked((MouseEvent evt)->{
            cadastrar();
        });
        
        btvoltar.setOnMouseClicked((MouseEvent evt)->{
            fechar();
        });
    }
    
    public void fechar(){
        try{
            MCadastrarDicas.getStage().close();
        }catch(Exception ee){
            ee.printStackTrace();
        }
    }

    public void cadastrar(){
        try{
            if(textodica.getText().trim().isEmpty()){
                Alert a = new Alert(AlertType.ERROR);
                a.setHeaderText("Não deixe campos nulos!");
                a.show();
            }else{
                Dicas d = new Dicas();
                d.setId_user(logado.getId_user());
                d.setTexto(textodica.getText());
                
                DicasDao dao = new DicasDao();
                dao.insereDica(d);
                
                Alert a = new Alert(AlertType.CONFIRMATION);
                a.setHeaderText("Dica Inserida com Sucesso");
                a.showAndWait();
                
                fechar();
            }
            
        }catch(Exception ee){
            ee.printStackTrace();
        }
    }
    
    public void limpar(){
        textodica.clear();
    }
    
    public void iniciar(){
        try{
            imguser.setImage(new Image(logado.getImagem()));
            nomeuser.setText(logado.getNome());
        }catch(Exception ee){
            ee.printStackTrace();
        }
    }
    
}
