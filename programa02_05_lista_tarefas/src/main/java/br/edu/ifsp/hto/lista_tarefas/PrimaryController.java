/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.edu.ifsp.hto.lista_tarefas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Gustavo
 */
public class PrimaryController implements Initializable {

    @FXML
    private Button btnAdicionar;
    @FXML
    private Button btnRemover;

    private ObservableList<Tarefa> tarefas = FXCollections.observableArrayList();
    @FXML
    private ListView<Tarefa> listView = new ListView<>(tarefas);
    @FXML
    private TextField txtTituloTarefa;
    @FXML
    private TextField txtDescricaoTarefa;

    private int indiceSelecionado = - 1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listView.setItems(tarefas);

        listView.setOnMouseClicked(event -> {
            if (!listView.getSelectionModel().isEmpty()) {
                int selectedIndex = listView.getSelectionModel().getSelectedIndex();
                Tarefa tarefa = tarefas.get(selectedIndex);
                txtTituloTarefa.setText(tarefa.getTitulo());
                txtDescricaoTarefa.setText(tarefa.getDescricao());
                this.indiceSelecionado = selectedIndex;
            }
        });

        listView.setCellFactory(listview1 -> new ListCell<Tarefa>() {
            private FXMLLoader loader;

            @Override
            protected void updateItem(Tarefa tarefa, boolean empty) {
                super.updateItem(tarefa, empty);

                if (empty || tarefa == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("tarefa_item.fxml"));
                        Parent root = loader.load();
                        TarefaItemController controller = loader.getController();
                        controller.setTarefa(tarefa);
                        setGraphic(root);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }

        });
    }

    @FXML
    private void adicionarItem(ActionEvent event) {
        if (txtTituloTarefa.getText().isEmpty()) {
            return;
        }

        Tarefa tarefa = new Tarefa(txtTituloTarefa.getText(), txtDescricaoTarefa.getText());

        if (this.indiceSelecionado != -1) {
            tarefas.set(indiceSelecionado, tarefa);
            this.indiceSelecionado = -1;
        } else {
            tarefas.add(tarefa);
        }
    }

    @FXML
    private void removerItem(ActionEvent event) {
        int selectedIndex = listView.getSelectionModel().getSelectedIndex();
        if (selectedIndex != -1) {
            tarefas.remove(selectedIndex);
        }
    }

}
