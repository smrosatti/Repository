/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author SARA
 */
public class AlterarDicasController implements Initializable {

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
    private ImageView imguser;

    @FXML
    private Label nomeuser;

    @FXML
    private Button btlimpar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
