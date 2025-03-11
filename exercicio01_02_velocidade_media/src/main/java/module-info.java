module br.edu.ifsp.hto.exercicio01_velocidade_media {
    requires javafx.controls;
    requires javafx.fxml;

    opens br.edu.ifsp.hto.exercicio01_velocidade_media to javafx.fxml;
    exports br.edu.ifsp.hto.exercicio01_velocidade_media;
}
