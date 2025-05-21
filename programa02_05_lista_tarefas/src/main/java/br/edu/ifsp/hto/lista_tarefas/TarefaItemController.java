package br.edu.ifsp.hto.lista_tarefas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Label;

public class TarefaItemController implements Initializable {

    @FXML
    private Label lblTitulo;
    @FXML
    private Label lblDescricao;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void setTarefa(Tarefa tarefa) {
        lblTitulo.setText(tarefa.getTitulo());
        lblDescricao.setText(tarefa.getDescricao());
    }

}
