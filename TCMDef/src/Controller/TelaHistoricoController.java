/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.MediasDao;
import Main.MAtualizar;
import Main.MHistorico;
import Model.Medias;
import Model.Usuario;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author SARA
 */
public class TelaHistoricoController implements Initializable {

    @FXML
    private TableColumn<Medias, Double> medialitroc;

    @FXML
    private TableColumn<Medias, Double> mediarealc;

    @FXML
    private TableColumn<Medias, LocalDate> dataregc;

    @FXML
    private Button btexcluir;

    @FXML
    private Button gerarpdf;

    @FXML
    private Button btatualizar;

    @FXML
    private TableColumn<Medias, Integer> dadossc;

    @FXML
    private Button pesquisar;

    @FXML
    private TableColumn<Medias, Integer> dadospc;

    @FXML
    private TableView<Medias> tablehistorico;

    @FXML
    private Button btsair;

    @FXML
    private Button btadicionar;

    @FXML
    private Button btexcluirtudo;

    @FXML
    private DatePicker pesquisardata;

    private ObservableList<Medias> OBListHistorico;

    private Medias selecionado;

    private static Usuario logado;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        iniciartabela();
        
        tablehistorico.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                selecionado = (Medias) newValue;
            }
        });

        btsair.setOnMouseClicked((MouseEvent evt) -> {
            sair();
        });

        btexcluir.setOnMouseClicked((MouseEvent evt) -> {
            excluir();
        });

        btadicionar.setOnMouseClicked((MouseEvent evt) -> {
            adicionar();
        });

        pesquisar.setOnMouseClicked((MouseEvent evt) -> {
            pesquisar();
        });

        btatualizar.setOnMouseClicked((MouseEvent evt) -> {
            atualizar();
        });

        btexcluirtudo.setOnMouseClicked((MouseEvent evt) -> {
            excluirtudo();
        });
        
        gerarpdf.setOnMouseClicked((MouseEvent evt) -> {
            gerarpdf();
        });

    }

    public void gerarpdf() {
        Document doc = new Document();

        FileChooser window = new FileChooser();
        window.getExtensionFilters().add(new ExtensionFilter("PDF", "*.pdf"));
        File a = window.showSaveDialog(new Stage());
        if (a != null) {
            try {
                PdfWriter.getInstance(doc, new FileOutputStream(a.getAbsolutePath()));
                doc.open();
                MediasDao dao = new MediasDao();
                List<Medias> medias = dao.getLista(logado);
                for (int x = 0; x < medias.size(); x++) {
                    doc.add(new Paragraph("Data da Leitura: " + medias.get(x).getData()));
                    doc.add(new Paragraph("Dados Iniciais: " + medias.get(x).getRegistro1()));
                    doc.add(new Paragraph("Dados Finais: " + medias.get(x).getRegistro2()));
                    doc.add(new Paragraph("Média em Litros: " + medias.get(x).getMetrocubico()));
                    doc.add(new Paragraph("Média em Reais: " + medias.get(x).getGasto()));
                    doc.add(new Paragraph("\n"));
                }
                doc.close();
                Alert al = new Alert(AlertType.INFORMATION);
                al.setHeaderText("PDF gerado com sucesso e armazenado em: " + a.getAbsolutePath());
                al.show();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(TelaHistoricoController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DocumentException ee) {
                Logger.getLogger(TelaHistoricoController.class.getName()).log(Level.SEVERE, null, ee);
            }
        } else {
            Alert al = new Alert(AlertType.INFORMATION);
            al.setHeaderText("Defina um lugar para salvar o arquivo!");
            al.show();
        }

    }

    public void iniciartabela() {
        try {
            medialitroc.setCellValueFactory(new PropertyValueFactory("regisFinal"));
            mediarealc.setCellValueFactory(new PropertyValueFactory("gasto"));
            dataregc.setCellValueFactory(new PropertyValueFactory("data"));
            dadospc.setCellValueFactory(new PropertyValueFactory("registro1"));
            dadossc.setCellValueFactory(new PropertyValueFactory("registro2"));

            MediasDao dao = new MediasDao();
            OBListHistorico = dao.getLista(getLogado());
            tablehistorico.setItems(OBListHistorico);

        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public void excluir() {
        try {
            if (selecionado != null) {
                MediasDao dao = new MediasDao();
                dao.delete(selecionado);

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
            MAtualizar tela = new MAtualizar(getLogado());
            tela.start(new Stage());
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public void pesquisar() {
        try {
            ObservableList<Medias> hist = FXCollections.observableArrayList();
            for (Medias h : OBListHistorico) {
                if (Date.valueOf(h.getData()).equals(Date.valueOf(pesquisardata.getValue()))) {
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
            MediasDao dao = new MediasDao();
            OBListHistorico = dao.getLista(getLogado());
            tablehistorico.setItems(OBListHistorico);
            Alert a = new Alert(AlertType.CONFIRMATION);
            a.setHeaderText("Tabela Atualizada!");
            a.showAndWait();
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public void excluirtudo() {
        try {
            ObservableList<Medias> hist = FXCollections.observableArrayList();
            for (Medias h : OBListHistorico) {
                MediasDao dao = new MediasDao();
                dao.delete(h);
            }
            Alert a = new Alert(AlertType.INFORMATION);
            a.setHeaderText("Todos os dados foram apagados com sucesso!");
            a.showAndWait();
            atualizar();

        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public void sair() {
        try {
            MHistorico.getStage().close();
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public static Usuario getLogado() {
        return logado;
    }

    public static void setLogado(Usuario aLogado) {
        logado = aLogado;
    }

}
