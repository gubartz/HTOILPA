module br.edu.ifsp.hto.programa01_01_operacoes_basicas {
    requires javafx.controls;
    requires javafx.fxml;

    opens br.edu.ifsp.hto.programa01_01_operacoes_basicas to javafx.fxml;
    exports br.edu.ifsp.hto.programa01_01_operacoes_basicas;
}
