package br.edu.ifsp.hto.exercicio01_velocidade_media;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class VelocidadeMediaController {
    @FXML
    private TextField txtDeslocamento;

    @FXML
    private TextField txtTempo;

    @FXML
    private Label lblResultado;
    
    @FXML
    private void calcularVelocidadeMedia() {
        double dDeslocamento, dTempo, velociadeMedia;
        
        dDeslocamento = Double.parseDouble(txtDeslocamento.getText());
        dTempo = Double.parseDouble(txtTempo.getText());
        
        velociadeMedia = dDeslocamento / dTempo;
        
        lblResultado.setText("A velocidade média é: " + String.valueOf(velociadeMedia));
        
    }


}
