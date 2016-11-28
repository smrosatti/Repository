/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.UsuarioDao;
import Main.MCadastro;
import Main.MLogin;
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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Aluno
 */
public class TelaCadastroController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button confirm;
    @FXML
    private Button cancel;
    @FXML
    private TextField usuario;
    @FXML
    private TextField nome;
    @FXML
    private TextField sobrenome;
    @FXML
    private TextField email;
    @FXML
    private PasswordField senha;
    @FXML
    private PasswordField senhaconf;
    @FXML
    private Button mudarimagem;
    @FXML
    private ImageView imagemuser;

    String CaminhoImagem;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        confirm.setOnMouseClicked((MouseEvent evt) -> {
            CadUser();
        });

        confirm.setOnKeyPressed((KeyEvent evt) -> {
            if (evt.getCode() == KeyCode.ENTER) {
                CadUser();
            }
        });

        cancel.setOnMouseClicked((MouseEvent evt) -> {
            Cancela();
        });

        cancel.setOnKeyPressed((KeyEvent evt) -> {
            if (evt.getCode() == KeyCode.ENTER) {
                Cancela();
            }
        });

        mudarimagem.setOnMouseClicked((MouseEvent evt) -> {
            Imagem();
        });
    }
    
     public void CadUser() {
        try {
            if (nome.getText().equals("") || sobrenome.getText().equals("") || usuario.getText().equals("") || email.getText().equals("") || senha.getText().equals("") || senhaconf.getText().equals("")) {
                Alert erro = new Alert(AlertType.ERROR);
                erro.setHeaderText("Por Favor Preencha Todos os Campos Corretamente!");
                erro.showAndWait();
            } else if (senha.getText().equals(senhaconf.getText())) {
                Usuario u = new Usuario();
                u.setNome(nome.getText());
                u.setSobrenome(sobrenome.getText());
                u.setUser(usuario.getText());
                u.setEmail(email.getText());
                u.setSenha(senha.getText());
                u.setImagem(CaminhoImagem);

                UsuarioDao dao = new UsuarioDao();
                dao.insereUsuario(u);

                Cancela();

                Alert sucess = new Alert(AlertType.INFORMATION);
                sucess.setHeaderText("Cadastro Feito Com Sucesso!");
                sucess.show();
            } else {
                senha.setBlendMode(BlendMode.RED);
                senhaconf.setBlendMode(BlendMode.RED);
                Alert ersenha = new Alert(AlertType.WARNING);
                ersenha.setHeaderText("Senha Incorreta! ");
                ersenha.showAndWait();
            }
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public void Imagem() {
        try {
            FileChooser esc = new FileChooser();
            esc.getExtensionFilters().add(new ExtensionFilter("Imagens", "*.jpg", "*.png", "*.jpeg"));
            File f = esc.showOpenDialog(new Stage());

            if (f != null) {
                CaminhoImagem = ("file:///" + f.getAbsolutePath());
                imagemuser.setImage(new Image(CaminhoImagem));
            } else {
                Alert img = new Alert(AlertType.WARNING);
                img.setHeaderText("Por Favor Selecione uma Imagem!");
                img.show();
            }

        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public void Cancela() {
        try {
            MCadastro.getStage().close();

        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }
}
