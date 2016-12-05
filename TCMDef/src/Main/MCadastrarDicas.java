/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Controller.CadastrarDicasController;
import Model.Usuario;
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
public class MCadastrarDicas extends Application {
    
    private static Stage stage;
    
    public static Stage getStage(){
        return MCadastrarDicas.stage;
    }
    
    public MCadastrarDicas(Usuario u){
        CadastrarDicasController.setLogado(u);
    }
    
    public void setStage(Stage st){
        MCadastrarDicas.stage = st;
    }
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("/View/CadastrarDicas.fxml"));
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Cadastrar Dicas");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        MCadastrarDicas.stage = primaryStage;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
