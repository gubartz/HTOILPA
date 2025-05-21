package br.edu.ifsp.hto.listatarefa;

import br.edu.ifsp.hto.listatarefa.model.Tarefa;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class PrimaryController implements Initializable {

    // TODO(10) Definir o generics para Tarefa, pois agora o ListView será para
    // objetos Tarefa e não mais String.
    @FXML
    private ListView<Tarefa> lvTarefas;

    // TODO(11) Definir o generics para Tarefa, pois agora a ObservableList será
    // paraobjetos Tarefa e não mais String.    
    private ObservableList<Tarefa> tarefas = FXCollections.observableArrayList();

    @FXML
    private TextField txtTituloTarefa;
    @FXML
    private TextField txtDescricaoTarefa;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lvTarefas.setItems(tarefas);
    }

    @FXML
    private void adicionarTarefa(ActionEvent event) {
        // TODO(11) Caso o título da tarefa esteja vazio então executamos o
        // return e o método para sua execução. Vamos permitir que a descrição
        // da Tarefa seja nula.
        if (txtTituloTarefa.getText().isBlank()) {
            return;
        }

        // TODO(12) Recuperar os valores digitados nos campos.
        String titulo = txtTituloTarefa.getText();
        String descricao = txtDescricaoTarefa.getText();

        // TODO(13) Criar/Instanciar um objeto Tarefa com os valores digitados
        // no campo.
        Tarefa tarefa = new Tarefa(titulo, descricao);
        // TODO(14) Adicionar a tarefa à ObservableList
        tarefas.add(tarefa);

        txtTituloTarefa.setText("");
        txtDescricaoTarefa.setText("");
    }

}
