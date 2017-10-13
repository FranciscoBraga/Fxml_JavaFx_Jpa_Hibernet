package br.com.cadastro.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;

import br.com.cadastro.dao.UsuarioDAO;
import br.com.cadastro.model.Usuario;
import br.com.cadastro.persistence.UsuarioDaoJpa;
import br.com.cadastro.tabela.UsuarioTabela;
import br.com.cadastro.util.JpaUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ListaController implements Initializable{

	public void initialize(URL location, ResourceBundle resources) {
		ListarUsuario();
	}
	
	@FXML
	private Label lblTitulo = new Label();
	@FXML
	private Button btnSalvar = new Button();
	@FXML
	private Button btnEditar = new Button();
	@FXML
	private Button btnCancelar = new Button();
	@FXML
	private Button btnSair = new Button();
	@FXML
	private TableView<UsuarioTabela> tbTabela;
	@FXML
	private TableColumn<UsuarioTabela, String> tcNome;
	@FXML
	private TableColumn<UsuarioTabela, Integer> tcIdade;
	@FXML
	private TextField txfNome = new  TextField();
	@FXML
	private TextField txfIdade = new TextField();
	
	
	private Usuario usuario;
	
	private List<Usuario> usuarioLista;
	
	//para colocar os dados na table
	private ObservableList<UsuarioTabela> listUsuarioTabela= FXCollections.observableArrayList();
	
	public void ListarUsuario() {
	
		if(!listUsuarioTabela.isEmpty()) {
			listUsuarioTabela.clear();
			System.out.println("Limpou Tabela");
		}
		
		EntityManager manager = JpaUtil.getEntityManager();
		UsuarioDAO aDao = new UsuarioDaoJpa(manager);
		this.usuario = new Usuario();
		usuarioLista =aDao.getAll(Usuario.class);
		
	
		
		for (Usuario listaDeUsuario : usuarioLista) {
			
			UsuarioTabela usuarioTabela =  new UsuarioTabela(listaDeUsuario.getId(), listaDeUsuario.getNome(), listaDeUsuario.getIdade());
 			listUsuarioTabela.add(usuarioTabela);
		}
		
		tcNome.setCellValueFactory(new PropertyValueFactory<UsuarioTabela, String>("nome"));
		tcIdade.setCellValueFactory(new PropertyValueFactory<UsuarioTabela, Integer>("idade") );
		
		tbTabela.setItems(listUsuarioTabela);
		
	}
	
	@FXML
	public void salvar(ActionEvent event) {
	
		
	}
	
	public void editar(ActionEvent event) {
		EntityManager manager = JpaUtil.getEntityManager();
		UsuarioDAO aDao = new UsuarioDaoJpa(manager);
		UsuarioTabela usuarioTabelaUpdate = tbTabela.getSelectionModel().getSelectedItem();
		this.usuario = new Usuario();
		int id = usuarioTabelaUpdate.getId();
		String nome = txfNome.getText();
		int idade = Integer.parseInt(txfIdade.getText());
		usuario = aDao.getById(Usuario.class, id);
		usuario.setNome(nome);
		usuario.setIdade(idade);
		 aDao.save(usuario);
		 ListarUsuario();
		
	}
	
	public void cancelar(ActionEvent event) {
		
	}
	
	public void sair (ActionEvent event) {
		
		try {
			Parent cadastro = FXMLLoader.load(getClass().getResource("/fxml/inicial.fxml"));
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
	
	@FXML
	public void excluir (ActionEvent event) {
		EntityManager manager = JpaUtil.getEntityManager();
		UsuarioDAO aDao = new UsuarioDaoJpa(manager);
		this.usuario = new Usuario();
		UsuarioTabela usuarioTabela = tbTabela.getSelectionModel().getSelectedItem();
		Integer id = usuarioTabela.getId();
		 aDao.remove(Usuario.class, id);
		 ListarUsuario();
		
	}
	
	
	
	

}
