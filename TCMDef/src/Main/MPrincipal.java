/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Controller.TelaPrincipalController;
import Model.Usuario;
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
public class MPrincipal extends Application {

    private static Stage stage;
    
    public MPrincipal(Usuario u){
        TelaPrincipalController.setLog(u);
    }

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/TelaPrincipal.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Tela Principal");
        stage.setScene(scene);
        stage.show();

        MPrincipal.stage = stage;

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * @return the stage
     */
    public static Stage getStage() {
        return MPrincipal.stage;
    }

    /**
     * @param stage the stage to set
     */
    public static void setStage(Stage stagep) {
        MPrincipal.stage = stagep;
    }

}
