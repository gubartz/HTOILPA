module br.edu.ifsp.hto.gasolina_ou_alcool {
    requires javafx.controls;
    requires javafx.fxml;

    opens br.edu.ifsp.hto.gasolina_ou_alcool to javafx.fxml;
    exports br.edu.ifsp.hto.gasolina_ou_alcool;
}
