package br.edu.ifsp.hto.lista_tarefas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class PrimaryController implements Initializable {
    
    @FXML
    private TextField txtTarefa;

    // TODO(2) Em vez de usar uma lista comum como ArrayList, utilizamos uma
    // ObservableList (por meio de FXCollections.observableArrayList). Isso permite
    // que a ListView monitore automaticamente as alterações na lista — como adições,
    // remoções ou modificações — e se atualize sem a necessidade de limpá-la ou
    // recarregar os itens manualmente.
    private ObservableList<String> tarefas = FXCollections.observableArrayList();
    
    @FXML
    private ListView<String> lvTarefas = new ListView<>();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO(3) Vinculamos a nossa ObservableList (atributo tarefas) no
        // ListView.
        lvTarefas.setItems(tarefas);
    }
    
    private void adicionarTarefa(ActionEvent event) {
        if (!txtTarefa.getText().isBlank()) {
            // TODO(4) Agora, ao adicionar um item na ObservableList, automaticamente,
            // a ListView é atualizada.
            tarefas.add(txtTarefa.getText().trim());
        }
        txtTarefa.setText("");
    }

    // TODO(5) Implementar o método para remoção de uma tarefa.
    @FXML
    private void removerTarefa(ActionEvent event) {
        // TODO(6) O Método getSelectionModel() contém o item selecionado e
        // getSelectedItem() retorna o item selecionado. No caso, é um String
        // contendo a descrição da tarefa.
        String tarefaSelecionada = lvTarefas.getSelectionModel().getSelectedItem();
        // TODO(7) Verificamos se a seleção é válida.
        if (tarefaSelecionada != null) {
            // TODO(8) Fazemos a remoção da tarefa da ObservableList e a ListView
            // é atualizada automaticamente.
            tarefas.remove(tarefaSelecionada);
        }
    }
    
}
