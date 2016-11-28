/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Controller.TelaEditUserController;
import Controller.TelaLoginController;
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
public class MEditUser extends Application {
    
    private static Stage stage;
    
    public MEditUser(Usuario us){
        TelaEditUserController.setUser(us);
    }
    
    public static Stage getStage(){
        return MEditUser.stage;
    }
    
    public static void setStage(Stage st){
        MEditUser.stage = st;
    }
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("/View/TelaEditUser.fxml"));
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Editar Usuário");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        MEditUser.stage = primaryStage;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
