package br.com.cadastro.tabela;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class UsuarioTabela {
	
	
	private final SimpleIntegerProperty id;
	private final SimpleStringProperty nome;
	private final SimpleIntegerProperty idade;
	
	
	public UsuarioTabela(int id,String nome, int idade ) {
		super();
		this.id= new SimpleIntegerProperty(id);
		this.nome = new SimpleStringProperty(nome);
		this.idade = new SimpleIntegerProperty(idade);
	}

	public int getId() {
		
		return id.get();
	}
	
	public String getNome() {
		return nome.get();
	}
	
	public int getIdade() {
		return idade.get();
	}
}
