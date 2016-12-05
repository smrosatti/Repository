/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.MediasDao;
import Main.MAtualizar;
import Main.MDicas;
import Main.MEconomia;
import Main.MEditUser;
import Main.MHistorico;
import Main.MListarUsers;
import Main.MLogin;
import Main.MPrincipal;
import Model.Medias;
import Model.Usuario;
import java.io.File;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
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
    @FXML
    private Label data2;

    @FXML
    private DatePicker datap;

    private String caminho;

    private static Usuario log;

    public void mudancas() {
        try {
            nome.setText(log.getNome());
            sobrenomet.setText(log.getSobrenome());
            MediasDao dao = new MediasDao();
            ObservableList<Medias> medias = dao.getLista(log);
            for (int i = 0; i < medias.size(); i++) {
                if (i + 1 == medias.size()) {
                    //datap.setValue(medias.get(i).getData());
                    data2.setText(String.valueOf(medias.get(i).getData()));
                }
            }
            try {
                foto.setImage(new Image(log.getImagem()));
            } catch (Exception e) {
                foto.setImage(new Image("/Imagem/user.png"));
            }
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public void Listar_Usuario() {
        try {
            MListarUsers user = new MListarUsers();
            user.start(new Stage());
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public void historico() {
        MHistorico tela = new MHistorico(log);
        try {
            tela.start(new Stage());
            MPrincipal.getStage().close();
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public void atualizar() {
        try {
            MAtualizar tela = new MAtualizar(log);
            tela.start(new Stage());
            MPrincipal.getStage().close();
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public void economia() {
        try {
            MEconomia tela = new MEconomia(log);
            tela.start(new Stage());
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public void sair() {
        Alert t = new Alert(AlertType.CONFIRMATION);
        t.setTitle("Deseja Sair?!");
        t.setHeaderText("Isso encerrara sua seção! Continuar?");
        Optional<ButtonType> bt = t.showAndWait();

        if (bt.get() == ButtonType.OK) {
            MLogin tela = new MLogin();
            try {
                tela.start(new Stage());
                MPrincipal.getStage().close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {

        }
    }

    @FXML
    void Editar_Usuario() {
        try {
            MEditUser edit = new MEditUser(log);
            edit.start(new Stage());
            MPrincipal.getStage().close();
        } catch (Exception ee) {
            ee.printStackTrace();
        }

    }

    @FXML
    void Dicas_Consumo() {
        try {
            MDicas dicas = new MDicas();
            dicas.start(new Stage());
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    @FXML
    void tutorial() {
        TelaTutorialController tela = new TelaTutorialController();
        try {
            tela.start(new Stage());
        } catch (Exception ex) {
            ex.printStackTrace();
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

    }
}
