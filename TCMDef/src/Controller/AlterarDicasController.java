/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.DicasDao;
import Main.MAlterarDicas;
import Model.Dicas;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author SARA
 */
public class AlterarDicasController implements Initializable {

    public static Dicas getDicaselecionada() {
        return dicaselecionada;
    }

    public static void setDicaselecionada(Dicas aDicaselecionada) {
        dicaselecionada = aDicaselecionada;
    }

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Button btvoltar;

    @FXML
    private Button btsalvar;

    @FXML
    private TextArea textodica;

    @FXML
    private Button btlimpar;
    
    private static Dicas dicaselecionada;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        iniciar();
        
        btvoltar.setOnMouseClicked((MouseEvent evt)->{
            voltar();
        });
        
        btsalvar.setOnMouseClicked((MouseEvent evt)->{
            salvar();
        });
        
        btlimpar.setOnMouseClicked((MouseEvent evt)->{
            limpar();
        });
    } 
    
    public void iniciar(){
        textodica.setText(dicaselecionada.getTexto());
    }
    
    public void voltar(){
        try{
            MAlterarDicas.getStage().close();
        }catch(Exception ee){
            ee.printStackTrace();
        }
    }
    
    public void limpar(){
        textodica.clear();
    }
    
    public void salvar(){
        try{
            if(textodica.getText().trim().isEmpty()){
                
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setHeaderText("Não deixe campos nulos");
                a.show();            
            }else{
                Dicas d = new Dicas();
                d.setTexto(textodica.getText());
                d.setId_dica(dicaselecionada.getId_dica());
                d.setId_user(dicaselecionada.getId_user());
                
                DicasDao dao = new DicasDao();
                dao.update(d);
                
                Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                a.setHeaderText("Dica Alterada com Sucesso");
                a.showAndWait();
                
                voltar();
            }
        }catch(Exception ee){
            ee.printStackTrace();
        }
    }
    
}
