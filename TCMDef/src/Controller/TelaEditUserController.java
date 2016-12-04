/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.UsuarioDao;
import Main.MEditUser;
import Main.MPrincipal;
import Model.Criptografia;
import Model.Usuario;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author SARA
 */
public class TelaEditUserController implements Initializable {

    public static Usuario getUser() {
        return user;
    }

    public static void setUser(Usuario aUser) {
        user = aUser;
    }

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button cancel;

    @FXML
    private TextField emailaltf;

    @FXML
    private TextField useraltf;

    @FXML
    private ImageView imageuseralt;

    @FXML
    private PasswordField consenhaaltf;

    @FXML
    private TextField nomealtf;

    @FXML
    private Button salvaralt;

    @FXML
    private TextField sobrenomealtf;

    @FXML
    private PasswordField senhaaltf;

    @FXML
    private Button fteditar;

    public String caminho;

    private static Usuario user;
    
    private Usuario alterado;

    public void clear() {
        nomealtf.clear();
        sobrenomealtf.clear();
        emailaltf.clear();
    }

    public void Update() {
        try {
            if (nomealtf.getText().trim().isEmpty() || sobrenomealtf.getText().trim().isEmpty() || emailaltf.getText().trim().isEmpty() || senhaaltf.getText().trim().isEmpty() || consenhaaltf.getText().trim().isEmpty() || caminho.trim().isEmpty() || useraltf.getText().trim().isEmpty()) {
                Alert erro = new Alert(AlertType.ERROR);
                erro.setHeaderText("Por Favor Preencha Todos os Campos Corretamente!");
                erro.showAndWait();

            } else if (senhaaltf.getText().equals(consenhaaltf.getText())) {

                Usuario u = new Usuario();
                u.setNome(nomealtf.getText());
                u.setSobrenome(sobrenomealtf.getText());
                u.setEmail(emailaltf.getText());
                u.setSenha(Criptografia.criptografar(senhaaltf.getText()));
                u.setImagem(caminho);
                u.setUser(useraltf.getText());
                u.setId_user(user.getId_user());

                UsuarioDao dao = new UsuarioDao();
                dao.Update(u);
                
                alterado = u;
                setUser(alterado);

                Alert erro = new Alert(AlertType.CONFIRMATION);
                erro.setHeaderText("Alterações feitas com sucesso!");
                erro.showAndWait();

                close();

            } else {
                senhaaltf.setBlendMode(BlendMode.RED);
                consenhaaltf.setBlendMode(BlendMode.RED);
                Alert erro = new Alert(AlertType.ERROR);
                erro.setHeaderText("Senhas não coincidem!!");
                erro.showAndWait();
            }

        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public void imagem() {
        try {
            FileChooser window = new FileChooser();
            window.getExtensionFilters().add(new ExtensionFilter("Imagens", "*.jpg", "*.jpeg", "*.png"));
            File f = window.showOpenDialog(new Stage());

            if (f != null) {
                caminho = ("file:///" + f.getAbsolutePath());
                imageuseralt.setImage(new Image(caminho));
            } else {
                Alert erro = new Alert(AlertType.WARNING);
                erro.setHeaderText("Por favor selecione uma imagem!");
            }

        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public void close() {
        try {
            MPrincipal mp = new MPrincipal(user);
            mp.start(new Stage());
            MEditUser.getStage().close();
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public void inicializa() {
        try {
            imageuseralt.setImage(new Image(user.getImagem()));
            nomealtf.setText(user.getNome());
            useraltf.setText(user.getUser());
            sobrenomealtf.setText(user.getSobrenome());
            emailaltf.setText(user.getEmail());
            caminho = user.getImagem();

        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        inicializa();

        fteditar.setOnMouseClicked((MouseEvent evt) -> {
            imagem();
        });

        salvaralt.setOnMouseClicked((MouseEvent evt) -> {
            Update();
        });

        cancel.setOnMouseClicked((MouseEvent evt) -> {
            close();
        });
    }

    public Usuario getAlterado() {
        return alterado;
    }

    public void setAlterado(Usuario alterado) {
        this.alterado = alterado;
    }

}
