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

public class PrimaryController implements Initializable {

    private ObservableList<Tarefa> tarefas = FXCollections.observableArrayList();
    @FXML
    private ListView<Tarefa> lvTarefas = new ListView<>();
    @FXML
    private TextField txtTituloTarefa;
    @FXML
    private TextField txtDescricaoTarefa;

    // TODO(2) Adicionar um atributo para manter o índice que está em edição.
    // Usamos -1 para indicar que nenhum item da lista está sendo editado.
    private int indiceEmEdicao = - 1;

    // TODO(3) Adicionar a referência oa botão.
    @FXML
    private Button btnAdicionar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lvTarefas.setItems(tarefas);

        // TODO(4) Ao clicar em um item da lista, queremos colocar os valores do
        // item clicado nos campos de texto para edição.
        lvTarefas.setOnMouseClicked(event -> {
            // TODO(5) Verificar se é um clique duplo.
            if (event.getClickCount() == 2) {
                // TODO(6) Verificar se de fato há um item selecionado. 
                if (!lvTarefas.getSelectionModel().isEmpty()) {
                    // TODO(7) Recuperar o item selecionado da lista.
                    int indiceSelecionado = lvTarefas.getSelectionModel().getSelectedIndex();
                    // TODO(8) Recuperar a Tarefa da ObservableList com base no
                    // índice do item selecionado. O método get recebe o índice
                    // e retorna o objeto correspondente.
                    Tarefa tarefa = tarefas.get(indiceSelecionado);
                    // TODO(9) Preencher os campos de TextField da tela com
                    // os valores recuperados do objeto Tarefa correspondente.
                    txtTituloTarefa.setText(tarefa.getTitulo());
                    txtDescricaoTarefa.setText(tarefa.getDescricao());
                    // TODO(10) Armazenamos qual item da lista está em edição.
                    // Necessário para quando formos fazer a atualização.
                    this.indiceEmEdicao = indiceSelecionado;
                    // TODO(11) Trocar o texto do botão de Adicionar para Editar.
                    btnAdicionar.setText("Editar Tarefa");
                }
            }
        });

        lvTarefas.setCellFactory(listview1 -> new ListCell<Tarefa>() {

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
    private void adicionarTarefa(ActionEvent event) {
        if (txtTituloTarefa.getText().isBlank()) {
            return;
        }

        Tarefa tarefa = new Tarefa(txtTituloTarefa.getText(), txtDescricaoTarefa.getText());

        // TODO(12) Caso exista um item em edição. Ou seja, o valor seja
        // diferente de -1 a atualização deve ser feita ao invés da inclusão.
        if (this.indiceEmEdicao != -1) {
            // TODO(13) Atualizar a lista substituindo a Tarefa no índice do
            // item que está sendo editado. O  método set, que recebe o índice
            // como primeiro argumento e o novo objeto como segundo.
            tarefas.set(indiceEmEdicao, tarefa);
            // TODO(14) Voltar o indiceEmEdicao para -1, indicando que agora não
            // há mais item em edição.
            this.indiceEmEdicao = -1;
            // TODO(15) Voltar o texto para Adicionar Tarefa após a edição.
            btnAdicionar.setText("Adicionar Tarefa");
        } else {
            // TODO(16) Caso não seja uma edição a tarefa é adicionada.
            tarefas.add(tarefa);
        }

        txtDescricaoTarefa.setText("");
        txtTituloTarefa.setText("");
    }

    @FXML
    private void removerTarefa(ActionEvent event) {
        // TODO(17) Recuperar o índice do elemento selecionado
        int indiceSelecionado = lvTarefas.getSelectionModel().getSelectedIndex();
        // TODO(18) Verificar se é um item válido da ListView
        if (indiceSelecionado != -1) {
            // TODO(19) Remover o item da lista
            tarefas.remove(indiceSelecionado);
            // TODO(20) O usuário pode clicar em editar e depois remover. Então
            // fazemos esse reset no índice também.
            this.indiceEmEdicao = -1;
        }
    }

}
