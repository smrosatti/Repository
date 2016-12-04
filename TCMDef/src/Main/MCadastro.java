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
public class MCadastro extends Application {
    
    private static Stage stage;
    
    public static Stage getStage(){
        return MCadastro.stage;
    }
    
    public static void setStage(Stage sp){
      MCadastro.stage = sp;
    }
    
    @Override
    public void start(Stage stagep) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("/View/TelaCadastro.fxml"));
        
        Scene scene = new Scene(root);
        
        stagep.setTitle("Tela de Cadastro");
        stagep.setScene(scene);
        stagep.show();
        
        MCadastro.stage = stagep;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
