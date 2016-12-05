/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.MediasDao;
import Main.MEconomia;
import Model.Medias;
import Model.Usuario;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import static javafx.beans.binding.Bindings.or;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.input.MouseEvent;

public class TelaEconomiaController implements Initializable {

    private static Usuario logado;

    @FXML
    private PieChart grafico;

    @FXML
    private Button btvoltar;

    private int janeiro = 0, fevereiro = 0, marco = 0, abril = 0,
            maio = 0, junho = 0, julho = 0, agosto = 0, setembro = 0,
            outubro = 0, novembro = 0, dezembro = 0;

    public static Usuario getLogado() {
        return logado;
    }

    public static void setLogado(Usuario aLogado) {
        logado = aLogado;
    }

    public void calculo() {
        MediasDao dao = new MediasDao();
        List<Medias> medias = new ArrayList<Medias>(dao.getLista(logado));
        for (int x = 0; x < medias.size(); x++) {
            if (medias.get(x).getData().getMonthValue() == 1) {
                janeiro = janeiro + 1;
            }
            if (medias.get(x).getData().getMonthValue() == 2) {
                fevereiro = fevereiro + 1;
            }
            if (medias.get(x).getData().getMonthValue() == 3) {
                marco = marco + 1;
            }
            if (medias.get(x).getData().getMonthValue() == 4) {
                abril = abril + 1;
            }
            if (medias.get(x).getData().getMonthValue() == 5) {
                maio = maio + 1;
            }
            if (medias.get(x).getData().getMonthValue() == 6) {
                junho = junho + 1;
            }
            if (medias.get(x).getData().getMonthValue() == 7) {
                julho = julho + 1;
            }
            if (medias.get(x).getData().getMonthValue() == 8) {
                agosto = agosto + 1;
            }
            if (medias.get(x).getData().getMonthValue() == 9) {
                setembro = setembro + 1;
            }
            if (medias.get(x).getData().getMonthValue() == 10) {
                outubro = outubro + 1;
            }
            if (medias.get(x).getData().getMonthValue() == 11) {
                novembro = novembro + 1;
            }
            if (medias.get(x).getData().getMonthValue() == 12) {
                dezembro = dezembro + 1;
            }
        }
    }

    public void iniciargrafico() {
        try {
            grafico.getData().addAll(new PieChart.Data("Janeiro", janeiro),
                    new PieChart.Data("Fevereiro", fevereiro),
                    new PieChart.Data("Março", marco),
                    new PieChart.Data("Abril", abril),
                    new PieChart.Data("Maio", maio),
                    new PieChart.Data("Junho", junho),
                    new PieChart.Data("Julho", julho),
                    new PieChart.Data("Agosto", agosto),
                    new PieChart.Data("Setembro", setembro),
                    new PieChart.Data("Outubro", outubro),
                    new PieChart.Data("Novembro", novembro),
                    new PieChart.Data("Dezembro", dezembro));
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public void voltar() {
        try {
            MEconomia.getStage().close();
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        calculo();
        iniciargrafico();

        btvoltar.setOnMouseClicked((MouseEvent evt) -> {
            voltar();
        });
    }

}
