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

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class PrimaryController implements Initializable {

    private TextField txtTarefa;

    private ObservableList<Tarefa> tarefas = FXCollections.observableArrayList();

    @FXML
    private TextField txtTituloTarefa;
    @FXML
    private TextField txtDescricaoTarefa;
    @FXML
    private ListView<Tarefa> lvTarefas;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lvTarefas.setItems(tarefas);

        // TODO(7) Este método é utilizado para personalizar/customizar cada
        // célula da ListView. Agora iremos utilizar um layout próprio, definido
        // no arquivo tarefa_item.fxml e precisamos definir como a célula é visualmente
        // criada.
        // Este método deve receber a implementação de uma ListCell. O generics
        // deve ser Tarefa, pois a ListView é para objetos Tarefa. Portanto,
        // ListCell<Tarefa>
        lvTarefas.setCellFactory(listview1 -> new ListCell<Tarefa>() {

            // TODO(8) Este método deve ser sobrescrito com a implementação que
            // para dar o layout que desejamos para um item da célula.
            @Override
            protected void updateItem(Tarefa tarefa, boolean empty) {
                // TODO(9) Chamar o updateItem da classe pai para garantir que
                // os demais comportamentos da ListCell sejam ativados e o
                // funcionamento seja correto.
                super.updateItem(tarefa, empty);

                // TODO(10) Verifica se a célula está vazia ou sem dados (null).
                if (empty || tarefa == null) {
                    // TODO(11) Caso a célual esteja vazia, limpa qualquer texto
                    // ou conteúdo gráfico da célula.
                    setText(null);
                    setGraphic(null);
                } else {
                    try {
                        // TODO(12) Carregar o layout da célula a partir do
                        // arquivo FXML.
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("tarefa_item.fxml"));
                        // TODO(13) Constrói a árvore de nós do FXML (interface
                        // da célula).
                        Parent root = loader.load();
                        // TODO(14) Obter o controller (TarefaItemController)
                        // associado ao FXML para configurar os dados da tarefa.
                        TarefaItemController controller = loader.getController();
                        // TODO(15) Chama o método do controller para exibir os
                        // dados do objeto Tarefa, correspondente a um item da
                        // lista, no layout.
                        controller.setTarefa(tarefa);
                        // TODO(16) Define o conteúdo visual da célula da
                        // ListView usando o layout carregado.
                        setGraphic(root);
                    } catch (IOException e) {
                        // TODO(17) Como o FXMLLoader acessa um arquivo, caso
                        // ele não exista uma IOException é lançada. Por isso,
                        // precisamos tratá-la.
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @FXML
    private void adicionarTarefa(ActionEvent event) {
        if (!txtTituloTarefa.getText().isBlank()) {
            // TODO(18) Fazer a adição em apenas uma instrução.
            tarefas.add(new Tarefa(txtTituloTarefa.getText(), txtDescricaoTarefa.getText()));
        }

        txtTituloTarefa.setText("");
    }

    @FXML
    private void removerTarefa(ActionEvent event) {
        // TODO(19) Este método não será implementado neste programa.
    }

}
