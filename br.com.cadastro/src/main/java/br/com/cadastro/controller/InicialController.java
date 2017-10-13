package br.com.cadastro.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class InicialController implements Initializable{

	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	@FXML
	Button btnAdicionar = new Button();
	@FXML
	Button btnListar = new Button();
	@FXML
	Button btnSair= new Button();
	@FXML
	Label lblTitulo = new Label();
	
	
	public void adicionar(ActionEvent event) {
		
		try {
			Parent cadastro = FXMLLoader.load(getClass().getResource("/fxml/adiciona.fxml"));
			Scene  cadastroCena = new Scene(cadastro);
			Stage cadastroTela = (Stage)((Node) event.getSource()).getScene().getWindow();
			cadastroTela.setScene(cadastroCena);
			cadastroTela.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
		}
		
	}
	
	
	public void listar(ActionEvent event) {
		try {
			Parent listaCadastro = FXMLLoader.load(getClass().getResource("/fxml/lista.fxml"));
			Scene  listaCadastroCena = new Scene(listaCadastro);
			Stage  listaCadastroTela = (Stage)((Node) event.getSource()).getScene().getWindow();
			listaCadastroTela.setScene(listaCadastroCena);
			listaCadastroTela.show();
		}catch(IOException e) {
			e.printStackTrace();
			e.getMessage();
		}
	}
	
   public void sair(ActionEvent event) {
	  
   }
}
