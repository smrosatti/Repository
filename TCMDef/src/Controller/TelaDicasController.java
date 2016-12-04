/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Main.MDicas;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author SARA
 */
public class TelaDicasController implements Initializable {
    
    @FXML
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
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        list();
    }    
    
}
