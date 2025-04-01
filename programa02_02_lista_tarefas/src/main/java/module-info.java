module br.edu.ifsp.hto.lista_tarefas {
    requires javafx.controls;
    requires javafx.fxml;

    opens br.edu.ifsp.hto.lista_tarefas to javafx.fxml;
    exports br.edu.ifsp.hto.lista_tarefas;
}
