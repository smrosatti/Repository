/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Aluno
 */
public class MInicial extends Application {
    
    private static Stage stage;
    
    public static Stage getStage(){
        return MInicial.stage;
    }
    
    public void setStage(Stage st){
        MInicial.stage = st;
    }
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("/View/TelaInicial.fxml"));
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Tela Inicial'");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        MInicial.stage = primaryStage;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
