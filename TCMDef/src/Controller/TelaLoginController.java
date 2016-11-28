/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.UsuarioDao;
import Main.MCadastro;
import Main.MLogin;
import Main.MPrincipal;
import Model.Criptografia;
import Model.Usuario;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Aluno
 */
public class TelaLoginController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button cad;
    @FXML
     Button logar;

    @FXML
    private TextField user;
    @FXML
    private PasswordField senha; 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cad.setOnMouseClicked((MouseEvent evt) -> {
            cad();
        });

        cad.setOnKeyPressed((KeyEvent evt) -> {
            if (evt.getCode() == KeyCode.ENTER) {
                cad();
            }
        });

        logar.setOnMouseClicked((MouseEvent evt) -> {
            Logar();
        });

        logar.setOnKeyPressed((KeyEvent evt) -> {
            if (evt.getCode() == KeyCode.ENTER) {
                Logar();
            }
        });

        senha.setOnKeyPressed((KeyEvent evt) -> {
            if (evt.getCode() == KeyCode.ENTER) {
                Logar();
            }
        });
    }
    
    public void limpa() {
        user.clear();
        senha.clear();
    }

    public void cad() {
        try {
            MCadastro tela = new MCadastro();
            tela.start(new Stage());

        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public void Logar() {
        try {
            UsuarioDao dao = new UsuarioDao();
            ObservableList<Usuario> users = dao.getLista();
            for (int i = 0; i < users.size(); i++) {
                if (user.getText().equals(users.get(i).getUser())) {
                    if (Criptografia.criptografar(senha.getText()).equals(users.get(i).getSenha())) {
                        String imagem, nome, sobrenome, email, user;
                        int id_user;
                        nome = users.get(i).getNome();
                        imagem = users.get(i).getImagem();
                        sobrenome = users.get(i).getSobrenome();
                        email = users.get(i).getEmail();
                        user = users.get(i).getUser();
                        id_user = users.get(i).getId_user();
                        Usuario usuario = new Usuario(nome, imagem, sobrenome, email, user, id_user);
                        
                        MLogin.getStage().close();
                        MPrincipal tela = new MPrincipal(usuario);
                        tela.start(new Stage());
                        i = users.size();
                    }
                } else if (i+1 == users.size()) {
                    Alert erro = new Alert(AlertType.ERROR);
                    erro.setHeaderText("Login ou senha inválidos");
                    erro.show();
                }
            }

        } catch (Exception ee) {
            Logger.getLogger(TelaLoginController.class.getName()).log(Level.SEVERE, null, ee);
        }
    }

}
