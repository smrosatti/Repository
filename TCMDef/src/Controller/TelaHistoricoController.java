/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.HistoricoDao;
import Main.MAtualizar;
import Model.Historico;
import Model.Usuario;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author SARA
 */
public class TelaHistoricoController implements Initializable {

    @FXML
    private TableColumn<Historico, Double> medialitroc;

    @FXML
    private TableColumn<Historico, Double> mediarealc;

    @FXML
    private TableColumn<Historico, LocalDate> dataregc;

    @FXML
    private Button btexcluir;

    @FXML
    private Button gerarpdf;

    @FXML
    private Button btatualizar;

    @FXML
    private TableColumn<Historico, Integer> dadossc;

    @FXML
    private Button pesquisar;

    @FXML
    private TableColumn<Historico, Integer> dadospc;

    @FXML
    private TableView<Historico> tablehistorico;

    @FXML
    private Button btsair;

    @FXML
    private Button btadicionar;

    @FXML
    private Button btexcluirtudo;

    @FXML
    private DatePicker pesquisardata;

    private ObservableList<Historico> OBListHistorico;

    private Historico selecionado;
    
    private Usuario logado;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        iniciartabela();
        
        btexcluir.setOnMouseClicked((MouseEvent evt)->{
            excluir();
        });
        
        btadicionar.setOnMouseClicked((MouseEvent evt)->{
            adicionar();
        });
        
        pesquisar.setOnMouseClicked((MouseEvent evt)->{
            pesquisar();
        });
        
        btatualizar.setOnMouseClicked((MouseEvent evt)->{
            atualizar();
        });
        
        
    }

    public void iniciartabela() {
        try {
            medialitroc.setCellValueFactory(new PropertyValueFactory("medialitro"));
            mediarealc.setCellValueFactory(new PropertyValueFactory("media"));
            dataregc.setCellValueFactory(new PropertyValueFactory("datareg"));
            dadospc.setCellValueFactory(new PropertyValueFactory("dadosiniciais"));
            dadossc.setCellValueFactory(new PropertyValueFactory("dadosfinais"));

            HistoricoDao dao = new HistoricoDao();
            OBListHistorico = dao.getLista();
            tablehistorico.setItems(OBListHistorico);

        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public void excluir() {
        try {
            if (selecionado != null) {
                HistoricoDao dao = new HistoricoDao();
                dao.deletar(selecionado);
                Alert a = new Alert(AlertType.CONFIRMATION);
                a.setHeaderText("Registro excluído com sucesso!");
                a.show();
            } else {
                Alert a = new Alert(AlertType.WARNING);
                a.setHeaderText("Por favor selecione um registro");
                a.show();
            }
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public void adicionar() {
        try {
            MAtualizar tela = new MAtualizar(logado);
            tela.start(new Stage());
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public void pesquisar() {
        try {
            ObservableList<Historico> hist = FXCollections.observableArrayList();
            for (Historico h : OBListHistorico) {
                if (Date.valueOf(h.getDatareg()).equals(Date.valueOf(pesquisardata.getValue()))) {
                    hist.add(h);
                }
            }
            tablehistorico.setItems(hist);
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public void atualizar() {
        try {
            HistoricoDao dao = new HistoricoDao();
            OBListHistorico = dao.getLista();
            tablehistorico.setItems(OBListHistorico);
            Alert a = new Alert(AlertType.CONFIRMATION);
            a.setHeaderText("Tabela Atualizada!");
            a.show();
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public void excluirtudo() {
        try {
            ObservableList<Historico> hist = FXCollections.observableArrayList();
            for (Historico h : OBListHistorico) {
                HistoricoDao dao = new HistoricoDao();
                dao.deletar(h);
            }

        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }
    
    public void gerarpdf(){
        try{
            
        }catch(Exception ee){
            ee.printStackTrace();
        }
    }

}
