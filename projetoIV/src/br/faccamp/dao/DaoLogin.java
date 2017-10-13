package br.faccamp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.exception.ConstraintViolationException;

import br.faccamp.model.Login;
import br.faccamp.oficina.util.DialogUtil;
import br.faccamp.oficina.util.JPAUtil;
import br.faccamp.view.CadastroLogin;
import sun.security.jca.GetInstance.Instance;

public class DaoLogin implements DaoFactory {
	EntityManager em = null;

	public boolean loginUser(String nome, String senha) {
		em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		String jpql = "select p from Login p ";
		// PASSANDO PARAMETRO ABAIXO E USANDO A JPQL CRIADO OU SEJA A CONSULTA.
		Query query = em.createQuery(jpql);
		List<Login> resultados = query.getResultList();

		for (Login login : resultados) {
			if (login.getNome().equals(nome) && login.getSenha().equals(senha))
				return true;
		}
		return false;
	}
	@Override
	public boolean insert(String nome, String cpf, String login, String senha) {
		if (em == null) {
			em = new JPAUtil().getEntityManager();
		}
		Login func = new Login();
		
		func.setNome(nome);
		func.setCpf(cpf);
		func.setLogin(login);
		func.setSenha(senha);
	
		// Fazendo commit
		try {
			em.getTransaction().begin();
			em.persist(func);					
			em.getTransaction().commit();
		} catch (Exception e) {							
		    em.getTransaction().rollback();
		    System.err.println("Erro no banco de dados : " + e.toString());
		    DialogUtil.mensagem("Cadastro Funcionário", "Erro ao inserir registro , " + nome + " " , e.toString() +"\n");
		    return false;
		} finally {
			em.close();
		}
			
		if (em != null)
			em = null;
		return true;
	}

	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean save() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean insert() {
		// TODO Auto-generated method stub
		return false;
	}
}
