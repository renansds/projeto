package br.faccamp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.exception.ConstraintViolationException;

import br.faccamp.model.Login;
import br.faccamp.oficina.util.DialogUtil;
import br.faccamp.oficina.util.JPAUtil;
import br.faccamp.view.CadastroLogin;
import sun.security.jca.GetInstance.Instance;

public class DaoLogin {
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

	public boolean loginSalvar(String nome, String cpf, String login, String senha) {
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
			e.printStackTrace();
		    em.getTransaction().rollback();
		    System.out.println("Erro no banco de dados : " + e.toString());
		    DialogUtil.mensagem("Erro", e.toString() , e.toString());
		    return false;
		} finally {
			em.close();
		}
			
		if (em != null)
			em = null;
		return true;
	}
}
