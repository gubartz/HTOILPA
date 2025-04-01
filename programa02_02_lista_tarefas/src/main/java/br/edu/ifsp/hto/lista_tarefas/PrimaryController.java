package br.edu.ifsp.hto.lista_tarefas;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private Button btnRemover;    
    
    private ObservableList<String> tarefas = FXCollections.observableArrayList();
    
    @FXML
    private ListView<String> listView = new ListView<>(tarefas);    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listView.setItems(tarefas);
    }

    public void adicionarItem() {
        if (!txtTarefa.getText().isEmpty()) {
            tarefas.add(txtTarefa.getText().trim());
        }
    }
    
    public void removeTask() {
        String selectedTask = listView.getSelectionModel().getSelectedItem();
        if (selectedTask != null) {
            tarefas.remove(selectedTask);
        }
    }    

}
