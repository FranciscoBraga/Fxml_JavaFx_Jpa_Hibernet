package br.com.cadastro.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.cadastro.dao.UsuarioDAO;
import br.com.cadastro.model.Usuario;
import br.com.cadastro.persistence.UsuarioDaoJpa;
import br.com.cadastro.util.JpaUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AdicionaController  implements Initializable{
	
	
	@FXML
	private Button btnSalvar;
	@FXML
	private Button btnSair;
	@FXML
	private Label lblNome;
	@FXML
	private Label lblIdade;
	@FXML 
	private Label lblTitulo;
	@FXML
	private TextField txfNome;
	@FXML
	private TextField txfIdade;
	
	private Usuario usuario;

	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	
	public void salvar(ActionEvent event) {
		EntityManager manager = JpaUtil.getEntityManager();
		//EntityTransaction tx = manager.getTransaction();
		//tx.begin();
		UsuarioDAO aDao = new UsuarioDaoJpa(manager);
		this.usuario = new Usuario();
		this.usuario.setNome(txfNome.getText());
		this.usuario.setIdade(Integer.parseInt(txfIdade.getText()));
		aDao.save(usuario);
		//manager.persist(usuario);
		//tx.commit();
		//manager.close();
		
	}
	
	

}
