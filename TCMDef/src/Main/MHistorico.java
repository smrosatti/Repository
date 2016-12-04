/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Controller.TelaHistoricoController;
import Model.Usuario;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author SARA
 */
public class MHistorico extends Application {
    
    private static Stage stage;
    
    public MHistorico(Usuario u){
    TelaHistoricoController.setLogado(u);
    
    }
    
    public static Stage getStage(){
        return MHistorico.stage;
    }
    
    public void setStage(Stage st){
        MHistorico.stage = st;
    }
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("/View/TelaHistorico.fxml"));
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Histórico");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        MHistorico.stage = primaryStage;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
