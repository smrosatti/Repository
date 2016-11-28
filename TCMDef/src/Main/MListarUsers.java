/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author vinn1
 */
public class MListarUsers {
    
    private static Stage stage;

    /**
     * @return the stage
     */
    public static Stage getStage() {
        return stage;
    }

    /**
     * @param aStage the stage to set
     */
    public static void setStage(Stage aStage) {
        stage = aStage;
    }
    
    public void start(Stage stage) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/TelaListarUsers.fxml"));
        
         Scene scene = new Scene(root);
        
        stage.setTitle("Lista de Usuários");
        stage.setScene(scene);
        stage.show();
        
        MListarUsers.stage = stage;
    }
    
    public static void main(String[] args) {
        
    }
    
}
