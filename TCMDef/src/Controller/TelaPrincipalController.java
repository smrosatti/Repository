/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.UsuarioDao;
import Main.MAtualizar;
import Main.MCadastro;
import Main.MDicas;
import Main.MEconomia;
import Main.MEditUser;
import Main.MHistorico;
import Main.MListarUsers;
import Main.MPrincipal;
import Model.Usuario;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
public class TelaPrincipalController implements Initializable {

    public static Usuario getLog() {
        return log;
    }

    public static void setLog(Usuario aLog) {
        log = aLog;
    }

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button hist;
    @FXML
    private Button atualiza;
    @FXML
    private Button ec;
    @FXML
    private Button sair;
    @FXML
    private ImageView foto;
    @FXML
    private Label nome;
    @FXML
    private Label sobrenomet;

    private String caminho;
    
    private static Usuario log;

    public void mudancas() {
        try {
            nome.setText(log.getNome());
            sobrenomet.setText(log.getSobrenome());
            try {
                foto.setImage(new Image(log.getImagem()));
            } catch (Exception e) {
                foto.setImage(new Image("/Imagem/user.png"));
            }
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public void Listar_Usuario(ActionEvent evt) {
        try {
            MListarUsers user = new MListarUsers();
            user.start(new Stage());
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public void imagem() {
        try {
            FileChooser janela = new FileChooser();
            janela.getExtensionFilters().add(new ExtensionFilter("Imagens", "*.jpg"));
            File f = janela.showOpenDialog(new Stage());

            if (f != null) {
                caminho = ("file:///" + f.getAbsolutePath());
                foto.setImage(new Image(caminho));
                //mudancas();
            } else {
                Alert erro = new Alert(AlertType.WARNING);
                erro.setHeaderText("Nenhuma imagem selecionada!");
            }
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public void historico() {
        try {
            MHistorico tela = new MHistorico();
            tela.start(new Stage());
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public void atualizar() {
        try {
            MAtualizar tela = new MAtualizar();
            tela.start(new Stage());
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public void economia() {
        try {
            MEconomia tela = new MEconomia();
            tela.start(new Stage());
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public void sair() {
        try {
            Alert sair = new Alert(AlertType.WARNING);
            sair.setHeaderText("Deseja Mesmo Sair?");
            MPrincipal.getStage().close();
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    @FXML
    private void Cadastrar_Usuario(ActionEvent evtcad) {
        try {
            MCadastro cad = new MCadastro();
            cad.start(new Stage());
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    @FXML
    private void Editar_Usuario(ActionEvent evtedit) {
        try {
            MEditUser edit = new MEditUser(log);
            edit.start(new Stage());
        } catch (Exception ee) {
            ee.printStackTrace();
        }

    }

    @FXML
    private void Dicas_Consumo(ActionEvent evtdicas) {
        try {
            MDicas dicas = new MDicas();
            dicas.start(new Stage());
        } catch (Exception ee) {
            ee.printStackTrace();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        mudancas();

        hist.setOnMouseClicked((MouseEvent evt) -> {
            historico();
        });

        atualiza.setOnMouseClicked((MouseEvent evt) -> {
            atualizar();
        });

        ec.setOnMouseClicked((MouseEvent evt) -> {
            economia();
        });

        sair.setOnMouseClicked((MouseEvent evt) -> {
            sair();
        });

        foto.setOnMouseClicked((MouseEvent evt) -> {
            imagem();
        });
    }

}
