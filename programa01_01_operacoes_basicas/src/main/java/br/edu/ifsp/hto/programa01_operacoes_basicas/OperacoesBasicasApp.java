package br.edu.ifsp.hto.programa01_operacoes_basicas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * JavaFX App
 */
public class OperacoesBasicasApp extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        // 1. Definição da tela

        // 2. Campos de entrada e um rótulo para o resultado
        TextField txtNum1 = new TextField();
        TextField txtNum2 = new TextField();
        Label lblNum1 = new Label("Número 1: ");
        Label lblNum2 = new Label("Número 2: ");
        Label lblResult = new Label("Resultado: ");

        // 3. Botões para as operações básicas
        Button btnAdd = new Button("+");
        Button btnSubtract = new Button("-");
        Button btnMultiply = new Button("*");
        Button btnDivide = new Button("/");
        
        // 4. Definição do código executado nos botões definidos no passo 2        
        // Expressão lambda: ao invés de implementar uma classe com a ação,
        // podemos definir o código que será executado diretamente como 
        // argumento da função.
        
        // Soma
        btnAdd.setOnAction((event) -> {
            // Campo de texto é necessário converter
            double num1 = Double.parseDouble(txtNum1.getText());
            double num2 = Double.parseDouble(txtNum2.getText());
            
            double result = num1 + num2;
            lblResult.setText("Resultado: " + String.valueOf(result));
        });
        
        // Subtração
        btnSubtract.setOnAction((event) -> {
            // Campo de texto é necessário converter
            double num1 = Double.parseDouble(txtNum1.getText());
            double num2 = Double.parseDouble(txtNum2.getText());
            
            double result = num1 - num2;
            lblResult.setText("Resultado: " + String.valueOf(result));
        });
        
        // Multiplicação
        btnMultiply.setOnAction((event) -> {
            // Campo de texto é necessário converter
            double num1 = Double.parseDouble(txtNum1.getText());
            double num2 = Double.parseDouble(txtNum2.getText());
            
            double result = num1 * num2;
            lblResult.setText("Resultado: " + String.valueOf(result));
        });
        
        // Divisão
        btnDivide.setOnAction((event) -> {
            // Campo de texto é necessário converter
            double num1 = Double.parseDouble(txtNum1.getText());
            double num2 = Double.parseDouble(txtNum2.getText());
            
            double result = num1 / num2;
            lblResult.setText("Resultado: " + String.valueOf(result));
        });         

        // 5. Container horizontal para os campos de entrada
        HBox inputBox = new HBox(10, lblNum1, txtNum1, lblNum2, txtNum2);
        inputBox.setAlignment(Pos.CENTER);

        // 6. Container horizontal para os botões das operações
        HBox buttonBox = new HBox(10, btnAdd, btnSubtract, btnMultiply, btnDivide);
        buttonBox.setAlignment(Pos.CENTER);

        // 7. Container vertical para os containers definidos nos passos 6 e 7
        // e para o campo de resultado definido no passo 2
        VBox root = new VBox(10, inputBox, buttonBox, lblResult);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(50));

        // 8. Definição do conteúdo da interface gráfica
        // o elemento que será mostrado é o item definido no passo 7
        Scene scene = new Scene(root, 600, 200); // Os últimos dois parâmetros definem o cumprimento e a altura, respectivamente
        primaryStage.setTitle("Operações Básicas");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}