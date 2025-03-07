package br.edu.ifsp.hto.programa01_01_operacoes_basicas;


import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class OperacoesBasicasApp extends Application {
    // 1. Declaração dos campos como atributos da classe
    private TextField txtNum1, txtNum2;
    private Label lblResult;
    

    @Override
    public void start(Stage primaryStage) throws IOException {

        // 2. Uso dos atributos da classe
        txtNum1 = new TextField();
        txtNum2 = new TextField();
        Label lblNum1 = new Label("Número 1: ");
        Label lblNum2 = new Label("Número 2: ");
        lblResult = new Label("Resultado: ");

        Button addButton = new Button("+");
        Button subtractButton = new Button("-");
        Button multiplyButton = new Button("*");
        Button divideButton = new Button("/");
        
        // 3. Uso do método calculate
        addButton.setOnAction((event) -> calculate('+'));
        subtractButton.setOnAction((event) -> calculate('-'));
        multiplyButton.setOnAction((event) -> calculate('*'));
        divideButton.setOnAction((event) -> calculate('/'));

        HBox inputBox = new HBox(10, lblNum1, txtNum1, lblNum2, txtNum2);
        inputBox.setAlignment(Pos.CENTER);

        HBox buttonBox = new HBox(10, addButton, subtractButton, multiplyButton, divideButton);
        buttonBox.setAlignment(Pos.CENTER);

        VBox root = new VBox(10, inputBox, buttonBox, lblResult);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(50));

        Scene scene = new Scene(root, 600, 200);
        primaryStage.setTitle("Operações Básicas");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void calculate(char operation){
 
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

    public static void main(String[] args) {
        launch();
    }

}
