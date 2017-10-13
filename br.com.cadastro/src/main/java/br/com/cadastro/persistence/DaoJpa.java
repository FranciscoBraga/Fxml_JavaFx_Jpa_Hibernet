package br.com.cadastro.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.cadastro.dao.DAO;
import br.com.cadastro.util.JpaUtil;

public class DaoJpa<T , I extends Serializable> implements DAO<T,I> {
	
	protected EntityManager manager;
	
	
	public DaoJpa(EntityManager manager){
		this.manager = JpaUtil.getEntityManager();
	}

	public void save(T entity) {
		System.out.println("salvar...");
		this.manager.getTransaction().begin();
		this.manager.merge(entity);
		this.manager.getTransaction().commit();
		this.manager.close();
		
		
		
	}

	public void remove(Class<T> classe, I pk) {
		System.out.println("Excluindo...");
		this.manager.getTransaction().begin();
	 T remover=	 this.getById(classe, pk);
	  this.manager.remove(remover);
	  this.manager.getTransaction().commit();
	  this.manager.close();
	}

	public T getById(Class<T> classe, I pk) {
		try{
			return this.manager.find(classe, pk);
		}catch(Exception exception){
			return null;
		}
		
	}

	public List<T> getAll(Class<T> classe) {
		Query q = this.manager.createQuery("select x from "
				+ classe.getSimpleName() + " x");
				return q.getResultList();	
	}
		
}
