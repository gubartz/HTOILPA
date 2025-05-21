package br.edu.ifsp.hto.lista_tarefas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Label;

// TODO(5) Definir um controller para o tarefa_item.fxml
public class TarefaItemController implements Initializable {

    @FXML
    private Label lblTitulo;
    @FXML
    private Label lblDescricao;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    // TODO(6) Quando um item da ListView for ser criado chamamos este método
    // passando uma Tarefa e utilizar o valor correspondente para preencher os
    // itens definimos no tarefa_item.fxml.
    public void setTarefa(Tarefa tarefa) {
        lblTitulo.setText(tarefa.getTitulo());
        lblDescricao.setText(tarefa.getDescricao());
    }

}
