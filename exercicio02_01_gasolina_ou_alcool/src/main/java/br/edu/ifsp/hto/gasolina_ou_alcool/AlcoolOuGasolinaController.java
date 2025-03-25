package br.edu.ifsp.hto.gasolina_ou_alcool;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

public class AlcoolOuGasolinaController {

    @FXML
    private Label lblResultado;

    @FXML
    private TextField txtPrecoAlcool;

    @FXML
    private TextField txtPrecoGasolina;

    @FXML
    public void initialize() {
        txtPrecoAlcool.setTextFormatter(formatarNumeros());
        txtPrecoGasolina.setTextFormatter(formatarNumeros());
    }
    
    private TextFormatter formatarNumeros(){
        
        TextFormatter<String> textFormatter = new TextFormatter<>(change -> {
            if (change.getControlNewText().matches("[0-9]*\\.?[0-9]*")) {
                return change;
            }
            return null;
        });        
        
        return textFormatter;

    }

    @FXML
    private void calcular() {
        if (txtPrecoAlcool.getText().isBlank()|| txtPrecoGasolina.getText().isBlank()) {
            return;
        }

        double dPrecoAlcool = Double.parseDouble(txtPrecoAlcool.getText());
        double dPrecoGasolina = Double.parseDouble(txtPrecoGasolina.getText());

        if (dPrecoAlcool / dPrecoGasolina < 0.7) {
            lblResultado.setText("Álcool");
        } else {
            lblResultado.setText("Gasolina");
        }

    }
}
