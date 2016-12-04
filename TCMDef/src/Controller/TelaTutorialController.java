/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author tiago
 */
public class TelaTutorialController implements Initializable {

    public static Stage tutorial;

    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/TelaTutorial.fxml"));

        Scene scene = new Scene(root);
        stage.setTitle("Tutorial");
        stage.setScene(scene);
        stage.show();

        tutorial = stage;
    }

    @FXML
    private ListView list;

    @FXML
    private ImageView img;

    @FXML
    void sair() {
        tutorial.close();
    }

    @FXML
    void img() {
        img.setImage(new Image("/Imagem/Registro_Agua.jpg"));
    }

    @FXML
    void img1() {
        img.setImage(new Image("/Imagem/Atualizar_Dados.png"));
    }

    @FXML
    void tabela() {
        String a = "1: Pegue os numeros mostrado na\n imagem ao lado, ignorando os\n vermelho;";
        String b = "2: Coloque o valor da primeira\n checagem no primeiro campo\n na tela de Atualizar Dados;";
        String c = "3: Coloque o numero da segunda\n checagem no segundo campo;";
        String d = "4: Clique em salvar e pronto.";
        String e = " ";

        ObservableList<String> obs = FXCollections.observableArrayList(a, e, b, e, c, e, d);
        list.setItems(obs);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tabela();
    }

}
