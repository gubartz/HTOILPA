/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.edu.ifsp.hto.listatarefa;

import br.edu.ifsp.hto.listatarefa.model.Tarefa;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class PrimaryController implements Initializable {

    @FXML
    private ListView<Tarefa> lvTarefas;

    private ObservableList<Tarefa> tarefas
            = FXCollections.observableArrayList();

    @FXML
    private TextField txtTituloTarefa;
    @FXML
    private TextField txtDescricaoTarefa;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lvTarefas.setItems(tarefas);
    }

    @FXML
    public void adicionarTarefa() {
        String titulo = txtTituloTarefa.getText();
        String descricao = txtDescricaoTarefa.getText();
        
        Tarefa tarefa = new Tarefa(titulo, descricao);
        tarefas.add(tarefa);
    }

}
