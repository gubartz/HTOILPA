/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.edu.ifsp.hto.lista_tarefas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Label;
/**
 * FXML Controller class
 *
 * @author Gustavo
 */
public class TarefaItemController implements Initializable {


    @FXML
    private Label lblTitulo;
    @FXML
    private Label lblDescricao;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void setTarefa(Tarefa tarefa) {
        lblTitulo.setText(tarefa.getTitulo());
        lblDescricao.setText(tarefa.getDescricao());
    }
    
}
