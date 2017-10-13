package br.com.cadastro.dao;

import java.io.Serializable;
import java.util.List;



public interface DAO<T,I extends Serializable >  {
	 void save(T entity);
	 void remove(Class<T> classe, I pk);
	 T getById(Class<T> classe, I pk);
	 List<T> getAll(Class<T> classe);




		
	}
