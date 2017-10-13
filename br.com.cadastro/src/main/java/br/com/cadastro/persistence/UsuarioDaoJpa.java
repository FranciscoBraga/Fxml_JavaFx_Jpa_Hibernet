package br.com.cadastro.persistence;



import javax.persistence.EntityManager;

import br.com.cadastro.dao.UsuarioDAO;
import br.com.cadastro.model.Usuario;

public class UsuarioDaoJpa extends DaoJpa<Usuario,Integer> implements UsuarioDAO{

	public UsuarioDaoJpa(EntityManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}



	



}
