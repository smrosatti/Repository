/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Main.MEconomia;
import Model.Usuario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class TelaEconomiaController implements Initializable {

    private static Usuario logado;

    public static Usuario getLogado() {
        return logado;
    }

    public static void setLogado(Usuario aLogado) {
        logado = aLogado;
    }

    @FXML
    void voltar() {
        MEconomia.getStage().close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

}
