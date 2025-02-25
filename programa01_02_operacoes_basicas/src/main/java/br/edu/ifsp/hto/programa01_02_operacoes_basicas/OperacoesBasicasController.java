package br.edu.ifsp.hto.programa01_02_operacoes_basicas;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class OperacoesBasicasController {
    
    @FXML
    private TextField txtNum1;

    @FXML
    private TextField txtNum2;

    @FXML
    private Label lblResult;


    @FXML
    private void calculate(char operation) {
        try{
            double num1 = Double.parseDouble(txtNum1.getText());
            double num2 = Double.parseDouble(txtNum2.getText());
            double result = 0;                   
            switch(operation){
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/': 
                    if (num2 == 0) {
                        throw new ArithmeticException("Divisão por zero não permitida!");
                    }
                    result = num1 / num2;
            }
            lblResult.setText("Resultado: " + result);
        }
        catch (NumberFormatException e) {
            lblResult.setText("Entrada inválida!");
        }        
        catch (ArithmeticException e) {
            lblResult.setText(e.getMessage());
        }               
    }
    
    @FXML
    private void calculateAdd() {
        calculate('+');
    }

    @FXML
    private void calculateSubtract() {
        calculate('-');
    }

    @FXML
    private void calculateMultiply() {
        calculate('*');
    }

    @FXML
    private void calculateDivide() {
        calculate('/');
    }    
}
