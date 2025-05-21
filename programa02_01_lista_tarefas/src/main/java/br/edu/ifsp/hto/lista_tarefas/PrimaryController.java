package br.edu.ifsp.hto.lista_tarefas;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class PrimaryController implements Initializable {

    @FXML
    private TextField txtTarefa;
    // TODO(5) Definir o ListView como <String>, pois trata-se de uma lista rolável
    // de textos.
    @FXML
    private ListView<String> lvTarefas;

    // TODO(6) Definir um ArrayList para manter uma lista de objetos String
    // das tarefas.
    List<String> listaTarefas = new ArrayList<>();

    // TODO(7) Este método é executado quando o controller é inicializado.
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO(8) Para adicionar itens na ArrayList utilizamos  método add.
        listaTarefas.add("Lavar Roupa");
        listaTarefas.add("Estudar");
        listaTarefas.add("Lavar Louça");
        listaTarefas.add("Tirar o Lixo");
        listaTarefas.add("Caminhar");

        // TODO(9) Para adicionar os itens de um ArrayList ao ListView usamos
        // o método getItems e depois addAll.
        lvTarefas.getItems().addAll(listaTarefas);
    }

    private void adicionarTarefa(ActionEvent event) {
        // TODO(10) Caso exista algum texto digitado no campo de descrição da tarefa
        // O valor é inserido na lista.
        if (!txtTarefa.getText().isBlank()) {
            // TODO(11) Primeiro o item é adicionado ao ArrayList e não à ListView.
            listaTarefas.add(txtTarefa.getText().trim());
            // TODO(12) Limpamos a ListView.
            lvTarefas.getItems().clear();
            // TODO(13) Adicionamos novamente a listaTarefa (ArrayList)
            //, que agora está atualizado.
            lvTarefas.getItems().addAll(listaTarefas);
        }
        // TODO(11) Após a inserção limpamos o campo de texto
        txtTarefa.setText("");
    }
}
