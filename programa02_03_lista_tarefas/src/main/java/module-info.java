module br.edu.ifsp.hto.listatarefa {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens br.edu.ifsp.hto.listatarefa to javafx.fxml;
    exports br.edu.ifsp.hto.listatarefa;
}
