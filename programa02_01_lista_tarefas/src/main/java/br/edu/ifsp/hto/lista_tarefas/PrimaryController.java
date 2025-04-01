package br.edu.ifsp.hto.lista_tarefas;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Gustavo
 */
public class PrimaryController implements Initializable {

    @FXML
    private TextField txtTarefa;
    @FXML
    private Button btnAdicionar;
    @FXML
    private ListView<String> listView;

    ArrayList<String> listaTarefas = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaTarefas.add("Lavar Roupa");
        listaTarefas.add("Estudar");
        listaTarefas.add("Lavar Louça");
        listaTarefas.add("Tirar o Lixo");
        listaTarefas.add("Caminhar");

        listView.getItems().addAll(listaTarefas);
    }

    public void adicionarItem() {
        if (!txtTarefa.getText().isEmpty()) {
            listaTarefas.add(txtTarefa.getText().trim());
            listView.getItems().clear();
            listView.getItems().addAll(listaTarefas);
        }
    }

}
