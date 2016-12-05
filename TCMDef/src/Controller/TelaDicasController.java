/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.TelaHistoricoController.getLogado;
import Dao.DicasDao;
import Dao.MediasDao;
import Main.MAlterarDicas;
import Main.MCadastrarDicas;
import Main.MDicas;
import Model.Dicas;
import Model.Usuario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
public class TelaDicasController implements Initializable {

    public static Usuario getLogado() {
        return logado;
    }

    public static void setLogado(Usuario aLogado) {
        logado = aLogado;
    }

    /* @FXML
    private ListView listv1;
    
    public void list() {
        String a = "No Banho: Se molhe, feche o chuveiro, se ensaboe e depois abra para enxaguar. Não fique com o chuveiro\n" +
" aberto. O consumo cairá de 180 para 48 litros.";
        String b = "Ao escovar os dentes: escove os dentes e enxágüe a boca com a água do copo. Economize 3 litros de água.";
        String c = "Na descarga: Verifique se a válvula não está com defeito, aperte-a uma única vez e não jogue lixo e restos \n" +
" de comida no vaso sanitário.";
        String d = "Na torneira: Uma torneira aberta gasta de 12 a 20 litros/minuto. Pingando, 46 litros/dia. Isto significa, 1.380 \n" +
" litros por mês. Feche bem as torneiras.";
        String e = "Vazamentos: Um buraco de 2 milímetros no encanamento desperdiça cerca de 3 caixas d’água de mil litros.";
        String f = "Na caixa d’água: Não a deixe transbordar e mantenha-a tampada.";
        String g = "Na lavagem de louças: Lavar louças com a torneira aberta, o tempo todo, desperdiça até 105 litros. Ensaboe \n" +
" a louça com a torneira fechada e depois enxágüe tudo de uma vez. Na máquina de lavar são gastos 40 litros. \n" +
" Utilize-a somente quando estiver cheia.";
        String h = "Regar jardins e plantas: No inverno, a rega pode ser feita dia sim, dia não, pela manhã ou à noite. Use man-\n" +
" gueira com esguicho-revólver ou regador.";
        String i = "Lavar carro: com uma mangueira gasta 600 litros de água. Só lave o carro uma vez por mês, com balde de\n" +
" 10 litros, para ensaboar e enxaguar. Para isso, use a água da sobra da máquina de lavar louça.";
        String j = "Na limpeza de quintal e calçadas use vassoura: Se precisar utilize a água que sai do enxágüe da máquina \n" +
" de lavar.";
        
        ObservableList<String> obs = FXCollections.observableArrayList(a," ",b," ",c," ",d," ",e," ",f," ",g," ",h," ",i," ",j);
        listv1.setItems(obs);
    }
    
    @FXML
    void voltar(){
        MDicas.getStage().close();
    }*/
    @FXML
    private Button btalterar;

    @FXML
    private TableView<Dicas> tabledicas;

    @FXML
    private TableColumn<String, Dicas> descricaoc;

    @FXML
    private Button btcadastrar;
    
    @FXML
    private Button btatualizartable;

    @FXML
    private TableColumn<Integer, Dicas> idc;

    @FXML
    private Button btsair;

    @FXML
    private Button btdeletar;

    private static Usuario logado;

    private Dicas selecionado;

    private ObservableList OBListDicas;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        inicializartable();

        tabledicas.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                selecionado = (Dicas) newValue;
            }
        });
        
        btalterar.setOnMouseClicked((MouseEvent evt)->{
            alterar();
        });
        
        btdeletar.setOnMouseClicked((MouseEvent evt)->{
            deletar();
        });
        
        btsair.setOnMouseClicked((MouseEvent evt)->{
            sair();
        });
        
        btcadastrar.setOnMouseClicked((MouseEvent evt)->{
            cadastrar();
        });
        
        btatualizartable.setOnMouseClicked((MouseEvent evt)->{
            atualizar();
        });
    }
    
    public void atualizar(){
        try{
            DicasDao dao = new DicasDao();
            OBListDicas= dao.getLista(getLogado());
            tabledicas.setItems(OBListDicas);
            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setHeaderText("Tabela Atualizada!");
            a.showAndWait();          
        }catch(Exception ee){
            ee.printStackTrace();
        }
    }

    public void inicializartable() {
        try {
            descricaoc.setCellValueFactory(new PropertyValueFactory("texto"));
            idc.setCellValueFactory(new PropertyValueFactory("id_dica"));

            DicasDao dao = new DicasDao();
            OBListDicas = dao.getLista(getLogado());
            tabledicas.setItems(OBListDicas);

        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public void alterar() {
        try {

            if (selecionado != null) {
                MAlterarDicas tela = new MAlterarDicas(selecionado);
                tela.start(new Stage());
            } else {
                Alert al = new Alert(Alert.AlertType.INFORMATION);
                al.setHeaderText("Selecione uma dica!");
                al.show();
            }
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public void cadastrar() {
        try{
            MCadastrarDicas tela = new MCadastrarDicas(logado);
            tela.start(new Stage());
        }catch(Exception ee){
            ee.printStackTrace();
        }

    }
    
    public void deletar(){
        try{
         if (selecionado != null) {
                DicasDao dao = new DicasDao();
                dao.delete(selecionado);
            } else {
                Alert al = new Alert(Alert.AlertType.INFORMATION);
                al.setHeaderText("Selecione uma dica!");
                al.show();
            }
        }catch(Exception ee){
            ee.printStackTrace();
        }
    }
    
    public void sair(){
        try{
            MDicas.getStage().close();
        }catch(Exception ee){
            ee.printStackTrace();
        }
    }

}
