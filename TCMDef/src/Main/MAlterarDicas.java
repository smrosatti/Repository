/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Controller.AlterarDicasController;
import Model.Dicas;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author SARA
 */
public class MAlterarDicas extends Application {
    
 private static Stage stage;
    
    public static Stage getStage(){
        return MAlterarDicas.stage;
    }
    
    public void setStage(Stage st){
        MAlterarDicas.stage = st;
    }
    
    public MAlterarDicas(Dicas d){
        AlterarDicasController.setDicaselecionada(d);
    }
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("/View/AlterarDicas.fxml"));
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Alterar Dicas");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        MAlterarDicas.stage = primaryStage;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}